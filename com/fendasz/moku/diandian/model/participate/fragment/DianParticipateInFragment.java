package com.fendasz.moku.diandian.model.participate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity;
import com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity;
import com.fendasz.moku.diandian.model.participate.DianParticipateFragment;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.helper.AlipayHelper;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.helper.WechatHelper;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.ui.adapter.MyParticipateInAdapter;
import com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;
import com.fendasz.moku.planet.ui.customview.StatusEmptyView;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DianParticipateInFragment extends DianParticipateFragment {
    public static final String MYPARTICIPATEIN_FRAGMENT_TAG = "MYPARTICIPATEIN_FRAGMENT_TAG";
    private static final String TAG = "DianParticipateInFragment";
    private boolean itemClick = false;
    private MyParticipateInAdapter mMyParticipateInAdapter;
    private RefreshableRecyclerView<ClientSampleTaskData> mPullToRefreshView;

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

    private void initData() {
        this.mPullToRefreshView.setTag("MYPARTICIPATEIN_FRAGMENT_TAG");
        MyParticipateInAdapter myParticipateInAdapter = new MyParticipateInAdapter(getActivity(), null);
        this.mMyParticipateInAdapter = myParticipateInAdapter;
        this.mPullToRefreshView.initData(myParticipateInAdapter, new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.diandian.model.participate.fragment.DianParticipateInFragment$$ExternalSyntheticLambda1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public final void refresh() {
                this.f$0.m399x58ab62a6();
            }
        });
    }

    /* renamed from: lambda$initData$0$com-fendasz-moku-diandian-model-participate-fragment-DianParticipateInFragment, reason: not valid java name */
    /* synthetic */ void m399x58ab62a6() {
        ApiDataHelper.getApiDataHelper().dianMyPartInList(getActivity(), this.mPullToRefreshView.getApiDataCallBack());
    }

    private void initListener() {
        this.mMyParticipateInAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() { // from class: com.fendasz.moku.diandian.model.participate.fragment.DianParticipateInFragment$$ExternalSyntheticLambda0
            @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.m400x1a57673b(view, i);
            }
        });
        this.mPullToRefreshView.setStatus(Status.I_KNOW);
        this.mPullToRefreshView.setOnStatusEmptyClickListener(new RefreshableRecyclerView.OnStatusEmptyClickListener() { // from class: com.fendasz.moku.diandian.model.participate.fragment.DianParticipateInFragment.1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.OnStatusEmptyClickListener
            public boolean isInterruptLoadDate() {
                return true;
            }

            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.OnStatusEmptyClickListener
            public void onStatusClick(StatusEmptyView statusEmptyView) {
                DianParticipateInFragment.this.getActivity().finish();
            }
        });
    }

    /* renamed from: lambda$initListener$1$com-fendasz-moku-diandian-model-participate-fragment-DianParticipateInFragment, reason: not valid java name */
    /* synthetic */ void m400x1a57673b(View view, int i) {
        Intent intent;
        if (this.itemClick) {
            return;
        }
        this.itemClick = true;
        if (this.mMyParticipateInAdapter.getData().get(i).getEasy().booleanValue()) {
            applyEasyTask(this.mMyParticipateInAdapter.getData().get(i));
            return;
        }
        Integer taskDataId = this.mMyParticipateInAdapter.getData().get(i).getTaskDataId();
        if (this.mMyParticipateInAdapter.getData().get(i).getCpl() != null && this.mMyParticipateInAdapter.getData().get(i).getCpl().booleanValue()) {
            intent = new Intent(getActivity(), (Class<?>) DianCPLDetailActivity.class);
        } else {
            intent = new Intent(getActivity(), (Class<?>) DianCpaDetailActivity.class);
        }
        intent.putExtra("taskDataId", taskDataId.intValue());
        startActivityForResult(intent, 0);
        this.itemClick = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPullToRefreshView.loadData();
    }

    private void onReady() {
        this.mPullToRefreshView.loadData();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mMyParticipateInAdapter.notifyDataInit();
    }

    private void applyEasyTask(final ClientSampleTaskData clientSampleTaskData) {
        long time = new Date().getTime();
        if (clientSampleTaskData.getEasyTaskType().intValue() == 1 && time < clientSampleTaskData.getNextTime().longValue()) {
            Toast.makeText(requireContext(), "该任务还没有开始哦，试试其他任务吧~", 0).show();
            return;
        }
        LoadingDialog.show(requireContext());
        final Integer easyTaskType = clientSampleTaskData.getEasyTaskType();
        ApiDataHelper.getApiDataHelper().applyEasyTask(requireContext(), Integer.valueOf(easyTaskType.intValue() == 2 ? -2 : clientSampleTaskData.getRecordId().intValue()), clientSampleTaskData.getTaskDataId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.participate.fragment.DianParticipateInFragment.2
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                if (easyTaskType.intValue() == 1) {
                    WechatHelper.getInstance().toMiniProgram(MokuConfigure.getInstance().getMokuOptions(DianParticipateInFragment.this.requireContext()).getString("wxAppId", ""), clientSampleTaskData.getUrl(), DianParticipateInFragment.this.getContext());
                } else {
                    AlipayHelper.getInstance().atformapiartapp(DianParticipateInFragment.this.getActivity(), clientSampleTaskData.getUrl());
                }
                DianParticipateInFragment.this.itemClick = false;
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                Toast.makeText(DianParticipateInFragment.this.requireContext(), "申请失败:" + str, 1).show();
                DianParticipateInFragment.this.itemClick = false;
            }
        });
    }
}
