import java.util.Scanner ;
import java.util.Vector ;
import java.io.*;


public class Statistics implements Serializable
{
  //Menu which allows user to choose between viewing question data and student data
  public static void menu( QuestionBank qb, StudentBank sb )
    {
      System.out.println("Options: \n" + "View student data : 1 \n" + "View question data : 2") ;
      Scanner in = new Scanner( System.in ) ;
      String choice = in.next();
      switch(choice)
      {
        case "1" : studentStats(sb) ;
        case "2" : questionStats(qb) ;
      }
    }



  public static void questionStats(QuestionBank qb)
    {
    //Displays all questions, allow user to choose one
    System.out.println("Choose question to view data of:");
    for(int i = 0; i != qb.length(); i++)
      {
        System.out.println(i + ": " + qb.getQuestion(i).getQuestionText());
      }
    Scanner in = new Scanner( System.in );
    int choice = in.nextInt();
    try
    {
      //Displays average time taken for chosen student
      qb.getQuestion(choice) ;
      System.out.println("Times asked : \n"
      + qb.getQuestion(choice).getTimesAsked()
      + "\n"
      +"Times answered correctly : \n"
      + qb.getQuestion(choice).getTimeCorrect()
      + "\n"
      +"Times answered incorrectly : \n"
      + qb.getQuestion(choice).getTimesWrong()
      + "\n"
      +"Times exited : \n"
      + qb.getQuestion(choice).getTimesExited()) ;
      adminMenu.loadMenu();


    }
    catch(Exception e)
    {

      System.out.println(e) ;
      adminMenu.loadMenu();
    }


    }

  public static void studentStats(StudentBank sb){
    System.out.println("Choose which student to view data of : ") ;
    Scanner in = new Scanner( System.in );
    for(int i = 0; i != sb.length(); i++)
    {
      System.out.println(sb.get(i).getName() + sb.get(i).getStudentNumber() + i) ;
    }
    int choice = in.nextInt() ;
    try
    {

      System.out.println(sb.get(choice).infoString()) ;
      adminMenu.loadMenu();
    }
    catch(Exception e)
    {
      System.out.println("Invalid");
      adminMenu.loadMenu();
    }
  }

}

