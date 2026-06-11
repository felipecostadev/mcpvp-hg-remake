package com.mcpvp.player.listener;

import com.mcpvp.player.user.User;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class SessionListener implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {

        final var player = event.getPlayer();
        final var attribute = player.getAttribute(Attribute.ATTACK_SPEED);

        if (attribute != null)
            attribute.setBaseValue(1024.0D);

        player.setCooldown(Material.ENDER_PEARL, 0);

        final var user = new User(player.getUniqueId());
        user.setPlayer(player);

        user.updateScoreboard(null);

    }

}