package com.uas.dao;

import com.uas.model.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/hero_db";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Penting untuk pastikan driver terbaca
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // READ ALL HEROES
    public List<Hero> getAllHeroes() {
        List<Hero> list = new ArrayList<>();
        String sql = "SELECT * FROM tm_hero ORDER BY id_hero DESC";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Hero h = new Hero(
                        rs.getInt("id_hero"),
                        rs.getString("nama_hero"),
                        rs.getString("kategori"),
                        rs.getString("gender")
                );
                list.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // READ SINGLE HERO BY ID
    public Hero getHeroById(int id) {
        Hero hero = null;
        String sql = "SELECT * FROM tm_hero WHERE id_hero = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                hero = new Hero(
                        rs.getInt("id_hero"),
                        rs.getString("nama_hero"),
                        rs.getString("kategori"),
                        rs.getString("gender")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hero;
    }

    // INSERT HERO
    public void insertHero(Hero h) {
        String sql = "INSERT INTO tm_hero(nama_hero, kategori, gender) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, h.getNama());
            stmt.setString(2, h.getKategori());
            stmt.setString(3, h.getGender());

            int rows = stmt.executeUpdate();
            System.out.println("[Insert] Rows inserted: " + rows);

        } catch (Exception e) {
            System.err.println("[Insert] Error:");
            e.printStackTrace();
        }
    }

    // UPDATE HERO
    public void updateHero(Hero h) {
        String sql = "UPDATE tm_hero SET nama_hero = ?, kategori = ?, gender = ? WHERE id_hero = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, h.getNama());
            stmt.setString(2, h.getKategori());
            stmt.setString(3, h.getGender());
            stmt.setInt(4, h.getId());

            int rows = stmt.executeUpdate();
            System.out.println("[Update] Rows updated: " + rows);

        } catch (Exception e) {
            System.err.println("[Update] Error:");
            e.printStackTrace();
        }
    }

    // DELETE HERO
    public void deleteHero(int id) {
        String sql = "DELETE FROM tm_hero WHERE id_hero = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println("[Delete] Rows deleted: " + rows);

        } catch (Exception e) {
            System.err.println("[Delete] Error:");
            e.printStackTrace();
        }
    }
}
