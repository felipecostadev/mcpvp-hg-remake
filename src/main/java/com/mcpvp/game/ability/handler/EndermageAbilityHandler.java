package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("UnstableApiUsage")
public final class EndermageAbilityHandler extends Ability {

    public EndermageAbilityHandler() {
        setName("Endermage");
        setIconStack(
                new ItemBuilder(Material.ACACIA_FENCE)
                        .setData(DataComponentTypes.ITEM_MODEL, Key.key("minecraft:item/portal"))
                        .build()
        );
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.ACACIA_FENCE)
                        .setData(DataComponentTypes.ITEM_MODEL, Key.key("minecraft:item/portal"))
                        .setName(Components.miniMessage("<italic:false>Portal"))
                        .build()
        });
        setSummary(ObjectList.of("Summon a portal to drag you and the", "people above or below to that spot"));
    }

}