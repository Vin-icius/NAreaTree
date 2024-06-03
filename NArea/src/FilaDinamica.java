class FilaDinamica {
    private No frente,tras;
    private No[] array;
    private int tamanho;
    public static int tf;

    public FilaDinamica() {
        this.array= new No[0];
        this.frente = null;
        this.tras = null;
        this.tamanho = 0;
        this.tf=0;
    }

    public FilaDinamica(int tam) {
        this.array= new No[tam];
        this.frente = null;
        this.tras = null;
        this.tamanho = 0;
        this.tf=tam;
    }

    public boolean estaVazia() {
        return frente == null;
    }

    public boolean estaCheia(){
        return tamanho == tf;
    }

    public void enfileirar(No elemento) {
        No novoNodo = elemento;
        if (estaVazia()) {
            frente = array[tamanho++] = novoNodo;
        } else
            if(!estaCheia()){
                tras = array[tamanho++] = novoNodo;
            }
    }

    public No desenfileirar() {
        if (estaVazia()) {
            return null;
        }
        else {
            No elemento = frente;
            frente = array[1];
            if (frente == null) {
                tras = null;
            }
            tamanho--;
            return elemento;
        }
    }

    public int size() {
        return tamanho;
    }
}