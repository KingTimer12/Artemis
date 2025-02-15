/*
 * Copyright © Wynntils 2022.
 * This file is released under AGPLv3. See LICENSE for full license details.
 */
package com.wynntils.mc.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.Event;

/**
 * Fired when {@link net.minecraft.client.renderer.entity.LivingEntityRenderer} checks whether an
 * entity should be rendered translucent or not
 */
public class LivingEntityRenderTranslucentCheckEvent extends Event {
    private boolean translucent;
    private final LivingEntity entity;
    private float translucence;

    public LivingEntityRenderTranslucentCheckEvent(
            boolean translucent, LivingEntity entity, float translucence) {
        this.translucent = translucent;
        this.entity = entity;
        this.translucence = translucence;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public float getTranslucence() {
        return translucence;
    }

    public void setTranslucence(float translucence) {
        this.translucence = translucence;
        this.translucent = translucence == 1f;
    }

    public boolean isTranslucent() {
        return translucent;
    }
}
