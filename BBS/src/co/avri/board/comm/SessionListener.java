package co.avri.board.comm;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

	public static Set<String> sessionSet = new HashSet<>();
	
	
    public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent event)  { 
    	System.out.println("세션 생성: " + event.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    }

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("속성 추가?: " + event.getName() + " : " + event.getValue());
    	if (event.getName().equals("id")) {
    		sessionSet.add((String)event.getValue());
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	if (event.getName().equals("id")) {
    		sessionSet.remove((String)event.getValue());
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
