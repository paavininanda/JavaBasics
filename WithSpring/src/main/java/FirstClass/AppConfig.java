package FirstClass;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@ComponentScan("FirstClass")
@MapperScan("FirstClass")
public class AppConfig {
	
	@Bean
    public BasicDataSource getDataSource() {
       BasicDataSource dataSource = new BasicDataSource();
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/java");
       dataSource.setUsername("root");
       dataSource.setPassword("");
       return dataSource;
   }
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
      sessionFactory.setDataSource((javax.sql.DataSource) getDataSource());
      sessionFactory.getObject().getConfiguration().addMapper(Mapper.class);
      return sessionFactory.getObject();
	}
	
	@Bean
	   public DataSourceTransactionManager transactionManager() {
	       return new DataSourceTransactionManager(getDataSource());
	   }
}
