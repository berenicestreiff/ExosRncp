package springConfigDeTestJUNIT.test;
// import des asserts

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.berenice.springConfigDeTestJUNIT.beans.Message;

import Services.GazouilleService;
// cette annotation indique à junit d'utiliser un autregestionnaire de test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:testContext.xml") 
public class MessageTest {

	private GazouilleService gazouilleService;
	
	
	
	public GazouilleService getGazouilleService() {
		return gazouilleService;
	}



	public void setGazouilleService(GazouilleService gazouilleService) {
		this.gazouilleService = gazouilleService;
	}



	@Test
	public void testmessage(){
		String expected="hello";
		String actual=message.getTitre();
		assertEquals("le titre du msg ne correspond pas", expected,actual);
		
	}
	
	
	@Test
	public void normalPublisgtest(){
		Messsage m = gazouilleService
		assertEquals("le titre ne correspond pas","vive la pizza",m.getTitre());
		assertEquals("le corps ne correspond pas","vive la pizza miam ",m.getCOrps());
		
		
		
		
	}
}
