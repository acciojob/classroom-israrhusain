package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    
     @Autowired
     StudentRepository service;

     public void addStudent(Student student){
         service.saveStudent(student);
     }
     public void addTeacher(Teacher teacher){
          service.saveTeacher(teacher);
     }

     public void addstudentFromteacher(String teacher,String student){
        service.saveTeacherstudentPair(teacher, student);
     }

     public Student FindstudentbyName(String student){
        return service.findStudent(student);
    }
    public Teacher FindTeacherbyName(String teacher){
        return service.FindTeacher(teacher);
    }
    public List<String> FindstudentFromteacher(String teacher){
          return service.getStudentList(teacher);
    }
    public List<String> FindAllstudents(){
            return service.FindAllstudents();
    }
    public void deleteTeacher(String teacher){
        service.deletestudentbyTeacher(teacher);
    }
    public void deleteAllTeachers(){
        service.removeAllteachers();
    }
}





