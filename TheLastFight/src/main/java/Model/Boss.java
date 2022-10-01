package Model;

public class Boss extends Enemy{

    private String finalesp;


    public Boss(int id,String finalesp,String name, String msg, int hp, int atk,String esp){
    super(id,name,msg,hp,atk,esp);
    this.finalesp = finalesp;
    }

}
