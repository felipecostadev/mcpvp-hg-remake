package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class NoneAbilityHandler extends Ability {

    public NoneAbilityHandler() {
        setName("None");
        setIconStack(ItemStack.of(Material.CHEST));
    }

}