package Controller;

import Model.*;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static UI.DriverProgram.*;

public class Actions {


    /**
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
        String type;
        if (players.size() <= 2) {
            Minion enemy;

            //switch para generar enemigos simples
            switch (randomvalue) {
                case 1:
                    name = "Esphantos";
                    msg = "No podras ganarme";
                    hp = 60;
                    atk = 10;
                    esp = "Regeneracion";
                    type = "Minion";
                    enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                    enemys.add(enemy);

                    name = "Hulises";
                    msg = "Eres muy lento";
                    hp = 40;
                    atk = 20;
                    esp = "AtaqueDoble";
                    type = "Minion";
                    enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                    enemys.add(enemy);

                    name = "Sussy";
                    msg = "No podras ganarme";
                    hp = 80;
                    atk = 5;
                    esp = "Regeneracion";
                    type = "Minion";
                    enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                    enemys.add(enemy);
                    break;
                case 2:
                    name = "Hulises";
                    msg = "Eres muy lento";
                    hp = 40;
                    atk = 40;
                    esp = "AtaqueDoble";
                    type = "Minion";
                    enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                    enemys.add(enemy);

                    name = "Ciclope";
                    msg = "Miren como mueren";
                    hp = 140;
                    atk = 10;
                    esp = "Regeneracion";
                    type = "Minion";
                    enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                    enemys.add(enemy);
                    break;
                case 3:
                    name = "Sussy";
                    msg = "No podras ganarme";
                    hp = 80;
                    atk = 15;
                    esp = "Regeneracion";
                    type = "Minion";
                    enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                    enemys.add(enemy);
                    break;
            }


        } else {
            int bossrandom = (int) (Math.random() * 3 + 1);
            switch (bossrandom) {

                case 1:
                    name = "Gorr";
                    msg = "Moriran......";
                    hp = 200;
                    atk = 30;
                    esp = "Regeneracion";
                    espF = "Necroespada";
                    type = "Boss";
                    Boss enemy = new Boss(generarIDEnemy(enemys), espF, name, msg, hp, atk, esp, type);
                    enemys.add(enemy);
                    bosses.add(enemy);
                    break;
                case 2:
                    name = "Hela";
                    msg = "No tienen oportunidad......";
                    hp = 150;
                    atk = 50;
                    esp = "Regeneracion";
                    espF = "Invocacion";
                    type = "Boss";
                    enemy = new Boss(generarIDEnemy(enemys), espF, name, msg, hp, atk, esp, type);
                    enemys.add(enemy);
                    bosses.add(enemy);
                    break;

                case 3:
                    name = "Enchantress";
                    msg = "Ya esta lista su tumba";
                    hp = 250;
                    atk = 35;
                    esp = "AtaqueDoble";
                    espF = "LLama eterna";
                    type = "Boss";
                    enemy = new Boss(generarIDEnemy(enemys), espF, name, msg, hp, atk, esp, type);
                    enemys.add(enemy);
                    bosses.add(enemy);
                    break;


            }
        }


    }

    /**
     * @param players
     * @param enemies
     */
    public static void gamestatus(ArrayList<Player> players, ArrayList<Enemy> enemies) {
        System.out.println(" ");
        System.out.println("-------------------------");
        for (Player player : players) {
            System.out.println("Combatiente " + player.getId() + " Nombre: " + player.getName() + " vida: " + player.getHp() + " Items: " + player.getNitems());
        }
        System.out.println(" ");
        System.out.println("  ++++++VS++++++  ");
        System.out.println(" ");
        for (Enemy enemy : enemies) {
            System.out.println("Enemigo " + enemy.getId() + " Nombre: " + enemy.getName() + " vida: " + enemy.getHp());
        }
        System.out.println("-------------------------");
        System.out.println(" ");

    }

