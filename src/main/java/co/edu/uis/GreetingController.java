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
	

	@GetMapping("/getMoto")
	public Greeting greeting(@RequestParam(value = "id", defaultValue = "all") String id) {
			if (id.equals("all")) {
				for(ArrayList<String> moto: motos){
					return new Greeting(moto.get(0),moto.get(1),moto.get(2),moto.get(3),moto.get(4));
				}
			}
			return null;
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