package com.company;

import java.util.Arrays;
import java.util.Locale;

public class RedAstronaut extends Player implements Impostor {
    /**
     * Constructor for Player Objects. Be sure to use this constructor, as it properly populates the players array.
     * The logic in this constructor ensures that players is always full, although frozen players will still be in it.
     * NOTE: Use getPlayers() each time you need it, since the reference will change with every new instance.
     *
     * @param name     Name of the player
     * @param susLevel Integer that represents the suspicion level, with higher being more suspicious.
     */
    private String skill;


    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name) {
        this(name, 15,"experienced");
    }

    @Override
    public void emergencyMeeting() {
        if(this.isFrozen()){
            return;
        }
        Arrays.sort(getPlayers());
        if(getPlayers()[0]==getPlayers()[1]){
            return;
        }else{
            getPlayers()[0].setFrozen(true);
        }
        gameOver();
    }

    @Override
    public void freeze(Player p) {
        Arrays.sort(getPlayers());
//        System.out.println("==========");
//        System.out.println(Arrays.toString(getPlayers()));
//        System.out.println("==========");
//        Checks if the passed in player is already frozed
        if(p.isFrozen()){
            return;
        }
//        The following condition checks if the passed player is also an imposter
        if(p.equals(getPlayers()[0])){
            return;
        }
//        Check if RedAstronaut’s susLevel is less than the Player’s
        if(this.getSusLevel()<p.getSusLevel()){
            p.setFrozen(true);
            return;
        }else if(this.getSusLevel()>p.getSusLevel()){
            this.setSusLevel(this.getSusLevel()*2);
        }
        gameOver();

    }

    @Override
    public void sabotage(Player p) {
        Arrays.sort(getPlayers());
//      Cannot sabotage another imposter
        if(p.equals(getPlayers()[0])){
            return;
        }
//        an Impostor that is frozen cannot sabotage OR sabotaging a frozen Player should do nothing
        if(this.isFrozen() | p.isFrozen()){
            return;
        }
        if(this.getSusLevel()<20){
            p.setSusLevel((int) (((p.getSusLevel())*0.5)+p.getSusLevel()));
        }else{
            p.setSusLevel((int) (((p.getSusLevel())*0.25)+p.getSusLevel()));
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        String dummyString=super.toString()+"I am an "+getSkill()+" player!";
        if (getSusLevel()>15){
            return dummyString.toUpperCase();
        }else{
            return dummyString;
        }
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
