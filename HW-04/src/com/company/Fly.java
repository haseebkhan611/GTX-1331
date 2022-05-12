package com.company;

public class Fly {
    private double mass;
    private double speed;
    public static final double default_mass=5.0;
    public static final double default_speed=10.0;

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass,default_speed);
    }

    public Fly() {
        this(default_mass,default_speed);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        String speed2Decimal=String.format("%.2f",this.speed);
        String mass2Decomal=String.format("%.2f",this.mass);
        if(this.mass==0){
            return "I’m dead, but I used to be a fly with a speed of "+speed2Decimal+".";
        }
        return "I’m a speedy fly with "+speed2Decimal+ " speed and "+mass2Decomal+ " mass.";
    }

    public void grow(double addedMass){
        while(addedMass>0){
            if(this.mass<=20){
                this.speed+=1;
                addedMass-=1;
            }else{
                this.speed-=0.5;
                addedMass-=1;
            }
            this.mass+=1;
        }
    }

    public boolean isDead(){
        if(this.mass==0){
            return true;
        }
        return false;
    }



}
