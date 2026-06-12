package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class SwitcherAbilityHandler extends Ability {

    public SwitcherAbilityHandler() {
        setName("Switcher");
        setIconStack(ItemStack.of(Material.SNOWBALL));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.SNOWBALL)
                        .setName(Components.miniMessage("<italic:false>Switcher Ball"))
                        .build()
        });
        setSummary(ObjectList.of("Switch places with other players and", "mobs by throwing a snowball at them!"));
    }

}