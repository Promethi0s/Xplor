package com.promethi0s.syk0tik.xplor.components.systems;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.interfaces.Game;
import com.promethi0s.syk0tik.xplor.components.saveData.SaveData;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler.Environment.city;
import static com.promethi0s.syk0tik.xplor.components.interfaces.Game.State.running;

public class Xplor extends Game {

    private Settings settings;
    private SaveData saveData;
    private Screen screen;
    private Graphics graphics;
    private Audio audio;
    private Controls controls;
    private WorkThread workThread;
    private State state;
    private MapHandler mapHandler;

    public Xplor() {

        settings = new Settings();
        saveData = new SaveData();
        controls = new Controls();
        screen = new Screen(settings, controls);
        graphics = new Graphics(settings);
        audio = new Audio();
        mapHandler = new MapHandler(graphics, controls, settings);
        workThread = new WorkThread(this);

    }

    public static void main(String[] args) {

        Xplor xplor = new Xplor();
        xplor.start();

    }

    public void start() {

        state = State.loading;
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

    private void updateLoading() {

        renderLoading();
        graphics.loadPlayer();
        graphics.loadMobs();
        graphics.loadProjectiles();
        graphics.loadCityEnvironment();
        mapHandler.generateMap(city, 64, 64, 16);
        state = running;

    }

    private void updateRunning() {

        controls.update();
        mapHandler.update();

    }

    private void updatePaused() {}

    private void updateGameOver() {}

    private void renderMenu() {}

    private void renderLoading() {}

    private void renderRunning() {

        screen.draw(mapHandler.render());

    }

    private void renderPaused() {}

    private void renderGameOver() {}

}