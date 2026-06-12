package com.mcpvp.core.enums;

import com.mcpvp.core.util.Components;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;

@RequiredArgsConstructor
public enum Tag {

    MOD("Mod", "<italic:true><color:dark_purple>", ObjectList.of()),

    YOUTUBER("Youtuber", "<color:aqua>", ObjectList.of("yt")),

    PRO("Pro", "<color:gold>", ObjectList.of()),
    MVP("Mvp", "<color:blue>", ObjectList.of()),
    VIP("Vip", "<color:green>", ObjectList.of()),

    NORMAL("Normal", "<color:white>", ObjectList.of());

    @Getter
    private final String name;

    private final String hex;

    private final ObjectList<String> aliases;

    public Component getHex(String entry) {
        return Components.miniMessage(hex + entry + "</color>");
    }

    public static Tag equalsOf(String name) {

        for (final var tag : values()) {

            if (tag.name.equalsIgnoreCase(name))
                return tag;

            final var aliases = tag.aliases;

            if (!aliases.isEmpty()) {

                for (final var alias : aliases) {

                    if (alias.equalsIgnoreCase(name))
                        return tag;

                }

            }

        }

        return null;

    }

}