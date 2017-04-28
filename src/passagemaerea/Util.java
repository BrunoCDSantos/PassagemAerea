package passagemaerea;

import java.util.Scanner;

public class Util {

    static String pedeString(String mensagem) {
        Scanner leia = new Scanner(System.in);
        String str;
        do {
            System.out.println(mensagem);
            str = leia.nextLine().trim();
        } while (str.length() == 0);
        return str;
    }

    static int pedeInteiro(String mensagem) {
        Scanner leia = new Scanner(System.in);
        int num;
        try {
            System.out.println(mensagem);
            num = leia.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Valor informado inválido, informe apenas números.");
            num = pedeInteiro(mensagem);
        }
        return num;
    }
}
