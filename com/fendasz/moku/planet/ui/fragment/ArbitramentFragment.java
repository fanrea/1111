package com.fendasz.moku.planet.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.ui.activity.ArbitrationInfoActivity;
import com.fendasz.moku.planet.ui.adapter.TaskRecordDataListAdapter;
import com.fendasz.moku.planet.ui.base.activity.BaseFragment;
import com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ArbitramentFragment extends BaseFragment {
    public static final String ARBITRAMENT_FRAGMENT_TAG = "ARBITRAMENT_FRAGMENT_TAG";
    private static final String TAG = "ArbitramentFragment";
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
        this.mPullToRefreshView.setTag(ARBITRAMENT_FRAGMENT_TAG);
        initListener();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onReady();
    }

    private void onReady() {
        this.mPullToRefreshView.loadData();
    }

    private void initListener() {
        final TaskRecordDataListAdapter taskRecordDataListAdapter = new TaskRecordDataListAdapter(getActivity(), null);
        taskRecordDataListAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() { // from class: com.fendasz.moku.planet.ui.fragment.ArbitramentFragment$$ExternalSyntheticLambda0
            @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.m438xd546644(taskRecordDataListAdapter, view, i);
            }
        });
        this.mPullToRefreshView.setStatus(Status.I_KNOW);
        this.mPullToRefreshView.initData(taskRecordDataListAdapter, new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.planet.ui.fragment.ArbitramentFragment.1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public void refresh() {
                ArbitramentFragment.this.getTaskList();
            }
        });
    }

    /* renamed from: lambda$initListener$0$com-fendasz-moku-planet-ui-fragment-ArbitramentFragment, reason: not valid java name */
    /* synthetic */ void m438xd546644(TaskRecordDataListAdapter taskRecordDataListAdapter, View view, int i) {
        ClientSampleTaskDataRecord clientSampleTaskDataRecord = taskRecordDataListAdapter.getData().get(i);
        int iIntValue = clientSampleTaskDataRecord.getTaskDataId().intValue();
        Intent intent = new Intent(getActivity(), (Class<?>) ArbitrationInfoActivity.class);
        intent.putExtra("taskDataId", iIntValue);
        Integer arbitrationRecordsId = clientSampleTaskDataRecord.getArbitrationRecordsId();
        if (arbitrationRecordsId != null) {
            intent.putExtra("taskRecordId", arbitrationRecordsId.intValue());
        }
        intent.putExtra("taskRecordState", 4);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskList() {
        ApiDataHelper.getApiDataHelper().arbitramentRecordList(getActivity(), this.mPullToRefreshView.getApiDataCallBack());
    }
}
