package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class SwitcherAbilityHandler extends Ability {

    public SwitcherAbilityHandler() {
        setName("Switcher");
        setIconStack(ItemStack.of(Material.SNOWBALL));
        setSummary(ObjectList.of("Switch places with other players and", "mobs by throwing a snowball at them!"));
    }

}