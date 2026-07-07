package com.mcpvp.game;

import com.mcpvp.HungerGames;
import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.player.user.User;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.UUID;

@Getter
public final class GameManager {

    private final Game game;

    private final ObjectArrayList<UUID> players = new ObjectArrayList<>();
    private final ObjectArrayList<UUID> spectators = new ObjectArrayList<>();

    public GameManager(HungerGames plugin) {
        plugin.syncTimer(this.game = new Game(this), 20L, 20L);

        registerRecipes(plugin);
    }

    public boolean isPlayer(Player player) {
        return players.contains(player.getUniqueId());
    }

    public boolean isSpectator(Player player) {
        return spectators.contains(player.getUniqueId());
    }

    public void joinPlayer(Player player, User user, Game game) {

        switch (game.getState()) {

            case STARTING -> {

                players.add(player.getUniqueId());

                reloadPlayer(player);

                player.teleport(game.getSpawnLocation());

                user.setPlayer(player);

            }

        }

    }

    public void joinSpectator() {

    }

    public void respawnPlayer(Player player, User user) {

    }

    private void reloadPlayer(Player player) {

        final var inventory = player.getInventory();
        inventory.setHeldItemSlot(0);
        inventory.clear();

        final var attribute = player.getAttribute(Attribute.ATTACK_SPEED);

        if (attribute != null)
            attribute.setBaseValue(1024.0D);

        player.setCooldown(Material.ENDER_PEARL, 0);

    }

    private void registerRecipes(HungerGames plugin) {

        final var cactusResult = new ItemBuilder(Material.MUSHROOM_STEW).setName(Components.miniMessage("<italic:false>Cactus Soup")).build();
        final var cactusKey = new NamespacedKey(plugin, "cactus_soup");
        final var cactusSoup = new ShapelessRecipe(cactusKey, cactusResult);
        cactusSoup.addIngredient(Material.BOWL);
        cactusSoup.addIngredient(2, Material.CACTUS);

        final var cocoaResult = new ItemBuilder(Material.MUSHROOM_STEW).setName(Components.miniMessage("<italic:false>Chocolate Milk")).build();
        final var cocoaKey = new NamespacedKey(plugin, "cocoa_soup");
        final var cocoaSoup = new ShapelessRecipe(cocoaKey, cocoaResult);
        cocoaSoup.addIngredient(Material.BOWL);
        cocoaSoup.addIngredient(Material.COCOA_BEANS);

        final var server = plugin.getServer();
        server.addRecipe(cactusSoup);
        server.addRecipe(cocoaSoup);

    }

}