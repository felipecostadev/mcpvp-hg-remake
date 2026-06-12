package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.TooltipDisplay;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("UnstableApiUsage")
public final class FishermanAbilityHandler extends Ability {

    public FishermanAbilityHandler() {
        setName("Fisherman");
        setIconStack(ItemStack.of(Material.FISHING_ROD));
        setSummary(ObjectList.of("Start the game with a fishing rod that", "can reel in players."));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.FISHING_ROD)
                        .setUnbreakable(true)
                        .setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.UNBREAKABLE).build())
                        .build()
        });
    }

}