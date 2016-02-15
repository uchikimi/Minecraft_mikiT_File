package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHerbicide extends Item {
    public ItemHerbicide() {
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName(ExampleMod.MODID + "_herbicide");
        setTextureName(ExampleMod.MODID + ":herbicide");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
                             int x, int y, int z, int meta,float wx, float wy, float wz) {

//木こり？
        /*
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                for (int k = -2; k <= 2; k++) {
                    Block block = world.getBlock(x + i, y + j, z + k);
                    System.out.println(block.getUnlocalizedName());
                    if(block == Blocks.leaves){
                        world.setBlock(x + i, y + j, z + k, Blocks.air);
                    }else if(block.getMaterial() == Material.wood){
                        world.setBlock(x + i, y + j, z + k, Blocks.air);
                    }

                }
            }
        }
        */

        //除草剤

        for (int i = -10; i <= 10; i++) {
            for (int j = -10; j <= 10; j++) {
                for (int k = -10; k <= 10; k++) {
                    Block block = world.getBlock(x + i, y + j, z + k);
                    System.out.println(block.getUnlocalizedName());
                    if(block == Blocks.grass){
                        world.setBlock(x + i, y + j, z + k, Blocks.snow_layer);
                    }else if(block == Blocks.tallgrass){
                        world.setBlock(x + i, y + j, z + k, Blocks.air);
                    }else if(block == Blocks.double_plant){
                        world.setBlock(x + i, y + j, z + k, Blocks.air);
                    }else if(block==Blocks.dirt){
                        world.setBlock(x+i,y+j,z+k,Blocks.snow);
                    }else if(block==Blocks.water){
                        world.setBlock(x+i,y+j,z+k,Blocks.snow);
                    }else if(block==Blocks.cobblestone){
                        world.setBlock(x+i,y+j,z+k,Blocks.snow);
                    }else if(block==Blocks.sand){
                        world.setBlock(x+i,y+j,z+k,Blocks.snow);
                    }

                }
            }
        }


        stack.stackSize--;
        return true;
    }
}

