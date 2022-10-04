package Model;

import java.util.ArrayList;

public class Warrior extends Player{

    /**
     *
     * @param id
     * @param name
     * @param hp
     * @param atk
     * @param Nitems
     * @param items
     */
    public Warrior(int id, String name, int hp, int atk, int Nitems, ArrayList<String> items){
        super(id, name, hp, atk,  Nitems,items);


    }
}
