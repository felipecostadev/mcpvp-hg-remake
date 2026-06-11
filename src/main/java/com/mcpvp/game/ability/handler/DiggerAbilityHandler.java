package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class DiggerAbilityHandler extends Ability {

    public DiggerAbilityHandler() {
        setName("Digger");
        setIconStack(ItemStack.of(Material.DRAGON_EGG));
        setSummary(ObjectList.of("Use your digging power to create a", "massive hole!"));
    }

}