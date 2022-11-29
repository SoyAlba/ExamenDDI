package servlet.insertar;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.BaseServlet;
import servlet.Repositorio.ChampionRepositorio;
import servlet.modelos.Champion;

@WebServlet("/insertChampion")
public class InsertarChampion extends BaseServlet{

	
	ChampionRepositorio repository = new ChampionRepositorio();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Champion champion = getChampionInsert(req);
		repository.insert(champion);
		String index="/index.jsp";
		redirect(req, resp,index);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	public ChampionRepositorio getRepository() {
		return repository;
	}

	public void setRepository(ChampionRepositorio repository) {
		this.repository = repository;
	}
}
