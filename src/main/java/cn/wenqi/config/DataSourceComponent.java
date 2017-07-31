package cn.wenqi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author wenqi
 */
@Configuration
@EnableTransactionManagement
@AutoConfigureAfter({DataSourceConfig.class})
public class DataSourceComponent extends MybatisAutoConfiguration {

   @Autowired
   @Qualifier("masterDataSource")
   private DataSource masterDataSource;

   @Autowired
   @Qualifier("slaveDataSource")
   private DataSource slaveDataSource;


    @Bean(name = "multiDataSource")
    public MultiRouteDataSource multiDataSource() {
        MultiRouteDataSource multiDataSource = new MultiRouteDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", masterDataSource);
        targetDataSources.put("slave", slaveDataSource);
        multiDataSource.setTargetDataSources(targetDataSources);
        multiDataSource.setDefaultTargetDataSource(masterDataSource);
        return multiDataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(multiDataSource());
        return manager;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(multiDataSource());
    }

}
