package cn.wenqi.repository;

import cn.wenqi.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wenqi
 */
public interface StudentRepository extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student> {

}
