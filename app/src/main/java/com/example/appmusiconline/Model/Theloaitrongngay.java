package com.example.appmusiconline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;

public class Theloaitrongngay {

@SerializedName("TheLoai")
@Expose
private List<TheLoai> theLoai = null;
@SerializedName("ChuDe")
@Expose
private List<ChuDe> chuDe = null;

public Collection<? extends com.example.appmusiconline.Model.TheLoai> getTheLoai() {
return theLoai;
}

public void setTheLoai(List<TheLoai> theLoai) {
this.theLoai = theLoai;
}

public Collection<? extends com.example.appmusiconline.Model.ChuDe> getChuDe() {
return chuDe;
}

public void setChuDe(List<ChuDe> chuDe) {
this.chuDe = chuDe;
}

}

