package passagemaerea;

public class Principal {
    static String AeroportoOrigem = "";
    static String AeroportoDestino = "";
    static String dataSaida;

    public static void main(String[] args) {
        Linha linha = new Linha();
        AeroportoOrigem = linha.pedeOrigemDestino("Informe o aeroporto de Origem (Nome ou IATA):");
        do {
            AeroportoDestino = linha.pedeOrigemDestino("Informe o aeroporto de Destino (Nome ou IATA):");
        } while (AeroportoOrigem.equals(AeroportoDestino));
        dataSaida = linha.pedeData();
    }

}
