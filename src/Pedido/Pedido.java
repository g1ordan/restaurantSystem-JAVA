import java.util.ArrayList;

public class Pedido {
    private int cod;
    private ArrayList<Integer> produtosCod = new ArrayList<Integer>();
    private int clienteCod;
    private int funcionarioCod;
    private boolean pago;

    public Pedido(ArrayList<Integer> produtosCod, int clienteCod, int funcionarioCod) {
        this.produtosCod = produtosCod;
        this.clienteCod = clienteCod;
        this.funcionarioCod = funcionarioCod;
        this.pago = false;
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

    public boolean getPago() {
        return this.pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

     @Override
    public String toString() {
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Cliente cliente = clienteDAO.getByCod(this.clienteCod);
        Funcionario funcionario = funcionarioDAO.getByCod(this.funcionarioCod);
        ArrayList<Produto> produtos = produtoDAO.getByCods(this.produtosCod);

        String texto = "Código: " + this.cod +
            "\nCliente (código): " + cliente.getCod() +
            "\nCliente (nome): " + cliente.getNome() +
            "\nFuncionário (código): " + funcionario.getCod() +
            "\nFuncionário (nome): " + funcionario.getNome() +
            "\nProdutos: ";

        double valorTotal = 0;
        for(int i = 0; i < produtos.size(); i++) {
            Produto produtoAtual = produtos.get(i);
            
            if(i != 0) texto+="\n";
            texto+= "\n     Nome: " + produtoAtual.getNome() +
                    "\n     Valor: " + produtoAtual.getValor();
            valorTotal+= produtoAtual.getValor();
        }

        texto+= "\n\nValor total: R$" + valorTotal;

        return texto;
    } 
}


