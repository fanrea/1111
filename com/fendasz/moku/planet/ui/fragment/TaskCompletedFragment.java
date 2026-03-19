package com.fendasz.moku.planet.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.ui.adapter.TaskRecordDataListAdapter;
import com.fendasz.moku.planet.ui.base.activity.BaseFragment;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskCompletedFragment extends BaseFragment {
    private static final String TAG = "TaskCompletedFragment";
    public static final String TASKCOMPLETED_FRAGMENT_TAG = "TASKCOMPLETED_FRAGMENT_TAG";
    private RefreshableRecyclerView<ClientSampleTaskDataRecord> mPullToRefreshView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.moku_fragment_pull_refresh_view, viewGroup, false);
        this.mPullToRefreshView = (RefreshableRecyclerView) viewInflate.findViewById(R.id.refresh_view);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mPullToRefreshView.setTag("TASKCOMPLETED_FRAGMENT_TAG");
        initListener();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPullToRefreshView.loadData();
    }

    private void onReady() {
        this.mPullToRefreshView.setTag("TASKCOMPLETED_FRAGMENT_TAG");
        this.mPullToRefreshView.loadData();
    }

    private void initListener() {
        TaskRecordDataListAdapter taskRecordDataListAdapter = new TaskRecordDataListAdapter(getActivity(), null);
        this.mPullToRefreshView.setStatus(Status.I_KNOW);
        this.mPullToRefreshView.initData(taskRecordDataListAdapter, new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.planet.ui.fragment.TaskCompletedFragment.1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public void refresh() {
                TaskCompletedFragment.this.getTaskList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        ApiDataHelper.getApiDataHelper().getTaskRecordList(getActivity(), arrayList, this.mPullToRefreshView.getApiDataCallBack());
    }
}
