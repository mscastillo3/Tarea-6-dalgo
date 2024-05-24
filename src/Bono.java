package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bono {
	
	private static int[][] mapa;
	
	
	
	public static void main(String[] args) {
		String archivo ="";
		mapa = crearGrafo(archivo);
		mapa = new int[][]{{1,1,1,1},{1,1,1,0}};
		
		Estado estado = encontarPuntos();
		System.out.print(estado.getIntercecciones().size()); 
    }

	private static Estado encontarPuntos() {
		Queue<Estado> agenda = new LinkedList<>();
		
		ArrayList<Integer> losEstados = new ArrayList<Integer> ();
		ArrayList<Boolean> lasCalles = new ArrayList<Boolean> ();
		int calles = mapa[0].length;
		int d = 0;
		while (d < calles) {
			lasCalles.add(false);
			d++;
		}
		
		boolean esS = false;
		agenda.add(new Estado(losEstados,lasCalles,esS ));
		
        HashMap<String, Boolean> visitados = new HashMap<String, Boolean>();
        
        boolean satisfactorio = true;
		while (satisfactorio && !agenda.isEmpty() ) {
	
            Estado currentEstado = agenda.poll();
            if(vaiable(currentEstado)) {
            	if (isSolution(currentEstado)) {
            		return currentEstado;
            	}
            	ArrayList<Estado> adllasentes = getSuccessors(currentEstado, visitados);
	            for (Estado neer : adllasentes) {
	            	String llave = neer.toString();
		                if (!visitados.containsKey(llave)) {
		                	visitados.put(llave, true);
		                	agenda.add(neer);
		                }
		               
	                }
            }
        }
		return null;
		
	}

	private static boolean isSolution(Estado currentEstado) {
		// TODO Auto-generated method stub
		return currentEstado.isCorrecto() ;
	}

	private static boolean vaiable(Estado neer) {
		
		return mapa.length >= neer.getIntercecciones().size();
	}

	private static ArrayList<Estado> getSuccessors(Estado currentNode, HashMap<String, Boolean> visitados ) {
		int vertices = mapa.length;
		int x = 0;
		ArrayList<Estado> estadosA = new ArrayList<Estado> ();
		ArrayList<Boolean> lasCalles = currentNode.getCallesCubiertas();

		while (x < vertices) {
			ArrayList<Integer> losEstados = (ArrayList<Integer>) currentNode.getIntercecciones().clone();
			
			ArrayList<Boolean> lasCalles2 = new ArrayList<Boolean> ();
			boolean acabe = true;
			if (losEstados.contains(x)) {
				continue;
			}
			losEstados.add(x);
			int y = 0;
			while(y < mapa[x].length) {
				
				if (mapa[x][y] == 1) {
					lasCalles2.add(true);
				}
				else {
					if (!lasCalles.get(y)) {
						lasCalles2.add(false);
						acabe = false;
					}
					else {
						lasCalles2.add(true);
					}
				}
				y++;
			}
			
			Estado elEstado = new Estado(losEstados,lasCalles, acabe);
			
			estadosA.add(elEstado);
			x++;
		}
		return estadosA;
	}

	private static int[][] crearGrafo(String archivo) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine() ;
            String[] callesInt = linea.split(" ");
            int calles = Integer.valueOf(callesInt[0]);
            int inter = Integer.valueOf(callesInt[1]);
            int[][] mape = new int[inter][calles];
            int x = 0;
            while ((linea = br.readLine()) != null) {
            	String[] datos = linea.split(" ");
            	int[] callesE = new int[datos.length];
            	int y = 0;
            	while (y <callesE.length ) {
            		callesE[y] = Integer.valueOf(datos[x]);
            		y ++;
            	}
            	mape[x]= callesE;
            	
            	x++;
               
            }
        	return mape;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return mapa;
	
	}
	

}

 class Estado {
	private ArrayList<Boolean>  callesCubiertas;
	private ArrayList<Integer> intercecciones;
	private boolean correcto;
	
	
	
	public Estado(ArrayList<Integer>  intercecciones, ArrayList<Boolean>  callesCubiertas, boolean correcto) {
		this.intercecciones = intercecciones;
		this.callesCubiertas = callesCubiertas;
		this.correcto = correcto;
	}
	
	public ArrayList<Integer>  getIntercecciones() {
		return intercecciones;
	}
	public void setIntercecciones(ArrayList<Integer>  intercecciones) {
		this.intercecciones = intercecciones;
	}
	public ArrayList<Boolean>  getCallesCubiertas() {
		return callesCubiertas;
	}
	public void setCallesCubiertas(ArrayList<Boolean> callesCubiertas) {
		this.callesCubiertas = callesCubiertas;
	}
	
	
	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public void sort(List<Integer> numbers) {
		int max = numbers.get(0);
		int min =  numbers.get(0);
		
		for (Integer numero: numbers) {
			if (max <numero ) {
				max = numero;
			}
			if (min > numero ) {
				min = numero;
			}
		}
		
		
		
		Object[]  cantidad= new Object[max -min +1];
		List<Integer>  listaOrdenada= new ArrayList<Integer>();
		
		
		
		for (Integer numero: numbers) {
			
			if (cantidad[numero-min]==null) {
				List<Integer>  boket = new ArrayList<Integer>();
				boket.add(numero);
				cantidad[numero-min] = boket;
			}
			else {
				List<Integer>  boket = (List<Integer>) cantidad[numero-min];
				boket.add(numero);
			}
			
		}
		
		numbers.clear();
		
		for (Object numeros: cantidad) {
			List<Integer> numero = (List<Integer>) numeros;
			if (numero != null) {
				for (Integer numeroEsp: numero) {
					numbers.add(numeroEsp);
				}
			}
			
			
		}
		}


	public String toString() {
		sort(intercecciones);
		String listaS = "";
		for (int dato: intercecciones) {
			listaS += dato;
		}
		return listaS;
	}
	
	
	
}
	
	




