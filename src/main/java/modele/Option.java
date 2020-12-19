package modele;

public class Option {
    private int volumeMusique;

    public int getVolumeMusique() {
        return volumeMusique;
    }

    public void setVolumeMusique(int volumeMusique) {
        this.volumeMusique = volumeMusique;
    }

    public Option(int volumeMusique){
        this.volumeMusique = volumeMusique;
    }
}
