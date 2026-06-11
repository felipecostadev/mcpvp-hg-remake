package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ThermoAbilityHandler extends Ability {

    public ThermoAbilityHandler() {
        setName("Thermo");
        setIconStack(ItemStack.of(Material.DAYLIGHT_DETECTOR));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.DAYLIGHT_DETECTOR)
                        .setName(Components.miniMessage("<italic:false>Transmutation Tablet"))
                        .build()
        });
        setSummary(ObjectList.of("Turn liquids to their counterpart"));
    }

}