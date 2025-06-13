package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Main {
    public static void main(String[] args) {
        ProductoSubastado samsungOdissey = new ProductoSubastado(); 
        samsungOdissey.reset();
        Subastador subastador1 = new Subastador("gonzager");
        Subastador subastador2 = new Subastador("diazdan");
        Subastador subastador3 = new Subastador("martomau");



        subastador1.reset();
        subastador2.reset();
        subastador3.reset();    
        samsungOdissey.agregarObserver(subastador1);
        samsungOdissey.agregarObserver(subastador3);

        Oferta oferta1 = new Oferta(subastador3, 10);
        // Oferta oferta3 = subastador3.crearNuevaOferta();
        
        samsungOdissey.agregarOferta(oferta1);
        
        Oferta oferta2 = subastador1.crearNuevaOferta(samsungOdissey); 
        
        samsungOdissey.agregarOferta(oferta2);

        Oferta oferta3 = subastador3.crearNuevaOferta(samsungOdissey); 
        samsungOdissey.agregarOferta(oferta3);

        System.out.println(samsungOdissey.getOfertas().get(samsungOdissey.getOfertas().size() - 1).getSubastador().getNombreDeUsuario());

    }
}