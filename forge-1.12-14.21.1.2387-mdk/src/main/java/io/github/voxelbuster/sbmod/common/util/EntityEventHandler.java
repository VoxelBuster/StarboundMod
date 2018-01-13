package io.github.voxelbuster.sbmod.common.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityEventHandler {
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        EntityLivingBase ent = event.getEntityLiving();
        if (ent instanceof EntityZombie) {
            ent.dropItem(RegisterUtil.pixel, 16);
        } else if (ent instanceof EntitySkeleton) {
            ent.dropItem(RegisterUtil.pixel, 16);
        } else if (ent instanceof EntitySpider) {
            ent.dropItem(RegisterUtil.pixel, 16);
        } else if (ent instanceof EntityEnderman) {
            ent.dropItem(RegisterUtil.pixel, 50);
        } else if (ent instanceof EntityCreeper) {
            ent.dropItem(RegisterUtil.pixel, 32);
        } else if (ent instanceof EntityCaveSpider) {
            ent.dropItem(RegisterUtil.pixel, 20);
        } else if (ent instanceof EntitySilverfish) {
            ent.dropItem(RegisterUtil.pixel, 8);
        } else if (ent instanceof EntityBlaze) {
            ent.dropItem(RegisterUtil.pixel, 40);
        } else if (ent instanceof EntityGhast) {
            ent.dropItem(RegisterUtil.pixel, 16);
        } else if (ent instanceof EntitySlime) {
            ent.dropItem(RegisterUtil.pixel, 8);
        } else if (ent instanceof EntityPigZombie) {
            ent.dropItem(RegisterUtil.pixel, 24);
        } else if (ent instanceof EntityMagmaCube) {
            ent.dropItem(RegisterUtil.pixel, 16);
        } else if (ent instanceof EntityDragon) {
            ent.dropItem(RegisterUtil.pixel, 250);
        } else if (ent instanceof EntityWitherSkeleton) {
            ent.dropItem(RegisterUtil.pixel, 32);
        } else if (ent instanceof EntityWither) {
            ent.dropItem(RegisterUtil.pixel, 300);
        } else if (ent instanceof EntityBat) {
            ent.dropItem(RegisterUtil.pixel, 8);
        } else if (ent instanceof EntityWitch) {
            ent.dropItem(RegisterUtil.pixel, 32);
        } else if (ent instanceof EntityEndermite) {
            ent.dropItem(RegisterUtil.pixel, 8);
        } else if (ent instanceof EntityGuardian) {
            ent.dropItem(RegisterUtil.pixel, 64);
        } else if (ent instanceof EntityElderGuardian) {
            ent.dropItem(RegisterUtil.pixel, 128);
        } else if (ent instanceof EntityShulker) {
            ent.dropItem(RegisterUtil.pixel, 64);
        } else if (ent instanceof EntityAnimal) {
            ent.dropItem(RegisterUtil.pixel, 10);
        } else if (ent instanceof EntityIronGolem) {
            ent.dropItem(RegisterUtil.pixel, 64);
        }
    }
}
