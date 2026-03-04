package com.yori3o.yo_hooks.impl;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.yori3o.yo_hooks.common.YoHooks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;



public class PlatformEntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, YoHooks.MOD_ID);

    //public static final Map<ResourceLocation, EntityType<?>> ITEMS = new HashMap<>();

    /*public static <T extends Entity> EntityType<T> registerEntity(ResourceLocation id, EntityType<T> entityType) {
        //return ENTITIES.register(
        //    id.getPath(),
        //    () -> entityType
        //).get();
        ITEMS.put(id, entityType);
        return entityType;
    } */

    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(ResourceLocation id, Supplier<EntityType<T>> supplier) {
        DeferredHolder<EntityType<?>, EntityType<T>> obj = ENTITIES.register(id.getPath(), supplier);
        return obj;
        /*return ENTITIES.register(
            id.getPath(),
            supplier
        );*/
    } 
     
}

