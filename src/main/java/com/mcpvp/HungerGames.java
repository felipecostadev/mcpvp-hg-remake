package com.mcpvp;

import com.github.retrooper.packetevents.PacketEvents;
import com.mcpvp.game.GameManager;
import com.mcpvp.game.ability.AbilityService;
import com.mcpvp.game.command.AbilityCommand;
import com.mcpvp.game.listener.CompassListener;
import com.mcpvp.game.listener.SoupListener;
import com.mcpvp.game.view.AbilityConfirmView;
import com.mcpvp.game.view.AbilityView;
import com.mcpvp.player.listener.SessionListener;
import com.mcpvp.player.user.UserService;
import dev.despical.commandframework.CommandFramework;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import lombok.Getter;
import me.devnatan.inventoryframework.ViewFrame;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class HungerGames extends JavaPlugin {

    @Getter
    private static HungerGames instance;

    private UserService userService;

    private GameManager gameManager;

    private AbilityService abilityService;

    private CommandFramework commandFramework;

    private ViewFrame viewFramework;

    @Override
    public void onLoad() {

//        getServer().unloadWorld("world", false);
//
//        try {
//
//            FileManager.deleteKeeping(new File("world"), "datapacks");
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();

    }

    @Override
    public void onEnable() {

        PacketEvents.getAPI().init();

        instance = this;

        userService = new UserService();

        gameManager = new GameManager(this);

        abilityService = new AbilityService(this);

        commandFramework = new CommandFramework(this);

        registerCommands(new AbilityCommand());

        viewFramework = ViewFrame.create(this).with(new AbilityView(), new AbilityConfirmView()).register();

        registerEvents(new CompassListener(), new SessionListener(), new SoupListener());

    }

    public void registerCommands(Object... commands) {

        for (final var command : commands)
            commandFramework.registerCommands(command);

    }

    public void registerEvents(Listener... listeners) {

        final var pluginManager = getServer().getPluginManager();

        for (final var listener : listeners)
            pluginManager.registerEvents(listener, this);

    }

    public void sync(Runnable runnable) {
        getServer().getScheduler().runTask(this, runnable);
    }

}