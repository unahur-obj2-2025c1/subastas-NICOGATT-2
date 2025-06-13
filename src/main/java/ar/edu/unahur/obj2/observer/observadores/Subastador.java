package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Subastador implements Observer {
    private String nombreDeUsuario; 
    private String ultimoMensaje = "";
    private Oferta ultimaOferta = null; 

    public Subastador(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    @Override
    public void actualizar(ProductoSubastado producto) {
        if (!producto.getOfertas().isEmpty()) {
            this.ultimaOferta = producto.getOfertas().get(producto.getOfertas().size() - 1);
            ultimoMensaje = nombreDeUsuario + " se enteró que " + ultimaOferta.getSubastador().getNombreDeUsuario()
                            + " hizo la nueva mejor oferta: $" + ultimaOferta.getValorOfertado();
            System.out.println(ultimoMensaje);
        }
    }


    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public Oferta crearNuevaOferta(ProductoSubastado producto) {
        int nuevoValor; 
        if(ultimaOferta == null)
            nuevoValor = 10;
        else 
            nuevoValor = ultimaOferta.getValorOfertado() + 10;
        return new Oferta(this, nuevoValor);
    }

    public String getUltimoMensaje() {
        return ultimoMensaje;
    }

    public void setUltimoMensaje(String ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }

    public Oferta getUltimaOferta() {
        return ultimaOferta;
    }

    public void setUltimaOferta(Oferta ultimaOferta) {
        this.ultimaOferta = ultimaOferta;
    }

    public void reset() {
        this.ultimaOferta = null; 
    }
}
