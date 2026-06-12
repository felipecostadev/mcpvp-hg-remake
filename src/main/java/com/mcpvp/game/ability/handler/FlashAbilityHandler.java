package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class FlashAbilityHandler extends Ability {

    public FlashAbilityHandler() {
        setName("Flash");
        setIconStack(ItemStack.of(Material.REDSTONE_TORCH));
        setItemStacks(new ItemStack[] {
                ItemStack.of(Material.REDSTONE_TORCH)
        });
        setSummary(ObjectList.of("Instantly teleport to the location", "you're looking at"));
    }

}