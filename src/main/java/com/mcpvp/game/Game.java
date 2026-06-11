package com.mcpvp.game;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.Converter;
import lombok.Getter;
import org.bukkit.Bukkit;

@Getter
public final class Game implements Runnable {

    private final GameManager gameManager;

    private GameState state = GameState.LOADING;

    private String formattedTimeOfClock;
    private String formattedTime;

    private int time;

    private boolean forceStart = false;

    public Game(GameManager gameManager) {
        this.gameManager = gameManager;

        updateState();
    }

    public boolean hasState(GameState gameState) {
        return this.state == gameState;
    }

    public boolean shouldEndState() {
        return this.time == 0;
    }

    public boolean shouldTrigger() {
        return this.time % 60 == 0 || this.time == 45 || this.time == 30 || this.time == 15 || this.time == 10 || this.time > 0 && this.time <= 5;
    }

    public void updateState() {
        this.state = state.getNextState();
        this.time = state.getTiming();
    }

    public void updateTime() {
        this.formattedTimeOfClock = Converter.formatAsClock(time);
        this.formattedTime = Converter.formatAsTime(time);
    }

    public void increaseTime() {
        this.time++;
    }

    public void decreaseTime() {
        this.time--;
    }

    public void forceStart() {
        this.forceStart = true;
        this.time = 0;
    }

    public void broadcast(String input) {
        Bukkit.broadcast(Components.miniMessage(input));
    }

    @Override
    public void run() {

        switch (state) {

            case STARTING -> {

                if (shouldTrigger()) {
                    broadcast("<color:red>Invincibility wears off in " + formattedTime + ".</color>");
                } else if (shouldEndState()) {
                    updateState();
                    broadcast("<color:red>You are no longer invincible.</color>");
                    return;
                }

                decreaseTime();
                updateTime();

            }

            case INVINCIBILITY -> {
                decreaseTime();
                updateTime();
            }

            case MIDDLE_GAME -> {
                increaseTime();
                updateTime();
            }

        }

    }

}