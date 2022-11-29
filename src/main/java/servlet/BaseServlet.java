package servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import servlet.modelos.Champion;
import servlet.modelos.ChampionAbiliti;
import servlet.modelos.ChampionStat;
import servlet.modelos.ChampionTip;
import servlet.modelos.item;
import servlet.modelos.Rune;

import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

	public BaseServlet() {
		super();
	}

	protected Champion getChampionInsert(HttpServletRequest req) {
		Champion champion = new Champion();
		champion.setId(Integer.parseInt(req.getParameter("id")));
		champion.setName(req.getParameter("name"));
		champion.setTitle(req.getParameter("title"));
		champion.setLore(req.getParameter("lore"));
		champion.setTags(req.getParameter("tags"));
		return champion;
	}
	protected ChampionAbiliti getAbilityInsertar(HttpServletRequest req) {
		ChampionAbiliti ability = new ChampionAbiliti();
		ability.setId(Integer.parseInt(req.getParameter("id")));
		ability.setChampion(req.getParameter("champion"));
		ability.setName(req.getParameter("name"));
		ability.setDescription(req.getParameter("description"));
		ability.setEffect(req.getParameter("effect"));
		ability.setCost(Integer.parseInt(req.getParameter("cost")));
		ability.setRange(Integer.parseInt(req.getParameter("range")));
		return ability;
	}
	protected ChampionStat getStatInsertar(HttpServletRequest req) {
		
		ChampionStat stat = new ChampionStat();
		stat.setChampion(Integer.parseInt(req.getParameter("champion")));
		stat.setName(req.getParameter("name"));
		stat.setValue(Integer.parseInt(req.getParameter("value")));
		stat.setModifier_per_level(Integer.parseInt(req.getParameter("modifier_per_level")));
		return stat;
	}

	protected ChampionTip getTipInsertar(HttpServletRequest req) {
		ChampionTip tip = new ChampionTip();
		tip.setId(Integer.parseInt(req.getParameter("id")));
		tip.setChampion(req.getParameter("champion"));
		tip.setTip(req.getParameter("tip"));
		return tip;

	}

    protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException{
        req.getRequestDispatcher(jsp).forward(req, resp);
    }

	protected item getItemInsertar(HttpServletRequest req) {
		item Item = new item();
		Item.setId(Integer.parseInt(req.getParameter("id")));
		Item.setName(req.getParameter("name"));
		Item.setEffect(req.getParameter("effect"));
		return Item;
	}
	protected Rune getRuneInsertar(HttpServletRequest req) {
		Rune rune = new Rune();
		rune.setId(Integer.parseInt(req.getParameter("id")));
		rune.setTier(req.getParameter("tier"));
		rune.setName(req.getParameter("name"));
		rune.setDescription(req.getParameter("description"));
		return rune;
	}

}