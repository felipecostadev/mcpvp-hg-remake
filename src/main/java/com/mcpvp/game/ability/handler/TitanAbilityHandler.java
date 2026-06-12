package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class TitanAbilityHandler extends Ability {

    public TitanAbilityHandler() {
        setName("Titan");
        setIconStack(ItemStack.of(Material.BEDROCK));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.BEDROCK)
                        .setName(Components.miniMessage("<italic:false><color:green>Titan mode</color>"))
                        .build()
        });
    }

}