package com.example.item;

import com.example.TemplateMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DX_KUMA = registerItem("dx_kuma", new Item(new Item.Settings().food(ModFoodComponents.DX_KUMA)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TemplateMod.LOGGER.info("Registering Mod items for" + TemplateMod.MOD_ID);

        //This adds item to "ingredients" tab of creative mode
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(DX_KUMA);
        });

    }

}
