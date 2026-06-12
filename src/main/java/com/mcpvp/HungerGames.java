package com.mcpvp;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.mcpvp.core.command.TagCommand;
import com.mcpvp.core.util.PacketHolder;
import com.mcpvp.game.GameManager;
import com.mcpvp.game.ability.AbilityService;
import com.mcpvp.game.command.AbilityCommand;
import com.mcpvp.game.listener.CompassListener;
import com.mcpvp.game.listener.SoupListener;
import com.mcpvp.game.view.AbilityConfirmView;
import com.mcpvp.game.view.AbilityView;
import com.mcpvp.player.listener.SessionListener;
import com.mcpvp.player.packet.PacketPlayerRecipeBookCloseListener;
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

    private GameManager gameManager;

    private UserService userService;

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

        final var packetEventsAPI = PacketEvents.getAPI();
        packetEventsAPI.init();

        instance = this;

        userService = new UserService(this, gameManager = new GameManager(this));

        abilityService = new AbilityService(this);

        commandFramework = new CommandFramework(this);

        registerCommands(new AbilityCommand(), new TagCommand());

        viewFramework = ViewFrame.create(this).with(new AbilityView(), new AbilityConfirmView()).register();

        registerEvents(new CompassListener(), new SessionListener(), new SoupListener());

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