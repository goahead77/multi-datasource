package cn.wenqi.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wenqi
 */
@Setter
@Getter
@Entity
@Table(name = "t_student")
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String stuName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
