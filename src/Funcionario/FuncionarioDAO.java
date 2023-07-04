import java.util.ArrayList;

public class FuncionarioDAO implements DAO<Funcionario> {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    /**
     * Insere um novo funcionário no banco de dados
     * @param funcionario a ser inserido no banco de dados
     */
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

    /**
     * Deleta um funcionário do banco de dados 
     * @param codigo do funcionario que vai ser deletado do banco de dados
     */
    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < FuncionarioDAO.funcionarios.size(); i++){
            if(codigo == FuncionarioDAO.funcionarios.get(i).getCod()){
                FuncionarioDAO.funcionarios.remove(i);
            }
        }
    }

    /**
     * Busca o funcionário pelo seu código, caso encontre, o mesmo é editado, caso contrário, nada acontece
     * @param funcionario a ser editado no banco de dados
     */
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

    /**
     * Retorna todos os funcionários do banco de dados
     * @return ArrayList<Funcionario>
     */
    @Override
    public ArrayList<Funcionario> getAll() {
        return FuncionarioDAO.funcionarios;
    }

    /**
     * Procura um funcionário no banco de dados, caso não ache o funcionário, retorna null 
     * @param cod do funcionário a ser buscado no banco de dados
     * @return Funcionario
     */
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
