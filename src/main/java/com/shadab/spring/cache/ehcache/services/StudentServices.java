package com.shadab.spring.cache.ehcache.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.shadab.spring.cache.ehcache.model.Student;


@Service("studentServices")
public class StudentServices implements StudentService{
	

	private static List<Student> students;
	
	static{
		students = getStudentsFromDB();
	}
	
	
	@Cacheable(value="students", key="#rollNumber",condition="#rollNumber!='128'" , unless="#result==null")
	 public Student getByRoll(String rollNumber) {
		Student foundStudent =null;
		
		System.out.println("-------------------Called---------------------------rollNumber:"+rollNumber);
		 for(Student currentStudent:students) {
			 
			 if(currentStudent.getRollNumber().equals(rollNumber)) {
				 
				 System.out.println("Yes Student is Available::::"+currentStudent);	
				 foundStudent=currentStudent;
 				 break;
				 
			 }
			
		 }		 
		 return foundStudent;
		 }
		 
	 
	
	@CacheEvict(value = "students", allEntries = true)
	public void evictStudents() {
		// flushes all students
		System.out.println("---- Students flushed------");
	}	
	

	
	@CachePut(value = "students",key = "#student.rollNumber",  unless="#result==null")
	public Student updateStudents(Student student) {
		System.out.println("--------Updating Students-----------");
		for(Student currentStudent : students){
			if(currentStudent.getRollNumber().equalsIgnoreCase(student.getRollNumber()))
				currentStudent.setRollNumber(student.getRollNumber()+"-Modified");
				return currentStudent;
		}
		return null;
	}
	
	 
	 public static List<Student> getStudentsFromDB(){
		 
		 Student student = new Student("Ram", "123", "test Street 123");
		 Student student1 = new Student("Shyam", "125", "test Street 125");
		 Student student11 = new Student("John", "126", "test Street 126");
		 Student student111 = new Student("Tom", "127", "test Street 127");
		 Student student1111 = new Student("Dummy", "128", "test Street 128");
		 
		 List<Student> studentList = new ArrayList<>();
		 studentList.add(student);
		 studentList.add(student1);
		 studentList.add(student11);
		 studentList.add(student111);
		 studentList.add(student1111);
		 
		 return studentList;
	 }

}
