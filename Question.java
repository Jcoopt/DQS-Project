//Joshua Tucker
//c1739307
//Adapted from PhoneBook.java from Week3
//Holds and returns data on a single student
import java.util.Vector;
import java.io.*;
class Question implements Serializable {

  private String[] details = new String[7];
  private Vector<Float> answerTimes;

  public Question(
    String questionText,
    String answer1,
    String answer2,
    String answer3,
    String answer4,
    String correctAnswer,
    String topic,
    String timesAsked,
    String timesCorrect,
    String timesWrong) {

    details[0] = questionText;
    details[1] = answer1;
    details[2] = answer2;
    details[3] = answer3;
    details[4] = answer4;
    details[5] = correctAnswer;
    details[6] = topic;
    details[7] = timesAsked;
    details[8] = timesCorrect;
    details[9] = timesWrong;

  }

  public Float getAvTime( ) {
  Float avAnswerTime = 0.0F;
    for (int i = 0; i >= answerTimes.size(); ++i) {
      avAnswerTime += answerTimes.get(i);
    }
    return (avAnswerTime / answerTimes.size());
  }

  public void updateTime( Float newTime ) {
    answerTimes.add(newTime);
  }

  public String getDetail( int index ) {
    return details[index];
  }

  public String getQuestionText( ) {
    return details[0];
  }

  public String getAnswer1( ) {
    return details[1];
  }

  public String getAnswer2( ) {
    return details[2];
  }

  public String getAnswer3( ) {
    return details[3];
  }

  public String getAnswer4( ) {
    return details[4];
  }

  public String getCorrectAnswer( ) {
    return details[5];
  }

  public String getTopic( ) {
        return details[6];
    }

    public String getTimesAsked( ) {
        return details[7];
    }

    public String getTimeCorrect( ) {
        return details[8];
    }
    public String getTimesWrong( ) {
        return details[9];
    }



  public String toString( ) {
    return(details[0]
    +"\n\t1." + details[1]
    +"\n\t2." + details[2]
    +"\n\t3." + details[3]
    +"\n\t4." + details[4]
    + "\nTopic: " + details[5]
    + "\nCorrect answer" + details[6]
    + "\nTimes Asked: " + details[7]
    + "\nTimes Correct" + details[8]
    + "\nTimes Wrong" + details[9]);
  }

}
