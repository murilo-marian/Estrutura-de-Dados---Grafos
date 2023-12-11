
import java.util.*;

class Aresta {
    int origem;
    int destino;
    int peso;

    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

public class GrafoListaAdjacencia {
    private int nVertices;
    private final List<List<Aresta>> adjacencias;
    private boolean direcionado;

    public GrafoListaAdjacencia(int nVertices, boolean direcionado) {
        this.nVertices = nVertices;
        this.direcionado = direcionado;
        this.adjacencias = new ArrayList<>(nVertices);
        for (int i = 0; i < nVertices; i++) {
            adjacencias.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int u, int v, int peso) {
        Aresta aresta = new Aresta(u, v, peso);
        adjacencias.get(u).add(aresta);
        if (!direcionado) {
            Aresta arestaInvertida = new Aresta(v, u, peso);
            adjacencias.get(v).add(arestaInvertida);
        }
    }

    public void adicionarAresta(int u, int v) {
        adicionarAresta(u, v, 1);
    }

    public void mostrar() {
        for (int i = 0; i < nVertices; i++) {
            System.out.println("Vertice " + i + ": ");
            for (Aresta aresta : adjacencias.get(i)) {
                System.out.println("(" + aresta.destino + "," + "Peso:" + aresta.peso + ")");
            }
            System.out.println();
        }
    }

    private void dfs(int vertice, boolean[] visitado) {
        // busca em profundidade
        visitado[vertice] = true;
        for (Aresta aresta : adjacencias.get(vertice)) {
            int destino = aresta.destino;
            if (!visitado[destino]) {
                dfs(destino, visitado);
            }
        }
    }

    public boolean isConexo() {
        boolean[] visitado = new boolean[nVertices];
        dfs(0, visitado);
        for (boolean v : visitado) {
            if (!v) {
                //se algum vértice não foi visitado o grafo não é conexo
                return false;
            }
        }
        return true;
    }

    public boolean isCompleto() {
        for (int i = 0; i < nVertices; i++) {
            if (adjacencias.get(i).size() < nVertices - 1) {
                //se um vértice tem menos ligações do que nVertices - 1, significa que tem algum vértice que não é conectado a ele
                return false;
            }
        }
        return true;
    }

    public String isHamiltoniano() {
        int[] caminhoHamiltoniano = new int[nVertices];
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < nVertices; i++) {
            caminhoHamiltoniano[i] = -1;
        }

        caminhoHamiltoniano[0] = 0;
        pilha.push(0);

        String hamilton = hamiltonianoRecursivo(caminhoHamiltoniano, pilha, 1);

        if (!hamilton.equals("não-hamiltoniano")) {
            //se o grafo for hamiltoniano ou semihamiltoniano, mostra o caminho
            for (int i : caminhoHamiltoniano) {
                System.out.print(i + " ");
            }
        }
        return hamilton;
    }


    private String hamiltonianoRecursivo(int[] caminho, Stack<Integer> pilha, int pos) {
        if (pos == nVertices) {
            // Chegou no último vértice, então tem um caminho hamiltoniano, se o primeiro e o último vértice forem adjacentes ele formará
            //um ciclo hamiltoniano, se não, ele será apenas semi-hamiltoniano
            int ultimoVertice = caminho[pos - 1];
            int primeiroVertice = caminho[0];
            if (isAdjacente(ultimoVertice, primeiroVertice)) {
                return "hamiltoniano";
            } else {
                return "semi-hamiltoniano";
            }
        }

        // Tenta adicionar vértices ao caminhoHamiltoniano
        for (int v = 1; v < nVertices; v++) {
            if (isAdjacente(pilha.peek(), v) && !pilha.contains(v)) {

                caminho[pos] = v;
                pilha.push(v);

                String hamilton = hamiltonianoRecursivo(caminho, pilha, pos + 1);
                if (!hamilton.equals("não-hamiltoniano")) {
                    return hamilton;
                }
                // Backtrack se a o vértice usado não levava a um caminho hamiltoniano
                caminho[pos] = -1;
                pilha.pop();
            }
        }
        return "não-hamiltoniano";
    }

