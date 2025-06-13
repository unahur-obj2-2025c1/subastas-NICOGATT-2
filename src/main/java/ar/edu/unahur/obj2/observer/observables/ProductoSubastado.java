package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class ProductoSubastado implements Observable {
    private List<Oferta> ofertas = new ArrayList<>();
    private Set<Observer> observadores = new HashSet<>();
    
    public ProductoSubastado(){}

    @Override
    public void agregarObserver(Observer observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObsever() {
        observadores.stream().forEach(obs -> obs.actualizar(this));
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public Set<Observer> getObservadores() {
        return observadores;
    }

    public void setObservadores(Set<Observer> observadores) {
        this.observadores = observadores;
    }

    public void agregarOferta(Oferta oferta) {
        if(!observadores.contains(oferta.getSubastador()))
            throw new OfertaSubastadorException("El subastador no participa en la subasta"); 
        ofertas.add(oferta);
        notificarObsever();
    }

    public void reset() {
        observadores.clear();
        ofertas.clear(); 
    }
}
