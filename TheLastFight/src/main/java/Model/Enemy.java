package Model;

public class Enemy {
    private int id;
    private String name;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
    public Enemy(int id, String name, String msg, int hp, int atk, String esp,String type) {
    this.id = id;
    this.name = name;
    this.msg = msg;
    this.hp = hp;
    this.atk = atk;
    this.esp = esp;
    this.type = type;


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
