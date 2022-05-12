package com.company;

public class GamePlay {
    public static void main(String[] args) {
        BlueAstronaut bob=new BlueAstronaut("Bob",20,6,30);
        BlueAstronaut heath=new BlueAstronaut("Heath",30,3,21);
        BlueAstronaut albert=new BlueAstronaut("Albert",44,2,0);
        BlueAstronaut angel=new BlueAstronaut("Angel",0,1,0);

        RedAstronaut liam=new RedAstronaut("Liam",19,"experienced");
        RedAstronaut suspiciousPerson=new RedAstronaut("Suspicious Person",100,"expert");

        liam.sabotage(bob);
        liam.freeze(suspiciousPerson);
        liam.freeze(albert);
        albert.emergencyMeeting();
        suspiciousPerson.emergencyMeeting();
        bob.emergencyMeeting();
        heath.completeTask();
        heath.completeTask();
        heath.completeTask();
//        Heath when completes the next task nothing should happen. Bug in code.
//        System.out.println(heath.toString());
        liam.freeze(angel);
        liam.sabotage(bob);
        liam.sabotage(bob);
        liam.freeze(bob);
//        Bug in the code. The below code should end the game.
        angel.emergencyMeeting();
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.freeze(heath);



    }
}
