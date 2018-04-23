//Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java
import java.util.Vector;
import java.util.Scanner;
import java.io.*;

public class Quiz {

  public static Vector<Question> qb = new Vector<Question>();


  public static void startQuiz( QuestionBank inBank, String topic ){
    int QuestionCounter = 0;
    int Score = 0;

    for ( int i = 0; i == inBank.length(); ++i) {
      displayQuestion(inBank.getQuestion(i));
      if (checkAnswer(inputAnswer(), Integer.parseInt(inBank.getQuestion(i).getCorrectAnswer()))) {
        Score += 1;
        System.out.println("correct");
        inBank.inCorrect(1);
      } else {
        System.out.println("incorrect");
        inBank.inWrong(1);
      }

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
