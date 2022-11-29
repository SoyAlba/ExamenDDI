package servlet.eliminar;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.BaseServlet;
import servlet.Repositorio.ChampionRepositorio;


@WebServlet(name="eliminarChampion", value="/ChampionDelete")
public class eliminarChampion extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req,resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ChampionRepositorio repository = new ChampionRepositorio();
		Integer id = Integer.parseInt(req.getParameter("id"));
		repository.deleteById(id);
		redirect(req, resp, "ListadoChampion.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String nombreChampion = req.getParameter("champion_name");
		Integer idChapion = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id", idChapion);
		req.setAttribute("champion_name", nombreChampion);
		redirect(req, resp, "/EliminarChampion.jsp");
	}
}
