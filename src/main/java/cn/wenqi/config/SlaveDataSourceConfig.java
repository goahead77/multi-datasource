package cn.wenqi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @author wenqi
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "cn.wenqi.slave.repository",
        entityManagerFactoryRef ="entityManagerFactorySlave",
        transactionManagerRef ="transactionManagerSlave")
public class SlaveDataSourceConfig {

    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource dataSource;

    @Primary
    @Bean(name = "entityManagerSlave")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySlave(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactorySlave")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySlave (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties(dataSource))
                .packages("cn.wenqi.common.dto") //设置实体类所在位置
                .persistenceUnit("slavePersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerSlave")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySlave(builder).getObject());
    }

}
