package sauveurs.stub;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Joueur;
import sauveurs.Sauveur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Simule la serialization d'une collection de joueur
 */
public class Stub extends Sauveur {

    /**
     * Simule la sauvegarde d'une collection de joueur
     * @param lesJoueurs  La collection a sauvegarder
     */
    @Override
    public void sauvegarderStats(Collection<Joueur> lesJoueurs) {

    }

    /**
     * Charge une collection de joueur
     * @return  La collection de joueur
     */
    @Override
    public Collection<Joueur> chargerStats() {
        Collection<Joueur> listeJoueurs = new ArrayList<Joueur>();
        listeJoueurs.add(new Joueur("Noé", 259));
        listeJoueurs.add(new Joueur("Erwan", 1000));
        listeJoueurs.add(new Joueur("Théo", 357));
        listeJoueurs.add(new Joueur("Paul", 1000));
        listeJoueurs.add(new Joueur("Mael", 50));
        listeJoueurs.add(new Joueur("Ambroise le boss", 58));
        listeJoueurs.add(new Joueur("Mathieu", 0));
        listeJoueurs.add(new Joueur("Mae", 350));
        listeJoueurs.add(new Joueur("Meriem", 20));
        listeJoueurs.add(new Joueur("Caly Romain", 500));
        listeJoueurs.add(new Joueur("Tutur05", 0));
        return listeJoueurs;
    }
}
