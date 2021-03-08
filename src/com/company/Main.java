package com.company;

import java.util.Scanner;

public class Main {

    public static void printArray(int[][] power4) {
        // Affiche la grille du puissance 4

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(power4[i][j]);
            }
            System.out.println();
        }
    }

    public static void namePlayer(Scanner sc, String player1, String player2) {
        // Déclaration des joueurs
        System.out.println("Joueur 1 : quel est votre prénom ? : ");
        player1 = sc.nextLine();

        System.out.println("Joueur 2 : quel est votre prénom ? : ");
        player2 = sc.nextLine();

    }

    public static void changeRow(int[][] power4, int columns, int compteur, int rows) {
        // modifie la ligne en fonction de la colonne choisie par le joueur
        for (int i = 5; i >= 0; --i) {
            if (power4[i][columns] == 0) {
                rows = i;
                if ((compteur % 2) == 0) {
                    rows = i;
                    power4[i][columns] = 1;
                } else {
                    power4[i][columns] = 2;
                }
                break;
            }
        }
    }

    public static void winPower4(int[][] power4, int columns, int rows, String player1, String player2) {
        // Contrôle combinaison gagnante colonne
        for (int i = 0; i < 4; i++) {
            if (power4[i][columns] == 1) {
                System.out.println(player1 + " vous avez gagné !!! ");
            }
        // if else?
        }
        // Contrôle combinaison gagnante ligne
        for (int j = 0; j < 4; j++) {
            if (power4[rows][j] == 1) {
                System.out.println(player1 + " vous avez gagné !!! ");
            }
            break;
        }
    }
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            String player1 = "";
            String player2 = "";

            //Déclaration de joueurs
            //namePlayer(sc, player1, player2);

            // Déclaration des jetons
            int red = 1;
            int yellow = 2;
            int empty = 0;

            // Déclaration du tableau
            int columns = 0;
            int rows = 0;
            int[][] power4 = new int[6][7];

            // Boucle remplissage power4
            for (int compteur = 0; compteur < 42; ++compteur) {
                System.out.println("player, choississez une colonne (0 à 6) :  ");
                columns = sc.nextInt();
                changeRow(power4, columns, compteur, rows);
                printArray(power4);
                winPower4(power4, columns, rows, player1, player2);

            }

        }
    }



