package com.yori3o.yo_hooks.impl;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.locating.IModFile;



public class PlatformModFileResolver {

    public static List<InputStream> findFiles(String path) {

        List<InputStream> streams = new ArrayList<>();

        for (IModInfo mod : ModList.get().getMods()) {

            IModFile file = mod.getOwningFile().getFile();

            try {
                Path found = file.findResource(path);

                if (Files.exists(found)) {
                    streams.add(Files.newInputStream(found));
                }

            } catch (Exception ignored) {}
        }

        return streams;
    }
}