package com.example.examplemod;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 2015/08/13.
 */

public class ItemLightningSword extends ItemSword {
    public ItemLightningSword() {
        super(ToolMaterial.EMERALD);
        setUnlocalizedName(ExampleMod.MODID + "_lightning_sword");
        setTextureName(ExampleMod.MODID + ":lightning_sword");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 2, player.posY, player.posZ - 2));

        /*
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 2, player.posY, player.posZ));
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 2, player.posY, player.posZ + 2));
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ - 2));
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ + 2));
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 2, player.posY, player.posZ - 2));
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 2, player.posY, player.posZ));
        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 2, player.posY, player.posZ + 2));
        */

        return super.onItemRightClick(itemStack, world, player);

    }

    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.none;
    }
}