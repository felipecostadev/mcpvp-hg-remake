package com.mcpvp.game;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.Converter;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

@Getter
public final class Game implements Runnable {

    private final GameManager gameManager;

    private GameState state = GameState.LOADING;

    @Setter
    private Location spawnLocation;

    private String formattedTimeOfClock;
    private String formattedTime;

    private int time = -1;

    private boolean forceStart = false;

    public Game(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public boolean hasState(GameState gameState) {
        return this.state == gameState;
    }

    public boolean shouldEndState() {
        return this.time == 0;
    }

    public boolean shouldAnnounce() {

        if (formattedTime == null)
            return false;

        return this.time > 0 && this.time % 60 == 0 || this.time == 30 || this.time == 15 || this.time == 10 || this.time > 0 && this.time <= 5;
    }

    public void updateState() {
        this.state = state.getNextState();
        this.time = state.getTiming();
        this.formattedTime = null;
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

            case LOADING -> {

                this.spawnLocation = new Location(Bukkit.getWorlds().getFirst(), 0.5D, 65, 0.5D);

                updateState();

            }

            case STARTING -> {

                if (shouldEndState()) {
                    updateState();
                    broadcast("<color:red>The Tournament has begun!</color>");
                    broadcast("<color:red>There are " + gameManager.getPlayers().size() + " players participating.</color>");
                    broadcast("<color:red>Everyone is invincible for 2 minutes.</color>");
                    broadcast("<color:red>Good Luck!</color>");
                    return;
                }

                decreaseTime();
                updateTime();

            }

            case INVINCIBILITY -> {

                if (shouldAnnounce()) {
                    broadcast("<color:red>Invincibility wears off in " + formattedTime + ".</color>");
                } else if (shouldEndState()) {
                    updateState();
                    broadcast("<color:red>You are no longer invincible.</color>");
                    return;
                }

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