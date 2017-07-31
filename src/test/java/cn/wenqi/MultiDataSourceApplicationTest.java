package cn.wenqi;

import cn.wenqi.common.dto.Student;
import cn.wenqi.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Unit test for simple MultiDataSourceApplication.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MultiDataSourceApplicationTest{

    private static final Log log= LogFactory.getLog(MultiDataSourceApplicationTest.class);

    @Autowired
    private StudentService studentService;

    @Test
    public void studentServiceTest() throws InterruptedException {
        Student student=new Student();
        student.setStuName(UUID.randomUUID().toString());
        student.setCreateTime(new Date());
        Student stu=studentService.addStudent(student);
        System.out.println(stu);
        Thread.sleep(2000);

        List<Student> students=studentService.queryList();
        assert students!=null && students.size()!=0;

        for (Student s:students){
            log.info(s);
        }
    }
}
