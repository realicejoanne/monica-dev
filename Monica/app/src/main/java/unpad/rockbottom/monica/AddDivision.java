package unpad.rockbottom.monica;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AddDivision {
    private String textViewInEditText;

    public AddDivision(String textViewInEditText) {
        this.textViewInEditText = textViewInEditText;
    }

    public String getTextViewInEditText() {
        return textViewInEditText;
    }

    public void setTextViewInEditText(String textViewInEditText) {
        this.textViewInEditText = textViewInEditText;
    }
}
