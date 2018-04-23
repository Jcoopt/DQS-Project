//Joshua Tucker
//Adapted from PhoneBookTest.java
import java.util.Vector;
import java.util.Scanner;
import java.io.*;

public class Quiz {

  public static Vector<Question> qb = new Vector<Question>();

  public static void startQuiz( QuestionBank inBank,String setTopic ){
    int QuestionCounter = 0;
    int Score = 0;
    //System.out.println( inBank.length() );
    int n = inBank.length();

    for ( int i = 0; i < n; ++i) {
      if ( setTopic.equals("")|| inBank.getQuestion(i).getTopic().equals(setTopic)){
        displayQuestion(inBank.getQuestion(i));
        inBank.getQuestion(i).setTimesAsked(1);
        int answer = inputAnswer();
        if ( answer == 8 ) {
          inBank.getQuestion(i).inTimesExited(1);
          break;
        }
        if (checkAnswer(answer, Integer.parseInt(inBank.getQuestion(i).getCorrectAnswer()))) {
          Score += 1;
            inBank.getQuestion(i).setTimesCorrect(1);
          System.out.println("correct");
          inBank.getQuestion(i).inCorrect(1);
        }
        else {
          System.out.println("incorrect");
            inBank.getQuestion(i).setTimesWrong(1);
          inBank.getQuestion(i).inWrong(1);
        }
        QuestionCounter += 1;
    }
    }
    endQuiz( QuestionCounter, Score );
  }

  public static void displayQuestion( Question q ) {
    System.out.println("-------------------------------");
    System.out.println("At any time enter '8' to exit.");
    System.out.println(q.getQuestionText());
    System.out.println("1)"+q.getAnswer1() + "  2)" + q.getAnswer2());
    System.out.println("3)"+q.getAnswer3() + "  4)" + q.getAnswer4());
    System.out.println("-------------------------------");
  }

  public static int inputAnswer(  ) {
    Scanner in = new Scanner(System.in);
    System.out.println("Answer: ");
    int inAnswer = in.nextInt();
    return( inAnswer );
  }

  public static Boolean checkAnswer( int answer, int correctAnswer ) {
    if ( answer == correctAnswer ) {
      return true;
    } else {
      return false;
    }

  }

  public static void endQuiz( int QuestionCount, int Score ) {
    System.out.println("----- END -----");
    System.out.println("You scored " + Score + "/" + QuestionCount);
    System.out.println("---------------");
  }


}
