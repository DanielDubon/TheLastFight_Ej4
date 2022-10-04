package Model;

public class Minion extends Enemy{


    /**
     *
     * @param id
     * @param name
     * @param msg
     * @param hp
     * @param atk
     * @param esp
     * @param type
     */
    public Minion(int id,String name, String msg, int hp, int atk, String esp,String type){

        super(id, name,  msg,  hp,  atk,  esp,type);

    }
}
