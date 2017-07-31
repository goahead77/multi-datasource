package cn.wenqi.master.repository;

import cn.wenqi.common.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wenqi
 */
public interface StudentWRepository extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student>{

}
