/*This is a gatcha wish system from the game GENSHIN IMPACT.
 * it emulates the exact odds you players winning a levent-exclusive 5 star with guranteed 5 star at 90 pulls.
 * if one were to looose the 50/50 it indicates the exact (event-exclusive guranteed) system on their next 5 star
 */

import java.util.Random;
import java.util.Scanner;
@SuppressWarnings("unused")



public class gacha_system {

    public static int balance = 32780; /*using balance as a gloal variable */
    public static int normal_char;
    public static int rare_char;
    public static int five_star_char = 0;
    public static int pityLow = 10;
    public static boolean  guranteed = false;

public static void pull(){


Random random = new Random();

        balance -= 1600;
       
        int pityHigh = 90;
        int randNum = random.nextInt(pityHigh - pityLow + 1 ) + pityLow;
        
        if (randNum == 90) {

            if(guranteed == true) { /*Checks if you're guranteed a  limited 5 star (if you lost the previous 50-50) */
                System.out.println("You got a LIMITED-TIME-EVENT 5 star character");
                //System.out.println(randNum);
                five_star_char++;
                pityLow = 0;
                guranteed = false;

            }
            else{

                randNum = random.nextInt(100) + 1; /*Incase you're not guranteed, you enter a 50/50 
                coin flip for the event exclusive character*/
            
                if(randNum <= 50) {
                    System.out.println("You got a LIMITED-TIME-EVENT 5-star character");
                    //System.out.println(randNum);
                    five_star_char++;
                    pityLow = 0;
                    guranteed = false;
    
                }
                else{
                    System.out.println("You got a Standard 5-star character");
                    guranteed = true; /*if you were to loose the 50-50 Your next 6 star will guranteed be the LIMITED TIME 5 star */
                    pityLow = 0;
                    
                }

            }

        }
        else if(randNum % 2 == 0) {
            System.out.println("You got a Rare character");
           // System.out.println(randNum);
            pityLow += 10;
        }
        else if(randNum % 2 == 1) {
            System.out.println("You got a Common character");
            //System.out.println(randNum);
            pityLow += 10;
        }
        
    }

    public static void main(String[] args) {

        int pulls = 0;
        int user_input;

        try (Scanner x = new Scanner(System.in)) {
            while(true) {
                System.out.println("Current balance: "+balance);
                System.out.println("Would you like to pull for 1600.\n1.TO PULL.\n2.TO EXIT. ");
                user_input = x.nextInt();

                if(user_input == 1) {

                    pull();
                    pulls++;

                }
                else if(user_input == 2) {
                    break;
                }

            }
        }

        System.out.println("NUmber of pulls made: "+pulls);


    }
}
