package modelo;

import java.time.LocalDate;

public class Datos {
	private String[] diasSem = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
	private Estudiante[] estudiantes;
	private int numEstudiantes = 30;
	private int numColum = 10;
	private Estudiante[][] estudianteCentro;
	

	public Estudiante[][] getEstudianteCentro() {
		return estudianteCentro;
	}

	public void setEstudianteCentro(Estudiante[][] estudianteCentro) {
		this.estudianteCentro = estudianteCentro;
	}

	public String[] getDiasSem() {
		return diasSem;
	}

	public void setDiasSem(String[] diasSem) {
		this.diasSem = diasSem;
	}

	public Estudiante[] getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Estudiante[] estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Datos() {
		super();
		estudiantes = new Estudiante[numEstudiantes];
		estudianteCentro = new Estudiante[numEstudiantes][numColum];
		Estudiante est1 = new Estudiante(148, "Pedro", "78458985k", 'F', LocalDate.of(1995, 8, 29), 478, null, null,
				68);
		Estudiante est2 = new Estudiante(144, "Paloma", "78458985k", 'M', LocalDate.of(1998, 4, 29), 55, null, null,
				89);
		Estudiante est3 = new Estudiante(144, "Palomita", "78458985k", 'M', LocalDate.of(1998, 4, 29), 55, null, null,
				89);

		estudiantes[2] = est1;
		estudiantes[10] = est2;
		estudiantes[5] = est3;
		
		estudianteCentro[5][8] = est1;
		estudianteCentro[1][3] = est2;
		estudianteCentro[1][4] = est3;
	}
}
