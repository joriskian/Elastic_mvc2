package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ICommand;
import command.InconnueCommand;
import commun.IConstante;

/**
 * Servlet implementation class FrontControleur
 * point d'entrée de toutes les requetes clients http
 * 
 *  les annotations :@nom:
 * urlPattern remplace le servlet mapping du  web-xml.
 * loadOnStartup=1 monte la servlet dés le demarrage de TomCat
 * 
 */
//@WebServlet(description = "controleur principal", urlPatterns = { "/frontControleur", "/index", "*.do"}, loadOnStartup=1)
@WebServlet("/frontControleur")
public class FrontControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControleur() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * 
     * @param request
     * 			la requete
     * @param response
     * 			la reponse
     * @throws ServletException
     * 			problemes avec la servlet
     * @throws IOException
     * 			probleme d'entrée sortie 
     */
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//methode principal
    	System.out.println("nom de servlet : "+this.getServletName()+" methode "+request.getMethod()+" uri "+request.getRequestURI());
    	
    	//on recupere la class de command qui correspont à la requete
    	//par exemple // si on m'envoit des infos depuis la page login.jsp ---> cmd = command.LoginCommand
    	ICommand command = getCommand(request);
    	
    	//on execute la methode execute (d'une des class implementant l'interface ICommand) et on la recupere dans un String "urlSuite"
    	//par exemple //du coup on lance la commande execute de la class command.LoginCommand (qui verifie si le user est valide)
    	//si valide--->renvoi vers --> command.InitCommand ou sinon vers la jsp --> WEB-INF/jsp/login.jsp
    	String urlSuite = command.execute(request, response);
    	System.out.println("mon url " +urlSuite);
    	//et on la renvoi dans la requete suivante  
    	request.getRequestDispatcher(urlSuite).forward(request, response);
    }

	//methode doGet et doPost 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
		
	}
	
	private ICommand getCommand(HttpServletRequest request) {
		
		//"command."+Nom+"Command" correspont à la structure ou "nom" correspont à la class que l'on retrouve dans la cmd
		// on le remplit via les constantes contenues dans "IConstante"
		String cmd  =   IConstante.PACKAGE_COMMAND + request.getParameter(IConstante.CLEFS_COMMAND)+IConstante.CLASS_COMMAND;
		//renvoi un truc du genre "command."+parametre recupéré+"Command" --->command.InitCommand
		//affichage dans la console
		System.out.println("FrontControleur, ma cmd : " + cmd);
		
		//initialisation d'une nouvel interface commandeAExecuter
		ICommand commandeAExecuter;
		
		try {
			//j'instancie la Class ? mais laquelle?
			
			//Au cours de l'exécution d'un programme, vous voulez créer un objet d'une classe dont le nom vous est donné sous forme de
			//chaîne de caractères, par exemple "InitCommand". Dans ce cas, il est impossible de créer cet objet grâce à l'opérateur new, puisque
			//new requiert une classe et pas une chaîne de caractères contenant le nom de cette classe;
			//new "InitCommand" () n'est pas accepté en Java.
			//mais comme là on sait pas quelle classe instancié vu qu'on est juste dans le frontControleur et qu'on sait pas par où
			//on arrive......
			//La classe java.lang.Class déclare les deux méthodes forName () et newInstance (), qui permettent de récupérer
			//une instance de Class à partir du nom complet d'une classe (package + nom de la classe) et de l'instancier
			//si cette classe a un constructeur sans paramètre.
			//
			//ah ah, je l'instancie quand même...
			commandeAExecuter = (ICommand) Class.forName(cmd).newInstance();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new InconnueCommand();
		} 
			
		
		//renvoi la commande a executer
		//dans notre cas   : (ICommand) Class.forName(cmd).newInstance();
		//----> la commande execute de command.InitCommand
		return commandeAExecuter;	
	}
		

}
