package com.schnurritv.sexmod;

import com.schnurritv.sexmod.networking.NetworkHandler;
import com.schnurritv.sexmod.entity.EntityRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "sexmod";
    public static final Logger LOGGER = LogManager.getLogger();

    public Main(ModContainer modContainer) {
        IEventBus modEventBus = modContainer.getEventBus();
        modEventBus.addListener(this::setup);
        EntityRegistry.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkHandler::register);
    }
}
