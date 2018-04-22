//Joshua Tucker
//c1739307
//adapted from week 3 'PhoneBook' example
//Used to store and manipulate a vector of student objects
import java.util.Vector;
import java.io.*;
public class QuestionBank implements Serializable {

	//creates a vector 'studentEntries' made up of Student objects
	private Vector<Question> questionBank;

    public QuestionBank( ) {
        questionBank = new Vector<Question>();
    }

	public void add( String questionText, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String topic ) {
		//add new student to studentEntries vector
		questionBank.add(new Question(
		questionText,
		answer1,
		answer2,
		answer3,
		answer4,
		correctAnswer,
		topic));
	}

	public void delete( int position ) {
		//removes student at 'position' index of the vector
		if (position >= 0 && position < questionBank.size()) {
			questionBank.remove(position);
		}
		System.out.println("invalid address");
	}

	public String searchQuestions( int field, String pattern ) {
		//creates a string of student details that contain the
		//substring 'pattern' in the given field
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < questionBank.size(); ++i) {

			//check for substring
			if (questionBank.get(i).getDetail(field).contains(pattern)) {
				//add to output string
				temp.append( questionBank.get(i).toString() + "\n" );

			}
		}

		//return string if results are found
		if (temp.length() != 0) {
			return temp.toString();
		} else {
			return "No Results";
		}

	}

	public String toString() {
		//appends to toStrings of all the student objects int he vector
		//Taken from week3 PhoneBook example
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < questionBank.size(); ++i) {
			temp.append( questionBank.get(i).toString() + "\n" );
		}
		return temp.toString();
	}

	public String subset( int start, int end ) {
		//Similar to toString method except it takes only a slice of the vector
		StringBuffer temp = new StringBuffer();
		if ( (start > -1) && (end <= questionBank.size()) ) {
			for (int i = start; i < end; ++i) {
				temp.append( questionBank.get(i).toString() + "\n" );
			}
			return temp.toString();
		}
		return ("invalid start/end position");

	}

	}
