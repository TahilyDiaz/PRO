package principal;

import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

import auxiliar.Practica;
import modelo.Datos;
import modelo.Equipo;
//import modelo.AccesoPersona;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Profesor;

public class Principal {

	public static void main(String[] args) {

		/*
		 * Persona persona1 = new Persona(); System.out.println(persona1.toString());
		 * 
		 * Persona persona2 = new Persona(); System.out.println(persona2.toString());
		 * 
		 * Persona persona3 = new Persona("Carmen", "45654546h", 'H', LocalDate.of(2000,
		 * 2, 5), 154, null, null, 487); System.out.println(persona3.toString());
		 * 
		 * persona2.setNombre("Yoandry"); System.out.println(persona2.toString());
		 * 
		 * Estudiante est1 = new Estudiante(145); System.out.println(est1.toString());
		 * 
		 * Estudiante est2 = new Estudiante(145, "Aeio", "56765456h", 'm',
		 * LocalDate.of(2011, 8, 9), 145, null, null, 789);
		 * System.out.println(est2.toString());
		 * 
		 * Estudiante est3 = new Estudiante(47); System.out.println(est3.toString());
		 * 
		 * System.out.println("Total de personas: " + Persona.getContadorInstancias());
		 * 
		 * Profesor pr1 = new Profesor(145, LocalDate.now());
		 * System.out.println(pr1.toString()); System.out.println("Personas: " +
		 * Persona.getContadorInstancias());
		 * 
		 * // METODOS DE LA CLASE PRACTICA--------------------
		 */

		Practica prac = new Practica();
		/*
		 * prac.muestraNumerosDe1a100While(); prac.muestraNumerosDe1a100For();
		 * 
		 * prac.muestraFor2(6, 11); prac.muestraRango(5, 10);
		 * 
		 * Random random1 = new Random();
		 *  int min = 10; 
		 *  int max = 30;
		 * System.out.println("Numero aleatorio : " + ((int) (random1.nextDouble() * (max - min + 1)) + min));
		 * 
		 * prac.generaAleatorios(5, 5, 7); String cad1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 * prac.estadisticaCadena(cad1); prac.estadisticaCadena1(cad1);
		 * 
		 * String cad2 = "abcdefghijklmnopqrstuvwxyz"; prac.saberTipo(cad2);
		 * prac.contadorVocales(cad2);
		 * 
		 * prac.saberMayusculas(cad2);
		 * 
		 * String cadena5 = "Hola 1548 IVAN ,+()[]"; prac.saberTodoTipo(cadena5);
		 * 
		 * String cad3 = "aB"; String cad4 = "ab";
		 * 
		 * int valor = cad1.compareToIgnoreCase(cad4); System.out.println(valor);
		 * 
		 * System.out.println((cad3.equals(cad4)));
		 * System.out.println((cad3.equalsIgnoreCase(cad4)));
		 * 
		 * int[] alea = prac.generaAleatoriosArray(5, 5, 7); for (int i = 0; i <
		 * alea.length; i++) { System.out.println(alea[i]); }
		 * 
		 * int[] arr = prac.generaAleatoriosArray(5, 10, 20); for (int i : arr) {
		 * System.out.println(i + " "); }
		 * 
		 * int[] ale = prac.estadisticaArray(5, 1, 3); for (int i : ale) {
		 * System.out.println("n: " + i); }
		 * 
		 * int[] cont = prac.estadisticaArray(10, 1, 6);
		 * 
		 * for (int i : cont) { System.out.println("numero veces que aparece " + i); }
		 * 
		 * Practica.diasSemana();
		 * 
		 * Estudiante[] lista = new Datos().getEstudiantes();
		 * Practica.listarEstudiantes(lista);
		 * 
		 * Estudiante[][] todos = new Datos().getEstudianteCentro();
		 * Practica.listarTodosEst(todos);
		 * 
		 * prac.listarEst2(lista);
		 * 
		 * String[] islas = { "LP", "GOM", "HIE", "TFE", "GC", "LTE", "FTV" };
		 * 
		 * String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
		 * "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
		 * 
		 * int[][] visitantesYear = { { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34
		 * }, { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 35 }, { 23, 24, 25, 26, 27,
		 * 28, 29, 30, 31, 32, 33, 36 }, { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33,
		 * 37 }, { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 38 }, { 23, 24, 25, 26,
		 * 27, 28, 29, 30, 31, 32, 33, 39 }, { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
		 * 33, 40 } };
		 * 
		 * int isla = 0; int mes = 5;
		 * 
		 * int n = prac.visitantesIslaYear(isla, visitantesYear);
		 * System.out.println("result " + islas[isla] + " :" + n);
		 * 
		 * int[][] visitantesMes = { { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34 },
		 * { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 35 }, { 23, 24, 25, 26, 27, 28,
		 * 29, 30, 31, 32, 33, 36 }, { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 37 },
		 * { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 38 }, { 23, 24, 25, 26, 27, 28,
		 * 29, 30, 31, 32, 33, 39 }, { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 40 }
		 * };
		 * 
		 * int m = prac.visitantesIslaMes(mes, visitantesMes);
		 * System.out.println("result " + meses[mes] + ": " + m);
		 * 
		 * // prac.Reloj();
		 * 
		 * String[] cadenas = { "123", "e3", "222", "1x3", "333" }; int[] res =
		 * prac.convierteCadenasANumeros(cadenas); for (int i : res) {
		 * System.out.println(i + ", "); }
		 * 
		 * float saldoInicial = 1000.0f; String[] mov = { "10", " -5", "x", "2" };
		 * 
		 * float saldof = prac.calculaSaldo(mov, saldoInicial);
		 * System.out.println("Saldo final: " + saldof + "€");
		 * 
		 * int nq = prac.numerosSeparados(555); System.out.println(nq);
		 * 
		 * int nn = prac.cadenaSumaNumeros("1122"); System.out.println(nn);
		 * 
		 * System.out.println("----------"); int[] numeros =
		 * prac.generaAleatoriosArray(15, 0, 10); int[] nue =
		 * prac.ordenaEnteros(numeros); for (int i = 0; i < nue.length; i++) {
		 * System.out.println(nue[i]); }
		 * 
		 * System.out.println("----------"); int[] numeros2 =
		 * prac.generaAleatoriosArray(15, 0, 10); prac.ordenaEnteros(numeros2); for (int
		 * j = 0; j < numeros2.length; j++) { System.out.println(numeros2[j]); }
		 * 
		 * System.out.println("----------"); String[] cadena = { "TAHILY", "IVAN",
		 * "HIMAR" }; prac.ordenaCadenas(cadena); for (int i = 0; i < cadena.length;
		 * i++) { System.out.println(cadena[i]); }
		 * 
		 * int[] numeros3 = prac.generaAleatoriosArray(20, 5, 10);
		 * Arrays.sort(numeros3); for (int i = 0; i < numeros3.length; i++) {
		 * System.out.println(numeros3[i]); }
		 * 
		 * String[] cadena2 = { "TAHILY", "IVAN", "HIMAR" }; Arrays.sort(cadena2); for
		 * (int j = 0; j < cadena2.length; j++) { System.out.println(cadena2[j]); }
		 * 
		 * Estudiante[] listEstudiantes = { est1, est2, est3 };
		 * prac.ordenarEstudiantes(listEstudiantes); for (int i = 0; i <
		 * listEstudiantes.length; i++) { System.out.println(listEstudiantes[i]); }
		 * 
		 * System.out.println("----------"); int[] l1 = { 8, 3, 5, 9, 0 }; int[] l2 = {
		 * 2, 7, 1, 1, 11 }; int[] l3 = prac.ordenarLista(l1, l2); for (int i = 0; i <
		 * l3.length; i++) { System.out.println(l3[i]); }
		 * 
		 * int[]l4 = {1,3,5,7,9}; int[]l5 = {2,4,6,8,10,12,14}; int[] l6 =
		 * prac.mezclaArrays(l4, l5); for (int i = 0; i < l6.length; i++) {
		 * System.out.println(l6[i]); }
		 */

		/*
		 * Component frame = null; String nif =
		 * JOptionPane.showInputDialog("Introduzca el DNI a válidar: "); boolean n2 =
		 * prac.validarNIF(nif);
		 * 
		 * if (n2) { JOptionPane.showMessageDialog(frame, nif + " es un DNI válido."); }
		 * else { JOptionPane.showMessageDialog(frame, nif + " no es un DNI válido",
		 * "ERROR", JOptionPane.ERROR_MESSAGE); }
		 */

		Datos dat = new Datos();
		/*
		 * System.out.println("------------CLASIFICACIÓN------------"); int[] clasi =
		 * prac.obtenerClasificacion(dat.getResultados()); for (int i = 0; i <
		 * clasi.length; i++) { System.out.println(clasi[i]); }
		 * 
		 * String[] equipos = new Datos().getEquipos(); prac.ordenaClasificacion(clasi,
		 * equipos); for (int i = 0; i < equipos.length; i++) {
		 * System.out.println(equipos[i] + " \t" + clasi[i]); }
		 * 
		 * int[] clasi2 = prac.obtenerClasificacionColumnas(dat.getResultados()); for
		 * (int i = 0; i < clasi2.length; i++) { System.out.println(clasi2[i]); }
		 * 
		 * System.out.println("------------CLASIFICACIÓN------------"); int[][]
		 * ptsJornada = new Datos().getPtsJornada(); Equipo[] clasificacion =
		 * prac.obtenerClasificacionJornadas(ptsJornada); for (int i = 0; i <
		 * clasificacion.length; i++) { System.out.println(clasificacion[i].getNombre()
		 * + clasificacion[i].getPuntos()); }
		 * 
		 * 
		 * 
		 * String cade = "abcdefghij";
		 * 
		 * String n3 = cade.substring(2, 5);
		 * 
		 * System.out.println(n3);
		 * 
		 * int n4 = cade.indexOf("cde"); System.out.println(n4);
		 * 
		 * 
		 * boolean primo = prac.esPrimo(3); System.out.println(primo);
		 * 
		 * 
		 * int[] lista = prac.listaPri(20); for (int i = 0; i < lista.length; i++) {
		 * System.out.println(lista[i]); }
		 * 
		 * int[] lista2 = prac.listaPri2(20); for (int i = 0; i < lista2.length; i++) {
		 * System.out.println(lista2[i]); }
		 * 
		 * 
		 * System.out.println("------------"); int[] listFibo = prac.numFibo(10); for
		 * (int i = 0; i < listFibo.length; i++) { System.out.println(listFibo[i]); }
		 */

		/*System.out.println("---------------");
		String cadena = "TAHILY";
		String ncadena = prac.invierteCadenas(cadena);
		System.out.println(ncadena);

		System.out.println("---------------");
		String cadena1 = "Hola mundo que tal ? a s s ";
		int cuenta = prac.cuentaPalabras(cadena1);
		System.out.println(cuenta);

		System.out.println("----------");
		int[][] matriz = { 
				{ 1, 2, 3, 4, 5 }, 
				{ 1 }, 
				{ 1, 2, 3, 4, 5 }, 
				{ 1, 2, 3 }, 
				{ 1, 2, 3, 4, 5 } 
			};
		int contador = prac.sumaDiagonal(matriz);
		System.out.println(contador);

		System.out.println("-------------------------");
		int[] numeros = { 1, 2, 5, 7, 8, 9, 5, 6, 8, 7, 8, 9, 5, 5, 8, 9, 5, 4, 2 };
		int maximo = prac.maximo(numeros);
		System.out.println(maximo);

		prac.recorrerMatrizIrregularColumnas(matriz);
		
		
		Integer[][] matriz2 = { 
				{ 1, 2, 3, 4,null, 5 }, 
				{ 1 }, 
				{ 1, 2, 3, 4, 5 }, 
				{ 1, 2, 3 }, 
				{ 1, 2, 3, 4, 5 }
		};
		
		prac.recorrerMatrizIrregularColumnasNull(matriz2);
		 */
		
		
		//SEGUNDA
		prac.introListas();
		ArrayList<Estudiante> listaE;

		
		//prac.listarEstudiantes(prac.introListas());
		System.out.println("-----------------------");
			
		
		ArrayList <String> cadenas = new ArrayList<String>();
		cadenas.add("123");
		cadenas.add("e3");
		cadenas.add("222");
		cadenas.add("1x3");
		cadenas.add("333");
		cadenas.add("xxx");
		
		ArrayList<Integer> lista = prac.convierteCadenasANumeros(cadenas);
		
		int[][] visitantesYear = { { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34}, 
				{ 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 35 }, 
				{ 23, 24, 25, 26, 27,28, 29, 30, 31, 32, 33, 36 }, 
				{ 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33,37 }, 
				{ 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 38 }, 
				{ 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 39 }, 
				{ 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 40 } 
			};
		
		ArrayList<ArrayList<Integer>> list = prac.convierteMatrizArrayLista(visitantesYear);
		
		
		HashMap<String, Estudiante> mapa = prac.introMapas();
		Estudiante noexisto = mapa.get("noexisto");
		
		String fic = "ficheros/personas.txt";
		ArrayList<String> lista2 = new ArrayList<String>();
		lista2 = prac.leerFicheroArrayList(fic);
		
		HashMap<String, String> mapa2 = prac.leerFicheroHashMap(fic);
		String fic2 = "ficheros/ventasDeptoAlmacen.txt";
		HashMap<String,ArrayList<Float>> resumenVentasVendedor=prac.resumenVentasVendedor(fic2);
		
		
		prac.leerFicheroTextoEdad();
		
		prac.generaAleatoriosArrayList(10, 1, 5);
		
		System.out.println("fin");
	}
}
