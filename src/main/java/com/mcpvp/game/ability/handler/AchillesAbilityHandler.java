package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class AchillesAbilityHandler extends Ability {

    public AchillesAbilityHandler() {
        setName("Achilles");
        setIconStack(ItemStack.of(Material.WOODEN_SWORD));
        setSummary(ObjectList.of("Wood weapons do more damage to you while", "non-wood items do less"));
    }

}