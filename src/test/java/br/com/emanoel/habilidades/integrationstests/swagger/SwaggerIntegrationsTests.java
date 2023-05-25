package br.com.emanoel.habilidades.integrationstests.swagger;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import br.com.emanoel.habilidades.configs.TestConfigs;
import br.com.emanoel.habilidades.integrationtest.testContainers.AbstractIntegrationTest;
import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationsTests extends AbstractIntegrationTest {

	@Test
	public void showDisplaySwaggerUiPage() {
		var content = given().basePath("/swagger-ui/index.html").port(TestConfigs.SERVER_PORT).when().get().then()
				.statusCode(200).extract().body().asString();
		
		assertTrue(content.contains("Swagger UI"));
	}

}
