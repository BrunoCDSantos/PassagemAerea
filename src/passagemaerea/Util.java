/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagemaerea;

import java.util.Scanner;

/**
 *
 * @author informatica
 */
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
