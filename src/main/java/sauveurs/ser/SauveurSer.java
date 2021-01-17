package sauveurs.ser;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Joueur;
import modele.Option;
import sauveurs.Sauveur;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Permet la serialization d'une collection de joueur dans un fichier binaire
 */
public class SauveurSer extends Sauveur {

    /**
     * Sauvegarde une collection de joueur dans le fichier auth.bin
     * @param top10Joueur  La collection a sauvegarder
     */
    @Override
    public void sauvegarderStats(Collection<Joueur> top10Joueur) {
        serialiser(top10Joueur);

    }

    /**
     * Charge une collection de joueur depuis le fichier auth.bin
     * @return  La collection de joueur
     */
    @Override
    public Collection<Joueur> chargerStats() {
        return deserialiser();
    }


    private void serialiser(Collection<Joueur> top10Joueur) {
        try {
            FileOutputStream fout = new FileOutputStream("donnees.bin");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(top10Joueur);
            oout.close();
            fout.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private Collection<Joueur> deserialiser() {
        Collection<Joueur> listeJoueurs = new ArrayList<Joueur>();
        try {
            FileInputStream fin = new FileInputStream("donnees.bin");
            ObjectInputStream oin = new ObjectInputStream(fin);
            listeJoueurs = (Collection<Joueur>) oin.readObject();
            oin.close();
            fin.close();
        } catch (ClassNotFoundException | IOException nfe) {
            nfe.printStackTrace();
        }
        return listeJoueurs;
    }

}
