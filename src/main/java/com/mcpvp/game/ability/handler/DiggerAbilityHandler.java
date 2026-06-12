package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class DiggerAbilityHandler extends Ability {

    public DiggerAbilityHandler() {
        setName("Digger");
        setIconStack(ItemStack.of(Material.DRAGON_EGG));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.DRAGON_EGG)
                        .setName(Components.miniMessage("<italic:false><color:white>Digger Egg</color>"))
                        .build()
        });
        setSummary(ObjectList.of("Use your digging power to create a", "massive hole!"));
    }

}