package collisionneur;


import modele.Partie;

/**
 * classe abstraite qui a pour rôle de vérifier les collisions
 */
public abstract class Collisionneur {
    /**
     * largeur de l'écran de jeu
     */
    protected final double width = 420;

    /**
     * hauteur de l'écran de jeu
     */
    protected final double height = 600;

    /**
     * partie en cours
     */
    protected Partie jeu;

    /**
     * permet de set la partie en cours
     * @param jeu jeu de type Partie
     */
    public void setJeu(Partie jeu) {
        this.jeu = jeu;
    }

    /**
     * vérifie si une pièce touche le haut de l'écran de jeu
     * @return Boolean, true si touche
     */
    public abstract boolean toucheHautEcran();

    /**
     * vérifie si une pièce peut bouger vers le bas
     * @return Boolean, true si peut bouger
     */
    public abstract boolean peutBougerEnBas();

    /**
     * vérifie si une pièce peut bouger vers la droite
     * @return Boolean, true si peut bouger
     */
    public abstract boolean peutBougerDroite();

    /**
     * vérifie si une pièce peut bouger vers la gauche
     * @return Boolean, true si peut bouger
     */
    public abstract boolean peutBougerGauche();

}
