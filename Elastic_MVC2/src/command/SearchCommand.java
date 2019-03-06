package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import commun.IConstante;

public class SearchCommand implements ICommand {
	
	//on instancie le logger
	final static Logger logger = Logger.getLogger(controleur.FrontControleur.class);
	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("je suis dans la recherche dans mon catalogue");
		
		
		
		
		// TODO Auto-generated method stub
		 return IConstante.JSP_ROOT + "catatalogue.jsp";
	}

}
