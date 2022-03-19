package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sum(new String[]{"1", "3", "2", "1"}));
    }


    public static String sum(String[] arr) {
        var wynik = 0;
        for(var i = 0; i < arr.length; i++){
            wynik += Integer.parseInt(arr[i]);
        }
        return String.valueOf(wynik);
    }
}
