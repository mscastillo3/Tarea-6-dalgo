package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		crearGrafo();
		
		Boolean estado = pv();
		System.out.print(estado); 
    }
	private static void crearGrafo() {
		
		 try (InputStreamReader reader = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(reader);) {
	            String linea = br.readLine();
	            dias = linea.split(" ");
	            linea = br.readLine();
	            estudiantes = linea.split(" ");
	            linea = br.readLine();
	            cota = Integer.valueOf(linea);
	            linea = br.readLine();
	            diasEsc = linea.split(" ");
	            int y = 0;
	            relaciones = new HashMap<String, int[]>();
	            while (!(linea = br.readLine()).equals("")) {
	            	String[] datos = linea.split(" ");
	            	int[] estudantesE = new int[datos.length];
	            	int x = 0;
	            	while (x <estudantesE.length ) {
	            		estudantesE[x] = Integer.valueOf(datos[x]);
	            		x ++;
	            	}
	            	relaciones.put(dias[y], estudantesE);
	            	y++;
	               
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
