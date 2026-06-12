package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class MonkAbilityHandler extends Ability {

    public MonkAbilityHandler() {
        setName("Monk");
        setIconStack(ItemStack.of(Material.BLAZE_ROD));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.BLAZE_ROD)
                        .setName(Components.miniMessage("<italic:false>Monk Rod"))
                        .build()
        });
    }

}