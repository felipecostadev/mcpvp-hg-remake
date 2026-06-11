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
public final class MinerAbilityHandler extends Ability {

    public MinerAbilityHandler() {
        setName("Miner");
        setIconStack(ItemStack.of(Material.STONE_PICKAXE));
        setItemStacks(new ItemStack[] {
                new ItemBuilder(Material.STONE_PICKAXE)
                        .addEnchantment(Enchantment.EFFICIENCY, 2)
                        .addEnchantment(Enchantment.UNBREAKING, 1)
                        .setUnbreakable(true)
                        .setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.ATTRIBUTE_MODIFIERS, DataComponentTypes.UNBREAKABLE).build())
                        .setName(Components.miniMessage("<italic:false><color:white><b>Miner Pickaxe</b></color>"))
                        .build(),

                ItemStack.of(Material.APPLE, 5)
        });
        setSummary(ObjectList.of("Start with a pick. Eat an apple while", "full to get a mining speed boost."));
    }

}