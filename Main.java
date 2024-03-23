/**
 * Marvel Cinematic Universe (MCU) Personal Log
 * This program will allow users to store personal reviews of the MCU movies they’ve watched
 * The program can output the reviews in certain orders as the user wishes
 * The search function that allows the user to search for specific reviews to be outputted
 *
 * @author (Rebecca)
 * @version (May.31st/23)
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main{
    //declare variables
    public static String strTitle = "";
    public static float fltRating = 0;
    public static String strComments = "";
    public static byte bytFlag = 0;
    
    //number of spaces that are used in the Files array
    public static byte bytStored = -1;
        //initialize negative one so that every time when it increments by one, objects can be stored at Files[0]
    
    //declare scanner
        //one only for number and one only for Strings to avoid scanner issues
        public static Scanner NumInput = new Scanner(System.in);
        public static Scanner StringInput = new Scanner(System.in);
    
    //declare objects of reviews
    public static Reviews Movie = new Reviews();
    //declare array of reviews
    public static Reviews[] Files = new Reviews[50];
    
    public static void main(String[] args){
        try {    
            //declare variables
            byte bytOption;
            
            //introduction
            System.out.println("Welcome to the MCU Lobby!");
            System.out.println("You can track all your reviews in your Personal MCU Log.");
            System.out.print("Press any key to get started!");
            StringInput.nextLine();
            
            //loop to keep outputting menu after each operation until user wants to exit
            do{
                //offer menu
                Menu();
                
                //reset the option input
                bytOption = 0;
                
                //get input for menu
                System.out.print("Option: ");
                bytOption = NumInput.nextByte();
                
                //if user doesn't input a number avaliable on the menu
                if (bytOption <= 0 || bytOption > 4){
                   JOptionPane.showMessageDialog(null, "Please enter a number from the menu!");
                }
                
                //evoke operation
                switch (bytOption){
                    case 1:    
                        //input
                            InputReviews(); 
                        //create object
                            Reviews Movie = new Reviews(strTitle, fltRating, strComments);
                        //store info in object and array
                            Files[bytStored += 1] = Movie; break;
                    case 2: ReviewSearch(Files); break;
                    case 3: ReviewMenu(bytOption, Files); break;
                    case 4: bytFlag = Exit(); break;
                }
            } while (bytFlag == 0);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");
        }
    }
    public static void Clear(){
        System.out.printf("\u000C");
    }
    public static void Menu(){
        System.out.println("\nMenu: ");
        System.out.println("1 - Input Reviews");
        System.out.println("2 - Review Search");
        System.out.println("3 - Output Reviews");
        System.out.println("4 - Exit Program");
    }
    public static void InputReviews(){
        try {
            //keep console empty
            Clear();
            
            //input title info and store in variables
            System.out.print("Title: ");
            strTitle = StringInput.nextLine();
            System.out.print("Rating out of 5 stars: ");
            fltRating = NumInput.nextFloat();
            System.out.print("Comments: ");
            strComments = StringInput.nextLine();
        } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");
           bytFlag = 1;
        }
    }
    public static void ReviewSearch(Reviews[] Files){
        //declare variables
        String strSearch;
        
        //keep console empty
        Clear();
        
        //check whether there are any reviews stored already
        if (bytStored < 0){
                System.out.println("Your files are empty, go add some reviews!");
        } else {
            //get input to search
            System.out.print("Search for Title: ");
            strSearch = StringInput.nextLine();
            
            //search through array
            for (int i = 0; i <= bytStored; i++){
                //if the Title the user is looking for is equal to any of the titles from the reviews
                if (strSearch.equalsIgnoreCase(Files[i].Title)){
                    //output the exact review the user is searching for
                    System.out.println("\n" + Files[i]);
                } else {
                    //title not found
                    System.out.println(strSearch + " does not exist in your files!");
                }
            }
        }
    }
    public static void ReviewMenu(byte bytOption, Reviews[] Files){
        try{
            //reset user's choice
            bytOption = 0;
            
            //keep console empty
            Clear();
        
            //offer menu
            System.out.println("Output reviews: ");
            System.out.println("1 - All Reviews");
            System.out.println("2 - Most Recent to Least");
            
            //get input for menu
            System.out.print("Option: ");
            bytOption = NumInput.nextByte();
            
            //if user doesn't input a number avaliable on the menu
            if (bytOption <= 0 || bytOption > 2){
                JOptionPane.showMessageDialog(null, "Please enter a number from the menu!");
            }
            
            //evoke operation
            switch (bytOption){
                case 1: All(Files); break;
                case 2: MostRecent(Files); break;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");
            bytFlag = 1; 
        }
    }
    public static void All(Reviews[] Files){
        //keep console empty
        Clear();
        
        //check whether there are any reviews stored already
        if (bytStored < 0){
                System.out.println("Your files are empty, go add some reviews!");
        } else {
            //there are reviews stored --> output all reviews from array
            for (int i = 0; i <= bytStored; i++){
                System.out.println(Files[i]);
                System.out.println();
            }
        }
    }
    public static void MostRecent(Reviews[] Files){
        //keep console empty
        Clear();
        
        //check whether there are any reviews stored already
        if (bytStored < 0){
                System.out.println("Your files are empty, go add some reviews!");
        } else {
            //there are reviews stored --> output all reviews from array in backwards order
            for (int i = bytStored; i >= 0; i--){
                System.out.println(Files[i]);
                System.out.println();
            }
        }
    }
    public static byte Exit(){
        //closing message
        System.out.println();
        System.out.println("Have a great day!");
        
        //end the loop of menu
        return 1;
    }
}
