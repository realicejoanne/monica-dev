package unpad.rockbottom.monica;

public class FileItem {
    private String textView;
    private int imageResource;

    public FileItem(String textView, int imageResource) {
        this.textView = textView;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTextView() {
        return textView;
    }
    //    Return whether or not there is an image
}
