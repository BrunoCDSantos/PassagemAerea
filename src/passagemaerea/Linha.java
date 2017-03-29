package passagemaerea;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Linha {

    static Scanner leia = new Scanner(System.in);

    public String pedeOrigemDestino(String msg) {
        System.out.println(msg);
        String Aeroporto = leia.nextLine().trim();
        return Aeroporto;
    }

    public String pedeData() {
        String data;
        Boolean verific;

        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date dataInformada = null;
        do {
            System.out.println("Informe a data de embarque (dd/mm/aaaa)");
            data = leia.nextLine();
            try {
                dataInformada = (Date) formatter.parse(data);
                verific = false;
            } catch (ParseException ex) {
                System.out.println("seu burro, digite uma data válida.");
                verific = true;
            }
        } while (verific);

        Calendar c = Calendar.getInstance();
        c.setTime(dataInformada);
        System.out.println("semana: " + c.getWeekYear());
        return data;
    }

    public static void main(String[] args) {
        Linha l = new Linha();
        String s = l.pedeData();
    }

    public void calculaPrevisão() {

    }
}
