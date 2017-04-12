package passagemaerea;

import java.util.ArrayList;

public class Principal {

    public String AeroportoOrigem = "";
    public String AeroportoDestino = "";
    String dataSaida;
    private ArrayList<Cliente> listaClientes = new ArrayList();
    

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

    
    private Cliente buscaCliente(String cpf){
        for (Cliente objeto : listaClientes) {
            if (objeto.getCpf().equals(cpf)) {
                return objeto;
            }
        }
        return null;
    }
    
    private void vendaPassagem(){
        String cpfCliente = Util.pedeString("Digite o CPF do cliente:");
        Cliente cliente = buscaCliente(cpfCliente);
        
        // verifica se o cliente está ou não cadastrado.
        if (cliente == null) {
            // como o cliente não está cadastrado, cria um objeto
            // da classe Cliente e pede os demais dados para fazer o cadastro dele.
            System.out.println("O cliente ainda não está cadastrado. Vamos fazer o cadastro agora.");
            cliente = new Cliente(Util.pedeString("Digite o nome do cliente:"), cpfCliente);
            
            // adiciona o objeto criado para manter o cliente cadastrado na memória
            // do programa.
            listaClientes.add(cliente);
        } else {
            System.out.println("Nome do cliente:" + cliente.getNome());
        }
        
        //
    }

    private void montaListaClientes(){
        listaClientes.add(new Cliente("Joao da Silva1", "1"));
        listaClientes.add(new Cliente("Joao da Silva12", "12"));
        listaClientes.add(new Cliente("Joao da Silva123", "123"));
        listaClientes.add(new Cliente("Joao da Silva1234", "1234"));
        listaClientes.add(new Cliente("Joao da Silva12345", "1235"));
    }
    private void iniciaPrograma() {
        montaListaClientes();
        int opcao = 0;
        do {
            opcao = Util.pedeInteiro("Selecione a opção desejada: \n 1 - Vender \n 2 - Sair");
            switch (opcao) {
                case 1 :
                    vendaPassagem();
            }
        } while (opcao != 2);
    }
}
