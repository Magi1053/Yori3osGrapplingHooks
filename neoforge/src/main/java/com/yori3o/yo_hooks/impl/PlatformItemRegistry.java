package com.yori3o.yo_hooks.impl;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.yori3o.yo_hooks.common.YoHooks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;



public class PlatformItemRegistry {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(Registries.ITEM, YoHooks.MOD_ID);

    //public static final Map<ResourceLocation, Item> ITEMS = new HashMap<>();

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    /*public static Item registerItem(ResourceLocation id, Item item) {
        //ITEMS.register(
        //    id.getPath(),
        //    () -> item
        //);
        ITEMS.put(id, item);
        return item;
    }*/
    public static <T extends Item> Supplier<T> registerItem(
            ResourceLocation id,
            Supplier<T> supplier
    ) {
        DeferredHolder<Item, T> obj = ITEMS.register(id.getPath(), supplier);
        return obj;
    }
     
}

