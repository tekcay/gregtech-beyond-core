package gtb.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.jetbrains.annotations.ApiStatus;

import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.event.PostMaterialEvent;

import gtb.GregtechBeyondCore;
import gtb.api.unification.GTBMaterialFlagAddition;
import gtb.api.unification.GTBMaterials;

@ApiStatus.Internal
@Mod.EventBusSubscriber(modid = GregtechBeyondCore.MODID)
public final class GTBEventHandlers {

    private GTBEventHandlers() {}

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(MaterialEvent event) {
        GTBMaterials.init();
    }

    @SubscribeEvent
    public static void registerMaterialsPost(PostMaterialEvent event) {
        GTBMaterialFlagAddition.initLate();
    }
}
