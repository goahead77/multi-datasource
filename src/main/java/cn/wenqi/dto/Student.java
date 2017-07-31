package cn.wenqi.dto;

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
@ToString
public class Student {

    private Integer id;

    private String stuName;
    private Date createTime;
}
