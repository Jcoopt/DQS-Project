import java.util.Scanner ;
import java.util.Vector ;
import java.io.*;


public class Statistics implements Serializable
{
  //Menu which allows user to choose between viewing question data and student data
  public static void menu()
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
        System.out.println(qb.get(i).getQuestionText() + i);
      }
    Scanner in = new Scanner( System.in );
    int choice = in.nextInt();
    try
    {
      //Displays average time taken for chosen student
      qb.get(choice) ;
      System.out.println("Average time taken to answer : \n"
      + qb.get(choice).getAvTime());

    }
    catch(Exception e)
    {
      System.out.println("Invalid") ;
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
    }
    catch(Exception e)
    {
      System.out.println("Invalid");
    }
  }

}
