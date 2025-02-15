/*
 * Copyright © Wynntils 2022.
 * This file is released under AGPLv3. See LICENSE for full license details.
 */
package com.wynntils.mc.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import java.util.Map;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyMapping.class)
public class KeyMappingMixin {
    @Shadow @Final private static Map<String, Integer> CATEGORY_SORT_ORDER;

    @Inject(
            method =
                    "<init>(Ljava/lang/String;Lcom/mojang/blaze3d/platform/InputConstants$Type;ILjava/lang/String;)V",
            at = @At("RETURN"))
    public void initPost(
            String name, InputConstants.Type type, int i, String category, CallbackInfo ci) {
        if (CATEGORY_SORT_ORDER.containsKey(category)) return;

        int max = 0;

        for (int val : CATEGORY_SORT_ORDER.values()) {
            if (val > max) {
                max = val;
            }
        }

        CATEGORY_SORT_ORDER.put(category, max + 1);
    }
}
