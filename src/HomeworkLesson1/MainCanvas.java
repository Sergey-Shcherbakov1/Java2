package HomeworkLesson1;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final MainCircles controller;
    long lastFrameTime;

    MainCanvas(MainCircles controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        long currentFrameTime = System.nanoTime();
        float deltaTime = (lastFrameTime - currentFrameTime) * 0.000000001f;
        lastFrameTime = currentFrameTime;
        controller.onCanvasRepainted (this, graphics, deltaTime);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft () {return 0;}
    public int getRight () {return getWidth()-1;}
    public int getTop () {return 0;}
    public int getBottom () {return getHeight()-1;}


}
