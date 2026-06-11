package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class SurpriseAbilityHandler extends Ability {

    public SurpriseAbilityHandler() {
        setName("Surprise");
        setIconStack(ItemStack.of(Material.NAME_TAG));
        setSummary(ObjectList.of("Receive a random kit from all of our", "kits (even un-owned kits!)"));
    }

}