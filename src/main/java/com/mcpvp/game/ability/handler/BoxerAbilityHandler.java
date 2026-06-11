package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class BoxerAbilityHandler extends Ability {

    public BoxerAbilityHandler() {
        setName("Boxer");
        setIconStack(ItemStack.of(Material.STONE_SWORD));
        setSummary(ObjectList.of("Fists do almost as much damage as stone", "sword; Incoming damage slightly reduced."));
    }

}