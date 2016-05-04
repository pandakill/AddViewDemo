package panda.com.addviewdemo.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

import panda.com.addviewdemo.R;

/**
 * Created by panda on 2016/1/7:9:03.
 *
 * 主题的view
 */
public class ViewZhuti extends BaseView {

    private LinearLayout mLLZhuti;
    private ImageView mIVTitle;
    private TextView mTVTitle;
    private ImageView mIVContent;

    private HashMap<String, Object> objectHashMap = null;

    public ViewZhuti(Context context, Object obj) {
        super(context, obj);
    }

    @Override
    public void onCreate() {

        setContentView(R.layout.view_zhuti);

        if (mParams instanceof HashMap) {
            objectHashMap = (HashMap<String, Object>) mParams;
        }

        super.onCreate();
    }

    @Override
    public void initView() {
        mLLZhuti = (LinearLayout) mView;
        mIVTitle = (ImageView) mView.findViewById(R.id.iv_title);
        mTVTitle = (TextView) mView.findViewById(R.id.tv_title);
        mIVContent = (ImageView) mView.findViewById(R.id.iv_content);
    }

    @Override
    public void afterView() {
        if (objectHashMap != null) {
            mTVTitle.setText(objectHashMap.get("title").toString());
            mIVTitle.setBackgroundColor((int) objectHashMap.get("color_id"));
        }

        mIVContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnViewClickListener.onClick(CLICK_ZHUTI_IMAGE, null);
            }
        });
    }
}
