package passagemaerea;

import java.util.Scanner;

public class Util {

    static String pedeString(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in).nextLine();
    }

    static int pedeInteiro(String mensagem) {
       
            System.out.println(mensagem);
            return new Scanner(System.in).nextInt();
       
           
        }
    }


