package HomeworkLesson1;

import java.awt.*;


public class Background {
    private MainCircles controlColor;

    Background(MainCircles controlColor) {
        this.controlColor = controlColor;
    }

    public void bgColorset(MainCanvas canvas) {

        Color color = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );
        canvas.setBackground(color);
    }
}
