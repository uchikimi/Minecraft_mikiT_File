package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by uchikimi on 16/02/10.
 */
public class BlockSound extends Block {

    private IIcon[] icons = new IIcon[6];

    public BlockSound() {
        super(Material.tnt);
        setCreativeTab(CreativeTabs.tabDecorations);
        setBlockName(ExampleMod.MODID + "_blocksound");
        setBlockTextureName(ExampleMod.MODID + "soundblock");
        setHardness(3.0F);
        setResistance(30.0F);
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for (int i = 0; i < 6; i++) {
            this.icons[i] = register.registerIcon(textureName + "_" + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return icons[side];
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        if (player == null) {
            return;
        }
        if (player.getHeldItem() == null) {
            return;
        }
        Item item = player.getHeldItem().getItem();
        if (item != Items.stick) {
            return;
        }
        int meta = world.getBlockMetadata(x,y,z);
        world.playSoundAtEntity(player, ExampleMod.MODID + ":" + "sound0" + meta, 0.3f, 1.0f);
        if(world.isRemote){
            String s = Integer.toString(meta + 1);
            player.addChatComponentMessage(new ChatComponentText(s+"番目の曲を流す"));
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ) {
        int meta = world.getBlockMetadata(x, y, z);
        meta = meta + 1;
        if (meta > 2) {
            meta = 0;
        }
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        return true;
    }
}
