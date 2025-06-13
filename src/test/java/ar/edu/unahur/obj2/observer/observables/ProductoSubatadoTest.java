package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {
    ProductoSubastado productoSubastado; 
    Subastador gonzager; 
    Subastador diazdan; 
    Subastador martomau;

    @BeforeEach
    void setUp(){
        productoSubastado = new ProductoSubastado(); 
        gonzager = new Subastador("gonzager"); 
        diazdan = new Subastador("diazdan"); 
        martomau = new Subastador("martomau"); 
    }

    // Test1 
    @Test
    void seVerificaQueLosSubsatadores_Y_RecibenCorrectamenteLaUltimaOfertaRecibida() {
        productoSubastado.reset();
        gonzager.reset();
        diazdan.reset();
        martomau.reset();

        productoSubastado.agregarObserver(gonzager);
        productoSubastado.agregarObserver(martomau);

        Oferta oferta1 = martomau.crearNuevaOferta(productoSubastado);
        productoSubastado.agregarOferta(oferta1);
        Oferta oferta2 = gonzager.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta2);
        Oferta oferta3 = martomau.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta3);

        assertEquals("gonzager se enteró que martomau hizo la nueva mejor oferta: $30", gonzager.getUltimoMensaje());
        assertEquals("martomau se enteró que martomau hizo la nueva mejor oferta: $30", martomau.getUltimoMensaje());
    }

    //Test2
    @Test
    void laUltimaOfertaRecibidaEsLaDeMartumau() {
        productoSubastado.reset();
        gonzager.reset();
        diazdan.reset();
        martomau.reset();

        productoSubastado.agregarObserver(gonzager);
        productoSubastado.agregarObserver(martomau);

        Oferta oferta1 = martomau.crearNuevaOferta(productoSubastado);
        productoSubastado.agregarOferta(oferta1);
        Oferta oferta2 = gonzager.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta2);
        Oferta oferta3 = martomau.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta3);

        Oferta ultimaOferta = productoSubastado.getOfertas().get(productoSubastado.getOfertas().size() - 1); 

        assertEquals("martomau", ultimaOferta.getSubastador().getNombreDeUsuario());
    }

    //Test 3
    @Test
    void laUltimaOfertaEsDe30(){
        productoSubastado.reset();
        gonzager.reset();
        diazdan.reset();
        martomau.reset();

        productoSubastado.agregarObserver(gonzager);
        productoSubastado.agregarObserver(martomau);

        Oferta oferta1 = new Oferta(martomau, 10); 
        productoSubastado.agregarOferta(oferta1);
        Oferta oferta2 = new Oferta(gonzager, 20); 
        productoSubastado.agregarOferta(oferta2);
        Oferta oferta3 = new Oferta(martomau, 30); 
        productoSubastado.agregarOferta(oferta3);

        assertEquals(30, productoSubastado.getOfertas().get(productoSubastado.getOfertas().size() - 1).getValorOfertado());
    }

    //Test 4
    @Test
    void elProductoSubastadoTieneTresOfertasRegitradas() {
        productoSubastado.reset();
        gonzager.reset();
        diazdan.reset();
        martomau.reset();

        productoSubastado.agregarObserver(gonzager);
        productoSubastado.agregarObserver(martomau);

        Oferta oferta1 = martomau.crearNuevaOferta(productoSubastado);
        productoSubastado.agregarOferta(oferta1);
        Oferta oferta2 = gonzager.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta2);
        Oferta oferta3 = martomau.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta3);

        assertEquals(3, productoSubastado.getOfertas().size());
    }

    //Test 5 
    @Test
    void alIntentarAgregarUnaOfertaDeDiazdanDaError() {
        productoSubastado.reset();
        gonzager.reset();
        diazdan.reset();
        martomau.reset();

        productoSubastado.agregarObserver(gonzager);
        productoSubastado.agregarObserver(martomau);

        Oferta oferta1 = martomau.crearNuevaOferta(productoSubastado);
        productoSubastado.agregarOferta(oferta1);
        Oferta oferta2 = gonzager.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta2);
        Oferta oferta3 = martomau.crearNuevaOferta(productoSubastado); 
        productoSubastado.agregarOferta(oferta3);
        Oferta oferta4 = diazdan.crearNuevaOferta(productoSubastado); 
        
        assertThrows(OfertaSubastadorException.class, () -> {
            productoSubastado.agregarOferta(oferta4);
        });



    }
}
