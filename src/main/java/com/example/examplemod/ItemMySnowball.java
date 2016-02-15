package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMySnowball extends ItemSnowball {

    public ItemMySnowball() {
        super();
        setUnlocalizedName(ExampleMod.MODID + "_snow_ball");
        // 1
        setTextureName("snowball");  //テクスチャの設定
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityMySnowball(world, player));

            world.spawnEntityInWorld(new EntityMySnowball(world, player));

        }
        return itemStack;
    }

}


