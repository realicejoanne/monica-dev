package unpad.rockbottom.monica;

public class List_Class {

    String id,
            divisi,
            isiPesan;
    boolean isChecked = false;

    public List_Class() {
    }

    public List_Class(String id, String division, String message, boolean isChecked) {
        this.id = id;
        this.divisi = division;
        this.isiPesan = message;
        this.isChecked = isChecked;
    }

    public String getId() {
        return id;
    }

    public String getDivisi() {
        return divisi;
    }

    public String getIsiPesan() {
        return isiPesan;
    }

    public boolean getIsChecked() {
        return isChecked;
    }
}
