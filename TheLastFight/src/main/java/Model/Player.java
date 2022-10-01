package Model;

public class Player {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private int hp;
    private int atk;
    protected int Nitems;


    public Player(int id,String name, int hp,int atk, int Nitems){
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.Nitems = Nitems;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getNitems() {
        return Nitems;
    }

    public void setNitems(int nitems) {
        Nitems = nitems;
    }
}
