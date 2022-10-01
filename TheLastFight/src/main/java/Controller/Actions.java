package Controller;

import Model.Boss;
import Model.Enemy;
import Model.Minion;
import Model.Player;

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
            System.out.println("Combatiente "+player.getId()+" Nombre: "+player.getName()+" vida: "+ player.getHp()+" Items"+player.getNitems());
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
        int TOTALHPP=0;
        int TOTALHPE=0;

        for (Player player: players){
            TOTALHPP = TOTALHPP+player.getHp();
        }

        for (Enemy enemy: enemies){
            TOTALHPE = TOTALHPE+enemy.getHp();
        }
        if (TOTALHPP==0 || TOTALHPE==0){
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
            if (TOTALHPP== 0){
                System.out.println("Perdiste, ganaron los enemigos");
            }else if (TOTALHPE ==0){
                System.out.println("Victoria, los enemigos fueron derrotados");
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
