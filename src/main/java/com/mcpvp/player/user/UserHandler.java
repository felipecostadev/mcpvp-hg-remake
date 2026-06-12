package com.mcpvp.player.user;

import com.github.retrooper.packetevents.PacketEvents;
import com.mcpvp.game.GameManager;

public record UserHandler(UserService userService, GameManager gameManager) implements Runnable {

    @Override
    public void run() {

        final var game = gameManager.getGame();

        if (game == null)
            return;

        final var playerManager = PacketEvents.getAPI().getPlayerManager();

        for (final var user : userService.getUsers()) {

            if (user == null)
                continue;

            final var player = user.getPlayer();

            if (player == null)
                continue;

            user.updateScoreboard(playerManager, game);

        }

    }

}