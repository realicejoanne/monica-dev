package unpad.rockbottom.monica;

public class List_Class {
    String divisi,
            isiPesan;
    boolean isChecked = false;

    public List_Class(String division, String message, boolean isChecked) {
        this.divisi = division;
        this.isiPesan = message;
        this.isChecked = isChecked;
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
