package Model;

import java.util.ArrayList;

public class Pokemon extends Player {


    String esp;

    public Pokemon(int id, String name, int hp, int atk, int Nitems, ArrayList<String> items, String pokemon,String esp){
        super(id, name, hp, atk,  Nitems, items);


    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }
}