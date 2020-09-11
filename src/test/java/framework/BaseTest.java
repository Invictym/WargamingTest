package framework;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import java.util.Map;

public class BaseTest extends BaseEntity {

  protected Map<String, String> parameters;

  @BeforeTest
  public void setUp(ITestContext context) {
    System.out.println("Get parametrs");
    parameters = context.getCurrentXmlTest().getAllParameters();
  }
}
