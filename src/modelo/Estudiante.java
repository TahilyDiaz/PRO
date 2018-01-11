package modelo;

import java.time.LocalDate;

public class Estudiante extends Persona implements Comparable<Estudiante> {

	private int codGrupo;

	public int getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(int codGrupo) {
		this.codGrupo = codGrupo;
	}

	public Estudiante(int codGrupo) {
		super();
		this.codGrupo = codGrupo;
	}

	public Estudiante(int codGrupo, String nombre, String nif, char sexo, LocalDate fecha, int altura, Persona padre,
			Persona madre, int longitudPaso) {
		super(nombre, nif, sexo, fecha, altura, padre, madre, longitudPaso);
		this.codGrupo = codGrupo;
	}

	public String toString() {
		return super.toString() + ", CodGrupo: " + this.codGrupo;
	}

	public int compareTo(Estudiante estudiante) {
		return this.getNif().compareTo(estudiante.getNif());
	}

}


