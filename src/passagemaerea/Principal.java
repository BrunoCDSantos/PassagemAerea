package passagemaerea;

import java.util.ArrayList;

public class Principal {

    public String AeroportoOrigem = "";
    public String AeroportoDestino = "";
    String dataSaida;
    final private ArrayList<Cliente> listaClientes = new ArrayList();
    final private ArrayList<Passageiro> Passageiros = new ArrayList();

    public static void main(String[] args) {
        Principal programa = new Principal();
        programa.iniciaPrograma();
    }

    private void cuidaLinha() {
        Aeroporto mostra = new Aeroporto();
        Linha linha = new Linha();
        Aeroporto a = new Aeroporto();
        System.out.println("**************************************************************************************************************");
        for (String b : mostra.aeroportos) {
            System.out.println(b + "\n");
        }
        AeroportoOrigem = linha.pedeOrigemDestino("Escolha um aeroporto acima como o de embarque (informe apenas a IATA):").toUpperCase();
        a.VerificaAeroporto(AeroportoOrigem);
        do {
            System.out.println("**************************************************************************************************************");
            for (String b : mostra.aeroportos) {
                if (!AeroportoOrigem.equalsIgnoreCase(b)) {
                    System.out.println(b + "\n");
                }
            }
            AeroportoDestino = linha.pedeOrigemDestino("Escolha um aeroporto acima como o de desembarque (informe apenas a IATA)").toUpperCase();
            a.VerificaAeroporto(AeroportoDestino);
        } while (AeroportoOrigem.equals(AeroportoDestino));
        dataSaida = linha.pedeData();
        linha.CalculaPrevisão(AeroportoOrigem, AeroportoDestino);

    }

    private Cliente buscaCliente(String cpf) {
        for (Cliente objeto : listaClientes) {
            if (objeto.getCpf().equals(cpf)) {
                return objeto;
            }
        }
        return null;
    }

    private String verificaCpf(String mensagem) {
        String CpfVerificado;
        String mask = "[0-9]{3}?\\.[0-9]{3}?\\.[0-9]{3}?\\-[0-9]{2}";
        do {
            CpfVerificado = Util.pedeString(mensagem + " (formato: xxx.xxx.xxx-xx, não podendo conter letras):");
        } while (!CpfVerificado.matches(mask));
        return CpfVerificado;
    }

    private void cadastroDaVenda(int quantidadePassagem, String CpfCliente) { 
        String nome;
        String IDs;
        int lugar;
        int idadePassageiro;
        String Telefone;
        String CpfPassageiro;
        String tipoPassagem;
        float precoPS;
        String IdPss;
        Passagem IdPassagem = new Passagem();
        Linha preco = new Linha();
        Aviao ids = new Aviao();
        Venda psVendidas = new Venda();
        
        for (int i = 0; i < quantidadePassagem; i++) {
            nome = psVendidas.Nome();
            CpfPassageiro = verificaCpf("Digite o Cpf do Passageiro:");
            Telefone = psVendidas.Telefone();
            IDs = IdPassagem.IDsPassagem();
            lugar = ids.InformaLugar();
            idadePassageiro = psVendidas.idadePassageiro;
            if ( idadePassageiro < 13) {
                tipoPassagem = "Passagem meia";
                precoPS = (float) (preco.preco * 0.25);
            } else {
                tipoPassagem = "Passagem Inteira";
                precoPS = preco.preco;
            }
            Passageiros.add(new Passageiro(nome,CpfCliente,CpfPassageiro, Telefone, tipoPassagem, IDs, idadePassageiro , lugar, precoPS));
        }
        System.out.println("Passagem cadastratadas com sucesso.");
      
    }

    private void verificacaoCliente(boolean passa, String cpf) {
        String cpfCliente = cpf;
        int IdadeCliente;
        String nomeCliente;
        String telefoneCliente;

        String maskTelefone = "\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}";
        if (passa) {
            cpfCliente = verificaCpf("Digite o CPF do cliente:");
        }
        Cliente cliente = buscaCliente(cpfCliente);

        // verifica se o cliente está ou não cadastrado.
        if (cliente == null) {

            // como o cliente não está cadastrado, cria um objeto da classe Cliente e pede os demais dados para fazer o cadastro dele.
            do {
                nomeCliente = Util.pedeString("Digite o nome do cliente(diferente de vazio):");
            } while ("".equals(nomeCliente));

            do {
                IdadeCliente = Util.pedeInteiro("Digite a idade do cliente(de 17 à 100)");
            } while (IdadeCliente < 17 || IdadeCliente > 99);

            if (IdadeCliente > 17) {
                do {

                    telefoneCliente = Util.pedeString("Informe o telefone do cliente(formato: (xx)xxxx-xxxx, não podendo conter letras):");
                } while (!telefoneCliente.matches(maskTelefone));

                String endereco = Util.pedeString("Informe o endereço:");
                cliente = new Cliente(nomeCliente, cpfCliente, endereco, telefoneCliente, IdadeCliente);

                // adiciona o objeto criado para manter o cliente cadastrado na memória do programa.
                listaClientes.add(cliente);
                System.out.println("Cliente cadastrado com sucesso!");

            } else {
                System.out.println("Não é possivel cadastrar o usuário, idade menor que o permitido (menor de 18 anos)."
                        + "\ndigite um úsuario com idade valida:");
            }
        } else {
            System.out.println("Cliente já cadastrado no sistema.");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Idade: " + cliente.getIdade());
        }
    }

    private void montaListaClientes() {
        listaClientes.add(new Cliente("Joao da Silva1", "168.129.201-02", "333", "44", 18));
    }

    private void vendaPassagem() {
        int escolha;
        String CpfVenda;

        CpfVenda = verificaCpf("Iniciaremos a venda de passagens áreas, por favor digite \n"
                + "seu CPF para continuarmos: ");

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
            int qtdPassagem = Util.pedeInteiro("Quantas passagens o senhor(a) gostaria?");
            int pss = Util.pedeInteiro("O senhor(a) será um passageiro?\n"
                    + "1 - sim\n"
                    + "2 - não");
            if (pss == 1) {
                Passageiros.add(new Passageiro(nome,CpfCliente,CpfPassageiro, Telefone, tipoPassagem, IDs, idadePassageiro , lugar, precoPS));
                qtdPassagem = qtdPassagem - 1;
            }
            cadastroDaVenda(qtdPassagem, CpfVenda);
        }
    }

    private void iniciaPrograma() {
        montaListaClientes();
        int opcao;
        try {
            do {
                opcao = Util.pedeInteiro("Selecione a opção desejada:"
                        + " \n 1 - Cadastrar"
                        + " \n 2 - Vender"
                        + " \n 3 - Sair:");

                switch (opcao) {
                    case 1:
                        verificacaoCliente(true, "0");
                        break;
                    case 2:
                        vendaPassagem();
                        break;
                }
            } while (opcao != 3);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Valor informado inválido, programa encerrado por erro(Digite um número não uma letra).");
        }
    }
}
