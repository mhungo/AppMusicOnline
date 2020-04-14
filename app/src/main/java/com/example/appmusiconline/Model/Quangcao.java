package com.example.appmusiconline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quangcao implements Serializable {

@SerializedName("IdQuangcao")
@Expose
private String idQuangcao;
@SerializedName("Hinhanh")
@Expose
private String hinhanh;
@SerializedName("Noidung")
@Expose
private String noidung;
@SerializedName("IdBaihat")
@Expose
private String idBaihat;
@SerializedName("Tenbaihat")
@Expose
private String tenbaihat;
@SerializedName("HinhBaihat")
@Expose
private String hinhBaihat;

public String getIdQuangcao() {
return idQuangcao;
}

public void setIdQuangcao(String idQuangcao) {
this.idQuangcao = idQuangcao;
}

public String getHinhanh() {
return hinhanh;
}

public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

public String getNoidung() {
return noidung;
}

public void setNoidung(String noidung) {
this.noidung = noidung;
}

public String getIdBaihat() {
return idBaihat;
}

public void setIdBaihat(String idBaihat) {
this.idBaihat = idBaihat;
}

public String getTenbaihat() {
return tenbaihat;
}

public void setTenbaihat(String tenbaihat) {
this.tenbaihat = tenbaihat;
}

public String getHinhBaihat() {
return hinhBaihat;
}

public void setHinhBaihat(String hinhBaihat) {
this.hinhBaihat = hinhBaihat;
}

}