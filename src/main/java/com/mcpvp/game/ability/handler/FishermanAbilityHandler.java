package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class FishermanAbilityHandler extends Ability {

    public FishermanAbilityHandler() {
        setName("Fisherman");
        setIconStack(ItemStack.of(Material.FISHING_ROD));
        setSummary(ObjectList.of("Start the game with a fishing rod that", "can reel in players."));
    }

}