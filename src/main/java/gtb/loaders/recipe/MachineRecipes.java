package gtb.loaders.recipe;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.*;
import static gtb.api.unification.materials.GTBMaterials.*;
import static gtb.common.block.blocks.GTBMultiblockCasing.CasingType.*;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;

import gtb.common.block.GTBMetaBlocks;
import gtb.common.metatileentities.GTBMetaTileEntities;

public class MachineRecipes {

    public static void init() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(200)
                .EUt(20)
                .outputs(GTBMetaBlocks.GTB_MULTIBLOCK_CASING.getItemVariant(VACUUM_FURNACE_CASING))
                .input(bolt, Silver)
                .input(frameGt, Iron)
                .fluidInputs(AluminoSilicateWoolSolution.getFluid(288))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, StainlessSteel, 4)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(ELECTRIC_MOTOR_IV, 4)
                .input(ELECTRIC_PUMP_IV, 4)
                .outputs(GTBMetaTileEntities.BACTERIAL_VAT.getStackForm(1))
                .duration(1200)
                .EUt(800)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(foil, StainlessSteel, 4)
                .input(frameGt, StainlessSteel)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(ELECTRIC_PUMP_EV, 2)
                .outputs(GTBMetaTileEntities.DILUTION_TANK.getStackForm(1))
                .duration(1200)
                .EUt(800)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(foil, Polybenzimidazole, 32)
                .input(plate, Grisium, 32)
                .input(stickLong, Cupronickel, 32)
                .input(pipeLargeFluid, Polytetrafluoroethylene, 8)
                .inputs(MetaBlocks.BOILER_CASING
                        .getItemVariant(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE))
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING))
                .input(circuit, MarkerMaterials.Tier.IV, 4)
                .input(ELECTRIC_MOTOR_IV, 4)
                .fluidInputs(Polytetrafluoroethylene.getFluid(2304))
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .output(GTBMetaTileEntities.CHEMICAL_PLANT)
                .duration(1200)
                .EUt(800)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .fluidInputs(Polytetrafluoroethylene.getFluid(2304))
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .input(circuit, MarkerMaterials.Tier.IV, 4)
                .input(foil, Polybenzimidazole, 32)
                .input(frameGt, Titanium, 16)
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN))
                .output(GTBMetaTileEntities.ENGRAVING_UNIT)
                .duration(120)
                .EUt(800)
                .buildAndRegister();

        ModHandler.addShapedRecipe("clarifier_machine", GTBMetaTileEntities.CLARIFIER.getStackForm(),
                "PCP", "UMU", "PCP",
                'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.EV),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'P', ELECTRIC_PISTON_EV.getStackForm(),
                'U', ELECTRIC_PUMP_EV.getStackForm());

        ModHandler.addShapedRecipe("digester_machine", GTBMetaTileEntities.DIGESTER.getStackForm(),
                "TTT", "PMP", "TTT",
                'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.IV),
                'P', ELECTRIC_PISTON_EV.getStackForm(),
                'T', new UnificationEntry(plate, Titanium));

        ModHandler.addShapedRecipe("stc_machine", GTBMetaTileEntities.SOLAR_THERMAL_CONCENTRATOR.getStackForm(),
                "PBP", "SFS", "PSP",
                'F', new UnificationEntry(frameGt, Bronze),
                'S', new UnificationEntry(pipeSmallFluid, Steel),
                'B', BlockMachineCasing.MachineCasingType.ULV,
                'P', new UnificationEntry(plate, Bronze));

        ModHandler.addShapedRecipe("ffu_machine", GTBMetaTileEntities.FROTH_FLOTATION_UNIT.getStackForm(),
                "CPC", "PMP", "CPC",
                'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.EV),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'P', ELECTRIC_PUMP_EV.getStackForm());

        ModHandler.addShapedRecipe("vac_furnace_machine", GTBMetaTileEntities.VACUUM_FURNACE.getStackForm(),
                "PCP", "CMC", "PCP",
                'M', GTBMetaBlocks.GTB_MULTIBLOCK_CASING.getItemVariant(VACUUM_FURNACE_CASING),
                'P', new UnificationEntry(plate, Steel),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.MV));

        registerMachineRecipe(GTBMetaTileEntities.ROTARY_EVAPORATOR,
                "MRM", "CMC", "PRP",
                'M', MOTOR,
                'R', ROTOR,
                'C', CIRCUIT,
                'P', PUMP,
                'M', HULL);

        registerMachineRecipe(GTBMetaTileEntities.ROASTER,
                "SCS", "UMU", "PCP",
                'C', CABLE,
                'S', MOTOR,
                'U', CIRCUIT,
                'M', HULL,
                'P', PISTON);

        registerMachineRecipe(GTBMetaTileEntities.ION_IMPLANTER,
                "PEP", "CGC", "PMP",
                'C', CIRCUIT,
                'E', EMITTER,
                'G', GLASS,
                'M', HULL,
                'P', PISTON);

        registerMachineRecipe(GTBMetaTileEntities.CVD_UNIT,
                "CGG",
                "KMP",
                "CHP",
                'C', CIRCUIT,
                'H', HULL,
                'G', GLASS,
                'M', MOTOR,
                'P', PUMP,
                'K', CABLE);

        registerMachineRecipe(GTBMetaTileEntities.MICROSCOPE,
                "MSM",
                "PCP",
                "PKP",
                'P', PLATE,
                'M', MOTOR,
                'S', SENSOR,
                'K', CABLE,
                'C', HULL);

        registerMachineRecipe(GTBMetaTileEntities.DEHYDRATORS,
                "KCK",
                "TMT",
                "PRP",
                'P', PLATE,
                'R', ROBOT_ARM,
                'C', CIRCUIT,
                'K', CABLE,
                'T', MOTOR,
                'M', HULL);

        registerMachineRecipe(GTBMetaTileEntities.CRYSTALLIZERS,
                "KCK",
                "CMC",
                "RKR",
                'R', ROBOT_ARM,
                'C', CIRCUIT,
                'K', CABLE,
                'M', HULL);
    }
}
