/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autosaleandpurchasemanagmentsystemfull;

/**
 *
 * @author DANI-PC
 */
public class Recipt {
   private String bname;
   private String bcnic;
   private String baddr;
 private String bno;
   private String sname;
   private  String scnic;
    private String saddr;
    private String sno;
   private  String cname;
    private String ccolor;
    private String cmanu;
    private String cmodel;
   private  String cowner;
   private  String clocation;
   private  String cfeul;
   private  String ctank;
   private  String doip;
    private String cmil;
    private  String date;
    private String price;
    public Recipt(String bname, String bcnic, String baddr, String bno, String sname, String scnic, String saddr, String sno, String cname, String ccolor, String cmanu, String cmodel, String cowner, String clocation, String cfeul, String ctank, String doip, String cmil,String dat,String pric) {
        this.bname = bname;
        this.bcnic = bcnic;
        this.baddr = baddr;
        this.bno = bno;
        this.sname = sname;
        this.scnic = scnic;
        this.saddr = saddr;
        this.sno = sno;
        this.cname = cname;
        this.ccolor = ccolor;
        this.cmanu = cmanu;
        this.cmodel = cmodel;
        this.cowner = cowner;
        this.clocation = clocation;
        this.cfeul = cfeul;
        this.ctank = ctank;
        this.doip = doip;
        this.cmil = cmil;
        this.date=dat;
        this.price=pric;
    }

    public Recipt() {
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBcnic(String bcnic) {
        this.bcnic = bcnic;
    }

    public void setBaddr(String baddr) {
        this.baddr = baddr;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setScnic(String scnic) {
        this.scnic = scnic;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCcolor(String ccolor) {
        this.ccolor = ccolor;
    }

    public void setCmanu(String cmanu) {
        this.cmanu = cmanu;
    }

    public void setCmodel(String cmodel) {
        this.cmodel = cmodel;
    }

    public void setCowner(String cowner) {
        this.cowner = cowner;
    }

    public void setClocation(String clocation) {
        this.clocation = clocation;
    }

    public void setCfeul(String cfeul) {
        this.cfeul = cfeul;
    }

    public void setCtank(String ctank) {
        this.ctank = ctank;
    }

    public void setDoip(String doip) {
        this.doip = doip;
    }

    public void setCmil(String cmil) {
        this.cmil = cmil;
    }

    public String getBname() {
        return bname;
    }

    public String getBcnic() {
        return bcnic;
    }

    public String getBaddr() {
        return baddr;
    }

    public String getBno() {
        return bno;
    }

    public String getSname() {
        return sname;
    }

    public String getScnic() {
        return scnic;
    }

    public String getSaddr() {
        return saddr;
    }

    public String getSno() {
        return sno;
    }

    public String getCname() {
        return cname;
    }

    public String getCcolor() {
        return ccolor;
    }

    public String getCmanu() {
        return cmanu;
    }

    public String getCmodel() {
        return cmodel;
    }

    public String getCowner() {
        return cowner;
    }

    public String getClocation() {
        return clocation;
    }

    public String getCfeul() {
        return cfeul;
    }

    public String getCtank() {
        return ctank;
    }

    public String getDoip() {
        return doip;
    }

    public String getCmil() {
        return cmil;
    }
    
    
}
