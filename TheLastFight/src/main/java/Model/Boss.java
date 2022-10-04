package Model;

public class Boss extends Enemy {

    private String finalesp;

    public String getFinalesp() {
        return finalesp;
    }

    public void setFinalesp(String finalesp) {
        this.finalesp = finalesp;
    }


    /**
     *
     * @param id
     * @param finalesp
     * @param name
     * @param msg
     * @param hp
     * @param atk
     * @param esp
     * @param type
     */
    public Boss(int id, String finalesp, String name, String msg, int hp, int atk, String esp, String type){
    super(id,name,msg,hp,atk,esp,type);
    this.finalesp = finalesp;


    }

}
