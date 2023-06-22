import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int controlador = 0;
        inserirValoresDefault();

        System.out.println("Aplicação inicializada!\n");
        do {
            System.out.println("Selecione uma opção:\n");
            System.out.println("1. Produtos");
            System.out.println("2. Clientes");
            System.out.println("3. Funcionários");
            System.out.println("4. Ingredientes");
            System.out.println("5. Fornecedores");

            controlador = Integer.parseInt(System.console().readLine());
            int subControlador = -1;

            while(controlador != 0 && subControlador != 0) {
                switch (controlador) {
                    case 1:
                        System.out.println("--PRODUTOS--");
                        System.out.println("0. Sair");
                        System.out.println("1. Listar");
                        System.out.println("2. Cadastrar");
                        System.out.println("3. Deletar");
                        System.out.println("4. Editar");
                        subControlador = Integer.parseInt(System.console().readLine());
                        
                        if(subControlador == 1) {
                            listarProdutos();
                        } else if(subControlador == 2) {
                            cadastrarProduto();
                        } else if(subControlador == 3) {
                            deletarProduto();
                        } else if(subControlador == 4) {
                            editarProduto();
                        }

                        break;

                    case 2:
                        System.out.println("--CLIENTES--");
                        System.out.println("0. Sair");
                        System.out.println("1. Listar");
                        System.out.println("2. Cadastrar");
                        System.out.println("3. Editar");
                        System.out.println("4. Anotar Pedido");
                        System.out.println("5. Receber Pagamento");
                        subControlador = Integer.parseInt(System.console().readLine());

                        if(subControlador == 1) {
                            listarClientes();
                        } else if(subControlador == 2) {
                            cadastrarCliente();
                        } else if(subControlador == 3) {
                            editarCliente();
                        }

                        break;

                    case 3:
                        System.out.println("--FUNCIONARIOS--");
                        System.out.println("0. Sair");
                        System.out.println("1. Admitir Funcionário");
                        System.out.println("2. Demitir Funcionário");
                        subControlador = Integer.parseInt(System.console().readLine());
  
                        if(subControlador == 1) {
                            // admitirFuncionario();
                        } else if(subControlador == 2) {
                            // demitirFuncionario();
                        }

                        break;

                    case 4:
                        System.out.println("--INGREDIENTES--");
                        System.out.println("0. Sair");
                        System.out.println("1. Listar");
                        System.out.println("2. Cadastrar");
                        System.out.println("3. Deletar");
                        System.out.println("4. Adicionar Estoque");

                        if(subControlador == 1) {
                            // listarIngredientes();
                        } else if(subControlador == 2) {
                            // cadastrarIngrediente();
                        } else if(subControlador == 3) {
                            // deletarIngrediente();
                        } else if(subControlador == 4) {
                            // adicionarEstoqueIngrediente();
                        }
                        break;

                    case 5:
                        System.out.println("--FORNECEDORES--");
                        System.out.println("0. Sair");
                        System.out.println("1. Listar");
                        System.out.println("2. Cadastrar");
                        System.out.println("3. Editar");
                        System.out.println("4. Deletar");
                        break;
                    
                    default:
                        break;
                }
            }
        } while(controlador != 0);

    }

    public static void inserirValoresDefault() {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        int i;
        ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>(Arrays.asList(
            new Ingrediente("Pão", 10),
            new Ingrediente("Ovo", 10),
            new Ingrediente("Hambúrguer", 10),
            new Ingrediente("Frango", 10),
            new Ingrediente("Strogonoff", 10),
            new Ingrediente("Calabresa", 10),
            new Ingrediente("Bacon", 10),
            new Ingrediente("Filé", 10),
            new Ingrediente("Coração", 10),
            new Ingrediente("Queijo", 10),
            new Ingrediente("Tomate", 10),
            new Ingrediente("Alface", 10),
            new Ingrediente("Fritas", 10),
            new Ingrediente("Molho 4 queijos", 10),
            new Ingrediente("Presunto", 10),
            new Ingrediente("Carne", 10),
            new Ingrediente("Catupiry", 10),
            new Ingrediente("Milho", 10),
            new Ingrediente("Ervilha", 10)
        ));

        for(i = 0; i < ingredientes.size(); i++) {
            ingredienteDAO.inserir(ingredientes.get(i));
        }

        ArrayList<Produto> produtos = new ArrayList<Produto>(Arrays.asList(
            new Produto("Xis Salada", Categoria.Lanches, 18, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Hambúrguer",  "Queijo", "Presunto", "Tomate", "Alface", "Fritas", "Maionese", "Ovo" })),
            new Produto("Xis Frango c/ Cautupiry", Categoria.Lanches, 24, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Frango",  "Catupiry", "Queijo", "Tomate", "Alface", "Maionese", "Ovo" })),
            new Produto("Xis Gado 4 queijos", Categoria.Lanches, 24, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Hambúrguer",  "Queijo", "Molho 4 queijos", "Tomate", "Alface", "Fritas", "Maionese", "Ovo" })),
            new Produto("Xis Coração", Categoria.Lanches, 27, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Coração",  "Queijo", "Tomate", "Alface", "Fritas", "Maionese", "Ovo" })),
            new Produto("Xis Calabresa", Categoria.Lanches, 23, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Calabresa",  "Queijo", "Tomate", "Alface", "Fritas", "Maionese", "Ovo" })),
            new Produto("Xis Bacon", Categoria.Lanches, 24, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Hambúrguer", "Bacon", "Queijo", "Tomate", "Alface", "Fritas", "Maionese", "Ovo" })),
            new Produto("Xis Strogonoff", Categoria.Lanches, 28, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Strogonoff",  "Queijo", "Milho", "Ervilha", "Tomate", "Alface", "Fritas", "Maionese", "Ovo" })),
            new Produto("Xis Filé", Categoria.Lanches, 28, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Filé",  "Queijo", "Presunto", "Milho", "Ervilha", "Tomate", "Alface", "Fritas", "Maionese", "Ovo" })),
            new Produto("Torrada c/ Strogonoff", Categoria.Lanches, 22, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Strogonoff",  "Queijo", "Maionese", "Ovo" })),
            new Produto("Torrada Simples", Categoria.Lanches, 15, ingredienteDAO.getCodByNomes(new String[] { "Pão", "Queijo",  "Presunto", "Maionese" })),
            new Produto("Fritas", Categoria.Porções, 25, ingredienteDAO.getCodByNomes(new String[] { "Fritas" })),
            new Produto("Batata Torre Misto", Categoria.BatataEmTorre, 89.9, ingredienteDAO.getCodByNomes(new String[] { "Fritas", "Bacon", "Coração", "Frango", "Calabresa", "Queijo", "Molho 4 queijos" })),
            new Produto("Batata Torre Coração", Categoria.BatataEmTorre, 69.9, ingredienteDAO.getCodByNomes(new String[] { "Fritas", "Coração", "Queijo", "Molho 4 queijos" })),
            new Produto("Batata Torre Strogonoff", Categoria.BatataEmTorre, 79.9, ingredienteDAO.getCodByNomes(new String[] { "Fritas", "Strogonoff"  })),
            new Produto("Pastel de Carne", Categoria.Pasteis, 11.5, ingredienteDAO.getCodByNomes(new String[] { "Carne", "Ovo"  })),
            new Produto("Pastel de Frango", Categoria.Pasteis, 11.5, ingredienteDAO.getCodByNomes(new String[] { "Frango", "Catupiry"  })),
            new Produto("Pastel de Strogonoff", Categoria.Pasteis, 20.5, ingredienteDAO.getCodByNomes(new String[] { "Strogonoff"  })),
            new Produto("Pastel de Queijo", Categoria.Pasteis, 12.5, ingredienteDAO.getCodByNomes(new String[] { "Queijo"  }))
        ));

        for(i = 0; i < produtos.size(); i++) {
            produtoDAO.inserir(produtos.get(i));
        }

        ArrayList<Cliente> clientes = new ArrayList<Cliente>(Arrays.asList(
            new Cliente("Pablo", "(33) 90852-2531", "Avenida Sabin, 1556", "183.043.700-34", 'M'),
            new Cliente("Giordano", "(37) 7940-2950", "Rua Donato Caetano Machado, 691", "258.846.510-23", 'M'),
            new Cliente("José", "(54) 95193-1945", "Rua Joaquim Silveira Filho, 1951", "714.290.560-37", 'M'),
            new Cliente("Vitória", "(46) 91193-1586", "Praça Santa Terezinha, 1917", "175.327.390-07", 'F')
        ));

        for(i = 0; i < clientes.size(); i++) {
            clienteDAO.inserir(clientes.get(i));
        }

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>(Arrays.asList(
            new Funcionario("João", "(31) 5612-3642", "Alameda dos Guatás, 1364", 1200, "Garçom", "10/10/2000", "12/05/2023"),
            new Funcionario("Vinicius", "(66) 5158-5731", "Rua Barra Mansa, 991", 1200, "Garçom", "22/07/2002", "05/03/2022"),
            new Funcionario("Maria", "(47) 3747-9839", "Rua Maranhão, 1099", 1800, "Gerente", "07/11/1998", "23/09/2018"),
            new Funcionario("Sofia", "(85) 7286-3751", "Rua Chico Mendes, 1155", 1350, "Cozinheira", "13/06/1996", "07/07/2021")
        ));

        for(i = 0; i < funcionarios.size(); i++) {
            funcionarioDAO.inserir(funcionarios.get(i));
        }
    }

    static void listarProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        ArrayList<Produto> produtos = produtoDAO.getAll();
        ArrayList<Ingrediente> ingredientes;

        for(int i = 0; i < produtos.size(); i++) {
            Produto produtoAtual = produtos.get(i);
            System.out.println(produtoAtual.toString());
            
            ingredientes = ingredienteDAO.getByCods(produtoAtual.getIngredientesId());
            System.out.print("Ingredientes: ");
            for(int j = 0; j < ingredientes.size(); j++) {
                if(j == ingredientes.size() - 1) {
                    System.out.println(ingredientes.get(j).getNome() + "\n");
                } else {
                    System.out.print(ingredientes.get(j).getNome() + ", ");
                }
            }
        }
    }

    static void cadastrarProduto(){
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto novoProduto = new Produto();
        String nome;
        int categoria;
        double valor;

        System.out.print("Digite o nome do produto: ");
        nome = System.console().readLine();
        novoProduto.setNome(nome);

        System.out.print("\nDigite a categoria do produto: ");
        System.out.print("\n1- Lanches");
        System.out.print("\n2- Porções");
        System.out.print("\n3- Batata em Torre");
        System.out.print("\n4- Pasteis\n");
        categoria = Integer.parseInt(System.console().readLine());

        switch (categoria) {
            case 1:
                novoProduto.setCategoria(Categoria.Lanches);
                break;
            case 2:
                novoProduto.setCategoria(Categoria.Porções);
                break;
            case 3:
                novoProduto.setCategoria(Categoria.BatataEmTorre);
                break;
            case 4:
                novoProduto.setCategoria(Categoria.Pasteis);
                break;
            default:
                System.out.println("Código inválido. Por favor, tente novamente.\n");
                return;
        }

        System.out.print("Digite o valor do produto: ");
        valor = Double.parseDouble(System.console().readLine());
        novoProduto.setValor(valor);

        ArrayList<Ingrediente> ingredientes = ingredienteDAO.getAll();
         new ArrayList<Integer>();

        for(int i = 0; i < ingredientes.size(); i++) {
            Ingrediente ingredienteAtual = ingredientes.get(i);
            System.out.println(ingredienteAtual.getCod() + "- " + ingredienteAtual.getNome());
        };
        System.out.print("\nDigite os códigos dos ingredientes separados por virgula. Ex: 1, 2, 3: ");
            
        // TODO: Validar se a resposta está formatada corretamente
        String[] ingredientesSelecionados = System.console().readLine().split(",");
        ArrayList<Integer> ingredientesCod = new ArrayList<Integer>();
        for(int i = 0; i < ingredientesSelecionados.length; i++){
            int valorConvertido = Integer.parseInt(ingredientesSelecionados[i].trim());
            ingredientesCod.add(valorConvertido);
        }
            
        novoProduto.setIngredientesId(ingredientesCod);
        produtoDAO.inserir(novoProduto);

        System.out.println("\nProduto cadastrado com sucesso.\n");

    }

    static void deletarProduto() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtos = produtoDAO.getAll();
            

        System.out.println("Produtos:");
        for(int i = 0; i < produtos.size(); i ++) {
            System.out.println(produtos.get(i).toString());
        }
        System.out.print("Digite o codigo do produto que deseja deletar: ");
        int codigo = Integer.parseInt(System.console().readLine());

        produtoDAO.deletar(codigo);
        System.out.println("Deletado com sucesso!");
    }
        
    static void editarProduto(){
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            IngredienteDAO ingredienteDAO = new IngredienteDAO();
            ArrayList<Produto> produtos = produtoDAO.getAll();

            System.out.println("Produtos: ");
            for(int i = 0; i < produtos.size(); i++){
                System.out.println(produtos.get(i).toString());
            }

            System.out.print("Digite o codigo do produto que deseja altera: ");
            int codigo = Integer.parseInt(System.console().readLine());
            
            Produto produto = produtoDAO.getByCod(codigo);
            String nome;
            int categoria;
            double valor;

            System.out.print("Caso não queira editar algum campo, digite '#'");
            System.out.print("Digite o nome do produto: ");
            nome = System.console().readLine();
            produto.setNome(nome);

            System.out.print("\nDigite a categoria do produto: ");
            System.out.print("\n1- Lanches");
            System.out.print("\n2- Porções");
            System.out.print("\n3- Batata em Torre");
            System.out.print("\n4- Pasteis\n");
            categoria = Integer.parseInt(System.console().readLine());

            switch (categoria) {
                case 1:
                    produto.setCategoria(Categoria.Lanches);
                    break;
                case 2:
                    produto.setCategoria(Categoria.Porções);
                    break;
                case 3:
                    produto.setCategoria(Categoria.BatataEmTorre);
                    break;
                case 4:
                    produto.setCategoria(Categoria.Pasteis);
                    break;
                default:
                    return;
            }


            System.out.print("Digite o valor do produto: ");
            valor = Double.parseDouble(System.console().readLine());
            produto.setValor(valor);

            ArrayList<Ingrediente> ingredientes = ingredienteDAO.getAll();
            new ArrayList<Integer>();

            for(int i = 0; i < ingredientes.size(); i++) {
                Ingrediente ingredienteAtual = ingredientes.get(i);
                System.out.println(ingredienteAtual.getCod() + "- " + ingredienteAtual.getNome());
            };
            System.out.print("\nDigite os códigos dos ingredientes separados por virgula. Ex: 1, 2, 3: ");
                
            // TODO: Validar se a resposta está formatada corretamente
            String[] ingredientesSelecionados = System.console().readLine().split(",");
            ArrayList<Integer> ingredientesCod = new ArrayList<Integer>();
            for(int i = 0; i < ingredientesSelecionados.length; i++){
                int valorConvertido = Integer.parseInt(ingredientesSelecionados[i].trim());
                ingredientesCod.add(valorConvertido);
            }
                
            produto.setIngredientesId(ingredientesCod);
            produtoDAO.editar(produto);

            System.out.println("\nProduto cadastrado com sucesso.\n");
        } catch(Error erro) {
            System.out.println(erro.getMessage());
        }
        
    }

    static void cadastrarCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        String cpf;
        String nome;
        String telefone;
        String endereco;
        char sexo;

        System.out.print("\nDigite o cpf do cliente: ");
        cpf = System.console().readLine();

        System.out.print("Digite o nome do cliente: ");
        nome = System.console().readLine();

        System.out.print("\nDigite o telefone do cliente: ");
        telefone = System.console().readLine();

        System.out.print("\nDigite o endereco do cliente: ");
        endereco = System.console().readLine();
        
        System.out.print("\nDigite o sexo do cliente: ");
        sexo = System.console().readLine().charAt(0);

        Cliente novoCliente = new Cliente(nome, telefone, endereco, cpf, sexo);
        clienteDAO.inserir(novoCliente);
        System.out.println("\nCliente cadastrado com sucesso.\n");
    }

    static void editarCliente() {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            ArrayList<Cliente> clientes = clienteDAO.getAll();

            for(int i = 0; i < clientes.size(); i++) {
                System.out.println(clientes.get(i).toString());
            }

            System.out.print("Digite o código do cliente que deseja alterar: ");
            int codigo = Integer.parseInt(System.console().readLine());

            Cliente cliente = clienteDAO.getByCod(codigo);
            
            String nome;
            String telefone;
            String endereco;
            char sexo;

            System.out.print("Caso não queira editar algum campo, digite '#'");
            System.out.print("\nDigite o nome do cliente: ");
            nome = System.console().readLine();
            cliente.setNome(nome);

            System.out.print("\nDigite o telefone do cliente: ");
            telefone = System.console().readLine();
            cliente.setTelefone(telefone);

            System.out.print("\nDigite o endereco do cliente: ");
            endereco = System.console().readLine();
            cliente.setEndereco(endereco);
            
            System.out.print("\nDigite o sexo do cliente: ");
            sexo = System.console().readLine().charAt(0);
            cliente.setSexo(sexo);

            clienteDAO.editar(cliente);
            System.out.println("\nCliente cadastrado com sucesso.\n");
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void listarClientes(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.getAll();
        
         for(int i = 0; i < clientes.size(); i++) {
                System.out.println(clientes.get(i).toString());
            }
    }
}
