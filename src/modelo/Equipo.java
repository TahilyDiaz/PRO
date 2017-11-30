package modelo;

public class Equipo implements Comparable<Equipo> {
	private String nombre;
	private Integer puntos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo() {
		super();
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public int compareTo(Equipo equipo) {
		return this.getPuntos().compareTo(equipo.getPuntos());
	}

}
