package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 15/11/15.
 */

public class BlockLogicAnd extends Block {
    private IIcon[] icons = new IIcon[4];

    protected BlockLogicAnd() {
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabRedstone);
        setBlockName(ExampleMod.MODID + "_logic_and");
        setBlockTextureName(ExampleMod.MODID + ":logic");
    }
    @Override
    public void registerBlockIcons(IIconRegister register) {
        icons[0] = register.registerIcon(textureName + "_blank");
        icons[1] = register.registerIcon(textureName + "_a");
        icons[2] = register.registerIcon(textureName + "_b");
        icons[3] = register.registerIcon(textureName + "_x");
    }
    @Override
    public IIcon getIcon(int side, int metadata) {
        if (side == 3) {
            return icons[3];
        } else if (side == 4) {
            return icons[2];
        } else if (side == 5) {
            return icons[1];
        } else {
            return icons[0];
        }
    }
    @Override
    public boolean canProvidePower(){
        return true;
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world,int x,int y,int z,int dir){
        return dir==1||dir==2||dir==3;
    }
    @Override
    public int isProvidingWeakPower(IBlockAccess world ,int x,int y,int z,int dir){
        if(dir==2){
            if(world.getBlockMetadata(x,y,z)==1){
                return 15;
            }
        }
        return 0;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess world,int x,int y,int z,int dir){
        return this.isProvidingWeakPower(world,x,y,z,dir);
    }

    private int getPowerFrom(World world,int x,int y,int z,int side){
        Block block = world.getBlock(x,y,z);
        if(!block.canProvidePower()){
            return 0;
        }
        if(block== Blocks.redstone_wire){
            return world.getBlockMetadata(x,y,z);
        }
        return world.getIndirectPowerLevelTo(x, y, z, side);
    }

    public int checkCurrentMetadata (World world,int x,int y,int z){
        int levelA = getPowerFrom(world,x-1,y,z,4);
        int levelB = getPowerFrom(world, x + 1, y, z, 5);

        if(levelA>0&&levelB>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public void onNeighborBlockChange (World world,int x,int y,int z,Block block){
        int meta = checkCurrentMetadata(world,x,y,z);
        int oldMeta = world.getBlockMetadata(x,y,z);
        if(oldMeta != meta){
            world.setBlockMetadataWithNotify(x,y,z,meta,3);
            world.notifyBlockOfNeighborChange(x,y,z-1,this);
        }

    }

}
