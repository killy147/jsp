
<html>
<head>
    <title>Tambah Kamar Kos</title>
</head>
<body>
    <h1>Tambah Kamar Kos</h1>

    <form action="/save" method="POST">
        <label for="idpemesanan">ID Pemesanan:</label>
        <input type="number" id="idpemesanan" name="idpemesanan" required><br><br>

        <label for="iduser">ID User:</label>
        <input type="number" id="iduser" name="iduser" required><br><br>

        <label for="idkamarkos">ID Kamar Kos:</label>
        <input type="number" id="idkamarkos" name="idkamarkos" required><br><br>

        <label for="tanggalpemesanan">Tanggal Pemesanan:</label>
        <input type="Date" id="tanggalpemesanan" name="tanggalpemesanan" required><br><br>

        <label for="tanggalmasuk">Tanggal Masuk:</label>
        <input type="Date" id="tanggalmasuk" name="tanggalmasuk" required><br><br>

        <label for="tanggalkeluar">Tanggal Keluar:</label>
        <input type="Date" id="tanggalkeluar" name="tanggalkeluar" required><br><br>

        <input type="submit" value="simpan">
    </form>

    <h2>Status Koneksi: ${connStatus}</h2>
    <h3>Pesan Koneksi: ${connMessage}</h3>
</body>
</html>
