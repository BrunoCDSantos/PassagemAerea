package passagemaerea;

public class Principal {

    public static String AeroportoOrigem = "";
    public static String AeroportoDestino = "";
    static String dataSaida;

    public static void main(String[] args) {
        cuidaLinha();
        cuidaPessoa();
    }

    private static void cuidaLinha() {
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

    private static void cuidaPessoa() {
        Pessoa p = new Pessoa();
       
    }
}
