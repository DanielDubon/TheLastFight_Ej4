package Controller;

import Model.Boss;
import Model.Enemy;
import Model.Minion;
import Model.Player;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static UI.DriverProgram.enemys;

public class Actions {


    /**
     *
     * @param players
     */
    public static void spawnenemys(ArrayList players) {

        int randomvalue = (int) (Math.random() * 3 + 1);
        String name;
        int hp;
        int atk;
        String msg;
        String esp;
        String espF;
        if (players.size() <= 2) {
        Minion enemy;

            //switch para generar enemigos simples
            switch (randomvalue) {
                case 1:
                    name = "Esphantos";
                     msg = "No podras ganarme";
                     hp = 199;
                     atk = 29;
                     esp = "Regeneracion";
                     enemy = new Minion(generarIDEnemy(enemys),name, msg, hp, atk, esp);
                    enemys.add(enemy);

                    name = "Hulises";
                    msg = "Eres muy lento";
                    hp = 40;
                    atk = 40;
                    esp = "AtaqueDoble";
                    enemy = new Minion(generarIDEnemy(enemys),name, msg, hp, atk, esp);
                    enemys.add(enemy);

                    name = "Sussy";
                    msg = "No podras ganarme";
                    hp = 199;
                    atk = 29;
                    esp = "Regeneracion";
                    enemy = new Minion(generarIDEnemy(enemys),name, msg, hp, atk, esp);
                    enemys.add(enemy);
                    break;
                case 2:
                    name = "Hulises";
                    msg = "Eres muy lento";
                    hp = 40;
                    atk = 40;
                    esp = "AtaqueDoble";
                    enemy= new Minion(generarIDEnemy(enemys),name, msg, hp, atk, esp);
                    enemys.add(enemy);

                    name = "Sussy";
                    msg = "No podras ganarme";
                    hp = 199;
                    atk = 29;
                    esp = "Regeneracion";
                    enemy = new Minion(generarIDEnemy(enemys),name, msg, hp, atk, esp);
                    enemys.add(enemy);
                    break;
                case 3:
                    name = "Sussy";
                    msg = "No podras ganarme";
                    hp = 199;
                    atk = 29;
                    esp = "Regeneracion";
                    enemy = new Minion(generarIDEnemy(enemys),name, msg, hp, atk, esp);
                    enemys.add(enemy);
                    break;
            }


            }else{
            name = "Esphantos";
            msg = "No podras ganarme";
            hp = 199;
            atk = 29;
            esp = "Regeneracion";
            espF = "Ultimate";
            Boss enemy = new Boss(generarIDEnemy(enemys),espF,name, msg, hp, atk, esp);
            enemys.add(enemy);

        }


        }


        public static void gamestatus(ArrayList<Player> players, ArrayList<Enemy> enemies){
        System.out.println(" ");
        System.out.println("-------------------------");
        for (Player player: players){
            System.out.println("Combatiente "+player.getId()+" Nombre: "+player.getName()+" vida: "+ player.getHp()+" Items: "+player.getNitems());
        }
            System.out.println(" ");
        System.out.println("  ++++++VS++++++  ");
            System.out.println(" ");
        for (Enemy enemy: enemies){
            System.out.println("Enemigo "+enemy.getId()+" Nombre: "+enemy.getName()+" vida: "+ enemy.getHp());
        }
        System.out.println("-------------------------");
        System.out.println(" ");

        }


        public static boolean gameRunning(ArrayList<Player> players, ArrayList<Enemy> enemies){
        boolean ingame= true;
        int TOTALHPP=1;
        int TOTALHPE=1;

        for (Player player: players){
            TOTALHPP = TOTALHPP+player.getHp();

        }

        for (Enemy enemy: enemies) {
            TOTALHPE = TOTALHPE + enemy.getHp();

        }
            if (TOTALHPP<=0 || TOTALHPE<=0){
                ingame = false;
            }

        return ingame;
        }

        public static void checkwinner(ArrayList<Player> players, ArrayList<Enemy> enemies){
            int TOTALHPP=0;
            int TOTALHPE=0;

            for (Player player: players){
                TOTALHPP = TOTALHPP+player.getHp();
            }

            for (Enemy enemy: enemies){
                TOTALHPE = TOTALHPE+enemy.getHp();
            }
            if (TOTALHPP<= 0){
                System.out.println("Perdiste, ganaron los enemigos");
            }else if (TOTALHPE <=0){
                System.out.println("Victoria, los enemigos fueron derrotados");
            }


        }

