public class No {

    public static int n = 3;
    private int[] vInfo;
    private No[] vLig;
    private int TL;

    public No() {
        this.vInfo = new int[n];
        this.vLig = new No[n+1];
        this.TL=0;
    }
    public No(int info)
    {
        this();
        vInfo[0] = info;
        TL = 1;
    }

    public int getvInfo(int pos) {
        return vInfo[pos];
    }

    public void setvInfo(int pos,int info) {
        this.vInfo[pos] = info;
    }

    public No getvLig(int pos) {
        return vLig[pos];
    }

    public No[] getvLig() {
        return vLig;
    }

    public void setvLig(int pos,No lig) {
        this.vLig[pos] = lig;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }

    public int buscarPos(int info)
    {
        int pos=0;
        while(pos<TL && info>vInfo[pos])
            pos++;
        return pos;
    }

    public void remanejar(int pos)
    {
        vLig[TL+1] = vLig[TL];
        for(int i=TL; i>pos; i--)
        {
            vInfo[i] = vInfo[i-1];
            vLig[i] = vLig[i-1];
        }
    }
}
