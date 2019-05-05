//package mobal.dev.test.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//@Configuration
//@EnableJpaRepositories(basePackages = {
//	"mobalDev.repo.utilisateurRepo", "mobalDev.repo.banqueRepo", "mobalDev.repo.venduRepo",
//	"mobalDev.repo.marchadiseRepo", "mobalDev.repo.venduInBanqueRepo", "mobalDev.repo.produitRepo",
//	"mobalDev.repo.roleRepo"
//})
//@EnableTransactionManagement
//public class DatabaseConfigTest {
//	
//	@Bean
//    @Profile("test")
//    public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("adama2011");
//        
//        
//        return dataSource;
//    }
//
//}
