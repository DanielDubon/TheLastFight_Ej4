package Model;

public class Enemy {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String msg;
    private int hp;
    private int atk;
    protected String esp;

    public Enemy(int id, String name, String msg, int hp, int atk, String esp) {
    this.id = id;
    this.name = name;
    this.msg = msg;
    this.hp = hp;
    this.atk = atk;
    this.esp = esp;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }



}
