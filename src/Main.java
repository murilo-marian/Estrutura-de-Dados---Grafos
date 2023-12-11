import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {
        /*GrafoListaAdjacencia grafo = new GrafoListaAdjacencia(3,false);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);
        System.out.println(grafo.isConexo()); //True
        System.out.println(grafo.isCompleto()); //True
        System.out.println();
        grafo.mostrar();
        grafo.removerVertice(0);
        System.out.println("----------");
        grafo.mostrar();
        grafo = new GrafoListaAdjacencia(3, false);
        System.out.println(grafo.isConexo()); //False
        System.out.println(grafo.isCompleto()); //False*/

        /*
        GrafoListaAdjacencia grafoDij = new GrafoListaAdjacencia(5, true);
        grafoDij.adicionarAresta(0,3, 3);
        grafoDij.adicionarAresta(0, 4, 10);
        grafoDij.adicionarAresta(0, 1, 1);
        grafoDij.adicionarAresta(1, 2, 5);
        grafoDij.adicionarAresta(2, 4, 1);
        grafoDij.adicionarAresta(3, 2, 2);
        grafoDij.adicionarAresta(3, 4, 6);
        grafoDij.mostrarDijkstra(0, 4);*/

        /*GrafoListaAdjacencia grafoEuler = new GrafoListaAdjacencia(7, false);
        grafoEuler.adicionarAresta(0, 1);
        grafoEuler.adicionarAresta(1, 2);
        grafoEuler.adicionarAresta(2, 3);
        grafoEuler.adicionarAresta(3, 4);
        grafoEuler.adicionarAresta(4, 5);
        grafoEuler.adicionarAresta(5, 6);
        grafoEuler.adicionarAresta(5, 0);
        grafoEuler.adicionarAresta(1, 6);
        grafoEuler.adicionarAresta(2, 6);
        grafoEuler.adicionarAresta(4, 6);
        grafoEuler.adicionarAresta(1, 5);
        grafoEuler.adicionarAresta(2, 4);
        System.out.println(grafoEuler.isEuleriano());*/

        /* GrafoListaAdjacencia grafoSemiEuler = new GrafoListaAdjacencia(6, false);

        grafoSemiEuler.adicionarAresta(0, 1);
        grafoSemiEuler.adicionarAresta(0, 5);
        grafoSemiEuler.adicionarAresta(1, 2);
        grafoSemiEuler.adicionarAresta(1, 5);
        grafoSemiEuler.adicionarAresta(2, 3);
        grafoSemiEuler.adicionarAresta(3, 1);
        grafoSemiEuler.adicionarAresta(3, 4);
        grafoSemiEuler.adicionarAresta(3, 5);
        grafoSemiEuler.adicionarAresta(4, 5);
        grafoSemiEuler.adicionarAresta(4, 0);
        System.out.println(grafoSemiEuler.isEuleriano()); */

        /*GrafoListaAdjacencia grafoNaoEuler = new GrafoListaAdjacencia(5, false);

        grafoNaoEuler.adicionarAresta(0, 1);
        grafoNaoEuler.adicionarAresta(0, 4);
        grafoNaoEuler.adicionarAresta(1, 4);
        grafoNaoEuler.adicionarAresta(2, 1);
        grafoNaoEuler.adicionarAresta(2, 3);
        grafoNaoEuler.adicionarAresta(2, 4);
        grafoNaoEuler.adicionarAresta(3, 4);
        grafoNaoEuler.adicionarAresta(3, 0);
        System.out.println(grafoNaoEuler.isEuleriano());*/
/*
        GrafoListaAdjacencia grafoHamilton = new GrafoListaAdjacencia(4, false);
        grafoHamilton.adicionarAresta(0,1);
        grafoHamilton.adicionarAresta(1, 2);
        grafoHamilton.adicionarAresta(2, 3);
        grafoHamilton.adicionarAresta(2, 0);
        grafoHamilton.adicionarAresta(3, 0);
        System.out.println(grafoHamilton.isHamiltoniano());*/

        /*GrafoListaAdjacencia grafoSemiHamilton = new GrafoListaAdjacencia(4, false);
        grafoSemiHamilton.adicionarAresta(0,1);
        grafoSemiHamilton.adicionarAresta(1, 2);
        grafoSemiHamilton.adicionarAresta(2, 0);
        grafoSemiHamilton.adicionarAresta(2, 3);
        System.out.println(grafoSemiHamilton.isHamiltoniano());*/

        GrafoListaAdjacencia grafoNaoHamilton = new GrafoListaAdjacencia(4, false);
        grafoNaoHamilton.adicionarAresta(0, 1);
        grafoNaoHamilton.adicionarAresta(0, 2);
        grafoNaoHamilton.adicionarAresta(0, 3);
        System.out.println(grafoNaoHamilton.isHamiltoniano());

    }
}