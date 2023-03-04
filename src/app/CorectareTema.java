package app;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.Vector;
import java.util.ListIterator;
import java.util.Iterator;
import java.io.*;

public class CorectareTema {


    //todo:Se dă un vector x cu n elemente, numere naturale.
    // Să se construiască un alt vector, y, care să conțină elementele impare din x, îm ordine inversă.


    //todo:functie ce primeste ca parametru un vector si returneaza numarul de valori impare din vector
    public static int contorNrImpare(int[] v) {
        int ct = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 1) {
                ct++;
            }
        }
        return ct;
    }


    public static int[] numereImpare(int[] v) {


        int[] impare = new int[contorNrImpare(v)];

        int p = 0;

        for (int i = v.length - 1; i >= 0; i--) {

            if (v[i] % 2 != 0) {
                impare[p] = v[i];
                p++;
            }
        }
        return impare;
    }

    public static void solVector1() {
        int[] v = {1, 2, 3, 4, 5};

        System.out.println("Pentru vectorul");

        Functii.afisare(v);

        int[] sol = numereImpare(v);

        System.out.println("\nNumerele impare sunt");

        Functii.afisare(sol);

    }

//todo:Se dă un vector x cu n elemente, numere naturale.
// Să se construiască un alt vector, y, cu proprietatea că y[i] este egal cu restul împărțirii lui x[i] la suma cifrelor lui x[i].


    //todo:functie ce face suma cifrelor unui numar
    public static int sumaCifreNumar(int n) {
        int s = 0;
        while (n != 0) {
            s = s + n % 10;
            n = n / 10;
        }
        return s;
    }

    public static int[] elemnenteSuma(int[] x) {

        int[] y = new int[x.length];


        for (int i = 0; i < x.length; i++) {

            y[i] = x[i] % sumaCifreNumar(x[i]);
        }

        return y;

    }

    //todo:Să se determine diferența maximă de forma a[i] - a[j], unde 1 ≤ i < j ≤ n.
    // 3 5 2 7 6 3 9 8

    // Diferența maximă 4 se obține din a[4]-a[6]=7-3=4.

    //parc de 2 ori cu i++ si j-- dupa fac dif ??
    public static int diferentaMaxima(int[] v) {

        int difMax = 0;
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if ((v[i] - v[j]) > difMax) {
                    difMax = v[i] - v[j];
                }
            }
        }

        return difMax;
    }


    //todo functie ce verifica daca un numar este prim

    public static boolean verificareNrPrim(int n) {

        if (n == 0 || n == 1) {

            return false;
        }

        for (int i = 2; i < n; i++) {

            if (n % i == 0) {

                return false;
            }
        }
        return true;
    }


    //todo:cate nr prime avem in vector?
    public static int nrPrime(int[] v) {
        int ct = 0;
        for (int i = 0; i < v.length; i++) {
            if (verificareNrPrim(v[i])) {

                ct++;

            }
        }
        return ct;
    }


    // todo:cea mai mare cifra din numar

    public static int ceaMaiMareCifraDinNumar(int n) {
        int max = 0;
        while (n != 0) {
            if (n % 10 > max) {
                max = n % 10;
            }
            n = n / 10;
        }
        return max;
    }

    //todo:cea mai mare cifra din vector
    public static int cifraMareVector(int[] v) {
        int max = 0;
        for (int i = 0; i < v.length; i++) {
            int cifraMax = ceaMaiMareCifraDinNumar(v[i]);
            if (cifraMax > max) {
                max = cifraMax;
            }
        }
        return max;
    }

    public static int ceaMaiMicaCifraDinNumar(int n) {
        int min = 10;
        while (n != 0) {
            if (n % 10 < min) {
                min = n % 10;
            }
            n = n / 10;
        }

        return min;
    }

    ////todo:cea mai mica cifra din vector
    public static int cifraMicaVector(int[] v) {
        int min = 10;
        for (int i = 0; i < v.length; i++) {
            int cifraMin = ceaMaiMicaCifraDinNumar(v[i]);
            if (cifraMin < min) {
                min = cifraMin;
            }
        }
        return min;
    }


    //todo: care este cea mai mica, respectiv cea mai mare cifra

    public static void solutieVec() {
        int[] v = {21, 35, 295, 7, 8};
        System.out.println("Pentru vectorul: ");
        Functii.afisare(v);
        System.out.println("\nCea mai mica cifra din vector este: ");
        int sol = cifraMicaVector(v);
        System.out.println(sol);
        System.out.println("Cea mai mare cifra din vector este ");
        int sol1 = cifraMareVector(v);
        System.out.println(sol1);
    }


    //todo: schimbarea cifrelor in numar

    public static int schCifre(int n) {
        int invers = 0;
        while (n > 0) {
            invers = invers * 10 + n % 10;
            n = n / 10;
        }
        return invers;
    }

    //todo:verifica daca prima cifra= cu ultima cifra
    public static boolean primaCifraIdenticaCuUltima(int n) {
        int aux1 = 0;
        int aux2 = 0;
        aux2 = n % 10;
        while (n > 9) {
            n = n / 10;
        }
        aux1 = n;

        return aux1 == aux2;
    }

    //todo: cate elemente are vectorul nou

    public static int contorNumere(int[] v) {
        int ct = 0;
        for (int i = 0; i < v.length; i++) {
            if (primaCifraIdenticaCuUltima(v[i])) {
                ct++;
            }
        }

        return ct;
    }

