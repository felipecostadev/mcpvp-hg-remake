package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class HermitAbilityHandler extends Ability {

    public HermitAbilityHandler() {
        setName("Hermit");
        setIconStack(ItemStack.of(Material.MUSHROOM_STEW));
        setSummary(ObjectList.of("When the game begins, you start at", "places you want to be!"));
    }

}