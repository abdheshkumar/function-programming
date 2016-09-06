package parkar.parallel;

import java.util.*;

/**
 * Created by abdhesh on 9/6/16.
 */
class SampleImperativeVsDeclarative {
    public static void findName(List<String> names) {
        boolean temp = false;
        for (String name : names) {
            if (name.equals("Abdhesh")) {
                temp = true;
                break;
            }
        }
        if(temp){
            System.out.println("Name found -:)");
        }else{
            System.out.println("Name not found -:(");
        }
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Piyush", "Hariom", "Santosh.K", "Abdhesh");
        findName(names);
    }
}

/**
 * if(names.contains("Abdhesh")){
 System.out.println("Name found -:)");
 }else{
 System.out.println("Name not found -:(");
 }
 You take all efforts to how to do as well what to do but declarative style you only
 need to say what to do. you don't need to spent time on how to do.
 so what contains function do? It says i don't care you how rude is this.
 but say in polite. it is encapsulation
 */



