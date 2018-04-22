//Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java
import java.util.Arrays;
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
    System.out.println("6.Load Question");
  System.out.println("7.Exit");
  ;


    Scanner in = new Scanner(System.in);
    int option = in.nextInt();
    String monthString;
    switch (option) {

        case 1:
        //1.Add new question
        QuestionEntry qe = new QuestionEntry();
        String questionInput[] = qe.newEntry();
        addQuestion(questionInput, qb);
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
            System.out.println("What is the name of the file you want to load?");
           // String file_name = in.nextLine();
            String file_name = "testQ.txt";
            loadQuestions(file_name,qb);
            break;

        case 7:
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
  public static void loadQuestions(String file_name, QuestionBank qb){


      try { //method adapted from lab and taught session exercises
          System.out.println("read file");
          Scanner input_file_handler = new Scanner(new File(file_name));

          while (input_file_handler.hasNextLine()) {

              String line_from_file = input_file_handler.nextLine();
              String[] split_line = line_from_file.split(",");
              addQuestion(split_line, qb);
              System.out.println("file read");

             /*System.out.println(Arrays.asList(split_line));
              StudentsList.add(new Student(Arrays.asList(split_line)));*/
          }
          input_file_handler.close();
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Problem reading file: " + file_name + ". Are you sure it exists?");
      }
  }

  public static void addQuestion( String[] questionInput, QuestionBank qb ) {
    qb.add(
    questionInput[0],
    questionInput[1],
    questionInput[2],
    questionInput[3],
    questionInput[4],
    questionInput[5],
    questionInput[6]
    );
  }
}
