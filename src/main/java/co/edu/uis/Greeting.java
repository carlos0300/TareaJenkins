package co.edu.uis;

public class Greeting {

	private final String id;
	private final String marca;
	private final String nombre;
	private final String year;
	private final String color;

	public Greeting(String id, String marca, String nombre, String year, String color) {
		this.id = id;
		this.marca = marca;
		this.nombre = nombre;
		this.year = year;
		this.color = color;

	}

	public String getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}
	public String getNombre() {
		return nombre;
	}
	public String getYear() {
		return year;
	}
	public String getColor() {
		return color;
	}
}