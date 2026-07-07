package com.mcpvp.game.listener;

import com.mcpvp.HungerGames;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class GameSessionListener implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {

        final var plugin = HungerGames.getInstance();

        final var gameManager = plugin.getGameManager();
        final var game = gameManager.getGame();

        final var player = event.getPlayer();
        final var user = plugin.getUserService().getUser(player);

        if (gameManager.isSpectator(player)) {
            gameManager.joinSpectator();
        } else {
            gameManager.joinPlayer(player, user, game);
        }

    }

}