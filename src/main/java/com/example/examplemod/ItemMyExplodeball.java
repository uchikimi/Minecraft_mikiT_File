package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 16/02/21.
 */
public class ItemMyExplodeball extends Item{
    public ItemMyExplodeball(){
        setUnlocalizedName(ExampleMod.MODID+"explode");
        setTextureName(ExampleMod.MODID+":normal_sword");
        setCreativeTab(CreativeTabs.tabCombat);
    }
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityMyExplodeball(world, player));
        }
        return itemStack;
    }
}
