package auxiliar;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import modelo.Datos;
import modelo.Equipo;
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
		while (num != 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}

	public int cadenaSumaNumeros(String num1) {
		int largocad = num1.length();
		int sum = 0;

		for (int i = 0; i < largocad; i++) {
			if (Character.isDigit(num1.charAt(i)))
				sum += Integer.parseInt("" + num1.charAt(i));
		}
		return sum;
	}

	public int[] ordenaEnteros(int[] numeros) {
		int aux;
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int j = i + 1; j < numeros.length; j++) {
				if (numeros[j] < numeros[i]) {
					aux = numeros[i];
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
			for (int j = i + 1; j < numeros.length; j++) {
				if (numeros[i] > numeros[j]) {
					aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
			}
		}
	}

	public void ordenaCadenas(String[] cadena) {
		String aux;
		for (int i = 0; i < cadena.length - 1; i++) {
			for (int j = i + 1; j < cadena.length; j++) {
				if (cadena[i].compareTo(cadena[j]) > 0) {
					aux = cadena[i];
					cadena[i] = cadena[j];
					cadena[j] = aux;
				}
			}
		}
	}

	public void ordenarEstudiantes(Estudiante[] estudiantes) {
		Estudiante aux;
		for (int i = 0; i < estudiantes.length - 1; i++) {
			for (int j = i + 1; j < estudiantes.length; j++) {
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					aux = estudiantes[i];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}
			}
		}
	}

	public int[] ordenarLista(int[] l1, int[] l2) {
		Practica pr = new Practica();

		pr.ordenaEnteros(l1);
		pr.ordenaEnteros(l2);

		int[] l3 = new int[l1.length + l2.length];

		int i = 0, j = 0, ind = 0;

		while (true) {
			if (l1[i] < l2[j]) {
				l3[ind] = l1[i];
				i++;
			} else {
				l3[ind] = l2[j];
				j++;
			}

			ind++;

			if (i == l1.length) {
				for (int k = j; k < l2.length; k++) {
					l3[ind] = l2[k];
					ind++;
				}
				break;
			}

			if (j == l2.length) {
				for (int m = i; m < l1.length; m++) {
					l3[ind] = l1[m];
					ind++;
				}
				break;
			}
		}
		return l3;
	}

	// SOLUCIÓN MAURICIO
	public int[] mezclaArrays(int[] l1, int[] l2) {
		int i = 0, j = 0, k = 0;
		int[] resultado = new int[l1.length + l2.length];

		while (l1[i] != Integer.MAX_VALUE || l2[j] != Integer.MAX_VALUE) {
			if (l1[i] < l2[j]) {
				resultado[k] = l1[i++];
			} else {
				resultado[k] = l2[j++];
			}

			k++;

			if (i == l1.length) {
				l1[--i] = Integer.MAX_VALUE;
			}

			if (j == l2.length) {
				l2[--j] = Integer.MAX_VALUE;
			}
		}
		return resultado;
	}

	public boolean validarNIF(String nif) {
		// Letras posibles en orden.
		char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		String numcad = "";

		if (nif.length() != 9) {
			return false;
		} else {

			// Si el último caracter es una letra.
			if (!Character.isLetter(nif.charAt(8))) {
				return false;
			}
		}

		// Si son digitos
		for (int i = 0; i < 8; i++) {
			if (!Character.isDigit(nif.charAt(i))) {
				return false;
			}
			numcad += nif.charAt(i);
		}

		int numDni = Integer.parseInt(numcad);

		// Comprobar si la letra corresponde
		numDni %= 23;
		if ((Character.toUpperCase(nif.charAt(8))) != letrasValidas[numDni]) {
			return false;
		}
		return true;
	}

	public int[] obtenerClasificacion(String[][] goles) {
		int[] puntos = new int[20];
		int golesLocal;
		int golesVisitantes;

		for (int i = 0; i < goles.length; i++) {
			for (int j = 0; j < goles[i].length; j++) {
				if (goles[i][j].indexOf("-") != -1) {
					String[] resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitantes = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitantes) {
						puntos[i] += 3;
					} else {
						if (golesLocal < golesVisitantes) {
							puntos[j] += 3;
						} else {
							puntos[i] += 1;
							puntos[j] += 1;
						}
					}
				}
			}
		}
		return puntos;
	}

	public void ordenaClasificacion(int[] numeros, String[] equipos) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] < numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
					String aux2 = equipos[i];
					equipos[i] = equipos[j];
					equipos[j] = aux2;
				}
	}

	public int[] obtenerClasificacionColumnas(String[][] goles) {
		int[] puntos = new int[20];
		int golesLocal;
		int golesVisitantes;

		for (int i = 0; i < goles.length; i++) {
			for (int j = 0; j < goles[i].length; j++) {
				if (goles[j][i].indexOf("-") != -1) {
					String[] resultado = goles[j][i].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitantes = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitantes) {
						puntos[j] += 3;
					} else {
						if (golesLocal < golesVisitantes) {
							puntos[i] += 3;
						} else {
							puntos[j] += 1;
							puntos[i] += 1;
						}
					}
				}
			}
		}
		return puntos;
	}

	public Equipo[] obtenerClasificacionJornadas(int[][] ptsJornada) {
		Equipo[] clasificacion = new Equipo[20];
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < ptsJornada[0].length; j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.length; i++) {
				e.setPuntos(e.getPuntos() + ptsJornada[i][j]);
				clasificacion[j] = e;
			}
		}
		return clasificacion;
	}

	public boolean esPrimo(int numero) {
		int contador = 0;
		for (int i = 1; i <= numero; i++) {
			if (numero % i == 0) {
				contador = contador + 1;
			}
		}

		if (contador > 2) {
			return false;
		}
		return true;
	}

	public int[] listaPri(int numero) {

		int[] primos = new int[numero];
		int i = 0;
		int j = 1;

		while (i < numero) {
			if (esPrimo(j)) {
				primos[i++] = j;
			}
			j++;
		}
		return primos;
	}

	public int[] listaPri2(int numero) {
		int[] listaPrimo2 = new int[numero];
		int indice = 0;
		int j = 1;

		for (int i = 0; i < numero; i++) {
			if (esPrimo(j)) {
				listaPrimo2[i] = j;
			}
			j++;
		}
		return listaPrimo2;
	}

	public int[] numFibo(int cuantos) {
		int[] listaFibo = new int[cuantos];
		int fibo1 = 0;
		int fibo2 = 1;
		int fibo3;
		listaFibo[0] = fibo1;
		listaFibo[1] = fibo2;

		for (int i = 2; i < cuantos; i++) {

			fibo3 = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibo3;
			listaFibo[i] = fibo3;
		}
		return listaFibo;
	}

	public String invierteCadenas(String cadena) {
		String ncadena = "";
		for (int i = cadena.length() - 1; i >= 0; i--) {
			ncadena = ncadena + cadena.charAt(i);
		}
		return ncadena;
	}

	public int cuentaPalabras(String cadena) {
		int cuenta = 1, pos;
		cadena = cadena.trim();
		if (cadena.isEmpty()) {
			cuenta = 0;
		} else {
			pos = cadena.indexOf(" ");
			while (pos != -1) {
				cuenta++;
				pos = cadena.indexOf(" ", pos + 1);
			}
		}
		return cuenta;
	}

	public int sumaDiagonal(int[][] matriz) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				try {
					if (i == j) {
						suma += matriz[i][j];
					}
				} catch (Exception e) {
				}
			}
		}
		return suma;
	}

	public int maximo(int[] numeros) {
		int aux;
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int j = i + 1; j < numeros.length; j++) {
				if (numeros[j] < numeros[i]) {
					aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
			}
		}
		int n = numeros.length - 1;
		int maximo = numeros[n];
		return maximo;
	}

	public void recorrerMatrizIrregularColumnas(int[][] matriz) {
		int longitudMax = 0;
		System.out.println("---------------------------");
		for (int i = 0; i < matriz.length; i++) {
			if (longitudMax < matriz[i].length) {
				longitudMax = matriz[i].length;
			}
		}

		System.out.println("maximo: " + longitudMax);

		for (int j = 0; j < longitudMax; j++) {
			System.out.println("Columna " + j + ":");
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("["+i+"]["+j+"]: " +matriz[i][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}
	
	public void recorrerMatrizIrregularColumnasNull(Integer[][] matriz) {
		int longitudMax = 0;
		System.out.println("---------------------------");
		for (int i = 0; i < matriz.length; i++) {
			if (longitudMax < matriz[i].length) {
				longitudMax = matriz[i].length;
			}
		}

		System.out.println("maximo: " + longitudMax);

		for (int j = 0; j < longitudMax; j++) {
			System.out.println("Columna " + j + ":");
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("["+i+"]["+j+"]: " +matriz[i][j].toString());
				} catch (NullPointerException e) {
					System.out.println("Null");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Bound");
				}
			}
		}
	}

}
