package modelo;

import java.time.LocalDate;

public class Datos {
	private String[] diasSem = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
	private Estudiante[] estudiantes;
	private int numEstudiantes = 30;
	private int numColum = 10;
	private Estudiante[][] estudianteCentro;
	
	//Ejemplo de la liga

	private String[] equipos = {"Athletic Club","Atlético de Madrid","C.D. Leganés", "Deportivo Alavés", "Deportivo de La Coruña", "F.C. Barcelona", "Getafe C.F.", "Girona C.F.",
			"Levante U.D.", "Málaga C.F.", "R.C. Celta de Vigo", "R.C.D. Epañol", "Real Betis Balompié", "Real Madrid C.F.", "Real Sociedad", "S.D. Eibar", "Sevilla F.C.",
			"U.D. Las Palmas", "Valencia C.F.", "Villareal C.F."};
	private int[] puntosEquipos;
	private String[][] resultados = { //LOCAL
			{"", "2-1", "2-2", "2-3", "3-2", "5-3", "7-1", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "1-1","", "2-2", "2-3", "1-1", "1-2", "4-3", "3-1",  "3-2", "5-3", "7-1","2-2", "0-1", "8-2", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "2-1", "2-2", "","2-2", "1-1", "0-2", "6-3","3-3", "0-1", "0-2", "2-1",  "3-2", "5-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "3-1", "2-2", "2-3", "","1-1", "1-2", "7-3", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "4-1", "2-2", "2-3", "1-1","", "1-2", "8-3", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "5-1", "3-2", "5-3", "7-1", "5-2","","8-3", "5-1", "5-2", "5-3", "5-1", "5-2", "5-3", "5-1", "5-2", "5-3", "5-1", "5-2", "5-3", "5-1"},
			{ "6-1", "2-2", "2-3", "1-1", "1-2", "1-3", "","3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "7-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "","3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "1-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2","", "3-3", "2-1", "2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "2-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3","", "2-1", "2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "3-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1", "","2-2", "2-3", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "4-1", "2-2", "2-3", "1-1", "1-2",  "3-2", "5-3", "7-1","2-1", "2-2","", "0-2", "0-3", "8-2", "1-3", "3-1", "3-2", "3-3", "2-1","0-0"},
			{ "5-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3","", "8-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "0-1", "0-2", "0-3", "0-1", "0-2", "0-3", "0-1", "0-2", "0-3", "0-1", "0-2", "0-3", "0-1","","0-2", "0-3", "0-1", "0-2", "0-3", "0-1"},
			{ "7-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1",  "3-2", "5-3", "7-1", "8-2", "","1-3", "3-1", "3-2", "3-3", "2-1"},
			{ "8-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "8-2", "1-3","", "3-1", "3-2", "3-3", "2-1"},
			{ "21-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "8-2", "1-3", "3-1","", "0-2", "0-3", "2-1"},
			{ "2-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1", "3-2", "5-3", "7-1", "18-2", "1-3", "3-1", "3-2","", "3-3", "2-1"},
			{ "1-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1", "8-2", "1-3", "3-1", "3-2", "3-3", "","2-1"},
			{ "1-1", "2-2", "2-3", "1-1", "1-2", "1-3", "3-1", "3-2", "3-3", "2-1", "2-2", "2-3", "8-1",  "3-2", "5-3", "0-2", "0-3","3-3", "2-1",""}
	};
	
	
	
	

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

	public String[][] getResultados() {
		return resultados;
	}

	public void setResultados(String[][] resultados) {
		this.resultados = resultados;
	}

	public String[] getEquipos() {
		return equipos;
	}

	public void setEquipos(String[] equipos) {
		this.equipos = equipos;
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
