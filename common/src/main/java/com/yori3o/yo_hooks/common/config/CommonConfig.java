package com.yori3o.yo_hooks.common.config;


import java.nio.file.Path;

import com.yori3o.yo_hooks.impl.PlatformUtil;



public class CommonConfig extends JsonConfigManager<CommonConfig.Values> {

    public static class Values {
        public float climbSpeed = 0.115f;

        public boolean softHook = false;
        public float stiffness = 0.10f;

        public boolean funnyMode = false;
    }

    private static final Path CONFIG_PATH = PlatformUtil.getConfigDir().resolve("yo_hooks_common.json");

    public CommonConfig() {
        super(Values.class, CONFIG_PATH);
    }

    @Override
    protected Values getDefaultConfig() {
        return new Values();
    }
}
