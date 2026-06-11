package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class SpyAbilityHandler extends Ability {

    public SpyAbilityHandler() {
        setName("Spy");
        setIconStack(ItemStack.of(Material.COMPASS));
        setSummary(ObjectList.of("Compass gives exact coords, get alerted", "of nearby players."));
    }

}