    /**
     * @param players
     * @param enemies
     * @return
     */
    public static boolean gameRunning(ArrayList<Player> players, ArrayList<Enemy> enemies) {
        boolean ingame = true;
        int TOTALHPP = 1;
        int TOTALHPE = 1;

        for (Player player : players) {
            TOTALHPP = TOTALHPP + player.getHp();

        }

        for (Enemy enemy : enemies) {
            TOTALHPE = TOTALHPE + enemy.getHp();

        }
        if (TOTALHPP <= 1 || TOTALHPE <= 1) {
            ingame = false;
        }

        return ingame;
    }

    /**
     * @param players
     * @param enemies
     */
    public static void checkwinner(ArrayList<Player> players, ArrayList<Enemy> enemies) {
        int TOTALHPP = 0;
        int TOTALHPE = 0;

        for (Player player : players) {
            if (!(player.getHp() < 0)) {
                TOTALHPP = TOTALHPP + player.getHp();
            }
        }

        for (Enemy enemy : enemies) {
            if (!(enemy.getHp() < 0)) {
                TOTALHPE = TOTALHPE + enemy.getHp();
            }
        }
        if (TOTALHPP <= 0) {
            System.out.println("Perdiste, ganaron los enemigos");
        } else if (TOTALHPE <= 0) {
            System.out.println("Victoria, los enemigos fueron derrotados");
        }


    }

    /**
     * @param turno
     * @param idA
     * @param enemies
     * @param players
     */
    public static void attack(int turno, int idA, ArrayList<Enemy> enemies, ArrayList<Player> players) {

        for (Player player : players) {
            for (Enemy enemy : enemies) {
                if (player.getId() == turno) {
                    if (idA == enemy.getId()) {
                        if (!(enemy.getHp() <= 0)) {
                            String ataque = ("El jugador: " + player.getName() + " ataco a: " + enemy.getName() + " ->vida anterior: " + enemy.getHp() + " vida nueva: " + (enemy.getHp() - player.getAtk()));
                            System.out.println(ataque);
                            enemy.setHp(enemy.getHp() - player.getAtk());
                        } else {
                            String ataque = ("Este enemigo ya esta muerto tirado en el piso... no se logro atacar a nadie");
                            System.out.println(ataque);
                        }
                    }
                }

            }

        }

    }

    /**
     * @param turno
     * @param idA
     * @param enemies
     * @param players
     */
    public static void enemyattack(int turno, int idA, ArrayList<Enemy> enemies, ArrayList<Player> players) {
        for (Enemy enemy : enemies) {
            for (Player player : players) {
                if (enemy.getId() == turno) {
                    if (!(enemy.getHp() <= 0)) {
                        if (idA == player.getId()) {
                            if (!(player.getHp() <= 0)) {
                                String ataque = ("El Enemigo: " + enemy.getName() + " ataco a: " + player.getName() + " ->vida anterior: " + player.getHp() + " vida nueva: " + (player.getHp() - enemy.getAtk()));
                                System.out.println(ataque);
                                player.setHp(player.getHp() - enemy.getAtk());
                            } else {
                                String ataque = ("Se fallo el ataque porque ya esta muerto tirado en el piso... no se logro atacar a nadie");
                                System.out.println(ataque);
                            }
                        }
                    }


                }
            }

        }

    }

