package com.driver;

import java.util.HashMap;
import java.util.*;

public class StudentRepository {
    private HashMap<String,Student> studentMap;
    private HashMap<String ,Teacher> teacherMap;
    private HashMap<String ,List<String>> studentTeacherMap;
    
    public StudentRepository(){
        this.studentMap=new HashMap<String ,Student>();
        this.teacherMap=new HashMap<String ,Teacher>();
        this.studentTeacherMap=new HashMap<String ,List<String>>();
    }


  // save student  in map;
  public void saveStudent(Student student){
      studentMap.put(student.getName() ,student);
  }

  // save teacher in map

  public void saveTeacher(Teacher teacher){
      teacherMap.put(teacher.getName(),teacher);
  }

  //save teacher and student pair teacher---->list of students
  public void saveTeacherstudentPair(String teacher ,String student){
       if(studentMap.containsKey(student) && teacherMap.containsKey(student)){
           List<String> studentlist=new ArrayList<>();

           if(studentTeacherMap.containsKey(teacher))
           studentlist=studentTeacherMap.get(teacher);

           studentlist.add(student);

           
       }
  }
  public Student findStudent(String student){
    return studentMap.get(student);
}


public Teacher FindTeacher(String teacher){
 return teacherMap.get(teacher);
}


public List<String> getStudentList(String teacher){
    List<String> studentList=new ArrayList<>();

    if(studentTeacherMap.containsKey(teacher)){
       studentList=studentTeacherMap.get(teacher);
    }
    return studentList;
}


public List<String> FindAllstudents(){
 return new ArrayList<>( studentMap.keySet());
}



public void deletestudentbyTeacher(String teacher){
      List<String> students=new ArrayList<>();

      if(studentTeacherMap.containsKey(teacher)){
         students=studentTeacherMap.get(teacher);
      for(String student: students){
         if(studentMap.containsKey(student)){
             studentMap.remove(student);
         }
      }
      studentTeacherMap.remove(teacher);
     }
     if(teacherMap.containsKey(teacher)){
         teacherMap.remove(teacher);
     }
}



public void removeAllteachers(){
   List<String> studentset=new ArrayList<>();
   teacherMap=new HashMap<>();
   for(String teacher:studentTeacherMap.keySet() ){
      for(String  student:studentTeacherMap.get(teacher) ){
          studentset.add(student);
      }
   }
   for(String student:studentset){
     if(studentMap.containsKey(student)){
         studentMap.remove(student);
     }
   }
   studentTeacherMap=new HashMap<>();
}
}