    public String isEuleriano() {
        if (!this.isConexo()) {
            return isSemiEuleriano();
        }
        for (int i = 0; i < nVertices; i++) {
            if (adjacencias.get(i).size() % 2 != 0) {
                return isSemiEuleriano();
            }
        }
        return "Euleriano";
    }

    private String isSemiEuleriano() {
        int contador = 0;
        for (int i = 0; i < nVertices; i++) {
            if (adjacencias.get(i).size() % 2 != 0) {
                contador++;
                if (contador > 2) {
                    return "Não-Euleriano";
                }
            }
        }
        return contador == 2 ? "Semi-Euleriano" : "Não-Euleriano";
    }

    public void removerAresta(int u, int v) {
        List<Aresta> arestasU = adjacencias.get(u);
        for (Aresta aresta : arestasU) {
            if (aresta.destino == v) {
                arestasU.remove(aresta);
                break;
            }
        }
        if (!direcionado) {
            List<Aresta> arestasV = adjacencias.get(v);
            for (Aresta aresta : arestasV) {
                if (aresta.destino == u) {
                    arestasV.remove(aresta);
                    break;
                }
            }
        }
    }

    public void removerVertice(int vertice) {
        // Renovendo todas as arestas incidentes no vértice
        List<Aresta> arestasDoVertice = adjacencias.get(vertice);
        for (Aresta aresta : arestasDoVertice) {
            int verticeAdjacente = aresta.destino;
            List<Aresta> arestasAdjacente = adjacencias.get(verticeAdjacente);
            // removendo as arestas dos vertices que são adjacentes
            for (int i = 0; i < arestasAdjacente.size(); i++) {
                if (arestasAdjacente.get(i).destino == vertice) {
                    arestasAdjacente.remove(i);
                    i--;
                }
            }
        }
        // Remover ele mesmo
        adjacencias.remove(vertice);
        nVertices--;
        for (List<Aresta> arestas : adjacencias) {
            for (Aresta aresta : arestas) {
                if (aresta.destino > vertice) {
                    aresta.destino--;
                }
            }
        }
    }


    public boolean isAdjacente(int u, int v) {
        List<Aresta> arestasU = adjacencias.get(u);
        for (Aresta aresta : arestasU) {
            if (aresta.destino == v) {
                return true;
            }
        }
        return false;
    }

    public void mostrarDoVertice(int vertice) {
        System.out.println("Vertice: " + vertice);
        for (Aresta aresta : adjacencias.get(vertice)) {
            System.out.println("(" + aresta.destino + ", Peso: " + aresta.peso + ")");
        }
    }


    //algoritmo de Dijkstra

    public void mostrarDijkstra(int origem, int destino) {
        int[] dijkstra = calcularDijkstra(origem, destino);
        System.out.println(origem + " -> " + destino);
        for (int i = 0; i < dijkstra.length; i++) {
            System.out.println(i + ": " + dijkstra[i]);
        }
        System.out.println("Distância de Dijkstra: " + distanciaDijkstra(dijkstra, destino));
    }

    private int distanciaDijkstra(int[] dijkstra, int destino) {
        return dijkstra[destino];
    }

    private int[] calcularDijkstra(int origem, int destino) {
        int[] distancias = new int[adjacencias.size()];
        Arrays.fill(distancias, Integer.MAX_VALUE);

        PriorityQueue<Integer> filaDePrioridade = new PriorityQueue<>(Comparator.comparingInt(vertex -> distancias[vertex]));

        distancias[origem] = 0;
        int[] verticesAntecessores = new int[adjacencias.size()];
        filaDePrioridade.add(origem);

        while (!filaDePrioridade.isEmpty()) {
            int verticeAtual = filaDePrioridade.poll();

            for (Aresta aresta : adjacencias.get(verticeAtual)) {
                int verticeAdjacente = aresta.destino;
                int novaDistancia = distancias[verticeAtual] + aresta.peso;

                if (novaDistancia < distancias[verticeAdjacente]) {
                    distancias[verticeAdjacente] = novaDistancia;
                    verticesAntecessores[verticeAdjacente] = verticeAtual;
                    filaDePrioridade.add(verticeAdjacente);
                }
            }
        }
        return distancias;
    }
}
