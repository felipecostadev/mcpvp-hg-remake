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
public final class SpecialistAbilityHandler extends Ability {

    public SpecialistAbilityHandler() {
        setName("Specialist");
        setIconStack(ItemStack.of(Material.EXPERIENCE_BOTTLE));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.WRITTEN_BOOK)
                        .setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.WRITTEN_BOOK_CONTENT).build())
                        .setName(Components.miniMessage("<italic:false>Enchantment Tome"))
                        .build()
        });
        setSummary(ObjectList.of("Gain double experience, experience from", "killing and a portable enchantment table"));
    }

}