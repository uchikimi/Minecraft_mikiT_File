package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import javax.swing.text.Position;

/**
 * Created by uchikimi on 15/12/24.
 */
public class MyItem extends Item {
    public MyItem(){
        setUnlocalizedName(ExampleMod.MODID+"_Original_Sword");
        setTextureName(ExampleMod.MODID+":Original_Sword");
        setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean hitEntity (ItemStack item,EntityLivingBase enemy,EntityLivingBase attacker){
        if(item == null){
            return true;
        }
        if(!(attacker instanceof EntityPlayer)){
            return true;
        }
        enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,1200,1));
    //    enemy.setFire(600);
  //      enemy.setPosition(enemy.posX, enemy.posY + 20, enemy.posZ);
//        enemy.worldObj.setBlock((int)enemy.posX,(int)enemy.posY,(int)enemy.posZ, Blocks.glass);
        return true;
    }
}