    /**
     * @param turno
     * @param opcion
     * @param enemies
     * @param players
     */
    public static void useitem(int turno, int opcion, ArrayList<Enemy> enemies, ArrayList<Player> players) {
        for (Player player : players) {

            if (player.getId() == turno) {
                System.out.println("Usaste el item: " + player.getItems().get(opcion - 1));

                if (player.getItems().get(opcion - 1).equals("Curar")) {
                    player.setHp(player.getHp() + 20);
                    System.out.println(player.getName() + " se curo 20HP");
                    ArrayList<String> actualizaciondeitems = (ArrayList<String>) player.getItems().clone();
                    actualizaciondeitems.remove(opcion - 1);
                    player.setItems(actualizaciondeitems);
                } else if (player.getItems().get(opcion - 1).equals("Subir Ataque")) {

                    System.out.println("El jugador: " + player.getName() + " elevo su poder con un hechizo: " + " poder antiguo: " + player.getAtk() + " poder nuevo: " + (player.getAtk() + 5));
                    player.setAtk(player.getAtk() + 5);

                    ArrayList<String> actualizaciondeitems = (ArrayList<String>) player.getItems().clone();
                    actualizaciondeitems.remove(opcion - 1);
                    player.setItems(actualizaciondeitems);
                } else if (player.getItems().get(opcion - 1).equals("Lluvia Curadora")) {

                    lluviacuradora = true;
                    ArrayList<String> actualizaciondeitems = (ArrayList<String>) player.getItems().clone();
                    actualizaciondeitems.remove(opcion - 1);
                    player.setItems(actualizaciondeitems);

                } else if (player.getItems().get(opcion - 1).equals("Revivir")) {
                    revivir = true;
                    ArrayList<String> actualizaciondeitems = (ArrayList<String>) player.getItems().clone();
                    actualizaciondeitems.remove(opcion - 1);
                    player.setItems(actualizaciondeitems);
                } else if (player.getItems().get(opcion-1).equals("Lanzar mascota")){
                    if (player.getNitems() == 0) {
                        player.setNitems(1);
                        generarPokemon = true;
                    }else {
                        System.out.println("Tu acompañante sigue en batalla o aun no se a regenerado...");
                    }


                }else{
                    System.out.println("Imposible de usar...");
                }

            }

        }


    }

    /**
     * @param turno
     * @param opcion
     * @param enemies
     * @param players
     */
    public static void enemyuseitem(int turno, int opcion, ArrayList<Enemy> enemies, ArrayList<Player> players) {
        for (Enemy enemy : enemies) {

            if (enemy.getId() == turno) {

                if (!(enemy.getHp() <= 0)) {
                    System.out.println("El Enemigo: " + enemy.getName() + " uso su habilidad especial: " + enemy.getEsp());
                    if (enemy.getEsp().equals("Regeneracion")) {
                        enemy.setHp(enemy.getHp() + 15);
                        System.out.println(enemy.getName() + " se curo 15HP");
                    } else if (enemy.getEsp().equals("AtaqueDoble")) {
                        for (Player player : players) {
                            if (player.getId() == opcion) {
                                if (!(player.getHp() <= 0)) {
                                    String ataque = ("El Enemigo: " + enemy.getName() + " ataco fuertemente a: " + player.getName() + " ->vida anterior: " + player.getHp() + " vida nueva: " + (player.getHp() - (enemy.getAtk() * 2)));
                                    System.out.println(ataque);
                                    player.setHp(player.getHp() - (enemy.getAtk() * 2));
                                    System.out.println("Golpe fuerte.....");
                                } else {
                                    System.out.println("Se fallo el ataque especial....");
                                }
                            }
                        }


                    } else {
                        System.out.println("EL enemigo no logro usar su ataque especial...");
                    }
                }

            }

        }


    }

    /**
     * @param turno
     * @param opcion
     * @param players
     * @param bosses
     */
    public static void bossfinal(int turno, int opcion, ArrayList<Player> players, ArrayList<Boss> bosses) {

        for (Boss boss : bosses) {
            if (boss.getId() == turno) {
                if (!(boss.getHp() <= 0)) {
                    System.out.println("El Jefe: " + boss.getName() + " uso su habilidad definitiva: " + boss.getFinalesp());

                    if (boss.getFinalesp().equals("Necroespada")) {
                        for (Player player : players) {
                            if (player.getId() == opcion) {
                                if (!(player.getHp() <= 0)) {
                                    String ataque = ("El Jefe: " + boss.getName() + " uso la necro espada contra: " + player.getName() + " ->vida anterior: " + player.getHp() + " vida nueva: " + 0);
                                    System.out.println(ataque);
                                    player.setHp(0);
                                    System.out.println("Muerte instantanea.....");
                                } else {
                                    System.out.println("Se fallo el uso de la necroespada...");
                                }
                            }
                        }
                    } else if (boss.getFinalesp().equals("Invocacion")) {

                        invocacion = true;

                    } else if (boss.getFinalesp().equals("LLama eterna")) {

                        System.out.println("Los combatientes se queman debido al hechizo de la llama eterna...");
                        for (Player player : players) {
                            int i = 0;
                            if (!(player.getHp() <= 0)) {
                                while (i <= 3) {
                                    player.setHp(player.getHp() - 15);
                                    System.out.println("El combatiente " + player.getName() + " se quema, vida: " + player.getHp());
                                    i = i + 1;
                                }
                            }
                        }

                    } else {
                        System.out.println("EL Jefe no logro usar su ataque definitivo...");
                    }
                }

            }

        }


    }


