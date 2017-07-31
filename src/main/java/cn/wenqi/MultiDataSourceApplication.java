package cn.wenqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 多数据源配置，主从配置
 */
@SpringBootApplication
@EnableAspectJAutoProxy
//@EnableConfigurationProperties({MasterDataSourceConfig.class, SlaveDataSourceConfig.class})//!!!很重要，告诉springboot可以查找并加载在申明的类中的配置
public class MultiDataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApplication.class,args);
    }
}
