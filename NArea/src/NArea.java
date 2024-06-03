public class NArea {
    private No raiz;

    // metods

    public NArea() {
    }

    public No getRaiz(){
        return raiz;
    }

    public void inserir(int info){
        No aux;
        int pos;
        boolean flag=false;
        if(raiz==null) {
            raiz= new No(info);
        }
        else{
            aux = raiz;
            while(!flag){
                pos = aux.buscarPos(info);
                if(aux.getTL()<No.n-1){
                    aux.remanejar(pos);
                    aux.setvInfo(pos,info);
                    aux.setTL(aux.getTL()+1);
                    flag=true;
                }
                else
                    if(aux.getvLig(pos)==null){
                        aux.setvLig(pos,new No(info));
                        flag=true;
                    }
                    else{
                        aux=aux.getvLig(pos);
                    }
            }
        }
    }

    public void in_ordem()
    {
        in_ordem(raiz);
    }

    private void in_ordem(No no)
    {
        if(no!=null)
        {
            for(int i=0; i<no.getTL(); i++)
            {
                in_ordem(no.getvLig(i));
                System.out.println(no.getvInfo(i));
            }
            in_ordem(no.getvLig(no.getTL()));
        }
    }

    private int contarNo(){
        int qtde=0;
        contarNo(raiz,qtde);
        return qtde;
    }
    private void contarNo(No no,int qtde){
        if(no!=null)
        {
            for(int i=0; i<no.getTL(); i++)
            {
                in_ordem(no.getvLig(i));
            }
            in_ordem(no.getvLig(no.getTL()));
            qtde+=1;
        }
    }

    public void exibirPorNivel() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        FilaDinamica fila = new FilaDinamica(contarNo());
        fila.enfileirar(raiz);

        while (!fila.estaVazia()) {
            int nivelTamanho = fila.size();

            while (nivelTamanho > 0) {
                No noAtual = fila.desenfileirar();
                for (int i = 0; i < noAtual.getTL(); i++) {
                    System.out.print(noAtual.getvInfo(i) + " ");
                }

                for (No filho : noAtual.getvLig()) {
                    if (filho != null) {
                        fila.enfileirar(filho);
                    }
                }
                nivelTamanho--;
            }
            System.out.println();
        }
    }

}
