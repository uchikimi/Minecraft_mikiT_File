package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import javax.swing.*;

/**
 * Created by uchikimi on 16/02/18.
 */
public class MyBlockTest1 extends Block {
    private IIcon[] icons = new IIcon[6];

    public MyBlockTest1() {
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(ExampleMod.MODID + "myblocktest1");
        setBlockTextureName(ExampleMod.MODID + ":MinecraftEnglish");
        setHardness(100F);
        setResistance(100F);
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for (int i = 0; i < 6; i++) {
            icons[i] = register.registerIcon(textureName + "_" + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return icons[side];
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ) {
/*
        EntityTNTPrimed tnt = new EntityTNTPrimed(world, player.posX, player.posY, player.posZ, player);
        float f = 1.0F;
        tnt.setLocationAndAngles(player.posX, player.posY + (double) player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
        tnt.posX -= (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        tnt.posY -= 0.1;
        tnt.posZ -= (double) (MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        tnt.setPosition(tnt.posX+2, tnt.posY+2, tnt.posZ+2);
        tnt.yOffset = 0.0F;
        tnt.motionX = (double) (-MathHelper.sin(tnt.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(tnt.rotationPitch / 180.0F * (float) Math.PI) * f);
        tnt.motionZ = (double) (MathHelper.cos(tnt.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(tnt.rotationPitch / 180.0F * (float) Math.PI) * f);
        tnt.motionY = (double) (-MathHelper.sin((tnt.rotationPitch) / 180.0F * (float) Math.PI) * f);

        world.spawnEntityInWorld(tnt);
 }
*/

        return false;
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        Block block = world.getBlock(x, y, z);

    }
}
