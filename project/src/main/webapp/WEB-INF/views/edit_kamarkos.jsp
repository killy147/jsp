<%@ page import="com.example.project.models.KamarKos" %>
<% 
    KamarKos m = (KamarKos) request.getAttribute("ks");
%>

<html>
<head>
    <title>Edit Kamar Kos</title>
</head>
<body>
    <h1>Edit Kamar Kos</h1>

    <form action="/update_KamasKos" method="POST">
        <input type="hidden" name="idpemesanan" value="<%= m.getIdPemesanan() %>">

        <label for="iduser">Id User :</label>
        <input type="number" id="iduser" name="iduser" value="<%= m.getIdUser() %>" required><br><br>

        <label for="idkamarkos">Id Kamar Kos :</label>
        <input type="number" id="idkamarkos" name="idkamarkos" value="<%= m.getIdKamarkos() %>" required><br><br>

        <label for="tanggalpemesanan">Tanggal Pemesanan :</label>
        <input type="date" id="tanggalpemesanan" name="tanggalpemesanan" value="<%= m.getTanggalPemesanan() %>" required><br><br>

        <label for="tanggalmasuk">Tanggal Masuk :</label>
        <input type="date" id="tanggalmasuk" name="tanggalmasuk" value="<%= m.getTanggalMasuk() %>" required><br><br>

        <label for="tanggalkeluar">Tanggal Keluar :</label>
        <input type="date" id="tanggalkeluar" name="tanggalkeluar" value="<%= m.getTanggalKeluar() %>" required><br><br>

        <input type="submit" value="Update">
    </form>

    <h2>Status Koneksi: ${connStatus}</h2>
    <h3>Pesan Koneksi: ${connMessage}</h3>
</body>
</html>
