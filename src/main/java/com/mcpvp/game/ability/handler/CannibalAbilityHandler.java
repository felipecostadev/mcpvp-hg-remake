package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CannibalAbilityHandler extends Ability {

    public CannibalAbilityHandler() {
        setName("Cannibal");
        setIconStack(ItemStack.of(Material.OCELOT_SPAWN_EGG));
        setSummary(ObjectList.of("Damage done is food for you, they have", "Hunger effect when hit."));
    }

}