package com.example.project.Models;

import java.sql.Date;

public class KamarKos {
    private int idpemesanan;
    private int iduser;
    private int idkamarkos;
    private Date tanggalpemesanan;
    private Date tanggalmasuk;
    private Date tanggalkeluar;

    public KamarKos() {

    }

    public KamarKos(int idpemesanan, int iduser, int idkamarkos, Date tanggalpemesanan, Date tanggalmasuk,
            Date tanggalkeluar) {
        this.idpemesanan = idpemesanan;
        this.iduser = iduser;
        this.idkamarkos = idkamarkos;
        this.tanggalpemesanan = tanggalpemesanan;
        this.tanggalmasuk = tanggalmasuk;
        this.tanggalkeluar = tanggalkeluar;
    }

    public void setIdPemesanan(int idpemesanan) {
        this.idpemesanan = idpemesanan;
    }

    public int getIdPemesanan() {
        return idpemesanan;
    }

    public void setIdUser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdUser() {
        return iduser;
    }

    public void setIdKamarkos(int idkamarkos) {
        this.idkamarkos = idkamarkos;
    }

    public int getIdKamarkos() {
        return idkamarkos;
    }

    public void setTanggalPemesanan(Date tanggalpemesanan) {
        this.tanggalpemesanan = tanggalpemesanan;
    }

    public Date getTanggalPemesanan() {
        return tanggalpemesanan;
    }

    public void setTanggalMasuk(Date tanggalmasuk) {
        this.tanggalmasuk = tanggalmasuk;
    }

    public Date getTanggalMasuk() {
        return tanggalmasuk;
    }

    public void setTanggalKeluar(Date tanggalkeluar) {
        this.tanggalkeluar = tanggalkeluar;
    }

    public Date getTanggalKeluar() {
        return tanggalkeluar;
    }
}