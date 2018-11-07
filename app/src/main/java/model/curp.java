package model;

public class curp {
    private String Ap;
    private String Am;
    private String name;
    private String sx;
    private String date;
    private String estado;

    public curp(){
this.Ap = Ap;
        this.Am = Am;
        this.name = name;
        this.date = date;
        this.estado = estado;

    }

    public String getAp() {
        return Ap;
    }

    public void setAp(String ap) {
        Ap = ap;
    }

    public String getAm() {
        return Am;
    }

    public void setAm(String am) {
        Am = am;
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
