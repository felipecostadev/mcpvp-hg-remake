package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.TooltipDisplay;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("UnstableApiUsage")
public final class BarbarianAbilityHandler extends Ability {

    public BarbarianAbilityHandler() {
        setName("Barbarian");
        setIconStack(
                new ItemBuilder(Material.WOODEN_SWORD)
                        .setDamage(58)
                        .build()
        );
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.WOODEN_SWORD)
                        .addEnchantment(Enchantment.EFFICIENCY, 1000)
                        .setDamage(58)
                        .setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.ATTRIBUTE_MODIFIERS).build())
                        .setName(Components.miniMessage("<italic:false><color:red>Tyrfing</color>"))
                        .build()
        });
        setSummary(ObjectList.of("Start the game with a sword that levels", "up every time you kill someone."));
    }

}