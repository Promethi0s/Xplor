package com.promethi0s.syk0tik.xplor.components.systems;

import com.promethi0s.syk0tik.xplor.components.gameData.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.EntityMap;
import com.promethi0s.syk0tik.xplor.components.gameData.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.entities.mobileEntities.Player;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.interfaces.Game;
import com.promethi0s.syk0tik.xplor.components.saveData.SaveData;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

public class Xplor extends Game {

    private Settings settings;
    private SaveData saveData;
    private Screen screen;
    private Graphics graphics;
    private Audio audio;
    private Controls controls;
    private WorkThread workThread;
    private State state;
    private Map map;
    private Player player;
    private EntityMap entities;
    private Coordinates viewOffset;

    public Xplor() {

        settings = new Settings();
        saveData = new SaveData();
        controls = new Controls();
        screen = new Screen(settings, controls);
        graphics = new Graphics(settings);
        audio = new Audio();
        workThread = new WorkThread(this);

    }

    public static void main(String[] args) {

        Xplor xplor = new Xplor();
        xplor.start();

    }

    public void start() {

        graphics.loadCityEnvironment();
        graphics.loadPlayer();
        map = new Map(64, 64, 16);
        viewOffset = new Coordinates(0, 0);
        player = new Player(17, 17, 2, viewOffset, settings, map, entities);
        state = State.running;
        workThread.start();

    }

    public void pause() {

        state = State.paused;

    }

    public void stop() {

        workThread.stop();

    }

    // Assigns update method based on state.
    public void update() {

        if (state == State.menu) updateMenu();
        if (state == State.loading) updateLoading();
        if (state == State.running) updateRunning();
        if (state == State.paused) updatePaused();
        if (state == State.gameOver) updateGameOver();

    }

    public void render() {

        graphics.clear();

        if (state == State.menu) renderMenu();
        if (state == State.loading) renderLoading();
        if (state == State.running) renderRunning();
        if (state == State.paused) renderPaused();
        if (state == State.gameOver) renderGameOver();

    }

    private void updateMenu() {}

    private void updateLoading() {}

    private void updateRunning() {

        controls.update();
        player.update(controls);
        entities.update(map, player);

    }

    private void updatePaused() {}

    private void updateGameOver() {}

    private void renderMenu() {}

    private void renderLoading() {}

    private void renderRunning() {

        screen.render(graphics.renderRunning(map, player, entities, viewOffset));

    }

    private void renderPaused() {}

    private void renderGameOver() {}

}