package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bean.Client;
import commun.IConstante;



public class LoginCommand implements ICommand {
	//mise en place du logger
	final static Logger logger = Logger.getLogger(command.LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String stringDeRetour = IConstante.JSP_ROOT + "login.jsp";
		
			//recuperer les valeur user et pass dans l'objet client
			//creation d'un objet client
			Client cl = new Client();
			//je passe les parametre user et name du formulaire login.jsp dans le client
			cl.setUser(request.getParameter("user"));
			cl.setPass(request.getParameter("pass"));
			
				
			//verifier si le client est enregistré
			//si on pas d'utilisateur dans la session
			if(request.getSession().getAttribute("user")==null) {
				logger.debug("user est null");
				
				//si le user et valide on l'enregistre dans la session
				if(cl.isValidate()) {
					request.getSession().setAttribute("user", cl);
					logger.debug("user est valid "+cl);
					//on renvoit vers Command.InitCommand
					stringDeRetour="frontControleur?cmd=Init";
				}
				
				
			}else {
				logger.debug("mon user "+cl);
			}
			return stringDeRetour;
			
	}

}
