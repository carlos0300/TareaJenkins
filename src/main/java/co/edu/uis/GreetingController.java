package co.edu.uis;

import java.util.ArrayList;
import java.util.List;

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
	public List<ArrayList<String>> greeting(@RequestParam(value = "id", defaultValue = "null") String id,
											@RequestParam(value = "marca", defaultValue = "null") String marca,
											@RequestParam(value = "nombre", defaultValue = "null") String nombre,
											@RequestParam(value = "year", defaultValue = "null") String year,
											@RequestParam(value = "color", defaultValue = "null") String color) {
	List<ArrayList<String>> motos2 = new ArrayList<>();
			if (!id.equals("null")) {
				for(ArrayList<String> moto: motos){
					if (moto.contains(id)) {
						motos2.add(moto);
					}
				}
				return motos2;
			}
			if (!marca.equals("null")) {
				for(ArrayList<String> moto: motos){
					if (moto.contains(marca)) {
						motos2.add(moto);
					}
				}
				return motos2;
			}
			if (!nombre.equals("null")) {
				for(ArrayList<String> moto: motos){
					if (moto.contains(nombre)) {
						motos2.add(moto);
					}
				}
				return motos2;
			}
			if (!year.equals("null")) {
				for(ArrayList<String> moto: motos){
					if (moto.contains(year)) {
						motos2.add(moto);
					}
				}
				return motos2;
			}
			if (!color.equals("null")) {
				for(ArrayList<String> moto: motos){
					if (moto.contains(color)) {
						motos2.add(moto);
					}
				}
				return motos2;
			}
			return motos;
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

	@PutMapping("/deleteMoto")
	public void deletear(@RequestParam String id)
	{
		
		for(ArrayList<String> moto: motos){
			if (moto.contains(id)) {
				moto.remove(0);
				moto.remove(1);
				moto.remove(2);
				moto.remove(3);
				moto.remove(4);
			}
			
		}
	}
}