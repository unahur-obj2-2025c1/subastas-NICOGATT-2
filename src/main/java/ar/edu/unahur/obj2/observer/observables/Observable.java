package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.observadores.Observer;

public interface Observable {
    void agregarObserver(Observer observador); 
    void notificarObsever();
}
