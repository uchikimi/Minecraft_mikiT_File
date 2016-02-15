package com.example.examplemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import javax.swing.text.Position;

/**
 * Created by uchikimi on 15/12/26.
 */

public class TickHandler {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        EntityPlayer player=event.player;
        ItemStack heldItem = player.getHeldItem();

        if (heldItem==null){
            return;
        }

        /*
        if(heldItem.getItem() != Blocks.woode){
            return;
        }
        */

        if(heldItem.getItem() != Items.wooden_sword){
            return;
        }
        PotionEffect effect = new PotionEffect(Potion.moveSpeed.getId(),1,10);
        player.addPotionEffect(effect);

    }
}
