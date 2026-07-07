package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class GamblerAbilityHandler extends Ability {

    public GamblerAbilityHandler() {
        setName("Gambler");
        setIconStack(ItemStack.of(Material.STONE_BUTTON));
        setItemStacks(new ItemStack[] {
                ItemStack.of(Material.STONE_BUTTON)
        });
        setSummary(ObjectList.of("Place a button and get a prize. Will it", "help you, or will it hurt you?"));
    }

}