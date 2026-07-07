package com.mcpvp.player.listener;

import com.mcpvp.HungerGames;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public final class PlayerSessionListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    private void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {

        HungerGames.getInstance().getUserService().addUser(event.getUniqueId());

    }

}