package com.mcpvp.core.command;

import com.mcpvp.core.enums.Tag;
import com.mcpvp.core.util.Components;
import dev.despical.commandframework.CommandArguments;
import dev.despical.commandframework.annotations.Command;
import dev.despical.commandframework.annotations.Command.SenderType;
import org.bukkit.entity.Player;

public final class TagCommand {

    @Command(name = "tag", senderType = SenderType.PLAYER)
    public void execute(CommandArguments commandArguments) {

        final var args = commandArguments.getArguments();

        if (args.length == 1) {

            final var tag = Tag.equalsOf(args[0]);

            if (tag != null) {

                final var player = (Player) commandArguments.getSender();

                final var hex = tag.getHex(player.getName());

                player.playerListName(hex);
                player.displayName(hex);

                commandArguments.sendMessage(Components.miniMessage("<color:green>Success! You now look like a " + tag.getName() + "</color>"));

                return;

            }

        }

        commandArguments.sendMessage(Components.miniMessage("<color:red>Wrong syntax! Use /tag [normal | vip | mvp | pro | youtuber | mod]</color>"));

    }

}