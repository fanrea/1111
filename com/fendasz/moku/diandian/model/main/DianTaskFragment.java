package com.fendasz.moku.diandian.model.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.diandian.commons.MokuDianFragment;
import com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity;
import com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataList;
import com.fendasz.moku.planet.source.bean.ItemConfig;
import com.fendasz.moku.planet.ui.activity.AppealUnblockActivity;
import com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DianTaskFragment extends MokuDianFragment {
    private static final int DEFAULT_PAGE_SIZE = 30;
    private static final int LOAD_MORE_PAGE_SIZE = 30;
    public static final int REQUEST_CODE_FOR_APPEAL = 301;
    public static final int REQUEST_CODE_FOR_MOKU_DETAIL = 200;
    private static final String TAG = "Dian_TaskFragment=>";
    public static final int TOP_MAX_NUM = 8;
    private Integer currentSelectTagId;
    private boolean isAllConfig;
    private boolean ismIsLoadingMore;
    private ItemConfig itemConfig;
    private LinearLayout llRefreshViewContainer;
    private List<ClientSampleTaskData> mClientSampleTaskData;
    private Context mContext;
    private int mPageIndex;
    private RefreshableRecyclerView<ClientSampleTaskData> mPullToRefreshView;
    private int mTag;
    private TaskToBeCompletedDataListAdapter mTaskToBeCompletedDataListAdapter;
    private int mCurrentPage = 1;
    private Integer mTotalPage = 0;
    private boolean mIsLoadingMore = false;
    private int cutInType = -1;
    private boolean isItemClick = false;
    private int loadDateTime = -1;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogUtils.log(TAG, "onCreateView");
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.moku_fragment_dian_task, viewGroup, false);
        this.llRefreshViewContainer = (LinearLayout) frameLayout.findViewById(R.id.ll_refresh_view_container);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getContext();
        this.mPullToRefreshView = new RefreshableRecyclerView<>(getActivity());
        this.llRefreshViewContainer.addView(this.mPullToRefreshView, new LinearLayout.LayoutParams(-1, -1));
        this.mPullToRefreshView.setAppealListener(new RefreshableRecyclerView.AppealListener() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.AppealListener
            public void onAppealClick() {
                LogUtils.logD(DianTaskFragment.TAG, "onAppealClick");
            }
        });
        initData();
        initListener();
        RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView = this.mPullToRefreshView;
        if (refreshableRecyclerView != null) {
            refreshableRecyclerView.loadData();
        }
    }

    private void initData() {
        this.mClientSampleTaskData = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mTag = arguments.getInt("tag");
            this.mPageIndex = arguments.getInt("pageIndex");
            String string = arguments.getString("tagData");
            if (string != null) {
                this.itemConfig = (ItemConfig) JSON.parseObject(string, ItemConfig.class);
            }
            this.cutInType = arguments.getInt("cutInType", this.cutInType);
            this.isAllConfig = arguments.getBoolean("isAllConfig", false);
        }
        this.mTaskToBeCompletedDataListAdapter = new TaskToBeCompletedDataListAdapter(getActivity(), this.mClientSampleTaskData);
    }

    private void initListener() {
        this.mTaskToBeCompletedDataListAdapter.setOnItemClickListener(new TaskToBeCompletedDataListAdapter.OnItemClickListener() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.2
            @Override // com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter.OnItemClickListener
            public void onItemClick(View view, int i) {
                if (DianTaskFragment.this.isItemClick) {
                    return;
                }
                synchronized (this) {
                    DianTaskFragment.this.isItemClick = true;
                    ClientSampleTaskData clientSampleTaskData = (ClientSampleTaskData) DianTaskFragment.this.mClientSampleTaskData.get(i);
                    if (clientSampleTaskData.getSurplusNum().intValue() > 0 || (clientSampleTaskData.getTaskDataApplyRecord() != null && (clientSampleTaskData.getTaskDataApplyRecord().getStatus().equals(MokuConstants.STATUS_OF_APPLYING) || clientSampleTaskData.getTaskDataApplyRecord().getStatus().equals(MokuConstants.STATUS_OF_OVERTIME)))) {
                        if (-1 != DianTaskFragment.this.cutInType) {
                            DianTaskFragment.this.itemLog("1", clientSampleTaskData.getTaskDataId(), DianTaskFragment.this.itemConfig.getItemId().intValue(), DianTaskFragment.this.itemConfig.getTagIdList(), DianTaskFragment.this.currentSelectTagId);
                        }
                        DianTaskFragment.this.gotoDetail(clientSampleTaskData);
                        DianTaskFragment.this.isItemClick = false;
                    } else {
                        DianTaskFragment.this.isItemClick = false;
                    }
                }
            }
        });
        this.mPullToRefreshView.setAdapter(this.mTaskToBeCompletedDataListAdapter);
        this.mPullToRefreshView.setRefreshListener(new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.3
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public void refresh() {
                LogUtils.logD(DianTaskFragment.TAG, "mPullToRefreshView refresh");
                DianTaskFragment.this.mCurrentPage = 1;
                DianTaskFragment.this.mClientSampleTaskData.clear();
                DianTaskFragment.this.mIsLoadingMore = false;
                DianTaskFragment.this.loadData();
            }
        });
        this.mPullToRefreshView.setAppealListener(new RefreshableRecyclerView.AppealListener() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.4
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.AppealListener
            public void onAppealClick() {
                DianTaskFragment.this.getActivity().startActivityForResult(new Intent(DianTaskFragment.this.mContext, (Class<?>) AppealUnblockActivity.class), 301);
            }
        });
        this.mPullToRefreshView.addOnScrollListener(new BaseRecyclerViewScrollListener() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.5
            @Override // com.fendasz.moku.diandian.model.main.DianTaskFragment.BaseRecyclerViewScrollListener
            public void onLoadMore() {
                LogUtils.logD(DianTaskFragment.TAG, "mPullToRefreshView ismIsLoadingMore=>" + DianTaskFragment.this.ismIsLoadingMore);
                if (!DianTaskFragment.this.ismIsLoadingMore) {
                    LogUtils.logD(DianTaskFragment.TAG, "mPullToRefreshView onLoadMore start,mCurrentPage:" + DianTaskFragment.this.mCurrentPage + ",mTotalPage:" + DianTaskFragment.this.mTotalPage);
                    if (DianTaskFragment.this.mCurrentPage < DianTaskFragment.this.mTotalPage.intValue()) {
                        DianTaskFragment.this.ismIsLoadingMore = true;
                        DianTaskFragment.this.mCurrentPage++;
                        LogUtils.logD(DianTaskFragment.TAG, "mPullToRefreshView onLoadMore do it now");
                        TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter = DianTaskFragment.this.mTaskToBeCompletedDataListAdapter;
                        Objects.requireNonNull(DianTaskFragment.this.mTaskToBeCompletedDataListAdapter);
                        taskToBeCompletedDataListAdapter.setLoadState(1);
                        DianTaskFragment.this.loadData();
                        return;
                    }
                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = DianTaskFragment.this.mTaskToBeCompletedDataListAdapter;
                    Objects.requireNonNull(DianTaskFragment.this.mTaskToBeCompletedDataListAdapter);
                    taskToBeCompletedDataListAdapter2.setLoadState(3);
                    LogUtils.logD(DianTaskFragment.TAG, "mPullToRefreshView onLoadMore mCurrentPage:" + DianTaskFragment.this.mCurrentPage + ",mTotalPage:" + DianTaskFragment.this.mTotalPage);
                    return;
                }
                LogUtils.logD(DianTaskFragment.TAG, "mPullToRefreshView onLoadMore ismIsLoadingMore");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        Integer num;
        List<Integer> tagIdList;
        ItemConfig itemConfig = this.itemConfig;
        if (itemConfig != null) {
            Integer itemId = itemConfig.getItemId();
            tagIdList = this.itemConfig.getTagIdList();
            num = itemId;
        } else {
            num = null;
            tagIdList = null;
        }
        this.loadDateTime++;
        LogUtils.logD(TAG, "loadData=>");
        ApiDataHelper.getApiDataHelper().getDianTaskList(getActivity(), this.mCurrentPage, 30, 5, num, tagIdList, this.currentSelectTagId, new ApiDataCallBack<ClientSampleTaskDataList>() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
                LoadingDialog.dismiss();
                DianTaskFragment.this.ismIsLoadingMore = false;
                if (clientSampleTaskDataList != null && clientSampleTaskDataList.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                    DianTaskFragment.this.mTotalPage = clientSampleTaskDataList.getTotalPage();
                    ArrayList arrayList = new ArrayList();
                    for (int size = DianTaskFragment.this.mClientSampleTaskData.size() - 1; size >= 0; size--) {
                        arrayList.add((ClientSampleTaskData) DianTaskFragment.this.mClientSampleTaskData.remove(size));
                        DianTaskFragment.this.mTaskToBeCompletedDataListAdapter.notifyItemRemoved(size);
                    }
                    Collections.reverse(arrayList);
                    arrayList.addAll(clientSampleTaskDataList.getList());
                    DianTaskFragment.this.mClientSampleTaskData.addAll(ApiDataHelper.getApiDataHelper().sortTask(arrayList));
                }
                LogUtils.logD(DianTaskFragment.TAG, "page info_mCurrentPage:" + DianTaskFragment.this.mCurrentPage + ",mTotalPage:" + DianTaskFragment.this.mTotalPage);
                if (DianTaskFragment.this.mCurrentPage >= DianTaskFragment.this.mTotalPage.intValue()) {
                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter = DianTaskFragment.this.mTaskToBeCompletedDataListAdapter;
                    Objects.requireNonNull(DianTaskFragment.this.mTaskToBeCompletedDataListAdapter);
                    taskToBeCompletedDataListAdapter.setLoadState(3);
                } else {
                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = DianTaskFragment.this.mTaskToBeCompletedDataListAdapter;
                    Objects.requireNonNull(DianTaskFragment.this.mTaskToBeCompletedDataListAdapter);
                    taskToBeCompletedDataListAdapter2.setLoadState(2);
                }
                DianTaskFragment.this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
                boolean z = DianTaskFragment.this.mClientSampleTaskData.size() == 0;
                if (DianTaskFragment.this.mPullToRefreshView != null) {
                    DianTaskFragment.this.mPullToRefreshView.setSuccess(i, z);
                }
                DianTaskFragment.this.mIsLoadingMore = false;
                if (DianTaskFragment.this.mClientSampleTaskData != null) {
                    FragmentActivity activity = DianTaskFragment.this.getActivity();
                    if (activity instanceof MokuDianMainActivity) {
                        List<ClientSampleTaskData> list = clientSampleTaskDataList.getList();
                        ArrayList arrayList2 = new ArrayList(8);
                        for (ClientSampleTaskData clientSampleTaskData : list) {
                            if (arrayList2.size() >= 8) {
                                break;
                            } else if (clientSampleTaskData.isTopPosition()) {
                                arrayList2.add(clientSampleTaskData);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            StorageUtils.putHotTaskList(DianTaskFragment.this.mContext, JSON.toJSONString(arrayList2));
                        }
                        ((MokuDianMainActivity) activity).updateDataFlagSuccess();
                    }
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                if (DianTaskFragment.this.mCurrentPage > DianTaskFragment.this.mTotalPage.intValue()) {
                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter = DianTaskFragment.this.mTaskToBeCompletedDataListAdapter;
                    Objects.requireNonNull(DianTaskFragment.this.mTaskToBeCompletedDataListAdapter);
                    taskToBeCompletedDataListAdapter.setLoadState(3);
                } else {
                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = DianTaskFragment.this.mTaskToBeCompletedDataListAdapter;
                    Objects.requireNonNull(DianTaskFragment.this.mTaskToBeCompletedDataListAdapter);
                    taskToBeCompletedDataListAdapter2.setLoadState(2);
                }
                DianTaskFragment.this.ismIsLoadingMore = false;
                DianTaskFragment.this.mIsLoadingMore = false;
                DianTaskFragment.this.getAppeal();
                if (DianTaskFragment.this.mPageIndex == 0) {
                    Toast.makeText(DianTaskFragment.this.getContext(), str, 0).show();
                }
                if (DianTaskFragment.this.mPullToRefreshView != null) {
                    DianTaskFragment.this.mPullToRefreshView.setError(i, str);
                }
                StorageUtils.clearHotTaskList(DianTaskFragment.this.mContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAppeal() {
        LogUtils.logW(TAG, "get appeal");
        ApiDataHelper.getApiDataHelper().getAppeal(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.7
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                LogUtils.logD(DianTaskFragment.TAG, "get appeal success");
                DianTaskFragment.this.mPullToRefreshView.showAppeal();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logD(DianTaskFragment.TAG, "get appeal error,code=>" + i + ",message=>" + str);
                DianTaskFragment.this.mPullToRefreshView.hideAppeal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemLog(String str, Integer num, int i, List<Integer> list, Integer num2) {
        ApiDataHelper.getApiDataHelper().itemLog(this.mContext, str, num, i, list, num2, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.main.DianTaskFragment.8
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i2, Object obj) throws Exception {
                LogUtils.logD(DianTaskFragment.TAG, "itemLog success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i2, String str2) throws Exception {
                LogUtils.logE(DianTaskFragment.TAG, "itemLog_error,msg =>" + str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoDetail(ClientSampleTaskData clientSampleTaskData) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Integer taskDataId = clientSampleTaskData.getTaskDataId();
            Intent intent = null;
            if (clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
                intent = new Intent(activity, (Class<?>) DianCPLDetailActivity.class);
            } else if (clientSampleTaskData.getTaskType() != null && clientSampleTaskData.getTaskType().intValue() == 1) {
                Toast.makeText(activity, "任务配置信息错误，请联系客服处理", 0).show();
            } else {
                intent = new Intent(activity, (Class<?>) DianCpaDetailActivity.class);
            }
            intent.putExtra("taskDataId", taskDataId.intValue());
            String gateType = clientSampleTaskData.getGateType();
            if (!TextUtils.isEmpty(gateType)) {
                intent.putExtra("gateType", gateType);
            }
            intent.putExtra("operationType", 100);
            activity.startActivityForResult(intent, 200);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView;
        Log.d(TAG, "requestCode==>" + i + ",resultCode=>" + i2);
        if (i != 200) {
            if (i == 301) {
                LogUtils.logI(TAG, "on result from appeal unblock");
                if (intent == null || !intent.getBooleanExtra(MokuConstants.INTENT_KEY_UNBLOCKRESULT, false)) {
                    return;
                }
                LogUtils.logI(TAG, "on result from appeal unblock,is unblock success");
                this.mCurrentPage = 1;
                this.mPullToRefreshView.loadData();
                return;
            }
            return;
        }
        if (i2 == 300) {
            RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView2 = this.mPullToRefreshView;
            if (refreshableRecyclerView2 != null) {
                this.mCurrentPage = 1;
                refreshableRecyclerView2.loadData();
                return;
            }
            return;
        }
        if (i2 != 2 || (refreshableRecyclerView = this.mPullToRefreshView) == null) {
            return;
        }
        this.mCurrentPage = 1;
        refreshableRecyclerView.loadData();
    }

    public abstract class BaseRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        private boolean isSlidingUpward = false;

        public abstract void onLoadMore();

        public BaseRecyclerViewScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            boolean z = i2 > 0;
            this.isSlidingUpward = z;
            if (z) {
                if (recyclerView.getLayoutManager().getChildCount() + (recyclerView.getLayoutManager() instanceof LinearLayoutManager ? ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() : 0) + 10 >= recyclerView.getLayoutManager().getItemCount()) {
                    LogUtils.logD(DianTaskFragment.TAG, "onScrolled_mIsLoadingMore:" + DianTaskFragment.this.mIsLoadingMore);
                    if (DianTaskFragment.this.mIsLoadingMore) {
                        return;
                    }
                    LogUtils.logD(DianTaskFragment.TAG, "onScrolled_mIsLoadingMore:" + DianTaskFragment.this.mIsLoadingMore + ",invoke onLoadMore");
                    DianTaskFragment.this.mIsLoadingMore = true;
                    onLoadMore();
                }
            }
        }
    }
}
