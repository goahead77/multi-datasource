package cn.wenqi.controller;

import cn.wenqi.common.dto.Student;
import cn.wenqi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author wenqi
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<String> addStudent(){
        Student student=new Student();
        student.setStuName(UUID.randomUUID().toString());
        student.setCreateTime(new Date());
        studentService.addStudent(student);
       return ResponseEntity.ok("done");
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> list(){

        return ResponseEntity.ok(studentService.queryList());
    }
}
