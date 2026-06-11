package com.mcpvp.game.ability.handler;

import com.mcpvp.game.ability.Ability;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class LauncherAbilityHandler extends Ability {

    public LauncherAbilityHandler() {
        setName("Launcher");
        setIconStack(ItemStack.of(Material.SPONGE));
        setSummary(ObjectList.of("Start with Sponges and use them to", "launch enemies and yourself!"));
    }

}