package com.revstudios.revsbetterstructures;

import com.mojang.serialization.MapCodec;
import com.revstudios.revsbetterstructures.structures.EndIslandStructures;
import com.revstudios.revsbetterstructures.structures.OceanStructures;
import com.revstudios.revsbetterstructures.structures.SkyStructures;
import com.revstudios.revsbetterstructures.structures.OverworldStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RBStructures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, RevsBetterStructures.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<SkyStructures>> SKY_STRUCTURES =
            DEFERRED_REGISTRY_STRUCTURE.register("sky_structures", () -> explicitStructureTypeTyping(SkyStructures.CODEC));

    public static final DeferredHolder<StructureType<?>, StructureType<OceanStructures>> OCEAN_STRUCTURES =
            DEFERRED_REGISTRY_STRUCTURE.register("ocean_structures", () -> explicitStructureTypeTyping(OceanStructures.CODEC));

    public static final DeferredHolder<StructureType<?>, StructureType<EndIslandStructures>> END_ISLAND_STRUCTURES =
            DEFERRED_REGISTRY_STRUCTURE.register("end_island_structures", () -> explicitStructureTypeTyping(EndIslandStructures.CODEC));

    // Only register the overworld structure group (not each building!)
    public static final DeferredHolder<StructureType<?>, StructureType<OverworldStructures>> OVERWORLD_STRUCTURES =
            DEFERRED_REGISTRY_STRUCTURE.register("overworld_structures", () -> explicitStructureTypeTyping(OverworldStructures.CODEC));

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec) {
        return () -> structureCodec;
    }
}