//todo: afisati rasturnatul numerelor cu proprietatea ca prima cifra=ultima cifra

    public static int[] vectorRasturnat(int[] v) {

        int p = 0;
        int[] vectorRast = new int[contorNumere(v)];
        for (int i = 0; i < v.length; i++) {
            if (primaCifraIdenticaCuUltima(v[i])) {
                v[i] = schCifre(v[i]);
                vectorRast[p] = v[i];
                p++;
            }
        }

        return vectorRast;
    }

    //todo: numar cu propr ca are k div propr, k dat de la tastatura
    public static boolean areKdivizori(int n, int k) {
        int ct = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                ct++;
            }
        }

        return ct == k;
    }

    //todo: contor cate numere o sa fie in noul vector cu propr de k elem

    public static int contorDivizoriK(int[] v, int k) {
        int ct = 0;
        for (int i = 0; i < v.length; i++) {
            if (areKdivizori((v[i]), k)) {
                ct++;
            }
        }
        return ct;
    }

    //todo:au toate numerele din vector proprietatea ca au exact k divizori proprii. k citit de la tasstatura

    public static boolean vectorKdivizori(int[] v, int k) {

        for (int i = 0; i < v.length; i++) {
            if (areKdivizori(v[i], k) == false) {
                return false;
            }
        }
        return true;
    }


    //todo:produsul numerelor ce au ac paritate cu pozitia pe care stau
    public static int produsulCifrelorParitate(int[] v) {
        int prod = 1;
        for (int i = 0; i < v.length; i++) {
            if (i % 2 == v[i] % 2) {
                prod *= v[i];
            }
        }
        return prod;
    }

    //todo:Afisati produsul cifrelor la fiecare element al vectorului ce are cifra de control de numar par

    public static int prodContor(int[] v) {
        int aux = 1;
        for (int i = 0; i < v.length; i += 2) {
            aux *= v[i];
        }

        return aux;
    }


    //todo:Aflati cifra minima.Afisati numerele care au in componenta aceasta cifra

    public static int minNumar( int numar) {
        int min = 0;
        min = numar % 10;
        while (numar != 0) {
            if (numar % 10 < min) min = numar % 10;
            numar = numar / 10;

        }
        return min;
    }


    public static void afisareNrMin(int [] v){
    for(int i=0; i<v.length; i++){
        int num=v[i];
        while(num>0) {
        int aux=num%10;
        if(aux==minNumar(num)){
            System.out.println(v[i]);
            break;
        }
            num /= 10;
        }
        }
    }


//todo:afisati in ordine inversa palindroamele ce au cifrele din mijl patrat perfect

//public static int nrPalindrom(int numar){
//        int aux=0;
//        while(numar>10){
//            numar/=10;
//            aux++;
//        }
//        //1991
//        for(int i=0; i<aux; i++){
//
//
//}



//todo:cate numere prime intre ele avem cu pozitia pe care stau in vector

public static int cNrPrime(int[] v) {
    int aux = 0;
    for (int i = 0; i < v.length; i++) {
        if (v[i]/v[i]==1) {
            aux++;
        }
    }
    return aux;
}

    public static boolean estePrim(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void solutie() {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int aux = cNrPrime(v);
        System.out.println("Numarul de numere prime cu aceeasi pozitie: " + aux);
    }


    //todo:sa se verifice daca cifrele din vector sunt consecutive de la st la dr
    public static boolean areCifreConsecutive(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int n = v[i];
            int aux = n % 10;
            n /= 10;
            while (n > 0) {
                int cifra = n % 10;
                if (cifra + 1 != aux) {
                    return false;
                }
                aux = cifra;
                n /= 10;
            }
        }
        return true;
    }


}


