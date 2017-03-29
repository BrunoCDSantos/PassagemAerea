package passagemaerea;

public class Principal {
   
    static String AeroportoOrigem;
    static String AeroportoDestino;
    String msg = "Informe o aeroporto de";
    
    public static void main(String[] args) {
           Linha linha = new Linha();
           linha.pedeOrigemDestino(msg);
           AeroportoOrigem = linha.pedeOrigemDestino(AeroportoOrigem);
           AeroportoDestino = linha.pedeOrigemDestino(AeroportoOrigem);
        
    }

}
