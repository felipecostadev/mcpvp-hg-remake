package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class FiremanAbilityHandler extends Ability {

    public FiremanAbilityHandler() {
        setName("Fireman");
        setIconStack(ItemStack.of(Material.WATER_BUCKET));
        setItemStacks(new ItemStack[] {
                ItemStack.of(Material.WATER_BUCKET)
        });
        setSummary(ObjectList.of("Immune to fire and lightning damage.", "Start with a bucket of water."));
    }

}