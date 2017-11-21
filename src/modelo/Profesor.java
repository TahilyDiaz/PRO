package modelo;

import java.time.LocalDate;

public class Profesor extends Persona {

	private int codDepto;
	private LocalDate fechaIng;

	/*
	 * public Profesor() { super(); this.setCodDepto(123);
	 ** this.setFechaIng(LocalDate.now()); }
	 */

	public Profesor(int codDepto, LocalDate fechaIng) {
		super();
		this.codDepto = codDepto;
		this.fechaIng = fechaIng;
	}

	public Profesor(String nombre, String nif, char sexo, LocalDate fecha, int altura, Persona padre, Persona madre,
			int longitudPaso, int codDepto, LocalDate fechaIng) {
		super(nombre, nif, sexo, fecha, altura, padre, madre, longitudPaso);
		this.codDepto = codDepto;
		this.fechaIng = fechaIng;
	}

	public String toString() {
		return super.toString() + ", CodDept: " + this.codDepto + ", Fech Ing: " + this.fechaIng;
	}

	public int getCodDepto() {
		return codDepto;
	}

	public void setCodDepto(int codDepto) {
		this.codDepto = codDepto;
	}

	public LocalDate getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(LocalDate fechaIng) {
		this.fechaIng = fechaIng;
	}
}
