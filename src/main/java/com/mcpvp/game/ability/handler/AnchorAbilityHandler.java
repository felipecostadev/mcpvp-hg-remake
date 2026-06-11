package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class AnchorAbilityHandler extends Ability {

    public AnchorAbilityHandler() {
        setName("Anchor");
        setIconStack(ItemStack.of(Material.IRON_BLOCK));
        setSummary(ObjectList.of("Take no knockback and deal no knockback"));
    }

}