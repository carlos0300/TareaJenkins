package co.edu.uis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/demo")
public class GreetingController {

	private static ArrayList<String> usuario;
	private static List<ArrayList<String>> usuarios1 = new ArrayList<>();

	private static final String template_fr = "Salut, %s!";
	private static final String template_es = "Hola, %s!";
	private static final String template_en = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		for(ArrayList<String> usuario: usuarios1){
			if (usuario.contains(name)) {
				if (usuario.contains("EN")) {
					return new Greeting(counter.incrementAndGet(), String.format(template_en, name));
				} else if (usuario.contains("ES")) {
					return new Greeting(counter.incrementAndGet(), String.format(template_es, name));
				} else if (usuario.contains("FR")) {
					return new Greeting(counter.incrementAndGet(), String.format(template_fr, name));
				} else {
					return new Greeting(counter.incrementAndGet(), String.format(template_en, name) + " I don't know your language");
				}
			}
		}
		return new Greeting(counter.incrementAndGet(), "You are not registered yet");
	}

	// aqui se crean las motos

	@PostMapping("/register")
	public void registrar(@RequestParam String name,
						@RequestParam String lang){

		usuario = new ArrayList<String>();

		usuario.add(name);
		usuario.add(lang);

		usuarios1.add(usuario);
	}
}