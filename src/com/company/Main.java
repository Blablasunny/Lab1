package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double s1 = 0;
        double s2 = 0;
        double s3 = 0;
        Unicycle uni = new Unicycle(25);
        TwoWheeled two = new TwoWheeled(26);
        Tricycle tri = new Tricycle(24);
        Workshop.repair(uni);
        uni.buy();
        uni.assemble();
        uni.use();
        Workshop.repair(two);
        two.buy();
        two.assemble();
        two.use();
        Workshop.repair(tri);
        tri.buy();
        tri.assemble();
        tri.use();
	    ArrayList<Bike> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int k = (int) (Math.random() * 3);
            System.out.println(k);
            if (k ==  0){Unicycle u = new Unicycle(in.nextDouble()); list.add(u); s1 += u.dia; Workshop.repair(u);}
            if (k ==  1){TwoWheeled tw = new TwoWheeled(in.nextDouble()); list.add(tw); s2 += tw.dia;}
            if (k ==  2){Tricycle tr = new Tricycle(in.nextDouble()); list.add(tr); s3 += tr.dia;}
        }
        if (s1 >= s2 && s2 >= s3){System.out.println("одноколесный - двухколесный - трехколесный");}
        else if (s1 >= s3 && s3 >= s2){System.out.println("одноколесный - трехколесный - двухколесный");}
        else if (s2 >= s1 && s1 >= s3){System.out.println("двухколесный - одноколесный - трехколесный");}
        else if (s2 >= s3 && s3 >= s1){System.out.println("двухколесный - трехколесный - одноколесный");}
        else if (s3 >= s1 && s1 >= s2){System.out.println("трехколесный - одноколесный - двухколесный");}
        else if (s3 >= s2 && s2 >= s1){System.out.println("трехколесный - двухколесный - одноколесный");}
    }
}

abstract class Bike{
    double dia;
    public Bike(double dia){
        this.dia = dia;
    }
    void buy(){
        System.out.println("Покупка велосипеда");
    }
    abstract void use();
    abstract void assemble();
}

class Unicycle extends Bike{
    public Unicycle(double dia){
        super(dia);
    }
    void use(){
        System.out.println("Использование одноколесного велосипеда");
    }
    void assemble(){
        System.out.println("Сборка одноколесного велосипеда");
    }
}

class TwoWheeled extends Bike{
    public TwoWheeled(double dia){
        super(dia);
    }
    void use(){
        System.out.println("Использование двухколесного велосипеда");
    }
    void assemble(){
        System.out.println("Сборка двухколесного велосипеда");
    }
}

class Tricycle extends Bike{
    public Tricycle(double dia){
        super(dia);
    }
    void use(){
        System.out.println("Использование трехколесного велосипеда");
    }
    void assemble(){
        System.out.println("Сборка трехколесного велосипеда");
    }
}

class Workshop{
    static void repair(Unicycle b){
        System.out.println("Ремонт одноколесного велосипеда");
    }
    static void repair(TwoWheeled b){
        System.out.println("Ремонт двухколесного велосипеда");
    }
    static void repair(Tricycle b){
        System.out.println("Ремонт трехколесного велосипеда");
    }
}