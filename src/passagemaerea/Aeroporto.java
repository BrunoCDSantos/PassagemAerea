package passagemaerea;

import java.util.ArrayList;

public class Aeroporto {

    String iata;
    boolean verdadeiro = true;
    String[] aeroportos = {"John F. Kennedy", "Antônio Carlos Jobim", "Hercílio Luz"};
    String[] iatas = {"JFK", "GIG", "FLN"};
    ArrayList<PrevisaoPreco> chega = new ArrayList();

    public void carregaArrayList() {
        chega.add(new PrevisaoPreco("JFK", "GIG", "10h09", 3097.00f));
        chega.add(new PrevisaoPreco("JFK", "FLN", "10h22", 3244.00f));
        chega.add(new PrevisaoPreco("GIG", "JFK", "10h09", 3097.00f));
        chega.add(new PrevisaoPreco("FLN", "JFK", "10h22", 3244.00f));
        chega.add(new PrevisaoPreco("GIG", "FLN", "1h33", 166.00f));
        chega.add(new PrevisaoPreco("FLN", "GIG", "1h33", 166.00f));
    }

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
