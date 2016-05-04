package panda.com.addviewdemo.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by panda on 2016/5/4:19:15.
 *
 * 适配器
 */
public class SQLiteListViewUserAdapter extends SimpleCursorAdapter {

    private Cursor mCursor;

    public SQLiteListViewUserAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        mCursor = c;
    }

    public SQLiteListViewUserAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        mCursor = c;
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return super.getView(position, convertView, parent);
    }
}
