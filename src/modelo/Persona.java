package modelo;

import java.time.LocalDate;

public class Persona {
	// public abstract class Persona{

	// DECLARACION DE VARIABLES
	private String nif;
	private String nombre;
	private char sexo; // 'M' 'F'
	private LocalDate fecha;
	private int altura;
	private Persona padre;
	private Persona madre;
	private int longitudPaso;

	private static int contadorInstancias = 0; // es estatico pq es un contador de la clase persona.

	// CONSTRUCTOR SIN PARÁMETROS
	public Persona() {
		this.nif = "448822292Y";
		this.nombre = "Anonimo";
		this.sexo = 'M';
		this.fecha = LocalDate.now();
		this.altura = 180;
		this.padre = null;
		this.madre = null;
		this.longitudPaso = 70;
		contadorInstancias++;
	}

	// CONSTRUCTOR CON PARÁMETROS o ARGUMENTOS
	public Persona(String nombre, String nif, char sexo, LocalDate fecha, int altura, Persona padre, Persona madre,
			int longitudPaso) {
		super();
		this.nombre = nombre;
		this.nif = nif;
		this.sexo = sexo;
		this.fecha = fecha;
		this.altura = altura;
		this.padre = padre;
		this.madre = madre;
		this.longitudPaso = longitudPaso;
		contadorInstancias++;
	}

	public String toString() {
		return "Persona nº: " + Persona.getContadorInstancias() + " , NIF: " + this.nif + ", Nombre: " + this.nombre
				+ ", Sexo: " + this.sexo + ", Fec: " + this.fecha + ", altura: " + this.altura + ", Padre: "
				+ this.padre + ", Madre: " + this.madre + ", Longitud paso: " + this.longitudPaso;
	}

	// PARA PODER LLAMARLO DESDE OTRA CLASE EN OTRO PAQUETE
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Persona getPadre() {
		return padre;
	}

	public void setPadre(Persona padre) {
		this.padre = padre;
	}

	public Persona getMadre() {
		return madre;
	}

	public void setMadre(Persona madre) {
		this.madre = madre;
	}

	public int getLongitudPaso() {
		return longitudPaso;
	}

	public void setLongitudPaso(int longitudPaso) {
		this.longitudPaso = longitudPaso;
	}

	public static int getContadorInstancias() {
		return contadorInstancias;
	}
}
