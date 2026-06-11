package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class GrapplerAbilityHandler extends Ability {

    public GrapplerAbilityHandler() {
        setName("Grappler");
        setIconStack(ItemStack.of(Material.LEAD));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.LEAD)
                        .setName(Components.miniMessage("<italic:false><color:red>Grappling Hook</color>"))
                        .build()
        });
        setSummary(ObjectList.of("Hook yourself onto terrain, mobs or", "players and pull yourself towards them"));
    }

}