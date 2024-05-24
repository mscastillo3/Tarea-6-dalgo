package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProblemaDos {
	
	private static String[]  dias;
	private static String[] estudiantes;
	private static HashMap<String, int[]> relaciones;
	private static int cota;
	private static String[] diasEsc;
	
	public static boolean pv() {
		boolean verifica = diasEsc.length <= cota;
		for (String dia: diasEsc) {
			if (!(relaciones.containsKey(dia) )) {
				return false;
			}
		}
		boolean[] estudiantesV = new boolean[estudiantes.length];
		for(String dia: diasEsc ) {
			for(int estudiante: relaciones.get(dia)) {
				estudiantesV[estudiante] = true;
			}
			
		}
		
		for (boolean este: estudiantesV) {
			if(!este) {
				return false;
			}
		}
		
		return verifica;
		
		
	}
	public static void main(String[] args) {
		String archivo ="";
		crearGrafo(archivo);
		
		Boolean estado = pv();
		System.out.print(estado); 
    }
	private static void crearGrafo(String archivo) {
		
		 try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea = br.readLine();
	            dias = linea.split(" ");
	            linea = br.readLine();
	            estudiantes = linea.split(" ");
	            linea = br.readLine();
	            cota = Integer.valueOf(linea);
	            linea = br.readLine();
	            diasEsc = linea.split(" ");
	            
	            relaciones = new HashMap<String, int[]>();
	            while ((linea = br.readLine()) != null) {
	            	String[] datos = linea.split(" ");
	            	int[] estudantesE = new int[datos.length-1];
	            	int x = 0;
	            	while (x <estudantesE.length ) {
	            		estudantesE[x] = Integer.valueOf(datos[x+1]);
	            		x ++;
	            	}
	            	relaciones.put(datos[0], estudantesE);
	               
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
