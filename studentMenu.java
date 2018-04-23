import java.io.File;
import java.util.Scanner;

public class studentMenu {
    //Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java


    public static void infoMenu( ) {
        while (true){
        System.out.println("Hi! What school are you from?");
        Scanner in = new Scanner(System.in);
        String school = in.nextLine();
        boolean running=true;
        while (running) {
            running=loadMenu();
        }
        System.exit(0);
        }

    }

    public static boolean loadMenu( ) {

        QuestionBank qb = new QuestionBank();
        adminMenu.loadQuestions("testQ.txt",qb);
        boolean running=true;
        while (true) {
            //display main menu

            System.out.println("1.Start quiz");
            System.out.println("2.Exit");

            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            String monthString;
            switch (option) {

                case 1:
                    //1.Start quiz
                    System.out.println("-------------------------------");
                    Scanner id = new Scanner(System.in);
                    System.out.println("Please enter the topic of the quiz");
                    String topic = id.nextLine();
                    Quiz q = new Quiz();
                    q.startQuiz(qb, topic);
                    System.out.println("-------------------------------");
                    break;

                case 2:
                    //2.Exit
                    running=false;
                    break;


            }break;

        }
        return running;
    }

}


