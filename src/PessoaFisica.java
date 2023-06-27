public class PessoaFisica extends Pessoa {
    protected String cpf;
    protected char sexo;
    
    public PessoaFisica(String nome, String telefone, String endereco, String cpf, char sexo) throws ApplicationError {
        super(nome, telefone, endereco);

        this.cpf = cpf;
        this.sexo = sexo;
    }

    public PessoaFisica() {
        super();
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) throws ApplicationError {
        String regex = "(\\d{3}).(\\d{3}).(\\d{3})-(\\d{2})";
        if(!cpf.matches(regex)) {
            throw new ApplicationError("CPF inválido");
        }

        this.cpf = cpf;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) throws ApplicationError {
        if(sexo == 'm') {
            sexo = 'M';
        } else if(sexo == 'f') {
            sexo = 'F';
        }

        if(sexo != 'M' && sexo != 'F') {
            throw new ApplicationError("Sexo inválido");
        }
        this.sexo = sexo;
    }
}