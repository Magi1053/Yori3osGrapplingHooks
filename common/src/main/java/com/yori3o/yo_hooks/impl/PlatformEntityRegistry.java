package com.yori3o.yo_hooks.impl;


import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;



public class PlatformEntityRegistry {

    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(ResourceLocation id, Supplier<EntityType<T>> supplier) {
        throw new RuntimeException("Platform-specific implementation missing");
    } 
     
}

