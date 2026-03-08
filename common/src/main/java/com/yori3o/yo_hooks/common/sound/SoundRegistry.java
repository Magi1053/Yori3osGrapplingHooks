package com.yori3o.yo_hooks.common.sound;


import com.yori3o.yo_hooks.common.hookregistry.HookRegistry;
import com.yori3o.yo_hooks.impl.PlatformSoundRegistry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.HashMap;
import java.util.Map;


/**
 * This class registers and contains sounds, as well as custom ones.
 */
public class SoundRegistry {


    public static final SoundEvent CAST = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "cast"));
    public static final SoundEvent BACK = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "back"));
    public static final SoundEvent AMBIENT = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "ambient"));
    public static final SoundEvent CLIMB = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "climb"));
    public static final SoundEvent HIT = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "hit"));

    public static final Map<String, CustomSoundsHolder> customSounds = new HashMap<>();


    public static void register() {
        PlatformSoundRegistry.registerSound(CAST.getLocation(), CAST);
        PlatformSoundRegistry.registerSound(BACK.getLocation(), BACK);
        PlatformSoundRegistry.registerSound(AMBIENT.getLocation(), AMBIENT);
        PlatformSoundRegistry.registerSound(CLIMB.getLocation(), CLIMB);
        PlatformSoundRegistry.registerSound(HIT.getLocation(), HIT);
    }

    public static void registerNewCustomSounds(String material) {
        final SoundEvent CAST_CUSTOM = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "cast_" + material));
        final SoundEvent BACK_CUSTOM = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "back_" + material));
        final SoundEvent AMBIENT_CUSTOM = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "ambient_" + material));
        final SoundEvent CLIMB_CUSTOM = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "climb_" + material));
        final SoundEvent HIT_CUSTOM = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("yo_hooks", "hit_" + material));

        PlatformSoundRegistry.registerSound(CAST_CUSTOM.getLocation(), CAST_CUSTOM);
        PlatformSoundRegistry.registerSound(BACK_CUSTOM.getLocation(), BACK_CUSTOM);
        PlatformSoundRegistry.registerSound(AMBIENT_CUSTOM.getLocation(), AMBIENT_CUSTOM);
        PlatformSoundRegistry.registerSound(CLIMB_CUSTOM.getLocation(), CLIMB_CUSTOM);
        PlatformSoundRegistry.registerSound(HIT_CUSTOM.getLocation(), HIT_CUSTOM);

        customSounds.put(material, new CustomSoundsHolder(CAST_CUSTOM, BACK_CUSTOM, AMBIENT_CUSTOM, CLIMB_CUSTOM, HIT_CUSTOM));
    }
    
    public static SoundEvent getCastSound(String material) {
        if (HookRegistry.hookMaterialsWithCustomVisuals.contains(material)) {
            return customSounds.get(material).CAST;
        } else {
            return CAST;
        }
    }

    public static SoundEvent getBackSound(String material) {
        if (HookRegistry.hookMaterialsWithCustomVisuals.contains(material)) {
            return customSounds.get(material).BACK;
        } else {
            return BACK;
        }
    }

    public static SoundEvent getAmbientSound(String material) {
        if (HookRegistry.hookMaterialsWithCustomVisuals.contains(material)) {
            return customSounds.get(material).AMBIENT;
        } else {
            return AMBIENT;
        }
    }

    public static SoundEvent getClimbSound(String material) {
        if (HookRegistry.hookMaterialsWithCustomVisuals.contains(material)) {
            return customSounds.get(material).CLIMB;
        } else {
            return CLIMB;
        }
    }

    public static SoundEvent getHitSound(String material) {
        if (HookRegistry.hookMaterialsWithCustomVisuals.contains(material)) {
            return customSounds.get(material).HIT;
        } else {
            return HIT;
        }
    }

}