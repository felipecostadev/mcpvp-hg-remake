package com.mcpvp.player.user;

import com.github.retrooper.packetevents.PacketEvents;
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

    public User(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void updateScoreboard(Game game) {

        final var score = Bukkit.getOnlinePlayers().size();
        final var text = Components.of("Player Count");

        final var entry = player.getUniqueId().toString();
        final var title = Components.miniMessage("<color:red>Starting In 3:00</color>");

        final var wrapperPlayServerScoreboardObjective = new WrapperPlayServerScoreboardObjective(entry, ObjectiveMode.CREATE, title, RenderType.INTEGER, null);
        final var wrapperPlayServerDisplayScoreboard = new WrapperPlayServerDisplayScoreboard(1, entry);
        final var wrapperPlayServerUpdateScore = new WrapperPlayServerUpdateScore("sb", Action.CREATE_OR_UPDATE_ITEM, entry, score, text, null);

        final var packetManager = PacketEvents.getAPI().getPlayerManager();
        packetManager.sendPacket(player, wrapperPlayServerScoreboardObjective);
        packetManager.sendPacket(player, wrapperPlayServerDisplayScoreboard);
        packetManager.sendPacket(player, wrapperPlayServerUpdateScore);

    }

}