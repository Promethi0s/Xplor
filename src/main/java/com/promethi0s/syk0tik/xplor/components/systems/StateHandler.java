package com.promethi0s.syk0tik.xplor.components.systems;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.interfaces.Game;
import com.promethi0s.syk0tik.xplor.components.saveData.SaveData;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler.Environment.city;
import static com.promethi0s.syk0tik.xplor.components.interfaces.Game.State.running;
import static com.promethi0s.syk0tik.xplor.components.systems.Controls.controls;

// Handles the overall state of the game, manages the WorkThread and IO.
public class StateHandler extends Game {

    private Settings settings;
    private SaveData saveData;
    private Screen screen;
    private Graphics graphics;
    private Audio audio;
    private WorkThread workThread;
    private State state;
    private MapHandler mapHandler;

    public StateHandler() {

        settings = new Settings();
        saveData = new SaveData();
        controls = new Controls();
        screen = new Screen(settings);
        graphics = new Graphics(settings);
        audio = new Audio();
        mapHandler = new MapHandler(graphics, settings);
        workThread = new WorkThread(this);

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

    public void draw() {

        graphics.clear();

        if (state == State.menu) drawMenu();
        if (state == State.loading) drawLoading();
        if (state == State.running) drawRunning();
        if (state == State.paused) drawPaused();
        if (state == State.gameOver) drawGameOver();

    }

    private void updateMenu() {}

    private void updateLoading() {

        drawLoading();
        graphics.loadPlayer();
        graphics.loadMobs();
        graphics.loadProjectiles();
        graphics.loadCityEnvironment();
        mapHandler.generateMap(city, 64, 64, 32);
        state = running;

    }

    private void updateRunning() {

        controls.update();
        mapHandler.update();
        screen.title = "Xplor! FPS: " + workThread.fps;

    }

    private void updatePaused() {}

    private void updateGameOver() {}

    private void drawMenu() {
    }

    private void drawLoading() {
    }

    private void drawRunning() {

        screen.draw(mapHandler.render());

    }

    private void drawPaused() {
    }

    private void drawGameOver() {
    }

}