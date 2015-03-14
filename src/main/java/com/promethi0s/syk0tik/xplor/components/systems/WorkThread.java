package com.promethi0s.syk0tik.xplor.components.systems;

/*
** WorkThread is responsible for looping while running, calling
** Xplor.update every 1/60 of a second, and calling Xplor.draw as
** many times as possible. It will log to the console if ups or fps
** ever drops below 50 times per second.
 */
public class WorkThread implements Runnable {


    public static long updateTimer;
    public String fps = "...";
    private StateHandler stateHandler;
    private Thread thread;
    private boolean running;

    public WorkThread(StateHandler stateHandler) {

        this.stateHandler = stateHandler;

    }

    public void start() {

        running = true;
        thread = new Thread(this, "Xplor");
        thread.start();

    }

    public void stop() {

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        // Initialize timing variables
        double ns = 1000000000.0 / 60.0;
        double delta = 0;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int frames = 0;
        updateTimer = 0;

        // Start game loop
        while (running) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {

                stateHandler.update();
                updateTimer++;
                stateHandler.draw();
                frames++;
                delta--;

            }

            // Log if frames or updates drop below 50
            if (System.currentTimeMillis() - timer >= 1000) {

                timer += 1000;
                fps = Integer.toString(frames);
                frames = 0;

            }

        }
    }
}
