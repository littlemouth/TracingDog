package dfst.com.tracingdog.fragment;

import android.content.res.ObbInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.manager.DBManager;
import dfst.com.tracingdog.manager.HttpManager;
import dfst.com.tracingdog.activity.BaseFragmentActivity;
import dfst.com.tracingdog.widget.DogLoadingView;

/**
 * Created by yanfei on 2016-10-25.
 */
public abstract class TabFragment extends Fragment {
    private boolean isLoaded = false;
    protected boolean isInit = false;
    protected DBManager dbManager;
    protected HttpManager httpManager;
    protected DogLoadingView loadingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dbManager = ((BaseFragmentActivity) getActivity()).getDbManager();
        httpManager = ((BaseFragmentActivity) getActivity()).getHttpManager();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isLoaded && isInit) {
            loadingView = new DogLoadingView(getContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            loadingView.setLayoutParams(params);
            loadingView.setBackgroundResource(R.drawable.loading_dog);
            ((ViewGroup)getView()).addView(loadingView);
            asyncTask.execute();
            isLoaded = true;
        }
    }

    /**
     * show loading
     */
    protected void loadingShow() {
        if (loadingView != null)
            loadingView.show();
    }

    /**
     * hide loading
     */
    protected void loadingHide() {
        if (loadingView != null)
            loadingView.hide();
    }

    protected void onFirstVisibleHeavyTask() {}

    protected void onFirstVisibleUiRefresh() {}

    private AsyncTask asyncTask = new AsyncTask<Object, Integer, Object>() {
        @Override
        protected void onPreExecute() {
            loadingShow();
        }

        @Override
        protected Void doInBackground(Object... params) {
            onFirstVisibleHeavyTask();
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            onFirstVisibleUiRefresh();
            loadingHide();
        }
    };
}
