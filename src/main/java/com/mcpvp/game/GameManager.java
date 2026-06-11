package com.mcpvp.game;

import com.mcpvp.HungerGames;
import com.mcpvp.player.user.User;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

@Getter
public final class GameManager {

    private final Game game;

    public GameManager(HungerGames plugin) {
        this.game = new Game(this);

        registerRecipes(plugin);
    }

    public void respawnPlayer(Player player, User user) {

    }

    private void registerRecipes(HungerGames plugin) {

        final var result = ItemStack.of(Material.MUSHROOM_STEW);

        final var cactusKey = new NamespacedKey(plugin, "cactus_soup");
        final var cactusSoup = new ShapelessRecipe(cactusKey, result);
        cactusSoup.addIngredient(Material.BOWL);
        cactusSoup.addIngredient(2, Material.CACTUS);

        final var cocoaKey = new NamespacedKey(plugin, "cocoa_soup");
        final var cocoaSoup = new ShapelessRecipe(cocoaKey, result);
        cocoaSoup.addIngredient(Material.BOWL);
        cocoaSoup.addIngredient(Material.COCOA_BEANS);

        final var server = plugin.getServer();
        server.addRecipe(cactusSoup);
        server.addRecipe(cocoaSoup);

    }

}