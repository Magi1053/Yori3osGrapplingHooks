package com.yori3o.yo_hooks.impl;


import java.io.InputStream;
import java.util.List;



public class PlatformModFileResolver {

    public static List<InputStream> findFiles(String path) {
        throw new RuntimeException("Platform-specific implementation missing");
    }
    
}