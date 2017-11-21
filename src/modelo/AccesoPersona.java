package modelo;

public class AccesoPersona {

	public static float cuantoAvanza(Persona quien, int numPasos) {
		// PARA QUE NOS DEVUELVA EL RESULTADO CON COMA
		float longitud = quien.getLongitudPaso();
		return numPasos * longitud / 100;
	}
	//
}
