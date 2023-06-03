<%@ page import="java.util.List" %>
<%@ page import="com.example.project.models.KamarKos" %>
<% 
    List<KamarKos> d = (List<KamarKos>) request.getAttribute("data");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>Admin | KOST</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&family=Poppins:wght@600;700&display=swap"
        rel="stylesheet" />

    <!-- Fontawesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/lib/animate/animate.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

    <!-- Template Stylesheet -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
</head>

<body>
    <p>Status Connection : <b> ${connStatus == "Connected" ? "<font color='green'>Connected</font>" : "<font color='red'>Disconnected</font>"} ${connMessage}</b></p>
    <p>
        Jumlah Data : ${data.size()}
    </p>
    <p>
        <a href="/tambah_KamarKos" class="btn btn-primary">Tambah</a>
    </p>
    <div class="container-xxl py-5">
        <h1 class="text-center">Admin</h1>
        <div class="container d-flex justify-content-center">
            <table class="table">
                <thead class="table-dark">
                    <tr>
                        <td>ID Pemesanan</td>
                        <td>ID User</td>
                        <td>ID Kamar Kos</td>
                        <td>Tanggal Pemesanan</td>
                        <td>Tanggal Masuk</td>
                        <td>Tanggal Keluar</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < d.size(); i++){ %>
                        <tr>
                            <td><%= d.get(i).getIdPemesanan() %></td>
                            <td><%= d.get(i).getIdUser() %></td>
                            <td><%= d.get(i).getIdKamarkos() %></td>
                            <td><%= d.get(i).getTanggalPemesanan() %></td>
                            <td><%= d.get(i).getTanggalMasuk() %></td>
                            <td><%= d.get(i).getTanggalKeluar() %></td>
                            <td>
                                <a href="/ubah_KamasKos?idpemesanan=<%= d.get(i).getIdPemesanan() %>" class="btn btn-primary">Update</a>
                                <a href="/hapus_KamasKos?idpemesanan=<%= d.get(i).getIdPemesanan() %>" onclick="return confirm('Apakah anda yakin untuk menghapus data ?')"class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>