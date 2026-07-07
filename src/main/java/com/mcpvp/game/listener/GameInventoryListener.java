package com.mcpvp.game.listener;

import com.mcpvp.HungerGames;
import com.mcpvp.core.util.ItemBuilder;
import io.papermc.paper.datacomponent.DataComponentTypes;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

@SuppressWarnings("UnstableApiUsage")
public final class GameInventoryListener implements Listener {

    @EventHandler
    private void onPrepareItemCraft(PrepareItemCraftEvent event) {

        final var recipe = event.getRecipe();

        if (recipe == null)
            return;

        final var result = recipe.getResult();
        final var material = result.getType();

        final var inventory = event.getInventory();

        if (material == Material.BROWN_DYE) {
            inventory.setResult(null);
            return;
        }

        if (isSword(material)) {

            final var itemStack = new ItemBuilder(result).setLegacySword().build();

            inventory.setResult(itemStack);

        }

    }

    @EventHandler
    private void onInventoryCreative(InventoryCreativeEvent event) {

        final var cursor = event.getCursor();

        if (!cursor.hasData(DataComponentTypes.BLOCKS_ATTACKS) && isSword(cursor.getType())) {

            final var inventory = event.getWhoClicked().getInventory();

            final var itemStack = new ItemBuilder(cursor).setLegacySword().build();

            HungerGames.getInstance().sync(() -> inventory.setItem(event.getSlot(), itemStack));

        }

    }

    private boolean isSword(Material material) {
        return material == Material.WOODEN_SWORD || material == Material.STONE_SWORD || material == Material.IRON_SWORD || material == Material.DIAMOND_SWORD || material == Material.NETHERITE_SWORD || material == Material.COPPER_SWORD || material == Material.GOLDEN_SWORD;
    }

}