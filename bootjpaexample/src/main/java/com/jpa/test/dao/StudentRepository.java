package com.jpa.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.entities.Student;
@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer>{
	/*
	 * public List<Student> findByName(String name); public List<Student>
	 * findByCity(String city); public List<Student> findAllStudent();
	 * //@Query("select u FROM User u where u.name =:n and u.city=:c") public
	 * List<Student> getStudentByNameAndCity( String name,String city);
	 * 
	 */

}
