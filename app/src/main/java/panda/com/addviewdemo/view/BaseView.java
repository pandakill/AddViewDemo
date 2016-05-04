package panda.com.addviewdemo.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by panda on 2016/1/7:9:27.
 *
 * 基础view
 */
public abstract class BaseView {

    protected View mView;
    protected Context mContext;

    protected int mResoulseID = -1;
    protected ViewGroup mViewGroup = null;

    protected Object mParams;

    protected OnViewClickListener mOnViewClickListener;

    public final static int CLICK_ZHUTI_IMAGE = 100;

    public BaseView (Context context, Object object) {
        mContext = context;
        mParams = object;

        onCreate();
    }

    public interface OnViewClickListener {
        void onClick(int type, Object obj);
    }

    public void onCreate() {

        initView();
        afterView();
    }

    public void setContentView(int resoulseID) {
        mResoulseID = resoulseID;
        mView = View.inflate(mContext, mResoulseID, null);
    }

    public void setContentView(int resoulseID, ViewGroup params) {
        mResoulseID = resoulseID;
        mViewGroup = params;

        mView = View.inflate(mContext, mResoulseID, mViewGroup);
    }

    public int getResoulseID() {
        return mResoulseID;
    }

    public void setOnViewClickListener(OnViewClickListener clickListener) {
        mOnViewClickListener = clickListener;
    }

    /**
     * 初始化view方法
     */
    public abstract void initView();

    public abstract void afterView();

    public View getView() {
        return mView;
    }
}
