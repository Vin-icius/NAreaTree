public class AplicacaoNArea {

    public AplicacaoNArea() {
    }

    public void executa(){
        NArea tree = new NArea();
        for(int i=1;i<11;i++)
            tree.inserir(i);
        tree.in_ordem();
        System.out.println("//////////////");
        tree.exibirPorNivel();
    }

    public static void main(String[] args) {
        AplicacaoNArea app = new AplicacaoNArea();
        app.executa();
    }
}
