package com.scouter.netherdepthsupgrade.items;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class SoulSuckerArmorItem extends ArmorItem {
    public SoulSuckerArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player pPlayer) {
        pLevel.registryAccess().registry(Registries.ENCHANTMENT).ifPresent(e -> {
            e.getHolder(Enchantments.SOUL_SPEED).ifPresent(d -> {
                pStack.enchant(d, 3);
            });
        });

    }
}
