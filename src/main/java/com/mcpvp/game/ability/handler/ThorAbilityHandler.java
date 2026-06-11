package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.TooltipDisplay;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("UnstableApiUsage")
public final class ThorAbilityHandler extends Ability {

    public ThorAbilityHandler() {
        setName("Thor");
        setIconStack(ItemStack.of(Material.WOODEN_AXE));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.WOODEN_AXE)
                        .setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.ATTRIBUTE_MODIFIERS).build())
                        .setName(Components.miniMessage("<italic:false>Thor Axe"))
                        .build()
        });
        setSummary(ObjectList.of("Call down lightning with your mighty", "axe!"));
    }

}