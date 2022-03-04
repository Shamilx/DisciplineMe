package com.shamil.DisciplineMe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends BaseAdapter {


    List<String> lines;
    LayoutInflater inflater;
    Context context;

    public CustomAdapter(Context _context, List<String> _lines) {
        this.lines = _lines;
        this.context = _context;
    }

    @Override
    public int getCount() {
        return lines.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = LayoutInflater.from(context);
        View line = inflater.inflate(R.layout.list_view_style,null);
        String myLine =  lines.get(i);

        TextView header = line.findViewById(R.id.header_title);
        header.setText(myLine);

        return line;
    }
}
