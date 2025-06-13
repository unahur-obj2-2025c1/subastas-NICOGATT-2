package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public interface Observer {
    void actualizar(ProductoSubastado producto); 
}
