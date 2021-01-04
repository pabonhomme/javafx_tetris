package boucleur;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public abstract class Boucleur implements Runnable, Observable {

    private List<InvalidationListener> mesObservateurs = new ArrayList<>();
    protected boolean running = false;

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {
        mesObservateurs.add(invalidationListener);

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        mesObservateurs.remove(invalidationListener);

    }
    protected void beep() {

        mesObservateurs.forEach(o -> Platform.runLater(()-> o.invalidated(this)));

    }
}
