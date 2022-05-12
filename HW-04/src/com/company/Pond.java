package com.company;

public class Pond {
    public static void main(String[] args) {
        Frog frogPeepo=new Frog("Peepo");
        Frog frogPepe = new Frog("Pepe",10,15);
        Frog frogPeepaw=new Frog("Peepaw",4.6,5);
        Frog frogLiking=new Frog("likingFrog",59,5);

        Fly fly1=new Fly(1,3);
        Fly fly2=new Fly(6);
        Fly flyLiking=new Fly();


//        frogPeepo.grow(5);
//        System.out.println(frogPeepo.toString());
        frogLiking.grow(8);
        System.out.println(frogLiking.toString());
//        frogPeepo.setSpecies("1331 Frogs");
//        System.out.println(frogPeepo.getSpecies());
//        System.out.println(frogLiking.getSpecies());
//        System.out.println(frogPeepo.toString());
//        frogPeepo.eat(fly2);
//        System.out.println(fly2.toString());
//        frogPeepo.grow(8);
//        frogPeepo.eat(fly2);
//        System.out.println(fly2.toString());
//        System.out.println(frogPeepo.toString());
//        System.out.println(frogLiking.toString());
//        frogPeepaw.grow(4);
//        System.out.println(frogPeepaw.toString());
//        System.out.println(frogPepe.toString());

    }
}
