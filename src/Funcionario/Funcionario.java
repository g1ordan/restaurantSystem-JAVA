public class Funcionario extends PessoaFisica {
    private double salario;
    private String funcao;
    private String dataNasci;
    private String admissao;
    final private String regexData = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";


    public Funcionario(String nome, String telefone, String endereco, String cpf, char sexo, double salario, String funcao, String dataNasci, String admissao) throws ApplicationError {
        super(nome, telefone, endereco, cpf, sexo);
        
        this.salario = salario;
        this.funcao = funcao;
        this.dataNasci = dataNasci;
        this.admissao = admissao;
    }

    public Funcionario(){
        super();
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDataNasci() {
        return this.dataNasci;
    }

    public void setDataNasci(String dataNasci) throws ApplicationError {
        if(!dataNasci.matches(this.regexData)) {
            throw new ApplicationError("Data de nascimento inválida");
        }
        this.dataNasci = dataNasci;
    }

    public String getAdmissao() {
        return this.admissao;
    }

    public void setAdmissao(String admissao) throws ApplicationError {
        if(!admissao.matches(this.regexData)) {
            throw new ApplicationError("Data de admissão inválida");
        }
        this.admissao = admissao;
    }

    @Override
    public String toString() {

        return  "Código: " + this.cod +
            "\nCpf: " + this.cpf +
            "\nNome: " + this.nome +
            "\nTelefone: " + this.telefone +
            "\nEndereço: " + this.endereco +
            "\nSexo: " + this.sexo +
            "\nFunção: " + this.funcao +
            "\nData de Nascimento: " + this.dataNasci +
            "\nData de Admissão: " + this.admissao;
    } 
}