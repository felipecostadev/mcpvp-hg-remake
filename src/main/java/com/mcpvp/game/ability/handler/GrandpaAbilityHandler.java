package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class GrandpaAbilityHandler extends Ability {

    public GrandpaAbilityHandler() {
        setName("Grandpa");
        setIconStack(ItemStack.of(Material.STICK));
        setSummary(ObjectList.of("Start with knockback 2 wooden stick."));
    }

}