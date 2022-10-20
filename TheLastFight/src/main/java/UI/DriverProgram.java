package UI;


/**
 *  Daniel Eduardo Dubon Ortiz 22233
 */

import java.util.ArrayList;
import java.util.Scanner;

import Model.*;
import Controller.Actions;

import static Controller.Actions.*;

public class DriverProgram {
    static boolean menu1 = true;
    static boolean menu2 = true;
    static boolean pokemonmuerto = false;
    static boolean menu3Juego = true;
    public static boolean invocacion = false;
    public static boolean lluviacuradora = false;
    public static boolean generarPokemon = false;
    public static boolean eliminarPokemon = false;
    public static boolean checkregeneration = false;
    public static boolean revivir = false;
    static int turno = 0;

    static int turnoglobal =1;

    static int tempdeadpokemon = 0;
    static public ArrayList<Player> players = new ArrayList();
    static public ArrayList<Enemy> enemys = new ArrayList();
    static public ArrayList<Boss> bosses = new ArrayList();



    public static void main(String[] args) {

    menu();
    }


    public static void menu() {

        Scanner in = new Scanner(System.in);
        int opcion;
        while (menu1) {
            menu3Juego = true;
            menu2 = true;
            enemys.clear();
            players.clear();
            bosses.clear();
            System.out.println("---Bienvenido a La ultima batalla---");
            System.out.println("1)Comenzar");
            System.out.println("2)Salir");
            System.out.print("Opcion: ");
            System.out.print("ingrese el numero de la opcion por favor: ");

            opcion = Integer.parseInt(in.nextLine());
            turnoglobal = 1;



            switch (opcion) {
                case 1:
                    while (menu2) {
                        System.out.println("¿Que tipo de personaje desea ser?");
                        System.out.println("1)Guerrero");
                        System.out.println("2)Explorador");
                        System.out.println("3)Cazador");
                        System.out.print("ingrese el numero de la opcion por favor: ");
                        opcion = in.nextInt();

                        if (opcion == 1) {
                            System.out.println("¿Cual es tu nombre?");
                            in.nextLine();
                            String name = in.nextLine();
                            int hp = 120;
                            int atk = 10;
                            int Nitems = 0;

                            ArrayList<String> items= new ArrayList<>();
                            items.add("Curar");

                            Warrior player = new Warrior(generarIDPlayer(players),name, hp, atk, Nitems,items);
                            players.add(player);

                        } else if (opcion == 2) {
                            System.out.println("¿Cual es tu nombre?");
                            in.nextLine();
                            String name = in.nextLine();
                            int hp = 90;
                            int atk = 7;
                            int Nitems = 0;
                            ArrayList<String> items= new ArrayList<>();
                            items.add("Curar");
                            items.add("Subir Ataque");
                            items.add("Revivir");
                            items.add("Lluvia Curadora");
                            Explorer player = new Explorer(generarIDPlayer(players),name, hp, atk, Nitems,items);
                            players.add(player);
                        }else if (opcion ==3){
                            System.out.println("¿Cual es tu nombre?");
                            in.nextLine();
                            String name = in.nextLine();
                            int hp = 200;
                            int atk = 5;
                            int Nitems = 0;
                            ArrayList<String> items= new ArrayList<>();
                            items.add("Lanzar mascota");
                            Hunter player = new Hunter(generarIDPlayer(players),name, hp, atk, Nitems,items,generatePet());
                            System.out.println(player.getPokemon());
                            players.add(player);
                        }

                        System.out.println("¿Desea agregar otro jugador?");
                        System.out.println("1) Si");
                        System.out.println("2) No");
                        opcion = in.nextInt();
                        in.nextLine();
                        if (opcion == 1) {
                            System.out.println("Agregando otro jugador....");
                        } else if (opcion == 2) {
                            menu2 = false;
                        }
                    }

                    System.out.println("inicia el juego.....");

                    spawnenemys(players);

                    System.out.println("La batalla a empezado");
                    System.out.println("Preparense: ");
                    for (Player player: players){
                        turno = turno +1;
                        System.out.println("Combatiente "+turno+" "+player.getName());
                    }
                    System.out.println("Lucharan contra");
                    turno = 0;
                    for (Enemy enemy: enemys){
                        turno = turno +1;
                        System.out.println("Enemigo "+turno+" "+enemy.getName()+" que dice: "+enemy.getMsg());
                    }

                    turno = 1;
                    int opcionatk =0;
                    int recuperacion = 0;
                    while (menu3Juego){
                        System.out.println("");
                        System.out.println("******************************************* Turno numero: "+turnoglobal+" *******************************************");
                        turno =1;
                        if (gameRunning(players,enemys)){
                     while (turno <= players.size()){
                         for (Player player: players) {

                             if (player.getId() == turno) {
                                 if (!(player.getHp()<=0)){
                                 gamestatus(players, enemys);
                                 System.out.println("Es el turno del combatiente: " + turno +" "+ player.getName());

                                 if (player.getName().equalsIgnoreCase("Cat")  ||player.getName().equalsIgnoreCase("Dog") ||player.getName().equalsIgnoreCase("Monkey")) {
                                    attack(turno,opcionatk,enemys,players);
                                 }else {

                                     System.out.println("¿Que desea realizar?");
                                     System.out.println("1)Atacar");
                                     System.out.println("2)Item");
                                     System.out.println("3)Pasar turno");
                                     opcion = in.nextInt();
                                     switch (opcion) {
                                         case 1:
                                             System.out.println("¿Que enemigo desea atacar?");
                                             for (Enemy enemy : enemys) {
                                                 System.out.println("Enemigo " + enemy.getId() + ") Nombre: " + enemy.getName());
                                             }
                                             opcionatk = in.nextInt();
                                             attack(turno, opcionatk, enemys, players);

                                             break;
                                         case 2:
                                             if (!(player.getItems().isEmpty())) {
                                                 System.out.println("¿Que item desea utilizar?");
                                                 int indice = 0;
                                                 if (player.getId() == turno) {
                                                     for (String items : player.getItems()) {
                                                         indice = indice + 1;
                                                         System.out.println(indice + ") " + items);
                                                     }
                                                     in.nextLine();
                                                     opcion = in.nextInt();
                                                     useitem(turno, opcion, enemys, players);

                                                 }
                                             } else {
                                                 System.out.println("No se tienen items para usar...");
                                                 turno = turno - 1;
                                             }
                                             break;
                                         case 3:

                                             System.out.println("No se realizo nada...");
                                             break;
                                     }
                                 }
                             }else{
                                     if (player instanceof Pokemon){
                                         pokemonmuerto = true;
                                     }else {
                                         pokemonmuerto = false;
                                     }


                                     System.out.println(player.getName()+" esta muerto...");
                                 }


                             }

                         }



                         if (pokemonmuerto){
                             for (Player player: players){
                                 for (Player player1: players) {
                                     if (player.getNitems() == player1.getId()){
                                         if (player1.getHp()<=0) {
                                             System.out.println("El pokemon " + player1.getName() + " del jugador " + player.getName() + " esta muerto ");
                                             tempdeadpokemon = player1.getId();
                                             eliminarPokemon = true;
                                             checkregeneration = true;
                                         }

                                     }
                                 }
                             }
                             pokemonmuerto = false;
                         }

                         if (eliminarPokemon){
                             players.remove(tempdeadpokemon-1);
                             tempdeadpokemon = 0;
                             eliminarPokemon = false;
                         }

                         if (checkregeneration){
                             recuperacion = recuperacion+1;

                             for (Player player: players){
                                 if (player.getNitems()!=0){

                                     if (recuperacion ==3){
                                         System.out.println("Alerta: Pokemon del Jugador"+player.getName()+" recuperado");
                                         player.setNitems(0);
                                         recuperacion = 1;
                                         checkregeneration = false;
                                     }
                                 }
                             }
                         }

                         if (generarPokemon){
                             Hunter l = (Hunter) players.get(turno-1);
                             System.out.println(l.getPokemon());
                             ArrayList<String> none = new ArrayList<>();
                             int idpokemon = generarIDPlayer(players);
                             players.get(turno-1).setNitems(idpokemon);
                             Pokemon pokemon = new Pokemon(idpokemon,l.getPokemon(),25,7,0,none,"none","Regenerar");

                             players.add(pokemon);
                             generarPokemon = false;
                         }

                            turno = turno+1;


                        }

                   turno = 1;
                    while (turno<=enemys.size()) {

                        int enemymovement = (int) (Math.random() * 4 + 1);
                        int bossmovement = (int) (Math.random() * 6 + 1);

                        for (Enemy enemy : enemys) {

                            if (enemy.getId() == turno){
                                if (!(enemy.getHp() <= 0) ){
                                if (enemy.getType().equals("Minion")){//ataque minions
                            if (enemymovement == 1 || enemymovement == 2 || enemymovement == 3) {
                                opcion = (int) (Math.random() * players.size() + 1);
                                enemyattack(turno, opcion, enemys, players);

                            } else if (enemymovement == 4) {
                                opcion = (int) (Math.random() * players.size() + 1);
                                enemyuseitem(turno, opcion, enemys, players);
                            }
                                }else if(enemy.getType().equals("Boss")) {//ataque jefes

                                    if (bossmovement == 1 || bossmovement == 2 || bossmovement == 3) {
                                        opcion = (int) (Math.random() * players.size() + 1);
                                        enemyattack(turno, opcion, enemys, players);

                                    } else if (bossmovement == 4 || bossmovement == 5 ) {
                                        opcion = (int) (Math.random() * players.size() + 1);
                                        enemyuseitem(turno, opcion, enemys, players);
                                    }else if(bossmovement == 6   ){
                                        bossfinal(turno, opcion,players,bosses);
                                    }
                                }else {}

                                }
                            }
                        }
                        if (invocacion){
                            invocar();
                            invocacion = false;
                        }

                        if (lluviacuradora){
                            System.out.println("curando.....");
                            lluviacuradora(players);
                            lluviacuradora = false;
                        }

                        if (revivir){
                            revivir(players);
                            revivir = false;
                        }


                            turno = turno + 1;


                    }
                    turno = 1;

                    }else {
                            checkwinner(players,enemys);
                            menu3Juego = false;
                        }
                        turnoglobal++;

                    }
                    in.nextLine();
                        break;
                        case 2:
                            System.out.println("                         ");
                            System.out.println("Adios hasta luego.......");
                            menu1 = false;
                            break;
                        default:
                            System.out.println("---Ingrese una opcion del menu por favor---");
                            break;

                    }

            }

    }
}