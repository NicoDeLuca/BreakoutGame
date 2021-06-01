import processing.core.PApplet;

public class Block {
    float brickPosition_y;
    float brickPosition_x;
    float brick_Height;
    boolean active = true;


    public Block(float brick_Height, float brickPosition_x, float brickPosition_y) {
        this.brickPosition_x = brickPosition_x;
        this.brickPosition_y = brickPosition_y;
        this.brick_Height = brick_Height;
    }


    public float[] setBlocks(PApplet g, float ball_y, float[] ball_speed, float ball_x) {
        if (active == true) {
            g.fill(0, 238, 0);
            g.rect(this.brickPosition_x, this.brickPosition_y, this.brick_Height, this.brick_Height);
        }
        if (ball_y >= brickPosition_y - 20 && ball_y <= brickPosition_y + 20 && active) {
            if (ball_x >= brickPosition_x - 20 && ball_x <= brickPosition_x + 20) {
                ball_speed[1] = (-ball_speed[1]);
                active = false;

            }
        }

        if (ball_x <= brickPosition_x && ball_x >= brickPosition_x) {
            if (ball_y <= brickPosition_y - 20 && ball_y >= brickPosition_y + 20) {
                ball_speed[0] = (-ball_speed[0]);
            }

        }
        return ball_speed;
    }



}

