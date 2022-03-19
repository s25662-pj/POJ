package com.company;

public class Main {

    public static void main(String[] args) {
        sum(new String[]{"1", "3", "2", "1"});
    }


    public static void sum(String[] arr) {
        var wynik = 0;
        for(var i = 0; i < arr.length; i++){
            wynik += Integer.parseInt(arr[i]);
        }
        System.out.println(String.valueOf(wynik));
    }
}
