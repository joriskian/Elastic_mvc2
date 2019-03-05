package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	//Règles de visibilité en Java - rappel
	
	//				Un membre de la classe  peut être :
	//"private" : accessible seulement à la classe
	//"protected ": accessible aux classed du paquetage et à toute classe dérivée en dehors du paquetage
	//"public ": accessible à toutes les classes
	
	//on note rien donc c'est friendly  : "package friendly (défaut) ": accessible aux classes dans le même paquetage.
	String execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
