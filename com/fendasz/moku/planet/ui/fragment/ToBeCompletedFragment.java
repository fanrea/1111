package com.fendasz.moku.planet.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.helper.AlipayHelper;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.helper.WechatHelper;
import com.fendasz.moku.planet.interf.observer.TagObserver;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataList;
import com.fendasz.moku.planet.source.bean.ItemConfig;
import com.fendasz.moku.planet.source.bean.TagForm;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.ui.activity.AppealUnblockActivity;
import com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity;
import com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity;
import com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity;
import com.fendasz.moku.planet.ui.activity.TaskDetailActivity;
import com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter;
import com.fendasz.moku.planet.ui.base.activity.BaseFragment;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ToBeCompletedFragment extends BaseFragment implements TagObserver {
    private static final int DEFAULT_PAGE_SIZE = 30;
    private static final int LOAD_MORE_PAGE_SIZE = 30;
    public static final int REQUEST_CODE_FOR_APPEAL = 301;
    public static final int REQUEST_CODE_FOR_MOKU_DETAIL = 200;
    public static final int REQUEST_COED_FOR_EASYTASK = 201;
    private static final String TAG = "ToBeCompletedFragment";
    private Integer currentSelectTagId;
    private boolean isAllConfig;
    private boolean isClickEasy;
    private ItemConfig itemConfig;
    private LinearLayout llRefreshViewContainer;
    private List<ClientSampleTaskData> mClientSampleTaskData;
    private Context mContext;
    private int mPageIndex;
    private RefreshableRecyclerView<ClientSampleTaskData> mPullToRefreshView;
    private int mTag;
    private TaskToBeCompletedDataListAdapter mTaskToBeCompletedDataListAdapter;
    private TextView tvAppeal;
    private int mCurrentPage = 0;
    private Integer mTotalPage = 0;
    private boolean mIsLoadingMore = false;
    private boolean isItemClick = false;
    private int cutInType = -1;

    static /* synthetic */ int access$1008(ToBeCompletedFragment toBeCompletedFragment) {
        int i = toBeCompletedFragment.mCurrentPage;
        toBeCompletedFragment.mCurrentPage = i + 1;
        return i;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogUtils.log(TAG, "onCreateView");
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.moku_fragment_to_be_completed, viewGroup, false);
        this.llRefreshViewContainer = (LinearLayout) frameLayout.findViewById(R.id.ll_refresh_view_container);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LogUtils.log(TAG, "onActivityCreated");
        initLoad();
        initView();
        initData();
        initListener();
        onReady();
    }

    private void onReady() {
        RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView = this.mPullToRefreshView;
        if (refreshableRecyclerView != null) {
            refreshableRecyclerView.loadData();
        }
    }

    private void initLoad() {
        this.mContext = getContext();
    }

    private void initView() {
        this.mPullToRefreshView = new RefreshableRecyclerView<>(getActivity());
        this.llRefreshViewContainer.addView(this.mPullToRefreshView, new LinearLayout.LayoutParams(-1, -1));
        this.mPullToRefreshView.setAppealListener(new RefreshableRecyclerView.AppealListener() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.1
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.AppealListener
            public void onAppealClick() {
                ToBeCompletedFragment.this.getActivity().startActivityForResult(new Intent(ToBeCompletedFragment.this.mContext, (Class<?>) AppealUnblockActivity.class), 301);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtils.logD(TAG, "isClickEasy=" + this.isClickEasy);
        if (this.isClickEasy) {
            List<ClientSampleTaskData> list = this.mClientSampleTaskData;
            if (list != null && list.size() > 0) {
                List<ClientSampleTaskData> list2 = this.mClientSampleTaskData;
                list2.removeAll(list2);
            }
            this.mPullToRefreshView.loadData();
            this.isClickEasy = false;
        }
    }

    private void initListener() {
        this.mTaskToBeCompletedDataListAdapter.setOnItemClickListener(new TaskToBeCompletedDataListAdapter.OnItemClickListener() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.2
            @Override // com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter.OnItemClickListener
            public void onItemClick(View view, int i) {
                if (ToBeCompletedFragment.this.isItemClick) {
                    return;
                }
                synchronized (this) {
                    ToBeCompletedFragment.this.isItemClick = true;
                    ClientSampleTaskData clientSampleTaskData = (ClientSampleTaskData) ToBeCompletedFragment.this.mClientSampleTaskData.get(i);
                    if (clientSampleTaskData.getSurplusNum().intValue() > 0 || (clientSampleTaskData.getTaskDataApplyRecord() != null && (clientSampleTaskData.getTaskDataApplyRecord().getStatus().equals(MokuConstants.STATUS_OF_APPLYING) || clientSampleTaskData.getTaskDataApplyRecord().getStatus().equals(MokuConstants.STATUS_OF_OVERTIME)))) {
                        if (-1 != ToBeCompletedFragment.this.cutInType) {
                            ToBeCompletedFragment.this.itemLog("1", clientSampleTaskData.getTaskDataId(), ToBeCompletedFragment.this.itemConfig.getItemId().intValue(), ToBeCompletedFragment.this.itemConfig.getTagIdList(), ToBeCompletedFragment.this.currentSelectTagId);
                        }
                        if (!clientSampleTaskData.getEasy().booleanValue()) {
                            ToBeCompletedFragment.this.gotoDetail(clientSampleTaskData);
                            ToBeCompletedFragment.this.isItemClick = false;
                        } else if (3 == clientSampleTaskData.getEasyTaskType().intValue()) {
                            ToBeCompletedFragment.this.gotoEasyTask(clientSampleTaskData);
                            ToBeCompletedFragment.this.isItemClick = false;
                        } else {
                            ToBeCompletedFragment.this.applyEasyTask(clientSampleTaskData);
                        }
                    } else {
                        ToBeCompletedFragment.this.isItemClick = false;
                    }
                }
            }
        });
        this.mPullToRefreshView.setAdapter(this.mTaskToBeCompletedDataListAdapter);
        this.mPullToRefreshView.setRefreshListener(new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.3
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public void refresh() {
                ToBeCompletedFragment.this.mCurrentPage = 0;
                ToBeCompletedFragment.this.getTaskListV3(false);
            }
        });
        this.mPullToRefreshView.addOnScrollListener(new AnonymousClass4());
    }

    /* renamed from: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment$4, reason: invalid class name */
    class AnonymousClass4 extends BaseRecyclerViewScrollListener {
        AnonymousClass4() {
            super();
        }

        @Override // com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.BaseRecyclerViewScrollListener
        public void onLoadMore() {
            ToBeCompletedFragment.this.mIsLoadingMore = true;
            TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
            Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
            taskToBeCompletedDataListAdapter.setLoadState(1);
            HandlerThread handlerThread = new HandlerThread(System.currentTimeMillis() + "");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).postDelayed(new Runnable() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ToBeCompletedFragment.this.cutInType == -1) {
                        ApiDataHelper.getApiDataHelper().getPagedTaskList(ToBeCompletedFragment.this.getActivity(), ToBeCompletedFragment.this.mCurrentPage, 30, ToBeCompletedFragment.this.mTag, new ApiDataCallBack<ClientSampleTaskDataList>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.4.1.1
                            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                            public void success(int i, ClientSampleTaskDataList clientSampleTaskDataList) {
                                if (clientSampleTaskDataList != null && clientSampleTaskDataList.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    ToBeCompletedFragment.access$1008(ToBeCompletedFragment.this);
                                    for (int size = ToBeCompletedFragment.this.mClientSampleTaskData.size() - 1; size >= 0; size--) {
                                        arrayList.add((ClientSampleTaskData) ToBeCompletedFragment.this.mClientSampleTaskData.remove(size));
                                        ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyItemRemoved(size);
                                    }
                                    Collections.reverse(arrayList);
                                    arrayList.addAll(clientSampleTaskDataList.getList());
                                    ToBeCompletedFragment.this.mClientSampleTaskData.addAll(ApiDataHelper.getApiDataHelper().sortTask(arrayList));
                                }
                                if (ToBeCompletedFragment.this.mCurrentPage > ToBeCompletedFragment.this.mTotalPage.intValue()) {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter2.setLoadState(3);
                                } else {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter3 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter3.setLoadState(2);
                                }
                                ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
                                ToBeCompletedFragment.this.mIsLoadingMore = false;
                            }

                            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                            public void error(int i, String str) {
                                if (ToBeCompletedFragment.this.mCurrentPage > ToBeCompletedFragment.this.mTotalPage.intValue()) {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter2.setLoadState(3);
                                } else {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter3 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter3.setLoadState(2);
                                }
                                ToBeCompletedFragment.this.mIsLoadingMore = false;
                            }
                        });
                    } else {
                        ApiDataHelper.getApiDataHelper().getPagedTaskList3(ToBeCompletedFragment.this.getActivity(), ToBeCompletedFragment.this.mCurrentPage, 30, ToBeCompletedFragment.this.mTag, ToBeCompletedFragment.this.itemConfig.getItemId().intValue(), ToBeCompletedFragment.this.itemConfig.getTagIdList(), ToBeCompletedFragment.this.currentSelectTagId, new ApiDataCallBack<ClientSampleTaskDataList>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.4.1.2
                            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                            public void success(int i, ClientSampleTaskDataList clientSampleTaskDataList) {
                                if (clientSampleTaskDataList != null && clientSampleTaskDataList.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    ToBeCompletedFragment.access$1008(ToBeCompletedFragment.this);
                                    for (int size = ToBeCompletedFragment.this.mClientSampleTaskData.size() - 1; size >= 0; size--) {
                                        arrayList.add((ClientSampleTaskData) ToBeCompletedFragment.this.mClientSampleTaskData.remove(size));
                                        ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyItemRemoved(size);
                                    }
                                    Collections.reverse(arrayList);
                                    arrayList.addAll(clientSampleTaskDataList.getList());
                                    ToBeCompletedFragment.this.mClientSampleTaskData.addAll(ApiDataHelper.getApiDataHelper().sortTask(arrayList));
                                }
                                if (ToBeCompletedFragment.this.mCurrentPage > ToBeCompletedFragment.this.mTotalPage.intValue()) {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter2.setLoadState(3);
                                } else {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter3 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter3.setLoadState(2);
                                }
                                ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
                                ToBeCompletedFragment.this.mIsLoadingMore = false;
                            }

                            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                            public void error(int i, String str) {
                                if (ToBeCompletedFragment.this.mCurrentPage > ToBeCompletedFragment.this.mTotalPage.intValue()) {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter2.setLoadState(3);
                                } else {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter3 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter3.setLoadState(2);
                                }
                                ToBeCompletedFragment.this.mIsLoadingMore = false;
                            }
                        });
                    }
                }
            }, 500L);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoDetail(ClientSampleTaskData clientSampleTaskData) {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.isClickEasy = false;
            Integer taskDataId = clientSampleTaskData.getTaskDataId();
            if (clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
                intent = new Intent(activity, (Class<?>) GameTaskDetailActivity.class);
            } else if (clientSampleTaskData.getTaskType() != null && clientSampleTaskData.getTaskType().intValue() == 1) {
                intent = new Intent(activity, (Class<?>) RewardTaskDetailActivity.class);
            } else {
                intent = new Intent(activity, (Class<?>) TaskDetailActivity.class);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoEasyTask(ClientSampleTaskData clientSampleTaskData) throws NoSuchMethodException, SecurityException {
        if (getActivity() != null) {
            LoadingDialog.show(this.mContext);
            MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, Integer.valueOf(clientSampleTaskData.getTaskId()));
            MokuConfigure.getInstance().updateUserType(this.mContext, 4);
            ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.5
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, Object obj) throws Exception {
                    Log.d(ToBeCompletedFragment.TAG, "upload device info success");
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LogUtils.logE(ToBeCompletedFragment.TAG, "upload device info error,code=>" + i + ",message" + str);
                }
            });
            ApiDataHelper.getApiDataHelper().beginEasyCollection(clientSampleTaskData.getCollectionDataId(), this.mContext, new ApiDataCallBack<EasyCollectionEntity>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.6
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, EasyCollectionEntity easyCollectionEntity) throws Exception {
                    LoadingDialog.dismiss();
                    Intent intent = new Intent(ToBeCompletedFragment.this.mContext, (Class<?>) EasyCollectionDetailActivity.class);
                    intent.putExtra("taskInfo", JSON.toJSONString(easyCollectionEntity));
                    ToBeCompletedFragment.this.startActivityForResult(intent, 201);
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    Toast.makeText(ToBeCompletedFragment.this.mContext, str + i, 1).show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskListV3(final boolean z) {
        Log.d(TAG, "getTaskListV3==>" + z);
        if (z) {
            LoadingDialog.show(getActivity());
        }
        if (this.cutInType != -1) {
            long j = this.mPageIndex * 1000;
            HandlerThread handlerThread = new HandlerThread(System.currentTimeMillis() + "");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).postDelayed(new Runnable() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    ToBeCompletedFragment.this.mCurrentPage = 1;
                    ApiDataHelper.getApiDataHelper().getPagedTaskList3(ToBeCompletedFragment.this.getActivity(), ToBeCompletedFragment.this.mCurrentPage, 30, ToBeCompletedFragment.this.mTag, ToBeCompletedFragment.this.itemConfig.getItemId().intValue(), ToBeCompletedFragment.this.itemConfig.getTagIdList(), ToBeCompletedFragment.this.currentSelectTagId, new ApiDataCallBack<ClientSampleTaskDataList>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.7.1
                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void success(int i, ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
                            if (z) {
                                LoadingDialog.dismiss();
                            }
                            int size = ToBeCompletedFragment.this.mClientSampleTaskData.size();
                            ToBeCompletedFragment.this.mClientSampleTaskData.clear();
                            ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyItemRangeRemoved(0, size);
                            if (clientSampleTaskDataList != null && clientSampleTaskDataList.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                                ToBeCompletedFragment.access$1008(ToBeCompletedFragment.this);
                                ToBeCompletedFragment.this.mTotalPage = clientSampleTaskDataList.getTotalPage();
                                ToBeCompletedFragment.this.mClientSampleTaskData.addAll(ApiDataHelper.getApiDataHelper().sortTask(clientSampleTaskDataList.getList()));
                                if (ToBeCompletedFragment.this.mCurrentPage > ToBeCompletedFragment.this.mTotalPage.intValue()) {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter.setLoadState(3);
                                } else {
                                    TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                    Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                    taskToBeCompletedDataListAdapter2.setLoadState(2);
                                }
                                ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
                            }
                            boolean z2 = ToBeCompletedFragment.this.mClientSampleTaskData.size() == 0;
                            if (ToBeCompletedFragment.this.mPullToRefreshView != null) {
                                ToBeCompletedFragment.this.mPullToRefreshView.setSuccess(i, z2);
                            }
                        }

                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void error(int i, String str) throws Exception {
                            ToBeCompletedFragment.this.getAppeal();
                            if (z) {
                                LoadingDialog.dismiss();
                            }
                            ToBeCompletedFragment.this.mClientSampleTaskData.clear();
                            ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
                            if (ToBeCompletedFragment.this.mPageIndex == 0) {
                                Toast.makeText(ToBeCompletedFragment.this.getContext(), str, 0).show();
                            }
                            if (ToBeCompletedFragment.this.mPullToRefreshView != null) {
                                ToBeCompletedFragment.this.mPullToRefreshView.setError(i, str);
                            }
                        }
                    });
                }
            }, j);
            return;
        }
        long j2 = this.mPageIndex * 1000;
        HandlerThread handlerThread2 = new HandlerThread(System.currentTimeMillis() + "");
        handlerThread2.start();
        new Handler(handlerThread2.getLooper()).postDelayed(new Runnable() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.8
            @Override // java.lang.Runnable
            public void run() {
                ToBeCompletedFragment.this.mCurrentPage = 1;
                ApiDataHelper.getApiDataHelper().getPagedTaskList(ToBeCompletedFragment.this.getActivity(), ToBeCompletedFragment.this.mCurrentPage, 30, ToBeCompletedFragment.this.mTag, new ApiDataCallBack<ClientSampleTaskDataList>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.8.1
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i, ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
                        if (z) {
                            LoadingDialog.dismiss();
                        }
                        int size = ToBeCompletedFragment.this.mClientSampleTaskData.size();
                        ToBeCompletedFragment.this.mClientSampleTaskData.clear();
                        ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyItemRangeRemoved(0, size);
                        if (clientSampleTaskDataList != null && clientSampleTaskDataList.getList() != null) {
                            ToBeCompletedFragment.access$1008(ToBeCompletedFragment.this);
                            ToBeCompletedFragment.this.mTotalPage = clientSampleTaskDataList.getTotalPage();
                            ToBeCompletedFragment.this.mClientSampleTaskData.addAll(ApiDataHelper.getApiDataHelper().sortTask(clientSampleTaskDataList.getList()));
                            if (ToBeCompletedFragment.this.mCurrentPage > ToBeCompletedFragment.this.mTotalPage.intValue()) {
                                TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                taskToBeCompletedDataListAdapter.setLoadState(3);
                            } else {
                                TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter2 = ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter;
                                Objects.requireNonNull(ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter);
                                taskToBeCompletedDataListAdapter2.setLoadState(2);
                            }
                            ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
                        }
                        boolean z2 = ToBeCompletedFragment.this.mClientSampleTaskData.size() == 0;
                        if (ToBeCompletedFragment.this.mPullToRefreshView != null) {
                            ToBeCompletedFragment.this.mPullToRefreshView.setSuccess(i, z2);
                        }
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i, String str) throws Exception {
                        if (z) {
                            LoadingDialog.dismiss();
                        }
                        ToBeCompletedFragment.this.mClientSampleTaskData.clear();
                        ToBeCompletedFragment.this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
                        if (ToBeCompletedFragment.this.mPageIndex == 0) {
                            Toast.makeText(ToBeCompletedFragment.this.getContext(), str, 0).show();
                        }
                        if (ToBeCompletedFragment.this.mPullToRefreshView != null) {
                            ToBeCompletedFragment.this.mPullToRefreshView.setError(i, str);
                        }
                    }
                });
            }
        }, j2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView;
        RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView2;
        String str = TAG;
        Log.d(str, "requestCode==>" + i + ",resultCode=>" + i2);
        if (i == 200) {
            if (i2 == 300) {
                RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView3 = this.mPullToRefreshView;
                if (refreshableRecyclerView3 != null) {
                    refreshableRecyclerView3.loadData();
                    return;
                }
                return;
            }
            if (i2 != 2 || (refreshableRecyclerView2 = this.mPullToRefreshView) == null) {
                return;
            }
            refreshableRecyclerView2.loadData();
            return;
        }
        if (i != 301) {
            if (201 != i || (refreshableRecyclerView = this.mPullToRefreshView) == null) {
                return;
            }
            refreshableRecyclerView.loadData();
            return;
        }
        LogUtils.logI(str, "on result from appeal unblock");
        if (intent == null || !intent.getBooleanExtra(MokuConstants.INTENT_KEY_UNBLOCKRESULT, false)) {
            return;
        }
        LogUtils.logI(str, "on result from appeal unblock,is unblock success");
        this.mPullToRefreshView.loadData();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mTaskToBeCompletedDataListAdapter.notifyDataInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyEasyTask(final ClientSampleTaskData clientSampleTaskData) throws NoSuchMethodException, SecurityException {
        long time = new Date().getTime();
        MokuConfigure.getInstance().updateUserType(this.mContext, 4);
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.9
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(ToBeCompletedFragment.TAG, "upload device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(ToBeCompletedFragment.TAG, "upload device info error,code=>" + i + ",message" + str);
            }
        });
        final Integer easyTaskType = clientSampleTaskData.getEasyTaskType();
        if (easyTaskType.intValue() == 1 && time < clientSampleTaskData.getNextTime().longValue()) {
            Toast.makeText(requireContext(), "该任务还没有开始哦，试试其他任务吧~", 0).show();
        } else {
            LoadingDialog.show(this.mContext);
            ApiDataHelper.getApiDataHelper().applyEasyTask(this.mContext, clientSampleTaskData.getTaskDataId(), Integer.valueOf(easyTaskType.intValue() == 2 ? -2 : clientSampleTaskData.getRecordId().intValue()), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.10
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    synchronized (clientSampleTaskData) {
                        ToBeCompletedFragment.this.isClickEasy = true;
                        if (easyTaskType.intValue() == 1) {
                            WechatHelper.getInstance().toMiniProgram(MokuConfigure.getInstance().getMokuOptions(ToBeCompletedFragment.this.requireContext()).getString("wxAppId", ""), clientSampleTaskData.getUrl(), ToBeCompletedFragment.this.getContext());
                        } else {
                            AlipayHelper.getInstance().atformapiartapp(ToBeCompletedFragment.this.getActivity(), clientSampleTaskData.getUrl());
                        }
                        ToBeCompletedFragment.this.isItemClick = false;
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    Toast.makeText(ToBeCompletedFragment.this.mContext, "申请失败:" + str, 1).show();
                    ToBeCompletedFragment.this.isItemClick = false;
                }
            });
        }
    }

    @Override // com.fendasz.moku.planet.interf.observer.TagObserver
    public void select(Integer num, TagForm tagForm) {
        String str = TAG;
        Log.d(str, "select_current_tag=>" + this.mTag + ",select config id=>" + num);
        if (this.mTag == num.intValue()) {
            this.mCurrentPage = 1;
            Log.d(str, "select,need query task list");
            this.currentSelectTagId = tagForm.getTagId();
            getTaskListV3(true);
            if (-1 != this.cutInType) {
                itemLog("0", null, this.itemConfig.getItemId().intValue(), this.itemConfig.getTagIdList(), this.currentSelectTagId);
            }
        }
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
                int childCount = recyclerView.getLayoutManager().getChildCount();
                int itemCount = recyclerView.getLayoutManager().getItemCount();
                int iFindFirstVisibleItemPosition = recyclerView.getLayoutManager() instanceof LinearLayoutManager ? ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() : 0;
                Log.d(ToBeCompletedFragment.TAG, "visibleItemCount=>" + childCount + ",totalItemCount=>" + itemCount + ",pastVisiblesItems=>" + iFindFirstVisibleItemPosition);
                if (ToBeCompletedFragment.this.mIsLoadingMore || childCount + iFindFirstVisibleItemPosition + 10 < itemCount) {
                    return;
                }
                onLoadMore();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemLog(String str, Integer num, int i, List<Integer> list, Integer num2) {
        ApiDataHelper.getApiDataHelper().itemLog(this.mContext, str, num, i, list, num2, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.11
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i2, Object obj) throws Exception {
                LogUtils.logD(ToBeCompletedFragment.TAG, "itemLog success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i2, String str2) throws Exception {
                LogUtils.logE(ToBeCompletedFragment.TAG, "itemLog_error,msg =>" + str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAppeal() {
        LogUtils.logW(TAG, "get appeal");
        ApiDataHelper.getApiDataHelper().getAppeal(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment.12
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                LogUtils.logD(ToBeCompletedFragment.TAG, "get appeal success");
                ToBeCompletedFragment.this.mPullToRefreshView.showAppeal();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logD(ToBeCompletedFragment.TAG, "get appeal error,code=>" + i + ",message=>" + str);
                ToBeCompletedFragment.this.mPullToRefreshView.hideAppeal();
            }
        });
    }
}
