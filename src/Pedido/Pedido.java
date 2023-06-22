import java.util.ArrayList;

public class Pedido {
    private int cod;
    private ArrayList<Integer> produtosCod = new ArrayList<Integer>();
    private int clienteCod;
    private int funcionarioCod;

    public Pedido(ArrayList<Integer> produtosCod, int clienteCod, int funcionarioCod) {
        this.produtosCod = produtosCod;
        this.clienteCod = clienteCod;
    }

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public ArrayList<Integer> getProdutosCod() {
        return this.produtosCod;
    }

    public void setProdutosCod(ArrayList<Integer> produtosCod) {
        this.produtosCod = produtosCod;
    }

    public int getClienteCod() {
        return this.clienteCod;
    }

    public void setClienteCod(int clienteCod) {
        this.clienteCod = clienteCod;
    }

    public int getFuncionarioCod() {
        return this.funcionarioCod;
    }

    public void setFuncionarioCod(int funcionarioCod) {
        this.funcionarioCod = funcionarioCod;
    }
}