        public static void attack(int turno,int idA, ArrayList<Enemy> enemies,ArrayList<Player> players){

        for (Player player: players){
            for (Enemy enemy: enemies){
                if (player.getId() == turno){
                    if (idA == enemy.getId()) {
                        if (!(enemy.getHp() <= 0)) {
                            String ataque = ("El jugador: " + player.getName() + " ataco a: " + enemy.getName() + " ->vida anterior: " + enemy.getHp() + " vida nueva: " + (enemy.getHp() - player.getAtk()));
                            System.out.println(ataque);
                            enemy.setHp(enemy.getHp() - player.getAtk());
                        }else{  String ataque =("Este enemigo ya esta muerto tirado en el piso... no se logro atacar a nadie"); System.out.println(ataque);}
                    }
                }

            }

        }

        }

    public static void enemyattack(int turno,int idA, ArrayList<Enemy> enemies,ArrayList<Player> players){
        for (Enemy enemy: enemies){
            for (Player player: players){
                if (enemy.getId() == turno){
                    if (idA == player.getId()) {
                        if (!(player.getHp() <= 0)) {
                            String ataque = ("El Enemigo: " + enemy.getName() + " ataco a: " + player.getName() + " ->vida anterior: " + player.getHp() + " vida nueva: " + (player.getHp() - enemy.getAtk()));
                            System.out.println(ataque);
                            player.setHp(player.getHp() - enemy.getAtk());
                        }else{  String ataque =("Se fallo el ataque porque ya esta muerto tirado en el piso... no se logro atacar a nadie"); System.out.println(ataque);}
                    }
                }

            }

        }

    }


        public  static void useitem(int turno, int opcion, ArrayList<Enemy> enemies,ArrayList<Player> players){
            for (Player player: players){

                    if (player.getId() == turno){
                        System.out.println("Usaste el item: "+player.getItems().get(opcion-1));

                        if (player.getItems().get(opcion-1).equals("Curar")){
                            player.setHp(player.getHp()+20);
                            System.out.println(player.getName()+" se curo 20HP");
                            ArrayList<String> actualizaciondeitems = (ArrayList<String>) player.getItems().clone();
                            actualizaciondeitems.remove(opcion-1);
                                    player.setItems(actualizaciondeitems);
                        }else if(player.getItems().get(opcion-1).equals("Subir ataque")){

                        }else{
                            System.out.println("Imposible de usar...");
                        }

                    }

            }


        }


    public  static void enemyuseitem(int turno, int opcion, ArrayList<Enemy> enemies,ArrayList<Player> players){
        for (Enemy enemy: enemies){

            if (enemy.getId() == turno){
                System.out.println("Uso el ataque especial: "+enemy.getEsp());

                if ( enemy.getEsp().equals("Regeneracion")){
                    enemy.setHp(enemy.getHp()+15);
                    System.out.println(enemy.getName()+" se curo 15HP");
                }else if(enemy.getEsp().equals("AtaqueDoble")){
                    for (Player player: players){
                        if (player.getId() == opcion){
                            String ataque = ("El Enemigo: " + enemy.getName() + " ataco a: " + player.getName() + " ->vida anterior: " + player.getHp() + " vida nueva: " + (player.getHp() - (enemy.getAtk()*2)));
                            System.out.println(ataque);
                            player.setHp(player.getHp() - (enemy.getAtk()*2));
                            System.out.println("Golpe fuerte.....");
                        }
                    }



                }else{
                    System.out.println("EL enemigo no logro usar su ataque especial...");
                }

            }

        }


    }


    public static int generarIDPlayer(ArrayList<Player> players) {
        int IDUSU = 1;

        for (Player player: players){
            IDUSU = IDUSU +1;
        }
        return IDUSU;
    }

    public static int generarIDEnemy(ArrayList<Enemy> enemies) {
        int IDUSU = 1;

        for (Enemy enemy: enemies){
            IDUSU = IDUSU +1;
        }
        return IDUSU;
    }
}
