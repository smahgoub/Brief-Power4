package com.company;

import java.util.Scanner;

public class Main {

    public static void printArray(int[][] power4) {
        // Affiche la grille du puissance 4

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print( " | "+ power4[i][j]);
            }
            System.out.println(" | ");
        }
    }

    public static int changeRow(int[][] power4, int columns, int compteur) {
        // modifie la ligne en fonction de la colonne choisie par le joueur
        int rows = 5;
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
        return rows;
    }

    public static boolean winLine(int[][] power4, int columns,int player) {
        boolean winLine = false;

        // Contrôle combinaison gagnante colonne
        int lineCount= 0;
        for (int i = 0; i < 6 && lineCount < 4; i++) {
            if (power4[i][columns] == player) {
                lineCount++;
            }
        }
        // J'ai gagné si linecount est supérieur à 3
        winLine = (lineCount > 3);

        return winLine;
    }

    public static boolean winColumn(int[][] power4, int rows,int player) {
        boolean winColumn = false;

        // Contrôle combinaison gagnante ligne
        int columnCount = 0;
        for (int j = 0; j < 7 && columnCount < 4; j++) {
            if (power4[rows][j] == player) {
                columnCount++;
            }
        }
        // J'ai gagné si columncount est supérieur à 3
        winColumn = (columnCount > 3);

        return winColumn;
    }

    public static boolean winDiagAC(int[][] power4, int rows, int columns,int player) {
        boolean winDiagAC = false;

        // Contrôle combinaison gagnante diagonale NO-SE
        int diagCountAC = 1;

        while (power4[rows][columns] == player && rows > 1 && columns <5 && diagCountAC < 4) {
            diagCountAC++;
            rows--;
            columns++;
                   }

        while (power4[rows][columns] == player && rows < 4 && columns > 1 && diagCountAC < 4) {
            diagCountAC++;
            rows++;
            columns--;
                    }
        // J'ai gagné si diagAC est supérieur à 3
        winDiagAC = (diagCountAC > 3);

        return winDiagAC;
    }

    public static boolean winDiagBD(int[][] power4, int rows, int columns,int player) git add{
        boolean winDiagBD = false;

        // Contrôle combinaison gagnante diagonale SO-NE
        int diagCountBD = 1;

        while (power4[rows][columns] == player && rows > 0 && columns > 0 && diagCountBD < 4) {
            diagCountBD++;
            rows--;
            columns--;
        }
        while (power4[rows][columns] == player && rows < 6 && columns < 7 && diagCountBD < 4) {
            diagCountBD++;
            rows++;
            columns++;
        }
        // J'ai gagné si columnDiagBD est supérieur à 3
        winDiagBD = (diagCountBD > 3);

        return winDiagBD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Déclaration et affectation des joueurs
        System.out.println("Joueur 1 : quel est votre prénom ? : ");
        String player1 = sc.nextLine();

        System.out.println("Joueur 2 : quel est votre prénom ? : ");
        String player2 = sc.nextLine();

        // Déclaration du tableau
        int columns = 0;
        int rows = 0;
        int[][] power4 = new int[6][7];

        // Déclaration des variables - pour les contrôles
        int player=1;
        boolean winLine = winLine(power4, columns,player);
        boolean winColumn = winColumn(power4, rows,player);
        boolean winDiagAC = winDiagAC(power4, columns, rows,player);
        boolean winDiagBD = winDiagBD(power4, columns, rows,player);

        // Boucle de contrôle du jeu
        for (int compteur = 0; compteur < 42; ++compteur) {
            if ((winLine == false) && (winColumn == false) && (winDiagAC == false) && (winDiagBD==false)) {
                if  ((compteur % 2) == 0) { System.out.println("\n"+player1  + ", choississez une colonne (0 à 6) :  ");
                player=1;}
                else {System.out.println("\n"+player2  + ", choississez une colonne (0 à 6) :  ");
                player=2;}
                columns = sc.nextInt();
                rows = changeRow(power4, columns, compteur);
                printArray(power4);
                winLine = winLine(power4, columns,player);
                winColumn = winColumn(power4, rows,player);
                winDiagAC = winDiagAC(power4, rows, columns,player);
                winDiagBD = winDiagAC(power4, rows, columns,player);

            } else {
                System.out.println("-------------------------------");
                if  ((compteur % 2) == 0) { System.out.println("Bravo " + player2 + ", vous avez gagné !!! ");}
                else {System.out.println("Bravo " + player1 + ", vous avez gagné !!! ");}
                break;

            }
        }

    }
}



