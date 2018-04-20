//Joshua Tucker
//c1739307
//Adapted from PhoneBook.java from Week3
//Holds and returns data on a single student

import java.io.*;
class Student implements Serializable {

  private String[] details = new String[8];

  public Student(
    String name,
    String studentNumber,
    String courseName,
    String courseID,
    String houseNumber,
    String streetName,
    String town,
    String postcode) {

    details[0] = name;
    details[1] = studentNumber;
    details[2] = courseName;
    details[3] = courseID;
    details[4] = houseNumber;
    details[5] = streetName;
    details[6] = town;
    details[7] = postcode;
  }

  public String getDetail( int index ) {
    return details[index];
  }

  public String getName() {
    return details[0];
  }

  public String getSudentNumber() {
    return details[1];
  }

  public String getCourseName() {
    return details[2];
  }

  public String getCourseID() {
    return details[3];
  }

  public String getHouseNumber() {
    return details[4];
  }

  public String getStreetName() {
    return details[5];
  }

  public String getTown() {
    return details[6];
  }

  public String getPostcode() {
    return details[7];
  }

  public String toString( ) {
    return("student of name: " + details[0]
    +"\n\tNumber: " + details[1]
    +"\n\tCourse: " + details[2]
    +"\n\tCourseID: " + details[3]
    +"\n\tAddress: \n\t" + details[4] + "\n\t" + details[5] + "\n\t" + details[6] + "\n\t" + details[7]);
  }

}
