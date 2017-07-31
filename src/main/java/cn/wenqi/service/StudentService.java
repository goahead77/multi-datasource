package cn.wenqi.service;

import cn.wenqi.annocation.TargetDataSource;
import cn.wenqi.dto.Student;

import java.util.List;

/**
 * @author wenqi
 */
public interface StudentService {

    @TargetDataSource("master")
    Student addStudent(Student student);

    @TargetDataSource("slave")
    List<Student> queryList();
}
