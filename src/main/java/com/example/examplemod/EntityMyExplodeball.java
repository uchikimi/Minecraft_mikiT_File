package com.example.examplemod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 16/02/21.
 */

public class EntityMyExplodeball extends EntitySnowball {
    public EntityMyExplodeball(World world) {
        super(world);
    }
    public EntityMyExplodeball(World world, EntityLivingBase entity) {
        super(world, entity);
    }
    public EntityMyExplodeball(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    @Override
    protected void onImpact(MovingObjectPosition position){
        Block block = worldObj.getBlock(position.blockX, position.blockY, position.blockZ);
        this.worldObj.createExplosion(riddenByEntity,this.posX,this.posY,this.posZ,3F,true);

        for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

    }
}
