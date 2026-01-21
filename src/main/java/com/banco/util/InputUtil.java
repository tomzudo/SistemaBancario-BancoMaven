package com.banco.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem + ": ");
        return sc.nextLine();
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem + ": ");
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
    
    public static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem + ": ");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
