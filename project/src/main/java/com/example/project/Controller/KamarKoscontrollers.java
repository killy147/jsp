package com.example.project.Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.Models.KamarKos;

@Controller
public class KamarKoscontrollers {
    private String url = "jdbc:postgresql://localhost:5432/dbPemesananKosss";
    private String user = "POSTGRES";
    private String password = "admin";

    private String connStatus = "Disconnected";
    private String connMessage = "";

    Connection conn;
    java.sql.Statement stmnt;
    String sql;

    @RequestMapping("/KosBuTetty")
    public String KosBuTetty(Model model) {
        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            connStatus = "Connected";

            stmnt = conn.createStatement();

            sql = "SELECT * FROM public.tblpemesanan";

            ResultSet rs = stmnt.executeQuery(sql);

            List<KamarKos> data = new LinkedList<>();

            while (rs.next()) {
                KamarKos ks = new KamarKos();

                ks.setIdPemesanan(rs.getInt("idpemesanan"));
                ks.setIdUser(rs.getInt("iduser"));
                ks.setIdKamarkos(rs.getInt("idkamarkos"));
                ks.setTanggalPemesanan(rs.getDate("tanggalpemesanan"));
                ks.setTanggalMasuk(rs.getDate("tanggalmasuk"));
                ks.setTanggalKeluar(rs.getDate("tanggalkeluar"));

                data.add(ks);
            }

            model.addAttribute("data", data);
        } catch (Exception e) {
            connMessage = e.getMessage();
        }

        model.addAttribute("connStatus", connStatus);
        model.addAttribute("connMessage", connMessage);

        return "KamarKos";
    }

    @RequestMapping("/tambah_KamarKos")
    public String tambah_KamarKos() {

        return "tambah_KamarKos";
    }

    @RequestMapping("/save")
    public String save(Model model, @RequestParam int iduser, @RequestParam int idkamarkos,
            @RequestParam Date tanggalpemesanan,
            @RequestParam Date tanggalmasuk, @RequestParam Date tanggalkeluar, @RequestParam int idpemesanan) {
        connStatus = "Disconnected";
        connMessage = "";

        KamarKos ks = new KamarKos();

        ks.setIdPemesanan(idpemesanan);
        ks.setIdUser(iduser);
        ks.setIdKamarkos(idkamarkos);
        ks.setTanggalPemesanan(tanggalpemesanan);
        ks.setTanggalMasuk(tanggalmasuk);
        ks.setTanggalKeluar(tanggalkeluar);

        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            connStatus = "Connected";

            stmnt = conn.createStatement();

            sql = "INSERT INTO public.tblpemesanan (idpemesanan, iduser, idkamarkos, tanggalpemesanan, tanggalmasuk, tanggalkeluar) VALUES ('"
                    + ks.getIdPemesanan() + "', '" + ks.getIdUser() + "', '" + ks.getIdKamarkos() + "', '"
                    + ks.getTanggalPemesanan() + "', '"
                    + ks.getTanggalMasuk() + "', '" + ks.getTanggalKeluar() + "')";

            stmnt.execute(sql);
        } catch (Exception e) {
            connMessage = e.getMessage();
        }

        model.addAttribute("connStatus", connStatus);
        model.addAttribute("connMessage", connMessage);
        return "redirect:/KosBuTetty";
    }

    @RequestMapping("/ubah_KamasKos")
    public String ubah(Model model, @RequestParam String idpemesanan) {
        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            connStatus = "Connected";

            stmnt = conn.createStatement();

            sql = "SELECT * FROM public.tblpemesanan WHERE idpemesanan ='" + idpemesanan + "'";

            ResultSet rs = stmnt.executeQuery(sql);

            rs.next();

            KamarKos ks = new KamarKos(rs.getInt("idpemesanan"), rs.getInt("iduser"), rs.getInt("idkamarkos"),
                    rs.getDate("tanggalpemesanan"), rs.getDate("tanggalmasuk"),
                    rs.getDate("tanggalkeluar"));

            model.addAttribute("ks", ks);
        } catch (Exception e) {
            connMessage = e.getMessage();
        }
        return "edit_kamarkos";
    }

    @RequestMapping("/update_KamasKos")
    public String update(Model model, @RequestParam int iduser, @RequestParam int idkamarkos,
            @RequestParam Date tanggalpemesanan,
            @RequestParam Date tanggalmasuk, @RequestParam Date tanggalkeluar, @RequestParam int idpemesanan) {

        connStatus = "Disconnected";
        connMessage = "";

        KamarKos ks = new KamarKos();

        ks.setIdPemesanan(idpemesanan);
        ks.setIdUser(iduser);
        ks.setIdKamarkos(idkamarkos);
        ks.setTanggalPemesanan(tanggalpemesanan);
        ks.setTanggalMasuk(tanggalmasuk);
        ks.setTanggalKeluar(tanggalkeluar);

        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            connStatus = "Connected";

            stmnt = conn.createStatement();

            sql = "UPDATE public.tblpemesanan SET iduser = '" + ks.getIdUser() + "', idkamarkos = '"
                    + ks.getIdKamarkos() + "', tanggalpemesanan = '" + ks.getTanggalPemesanan() + "', tanggalmasuk='"
                    + ks.getTanggalMasuk() + "', tanggalkeluar='" + ks.getTanggalKeluar()
                    + "' WHERE idpemesanan = '" + ks.getIdPemesanan() + "'";

            stmnt.execute(sql);
        } catch (Exception e) {
            connMessage = e.getMessage();
        }

        model.addAttribute("connStatus", connStatus);
        model.addAttribute("connMessage", connMessage);

        return "redirect:/KosBuTetty";
    }

    @RequestMapping("/hapus_KamasKos")
    public String delete(Model model, @RequestParam int idpemesanan) {
        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            connStatus = "Connected";

            stmnt = conn.createStatement();

            sql = "DELETE FROM public.tblpemesanan WHERE idpemesanan='" + idpemesanan + "'";

            stmnt.execute(sql);
        } catch (Exception e) {
            connMessage = e.getMessage();
        }

        model.addAttribute("connStatus", connStatus);
        model.addAttribute("connMessage", connMessage);

        return "redirect:/KosBuTetty";
    }

}
