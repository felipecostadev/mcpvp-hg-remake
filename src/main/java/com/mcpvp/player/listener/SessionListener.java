package com.mcpvp.player.listener;

import com.mcpvp.HungerGames;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public final class SessionListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    private void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {

        HungerGames.getInstance().getUserService().addUser(event.getUniqueId());

    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {

        final var player = event.getPlayer();
        final var attribute = player.getAttribute(Attribute.ATTACK_SPEED);

        if (attribute != null)
            attribute.setBaseValue(1024.0D);

        player.setCooldown(Material.ENDER_PEARL, 0);

        final var user = HungerGames.getInstance().getUserService().getUser(player);
        user.setPlayer(player);

    }

}