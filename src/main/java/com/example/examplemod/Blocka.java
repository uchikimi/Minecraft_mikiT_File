package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 15/09/06.
 */
public class Blocka extends Block{

    private IIcon[] icons = new IIcon[4];
    public static final Block Blocka = new Blocka();

    public Blocka(){
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(ExampleMod.MODID + "_Blocka");
        setBlockTextureName(ExampleMod.MODID + ":MinecraftEnglish");
        setHardness(100F);
    }
/*
    @Override
    public void registerBlockIcons(IIconRegister register){
        icons[0]=register.registerIcon(textureName+"");
        icons[1]=register.registerIcon(textureName+"");
        icons[2]=register.registerIcon(textureName+"");
        icons[3]=register.registerIcon(textureName+"");
    }
*/

    //右クリック
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ) {
        Block block =world.getBlock(x,y,z);
        world.setBlock(x,y,z, Blocks.air,0,2);
        world.setBlock(x,y+1,z,Blocks.sand,0,2);
        return super.onBlockActivated(world, x, y, z, player, side, posX, posY, posZ);
    }
}
