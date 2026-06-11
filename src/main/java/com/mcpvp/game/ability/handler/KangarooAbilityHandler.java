package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.TooltipDisplay;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("UnstableApiUsage")
public final class KangarooAbilityHandler extends Ability {

    public KangarooAbilityHandler() {
        setName("Kangaroo");
        setIconStack(ItemStack.of(Material.FIREWORK_ROCKET));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.FIREWORK_ROCKET)
                        .setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.FIREWORKS).build())
                        .setName(Components.miniMessage("<italic:false><color:gold>Double-Jump Rocket</color>"))
                        .build()
        });
        setSummary(ObjectList.of("Start with a rocket that enables you to", "double-jump!"));
    }

}