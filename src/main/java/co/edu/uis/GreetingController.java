package co.edu.uis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/demo")
public class GreetingController {

	private static ArrayList<String> moto;
	private static List<ArrayList<String>> motos = new ArrayList<>();

	private static final String template_fr = "Salut, %s!";
	private static final String template_es = "Hola, %s!";
	private static final String template_en = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		for(ArrayList<String> moto: motos){
			if (moto.contains(name)) {
				if (moto.contains("EN")) {
					return new Greeting(counter.incrementAndGet(), String.format(template_en, name));
				} else if (moto.contains("ES")) {
					return new Greeting(counter.incrementAndGet(), String.format(template_es, name));
				} else if (moto.contains("FR")) {
					return new Greeting(counter.incrementAndGet(), String.format(template_fr, name));
				} else {
					return new Greeting(counter.incrementAndGet(), String.format(template_en, name) + " I don't know your language");
				}
			}
		}
		return new Greeting(counter.incrementAndGet(), "You are not registered yet");
	}

	// aqui se crean las motos

	@PostMapping("/addMoto")
	public void registrar(@RequestParam String id,
						@RequestParam String marca,
						@RequestParam String nombre,
						@RequestParam String year,
						@RequestParam String color){

		moto = new ArrayList<String>();

		moto.add(id);
		moto.add(marca);
		moto.add(nombre);
		moto.add(year);
		moto.add(color);

		motos.add(moto);
	}

	@PutMapping("/update")
	public void actualizar(@RequestParam String id,
	@RequestParam String marca,
	@RequestParam String nombre,
	@RequestParam String year,
	@RequestParam String color)
	{
		int i=0;
		for(ArrayList<String> moto: motos){
			if (moto.contains(id)) {
				moto.set(i,marca);
				moto.set(i,nombre);
				moto.set(i,year);
				moto.set(i,color);
			}
			i=i+1;
		}

	}

}