package com.yori3o.yo_hooks.impl;


import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;



public class PlatformItemRegistry {

    public static <T extends Item> Supplier<T> registerItem(ResourceLocation id, Supplier<T> suppler) {
        throw new RuntimeException("Platform-specific implementation missing");
    } 
     
}

