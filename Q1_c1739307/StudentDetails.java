//Joshua Tucker
//c1739307
//adapted from week 3 'PhoneBook' example
//Used to store and manipulate a vector of student objects
import java.util.Vector;
import java.io.*;
public class StudentDetails implements Serializable {

	//creates a vector 'studentEntries' made up of Student objects
	private Vector<Student> studentEntries;

    public StudentDetails( ) {
        studentEntries = new Vector<Student>();
    }

	public void add( String inName, String inStudentNumber, String inCourseName, String inCourseID, String inHouseNumber, String inStreetName, String inTown, String inPostcode) {
		//add new student to studentEntries vector
		studentEntries.add(new Student(
		inName,
		inStudentNumber,
		inCourseName,
		inCourseID,
		inHouseNumber,
		inStreetName,
		inTown,
		inPostcode));
	}

	public void delete( int position ) {
		//removes student at 'position' index of the vector
		if (position > 0 && position < studentEntries.size()) {
			studentEntries.remove(position);
		}
		System.out.println("invalid address");
	}

	public String searchStudents( int field, String pattern ) {
		//creates a string of student details that contain the
		//substring 'pattern' in the given field
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < studentEntries.size(); ++i) {

			//check for substring
			if (studentEntries.get(i).getDetail(field).contains(pattern)) {
				//add to output string
				temp.append( studentEntries.get(i).toString() + "\n" );

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
		for (int i = 0; i < studentEntries.size(); ++i) {
			temp.append( studentEntries.get(i).toString() + "\n" );
		}
		return temp.toString();
	}

	public String subset( int start, int end ) {
		//Similar to toString method except it takes only a slice of the vector
		StringBuffer temp = new StringBuffer();
		if ( (start > -1) && (end <= studentEntries.size()) ) {
			for (int i = start; i < end; ++i) {
				temp.append( studentEntries.get(i).toString() + "\n" );
			}
			return temp.toString();
		}
		return ("invalid start/end position");

	}

	}
