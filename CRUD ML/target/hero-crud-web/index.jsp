<%@ page import="java.util.*, com.uas.model.Hero" %>
<%
    List<Hero> heroList = (List<Hero>) request.getAttribute("heroList");
%>
<html>
<head>
    <title>Daftar Hero</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Daftar Hero Mobile Legend</h2>

    <div style="margin-bottom: 15px;">
        <a class="btn" href="form.jsp">Tambah Hero</a>
        <a class="btn" href="HeroServlet">Refresh</a>
    </div>

    <table>
        <tr>
            <th>ID</th><th>Nama</th><th>Kategori</th><th>Gender</th><th>Aksi</th>
        </tr>
        <%
            if (heroList != null && !heroList.isEmpty()) {
                for (Hero h : heroList) {
        %>
        <tr>
            <td><%= h.getId() %></td>
            <td><%= h.getNama() %></td>
            <td><%= h.getKategori() %></td>
            <td><%= h.getGender() %></td>
            <td>
                <a href="HeroServlet?edit=<%= h.getId() %>">Edit</a> |
                <a href="HeroServlet?delete=<%= h.getId() %>" onclick="return confirm('Yakin ingin menghapus?')">Hapus</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5" style="text-align:center;">🚫 Tidak ada data hero ditemukan.</td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
