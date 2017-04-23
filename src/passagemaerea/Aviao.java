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
    
    public int InformaLugar(){
        Random l = new Random();
        lugar = l.nextInt((200 - 1) + 1) + 1;
        return lugar;
    }
}