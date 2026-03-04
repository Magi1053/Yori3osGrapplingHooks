package com.yori3o.yo_hooks.impl;


import net.minecraft.client.KeyMapping;



public class PlatformKeyMappingRegistry {

    public static void registerKeyMapping(KeyMapping keyMapping) {
        throw new RuntimeException("Platform-specific implementation missing");
    } 
     
}

