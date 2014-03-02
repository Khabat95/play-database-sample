import org.junit.Test;

import play.libs.F.Callback;
import play.test.Helpers;
import play.test.TestBrowser;
import static org.fest.assertions.Assertions.*;

public class IntegrationTest {

	/**
	 * add your integration test here in this example we just check if the
	 * welcome page is being shown
	 */
	@Test
	public void test() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication(Helpers.inMemoryDatabase())),
				Helpers.HTMLUNIT, new Callback<TestBrowser>() {
					public void invoke(TestBrowser browser) {
						browser.goTo("http://localhost:3333");
						assertThat(browser.pageSource()).contains("Sign in");
						assertThat(browser.pageSource()).contains(
								"Don't have an account");
					}
				});
	}

}
