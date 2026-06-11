package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ViperAbilityHandler extends Ability {

    public ViperAbilityHandler() {
        setName("Viper");
        setIconStack(ItemStack.of(Material.SPIDER_EYE));
        setSummary(ObjectList.of("Every hit you deal has a chance of", "poisoning the other player."));
    }

}