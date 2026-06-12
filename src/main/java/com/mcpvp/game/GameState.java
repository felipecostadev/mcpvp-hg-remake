package com.mcpvp.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GameState {

    LOADING(),

    STARTING("Starting In ", 60),

    INVINCIBILITY("Invincible for ", 120),

    MIDDLE_GAME(120),

    ENDGAME(30);

    private final String namespace;

    private final int timing;

    GameState() {
        this(null, -1);
    }

    GameState(int timing) {
        this(null, timing);
    }

    public boolean hasScoreboard() {
        return this.namespace != null;
    }

    public GameState getNextState() {
        return this == ENDGAME ? ENDGAME : values()[ordinal() + 1];
    }

}