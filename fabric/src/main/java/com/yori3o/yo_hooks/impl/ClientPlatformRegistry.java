package com.yori3o.yo_hooks.impl;


import com.yori3o.yo_hooks.common.entity.HookEntity;
import com.yori3o.yo_hooks.common.item.HookItem;
import com.yori3o.yo_hooks.common.init.EntityRegistry;
import com.yori3o.yo_hooks.common.init.ItemRegistry;
import com.yori3o.yo_hooks.common.client.render.HookRenderer;
import com.yori3o.yo_hooks.common.util.PlayerWithHookData;

import java.util.function.Supplier;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;



public class ClientPlatformRegistry {

    public static void initClient() {
        EntityRendererRegistry.register(
            EntityRegistry.HOOK_ENTITY.get(), 
            HookRenderer::new
        );

        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            registerItemProperty();
        });
    }

    private static void registerItemProperty() {
        for (Supplier<HookItem> supplier : ItemRegistry.ALL_HOOKS.values()) {
    
            ItemProperties.register(
                supplier.get(),
                ResourceLocation.fromNamespaceAndPath("yo_hooks", "grappling_hook_handle"),
                (stack, level, entity, seed) -> {
                    if (entity == null || !(entity instanceof Player)) {
                        return 0.0F;
                    }
                    Player player = (Player) entity;
                    HookEntity hook = ((PlayerWithHookData) player).getHook();
                    ItemStack mainHandItem = player.getMainHandItem();

                    boolean flag = mainHandItem == stack;
                    boolean flag1 = player.getOffhandItem() == stack;
                    if (mainHandItem.getItem() instanceof HookItem) {
                        flag1 = false;
                    }

                    boolean hookIsActive = hook != null && !hook.isRemoved();
                    if ((flag || flag1) && hookIsActive) {
                        return 1.0F;
                    } else {
                        return 0.0F;
                    }
                }
            );
        }
    }
}
