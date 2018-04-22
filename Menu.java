//Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java
import java.util.Scanner;
import java.io.*;

public class Menu {

  public static void main( String[] args ) {

    QuestionBank qb = new QuestionBank();


while (true) {
  //display main menu
  System.out.println("Options:");
  System.out.println("1.Add new question");
  System.out.println("2.Display all questions");
  System.out.println("3.Show questions by topic");
  System.out.println("4.Delete question");
  System.out.println("5.Save questions");
  System.out.println("6.Exit");


    Scanner in = new Scanner(System.in);
    int option = in.nextInt();
    String monthString;
    switch (option) {

        case 1:
        //1.Add new question
        QuestionEntry qe = new QuestionEntry();
        String questionInput[] = qe.newEntry();
        qb.add(
        questionInput[0],
        questionInput[1],
        questionInput[2],
        questionInput[3],
        questionInput[4],
        questionInput[5],
        questionInput[6]
        );
        break;

        case 2:
        //2.Display all questions
        System.out.println(qb);
        break;

        case 3:
        //3.Search for students by topic
        System.out.println(getSearch(qb));
        break;

        case 4:
        //4.Delete student
        System.out.println("Enter number of record to Delete: ");
        qb.delete(in.nextInt());
        break;

        case 5:
        //5.Save Questions

        break;

        case 6:
        //6.Exit
        System.exit(0);
        break;

      }

    }

  }

  public static String getSearch( QuestionBank qb ) {

    //get substring to search for
    System.out.println("Search for: ");
    Scanner ib = new Scanner(System.in);
    String pattern = ib.nextLine();

    //return results
    return (qb.searchQuestions( 5, pattern ));
  }

}
