package com.example.tracuudiemthi.tracuu.Model;

public class ThongTinModel {
    private String sbd, ma_ngoai_ngu;
    private float toan, ngu_van, ngoai_ngu, vat_li, hoa_hoc, sinh_hoc, lich_su, dia_li, gdcd;
    public ThongTinModel() {}
    public ThongTinModel(String sbd, float toan, float ngu_van, float ngoai_ngu, float vat_li, float hoa_hoc, float sinh_hoc, float lich_su, float dia_li, float gdcd, String ma_ngoai_ngu) {
        this.sbd = sbd;
        this.toan = toan;
        this.ngu_van = ngu_van;
        this.ngoai_ngu = ngoai_ngu;
        this.vat_li = vat_li;
        this.hoa_hoc = hoa_hoc;
        this.sinh_hoc = sinh_hoc;
        this.lich_su = lich_su;
        this.dia_li = dia_li;
        this.gdcd = gdcd;
        this.ma_ngoai_ngu = ma_ngoai_ngu;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getNgu_van() {
        return ngu_van;
    }

    public void setNgu_van(float ngu_van) {
        this.ngu_van = ngu_van;
    }

    public float getNgoai_ngu() {
        return ngoai_ngu;
    }

    public void setNgoai_ngu(float ngoai_ngu) {
        this.ngoai_ngu = ngoai_ngu;
    }

    public float getVat_li() {
        return vat_li;
    }

    public void setVat_li(float vat_li) {
        this.vat_li = vat_li;
    }

    public float getHoa_hoc() {
        return hoa_hoc;
    }

    public void setHoa_hoc(float hoa_hoc) {
        this.hoa_hoc = hoa_hoc;
    }

    public float getSinh_hoc() {
        return sinh_hoc;
    }

    public void setSinh_hoc(float sinh_hoc) {
        this.sinh_hoc = sinh_hoc;
    }

    public float getLich_su() {
        return lich_su;
    }

    public void setLich_su(float lich_su) {
        this.lich_su = lich_su;
    }

    public float getDia_li() {
        return dia_li;
    }

    public void setDia_li(float dia_li) {
        this.dia_li = dia_li;
    }

    public float getGdcd() {
        return gdcd;
    }

    public void setGdcd(float gdcd) {
        this.gdcd = gdcd;
    }

    public String getMa_ngoai_ngu() {
        return ma_ngoai_ngu;
    }

    public void setMa_ngoai_ngu(String ma_ngoai_ngu) {
        this.ma_ngoai_ngu = ma_ngoai_ngu;
    }
}
