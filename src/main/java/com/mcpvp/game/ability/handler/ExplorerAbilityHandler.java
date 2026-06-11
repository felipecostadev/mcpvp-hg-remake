package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ExplorerAbilityHandler extends Ability {

    public ExplorerAbilityHandler() {
        setName("Explorer");
        setIconStack(ItemStack.of(Material.MAP));
        setSummary(ObjectList.of("Get a map that reveals everything you", "want to know!"));
    }

}