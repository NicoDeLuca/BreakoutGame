import processing.core.PApplet;
	

public class Breakout extends PApplet{
    Player player1;
    Balltreffer b;
    Block[] block = new Block[100];
    float ball_y;
    float ball_x;
    int playerlifes;
    float[] ball_speed = new float[2];



    public static void main(String[] args) {
        PApplet.main("Breakout");


    }

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        noLoop();
        rectMode(CENTER);
        player1 = new Player(580,400);
        ball_y = 300;
        ball_x = 400;
        ball_speed[0] = 0;
        ball_speed[1] = 4;
        playerlifes = 3;


       b = new Balltreffer(0);

        keyPressed();

        float brickPosition_x = 40;

        int zahl = 0;

        for(int i = 0; i <= 18;i++){


            block[zahl] = new Block(40,brickPosition_x,20);

            brickPosition_x = brickPosition_x +40;
            zahl = zahl + 1;

        }

        brickPosition_x = 40;


        for(int i = 0; i <= 18;i++){


            block[zahl] = new Block(40,brickPosition_x,60);

            brickPosition_x = brickPosition_x +40;
            zahl = zahl + 1;

        }

        brickPosition_x = 40;

        for(int i = 0; i <= 18;i++){


            block[zahl] = new Block(40,brickPosition_x,100);

            brickPosition_x = brickPosition_x +40;
            zahl = zahl + 1;

        }



    }

    public void draw() {
        background(0);

        if (key == 'z'){
            setup();
        }

        leben();
        fill(255);
        textSize(11);
        text("Leben:"+playerlifes,100,550);


        player1.Move(this);
        player1.drawit(this);

        Ball(player1.player_x);

        fill(255);

        int zahl = 0;
        for(int i = 0; i <= 18;i++){


            ball_speed = block[zahl].setBlocks(this,ball_y,ball_speed,ball_x);

            zahl = zahl + 1;
        }

        zahl = 19;
        for(int i = 0; i <= 18;i++){


            ball_speed = block[zahl].setBlocks(this,ball_y,ball_speed,ball_x);

            zahl = zahl + 1;
        }
        zahl = 38;
        for(int i = 0; i <= 18;i++){

            fill(255);
            ball_speed = block[zahl].setBlocks(this,ball_y,ball_speed,ball_x);

            zahl = zahl + 1;
        }




        b.balltreffer(this.g,ball_y);


        if (block.length == 0){
            text("Sie haben gewonnen!", 260, 300);
            noLoop();
        }
    }


    public void Ball(float player_x) {
        fill(238, 44, 44);
        rect(ball_x, ball_y, 10, 10, 20);

        ball_x = ball_x + ball_speed[0];
        ball_y = ball_y + ball_speed[1];

        if (ball_y > 565) {
            if (ball_x < (player_x + 75) && ball_x > (player_x - 75)) {
                ball_speed[1] = (-ball_speed[1]);
                ball_speed[0] = ball_speed[0] - ((player_x - ball_x)/10);


            } else {
                ball_x = 400;
                ball_y = 300;
                ball_speed[0] = 0;
                ball_speed[1] = 4;
                playerlifes -= 1;
            }
        }
        if (ball_y < 5) {
            ball_speed[1] = -ball_speed[1];
        }

        if (ball_x > 795 || ball_x < 5) {
            ball_speed[0] = -ball_speed[0];
        }


        }

        public void leben(){
        if (playerlifes == 0){
            noLoop();

                textSize(32);
                text("Sie haben verloren", 260, 300);
                if (keyPressed){
                if(keyCode == ENTER) {
                    setup();

                }
                }

        }

        }

    public void keyPressed () {

        if (keyCode == ENTER)
            if (looping) noLoop();
            else loop();
    }


}