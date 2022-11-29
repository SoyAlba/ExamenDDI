package servlet.Buscar;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.Repositorio.AbilityRepositorio;
import servlet.Repositorio.ChampionRepositorio;

import servlet.modelos.Champion;
import servlet.modelos.ChampionAbiliti;

@WebServlet("/verChampionAbility")
public class VerChampionAbility extends HttpServlet {
	AbilityRepositorio repo = new AbilityRepositorio();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<ChampionAbiliti> champion = repo.buscar();
		req.setAttribute("lista", champion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoAbiliti.jsp");
		dispatcher.forward(req, resp);
	}
}
