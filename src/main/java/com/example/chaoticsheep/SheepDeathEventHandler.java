package com.example.chaoticsheep;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class SheepDeathEventHandler {

    private static final float SPAWN_CHANCE = 0.05f;

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

    private static final int LIGHTNING_STRIKES = 8;
    private static final double LIGHTNING_RADIUS = 3.0;

    private static void spawnWither(Sheep sheep) {
        Level world = sheep.level();
        if (!(world instanceof ServerLevel serverLevel)) {
            return;
        }

        double x = sheep.getX();
        double y = sheep.getY();
        double z = sheep.getZ();

        for (int i = 0; i < LIGHTNING_STRIKES; i++) {
            double angle = (Math.PI * 2 * i) / LIGHTNING_STRIKES;
            double lx = x + Math.cos(angle) * LIGHTNING_RADIUS;
            double lz = z + Math.sin(angle) * LIGHTNING_RADIUS;
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel);
            bolt.setPos(lx, y, lz);
            serverLevel.addFreshEntity(bolt);
        }

        WitherBoss wither = new WitherBoss(EntityType.WITHER, serverLevel);
        wither.setPos(x, y + 3, z);
        serverLevel.addFreshEntity(wither);
    }
}
