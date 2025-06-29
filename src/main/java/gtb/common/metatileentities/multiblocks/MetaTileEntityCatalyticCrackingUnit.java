package gtb.common.metatileentities.multiblocks;

import static gregtech.api.recipes.RecipeMaps.CRACKING_RECIPES;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.jetbrains.annotations.NotNull;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;

public class MetaTileEntityCatalyticCrackingUnit extends RecipeMapMultiblockController {

    public MetaTileEntityCatalyticCrackingUnit(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, CRACKING_RECIPES);
    }

    public IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle("CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC",
                        "CCCCC", "CCCCC", "CCCCC")
                .aisle("CCCCC", " AAA ", " AAA ", " AAA ", " P P ", " P P ", " P P ", " P P ", "CP PC", " AAA ",
                        " AAA ", " AAA ", "CCSCC")
                .aisle("CCCCC", " AAA ", " A A ", " AAA ", "     ", "     ", "     ", "     ", "C   C", " AAA ",
                        " F F ", " AAA ", "CCCCC")
                .aisle("CCCCC", " TTT ", " TTT ", " TTT ", "  R  ", "  R  ", "  R  ", "  R  ", "C R C", " AAA ",
                        " AAA ", " AAA ", "CCCCC")
                .aisle("CCCCC", "C   C", "C   C", "C   C", "C   C", "C   C", "C   C", "C   C", "CCCCC", "CCCCC",
                        "CCCCC", "CCCCC", "CCCCC")
                .where('S', selfPredicate())
                .where('G', states(Blocks.GLASS.getDefaultState()))
                .where('~', any())
                .where('C', states(getCasingState()).setMinGlobalLimited(135).or(autoAbilities()))
                .where('F',
                        states(MetaBlocks.BOILER_FIREBOX_CASING
                                .getState(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX)))
                .where('P', states(MetaBlocks.BOILER_CASING.getState((BoilerCasingType.STEEL_PIPE))))
                .where('R', states(MetaBlocks.BOILER_CASING.getState((BoilerCasingType.BRONZE_PIPE))))
                .where('A', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)))
                .where('T',
                        states(MetaBlocks.BOILER_FIREBOX_CASING
                                .getState(BlockFireboxCasing.FireboxCasingType.BRONZE_FIREBOX)))
                .build();
    }

    @Override
    public TraceabilityPredicate autoAbilities() {
        return autoAbilities(true, true, true, true, true, true, false);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.ASSEMBLER_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityCatalyticCrackingUnit(metaTileEntityId);
    }
}
