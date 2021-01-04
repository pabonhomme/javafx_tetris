package boucleur;


public class BoucleurDeJeu extends Boucleur {

    private boolean estEnpause = false;

    public boolean getEstEnpause() {
        return estEnpause;
    }

    public void pause() {
        estEnpause = true;
    }

    public void reprendre() {
        estEnpause = false;
    }


    @Override
    public void run() {
        try {

            Thread.sleep(1500);
        } catch (InterruptedException e) {
            running = false;
        }
        while (running) {
            if (!estEnpause) {
                beep();
            }
            try {

                Thread.sleep(500);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}
