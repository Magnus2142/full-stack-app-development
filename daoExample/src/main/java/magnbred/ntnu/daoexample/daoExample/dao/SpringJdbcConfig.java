package magnbred.ntnu.daoexample.daoExample.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // LOCAL MYSQL SERVER
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/daoExample");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //NTNU's mysql server
        /*
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://loginstud04.stud.ntnu.no:3306/magnbred_daoExample");
        dataSource.setUsername("magnbred_magnus2142");
        dataSource.setPassword("root");
*/
        return dataSource;
    }
}
