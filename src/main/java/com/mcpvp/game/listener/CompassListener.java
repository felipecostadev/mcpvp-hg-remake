package com.mcpvp.game.listener;

import com.mcpvp.HungerGames;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class CompassListener implements Listener {

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getAction() == Action.PHYSICAL)
            return;

        final var item = event.getItem();

        if (item == null || item.getType() != Material.COMPASS)
            return;

        final var game = HungerGames.getInstance().getGameManager().getGame();

        if (game == null)
            return;


    }

}