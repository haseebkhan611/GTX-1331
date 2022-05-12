package com.company;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{
    /**
     * Constructor for Player Objects. Be sure to use this constructor, as it properly populates the players array.
     * The logic in this constructor ensures that players is always full, although frozen players will still be in it.
     * NOTE: Use getPlayers() each time you need it, since the reference will change with every new instance.
     *
     * @param name     Name of the player
     * @param susLevel Integer that represents the suspicion level, with higher being more suspicious.
     */

    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks,int taskSpeed) {
        super(name, susLevel);
        this.numTasks=numTasks;
        this.taskSpeed=taskSpeed;
    }
    public BlueAstronaut(String name){
        this(name,15,6,10);
    }



    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }



    @Override
    public void emergencyMeeting() {
        if(isFrozen()){
            return;
        }
        Arrays.sort(getPlayers());
        if(getSusLevel()==getPlayers()[0].getSusLevel()){
            return;
        }else{
            getPlayers()[0].setFrozen(true);
        }
        gameOver();

    }

    @Override
    public void completeTask() {
        if(isFrozen()){
            return;
        }
        if(getNumTasks()==0){
            return;
        }
        if(getTaskSpeed()>20){
            setNumTasks(getNumTasks()-2);
        }else{
            setNumTasks(getNumTasks()-1);
        }
        if(getNumTasks()<1){
            setNumTasks(0);
            System.out.println("I have completed all my tasks");
            setSusLevel((int) (((getSusLevel()-(getSusLevel())*0.5))));
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            return getName().equals(player.getName()) && isFrozen() == player.isFrozen()
                    && getSusLevel() == player.getSusLevel() && getNumTasks() == player.getNumTasks()
                    && getTaskSpeed()== player.getTaskSpeed();
        }
        return false;
    }

    @Override
    public String toString() {
        String dummyString=super.toString()+" I have "+getNumTasks()+" left over.";
        if(getSusLevel()>15){
            return dummyString.toUpperCase();
        }else{
            return dummyString;
        }
    }
}
