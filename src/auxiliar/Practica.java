package auxiliar;

import modelo.Datos;
import modelo.Estudiante;

public class Practica {

	// private static String[] diasSem = { "Lunes", "Martes", "Miercoles", "Jueves",
	// "Viernes", "Sabado", "Domingo" };

	public void muestraNumerosDe1a100While() {
		int a = 1;
		while (a <= 100) {
			System.out.println(a);
			a++;
		}
	}

	public void muestraNumerosDe1a100For() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
	}

	public void muestraFor2(int min, int max) {
		if (min > max) {
			System.out.println("Minimo mayor que maximo");
		} else {
			for (int i = min; i <= max; i++)
				System.out.println(i);
		}
	}

	public void muestraRango(int min, int max) {
		if (min > max) {
			System.out.println("Minimo mayor que maximo");
		} else {
			do {
				System.out.println("x: " + min);
				min++;
			} while (min <= max);
		}
	}

	public void generaAleatorios(int repetir, int min, int max) {
		int rand = 0;

		for (int i = 1; i <= repetir; i++) {
			rand = (int) (Math.random() * (max - min + 1)) + min;
			System.out.println(rand);

		}
	}

	public void estadisticaCadena(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			System.out.println("Caracteres: " + cadena.charAt(i));
		}
	}

	public void estadisticaCadena1(String cadena) {
		int i = 0;
		while (i < cadena.length()) {
			System.out.println("Caracteres: " + cadena.charAt(i));
			i++;
		}
	}

	public void saberTipo(String cadena) {
		int contadorVocales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			System.out.println("Caracteres: " + cadena.charAt(i));
			int n = (int) cadena.charAt(i);

			if (n == 97 || n == 101 || n == 105 || n == 111 || n == 117 || n == 65 || n == 69 || n == 73 || n == 79
					|| n == 85) {

				// System.out.println("Vocal minuscula: " + cadena.charAt(i));

				contadorVocales++;
			}
		}
		System.out.println("Contador vocales minusculas: " + contadorVocales);
	}

	public void contadorVocales(String cadena) {
		int contVoc = 0;
		for (int i = 0; i < cadena.length(); i++) {
			char n = cadena.charAt(i);
			if (n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u') {
				contVoc++;
			}
		}
		System.out.println("nº voc: " + contVoc);
	}

	public void saberMayusculas(String cadena) {
		int contadorMayusculas = 0;
		for (int i = 0; i < cadena.length(); i++) {
			System.out.println("Caracteres: " + cadena.charAt(i));
			int n = (int) cadena.charAt(i);

			if (n >= 65 && n <= 90) {
				contadorMayusculas++;
			}

		}
		System.out.println("contador mayusculas: " + contadorMayusculas);
	}

	public void saberTodoTipo(String cadena) {
		int contadorMay = 0;
		int contadorMin = 0;
		int contadorNum = 0;
		int contadorEsp = 0;
		int contadorEspeciales = 0;

		for (int i = 0; i < cadena.length(); i++) {
			System.out.println("Caracteres: " + cadena.charAt(i));
			int n = (int) cadena.charAt(i);

			if (n >= 65 && n <= 90) {
				contadorMay++;
			}

			if (n >= 97 && n <= 122) {
				contadorMin++;
			}

			if (n >= 48 && n <= 57) {
				contadorNum++;
			}

			if (n == 32) {
				contadorEsp++;
			}
			if (n >= 33 && n <= 47 || n >= 58 && n <= 64 || n >= 91 && n <= 96 || n >= 123 && n <= 191) {
				contadorEspeciales++;
			}
		}

		System.out.println("contador mayusculas: " + contadorMay);
		System.out.println("contador minusculas: " + contadorMin);
		System.out.println("contador números: " + contadorNum);
		System.out.println("contador espacios: " + contadorEsp);
		System.out.println("contador espacios: " + contadorEspeciales);
	}

	public int[] generaAleatoriosArray(int repetir, int min, int max) {
		int[] ale = new int[repetir];

		for (int i = 0; i < repetir; i++) {
			ale[i] = (int) (Math.random() * (max - min + 1)) + min;
		}
		return ale;
	}

	public int[] estadisticaArray(int repetir, int mini, int maxi) {
		int[] ale = new int[repetir];
		int[] contador = new int[maxi - mini + 1];
		int cont;

		for (int i = 0; i < repetir; i++) {
			cont = (int) (Math.random() * (maxi - mini + 1)) + mini;
			ale[i] = cont;
			contador[cont - 1]++;
			System.out.println("n : " + ale[i]);
		}
		return contador;
	}

	public int[] frecuenciaAparicion(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamientos = this.generaAleatoriosArray(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.length; i++) {
			resultado[lanzamientos[i] - 1]++;
		}
		return resultado;

	}

	public static void diasSemana() {
		// String[] diasSem = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes",
		// "Sabado", "Domingo" };

		Datos datos = new Datos();

		/*
		 * for (int i = 0; i < datos.getDiasSem().length; i++) {
		 * System.out.println(datos.getDiasSem()[i]); }
		 */

		for (String dias : datos.getDiasSem()) {
			System.out.println(dias);
		}
	}

	public static void listarEstudiantes(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public static void listarEst(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			try {
				System.out.println(estudiante);
			} catch (NullPointerException e) {

			}
		}
	}

	public static void listarEst2(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			if (estudiante != null) {
				System.out.println(estudiante);
			}
		}
	}

	public static void listarEst3(Estudiante[] lista) {
		int contador1 = 0;
		int ind = 0;
		String[] lista2 = new String[contador1];

		// Para recorrer el array y contar el numero de parametros no null
		for (Estudiante estudiante : lista) {
			if (estudiante != null) {
				contador1++;
			}
		}

		// Nuevo contador para ir incrementando el indice
		for (Estudiante estudiante : lista) {
			if (estudiante != null) {
				lista2[ind] = estudiante.getNombre();
				ind++;
			}
		}

		// Mostramos por pantalla
		for (String lis2 : lista2) {
			System.out.println(lis2);
		}
	}

	public static void listarTodosEst(Estudiante[][] todos) {
		for (int i = 0; i < todos.length; i++) {
			for (int j = 0; j < todos[i].length; j++) {
				try {
					System.out.println(todos[i][j].getNombre());
				} catch (NullPointerException e) {
				}
			}
		}
	}

	public int visitantesIslaYear(int isla, int[][] visitantesYear) {
		int acu = 0;
		for (int j = 0; j < visitantesYear[isla].length; j++) {
			acu += visitantesYear[isla][j];
		}
		return acu;
	}

	public int visitantesIslaMes(int mes, int[][] visitantesMes) {
		int acu2 = 0;
		for (int i = 0; i < visitantesMes.length; i++) {
			acu2 += visitantesMes[i][mes];
		}
		return acu2;
	}

	public static void Reloj() {
		int[][][] time = new int[24][60][60];
		int h = 0;

		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < time[i].length; j++) {
				int j3 = 0;
				for (int j2 = 0; j2 < time[i][j].length; j2++) {
					time[i][j][j2] = j3++;
				}
			}
		}

		for (int i = 0; i < time.length; i++) {
			int min = 0;
			for (int j = 0; j < time[i].length; j++) {
				for (int j2 = 0; j2 < time[i][j].length; j2++) {
					System.out.println(h + ":" + min + ":" + time[i][j][j2]);
				}
				min++;
			}
			h++;
		}
	}

	public int[] convierteCadenasANumeros(String[] cadenas) {
		int[] resultado = new int[cadenas.length];
		for (int i = 0; i < cadenas.length; i++) {
			try {
				resultado[i] = Integer.parseInt(cadenas[i]);
			} catch (NumberFormatException e) {
				resultado[i] = -1;
			}
		}
		return resultado;
	}

	public float calculaSaldo(String[] movimientos, float saldoInicial) {
		float saldoFinal = saldoInicial;
		float[] res = new float[movimientos.length];
		
			for (int i = 0; i < movimientos.length; i++) {
				try {
					res[i] = Float.parseFloat(movimientos[i]);
					saldoFinal += res[i];
				} catch (NumberFormatException e) {
				}
			}
		
		return saldoFinal;
	}
	
	
	public int numerosSeparados(int num) {
		int sum = 0;
		while(num !=0) {
			sum+=num%10;
			num=num/10;
		}
		return sum;
	}
	
	public int cadenaSumaNumeros(String num1) {
		int largocad = num1.length();
		int sum = 0;
		
		for(int i=0; i<largocad; i++)
		{  
	         if (Character.isDigit(num1.charAt(i))) 
	            sum += Integer.parseInt("" + num1.charAt(i));         
	       }
		return sum;
	}
	
	public int[] ordenaEnteros(int[] numeros) {
		int aux;
		for (int i = 0; i < numeros.length -1; i++) {
			for (int j = i+1; j < numeros.length; j++) {
				if(numeros[j] < numeros[i]) {
					aux=numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
			}
		}
		return numeros;
	}
	
	
	public void ordenaEnteros2(int[] numeros) {
		int aux;
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int j = i+1; j < numeros.length; j++) {
				if(numeros[i] > numeros[j]) {
					aux=numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
			}
		}
	}
	
	
	public void ordenaCadenas(String[] cadena) {
		String aux;
		for (int i = 0; i < cadena.length -1; i++) {
			for (int j = i+1; j < cadena.length; j++) {
				if(cadena[i].compareTo(cadena[j]) > 0) {
					aux = cadena[i];
					cadena[i] = cadena[j];
					cadena[j] = aux;
				}
			}
		}
	}
	
	public void ordenarEstudiantes(Estudiante[] estudiantes) {
		Estudiante aux;
		for (int i = 0; i < estudiantes.length -1; i++) {
			for (int j = i+1; j < estudiantes.length; j++) {
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					aux = estudiantes[i];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}
			}
		}
	}
	
	
	
}
