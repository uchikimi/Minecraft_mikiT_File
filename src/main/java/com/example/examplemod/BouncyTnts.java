package com.example.examplemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * Created by uchikimi on 2015/08/13.
 */

public class BouncyTnts {
    @SubscribeEvent
    public void makeJumpHigher(LivingEvent.LivingJumpEvent event) {
        if (!(event.entity instanceof EntityPlayer)) {
            return;
        }

        if (event.entity.worldObj.getBlock(
                ((int) Math.floor(event.entity.posX)),
                ((int) Math.floor(event.entity.posY)) - 2,
                ((int) Math.floor(event.entity.posZ))) != Blocks.dirt) {
            return;
        }

        event.entity.motionY *=5;
    }
}
