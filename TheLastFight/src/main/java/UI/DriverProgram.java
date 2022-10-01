package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Model.*;
import Controller.Actions;

import static Controller.Actions.*;

public class DriverProgram {
    static boolean menu1 = true;
    static boolean menu2 = true;
    static boolean menu3Juego = true;

    static int turno = 0;

    static public ArrayList<Player> players = new ArrayList();
    static public ArrayList<Enemy> enemys = new ArrayList();

    public static void main(String[] args) {

    menu();
    }

    public static void menu() {

        Scanner in = new Scanner(System.in);
        int opcion;
        while (menu1) {
            System.out.println("---Bienvenido a La ultima batalla---");
            System.out.println("1)Iniciar");
            System.out.println("2)Salir");
            System.out.print("Opcion: ");
            opcion = in.nextInt();


            switch (opcion) {
                case 1:
                    while (menu2) {
                        System.out.println("¿Que tipo de personaje desea ser?");
                        System.out.println("1)Guerrero");
                        System.out.println("1)Explorador");
                        opcion = in.nextInt();

                        if (opcion == 1) {
                            System.out.println("¿Cual es su nombre?");
                            in.nextLine();
                            String name = in.nextLine();
                            int hp = 100;
                            int atk = 10;
                            int Nitems = 2;
                            Warrior player = new Warrior(generarIDPlayer(players),name, hp, atk, Nitems);
                            players.add(player);

                        } else if (opcion == 2) {
                            System.out.println("¿Cual es su nombre?");
                            in.nextLine();
                            String name = in.nextLine();
                            int hp = 60;
                            int atk = 5;
                            int Nitems = 10;
                            Explorer player = new Explorer(generarIDPlayer(players),name, hp, atk, Nitems);
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
                    final int turns = players.size()+enemys.size();
                    System.out.println("La batalla a empezado");
                    System.out.println("Preparense: ");
                    for (Player player: players){
                        turno = turno +1;
                        System.out.println("Combatiente "+turno+" "+player.getName()+" ID DE JUGADORES: "+player.getId());
                    }
                    System.out.println("Lucharan contra");
                    turno = 0;
                    for (Enemy enemy: enemys){
                        turno = turno +1;
                        System.out.println("Enemigo "+turno+" "+enemy.getName()+" dice: "+enemy.getMsg());
                    }

                    turno = 1;
                    while (menu3Juego){
                        gamestatus(players,enemys);
                        if (gameRunning(players,enemys)){
                        if (turno <= players.size()) {
                            System.out.println("Es el turno del combatiente: "+turno);

                            System.out.println("¿Que desea realizar?");
                            System.out.println("1)Atacar");
                            System.out.println("2)Item");
                            System.out.println("3)Pasar turno");
                            opcion = in.nextInt();
                            switch (opcion) {
                                case 1:
                                    System.out.println("¿Que enemigo desea atacar?");

                                    break;

                            }
                        }

                    }else {
                            checkwinner(players,enemys);
                        }
                    }
                        break;
                        case 2:
                            System.out.println("                         ");
                            System.out.println("Adios cobarde.......");
                            menu1 = false;
                            break;
                        default:
                            System.out.println("---Ingrese una opcion del menu por favor---");
                            break;

                    }

            }

    }
}