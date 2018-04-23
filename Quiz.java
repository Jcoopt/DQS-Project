//Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java
import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Quiz {
  public static Vector<Question> qb = new Vector<Question>();

  public Quiz( QuestionBank inBank, String topic ) {


    for (int i = 0; i <= inBank.length(); ++i ) {
      qb.add(inBank.getQuestion(i));
    }

    Collections.shuffle(qb);
    int QuestionCounter = 0;





  }

  public static void startQuiz( ){

    for (int i = 0; i <= qb.size(); ++i ) {
      displayQuestion( qb.get(i) );
      checkAnswer(inputAnswer(  ), Integer.parseInt(qb.get(i).getCorrectAnswer()));

    }

  }

  public static void displayQuestion( Question q ) {
    System.out.println(q.getQuestionText());
    System.out.println(q.getAnswer1() + "  " + q.getAnswer2());
    System.out.println(q.getAnswer3() + "  " + q.getAnswer4());
  }

  public static int inputAnswer(  ) {
    Scanner in = new Scanner(System.in);
    System.out.println("Answer: ");
    return( in.nextInt() );
  }

  public static Boolean checkAnswer( int answer, int correctAnswer ) {
    if ( answer == correctAnswer ) {
      return true;
    } else {
      return false;
    }

  }


}
