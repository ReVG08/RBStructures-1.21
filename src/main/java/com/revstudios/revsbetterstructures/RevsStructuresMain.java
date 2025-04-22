package com.revstudios.revsbetterstructures;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RevsBetterStructures.MODID)
public class RevsBetterStructures {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "revsbetterstructures";

    public RevsBetterStructures(IEventBus modEventBus) {
        RBStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        RBStructurePlacements.DEFERRED_REGISTRY_STRUCTURE_PLACEMENT_TYPE.register(modEventBus);
    }
}
