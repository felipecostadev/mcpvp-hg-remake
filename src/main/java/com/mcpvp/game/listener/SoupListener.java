package com.mcpvp.game.listener;

import com.mcpvp.HungerGames;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public final class SoupListener implements Listener {

    private final ItemStack RESULT_ACTION = new ItemStack(Material.BOWL);

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getHand() == EquipmentSlot.OFF_HAND)
            return;

        if (!event.getAction().isRightClick())
            return;

        final var item = event.getItem();

        if (item == null || item.getType() != Material.MUSHROOM_STEW)
            return;

        final var game = HungerGames.getInstance().getGameManager().getGame();

        if (game == null)
            return;

        event.setCancelled(true);

        final var player = event.getPlayer();
        final var attribute = player.getAttribute(Attribute.MAX_HEALTH);

        final var health = player.getHealth();
        final var maxHealth = attribute != null ? attribute.getValue() : 20.0D;

        final var food = player.getFoodLevel();
        final var maxFood = 20;

        var changeItemInMainHand = false;

        if (health < maxHealth) {

            var heal = health + 7.0D;

            if (heal > maxHealth)
                heal = maxHealth;

            player.setHealth(heal);

            changeItemInMainHand = true;

        } else if (food < maxFood) {

            var satiate = food + 7;

            if (satiate > maxFood)
                satiate = maxFood;

            player.setFoodLevel(satiate);
            player.setSaturation(satiate);

            changeItemInMainHand = true;

        }

        if (changeItemInMainHand)
            player.getInventory().setItemInMainHand(RESULT_ACTION);

    }

}