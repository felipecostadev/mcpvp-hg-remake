package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ChameleonAbilityHandler extends Ability {

    public ChameleonAbilityHandler() {
        setName("Chameleon");
        setIconStack(ItemStack.of(Material.WHEAT));
        setSummary(ObjectList.of("Get mobs items, and hold the mob item to", "look like it!"));
    }

}