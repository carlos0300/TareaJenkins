package co.edu.uis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
//@RequestMapping("/demo")
public class GreetingController {

	private static ArrayList<String> moto;
	private static List<ArrayList<String>> motos = new ArrayList<>();
	private static ArrayList<Greeting> motos2;
	

	@GetMapping("/getMoto")
	public ArrayList<Greeting> mostrar(@RequestParam(value = "id", defaultValue = "null") String id) {
	motos2 = new ArrayList<>();
			if (!id.equals("null")) {
				for(ArrayList<String> moto: motos){
					if (moto.contains(id)) {
						motos2.add(new Greeting(moto.get(0), moto.get(1), moto.get(2), moto.get(3), moto.get(4)));
					}
				}
				return motos2;
			}
			for(ArrayList<String> moto: motos){
				motos2.add(new Greeting(moto.get(0), moto.get(1), moto.get(2), moto.get(3), moto.get(4)));
			}
			return motos2;
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

	@PutMapping("/editMoto")
	public void actualizar(@RequestParam String id,
	@RequestParam String marca,
	@RequestParam String nombre,
	@RequestParam String year,
	@RequestParam String color)
	{
		
		for(ArrayList<String> moto: motos){
			if (moto.contains(id)) {
				moto.set(1,marca);
				moto.set(2,nombre);
				moto.set(3,year);
				moto.set(4,color);
			}
			
		}

	}

	@DeleteMapping("/deleteMoto")
	public void deletear(@RequestParam String id)
	{
		int i=0;
		for(Greeting moto: motos2){
			if (moto.getId().equals(id)) {
				motos.remove(i);
			}
			i++;
			
		}
	}
}