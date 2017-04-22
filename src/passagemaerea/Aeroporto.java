package passagemaerea;

public class Aeroporto {

    String iata;
    boolean verdadeiro = true;
        String[] aeroportos = {"John F. Kennedy", "Orlando", "Los Angeles", "Guarulhos", "Antônio Carlos Jobim", "Hercílio Luz","Nova Iorque", "São Paulo", "Rio de Janeiro", "Florianópolis"};
        String[] iatas = {"JFK", "MCO", "LAX", "GRU", "GIG", "FLN"};
    public void VerificaAeroporto(String aeroporto) {
        
        if (aeroporto.length() == 3) {
            aeroporto = aeroporto.toUpperCase();
            for (String b : iatas) {
                if (aeroporto.equals(b)) {
                    verdadeiro = false;
                }
            }
        }
        for (String a : aeroportos) {
            if (aeroporto.equalsIgnoreCase(a)) {
                verdadeiro = false;
            }
        }

    }

}