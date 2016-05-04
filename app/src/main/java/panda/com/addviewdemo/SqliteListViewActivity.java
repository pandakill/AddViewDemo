package panda.com.addviewdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by panda on 2016/5/4:15:32.
 *
 * SQLite 和 listview 绑定的activity
 */
public class SqliteListViewActivity extends AppCompatActivity {

    private EditText mEditTextView;
    private Button mBtnAddView;
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_sqlite_listview);

        initView();

        afterView();
    }

    private void initView() {
        mEditTextView = (EditText) findViewById(R.id.add_edit);
        mBtnAddView = (Button) findViewById(R.id.add_button);
        mListView = (ListView) findViewById(R.id.listview);
    }

    private void afterView() {
        mBtnAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SqliteListViewActivity.this, mEditTextView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
