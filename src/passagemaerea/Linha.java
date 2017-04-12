package passagemaerea;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        boolean verific;
        //método para chamar a data atual
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateAtual = formatter.format(date);
        Date dataInformada = null;

        do {
            System.out.println("Informe a data de embarque (dd/mm/aaaa)");
            data = leia.nextLine();
            verific = VerificaData(data, dateAtual);
            if (!verific) {
                try {
                    dataInformada = (Date) formatter.parse(data);
                    verific = false;
                } catch (ParseException ex) {
                    System.out.println("Data inválida, digite novamente.");
                    verific = true;
                }
            }
        } while (verific);
        return data;
    }

    public boolean VerificaData(String data, String dataAtual) {

        int[] diasNoMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      //separação da data atual em mês e ano
        int mesAtual = Integer.valueOf(dataAtual.substring(3, 5));
        int anoAtual = Integer.valueOf(dataAtual.substring(6));
        int dia = Integer.valueOf(data.substring(0, 2));
      
        try {
            int mes = Integer.valueOf(data.substring(3, 5));
            int maiorDia = diasNoMes[mes - 1];
            int ano = Integer.valueOf(data.substring(6));
             if (ano > anoAtual) {
                return false;
            }
              if (mes < mesAtual){
                  System.out.println("Data inválida.");
                return true;
            }
            if (dia < 0 || dia > maiorDia) {
                System.out.println("Data inválida.");
                return true;
            }
                      
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return true;
        }
        return false;
    }

    public void CalculaPrevisão() {

    }
}