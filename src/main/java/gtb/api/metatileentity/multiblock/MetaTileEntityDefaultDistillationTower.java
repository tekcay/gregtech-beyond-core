package gtb.api.metatileentity.multiblock;

import static gregtech.api.util.RelativeDirection.*;

import java.util.List;
import java.util.function.Function;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.IDistillationTower;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.DistillationTowerLogicHandler;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTTransferUtils;
import gregtech.api.util.GTUtility;
import gregtech.api.util.RelativeDirection;
import gregtech.api.util.TextComponentUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.core.sound.GTSoundEvents;

/**
 * Code from {@link gregtech.common.metatileentities.multi.electric.MetaTileEntityDistillationTower}
 */
public abstract class MetaTileEntityDefaultDistillationTower extends RecipeMapMultiblockController
                                                             implements IDistillationTower {

    protected DistillationTowerLogicHandler handler;

    protected MetaTileEntityDefaultDistillationTower(ResourceLocation metaTileEntityId, RecipeMap recipeMap) {
        super(metaTileEntityId, recipeMap);
        this.recipeMapWorkable = new DistillationTowerRecipeLogic(this);
        this.handler = new DistillationTowerLogicHandler(this);
    }

    /**
     * Used if MultiblockPart Abilities need to be sorted a certain way, like
     * Distillation Tower and Assembly Line. <br>
     * <br>
     * There will be <i>consequences</i> if this is changed. Make sure to set the logic handler to one with
     * a properly overriden {@link DistillationTowerLogicHandler#determineOrderedFluidOutputs()}
     */
    @Override
    protected Function<BlockPos, Integer> multiblockPartSorter() {
        return RelativeDirection.UP.getSorter(getFrontFacing(), getUpwardsFacing(), isFlipped());
    }

    /**
     * Whether this multi can be rotated or face upwards. <br>
     * <br>
     * There will be <i>consequences</i> if this returns true. Make sure to set the logic handler to one with
     * a properly overriden {@link DistillationTowerLogicHandler#determineOrderedFluidOutputs()}
     */
    @Override
    public boolean allowsExtendedFacing() {
        return false;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            FluidStack stackInTank = importFluids.drain(Integer.MAX_VALUE, false);
            if (stackInTank != null && stackInTank.amount > 0) {
                ITextComponent fluidName = TextComponentUtil.setColor(GTUtility.getFluidTranslation(stackInTank),
                        TextFormatting.AQUA);
                textList.add(TextComponentUtil.translationWithColor(
                        TextFormatting.GRAY,
                        "gregtech.multiblock.distillation_tower.distilling_fluid",
                        fluidName));
            }
        }
        super.addDisplayText(textList);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        if (this.handler == null || this.structurePattern == null) return;
        handler.determineLayerCount(this.structurePattern);
        handler.determineOrderedFluidOutputs();
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        if (this.handler != null) handler.invalidate();
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RIGHT, FRONT, UP)
                .aisle("YSY", "YYY", "YYY")
                .aisle("XXX", "X#X", "XXX").setRepeatable(1, 11)
                .aisle("XXX", "XXX", "XXX")
                .where('S', selfPredicate())
                .where('Y', states(getCasingState())
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMaxGlobalLimited(1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setExactLimit(1)))
                .where('X', states(getCasingState())
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS).setMaxLayerLimited(1, 1))
                        .or(autoAbilities(true, false)))
                .where('#', air())
                .build();
    }

    @Override
    public boolean allowSameFluidFillForOutputs() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(MetalCasingType.STAINLESS_CLEAN);
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.DISTILLATION_TOWER_OVERLAY;
    }

    @Override
    public int getFluidOutputLimit() {
        if (this.handler != null) return this.handler.getLayerCount();
        else return super.getFluidOutputLimit();
    }

    protected class DistillationTowerRecipeLogic extends MultiblockRecipeLogic {

        public DistillationTowerRecipeLogic(MetaTileEntityDefaultDistillationTower tileEntity) {
            super(tileEntity);
        }

        @Override
        protected void outputRecipeOutputs() {
            GTTransferUtils.addItemsToItemHandler(getOutputInventory(), false, itemOutputs);
            handler.applyFluidToOutputs(fluidOutputs, true);
        }

        @Override
        protected boolean setupAndConsumeRecipeInputs(@NotNull Recipe recipe,
                                                      @NotNull IItemHandlerModifiable importInventory,
                                                      @NotNull IMultipleTankHandler importFluids) {
            this.overclockResults = calculateOverclock(recipe);

            modifyOverclockPost(overclockResults, recipe.getRecipePropertyStorage());

            if (!hasEnoughPower(overclockResults)) {
                return false;
            }

            IItemHandlerModifiable exportInventory = getOutputInventory();

            // We have already trimmed outputs and chanced outputs at this time
            // Attempt to merge all outputs + chanced outputs into the output bus, to prevent voiding chanced outputs
            if (!metaTileEntity.canVoidRecipeItemOutputs() &&
                    !GTTransferUtils.addItemsToItemHandler(exportInventory, true, recipe.getAllItemOutputs())) {
                this.isOutputsFull = true;
                return false;
            }

            // We have already trimmed fluid outputs at this time
            if (!metaTileEntity.canVoidRecipeFluidOutputs() &&
                    !handler.applyFluidToOutputs(recipe.getAllFluidOutputs(), false)) {
                this.isOutputsFull = true;
                return false;
            }

            this.isOutputsFull = false;
            if (recipe.matches(true, importInventory, importFluids)) {
                this.metaTileEntity.addNotifiedInput(importInventory);
                return true;
            }
            return false;
        }

        @Override
        protected IMultipleTankHandler getOutputTank() {
            return handler.getFluidTanks();
        }
    }
}
