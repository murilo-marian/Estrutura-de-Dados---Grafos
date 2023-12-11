import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {
        GrafoListaAdjacencia grafo = new GrafoListaAdjacencia(7,false);
        grafo.adicionarAresta(0,1);
        grafo.adicionarAresta(1,2);
        grafo.adicionarAresta(2,3);
        grafo.adicionarAresta(3,4);
        grafo.adicionarAresta(4,5);
        grafo.adicionarAresta(5,0);
        grafo.adicionarAresta(1,6);
        grafo.adicionarAresta(2,6);
        grafo.adicionarAresta(4,6);
        grafo.adicionarAresta(5,6);
        grafo.adicionarAresta(2,4);
        grafo.adicionarAresta(1,5);
        System.out.println(grafo.isConexo()); //True
        System.out.println(grafo.isCompleto()); //False

        /*grafo.mostrar();
        System.out.println("==========");
        grafo.removerVertice(2);
        grafo.mostrar();*/
    }
}