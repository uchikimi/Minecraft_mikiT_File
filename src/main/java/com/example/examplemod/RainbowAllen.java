package com.example.examplemod;

/**
 * Created by uchikimi on 2015/09/01.
 */

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;


public class RainbowAllen extends Block{

    public IIcon[]icons=new IIcon[20];

    public RainbowAllen(){
        super(Material.tnt);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(ExampleMod.MODID + "happybirthdayallen");
        setBlockTextureName(ExampleMod.MODID + ":" + "happybirthdayallen");
        setHardness(100f);
    }

    @Override
    public void registerBlockIcons(IIconRegister register){
        for (int i=0; i<20; i++){
            this.icons[i]=register.registerIcon(textureName+"_"+i);
        }
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        return icons[metadata];
    }

    @Override
    public void onBlockClicked(World world,int x,int y,int z,EntityPlayer player){
        int meta=world.getBlockMetadata(x,y,z);
        meta=meta+1;

        if(meta>=20){
            meta=0;
        }
        world.setBlockMetadataWithNotify(x,y,z,meta,2);
    }

}