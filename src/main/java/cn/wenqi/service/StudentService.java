package cn.wenqi.service;

import cn.wenqi.common.dto.Student;

import java.util.List;

/**
 * @author wenqi
 */
public interface StudentService {

    Student addStudent(Student student);

    List<Student> queryList();
}
