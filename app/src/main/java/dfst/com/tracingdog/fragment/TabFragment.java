package dfst.com.tracingdog.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dfst.com.tracingdog.manager.DBManager;
import dfst.com.tracingdog.manager.HttpManager;
import dfst.com.tracingdog.activity.BaseFragmentActivity;

/**
 * Created by yanfei on 2016-10-25.
 */
public abstract class TabFragment extends Fragment {
    protected DBManager dbManager;
    protected HttpManager httpManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dbManager = ((BaseFragmentActivity) getActivity()).getDbManager();
        httpManager = ((BaseFragmentActivity) getActivity()).getHttpManager();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
