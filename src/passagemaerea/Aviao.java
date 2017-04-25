package passagemaerea;

import java.util.Random;

public class Aviao {

    int lugar;
    int numeroVoo;

    public int InformaVoo() {
        Random n = new Random();
        numeroVoo = n.nextInt((999 - 99) + 1) + 100;
        return numeroVoo;
    }

    public int InformaLugar() {

        int lugar1 = lugar + 001;
        lugar = lugar1;
        return lugar1;
    }
}
