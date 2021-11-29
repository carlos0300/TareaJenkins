package co.edu.uis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoSpringApplicationTests {

	
    GreetingController classmoto = new GreetingController();

	@Test
	void comprobarMetodoPost_Get(){

		classmoto.registrar("01", "Honda", "Cb 110", "2018", "Azul");
        classmoto.registrar("02", "Bajaj", "Pulsar 150", "2015", "Negro");
        classmoto.registrar("03", "Susuki", "Gs 125", "2020", "Rojo");
        classmoto.registrar("04", "Bajaj", "Pulsar NS 200", "2022", "Negro");
        classmoto.registrar("05", "Honda", "Cb 110", "2020", "Azul");

        Greeting moto_prueba = new Greeting("05", "Honda", "Cb 110", "2020", "Azul");

        ArrayList<Greeting> motos = new ArrayList<>();
        motos = classmoto.mostrar("05");

        assertEquals(moto_prueba.getId(), motos.get(0).getId());
        assertEquals(moto_prueba.getMarca(), motos.get(0).getMarca());
        assertEquals(moto_prueba.getNombre(), motos.get(0).getNombre());
        assertEquals(moto_prueba.getYear(), motos.get(0).getYear());
        assertEquals(moto_prueba.getColor(), motos.get(0).getColor());
    }

    @Test
	void comprobarMetodoPut(){

        classmoto.registrar("01", "Honda", "Cb 110", "2018", "Azul");
        classmoto.registrar("02", "Bajaj", "Pulsar 150", "2015", "Negro");
        classmoto.registrar("03", "Susuki", "Gs 125", "2020", "Rojo");
        classmoto.registrar("04", "Bajaj", "Pulsar NS 200", "2022", "Negro");
        classmoto.registrar("05", "Honda", "Cb 110", "2020", "Azul");

        Greeting moto_prueba = new Greeting("04", "Bajaj", "Discover st 125", "2021", "Negra");

        classmoto.actualizar("04", "Bajaj", "Discover st 125", "2021", "Negra");

        ArrayList<Greeting> motos = new ArrayList<>();
        motos = classmoto.mostrar("04");

        assertEquals(moto_prueba.getId(), motos.get(0).getId());
        assertEquals(moto_prueba.getMarca(), motos.get(0).getMarca());
        assertEquals(moto_prueba.getNombre(), motos.get(0).getNombre());
        assertEquals(moto_prueba.getYear(), motos.get(0).getYear());
        assertEquals(moto_prueba.getColor(), motos.get(0).getColor());

    }

    @Test
	void comprobarMetodoDelete(){

		ArrayList<Greeting> motos = new ArrayList<>(); 
		motos = classmoto.mostrar("null");
       
        classmoto.deletear("04");
		
        
        motos = classmoto.mostrar("null");


        ArrayList<Greeting> motos2 = new ArrayList<>();

		motos = classmoto.mostrar("04");

        assertEquals(motos, motos2);
    }

}
