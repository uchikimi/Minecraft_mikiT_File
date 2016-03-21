package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 16/02/20.
 */
public class AllenModWhiteChicken extends ItemFood {
    private PotionEffect[] effects;

    public AllenModWhiteChicken(String unlocalizedName, int healAmount, float saturationModifier, boolean wovesFavourite, PotionEffect[] effects) {
        super(healAmount, saturationModifier, wovesFavourite);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(ExampleMod.MODID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.effects = effects;
    }

    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
        --itemStack.stackSize;
        player.getFoodStats().func_151686_a(this, itemStack);
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(itemStack, world, player);
        return itemStack;
    }
}