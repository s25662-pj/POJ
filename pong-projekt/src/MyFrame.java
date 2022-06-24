import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class MyFrame extends JFrame{

    Image image;
    Graphics graphics;
    Box player1, player2, ball;
    float[] ballMovement;
    int[] score;
    int ballSpeed;
    int paletteWidth, paletteHeight, ballRadius;
    int screenWidth, screenHeight;


    MyFrame(){
        //zmienne ktore mozna sobie pozmieniac dla urozmaicenia/utrudnienia gry
        screenWidth = 600;
        screenHeight = 600;
        paletteWidth = 10;
        paletteHeight = 80;
        ballRadius = 7;
        ballSpeed = 10;



        ballMovement = new float[2];
        ballMovement[0] = ballSpeed;
        ballMovement[1] = 0;
        score = new int[2];
        score[0] = 0;
        score[1] = 0;





        player1 = new Box(10 + paletteWidth/2,(screenHeight-paletteHeight)/2, paletteWidth, paletteHeight,Color.blue);
        player2 = new Box(screenWidth-paletteWidth*2 -5,(screenHeight-paletteHeight)/2, paletteWidth, paletteHeight,Color.red);
        ball = new Box(screenWidth/2-ballRadius,screenHeight/2-ballRadius,ballRadius*2,ballRadius*2,Color.black);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth,screenHeight);
        this.setVisible(true);
        this.addKeyListener(new AL());
    }

    public void paint(Graphics g) {
        image = createImage(this.getWidth(),this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image,0,0,this);

        player1.draw(g);
        player2.draw(g);
        ball.draw(g);

    }
    public void restart(int n){
        System.out.println("Score: " + score[0] + " : " + score[1]);
        ballMovement[0] = ballSpeed*n;
        ballMovement[1] = 0;
        player1 = new Box(10 + paletteWidth/2,(screenHeight-paletteHeight)/2, paletteWidth, paletteHeight,Color.blue);
        player2 = new Box(screenWidth-paletteWidth*2 -5,(screenHeight-paletteHeight)/2, paletteWidth, paletteHeight,Color.red);
        ball = new Box(screenWidth/2-ballRadius,screenHeight/2-ballRadius,ballRadius*2,ballRadius*2,Color.black);

    }

    public void checkCollision() {
        if(ball.intersects(player1)) {
            ballMovement[1] = (float)(-ballSpeed + Math.random() * (ballSpeed*2))*0.8f;
            ballMovement[0] = (float)Math.sqrt(Math.abs(Math.pow(ballSpeed, 2) - Math.pow(ballMovement[1], 2)));
        }
        if(ball.intersects(player2)) {
            ballMovement[1] = (float)(-ballSpeed + Math.random() * (ballSpeed*2))*0.8f;
            ballMovement[0] = -(float)Math.sqrt(Math.abs(Math.pow(ballSpeed, 2) - Math.pow(ballMovement[1], 2)));
        }
        //System.out.println(ballMovement[0] + ", " +  ballMovement[1]);
        if(ball.y < 0 || ball.y+ballRadius*2 > screenHeight){
            ballMovement[1] = -ballMovement[1];
        }

        if(ball.x < -ballRadius*2){
            score[1] += 1;
            restart(-1);
        }

        if(ball.x > screenWidth){
            score[0] += 1;
            restart(1);
        }

    }

    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e, 1);
            player2.keyPressed(e, 2);
            checkCollision();
            ball.x += ballMovement[0];
            ball.y += ballMovement[1];
            repaint();
        }



    }

}
