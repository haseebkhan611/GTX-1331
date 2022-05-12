package com.company;

public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    //    static String species;
    private static String species = "Rare Pepe";
    public static final int default_age = 5;
    public static final double default_tongueSpeed = 5.0;

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        if(this.age>1 && this.age<7){
            this.isFroglet=true;
        }else{this.isFroglet=false;};
//        this.species="Rare Pepe";
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name,(int) ageInYears*12,tongueSpeed);
    }

    public Frog(String name) {
        this(name,default_age,default_tongueSpeed);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        Frog.species = species;
    }

    public void grow(int growByMonths){
        while(growByMonths>0){
            if(this.age<12&& this.tongueSpeed>=5){
                this.tongueSpeed+=1;
            }
            else if(this.age>=30 && this.tongueSpeed>5){
                this.tongueSpeed-=1;
            }

            this.age+=1;
            growByMonths-=1;
        }
        if(this.age>1 && this.age<7){
            this.isFroglet=true;
        }
    }

    public void grow(){
        this.age+=1;
    }

    public void eat(Fly fly){
        if(!(fly.isDead())){
            if(this.tongueSpeed > fly.getSpeed()){
                if(fly.getMass()>=(0.5*this.age)){
                    this.grow();
                    fly.setMass(0);
                }
            }else{
                fly.grow(1);
            }
        }
    }

    @Override
    public String toString() {
        String tongue2Decimal=String.format("%.2f",this.tongueSpeed);
        if(this.isFroglet){
            return "My name is "+this.name+" and I’m a rare froglet! I’m " + this.age+" months old and my tongue has a speed of "+tongue2Decimal+".";
        }
        return "My name is "+this.name+" and I’m a rare frog. I’m " + this.age+" months old and my tongue has a speed of "+tongue2Decimal+".";
    }
}
