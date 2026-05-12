package com.example.chaoticsheep;

import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class SheepDeathEventHandler {

    private static final float SPAWN_CHANCE = 0.01f;

    @SubscribeEvent
    public void onSheepDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Sheep sheep)) {
            return;
        }

        Level world = sheep.level();
        if (world.isClientSide()) {
            return;
        }

        if (world.getRandom().nextFloat() < SPAWN_CHANCE) {
            spawnWither(sheep);
        }
    }

    private static void spawnWither(Sheep sheep) {
        Level world = sheep.level();
        WitherBoss wither = new WitherBoss(net.minecraft.world.entity.EntityType.WITHER, world);
        wither.setPos(sheep.getX(), sheep.getY() + 3, sheep.getZ());
        world.addFreshEntity(wither);
    }
}
