package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CamelAbilityHandler extends Ability {

    public CamelAbilityHandler() {
        setName("Camel");
        setIconStack(ItemStack.of(Material.POTION));
        setSummary(ObjectList.of("The desert is your home, giving you an", "advantage in deserts"));
    }

}