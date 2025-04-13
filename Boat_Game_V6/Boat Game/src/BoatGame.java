import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.InvalidObjectException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class BoatGame {

    public int roll() {
        Random r = new Random();
        int dice = (int) (Math.random() * 6 + 1);
        return dice;
    }


    public static void main(String[] args) throws IOException {
        int turnA = 0, turnB = 0;
        int y1 = 0, y2 = 0;
        Scanner input = new Scanner(System.in);
        String nameA;
        String nameB;
        String score;
        BoatGame Boat = new BoatGame();
        boolean playerAWon = false;
        boolean playerBWon = false;
        Score leaderboard = new Score();
        int count = 0;
        File path = new File("C:\\Users\\Abdoulahi Said Omar\\Downloads\\Boat_Game_V6\\score\\score.txt");

        //score saver


        



        //Setting up the River with Player, Traps, Currents, and Rocket
        River river =  new River();
        //Creating Player objects
        Player A = new Player("A");
        A.setPosition(1, y1);
        Player B = new Player("B");
        B.setPosition(2,y2);


/*
        //Creating Player's info

        System.out.println("Enter Player A Name: ");
        nameA = input.nextLine();

        score = nameA + turnA;
        leaderboard.setScore(score);


        System.out.println("Enter Player B Name: ");
        nameB = input.nextLine();
        score = nameB + turnB;
        leaderboard.setScore(score);

        */

/*
        int size = leaderboard.getLength();

        for (int i = 0; i < size; i++){
            String emp = "";
            String num = "";
            String nam = "";
            emp = leaderboard.element(i);
            nam = emp.replaceAll("[0-9]", "");
            leaderboard.setScore(nam);
            System.out.println(nam);
            num = emp.replaceAll("[^0-9]", "");
            leaderboard.setScore(num);
            System.out.println(num);
            }
        System.out.println(leaderboard.getScore());
        }
*/


        //Creating Trap objects
        river.trap1();
        river.trap2();
        //Creating Current objects
        river.current1();
        river.current2();
        //Creating Rocket object
        river.rock1();
        river.rock2();
        river.addPlayersToRiver(A);
        river.addPlayersToRiver(B);
        System.out.println(river);



        while (playerAWon == false || playerBWon == false){
        	count = count + 1;
            int temp = Boat.roll();
            System.out.print("Player A press any key to roll the dice");
            input.nextLine();
            turnA += 1;
            System.out.println("A rolled: " + temp);
            y1 = river.clash(A.getRow(), A.getCol(), temp,B.getCol());
            river.clearPreviousPosition(A.getRow(), A.getCol());
            if(y1 >= 100)
            {
                playerAWon = true;
                A.setPosition(1, 100);
                break;
            }
            else
            {
                A.setPosition(1, y1);
                river.addPlayersToRiver(A);
                river.addPlayersToRiver(B);
                System.out.println(river);
            }
            

            System.out.print("Player B press any key to roll the dice");
            input.nextLine();
            turnB += 1;
            temp = Boat.roll();
            System.out.println("B rolled: " + temp);
            y2 = river.clash(B.getRow(), B.getCol(), temp,A.getCol());;
            river.clearPreviousPosition(B.getRow(), B.getCol());
            if(y2 >= 100)
            {
                playerBWon = true;
                A.setPosition(1, 100);
                break;
            }
            else
            {
                B.setPosition(2, y2);
                river.addPlayersToRiver(A);
                river.addPlayersToRiver(B);
                System.out.println(river);
            }
            
        }

        if (playerAWon) {
        	FileWriter wr = new FileWriter(path);
            System.out.println("Player A Won!");
            wr.write("A," + count);
            wr.close();
        }
        else
        if (playerBWon) {
            System.out.println("Player B Won!");
        }

        System.out.println("it took " + count + "number of tries.");
    }

}



