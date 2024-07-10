package com.scouter.netherdepthsupgrade.items;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class NDUArmorMaterials {

    public static final Holder<ArmorMaterial> SOUL_SUCKER = register(
            "soul_sucker",
            Util.make(new EnumMap<>(ArmorItem.Type.class), p_323384_ -> {
                p_323384_.put(ArmorItem.Type.BOOTS, 1);
                p_323384_.put(ArmorItem.Type.LEGGINGS, 2);
                p_323384_.put(ArmorItem.Type.CHESTPLATE, 3);
                p_323384_.put(ArmorItem.Type.HELMET, 1);
                p_323384_.put(ArmorItem.Type.BODY, 3);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            1F, 1F,
            () -> Ingredient.of(NDUItems.SOUL_SUCKER_LEATHER.get()),
            List.of(
                    new ArmorMaterial.Layer(prefix("soul_sucker"), "", false)
            )
    );

    private static Holder<ArmorMaterial> register(
            String pName,
            EnumMap<ArmorItem.Type, Integer> pDefense,
            int pEnchantmentValue,
            Holder<SoundEvent> pEquipSound,
            float pToughness,
            float pKnockbackResistance,
            Supplier<Ingredient> pRepairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(pName)));
        return register(pName, pDefense, pEnchantmentValue, pEquipSound, pToughness, pKnockbackResistance, pRepairIngredient, list);
    }

    private static Holder<ArmorMaterial> register(
            String pName,
            EnumMap<ArmorItem.Type, Integer> pDefense,
            int pEnchantmentValue,
            Holder<SoundEvent> pEquipSound,
            float pToughness,
            float pKnockbackResistance,
            Supplier<Ingredient> pRepairIngridient,
            List<ArmorMaterial.Layer> pLayers
    ) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
            enummap.put(armoritem$type, pDefense.get(armoritem$type));
        }

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                ResourceLocation.fromNamespaceAndPath(NetherDepthsUpgrade.MODID,pName),
                new ArmorMaterial(enummap, pEnchantmentValue, pEquipSound, pRepairIngridient, pLayers, pToughness, pKnockbackResistance)
        );
    }
}
