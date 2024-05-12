package gtb.api.unification.materials;

import static gregtech.api.util.GTUtility.gregtechId;
import static gtb.api.unification.materials.GTBMaterials.*;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;

public class GTBBiologicalMaterials {

    // Range 25601-25800
    private static int startId = 25601;
    private static final int END_ID = startId + 200;

    public static void register() {
        CupriavidusNecator = new Material.Builder(getMaterialsId(), gregtechId("cupriavidus_necator"))
                .dust()
                .color(0xEF5350)
                .build().setFormula("Bacteria", true);

        BacterialGrowthMedium = new Material.Builder(getMaterialsId(), gregtechId("bacterial_growth_medium"))
                .liquid(new FluidBuilder())
                .color(0xEF5350)
                .build().setFormula("For Bacteria", true);

        DepletedBacterialGrowthMedium = new Material.Builder(getMaterialsId(),
                gregtechId("depleted_bacterial_growth_medium"))
                        .liquid(new FluidBuilder())
                        .color(0xEF5350)
                        .build().setFormula("For Bacteria", true);

        Blood = new Material.Builder(getMaterialsId(), gregtechId("blood"))
                .liquid(new FluidBuilder())
                .color(0xEF5350)
                .build().setFormula("?", true);

        BloodCells = new Material.Builder(getMaterialsId(), gregtechId("blood"))
                .liquid(new FluidBuilder())
                .color(0xEF5350)
                .build().setFormula("?", true);

        BloodPlasma = new Material.Builder(getMaterialsId(), gregtechId("blood"))
                .liquid(new FluidBuilder())
                .color(0xEF5350)
                .build().setFormula("?", true);

        Catalase = new Material.Builder(getMaterialsId(), gregtechId("catalase"))
                .liquid(new FluidBuilder())
                .color(0xEF5350)
                .build().setFormula("?", true);

        BasicFibroblastGrowthMedium = new Material.Builder(getMaterialsId(),
                gregtechId("basic_fibroglast_growth_medium"))
                        .liquid(new FluidBuilder())
                        .color(0xEF5350)
                        .build().setFormula("bFGF", true);

        EpidermalGrowthFactor = new Material.Builder(getMaterialsId(), gregtechId("epidermal_growth_factora"))
                .liquid(new FluidBuilder())
                .color(0xEF5350)
                .build().setFormula("C257H381N73O83S7", true);

        CupriavidusNecatorBacteriaSample = new Material.Builder(getMaterialsId(),
                gregtechId("cupriavidus_necator_bacteria_sample"))
                        .dust()
                        .color(0xEF5350)
                        .build().setFormula("Bacteria", true);

        Cuproquin = new Material.Builder(getMaterialsId(), gregtechId("cuproquin"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C18H13CuN2O", true);

        Sulfanilamide = new Material.Builder(getMaterialsId(), gregtechId("sulfanilamide"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        AcetylsulfanilylChloride = new Material.Builder(getMaterialsId(), gregtechId("acetylsulfanilyl_chloride"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        ChlorosulfonicAcid = new Material.Builder(getMaterialsId(), gregtechId("chlorosulfonic_acid"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        AceticAnhydride = new Material.Builder(getMaterialsId(), gregtechId("acetic_anhydride"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        Aniline = new Material.Builder(getMaterialsId(), gregtechId("aniline"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        AmmoniumNitrate = new Material.Builder(getMaterialsId(), gregtechId("ammonium_nitrate"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        B_27_Supplement = new Material.Builder(getMaterialsId(), gregtechId("b_27_supplement"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        Glutamine = new Material.Builder(getMaterialsId(), gregtechId("glutamine"))
                .dust()
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        LinoleicAcid = new Material.Builder(getMaterialsId(), gregtechId("linoleic_acid"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        Biotin = new Material.Builder(getMaterialsId(), gregtechId("biotin"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        Ethanolamine = new Material.Builder(getMaterialsId(), gregtechId("ethanolamine"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        VitaminA = new Material.Builder(getMaterialsId(), gregtechId("vitamin_a"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        BetaIonone = new Material.Builder(getMaterialsId(), gregtechId("beta_ionone"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        PropargylChloride = new Material.Builder(getMaterialsId(), gregtechId("PropargylChloride"))
                .liquid(new FluidBuilder())
                .color(0x191919)
                .build().setFormula("C6H8N2O2S", true);

        Citral = new Material.Builder(getMaterialsId(), gregtechId("citral"))
                .liquid(new FluidBuilder())
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        BetaPinene = new Material.Builder(getMaterialsId(), gregtechId("beta_pinene"))
                .dust()
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        Turpentine = new Material.Builder(getMaterialsId(), gregtechId("turpentine"))
                .liquid(new FluidBuilder())
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        PropargylAlcohol = new Material.Builder(getMaterialsId(), gregtechId("propargyl_alcohol"))
                .liquid(new FluidBuilder())
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        Acetylene = new Material.Builder(getMaterialsId(), gregtechId("acetylene"))
                .liquid(new FluidBuilder())
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        CleanAmmoniaSolution = new Material.Builder(getMaterialsId(), gregtechId("clean_ammonia_solution"))
                .liquid(new FluidBuilder())
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        Leucine = new Material.Builder(getMaterialsId(), gregtechId("leucine"))
                .dust()
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        Yeast = new Material.Builder(getMaterialsId(), gregtechId("yeast"))
                .dust()
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        BrevibacteriumFlavium = new Material.Builder(getMaterialsId(), gregtechId("brevibacterium_flavium"))
                .dust()
                .color(0x9DD6D0)
                .build().setFormula("C20H12O3", true);

        YEEMSolution = new Material.Builder(getMaterialsId(), gregtechId("yeem_solution"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        YeastExtractMannitolMedium = new Material.Builder(getMaterialsId(), gregtechId("yeast_extract_mannitol_medium"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        YeastExtractMannitolAgarSolution = new Material.Builder(getMaterialsId(),
                gregtechId("yeast_extract_mannitol_agar_solution"))
                        .liquid(new FluidBuilder())
                        .color(0x4A148C)
                        .build().setFormula("C20H12O3", true);

        DissolvedYeastExtractMannitolMixture = new Material.Builder(getMaterialsId(),
                gregtechId("dissolved_yeast_extract_mannitol_mixture"))
                        .liquid(new FluidBuilder())
                        .color(0x4A148C)
                        .build().setFormula("C20H12O3", true);

        YeastExtract = new Material.Builder(getMaterialsId(), gregtechId("yeast_extract"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        Mannitol = new Material.Builder(getMaterialsId(), gregtechId("mannitol"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        YeastMixture = new Material.Builder(getMaterialsId(), gregtechId("yeast_mixture"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        WasteWater = new Material.Builder(getMaterialsId(), gregtechId("waste_water"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        NutrientRichSolution = new Material.Builder(getMaterialsId(), gregtechId("nutrient_rich_solution"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        MaltExtract = new Material.Builder(getMaterialsId(), gregtechId("malt_extract"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        Peptone = new Material.Builder(getMaterialsId(), gregtechId("peptone"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        Wort = new Material.Builder(getMaterialsId(), gregtechId("wort"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        HotGristSolution = new Material.Builder(getMaterialsId(), gregtechId("hot_grist_solution"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        GristPowder = new Material.Builder(getMaterialsId(), gregtechId("grist_powder"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        SolidGrain = new Material.Builder(getMaterialsId(), gregtechId("solid_grain"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        Glucose = new Material.Builder(getMaterialsId(), gregtechId("glucose"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        Nonoxynol_9 = new Material.Builder(getMaterialsId(), gregtechId("nonoxynol_9"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        Nonoxynol_9_Solution = new Material.Builder(getMaterialsId(), gregtechId("nonoxynol_9_solution"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        EthoxylatedNonylphenol = new Material.Builder(getMaterialsId(), gregtechId("ethoxylated_nonylphenol"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        Nonylphenol = new Material.Builder(getMaterialsId(), gregtechId("nonylphenol"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("C20H12O3", true);

        EschericiaColi = new Material.Builder(getMaterialsId(), gregtechId("eschericia_coli"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

        Iriditus = new Material.Builder(getMaterialsId(), gregtechId("iriditus"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

        Fructose = new Material.Builder(getMaterialsId(), gregtechId("fructose"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

        SheepBlood = new Material.Builder(getMaterialsId(), gregtechId("sheep_blood"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("?", true);

        SheepBloodPlasma = new Material.Builder(getMaterialsId(), gregtechId("sheep_blood_plasma"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("?", true);

        SheepBloodCells = new Material.Builder(getMaterialsId(), gregtechId("sheep_blood_cells"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("?", true);

        DefibernatedSheepBlood = new Material.Builder(getMaterialsId(), gregtechId("defibernated_sheep_blood"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("?", true);

        EdeticAcid = new Material.Builder(getMaterialsId(), gregtechId("edetic_acid"))
                .liquid(new FluidBuilder())
                .color(0x4A148C)
                .build().setFormula("?", true);

        SolidifiedSterileDefibernatedSheepBlood = new Material.Builder(getMaterialsId(), gregtechId("edetic_acid"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

        DissolvedPhenylEthylAlcoholAgar = new Material.Builder(getMaterialsId(), gregtechId("dissolved_phenyl_ethyl_alcohol_agar"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

        PhenylEthylAlcoholAgarSolution = new Material.Builder(getMaterialsId(), gregtechId("phenyl_ethyl_alcohol_agar_solution"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

        PhenylEthylAlcohol = new Material.Builder(getMaterialsId(), gregtechId("phenyl_ethyl_alcohol"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

        Xerizin = new Material.Builder(getMaterialsId(), gregtechId("xerizin"))
                .dust()
                .color(0x4A148C)
                .build().setFormula("?", true);

    }


    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
