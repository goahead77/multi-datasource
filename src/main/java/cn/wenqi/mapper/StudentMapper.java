package cn.wenqi.mapper;

import cn.wenqi.dto.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wenqi
 */
@Mapper
public interface StudentMapper {

    Student selectById(Integer id);

    List<Student> selectAllStudent();

    void addStudent(Student student);

}
