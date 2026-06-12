package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class TimelordAbilityHandler extends Ability {

    public TimelordAbilityHandler() {
        setName("Timelord");
        setIconStack(ItemStack.of(Material.CLOCK));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.CLOCK)
                        .setName(Components.miniMessage("<italic:false><color:red>The Pocket Watch of Blood</color>"))
                        .build()
        });
        setSummary(ObjectList.of("Right click your watch to freeze time", "around you, trapping your enemies!"));
    }

}