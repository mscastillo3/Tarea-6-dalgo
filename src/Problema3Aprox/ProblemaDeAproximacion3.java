import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.io.IOException;


public class ProblemaDeAproximacion3 {
    public static void main(String[] args) throws IOException {
         ProblemaDeAproximacion3 solver = new ProblemaDeAproximacion3();
         try (InputStreamReader reader = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(reader);) {
        	
            String amigos =br.readLine();
            ArrayList<String> totalidad = new ArrayList<String>();
            Set<Amigo> totalidadAmigos = new HashSet<Amigo>();
            String[] separados = amigos.split(" ");
            for (int u=0;u<separados.length;u++){
	            String valor = separados[u];
                Amigo amigazo = solver.new Amigo(valor);
                totalidad.add(amigazo.valor);
                totalidadAmigos.add(amigazo);
            }
            String linea = br.readLine();
            ArrayList <Peleados> luchita = new ArrayList<Peleados>();
            while (!linea.equals("")) {
                String[] peleados = linea.split(" ");
                Amigo a1 = solver.new Amigo(peleados[0]);
                Amigo a2 = solver.new Amigo(peleados[1]);
                luchita.add(solver.new Peleados(a1, a2));
                linea = br.readLine();
            }
            ArrayList<ArrayList<String>> conjuntos = (solver.AproximarConjuntos(totalidad, totalidadAmigos, luchita));
            ArrayList<String> resp  = solver.algAprox(conjuntos, luchita);
            for (int q=0;q<resp.size();q++){
                System.out.println(resp.get(q));
            }
         }
    }
    public ArrayList<ArrayList<String>> AproximarConjuntos(ArrayList<String> totalidad,Set<Amigo> totalidadAmigos, ArrayList <Peleados> peleas){
        ArrayList<String> resultado = new ArrayList<String>();
        ArrayList<String> segundo = new ArrayList<String>();
        Random vaino = new Random();
        //numero entre |totalidad|/4 y 3/4|totalidad|
        int valor = vaino.nextInt(totalidad.size()/2)+(totalidad.size()/4);
        //System.out.println(valor);
        for (int i=0; i<valor;i++){
            resultado.add(totalidad.get(i));
            //System.out.println(totalidad.get(i));
        }
        //System.out.println("Segunda lista");
        for (int u=valor; u<totalidad.size();u++){
            segundo.add(totalidad.get(u));
            //System.out.println(totalidad.get(u));
        }
        ArrayList<ArrayList<String>> conjuntos = new ArrayList<ArrayList<String>>();
        conjuntos.add(resultado);
        conjuntos.add(segundo);
        return conjuntos;
    }
    public ArrayList<String> algAprox (ArrayList<ArrayList<String>> conjuntos, ArrayList <Peleados> pelea){
        ArrayList<String> a1 = conjuntos.get(0);
        ArrayList<String> a2 = conjuntos.get(1);
        for (int k=0; k<a1.size();k++){
            boolean mejorIrse = calcularEjes(a1.get(k), a1, pelea);
            if (mejorIrse){
                a2.add(a1.get(k));
                a1.remove(k);
            }
        }
        return a1;
    }
    public boolean calcularEjes(String amig, ArrayList<String>conjuntos, ArrayList <Peleados> pelea){
        int peleaInterna = 0;
        int peleaExterna = 0;
        for (Peleados fighters: pelea){
            String p1 = fighters.getUno().valor;
            String p2 = fighters.getDos().valor;
            if (p1.equals(amig)&& conjuntos.contains(p2)) peleaInterna++;
            else if (p1.equals(amig)&& !conjuntos.contains(p2)) peleaExterna++;
            else if (p2.equals(amig)&& conjuntos.contains(p1)) peleaInterna++;
            else if (p2.equals(amig)&& !conjuntos.contains(p1)) peleaExterna++;
        }
        return peleaInterna>peleaExterna;
    }


    class Peleados{
        Amigo uno;
        Amigo dos;

        public Peleados(Amigo uno, Amigo dos){
            this.uno=uno;
            this.dos=dos;
        }
        public Amigo getUno(){
            return this.uno;
        }
        public Amigo getDos(){
            return this.dos;
        }
    }
    class Amigo{
        String valor;
        public Amigo(String valor){
            this.valor=valor;
        }
    }

}

