package panda.com.addviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;

import panda.com.addviewdemo.view.BaseView;
import panda.com.addviewdemo.view.ViewZhuti;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mContentView;
    private Button mButtonAdd;

    private ViewZhuti mZhuti;

    private HashMap<String, Object> params = new HashMap<>();

    private static int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mContentView = (LinearLayout) findViewById(R.id.main_content);
        mButtonAdd = (Button) findViewById(R.id.button_addview);

        params.put("title", "测试的主题哦哦哦哦");
        params.put("color_id", getResources().getColor(R.color.colorAccent));

        mZhuti = new ViewZhuti(this, params);

        afterView();
    }

    private void afterView() {
        mButtonAdd.setOnClickListener(onClickListener);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mZhuti.getView().getParent() != null) {
                params.put("title", "测试测试testtest-----count = " + count);
                if (count % 2 == 0) {
                    params.put("color_id", getResources().getColor(R.color.colorPrimary));
                } else {
                    params.put("color_id", getResources().getColor(R.color.colorAccent));
                }

                mZhuti = new ViewZhuti(MainActivity.this, params);
            }
            if (count == 4) {
                mContentView.addView(mZhuti.getView(), 0);
            } else {
                mContentView.addView(mZhuti.getView());
            }
            mZhuti.setOnViewClickListener(onViewClickListener);
            count ++;
        }
    };

    private BaseView.OnViewClickListener onViewClickListener = new BaseView.OnViewClickListener() {
        @Override
        public void onClick(int type, Object obj) {
            switch (type) {
                case BaseView.CLICK_ZHUTI_IMAGE:
                    Toast.makeText(MainActivity.this, "点击了content_view", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SqliteListViewActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
