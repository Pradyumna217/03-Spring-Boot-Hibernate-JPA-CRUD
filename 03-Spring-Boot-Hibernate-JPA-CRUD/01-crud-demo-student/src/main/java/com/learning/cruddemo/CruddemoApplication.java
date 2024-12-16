package com.learning.cruddemo;

import com.learning.cruddemo.dao.StudentDAO;
import com.learning.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.ref.SoftReference;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public 	CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipletudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			updateStudentByLastName(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all Students");
		int num = studentDAO.deleteAll();

		System.out.println("Deleted " + num + " Students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting Student id : "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudentByLastName(StudentDAO studentDAO) {
		int num = studentDAO.updateByLastName();
		System.out.println(num);
	}

	private void updateStudent(StudentDAO studentDAO) {
//		retrieve student based on id : primary key

		int studentId = 1;
		System.out.println("Getting Student with id : "+studentId);

		Student myStudent = studentDAO.findbyId(studentId);

		System.out.println("Updating Student : ");

//		Set the data
		myStudent.setFirstName("Pradyumna");
		myStudent.setLastName("Deshmukh");
		myStudent.setEmail("pradyumna.deshmukh21@gmail.com");

		studentDAO.update(myStudent);

//		Display Updated Student
		System.out.println("Updated Student : "+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//		Get the list of Students
		List<Student> theStudents = studentDAO.findByLastName("Patil");

//		Display list of students

		for (Student s : theStudents){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
//		Get the list of Students
		List<Student> theStudents = studentDAO.findAll();

//		Display list of students

		for (Student s : theStudents){
			System.out.println(s);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
//		Create a student
		System.out.println("Creating new student");
		Student tempStudent= new Student("Daffy","Duck","Daffy.Duck@gmail.com");
//		save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
//		Display the id of the student
		int theId = tempStudent.getId();
		System.out.println("Saved Student : Generated ID : " +theId);
//		Retrieve the student based on id of the student
		Student theStudent = studentDAO.findbyId(theId);
//		Display student
		System.out.println("Found the Student " + theStudent);
	}

	private void createMultipletudents(StudentDAO studentDAO) {
//		Create Multiple Students
		System.out.println("Creating 3 student object");
		Student tempStudent1 = new Student("Akshay","Patil","MNO@gmail.com");
		Student tempStudent2 = new Student("Kshitij","Patil","IJK@gmail.com");
		Student tempStudent3 = new Student("Ishant","Patil","EFG@gmail.com");

//		Save those Students

		System.out.println("Saving the student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
//		create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Pradyumna","Deshmukh","pradyumna.deshmukh21@gmail.com");
//		Save the student object
		System.out.println("Saving the student ");
		studentDAO.save(tempStudent);
//		Display the id of the object

		System.out.println("Saved Student. Generated ID : " +tempStudent.getId());
	}

}
