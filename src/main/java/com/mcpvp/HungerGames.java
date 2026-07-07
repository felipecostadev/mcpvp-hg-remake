package com.mcpvp;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.mcpvp.core.command.TagCommand;
import com.mcpvp.core.util.FileManager;
import com.mcpvp.core.util.PacketHolder;
import com.mcpvp.game.GameManager;
import com.mcpvp.game.ability.AbilityService;
import com.mcpvp.game.command.AbilityCommand;
import com.mcpvp.game.listener.*;
import com.mcpvp.game.view.AbilityConfirmView;
import com.mcpvp.game.view.AbilityView;
import com.mcpvp.player.listener.NatureListener;
import com.mcpvp.player.listener.PlayerSessionListener;
import com.mcpvp.player.packet.PacketPlayerRecipeBookCloseListener;
import com.mcpvp.player.user.UserService;
import dev.despical.commandframework.CommandFramework;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import lombok.Getter;
import me.devnatan.inventoryframework.ViewFrame;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public final class HungerGames extends JavaPlugin {

    @Getter
    private static HungerGames instance;

    private GameManager gameManager;

    private UserService userService;

    private AbilityService abilityService;

    private CommandFramework commandFramework;

    private ViewFrame viewFramework;

    @Override
    public void onLoad() {

        getServer().unloadWorld("world", false);

        var foundWorld = false;

        try {

            final var worldPath = new File("world").toPath();

            FileManager.delete(worldPath);

            final var mapFolder = new File("C:\\Users\\Pichau\\Desktop\\rededojo.com\\maps");
            final var mapFiles = mapFolder.listFiles(File::isDirectory);

            if (mapFiles == null || mapFiles.length == 0) {
                Bukkit.shutdown();
                return;
            }

            final var mapFile = mapFiles[ThreadLocalRandom.current().nextInt(mapFiles.length)];

            FileManager.copy(mapFile.toPath(), worldPath);

            foundWorld = true;

        } catch (Exception e) {
        }

        if (!foundWorld) {
            Bukkit.shutdown();
            return;
        }

        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();

    }

    @Override
    public void onEnable() {

        final var packetEventsAPI = PacketEvents.getAPI();
        packetEventsAPI.init();

        instance = this;

        userService = new UserService(this, gameManager = new GameManager(this));

        abilityService = new AbilityService(this);

        commandFramework = new CommandFramework(this);

        registerCommands(new AbilityCommand(), new TagCommand());

        viewFramework = ViewFrame.create(this).with(new AbilityView(), new AbilityConfirmView()).register();

        registerEvents(new BlockListener(), new WorldListener(), new CompassListener(), new GameSessionListener(), new PlayerSessionListener(), new NatureListener(), new SoupListener());

        registerPackets(packetEventsAPI, new PacketHolder(new PacketPlayerRecipeBookCloseListener(), PacketListenerPriority.NORMAL));

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

    private void registerPackets(PacketEventsAPI<?> packetEventsAPI, PacketHolder... packets) {

        final var eventManager = packetEventsAPI.getEventManager();

        for (final var packet : packets)
            eventManager.registerListener(packet.listener(), packet.priority());

    }

    public void registerPackets(PacketHolder... packets) {
        registerPackets(PacketEvents.getAPI(), packets);
    }

    public void sync(Runnable runnable) {
        getServer().getScheduler().runTask(this, runnable);
    }

    public void syncTimer(Runnable runnable, long delay, long period) {
        getServer().getScheduler().runTaskTimer(this, runnable, delay, period);
    }

}