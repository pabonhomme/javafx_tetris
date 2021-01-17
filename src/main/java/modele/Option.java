package modele;

/**
 * Classe qui gère les options du jeu
 */
public class Option {
    /**
     * volume de la musique
     */
    private int volumeMusique;

    /**
     * récupère le volume de la musique
     * @return
     */
    public int getVolumeMusique() {
        return volumeMusique;
    }

    /**
     * set le volume de la musique
     * @param volumeMusique
     */
    public void setVolumeMusique(int volumeMusique) {
        this.volumeMusique = volumeMusique;
    }

    /**
     * constructeur
     * @param volumeMusique volume de la musique, int
     */
    public Option(int volumeMusique){
        this.volumeMusique = volumeMusique;
    }
}
