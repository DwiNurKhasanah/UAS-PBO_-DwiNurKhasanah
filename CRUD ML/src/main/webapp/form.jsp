<%@ page import="com.uas.model.Hero" %>
<%
    Hero hero = (Hero) request.getAttribute("hero");
%>
<html>
<head>
    <title><%= (hero != null ? "Edit Hero" : "Tambah Hero") %></title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2><%= (hero != null ? "Edit Hero" : "Tambah Hero Baru") %></h2>

    <form action="HeroServlet" method="post">
        <input type="hidden" name="id" value="<%= (hero != null) ? hero.getId() : 0 %>">

        <label>Nama:</label>
        <input type="text" name="nama" value="<%= (hero != null) ? hero.getNama() : "" %>" required><br>

        <label>Kategori:</label>
        <select name="kategori">
            <option <%= (hero != null && hero.getKategori().equals("MAGE")) ? "selected" : "" %>>MAGE</option>
            <option <%= (hero != null && hero.getKategori().equals("ASSASIN")) ? "selected" : "" %>>ASSASIN</option>
            <option <%= (hero != null && hero.getKategori().equals("FIGHTER")) ? "selected" : "" %>>FIGHTER</option>
            <option <%= (hero != null && hero.getKategori().equals("TANK")) ? "selected" : "" %>>TANK</option>
            <option <%= (hero != null && hero.getKategori().equals("MARKSMAN")) ? "selected" : "" %>>MARKSMAN</option>
            <option <%= (hero != null && hero.getKategori().equals("SUPPORT")) ? "selected" : "" %>>SUPPORT</option>
        </select><br>

        <label>Gender:</label>
        <select name="gender">
            <option <%= (hero != null && hero.getGender().equals("MALE")) ? "selected" : "" %>>MALE</option>
            <option <%= (hero != null && hero.getGender().equals("FEMALE")) ? "selected" : "" %>>FEMALE</option>
        </select><br>

        <input type="submit" value="<%= (hero != null) ? "Update" : "Simpan" %>">
    </form>

    <a class="btn" href="HeroServlet">⬅ Kembali</a>
</div>
</body>
</html>
