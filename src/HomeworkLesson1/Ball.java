package HomeworkLesson1;

import HomeworkLesson1.MainCanvas;
import HomeworkLesson1.Sprite;

import java.awt.*;

public class Ball extends Sprite {
    private final Color color = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );
    private float velocityX = (float) (Math.random() * 200f + 100f);
    private float velocityY = (float) (Math.random() * 200f + 100f);

    protected Ball() {
        halfWidth = (float) (Math.random() * 50f + 20f);
        halfHeight = halfWidth;
    }

    @Override
    void update(MainCanvas canvas, float deltaTime) {
        x = velocityX * deltaTime + x;
        y = velocityY * deltaTime + y;
        if ( getLeft() < canvas.getLeft() ) {
            setLeft(canvas.getLeft());
            velocityX = -velocityX;
        }
        if ( getRight() > canvas.getRight() ) {
            setRight(canvas.getRight());
            velocityX = -velocityX;
        }
        if ( getTop() < canvas.getTop() ) {
            setTop(canvas.getTop());
            velocityY = -velocityY;
        }
        if ( getBottom() > canvas.getBottom() ) {
            setBottom(canvas.getBottom());
            velocityY = -velocityY;
        }
    }

    @Override
    protected void rendering(MainCanvas canvas, Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
