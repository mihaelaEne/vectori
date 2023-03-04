package app;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.Vector;
import java.util.ListIterator;
import java.util.Iterator;
import java.io.*;

public class Functii {


    //todo:functie de afisare elementele unui vecotr

    public static void afisare(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }

    public static void sol1() {
        int[] v = {123, 32, 43, 54, 6};
        afisare(v);
    }


    //todo:functie ce primeste ca parametru un vetcor si returneaza numarul de  elemente pare

    public static int conorPare(int[] v) {

        int ct = 0;

        for (int i = 0; i < v.length; i++) {

            if (v[i] % 2 == 0) {
                ct++;
            }
        }

        return ct;

    }


    public static int contorImpare(int[] v) {
        int ct = 0;

        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 1) {
                ct++;
            }
        }
        return ct;
    }


    public static String afisareDiferenta(int[] v) {
        String text = "";
        text += "Pentru " + conorPare(v) + " numere pare si " + contorImpare(v) + " numere impare";
        text += "diferenta dintre ele este de " + (conorPare(v) - contorImpare(v));

        return text;
    }


    public static void sol2() {


        int[] v = {23, 34, 54, 56, 67, 78, 98, 21};


        afisare(v);


        System.out.println(afisareDiferenta(v));
    }


    //todo:Se citește un vector cu n elemente, numere naturale.
    // Să se afișeze elementele din vector care sunt multipli ai ultimului element.

    public static void pb546(int[] v) {

        int ultim = v[v.length - 1];
        int ct = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % ultim == 0) {
                System.out.println(v[i]);
            }
        }
    }

// fct cu cate elem cu propr mea si dupa fac vector

    //todo:Se citește un vector cu n elemente, numere naturale.
    // Să se afișeze elementele cu indici pari în ordinea crescătoare a indicilor,
    // iar elementele cu indici impari în ordinea descrescătoare a indicilor.

    public static void afisareIndiciPari(int[] v) {
        System.out.println("numerele cu indici pari:");

        for (int i = 0; i <= v.length; i += 2) {
            System.out.println(v[i]);

        }
    }

    public static void afisareIndiciImpari(int[] v) {
        System.out.println("numerele cu indici impari:");

        for (int i = 1; i < v.length; i += 2) {
            System.out.println(v[i]);

        }
    }

    public static void sol3() {
        int[] v = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        afisareIndiciImpari(v);
        afisareIndiciPari(v);

    }


    //todo:Să se determine maximul şi minimul valorilor elementelor unui vector.
    public static int maxVector(int[] v) {

        int max = v[0];

        for (int i = 0; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
            }
        }
        return max;
    }

    public static int minVector(int[] v) {
        int val = v[0];
        for (int i = 0; i < v.length; i++) {
            if (v[i] < val) {
                val = v[i];
            }
        }
        return val;
    }

    public static void sol4() {

        int[] v = {5555, 2, 3, 4, 5, 6, 7, 1, 8, 9, 10};

        String text = "";
        text += "\ncea mai mica val este: " + minVector(v);
        text += "\n cea mai mare val este: " + maxVector(v);

        System.out.println("vector:");
        afisare(v);

        System.out.println(text);
    }


//todo:Se citește un vector cu n elemente, numere naturale distincte.
// Să se afișeze elementele cuprinse între elementul cu valoarea minimă și cel cu valoare maximă din vector, inclusiv acestea.

    //todo:functie ce returneaza pozitia unui element din vector
    public static int findElement(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }


    public static int indiceMax(int[] v) {

        return findElement(v, maxVector(v));
    }

    public static int indiceMin(int[] v) {

        return findElement(v, minVector(v));
    }


    // functie care imi numara cate elemente sunt inre min si max
    public static int numarareElem(int[] v) {

        int a = indiceMax(v);
        int b = indiceMin(v);
        if (a > b) {
            int aux = a;
            a = b;
            b = aux;
        }

        int ct = 0;

        for (int i = a; i <= b; i++) {
            ct++;
        }
        return ct;
    }

    public static int[] vector(int[] v) {
        int[] vector = v;

        int numarElemente = numarareElem(v);
        int a = indiceMax(v);
        int b = indiceMin(v);


        if (a > b) {
            int aux = a;
            a = b;
            b = aux;
        }

        int j = 0;
        for (int i = a; i <= numarElemente + 1; i++) {
            vector[j] = v[i];
            j++;
        }
        return v;
    }


    //todo:Se citește un vector cu n elemente, numere naturale.
    // Să se determine suma valorilor elementelor cuprinse între primul și ultimul element par al vectorului, inclusiv acestea.

    public static int sumaElemPare(int[] v) {
        int suma = 0;
        System.out.println("nr de elemente pare din vector: " + conorPare(v));
        for (int i = 0; i < v.length; i++) {
            if (i % 2 == 0) {
                suma = suma + v[i];
            }
        }
        System.out.println("suma de elemente pare este de :");
        return suma;
    }

//todo:Se dă un șir cu n elemente, numere reale.                                                                                        //nu e bine
// Să se determine câte dintre elemente se află în afara intervalului închis determinat de primul și ultimul element.

    public static int contorElemente(int[] v) {
        int ct = 0;
        int ct1 = 0;

        for (int i = 0; i < v.length; i++) {
            if (v[0] < i)
                ct++;
        }

        for (int j = v.length - 1; j >= 0; j--) {
            if (v.length - 1 > j)
                ct1++;
        }
        int aux = ct + ct1;
        return aux;
    }

    //todo:Se dă un vector cu n numere naturale.
    // Să se determine câte dintre elemente au valoarea strict mai mare decât media aritmetică a elementelor vectorului.
    public static int ex487(int[] v) {
        int ct = 0;
        int s = 0;
        for (int i = 0; i < v.length; i++) {
            s = s + v[i];
            ct++;
        }
        s = s / ct;
        int aux = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] > s)
                aux++;
        }
        return aux;
    }


    //todo:  Se consideră un șir a1, a2, …, an de numere naturale.
    // Să se afișeze elementele șirului de la dreapta la stânga.

    public static void exAfisare1(int[] v) {
        for (int i = v.length - 1; i >= 0; i--) {
            System.out.print(v[i] + " ");
        }
    }

    // todo:Să se calculeze suma valorilor pare din șir.
    public static int valoriPareEx2(int[] v) {
        int ct = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                ct = ct + v[i];
            }
        }
        return ct;
    }


    // todo: Să se determine numărul numerelor din șir care sunt divizibile cu 10.
    public static int divizibileCu10(int [] v){
        int ct=0;
        for(int i=0; i<v.length; i++){
            if (v[i] % 10 == 0) {
                ct++;
            }
        }
        return ct;
    }

    // todo: Să se determine suma numerelor divizibile cu 3 și aflate pe poziții impare                                         //nu e bine

    public static int divizibileCu3(int [] v){
        int ct=0;
        for(int i=0; i<v.length; i+=2){
            if (v[i] % 3 == 0) {
                ct = ct + v[i];
            }
        }
        return ct;
    }


    //todo:Se dă un vector x cu n elemente, numere naturale.
    // Să se construiască un alt vector, y, care să conțină elementele impare din x, îm ordine inversă.

//    public static void main(String[] a){
//        Vector<Integer> test= new Vector<>();
//
//
//    }


}
