package com.fendasz.moku.planet.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.ui.activity.ArbitrationActivity;
import com.fendasz.moku.planet.ui.activity.AuditActivity;
import com.fendasz.moku.planet.ui.adapter.TaskRecordDataListAdapter;
import com.fendasz.moku.planet.ui.base.activity.BaseFragment;
import com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class UnderReviewFragment extends BaseFragment {
    private static final String TAG = "UnderReviewFragment";
    public static final String UNDERREVIEW_FRAGMENT_TAG = "UNDERREVIEW_FRAGMENT_TAG";
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
        initData();
        initListener();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPullToRefreshView.loadData();
    }

    private void onReady() {
        this.mPullToRefreshView.loadData();
    }

    private void initListener() {
        final TaskRecordDataListAdapter taskRecordDataListAdapter = new TaskRecordDataListAdapter(getActivity(), null);
        taskRecordDataListAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() { // from class: com.fendasz.moku.planet.ui.fragment.UnderReviewFragment$$ExternalSyntheticLambda0
            @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.m442xb10ec54b(taskRecordDataListAdapter, view, i);
            }
        });
        this.mPullToRefreshView.setStatus(Status.I_KNOW);
        this.mPullToRefreshView.initData(taskRecordDataListAdapter, new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.planet.ui.fragment.UnderReviewFragment.1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public void refresh() {
                UnderReviewFragment.this.getTaskList();
            }
        });
    }

    /* renamed from: lambda$initListener$0$com-fendasz-moku-planet-ui-fragment-UnderReviewFragment, reason: not valid java name */
    /* synthetic */ void m442xb10ec54b(TaskRecordDataListAdapter taskRecordDataListAdapter, View view, int i) {
        gotoDetail(taskRecordDataListAdapter.getData().get(i));
    }

    private void initData() {
        this.mPullToRefreshView.setTag(UNDERREVIEW_FRAGMENT_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        ApiDataHelper.getApiDataHelper().getTaskRecordList(getActivity(), arrayList, this.mPullToRefreshView.getApiDataCallBack());
    }

    private void gotoDetail(ClientSampleTaskDataRecord clientSampleTaskDataRecord) {
        int iIntValue = clientSampleTaskDataRecord.getTaskDataId().intValue();
        if (1000000000 < iIntValue && iIntValue < 1500000000) {
            Intent intent = new Intent(getActivity(), (Class<?>) ArbitrationActivity.class);
            intent.putExtra("taskDataId", iIntValue);
            intent.putExtra("taskRecordId", clientSampleTaskDataRecord.getSubmitRecordId().intValue());
            intent.putExtra("taskRecordState", 1);
            getActivity().startActivityForResult(intent, 604);
            return;
        }
        Intent intent2 = new Intent(getActivity(), (Class<?>) AuditActivity.class);
        intent2.putExtra("submitRecordId", clientSampleTaskDataRecord.getSubmitRecordId().intValue());
        intent2.putExtra("status", MokuConstants.TASK_RECORD_UNDER_REVIEW);
        startActivity(intent2);
    }
}
