//Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class adminMenu {

  public static void loadMenu( ) {
    StudentBank sb = new StudentBank();
    loadStudents("students.txt",sb);

    QuestionBank qb = new QuestionBank();
    loadQuestions("testQ.txt",qb);


    while (true) {
      //display main menu
      System.out.println("Options:");
      System.out.println("1.Add new question");
      System.out.println("2.Display all questions");
      System.out.println("3.Show questions by topic");
      System.out.println("4.Delete question");
      System.out.println("5.Save questions");
      System.out.println("6.Load Question");
      System.out.println("7.Start quiz");
      System.out.println("8.Start quiz for students");
      System.out.println("9.View Statistics");
      System.out.println("10.Edit Question");
      System.out.println("11.Exit");
      ;


        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        String monthString;
        switch (option) {

            case 1:
            //1.Add new question
            System.out.println("-------------------------------");
            QuestionEntry qe = new QuestionEntry();
            String questionInput[] = qe.newEntry();
            addQuestion(questionInput, qb);
            System.out.println("-------------------------------");
            break;

            case 2:
            //2.Display all questions
            System.out.println("-------------------------------");
            System.out.println(qb);
            System.out.println("-------------------------------");
            break;

            case 3:
            //3.Search for students by topic
            System.out.println("-------------------------------");
            System.out.println(getSearch(qb));
            System.out.println("-------------------------------");
            break;

            case 4:
            //4.Delete student
            System.out.println("-------------------------------");
            System.out.println("Enter number of record to Delete: ");
            qb.delete(in.nextInt());
            System.out.println("-------------------------------");
            break;

            case 5:
            System.out.println("-------------------------------");
            qb.saveBank();
            System.out.println("-------------------------------");
            //5.Save Questions

            break;

            case 6:
            System.out.println("-------------------------------");
            System.out.println("What is the name of the file you want to load?");
            // String file_name = in.nextLine();
            String file_name = "testQ.txt";
            loadQuestions(file_name,qb);
            System.out.println("-------------------------------");
            break;

            case 7:
            //7.Start quiz
            System.out.println("-------------------------------");
            Scanner id = new Scanner(System.in);
            Quiz q = new Quiz();
            q.startQuiz(qb);
            System.out.println("-------------------------------");
            break;

            case 8:
                studentMenu studentQuiz= new studentMenu();
                studentQuiz.infoMenu();
                break;

            case 9:
            Statistics studentStats = new Statistics();
            Statistics.menu(qb, sb);
            case 10:
                System.out.println("Which question would you like to edit?");
                int n = qb.length();

                for ( int i = 0; i < n; ++i) {
                    System.out.println("" + i + "." + qb.getQuestion(i).getQuestionText());
                }
                int qToChange = in.nextInt();
                in.nextLine();
                System.out.println("What should the question text say??");
                String qText=in.nextLine();
                System.out.println("What should Question A be?");
                String aAText= in.nextLine();
                System.out.println("What should Question B be?");
                String aBText=in.nextLine();
                System.out.println("What should Question C be?");
                String aCText=in.nextLine();
                System.out.println("What should Question D be?");
                String aDText=in.nextLine();
                qb.getQuestion(qToChange).EditQuestion(qText,aAText,aBText,aCText,aDText);
                qb.saveBank();
                break;
            case 11:
            //8.Exit
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
          System.out.println("Loading Questions\n\n");
          Scanner input_file_handler = new Scanner(new File(file_name));

          while (input_file_handler.hasNextLine()) {

              String line_from_file = input_file_handler.nextLine();
              String[] split_line = line_from_file.split(",");
              addQuestion(split_line, qb);
             // System.out.println("file read");

             /*System.out.println(Arrays.asList(split_line));
              StudentsList.add(new Student(Arrays.asList(split_line)));*/
          }
          input_file_handler.close();
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Problem reading file: " + file_name + ". Are you sure it exists?");
      }
  }

  public static void loadStudents(String file_name, StudentBank sb){

      try { //method adapted from lab and taught session exercises
          System.out.println("Loading Questions\n\n");
          Scanner input_file_handler = new Scanner(new File(file_name));

          while (input_file_handler.hasNextLine()) {

              String line_from_file = input_file_handler.nextLine();
              String[] split_line = line_from_file.split(",");
              addStudent(split_line, sb);
             // System.out.println("file read");

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

  public static void addStudent( String[] studentInput, StudentBank sb ) {
    Student inStudent = new Student(studentInput[0], studentInput[1], studentInput[2]);
    sb.add(inStudent);

  }
}
