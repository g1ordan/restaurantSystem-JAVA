import java.util.ArrayList;

public class FuncionarioDAO implements DAO<Funcionario> {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    @Override
    public void inserir(Funcionario funcionario) {
        int maiorCodigo = 0;
        for(int i = 0; i < FuncionarioDAO.funcionarios.size(); i++){
            int codigoAtual = FuncionarioDAO.funcionarios.get(i).getCod();
            if(codigoAtual > maiorCodigo){
                maiorCodigo = codigoAtual;
            }
        }
        funcionario.setCod(maiorCodigo + 1);
        FuncionarioDAO.funcionarios.add(funcionario);
    }

    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < FuncionarioDAO.funcionarios.size(); i++){
            if(codigo == FuncionarioDAO.funcionarios.get(i).getCod()){
                FuncionarioDAO.funcionarios.remove(i);
            }
        }
    }

    @Override
    public void editar(Funcionario funcionario) {
        for(int i = 0; i < FuncionarioDAO.funcionarios.size(); i++) {
            Funcionario funcionarioAtual = FuncionarioDAO.funcionarios.get(i);
            if(funcionarioAtual.getCod() == funcionario.getCod()) {
                FuncionarioDAO.funcionarios.set(i, funcionario);
                return;
            }
        }
    }

    @Override
    public ArrayList<Funcionario> getAll() {
        return FuncionarioDAO.funcionarios;
    }

    @Override
    public Funcionario getByCod(int cod) {
        for(int i = 0; i < FuncionarioDAO.funcionarios.size(); i++){
            Funcionario funcionarioAtual = FuncionarioDAO.funcionarios.get(i);
            if(cod == funcionarioAtual.getCod())
                return funcionarioAtual;
        }  

        return null;
    }

}
