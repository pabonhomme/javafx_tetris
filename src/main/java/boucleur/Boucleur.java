package boucleur;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * classe abstraite qui contient les méthodes pour boucler
 */
public abstract class Boucleur implements Runnable, Observable {

    /**
     * liste des objets qui pourrait boucler
     */
    private List<InvalidationListener> mesObservateurs = new ArrayList<>();

    /**
     * valeur booléenne qui permet à la boucle de tourner
     */
    protected boolean running = false;

    /**
     * Permet de lancer ou arrêter la boucle
     * @param running valeur booléenne
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * ajout à la liste d'objets qui pourront exécuter une méthode en boucle
     * @param invalidationListener Objet de type Invalidation Listener à ajouter
     */
    @Override
    public void addListener(InvalidationListener invalidationListener) {
        mesObservateurs.add(invalidationListener);

    }

    /**
     * supprime à la liste d'objets qui pourront exécuter une méthode en boucle
     * @param invalidationListener Objet de type Invalidation Listener à supprimer
     */
    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        mesObservateurs.remove(invalidationListener);

    }

    /**
     * méthode qui sera appelée en boucle dans les classes filles
     */
    protected void beep() {

        mesObservateurs.forEach(o -> Platform.runLater(()-> o.invalidated(this)));

    }
}
