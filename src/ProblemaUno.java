package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ProblemaUno {
	private static String[] calles;
	private static int[][] inntercecciones;
	private static String[] solucion;
	private static int nat;
	public static boolean verififacicion () {
		boolean verificacion = nat>= solucion.length;
		//verifica que todos las intrecacciones que se selecionaron esten.
		verificacion &= inntercecciones.length >= solucion.length;
		boolean[] callesCubierta = new boolean[calles.length];
		for (String interceccion: solucion) {
			for (int calle: inntercecciones[Integer.valueOf(interceccion)]) {
				callesCubierta[calle] = true;
			}
		}
		
		for(boolean cubierta: callesCubierta) verificacion &= cubierta;
		return verificacion;
		
	}
	
	public static void main(String[] args) {
		crearGrafo();
		
		Boolean estado = verififacicion();
		System.out.print(estado); 
    }

	private static void crearGrafo() {
		try (InputStreamReader reader = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(reader);) {
            String linea = br.readLine();
            calles = linea.split(" ");
            linea = br.readLine();
            solucion = linea.split(" ");
            linea = br.readLine();
            nat = Integer.valueOf(linea);
            linea = br.readLine();
            Integer cantidadInt = Integer.valueOf(linea);
            inntercecciones = new int[cantidadInt][calles.length];
            int y = 0;
            while (!(linea = br.readLine()).equals("")) {
            	String[] datos = linea.split(" ");
            	int[] calles = new int[datos.length];
            	int x = 0;
            	while (x <calles.length ) {
            		calles[x] = Integer.valueOf(datos[x]);
            		x ++;
            	}
            	inntercecciones[y]= calles;
            	y++;
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
