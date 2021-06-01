import processing.core.PGraphics;

public class Balltreffer {
    int count;

    public Balltreffer(int Count) {
        this.count = Count;
    }

    public void balltreffer(PGraphics g, float ball_y){
        if((ball_y > 565)) {
            this.count = this.count +1;
        }
        g.fill(255);
        g.textSize(11);
        g.text("Balltreffer " + count,580,550);

    }


}
