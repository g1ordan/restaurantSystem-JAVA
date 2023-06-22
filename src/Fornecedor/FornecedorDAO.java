import java.util.ArrayList;

public class FornecedorDAO implements DAO<Fornecedor> {
    private static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

    @Override
    public void inserir(Fornecedor fornecedor) {
        int maiorCodigo = 1;
        for(int i = 0; i < FornecedorDAO.fornecedores.size(); i++){
            int codigoAtual = FornecedorDAO.fornecedores.get(i).getCod();
            if(codigoAtual > maiorCodigo){
                maiorCodigo = codigoAtual;
            }
        }
        fornecedor.setCod(maiorCodigo + 1);
        FornecedorDAO.fornecedores.add(fornecedor);
    }

    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < FornecedorDAO.fornecedores.size(); i++){
            if(codigo == FornecedorDAO.fornecedores.get(i).getCod()){
                FornecedorDAO.fornecedores.remove(i);
            }
        }
    }

    @Override
    public void editar(Fornecedor fornecedor) {
        for(int i = 0; i < FornecedorDAO.fornecedores.size(); i++) {
            Fornecedor fornecedorAtual = FornecedorDAO.fornecedores.get(i);
            if(fornecedorAtual.getCod() == fornecedor.getCod()) {
                FornecedorDAO.fornecedores.set(i, fornecedor);
                return;
            }
        }
    }

    @Override
    public ArrayList<Fornecedor> getAll() {
        return FornecedorDAO.fornecedores;
    }

    @Override
    public Fornecedor getByCod(int codigo) {
        for(int i = 0; i < FornecedorDAO.fornecedores.size(); i++){
            Fornecedor fornecedorAtual = FornecedorDAO.fornecedores.get(i);
            if(codigo == fornecedorAtual.getCod())
                return fornecedorAtual;
        }  

        throw new Error("Fornecedor não encontrado");
    }

}
