
import java.util.Vector;
import java.io.*;
class Question implements Serializable {

  private String[] details = new String[10];
  private int[] stats = new int[4];
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
    stats[0] = Integer.parseInt(timesAsked);
    stats[1] = Integer.parseInt(timesCorrect);
    stats[2] = Integer.parseInt(timesWrong);
    stats[3] = 0;

  }

  public Float getAvTime( ) { // for recording average times (not functional in prototype)
  Float avAnswerTime = 0.0F;
    for (int i = 0; i >= answerTimes.size(); ++i) {
      avAnswerTime += answerTimes.get(i);
    }
    return (avAnswerTime / answerTimes.size());
  }

  public void updateTime( Float newTime ) {// for recording average times (not functional in prototype)
    answerTimes.add(newTime);
  }

  public String getDetail( int index ) {// getter for parts of the question as stored
    return details[index];
  }

  public String getQuestionText( ) { // getter for the actual text of the question
    return details[0];
  }
  public void EditQuestion(String text,String a1,String a2,String a3,String a4,String correct){
      // updates a question
      details[0] = text;
      details[1] = a1;
      details[2] = a2;
      details[3] = a3;
      details[4] = a4;
      details[5]=correct;
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

  public void setTimesAsked(int increase){
      details[7]+=increase;
  }
  public void setTimesCorrect(int increase){
        details[8]+=increase;
    }
    public void setTimesWrong(int increase){
        details[9]+=increase;
    }

  public String getTopic( ) {
        return details[6];
    }

    public int getTimesAsked( ) {
        return (stats[0] + stats[1]);
    }

    public int getTimeCorrect( ) {
        return stats[0];
    }
    public int getTimesWrong( ) {
        return stats[1];
    }

    public void inCorrect( int modifier ) {
      stats[0] += modifier;
    }

    public void inWrong( int modifier ) {
      stats[1] += modifier;
    }

    public int getTimesExited( ) {
      return stats[2];
    }

    public void inTimesExited( int modifier ) {
      stats[2] += modifier;
    }

    public String getQuestionFileSafe() { //returns the question in a format for saving
      String  temp="";
      temp+= details[0]
              +"," + details[1]
              +"," + details[2]
              +"," + details[3]
              +"," + details[4]
              +"," + details[5]
              +"," + details[6]
              +"," + stats[0]
              +"," + stats[1]
              +"," + stats[2];
      return temp;
    }

    public String toString( ) {
    return(details[0]
    +"\n\t1." + details[1]
    +"\n\t2." + details[2]
    +"\n\t3." + details[3]
    +"\n\t4." + details[4]
    + "\nTopic: " + details[6]
    + "\nCorrect answer" + details[5]
    + "\nTimes Asked: " + details[7]
    + "\nTimes Correct: " + details[8]
    + "\nTimes Wrong: " + details[9]
    + "\nTimes Exited on: " + stats[2]);
  }

}
