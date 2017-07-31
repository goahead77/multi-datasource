package cn.wenqi.service.impl;

import cn.wenqi.annocation.TargetDataSource;
import cn.wenqi.dto.Student;
import cn.wenqi.mapper.StudentMapper;
import cn.wenqi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wenqi
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Transactional
    @TargetDataSource("master")
    @Override
    public Student addStudent(Student student) {
        studentMapper.addStudent(student);
        return  student;
    }

    @TargetDataSource("slave")
    @Override
    @Transactional(readOnly = true)
    public List<Student> queryList() {
        return studentMapper.selectAllStudent();
    }
}
