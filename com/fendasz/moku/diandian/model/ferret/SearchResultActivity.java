package com.fendasz.moku.diandian.model.ferret;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.diandian.commons.MokuDianActivity;
import com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity;
import com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.exception.MokuException;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataList;
import com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter;
import com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView;
import com.fendasz.moku.planet.ui.customview.StatusEmptyView;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SearchResultActivity extends MokuDianActivity {
    public static final int REQUEST_CODE_FOR_MOKU_DETAIL = 200;
    private static final String TAG = "Dian_Search_Result=>";
    private static final int WHAT_TASK_EMPTY = 2;
    private static final int WHAT_TASK_LIST = 1;
    private LinearLayout llRefreshViewContainer;
    private List<ClientSampleTaskData> mClientSampleTaskData;
    private Context mContext;
    private MokuOptions mMokuOptions;
    private RefreshableRecyclerView<ClientSampleTaskData> mPullToRefreshView;
    private TaskToBeCompletedDataListAdapter mTaskToBeCompletedDataListAdapter;
    private String searchKey;
    private boolean isItemClick = false;
    private int cutInType = -1;
    private MyHandler handler = null;

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private static class MyHandler extends Handler {
        private final WeakReference<SearchResultActivity> activityReference;

        public MyHandler(SearchResultActivity searchResultActivity) {
            super(Looper.getMainLooper());
            this.activityReference = new WeakReference<>(searchResultActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            SearchResultActivity searchResultActivity = this.activityReference.get();
            if (searchResultActivity != null) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        searchResultActivity.notifyAdapter();
                    } else {
                        LoadingDialog.dismiss();
                        return;
                    }
                }
                searchResultActivity.notifyAdapter();
            }
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_search_result, (ViewGroup) null);
        this.llRefreshViewContainer = (LinearLayout) frameLayout.findViewById(R.id.ll_refresh_view_search_container);
        return frameLayout;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.ferret.SearchResultActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchResultActivity.this.finish();
            }
        });
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        String string;
        super.initTitle(textView);
        if (textView == null || (string = this.mMokuOptions.getString("titleText", null)) == null) {
            return;
        }
        textView.setText(string);
        textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        super.onSuperCreate(bundle);
        this.mContext = this;
        this.mMokuOptions = MokuConfigure.getInstance().getMokuOptions(this.mContext);
        this.handler = new MyHandler(this);
        this.cutInType = this.mMokuOptions.getInteger("cutInType", -1);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initView() {
        super.initView();
        this.mPullToRefreshView = new RefreshableRecyclerView<>(this);
        this.llRefreshViewContainer.addView(this.mPullToRefreshView, new LinearLayout.LayoutParams(-1, -1));
        initData();
        initListener();
        RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView = this.mPullToRefreshView;
        if (refreshableRecyclerView != null) {
            refreshableRecyclerView.setStatus(Status.DIAN_SEARCH_EMPTY);
            this.mPullToRefreshView.loadData();
        }
        LogUtils.logD(TAG, "run search thread to query task list");
    }

    private void initData() {
        this.mClientSampleTaskData = new ArrayList();
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("moku_dian_ferret_key");
            this.searchKey = stringExtra;
            if (stringExtra == null || StringUtils.isEmpty(stringExtra)) {
                finish();
            }
        }
        this.mTaskToBeCompletedDataListAdapter = new TaskToBeCompletedDataListAdapter(this, this.mClientSampleTaskData);
    }

    private void initListener() {
        this.mTaskToBeCompletedDataListAdapter.setOnItemClickListener(new TaskToBeCompletedDataListAdapter.OnItemClickListener() { // from class: com.fendasz.moku.diandian.model.ferret.SearchResultActivity.2
            @Override // com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter.OnItemClickListener
            public void onItemClick(View view, int i) {
                if (SearchResultActivity.this.isItemClick) {
                    return;
                }
                synchronized (this) {
                    SearchResultActivity.this.isItemClick = true;
                    ClientSampleTaskData clientSampleTaskData = (ClientSampleTaskData) SearchResultActivity.this.mClientSampleTaskData.get(i);
                    if (clientSampleTaskData.getSurplusNum().intValue() > 0 || (clientSampleTaskData.getTaskDataApplyRecord() != null && (clientSampleTaskData.getTaskDataApplyRecord().getStatus().equals(MokuConstants.STATUS_OF_APPLYING) || clientSampleTaskData.getTaskDataApplyRecord().getStatus().equals(MokuConstants.STATUS_OF_OVERTIME)))) {
                        int unused = SearchResultActivity.this.cutInType;
                        SearchResultActivity.this.gotoDetail(clientSampleTaskData);
                        SearchResultActivity.this.isItemClick = false;
                    } else {
                        SearchResultActivity.this.isItemClick = false;
                    }
                }
            }
        });
        this.mPullToRefreshView.setAdapter(this.mTaskToBeCompletedDataListAdapter);
        this.mPullToRefreshView.setRefreshListener(new RefreshableRecyclerView.RefreshListener() { // from class: com.fendasz.moku.diandian.model.ferret.SearchResultActivity.3
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.RefreshListener
            public void refresh() {
                LogUtils.logD(SearchResultActivity.TAG, "mPullToRefreshView refresh");
                new Thread(SearchResultActivity.this.new SearchRunable()).start();
            }
        });
        this.mPullToRefreshView.setOnStatusEmptyClickListener(new RefreshableRecyclerView.OnStatusEmptyClickListener() { // from class: com.fendasz.moku.diandian.model.ferret.SearchResultActivity.4
            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.OnStatusEmptyClickListener
            public boolean isInterruptLoadDate() {
                return false;
            }

            @Override // com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.OnStatusEmptyClickListener
            public void onStatusClick(StatusEmptyView statusEmptyView) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdapter() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        LoadingDialog.dismiss();
        TaskToBeCompletedDataListAdapter taskToBeCompletedDataListAdapter = this.mTaskToBeCompletedDataListAdapter;
        Objects.requireNonNull(taskToBeCompletedDataListAdapter);
        taskToBeCompletedDataListAdapter.setLoadState(3);
        List<ClientSampleTaskData> list = this.mClientSampleTaskData;
        boolean z = true;
        if (list != null && list.size() == 1) {
            gotoDetail(this.mClientSampleTaskData.get(0));
            finish();
            return;
        }
        List<ClientSampleTaskData> list2 = this.mClientSampleTaskData;
        if (list2 != null && !list2.isEmpty()) {
            z = false;
        }
        this.mTaskToBeCompletedDataListAdapter.setList(this.mClientSampleTaskData);
        this.mTaskToBeCompletedDataListAdapter.notifyDataSetChanged();
        RefreshableRecyclerView<ClientSampleTaskData> refreshableRecyclerView = this.mPullToRefreshView;
        if (refreshableRecyclerView != null) {
            refreshableRecyclerView.setSuccess(0, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoDetail(ClientSampleTaskData clientSampleTaskData) {
        Intent intent;
        Integer taskDataId = clientSampleTaskData.getTaskDataId();
        if (clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
            intent = new Intent(this, (Class<?>) DianCPLDetailActivity.class);
        } else if (clientSampleTaskData.getTaskType() != null && clientSampleTaskData.getTaskType().intValue() == 1) {
            Toast.makeText(this, "任务配置信息错误，请联系客服处理", 0).show();
            intent = null;
        } else {
            intent = new Intent(this, (Class<?>) DianCpaDetailActivity.class);
        }
        intent.putExtra("taskDataId", taskDataId.intValue());
        String gateType = clientSampleTaskData.getGateType();
        if (!TextUtils.isEmpty(gateType)) {
            intent.putExtra("gateType", gateType);
        }
        intent.putExtra("operationType", 100);
        startActivityForResult(intent, 200);
    }

    class SearchRunable implements Runnable {
        SearchRunable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<ClientSampleTaskData> array;
            LogUtils.logI(SearchResultActivity.TAG, "SearchRunable run start");
            String searchTaskList = StorageUtils.getSearchTaskList(SearchResultActivity.this.mContext);
            if (searchTaskList == null || StringUtils.isEmpty(searchTaskList)) {
                array = null;
            } else {
                LogUtils.logI(SearchResultActivity.TAG, "SearchRunable dataJsonList is not empty,parase it to task list");
                try {
                    array = JSON.parseArray(searchTaskList, ClientSampleTaskData.class);
                } catch (Exception unused) {
                    LogUtils.logE(SearchResultActivity.TAG, "local sp task to list error");
                }
            }
            if (array != null && !array.isEmpty()) {
                LogUtils.logI(SearchResultActivity.TAG, "SearchRunable task list from local,send hand message");
                ArrayList arrayList = new ArrayList();
                for (ClientSampleTaskData clientSampleTaskData : array) {
                    if (clientSampleTaskData.getShowName() != null && clientSampleTaskData.getShowName().contains(SearchResultActivity.this.searchKey)) {
                        arrayList.add(clientSampleTaskData);
                    } else if (clientSampleTaskData.getDesc() != null && clientSampleTaskData.getDesc().contains(SearchResultActivity.this.searchKey)) {
                        arrayList.add(clientSampleTaskData);
                    }
                }
                if (!arrayList.isEmpty()) {
                    SearchResultActivity.this.mClientSampleTaskData = arrayList;
                    SearchResultActivity.this.handler.sendEmptyMessage(1);
                    return;
                } else {
                    SearchResultActivity.this.handler.sendEmptyMessage(2);
                    return;
                }
            }
            LogUtils.logI(SearchResultActivity.TAG, "SearchRunable task list from local is empty,query from server");
            try {
                ApiDataHelper.getInstance(SearchResultActivity.this.mContext).getDianTaskList(SearchResultActivity.this.mContext, 1, Integer.MAX_VALUE, 5, null, null, 0, new ApiDataCallBack<ClientSampleTaskDataList>() { // from class: com.fendasz.moku.diandian.model.ferret.SearchResultActivity.SearchRunable.1
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i, ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
                        LogUtils.logD(SearchResultActivity.TAG, "SearchRunable query from server success");
                        if (clientSampleTaskDataList == null || clientSampleTaskDataList.getList() == null || clientSampleTaskDataList.getList().isEmpty()) {
                            SearchResultActivity.this.handler.sendEmptyMessage(2);
                            return;
                        }
                        new Thread(SearchResultActivity.this.new InsertRunable(clientSampleTaskDataList.getList())).start();
                        ArrayList arrayList2 = new ArrayList();
                        for (ClientSampleTaskData clientSampleTaskData2 : clientSampleTaskDataList.getList()) {
                            if (clientSampleTaskData2.getShowName() != null && clientSampleTaskData2.getShowName().contains(SearchResultActivity.this.searchKey)) {
                                arrayList2.add(clientSampleTaskData2);
                            } else if (clientSampleTaskData2.getDesc() != null && clientSampleTaskData2.getDesc().contains(SearchResultActivity.this.searchKey)) {
                                arrayList2.add(clientSampleTaskData2);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            SearchResultActivity.this.mClientSampleTaskData = arrayList2;
                            SearchResultActivity.this.handler.sendEmptyMessage(1);
                        } else {
                            SearchResultActivity.this.handler.sendEmptyMessage(2);
                        }
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i, String str) throws Exception {
                        LogUtils.logE(SearchResultActivity.TAG, "SearchRunable query from server error,code:" + i + ",message:" + str);
                        SearchResultActivity.this.handler.sendEmptyMessage(2);
                    }
                });
            } catch (MokuException e) {
                e.printStackTrace();
                LogUtils.logE(SearchResultActivity.TAG, "SearchRunable getTask list from server error");
                SearchResultActivity.this.handler.sendEmptyMessage(2);
            }
        }
    }

    class InsertRunable implements Runnable {
        private List<ClientSampleTaskData> dataList;

        public InsertRunable(List<ClientSampleTaskData> list) {
            this.dataList = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<ClientSampleTaskData> list = this.dataList;
            if (list != null) {
                try {
                    StorageUtils.putSearchTaskList(SearchResultActivity.this.mContext, JSON.toJSONString(list));
                    LogUtils.logD(SearchResultActivity.TAG, "insert task list success");
                } catch (Exception unused) {
                    LogUtils.logE(SearchResultActivity.TAG, "insert task list,mClientSampleTaskData to json error");
                }
            }
        }
    }
}
