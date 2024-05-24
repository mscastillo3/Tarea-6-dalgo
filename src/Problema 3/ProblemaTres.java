import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProblemaTres {
    public static void main(String[] args) throws IOException {
         ProblemaTres solver = new ProblemaTres();
         try (InputStreamReader reader = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(reader);) {
        	int k = Integer.valueOf(br.readLine());
            String amigos =br.readLine();
            Set<Amigo> totalidad = new HashSet<Amigo>();
            String[] separados = amigos.split(" ");
            for (int u=0;u<separados.length;u++){
	            String valor = separados[u];
                Amigo amigazo = solver.new Amigo(valor);
                totalidad.add(amigazo);
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
            String[] certificado1 = br.readLine().split(" ");
            Set <Amigo> posibleSol1 = new HashSet<Amigo>();
            for (int p=0;p<certificado1.length;p++){
	            String valor = certificado1[p];
                Amigo amigazo = solver.new Amigo(valor);
                posibleSol1.add(amigazo);
            }
            String[] certificado2 = br.readLine().split(" ");
            Set <Amigo> posibleSol2 = new HashSet<Amigo>();
            for (int p=0;p<certificado2.length;p++){
	            String valor = certificado2[p];
                Amigo amigazo = solver.new Amigo(valor);
                posibleSol2.add(amigazo);
            }
            System.out.println(solver.Revision(posibleSol1, posibleSol2, totalidad, k, luchita));
        }
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
    public Boolean Revision (Set<Amigo> certificado1,Set<Amigo> certificado2, Set<Amigo> totalidad, int k, ArrayList <Peleados> luchita ){
        for (Amigo a:totalidad) System.out.println(a.valor);
        for (Amigo check: certificado1){
            //Revisa si hay algún amigo que no estaba en la lista
            if (!totalidad.contains(check)) {
                System.out.println("El amigo "+check.valor+" no existe");
                System.out.println("error 1");
                return false;
            }
        }
        for (Amigo check: certificado2){
            //Revisa si hay algún amigo que no estaba en la lista
            if (!totalidad.contains(check)) {
                System.out.println("error 2");
                return false;
            }
        }
        for (Amigo check: totalidad){
            //Revisa que todos los amigos pertenezcan a una sola lista y que
            //ninguno pertenezca a las 2
            if ((!certificado1.contains(check)&&!certificado2.contains(check))||
            (certificado1.contains(check)&&certificado2.contains(check))) {
                System.out.println("error 3");
                return false;
            }
        }
        int conteo=0;
        for (Peleados pelea:luchita){
            //por cada pelea que cumpla SV(del documento), sumar 1
            if ((certificado1.contains(pelea.getUno())&&certificado2.contains(pelea.getDos()))
            ||(certificado2.contains(pelea.getUno())&&certificado1.contains(pelea.getDos()))) 
            conteo = conteo+1;
        }
        if (conteo<k) return false;

        
        
        return true;
    }
}
