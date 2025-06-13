package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
    private Integer valorOfertado; 
    private final Subastador subastador; 

    public Oferta(Subastador subastador, Integer valorOfertado) {
        this.subastador = subastador; 
        this.valorOfertado = valorOfertado;
    }

    public Integer getValorOfertado() {
        return valorOfertado;
    }

    public void setValorOfertado(Integer valorOfertado) {
        this.valorOfertado = valorOfertado;
    }

    public Subastador getSubastador() {
        return subastador;
    }


}
