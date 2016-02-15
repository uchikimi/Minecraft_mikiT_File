package com.example.examplemod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class MyBlock_2 extends Block {
    public MyBlock_2() {
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(ExampleMod.MODID + "_" + "myblock_2");
        setBlockTextureName(ExampleMod.MODID + ":" + "myblock_2");
        setHardness(10.0F);
        setResistance(6000.0F);
        setLightLevel(50.0F);
    }
}
