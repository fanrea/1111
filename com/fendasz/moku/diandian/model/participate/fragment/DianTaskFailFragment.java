package com.fendasz.moku.diandian.model.participate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.fendasz.moku.diandian.model.participate.DianParticipateFragment;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.ui.activity.ArbitrationActivity;
import com.fendasz.moku.planet.ui.activity.AuditActivity;
import com.fendasz.moku.planet.ui.adapter.TaskRecordDataListAdapter;
import com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;
import com.fendasz.moku.planet.ui.customview.StatusEmptyView;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DianTaskFailFragment extends DianParticipateFragment {
    private static final String TAG = "DianTaskFailFragment";
    public static final String TASKFAIL_FRAGMENT_TAG = "TASKFAIL_FRAGMENT_TAG";
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
        this.mPullToRefreshView.setTag("TASKFAIL_FRAGMENT_TAG");
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
        taskRecordDataListAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() { // from class: com.fendasz.moku.diandian.model.participate.fragment.DianTaskFailFragment$$ExternalSyntheticLambda0
            @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.m401xbb20abca(taskRecordDataListAdapter, view, i);
            }
        });
        this.mPullToRefreshView.setStatus(Status.I_KNOW);
        this.mPullToRefreshView.initData(taskRecordDataListAdapter, new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.diandian.model.participate.fragment.DianTaskFailFragment.1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public void refresh() {
                DianTaskFailFragment.this.getTaskList();
            }
        });
        this.mPullToRefreshView.setOnStatusEmptyClickListener(new RefreshableRecyclerView.OnStatusEmptyClickListener() { // from class: com.fendasz.moku.diandian.model.participate.fragment.DianTaskFailFragment.2
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.OnStatusEmptyClickListener
            public boolean isInterruptLoadDate() {
                return false;
            }

            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.OnStatusEmptyClickListener
            public void onStatusClick(StatusEmptyView statusEmptyView) {
                DianTaskFailFragment.this.getActivity().finish();
            }
        });
    }

    /* renamed from: lambda$initListener$0$com-fendasz-moku-diandian-model-participate-fragment-DianTaskFailFragment, reason: not valid java name */
    /* synthetic */ void m401xbb20abca(TaskRecordDataListAdapter taskRecordDataListAdapter, View view, int i) {
        ClientSampleTaskDataRecord clientSampleTaskDataRecord = taskRecordDataListAdapter.getData().get(i);
        int iIntValue = clientSampleTaskDataRecord.getTaskDataId().intValue();
        if (1000000000 < iIntValue && iIntValue < 1500000000) {
            Intent intent = new Intent(getActivity(), (Class<?>) ArbitrationActivity.class);
            intent.putExtra("taskDataId", iIntValue);
            intent.putExtra("taskRecordId", clientSampleTaskDataRecord.getSubmitRecordId().intValue());
            intent.putExtra("taskRecordState", 3);
            getActivity().startActivityForResult(intent, 604);
            return;
        }
        if (((FragmentActivity) Objects.requireNonNull(getActivity())).getString(R.string.moku_answer_incorrect_title).equals(taskRecordDataListAdapter.getData().get(i).getTaskDataReviewFailureReason().trim())) {
            return;
        }
        gotoDetail(clientSampleTaskDataRecord.getSubmitRecordId().intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(-1);
        ApiDataHelper.getApiDataHelper().getDianTaskRecordList(getActivity(), arrayList, this.mPullToRefreshView.getApiDataCallBack());
    }

    private void gotoDetail(int i) {
        Intent intent = new Intent(getActivity(), (Class<?>) AuditActivity.class);
        intent.putExtra("submitRecordId", i);
        intent.putExtra("status", MokuConstants.TASK_RECORD_FAIL);
        startActivity(intent);
    }
}
