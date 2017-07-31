package cn.wenqi.service.impl;

import cn.wenqi.common.dto.Student;
import cn.wenqi.master.repository.StudentWRepository;
import cn.wenqi.service.StudentService;
import cn.wenqi.slave.repository.StudentRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenqi
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentWRepository studentWRepository;

    @Autowired
    private StudentRRepository studentRRepository;


    @Override
    public Student addStudent(Student student) {
        return studentWRepository.save(student);
    }

    @Override
    public List<Student> queryList() {
        return studentRRepository.findAll();
    }
}