    public static void invocar() {
        System.out.println(" ");
        System.out.println("¡Nuevos enemigos entran al campo de batalla!");
        int randomvalue = (int) (Math.random() * 3 + 1);
        Minion enemy;
        String name;
        int hp;
        int atk;
        String msg;
        String esp;
        String espF;
        String type;
        //switch para generar enemigos simples;
        switch (randomvalue) {

            case 1:
                name = "Esqueleto";
                msg = "...";
                hp = 20;
                atk = 5;
                esp = "ninguna";
                type = "Minion";
                enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                enemys.add(enemy);

                name = "Esqueleto";
                msg = "...";
                hp = 20;
                atk = 5;
                esp = "ninguna";
                type = "Minion";
                enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                enemys.add(enemy);

                name = "Esqueleto";
                msg = "...";
                hp = 20;
                atk = 5;
                esp = "ninguna";
                type = "Minion";
                enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                enemys.add(enemy);
                break;
            case 2:
                name = "Garmr";
                msg = "Guau";
                hp = 100;
                atk = 30;
                esp = "AtaqueDoble";
                type = "Minion";
                enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                enemys.add(enemy);

                break;
            case 3:
                name = "Odin zombie";
                msg = "No podras ganarme";
                hp = 40;
                atk = 60;
                esp = "Regeneracion";
                type = "Minion";
                enemy = new Minion(generarIDEnemy(enemys), name, msg, hp, atk, esp, type);
                enemys.add(enemy);
                break;
        }

    }

    /**
     * @param players
     */
    public static void lluviacuradora(ArrayList<Player> players) {

        for (Player player : players) {
            int i = 0;
            if (!(player.getHp() <= 0)) {
                System.out.println("curando 3----");
                while (i <= 2) {
                    player.setHp(player.getHp() + 10);
                    System.out.println("El combatiente " + player.getName() + " se cura: vida: " + player.getHp());
                    i = i + 1;
                }
            }
        }
    }

    /**
     * @param players
     */
    public static void revivir(ArrayList<Player> players) {
        int i = 0;
        for (Player player : players) {
            if (player.getHp() <= 0) {
                if (!(i == 1)) {
                    System.out.println("Se revivio el jugador: " + player.getName());
                    player.setHp(80);
                    i = i + 1;

                }
            }
        }
    }

    /**
     * @param players
     * @return
     */

    public static int generarIDPlayer(ArrayList<Player> players) {
        int IDUSU = 1;

        for (Player player : players) {
            IDUSU = IDUSU + 1;
        }
        return IDUSU;
    }

    /**
     * @param enemies
     * @return
     */
    public static int generarIDEnemy(ArrayList<Enemy> enemies) {
        int IDUSU = 1;

        for (Enemy enemy : enemies) {
            IDUSU = IDUSU + 1;
        }
        return IDUSU;
    }

    public static String generatePet(){
        int randomvalue = (int) (Math.random() * 3 + 1);

        switch (randomvalue) {

            case 1:
                return "Monkey";

            case 2:
                return "Dog";

            case 3:
                return "Cat";
        }

        return "None";
    }
}
