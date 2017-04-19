package passagemaerea;

import java.util.ArrayList;

public class Principal {

    public String AeroportoOrigem = "";
    public String AeroportoDestino = "";
    String dataSaida;
    private ArrayList<Cliente> listaClientes = new ArrayList();
    private ArrayList<Cliente> Passageiros = new ArrayList();

    public static void main(String[] args) {
        Principal programa = new Principal();
        programa.iniciaPrograma();
    }

    private void cuidaLinha() {
        Linha linha = new Linha();
        //Aeroporto a = new Aeroporto();
        AeroportoOrigem = linha.pedeOrigemDestino("Informe o nome ou IATA (em letras maiúaeroporto de Origem (Nome ou IATA):");
        //a.VerificaAeroporto(AeroportoOrigem);
        do {
            AeroportoDestino = linha.pedeOrigemDestino("Informe o aeroporto de Destino (Nome ou IATA):");
            //a.VerificaAeroporto(AeroportoDestino);
        } while (AeroportoOrigem.equals(AeroportoDestino));
        dataSaida = linha.pedeData();
    }

    private Cliente buscaCliente(String cpf) {
        for (Cliente objeto : listaClientes) {
            if (objeto.getCpf().equals(cpf)) {
                return objeto;
            }
        }
        return null;
    }

    private void cadastroCliente(int quantidadePassagem) {
        int precoPassagem;
        for (int i = 0; i > quantidadePassagem; i++) {
            
        }
    }

    private void verificacaoCliente(boolean passa, String cpf) {
        String cpfCliente = cpf;
        if (passa) {
            cpfCliente = Util.pedeString("Digite o CPF do cliente:");

        }
        Cliente cliente = buscaCliente(cpfCliente);
        // verifica se o cliente está ou não cadastrado.
        if (cliente == null) {
            // como o cliente não está cadastrado, cria um objeto
            // da classe Cliente e pede os demais dados para fazer o cadastro dele.
            String nomeCliente = Util.pedeString("Digite o nome do Cliente:");
            int IdadeCliente = Util.pedeInteiro("Digite a idade do Cliente");
            if (IdadeCliente > 17) {
                String telefoneCliente = Util.pedeString("Informe o telefone do cliente");
                String endereco = Util.pedeString("Informe o endereço da sua casa:");
                cliente = new Cliente(nomeCliente, cpfCliente, endereco, telefoneCliente, IdadeCliente);

                // adiciona o objeto criado para manter o cliente cadastrado na memória
                // do programa.
                listaClientes.add(cliente);
                System.out.println("Cliente cadastrado com sucesso");

            } else {
                System.out.println("Não é possivel cadastrar o úsuario, pois é de menor de idade "
                        + "\ndigite um úsuario com idade valida:");
            }
        } else {
            System.out.println("Cliente já esta cadastrado no nosso sistema");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Idade: " + cliente.getIdade());
        }
    }

    private void montaListaClientes() {
        listaClientes.add(new Cliente("Joao da Silva1", "1", "333", "44", 18));
        listaClientes.add(new Cliente("Joao da Silva12", "12", "22", "44", 18));
        listaClientes.add(new Cliente("Joao da Silva123", "123", "123", "52", 19));
        listaClientes.add(new Cliente("Joao da Silva1234", "1234", "1234", "62", 20));
        listaClientes.add(new Cliente("Joao da Silva12345", "1235", "12345", "72", 21));
    }

    private void vendaPassagem() {
        int escolha;
        String CpfVenda;
        CpfVenda = Util.pedeString("Começaremos a venda de passagens áreas por favor digite seu CPF para continuarmos:");
        Cliente cliente = buscaCliente(CpfVenda);
        if (cliente == null) {
            escolha = Util.pedeInteiro("Cliente ainda não cadastrado, gostaria de cadastrar?\n"
                    + "1 - sim\n"
                    + "2 - não");
            if (escolha == 1) {
                verificacaoCliente(false, CpfVenda);
            }
        } else {
            cuidaLinha();
            int qtdPassagem = Util.pedeInteiro("Quantas passagens o senhor/a gostaria?");
            int pss = Util.pedeInteiro("O senhor será um passageiro?\n"
                    + "1 - sim\n"
                    + "2 - não");
            if (pss == 1) {
                qtdPassagem = qtdPassagem - 1;
            }
            cadastroCliente(qtdPassagem);
        }
    }

    private void iniciaPrograma() {
        montaListaClientes();
        int opcao;
        do {
            opcao = Util.pedeInteiro("Selecione a opção desejada:"
                    + " \n 1 - Cadastrar"
                    + " \n 2 - Vender"
                    + " \n 3  - Sair:");

            switch (opcao) {
                case 1:
                    verificacaoCliente(true, "0");
                    break;
                case 2:
                    vendaPassagem();
                    break;
            }
        } while (opcao != 3);
    }
}
