/**
 * Полностью разобраться с кодом
 * Прочитать методичку к следующему уроку
 * Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
 * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
 * * Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
 */

package HomeworkLesson1;


import HomeworkLesson1.Ball;
import HomeworkLesson1.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainCircles extends JFrame {

    private Sprite[] sprites = new Ball[10];
    private Background backgroundColor = new Background(this);
    private static final int POS_X = 100;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 550;


    public static void main(String[] args) {
//    new MainCircles();
        SwingUtilities.invokeLater(() -> new MainCircles());
    }

    private MainCircles() {
        setTitle("Bounding circles");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);


        MainCanvas canvas = new MainCanvas(this);
        initSprites();
        updateBackgroundColor(canvas);
        add(canvas);
//не работает       spritesOnClick(canvas);
        setVisible(true);
    }
//не работает
//    public void spritesOnClick(MainCanvas canvas, Sprite... sprites) {
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if ( e.getButton() == MouseEvent.BUTTON1 ) {
//                    Sprite [] sprites = new Ball[];
//                }
//            }
//        });
//    }


    private void initSprites() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    private void updateBackgroundColor(MainCanvas canvas) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( e.getButton() == MouseEvent.BUTTON3 ) {
                    backgroundColor.bgColorset(canvas);
                }
            }
        });
    }

    protected void onCanvasRepainted(MainCanvas canvas, Graphics graphics, float deltaTime) {
        update(canvas, deltaTime);
        rendering(canvas, graphics);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void rendering(MainCanvas canvas, Graphics graphics) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].rendering(canvas, graphics);
        }
    }
}
