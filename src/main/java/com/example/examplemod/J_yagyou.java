package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 16/02/06.
 */
public class J_yagyou extends Block {
    private IIcon[] icons = new IIcon[6];

    public J_yagyou(){
        super(Material.tnt);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(ExampleMod.MODID + "MinecraftLiteralYA");
        setBlockTextureName(ExampleMod.MODID + ":" + "MinecraftLiteralYA");
        setHardness(100F);
    }

    @Override
    public void registerBlockIcons(IIconRegister register){
        for (int i=0; i<6; i++){
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

        if(meta>=6){
            meta=0;
        }
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}
