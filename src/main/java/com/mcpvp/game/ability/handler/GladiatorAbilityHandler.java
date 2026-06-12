package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class GladiatorAbilityHandler extends Ability {

    public GladiatorAbilityHandler() {
        setName("Gladiator");
        setIconStack(ItemStack.of(Material.IRON_BARS));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.IRON_BARS)
                        .setName(Components.miniMessage("<italic:false><color:red>Start Shadow Game</color>"))
                        .build()
        });
    }

}