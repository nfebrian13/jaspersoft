package com.nfebrian13.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.nfebrian13.model.Student;

@Mapper
public interface StudentRepository {

	@Select("SELECT * FROM student WHERE id = #{id}")
	public Student findById(long id);

	@Select("select * from student")
	public List<Student> findAll();

	@Delete("DELETE FROM student WHERE id = #{id}")
	public int deleteById(long id);

	@Insert("INSERT INTO student(id, name, passport) VALUES (#{id}, #{name}, #{passport})")
	public int insert(Student student);

	@Update("Update student set name=#{name}, passport=#{passport} where id=#{id}")
	public int update(Student student);
}