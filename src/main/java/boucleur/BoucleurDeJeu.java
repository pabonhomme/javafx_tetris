package boucleur;

/**
 * Classe qui hérite de Boucleur, intanciable
 */
public class BoucleurDeJeu extends Boucleur {

    /**
     * variable booléenne pour mettre en pause ou non
     */
    private boolean estEnpause = false;

    /**
     * permet de savoir si la boucle est en pause
     * @return valeur de type Boolean
     */
    public boolean getEstEnpause() {
        return estEnpause;
    }

    /**
     * méthode qui met la boucle en pause
     */
    public void pause() {
        estEnpause = true;
    }

    /**
     * méthode qui permet de remettre la boucle en pause
     */
    public void reprendre() {
        estEnpause = false;
    }


    /**
     * exécute une méthode en boucle avec un délai d'attente entre chaque exécution
     */
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
