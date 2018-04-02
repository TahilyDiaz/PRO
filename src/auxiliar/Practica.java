package auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Vehiculo;

public class Practica {
	// TERCERA EVALUACION
	
	
	
	
	// SEGUNDA EVALUACION

	public ArrayList introListas() {
		ArrayList<Estudiante> listaE;
		listaE = new ArrayList<Estudiante>();
		Estudiante est1 = new Estudiante(123);

		listaE.add(est1); // añadir a la lista
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);

		int tam = listaE.size(); // tamaño lista

		Estudiante est2 = new Estudiante(321);
		listaE.add(0, est2);

		listaE.remove(listaE.size() - 1); // borrar

		// listaE.set(0, est1); //cambiar

		// Estudiante e = listaE.get(0); //obtener en esa posicion

		/*
		 * for (Estudiante estudiante : listaE) {
		 * System.out.println(estudiante.getCodGrupo()); }
		 * 
		 * for (int i = 0; i < listaE.size(); i++) { System.out.println(listaE.get(i));
		 * }
		 */

		System.out.println("fin introListas");

		return listaE;
	}

	public void listaEstudiantes(ArrayList<Estudiante> lista) {
		for (Estudiante estudiante : lista) {
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public ArrayList<Integer> convierteCadenasANumeros(ArrayList<String> cadenas) {
		ArrayList<Integer> resultado = new ArrayList<Integer>();

		for (String cadena : cadenas) {
			try {
				resultado.add(Integer.parseInt(cadena));
			} catch (NumberFormatException e) {
				resultado.add(-1);
			}
		}
		return resultado;
	}

	// Leer matriz y devolverla como ArrayList
	public ArrayList<ArrayList<Integer>> convierteMatrizArrayLista(int[][] matriz) {

		ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();

		for (int[] fila : matriz) {
			ArrayList<Integer> lista2 = new ArrayList<Integer>();
			for (int numero : fila) {
				lista2.add(numero);
			}
			resultado.add(lista2);
		}
		return resultado;
	}

	// Mapas, clase HashMap

	public HashMap<String, Estudiante> introMapas() {
		// la clave representa el nif del estudiante
		HashMap<String, Estudiante> resultado = new HashMap<String, Estudiante>();
		Estudiante est = new Estudiante(123, "Paco", "435G", 'M', null, 180, null, null, 12);

		resultado.put(est.getNif(), est);
		Estudiante estudiante = resultado.get("435G");
		Estudiante est2 = new Estudiante(123, "Carlos", "435G", 'M', null, 180, null, null, 12);

		resultado.put("435G", est2);

		resultado.put("444H", new Estudiante(122, "Paca", "444H", 'F', null, 185, null, null, 5));

		Set<String> claves = resultado.keySet();
		for (String clave : claves) {
			// System.out.println(resultado.get(clave).getNombre());
		}

		return resultado;
	}

	public int calculaEdad(String fechaNacimiento) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		System.out.printf("Tu edad es: %s años, %s meses y %s dias ", periodo.getYears(), periodo.getMonths(),
				periodo.getDays());
		return periodo.getYears();
	}

	public void leerFicheroTexto() {
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/personas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("&&");
				System.out.println(calculaEdad(campos[2]));
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerFicheroTextoOrdenado(String rutaFichero) {
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			String codigo_leido, codigo_anterior = null;
			int contadorTotal = 0;
			int contadorGrupos = 0;

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("&&");

				codigo_leido = campos[0];

				if (codigo_anterior == null) {
					codigo_anterior = codigo_leido;
				}

				if (!codigo_leido.equals(codigo_anterior)) {
					System.out.println("Hay " + contadorGrupos + " alumnos en el grupo " + codigo_anterior);
					contadorTotal += contadorGrupos;
					contadorGrupos = 0;
					codigo_anterior = codigo_leido;
				}
				contadorGrupos++;
			}
			System.out.println("Hay en total: " + contadorTotal);

			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerFicheroTextoEdad() {
		try {
			// Abrir el fichero
			int contador = 0;
			int acumulador = 0;

			FileReader fr = new FileReader("ficheros/personas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("&&");
				int edad = calculaEdad(campos[2]);
				System.out.println(edad);
				contador++;
				acumulador += edad;
				System.out.println(acumulador);
			}

			int resultado = acumulador / contador;
			System.out.println(resultado);
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String> leerFicheroArrayList(String fic) {
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(fic);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			// Leer el fichero linea a linea
			ArrayList<String> lista = new ArrayList<String>();
			while ((linea = br.readLine()) != null) {
				lista.add(linea);
			}
			fr.close();
			br.close();
			return lista;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	public HashMap<String, String> leerFicheroHashMap(String fic) {
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(fic);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Leer el fichero linea a linea
			HashMap<String, String> mapa = new HashMap<String, String>();
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("&&");
				String nif = campos[0];
				mapa.put(nif, linea);
			}
			fr.close();
			br.close();
			return mapa;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	public HashMap<String, ArrayList<Float>> resumenVentasVendedor(String ficheroVentas) {
		HashMap<String, ArrayList<Float>> resultado = new HashMap<String, ArrayList<Float>>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(ficheroVentas);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			System.out.println(LocalDate.now());
			// Leer el fichero linea a linea

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("%");
				if (resultado.get(campos[1]) == null) {
					resultado.put(campos[1], new ArrayList<Float>());
				}
				resultado.get(campos[1]).add(Float.parseFloat(campos[2]));
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	// ----------TOTAL POR VENDEDOR------

	public HashMap<String, Float> resumenVentasPorVendedor(HashMap<String, ArrayList<Float>> ventas) {
		HashMap<String, Float> resultado = new HashMap<String, Float>();
		Set<String> claves = ventas.keySet();
		for (String clave : claves) {
			float acumuladoVendedor = 0f;
			ArrayList<Float> listaVentas = ventas.get(clave);
			for (Float importe : listaVentas) {
				acumuladoVendedor += importe;
			}
			resultado.put(clave, acumuladoVendedor);
		}
		return resultado;
	}

	public int generaAleatoriosN(int min, int max) {
		int num = (int) (Math.random() * (max - min + 1)) + min;
		return num;
	}

	// ESCRIBIR FICHERO
	public void generaFicheroLanzamientosDado(int cuantos, String rutaFichero) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero));
			for (int i = 1; i <= cuantos; i++) {
				int numero = generaAleatoriosN(1, 6);
				bw.write(i + "#" + numero + "\n");
			}
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// GRABAR OBJETOS EN FICHERO
	public static void grabarObjetosEnFichero(String fichero) {
		Estudiante est = new Estudiante(1, "Carlos1", "111G", 'M', null, 180, null, null, 12);
		Estudiante est1 = new Estudiante(2, "Carlos2", "222G", 'M', null, 180, null, null, 12);
		Estudiante est2 = new Estudiante(3, "Carlos3", "333G", 'M', null, 180, null, null, 12);

		// abrir fichero de objetos
		try {
			FileOutputStream fOs = new FileOutputStream(fichero);
			ObjectOutputStream fObj = new ObjectOutputStream(fOs);

			// guardar los objetos estudiantes en el fichero
			fObj.writeObject(est);
			fObj.writeObject(est1);
			fObj.writeObject(est2);
			fObj.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		}
		System.out.println("FIN DEL METODO");
	}

	public static Estudiante crearEstudianteLeido(String[] datos) {
		int grupo = Integer.parseInt(datos[0]);
		Estudiante estudiante = new Estudiante(grupo);
		estudiante.setNif(datos[1]);
		estudiante.setNombre(datos[2]);
		estudiante.setSexo(datos[3].charAt(0));

		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate fechaNac = LocalDate.parse(datos[4], form);
		estudiante.setFecha(fechaNac);

		estudiante.setAltura(Integer.parseInt(datos[5]));
		estudiante.setMadre(null);
		estudiante.setPadre(null);

		return estudiante;
	}

	public static void escribirEstudiantesObjetosATxt(String rutaTxt, String rutaObjeto) {

		try {
			// Abrir el fichero de entrada
			FileInputStream fIs = new FileInputStream(rutaObjeto);
			ObjectInputStream fObj = new ObjectInputStream(fIs);

			// recorrer fichero
			Estudiante est = null;
			while (fIs.available() > 0) {
				est = (Estudiante) fObj.readObject();
				System.out.println(est.getNif());
			}
			fIs.close();
			fObj.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void escribirEstudiantesTxtAObjetos(String rutaObjeto, String rutaTxt) {

		try {
			// Abrir el fichero de entrada
			FileReader fr = new FileReader(rutaTxt);
			BufferedReader br = new BufferedReader(fr);
			// Abrir el fichero de salida
			FileOutputStream fOs = new FileOutputStream(rutaObjeto);
			ObjectOutputStream fObj = new ObjectOutputStream(fOs);

			String linea;

			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("#");
				// crear estudiante a partir del registro leido
				Estudiante estudiante = crearEstudianteLeido(campos);
				// guardar los objetos estudiantes en el fichero
				fObj.writeObject(estudiante);
			}
			fr.close();
			br.close();
			fObj.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// LEER FICHERO
	public void leeObjetosDesdeFichero(String fichero) {
		try {
			FileInputStream fIs = new FileInputStream(fichero);

			ObjectInputStream fObj = new ObjectInputStream(fIs);

			// recorrer fichero
			Estudiante est = null;
			while (fIs.available() > 0) {
				est = (Estudiante) fObj.readObject();
				System.out.println(est.getNif());
			}
			fIs.close();
			fObj.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		}
	}

	// GRABAR LISTA EN FICHERO
	public static void grabarObjetosListaEnFichero(String fichero) {
		Estudiante est = new Estudiante(1, "Carlos1", "111G", 'M', null, 180, null, null, 12);
		Estudiante est1 = new Estudiante(2, "Carlos2", "222G", 'M', null, 180, null, null, 12);
		Estudiante est2 = new Estudiante(3, "Carlos3", "333G", 'M', null, 180, null, null, 12);

		ArrayList<Estudiante> listaEst = new ArrayList<Estudiante>();
		listaEst.add(est);
		listaEst.add(est1);
		listaEst.add(est2);

		// abrir fichero de objetos
		try {
			FileOutputStream fOs = new FileOutputStream(fichero);
			ObjectOutputStream fObj = new ObjectOutputStream(fOs);

			// guardar los objetos estudiantes en el fichero
			fObj.writeObject(listaEst);
			fObj.close();
			fOs.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		}
		System.out.println("FIN DEL METODO");
	}

	// LEER FICHERO CON LISTA
	public void leeObjetosDesdeFichero2(String fichero) {
		try {
			FileInputStream fIs = new FileInputStream(fichero);

			ObjectInputStream fObj = new ObjectInputStream(fIs);

			// recorrer fichero
			Estudiante est = null;
			ArrayList<Estudiante> lista = null;
			while (fIs.available() > 0) {
				lista = (ArrayList<Estudiante>) fObj.readObject();
			}
			System.out.println(lista.get(0).getNombre());
			fIs.close();
			fObj.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		}
	}

	// LEE Y DEVUELVE UN ARRAYLIST
	public ArrayList<Vehiculo> repasoMetodo1(String fichero) {
		ArrayList<Vehiculo> resultado = new ArrayList<Vehiculo>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("#");
				DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyyMMdd");
				LocalDate fecha = LocalDate.parse(campos[3], form);
				Vehiculo veh = new Vehiculo(Integer.parseInt(campos[0]), campos[1], campos[2], fecha,
						Float.parseFloat(campos[4]));
				resultado.add(veh);

				/**/
			}
			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return resultado;
	}

	// GRABA UN FICHERO CON OBJETOS
	public void vehiculoEnFichero(ArrayList<Vehiculo> listaVehiculo, String fichero) {
		try {
			ObjectOutputStream fObj = new ObjectOutputStream(new FileOutputStream(fichero));

			for (Vehiculo vehiculo : listaVehiculo) {
				fObj.writeObject(vehiculo);
			}

			fObj.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void inicializaVisitantesIsla(HashMap<Integer, ArrayList<Float>> resultado) {
		ArrayList<Float> visitantesMeses;
		for (int isla = 0; isla < 7; isla++) { // recorre islas
			visitantesMeses = new ArrayList<Float>();
			for (int mes = 0; mes < 12; mes++) // pone a cero los meses
				visitantesMeses.add(0f);
			resultado.put(isla, visitantesMeses);
		}
	}

	public HashMap<Integer, ArrayList<Float>> contarVisitantesIslas(String fichero) {
		HashMap<Integer, ArrayList<Float>> resultado = new HashMap<Integer, ArrayList<Float>>();

		try {
			// Abrir el fichero
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;

			inicializaVisitantesIsla(resultado);

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("@");
				int isla = Integer.parseInt(campos[0]);
				int mes = Integer.parseInt(campos[1]);
				float numeroVisitantes = Float.parseFloat(campos[2]);

				resultado.get(isla - 1).set(mes - 1, numeroVisitantes);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return resultado;
	}

	public void listadoIslasMeses(String fichero) {
		HashMap<Integer, ArrayList<Float>> xyzz = contarVisitantesIslas(fichero);
		// recorrer el HashMap
		String[] islas = { "GRAN CANARIA", "LANZAROTE", "FUERTEVENTURA", "TENERIFE", "LA PALMA", "LA GOMERA",
				"EL HIERRO" };
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		Set<Integer> claves = xyzz.keySet();
		System.out.print("\t\t\t\t");

		for (int i = 0; i < meses.length; i++) {
			System.out.print(meses[i] + "\t");
		}
		System.out.println();

		float acumuladorMes[] = new float[12];

		for (Integer clave : claves) {
			ArrayList<Float> visitantes = xyzz.get(clave);
			System.out.print(islas[clave] + "\t");
			float acumuladorIsla = 0f;

			for (int i = 0; i < visitantes.size(); i++) {
				acumuladorIsla += visitantes.get(i);
				acumuladorMes[i] += visitantes.get(i);
				System.out.printf("%.0f\t", visitantes.get(i) * 1000);
			}

			System.out.println("total visitantes " + islas[clave] + " = " + acumuladorIsla);
			System.out.println();
		}
		for (float acuMes : acumuladorMes) {
			System.out.print("\t\t" + acuMes);
		}
	}

	
	// LISTADO DE PROVINCIAS POR CCAA.
	// Primer metodo
	// Leer fichero y meter comunidades en AL
	
	public String[] leerCA(String rutaComunidades) {
		String[] comunidades = new String[19];
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaComunidades);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null)
				comunidades[i++] = linea.split("%")[1];
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return comunidades;
	}
	
	
	// Segundo metodo
	// Recorrer provincias y crear HM con cada comunidad de clave
	// y valor la lista de sus provincias
	// devolver HM
	
	public HashMap<String, ArrayList<String>> generarDatosListadoProvincias(String rutaProvincias) {
		String[] comunidades = leerCA("ficheros/comunidades.txt");
		HashMap<String, ArrayList<String>> datosListado = new HashMap<String, ArrayList<String>>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaProvincias);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("%");
				if (datosListado.get(comunidades[Integer.parseInt(campos[2]) - 1]) == null) 
				{
					datosListado.put(comunidades[Integer.parseInt(campos[2]) - 1], new ArrayList<String>());
				}
				datosListado.get(comunidades[Integer.parseInt(campos[2]) - 1]).add(campos[1] + "#" + campos[3]);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return datosListado;
	}

	
	// Tercer metodo
	// Recorrer y listar HM anterior
		
	public void listadoProvinciasPorCA(HashMap<String, ArrayList<String>> datosListado) {
		// recorrer hm de entrada creando el de salida
		Set<String> comunidades = datosListado.keySet();
		for (String comunidad : comunidades) {
			ArrayList<String> listaProvincias = datosListado.get(comunidad);
			int acumuladoCA = 0;
			System.out.println("CCAA : " + comunidad);
			for (String provincia : listaProvincias) {
				acumuladoCA += Integer.parseInt(provincia.split("#")[1]);
				System.out.println(provincia.split("#")[0] + ", " + provincia.split("#")[1]);
			}
			System.out.println("Total padrón CCAA : " + comunidad + " = " + acumuladoCA);
		}
	}

	
	
	///////PRUEBAS
	
	public int[] getVisitantesMesYear(ArrayList<HashMap<Integer, Integer>> listaVisitantes) {
		int[] visitantesAcumuladoMes = new int[12];
		for (int i = 0; i < 12; i++) { // recorremos los meses, horizontalmente
			visitantesAcumuladoMes[i] = 0;
			for (int j = 0; j < 7; j++) // recorremos las islas, verticalmente
				visitantesAcumuladoMes[i] += listaVisitantes.get(j).get(i).intValue();
		}
		return visitantesAcumuladoMes;
	}

	public int[] getVisitantesIslaYear(ArrayList<HashMap<Integer, Integer>> listaVisitantes) {
		int[] visitantesAcumuladoIsla = new int[listaVisitantes.size()];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < listaVisitantes.size(); i++) {
			visitantesAcumuladoIsla[i] = 0;
			hm = listaVisitantes.get(i);
			Set<Integer> claves = hm.keySet();
			for (Integer clave : claves) {
				visitantesAcumuladoIsla[i] += hm.get(clave).intValue();
			}
		}
		return visitantesAcumuladoIsla;
	}

	public void mostrarVisitantesIslaMes(ArrayList<HashMap<Integer, Integer>> listaVisitantes) {
		String[] meses = { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE",
				"OCTUBRE", "NOVIEMBRE", "DICIEMBRE" };
		String[] islas = { "GRAN CANARIA", "LANZAROTE", "FUERTEVENTURA", "TENERIFE", "LA PALMA", "GOMERA",
				"EL HIERRO" };
		int isla = 0;
		for (String mes : meses) {
			System.out.print("\t" + mes);
		}
		System.out.println();
		for (HashMap<Integer, Integer> visitasIslaYear : listaVisitantes) {
			System.out.println(islas[isla++]);
			for (Integer mes = 0; mes < 12; mes++)
				System.out.print("\t" + visitasIslaYear.get(mes).intValue());
			System.out.println();
		}
	}
	
	
	
	
	// PRIMERA EVALUACION

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

	public ArrayList<Integer> generaAleatoriosArrayList(int repetir, int min, int max) {

		ArrayList<Integer> aleatorios = new ArrayList<Integer>();

		for (int i = 0; i < repetir; i++) {
			aleatorios.add((int) (Math.random() * (max - min + 1)) + min);
		}

		return aleatorios;
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

	public static void listarEst(ArrayList<Estudiante> lista) {
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

	public static void listarEst3(ArrayList<Estudiante> lista) {
		int contador1 = 0;
		ArrayList<String> lista2 = new ArrayList<String>();
		// String[] lista2 = new String[contador1];

		// Para recorrer el array y contar el numero de parametros no null
		for (Estudiante estudiante : lista) {
			if (estudiante != null) {
				contador1++;
			}
		}

		// Nuevo contador para ir incrementando el indice
		for (Estudiante estudiante : lista) {
			if (estudiante != null) {
				lista2.add(estudiante.getNombre());
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

	public void listarTodos(ArrayList<ArrayList<Estudiante>> todos) {
		int contador2 = 0;
		ArrayList<Estudiante> estudiantes2 = new ArrayList<Estudiante>();
		for (int i = 0; i < todos.size(); i++) {
			for (int j = 0; j < todos.get(i).size(); j++) {
				if (todos.get(i).get(j) != null) {
					System.out.println("nombre: " + todos.get(i).get(j).getNombre());
					estudiantes2.set(contador2, todos.get(i).get(j));
					contador2++;
				}
			}
		}
		for (Estudiante estudiante : estudiantes2) {
			System.out.println(estudiante);
			;
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

	public ArrayList<Integer> convierteCadenasANumerosArrayList(ArrayList<String> cadenas) {

		ArrayList<Integer> resultado = new ArrayList<Integer>();

		for (String cadena : cadenas) {
			try {
				resultado.add(Integer.parseInt(cadena));
			} catch (NumberFormatException e) {
				resultado.add(-1);
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

	public ArrayList<Integer> ordenaEnterosArrayList(ArrayList<Integer> numeros) {
		Collections.sort(numeros);
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
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j]);
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
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j].toString());
				} catch (NullPointerException e) {
					System.out.println("Null");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Bound");
				}
			}
		}
	}

	public void hundirFlota(char[][] tablero) {
		int a = 2;
		int ca = 0;
		int b = 2;
		int cb = 0;
		int c = 3;
		int cc = 0;
		int d = 1;
		int cd = 0;
		int e = 5;
		int ce = 0;
		int fin = 13;
		int cf = 0;
		while (true) {
			System.out.println("PRIMERA COORDENADA: ");
			Scanner sc = new Scanner(System.in);
			int uno = sc.nextInt();
			System.out.println("SEGUNDA COORDENADA: ");
			int dos = sc.nextInt();

			if (tablero[uno][dos] == 'a') {
				ca++;
				cf++;
				System.out.println("TOCADO!");
				if (ca == a) {
					System.out.println("¡HUNDIDO!");
				}
			}
			if (tablero[uno][dos] == 'b') {
				cb++;
				cf++;
				System.out.println("TOCADO!");
				if (cb == b) {
					System.out.println("¡HUNDIDO!");

				}
			}
			if (tablero[uno][dos] == 'c') {
				cc++;
				cf++;
				System.out.println("TOCADO!");
				if (cc == c) {
					System.out.println("¡HUNDIDO!");

				}
			}
			if (tablero[uno][dos] == 'd') {
				cd++;
				cf++;
				System.out.println("TOCADO!");
				if (cd == d) {
					System.out.println("¡HUNDIDO!");

				}
			}
			if (tablero[uno][dos] == 'e') {
				ce++;
				cf++;
				System.out.println("TOCADO!");
				if (ce == e) {
					System.out.println("¡HUNDIDO!");

				}
			}

			if (tablero[uno][dos] == 'x') {
				System.out.println("VUELVA A INTENTARLO.");
			}

			if (cf == fin) {
				System.out.println("Fin del juego, GANASTE!");
			}
		}
	}
}
