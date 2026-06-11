package com.mcpvp.core.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class Components {

    public static final Component EMPTY = Component.empty();

    public static final Component SPACE = Component.space();

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    public static final LegacyComponentSerializer LEGACY_AMPERSAND = LegacyComponentSerializer.legacyAmpersand();

    public static Component miniMessage(String input) {
        return MINI_MESSAGE.deserialize(input);
    }

    public static Component legacyAmpersand(String input) {
        return LEGACY_AMPERSAND.deserialize(input);
    }

    public static Component of(String input) {
        return Component.text(input);
    }

}