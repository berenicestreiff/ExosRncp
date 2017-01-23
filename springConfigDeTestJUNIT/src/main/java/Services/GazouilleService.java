 package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berenice.springConfigDeTestJUNIT.beans.Message;
import com.berenice.springConfigDeTestJUNIT.beans.MessageDAO;
@Service
public class GazouilleService {
private MessageDAO messagedao;


public static final String CENSORED = "twitter";


@Autowired
	public MessageDAO getMessagedao() {
	return messagedao;}

public void setMessagedao(MessageDAO messagedao) {
	this.messagedao = messagedao;}

	public Message publish(Message m){
			m.setTitre(m.getTitre().replaceAll(CENSORED, "GAZOUILLE"));
			m.setCorps(m.getCorps().replaceAll(CENSORED, "GAZOUILLE"));
			getMessagedao().save(m);
			return m;
	}
	
	

	
}
