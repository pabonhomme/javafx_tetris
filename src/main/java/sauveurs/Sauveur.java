package sauveurs;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import modele.Joueur;

import java.util.Collection;

/**
 * Gere la serialization d'une collection de joueur
 */
public abstract class Sauveur {

    /**
     * Sauvegarde une collection de joueur
     * @param lesJoueurs  La collection a sauvegarder
     */
    public abstract void sauvegarderStats(Collection<Joueur> lesJoueurs);

    /**
     * Charge une collection de joueur
     * @return  La collection de joueur
     */
    public abstract Collection<Joueur> chargerStats();
}

