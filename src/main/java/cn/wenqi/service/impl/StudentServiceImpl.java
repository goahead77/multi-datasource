package cn.wenqi.service.impl;

import cn.wenqi.annocation.TargetDataSource;
import cn.wenqi.dto.Student;
import cn.wenqi.repository.StudentRepository;
import cn.wenqi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenqi
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @TargetDataSource("master")
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @TargetDataSource("slave")
    @Override
    public List<Student> queryList() {
        return studentRepository.findAll();
    }
}
