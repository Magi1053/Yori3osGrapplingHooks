package com.yori3o.yo_hooks.impl;


import java.nio.file.Path;



public final class PlatformUtil {

    public static boolean isModLoaded(String id) {
        throw new RuntimeException("Platform-specific implementation missing");
    }

    public static Path getConfigDir() {
        throw new RuntimeException("Platform-specific implementation missing");
    }

    public static Path getGameDir() {
        throw new RuntimeException("Platform-specific implementation missing");
    }

    public static boolean isClient() {
        throw new RuntimeException("Platform-specific implementation missing");
    }

    public static String getVerison(String modId) {
        throw new RuntimeException("Platform-specific implementation missing");
    }
    
    public static boolean isFabric() {
        throw new RuntimeException("Platform-specific implementation missing");
    }

}
