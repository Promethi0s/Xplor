package com.promethi0s.syk0tik.xplor.components.systems;

/*
** WorkThread is responsible for looping while running, calling
** Xplor.update every 1/60 of a second, and calling Xplor.render as
** many times as possible. It will log to the console if ups or fps
** ever drops below 50 times per second.
 */
public class WorkThread implements Runnable {


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
        double ns = 1000000000.0 / 45.0;
        double delta = 0;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;

        // Start game loop
        while (running) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {

                stateHandler.update();
                updates++;
                stateHandler.render();
                frames++;
                delta = 0;

            }

            // Log if frames or updates drop below 50
            if (System.currentTimeMillis() - timer >= 1000) {

                timer += 1000;
                if (frames < 30) System.out.println("Frames low!");
                if (updates < 30) System.out.println("Updates low!");
                frames = 0;
                updates = 0;

            }

        }
    }
}
