package br.com.emanoel.habilidades.integrationtest.testContainers;

import java.util.Map;
import java.util.stream.Stream;

import org.hibernate.service.spi.Startable;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {
	public class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		private static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER;

		static {
			POSTGRESQL_CONTAINER = new PostgreSQLContainer<>("postgres:latest").withDatabaseName("bucetinha")
					.withUsername("wrpdv").withPassword("rpdvwin1064");
			POSTGRESQL_CONTAINER.start();
		}

		private static Map<String, String> createConnectionConfiguration() {

			return Map.of("spring.datasource.url", POSTGRESQL_CONTAINER.getJdbcUrl(), "spring.datasource.username",
					POSTGRESQL_CONTAINER.getUsername(), "spring.datasource.password",
					POSTGRESQL_CONTAINER.getPassword());
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			startContainer();

			String url = POSTGRESQL_CONTAINER.getJdbcUrl();
			String username = POSTGRESQL_CONTAINER.getUsername();
			String password = POSTGRESQL_CONTAINER.getPassword();

			ConfigurableEnvironment environment = applicationContext.getEnvironment();
			MapPropertySource testeContainers = new MapPropertySource("testeContainers",
					(Map) createConnectionConfiguration());

			environment.getPropertySources().addFirst(testeContainers);
		}

		private static void startContainer() {
			Startables.deepStart(Stream.of(POSTGRESQL_CONTAINER)).join();
		}

	}

}
