package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 2015/08/15.
 */
public class ItemTNTRod extends Item {
    public ItemTNTRod() {
        super();
        setCreativeTab(CreativeTabs.tabCombat);
        setUnlocalizedName(ExampleMod.MODID + "_tnt_rod");
        setTextureName(ExampleMod.MODID + ":tnt_rod");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if (!player.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            EntityTNTPrimed tnt = new EntityTNTPrimed(world, player.posX, player.posY, player.posZ, player);

            float f = 1.0F;
            tnt.setLocationAndAngles(player.posX, player.posY + (double) player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
            tnt.posX -= (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
            tnt.posY -= 0.1;
            tnt.posZ -= (double) (MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
            tnt.setPosition(tnt.posX, tnt.posY, tnt.posZ);
            tnt.yOffset = 0.0F;
            tnt.motionX = (double) (-MathHelper.sin(tnt.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(tnt.rotationPitch / 180.0F * (float) Math.PI) * f);
            tnt.motionZ = (double) (MathHelper.cos(tnt.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(tnt.rotationPitch / 180.0F * (float) Math.PI) * f);
            tnt.motionY = (double) (-MathHelper.sin((tnt.rotationPitch) / 180.0F * (float) Math.PI) * f);

            world.spawnEntityInWorld(tnt);

        }
        return itemStack;
    }
}