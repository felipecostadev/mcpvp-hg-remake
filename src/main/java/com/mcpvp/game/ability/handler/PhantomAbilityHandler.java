package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class PhantomAbilityHandler extends Ability {

    public PhantomAbilityHandler() {
        setName("Phantom");
        setIconStack(ItemStack.of(Material.FEATHER));
        setItemStacks(new ItemStack[] {
                ItemStack.of(Material.FEATHER)
        });
        setSummary(ObjectList.of("Use a feather on the ground to get a", "temporary flight ability"));
    }

}