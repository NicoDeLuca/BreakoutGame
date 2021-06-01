import processing.core.PApplet;

public class Player{

    float player_y;
    float player_x;

    public Player(float player_y, float player_x) {
        this.player_y = player_y;
        this.player_x = player_x;
    }
    public void drawit(PApplet g){
        g.rect(player_x, player_y, 150, 20, 7);

    }


    public void Move(PApplet g) {
        if (g.keyPressed) {
            if (g.key == 'd' || g.key == 'D') {
                if (player_x < 725)
                    player_x = player_x + 10;
            }
            if (g.key == 'a' || g.key == 'A') {
                if (player_x > 75)
                    player_x = player_x - 10;
            }
        }

    }

}
