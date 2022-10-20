package Model;

import java.util.ArrayList;

public class Hunter extends Player{

    String pokemon;

    public Hunter(int id, String name, int hp, int atk, int Nitems, ArrayList<String> items, String pokemon){
        super(id, name, hp, atk,  Nitems, items);
        this.pokemon = pokemon;

    }

;


    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }
}
