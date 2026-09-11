import java.util.Scanner;
import java.util.Random;

class Game{
    String play(String p,String c){
        if (p.equals(c)){
            return "Draw";
        }
        else if ((p.equals("Rock") && c.equals("Scissors")) ||
            (p.equals("Paper") && c.equals("Rock")) ||
            (p.equals("Scissors") && c.equals("Paper"))){
                 return "Win";
            }

        else{
             return "Loss";
        }
       
    }

    void playGame(){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] p = new String[5];
        String[] c  = new String[5];
        String[] result = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

         for (int i = 0; i < 5; i++) {

            System.out.print("Round " + (i + 1)
                    + " - Enter Rock, Paper or Scissors: ");

            p[i] = sc.next();

          
            c[i] = moves[random.nextInt(3)];

            
            result[i] = play(p[i], c[i]);

            System.out.println("Computer: " + c[i]);
            System.out.println("Result: " + result[i]);
            System.out.println();

             if (result[i].equals("Win"))
                wins++;
            else if (result[i].equals("Loss"))
                losses++;
            else
                draws++;

         }
        System.out.println("\n--------------- SCOREBOARD ---------------");
        System.out.println("Round\tPlayer\t\tComputer\tResult");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "\t"
                    + p[i] + "\t\t"
                    + c[i] + "\t\t"
                    + result[i]);
        }
        
        double winPercentage = (wins / 5.0) * 100;

        System.out.println("------------------------------------------");
        System.out.println("Wins          : " + wins);
        System.out.println("Losses        : " + losses);
        System.out.println("Draws         : " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

         sc.close();



    }
   
}
public class ppo1{
    public static void main(String[] args) {
        Game G = new Game();
        G.playGame();
    } 

}