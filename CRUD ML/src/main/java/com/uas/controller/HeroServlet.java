package com.uas.controller;

import com.uas.dao.HeroDAO;
import com.uas.model.Hero;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class HeroServlet extends HttpServlet {
    private final HeroDAO dao = new HeroDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Hapus data
        if (req.getParameter("delete") != null) {
            int id = Integer.parseInt(req.getParameter("delete"));
            dao.deleteHero(id);
            resp.sendRedirect("HeroServlet");
            return;
        }

        // Form edit data
        if (req.getParameter("edit") != null) {
            int id = Integer.parseInt(req.getParameter("edit"));
            Hero hero = dao.getHeroById(id);
            req.setAttribute("hero", hero);
            RequestDispatcher dispatcher = req.getRequestDispatcher("form.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        // Tampilkan semua data (READ/REFRESH)
        List<Hero> heroes = dao.getAllHeroes();
        req.setAttribute("heroList", heroes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        req.setCharacterEncoding("UTF-8");

        String idParam = req.getParameter("id");
        String nama = req.getParameter("nama");
        String kategori = req.getParameter("kategori");
        String gender = req.getParameter("gender");

        // Debugging (opsional, bisa dihapus)
        System.out.println("=== FORM SUBMIT ===");
        System.out.println("id: " + idParam);
        System.out.println("nama: " + nama);
        System.out.println("kategori: " + kategori);
        System.out.println("gender: " + gender);

        // Logika tambah vs edit
        if (idParam != null && !idParam.isEmpty() && !idParam.equals("0")) {
            // Update hero
            int id = Integer.parseInt(idParam);
            Hero hero = new Hero(id, nama, kategori, gender);
            dao.updateHero(hero);
        } else {
            // Tambah hero baru
            Hero hero = new Hero(0, nama, kategori, gender);
            dao.insertHero(hero);
        }

        // Redirect ke daftar
        resp.sendRedirect("HeroServlet");
    }
}
