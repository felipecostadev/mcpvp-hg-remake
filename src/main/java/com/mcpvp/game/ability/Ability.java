package com.mcpvp.game.ability;

import com.mcpvp.HungerGames;
import com.mcpvp.game.GameManager;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

@Data
public abstract class Ability implements Listener {

    private String name;

    private boolean enabled;

    private ObjectList<String> summary;

    private ItemStack iconStack;
    private ItemStack[] itemStacks;

    protected GameManager getGameManager(HungerGames plugin) {
        return plugin.getGameManager();
    }

    protected GameManager getGameManager() {
        return getGameManager(HungerGames.getInstance());
    }

    public void sendItemStacks(Player player) {

        if (itemStacks == null)
            return;

        final var inventory = player.getInventory();

        for (final var itemStack : itemStacks) {

            inventory.addItem(itemStack);

        }

    }

}