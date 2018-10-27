package unpad.rockbottom.monica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class FilesAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<FileItem> file;

    public FilesAdapter(Context mContext, ArrayList<FileItem> file) {
        this.mContext = mContext;
        this.file = file;
    }

    @Override
    public int getCount() {
        return file.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        FileItem fileItemAdapter = file.get(position);
        View gridItemView = view;
        // 2
        if (gridItemView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            gridItemView = layoutInflater.inflate(R.layout.file_list_item, null);
        }
        TextView folderName = (TextView) gridItemView.findViewById(R.id.text_file_grid);
        folderName.setText(fileItemAdapter.getTextView());
        ImageView imageView = (ImageView) gridItemView.findViewById(R.id.grid_image);
        imageView.setImageResource(fileItemAdapter.getImageResource());
//        TextView dummyTextView = new TextView(mContext);
//        dummyTextView.setText(String.valueOf(position));
        return gridItemView;
    }
}
