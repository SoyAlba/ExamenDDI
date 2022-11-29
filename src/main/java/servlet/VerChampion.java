package servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servlet.Repositorio.ChampionRepositorio;

import servlet.modelos.Champion;

@WebServlet("/verChampion")
public class VerChampion extends HttpServlet {
	ChampionRepositorio repo = new ChampionRepositorio();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Champion> champion = repo.listAll();
		req.setAttribute("lista", champion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoChampion.jsp");
		dispatcher.forward(req, resp);
	}
}
