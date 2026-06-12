package com.mcpvp.player.user;

import com.github.retrooper.packetevents.manager.player.PlayerManager;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDisplayScoreboard;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerScoreboardObjective;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerScoreboardObjective.ObjectiveMode;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerScoreboardObjective.RenderType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateScore;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateScore.Action;
import com.mcpvp.core.util.Components;
import com.mcpvp.game.Game;
import com.mcpvp.game.ability.Ability;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Data
public final class User {

    private final UUID uniqueId;

    private Player player;

    private Ability ability;

    private UserState state;

    private boolean scoreboardInitialized = false;

    public User(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void updateScoreboard(PlayerManager packetManager, Game game) {

        final var entry = player.getUniqueId().toString();
        final var state = game.getState();

        if (state.hasScoreboard()) {

            final var title = Components.miniMessage("<color:red>" + state.getNamespace() + game.getFormattedTimeOfClock() + "</color>");

            if (scoreboardInitialized) {

                final var wrapperPlayServerScoreboardObjective = new WrapperPlayServerScoreboardObjective(entry, ObjectiveMode.UPDATE, title, RenderType.INTEGER, null);

                packetManager.sendPacket(player, wrapperPlayServerScoreboardObjective);

            } else {

                final var wrapperPlayServerScoreboardObjective = new WrapperPlayServerScoreboardObjective(entry, ObjectiveMode.CREATE, title, RenderType.INTEGER, null);

                packetManager.sendPacket(player, wrapperPlayServerScoreboardObjective);

                scoreboardInitialized = true;

            }

            final var score = Bukkit.getOnlinePlayers().size();
            final var text = Components.of("Player Count");

            final var wrapperPlayServerDisplayScoreboard = new WrapperPlayServerDisplayScoreboard(1, entry);
            final var wrapperPlayServerUpdateScore = new WrapperPlayServerUpdateScore("sb", Action.CREATE_OR_UPDATE_ITEM, entry, score, text, null);

            packetManager.sendPacket(player, wrapperPlayServerDisplayScoreboard);
            packetManager.sendPacket(player, wrapperPlayServerUpdateScore);

        } else {

            if (!scoreboardInitialized)
                return;

            final var wrapperPlayServerScoreboardObjective = new WrapperPlayServerScoreboardObjective(entry, ObjectiveMode.REMOVE, null, null, null);

            packetManager.sendPacket(player, wrapperPlayServerScoreboardObjective);

            scoreboardInitialized = false;

        }

    }

}