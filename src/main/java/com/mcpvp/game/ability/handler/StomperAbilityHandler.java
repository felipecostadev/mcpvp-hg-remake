package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class StomperAbilityHandler extends Ability {

    public StomperAbilityHandler() {
        setName("Stomper");
        setIconStack(ItemStack.of(Material.IRON_BOOTS));
        setSummary(ObjectList.of("Jump down from high above other players", "to do massive damage to them"));
    }

}