package cn.wenqi.slave.repository;

import cn.wenqi.common.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wenqi
 */
public interface StudentRRepository extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student>{

}
