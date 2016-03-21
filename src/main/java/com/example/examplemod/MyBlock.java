package com.example.examplemod;

/**
 * Created by uchikimi on 2015/08/07.
 */

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class MyBlock extends Block{

    public MyBlock(){
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(ExampleMod.MODID + "_" + "myblock");
        setBlockTextureName(ExampleMod.MODID+":"+"MinecraftEnglish_2");
        setHardness(10.0F);
        setResistance(6000.0F);
        setLightLevel(50.0F);
    }
//myblockのtntがうまくいかない（下）
    /*
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister MyBlock)
    {
        this.blockIcon = MyBlock.registerIcon(this.getTextureName() + "_side");
        this.field_150116_a = MyBlock.registerIcon(this.getTextureName() + "_top");
        this.field_150115_b = MyBlock.registerIcon(this.getTextureName() + "_bottom");
    }

    */
}
