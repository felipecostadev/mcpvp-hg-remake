package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class BarbarianAbilityHandler extends Ability {

    public BarbarianAbilityHandler() {
        setName("Barbarian");
        setIconStack(ItemStack.of(Material.WOODEN_SWORD));
        setSummary(ObjectList.of("Start the game with a sword that levels", "up every time you kill someone."));
    }

}