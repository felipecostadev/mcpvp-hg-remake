package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class PickpocketAbilityHandler extends Ability {

    public PickpocketAbilityHandler() {
        setName("Pickpocket");
        setIconStack(ItemStack.of(Material.BLAZE_ROD));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.BLAZE_ROD)
                        .setName(Components.miniMessage("<italic:false><color:red>Pocket Browser</color>"))
                        .build()
        });
        setSummary(ObjectList.of("Open other player's inventory and steal", "their items!"));
    }

}