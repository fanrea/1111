package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RefreshableRecyclerView<T> extends RelativeLayout implements ApiDataCallBack<List<T>> {
    private static final String TAG = "RefreshableRecyclerView";
    private AppealListener appealListener;
    private RecyclerView.Adapter mAdapter;
    private BaseRecyclerAdapter<T> mBaseRecyclerAdapter;
    private String mClzNameSwipeRefreshLayout;
    private Class mClzSwipeRefreshLayout;
    private Long mLastRefreshTime;
    private LoadingView mLoadingView;
    private RecyclerView mRecyclerView;
    private RefreshListener mRefreshListener;
    private Status mStatus;
    private StatusEmptyView mStatusEmptyView;
    private ViewGroup mSwipeRefreshLayout;
    private OnStatusEmptyClickListener onStatusEmptyClickListener;
    private String tag;
    private TextView tvAppeal;

    public interface AppealListener {
        void onAppealClick();
    }

    public interface OnStatusEmptyClickListener {
        boolean isInterruptLoadDate();

        void onStatusClick(StatusEmptyView statusEmptyView);
    }

    public interface RefreshListener {
        void refresh();
    }

    public ApiDataCallBack<List<T>> getApiDataCallBack() {
        return this;
    }

    public RefreshableRecyclerView(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super(context);
        this.mRecyclerView = null;
        this.mStatus = Status.NO_DATA_UNDERWAY;
        this.mLastRefreshTime = 0L;
        onLoad();
    }

    public RefreshableRecyclerView(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.mRecyclerView = null;
        this.mStatus = Status.NO_DATA_UNDERWAY;
        this.mLastRefreshTime = 0L;
        onLoad();
    }

    public RefreshableRecyclerView(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i);
        this.mRecyclerView = null;
        this.mStatus = Status.NO_DATA_UNDERWAY;
        this.mLastRefreshTime = 0L;
        onLoad();
    }

    private void onLoad() throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        initView();
        initListener();
    }

    private void initListener() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.mSwipeRefreshLayout != null) {
            Class<?> cls = null;
            try {
                cls = Class.forName(this.mClzNameSwipeRefreshLayout + "$OnRefreshListener");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (cls != null) {
                try {
                    try {
                        this.mClzSwipeRefreshLayout.getMethod("setOnRefreshListener", cls).invoke(this.mSwipeRefreshLayout, Proxy.newProxyInstance(RefreshableRecyclerView.class.getClassLoader(), new Class[]{cls}, new MyHandle()));
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                    }
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private void initView() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.moku_base_pull_to_refresh_view, (ViewGroup) this, true);
        this.mRecyclerView = new RecyclerView(getContext());
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.setBackgroundColor(getContext().getResources().getColor(R.color.activity_background));
        ((SimpleItemAnimator) Objects.requireNonNull(this.mRecyclerView.getItemAnimator())).setSupportsChangeAnimations(false);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()) { // from class: com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(-1, -1);
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });
        this.mClzSwipeRefreshLayout = null;
        this.mClzNameSwipeRefreshLayout = "androidx.swiperefreshlayout.widget.SwipeRefreshLayout";
        try {
            this.mClzSwipeRefreshLayout = Class.forName("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (this.mClzSwipeRefreshLayout == null) {
            this.mClzNameSwipeRefreshLayout = "androidx.swiperefreshlayout.widget.SwipeRefreshLayout";
            try {
                this.mClzSwipeRefreshLayout = Class.forName("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        Class cls = this.mClzSwipeRefreshLayout;
        if (cls != null) {
            try {
                try {
                    try {
                        this.mSwipeRefreshLayout = (ViewGroup) cls.getConstructor(Context.class).newInstance(getContext());
                        LogUtils.log(TAG, "found class " + this.mSwipeRefreshLayout.getClass().getName());
                        relativeLayout.addView(this.mSwipeRefreshLayout, 0);
                        ScreenAdaptationUtils.setSize(getContext(), this.mSwipeRefreshLayout, -1, -1);
                        this.mSwipeRefreshLayout.addView(this.mRecyclerView);
                        try {
                            this.mClzSwipeRefreshLayout.getMethod("setColorSchemeResources", int[].class).invoke(this.mSwipeRefreshLayout, new int[]{R.color.google_logo_blue, R.color.google_logo_green, R.color.google_logo_red, R.color.google_logo_yellow});
                        } catch (NoSuchMethodException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                } catch (InstantiationException e6) {
                    e6.printStackTrace();
                }
            } catch (NoSuchMethodException e7) {
                e7.printStackTrace();
            }
        }
        this.mStatusEmptyView = (StatusEmptyView) findViewById(R.id.list_empty_view);
        this.mLoadingView = (LoadingView) findViewById(R.id.loading_view);
        TextView textView = (TextView) findViewById(R.id.tv_appeal);
        this.tvAppeal = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RefreshableRecyclerView.this.appealListener != null) {
                    RefreshableRecyclerView.this.appealListener.onAppealClick();
                }
            }
        });
    }

    public void loadData() {
        this.mLoadingView.show();
        this.mStatusEmptyView.hide();
        this.mRefreshListener.refresh();
    }

    public void initData(BaseRecyclerAdapter<T> baseRecyclerAdapter, RefreshListener refreshListener) {
        this.mRefreshListener = refreshListener;
        this.mBaseRecyclerAdapter = baseRecyclerAdapter;
        baseRecyclerAdapter.setTag(this.tag);
        this.mRecyclerView.setAdapter(this.mBaseRecyclerAdapter);
    }

    public void setAppealListener(AppealListener appealListener) {
        this.appealListener = appealListener;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    public void setRefreshListener(RefreshListener refreshListener) {
        this.mRefreshListener = refreshListener;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public OnStatusEmptyClickListener getOnStatusEmptyClickListener() {
        return this.onStatusEmptyClickListener;
    }

    public void setOnStatusEmptyClickListener(OnStatusEmptyClickListener onStatusEmptyClickListener) {
        this.onStatusEmptyClickListener = onStatusEmptyClickListener;
    }

    public void setStatus(Status status) {
        this.mStatus = status;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefresh() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = this.mClzSwipeRefreshLayout.getMethod("setRefreshing", Boolean.TYPE);
            try {
                ViewGroup viewGroup = this.mSwipeRefreshLayout;
                if (viewGroup != null) {
                    method.invoke(viewGroup, false);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        }
    }

    public void setSuccess(int i, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        cancelRefresh();
        StatusEmptyView statusEmptyView = this.mStatusEmptyView;
        if (statusEmptyView != null) {
            if (z) {
                statusEmptyView.show(this.mStatus, new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!(RefreshableRecyclerView.this.onStatusEmptyClickListener != null ? RefreshableRecyclerView.this.onStatusEmptyClickListener.isInterruptLoadDate() : false)) {
                            RefreshableRecyclerView.this.loadData();
                        }
                        if (RefreshableRecyclerView.this.onStatusEmptyClickListener != null) {
                            RefreshableRecyclerView.this.onStatusEmptyClickListener.onStatusClick(RefreshableRecyclerView.this.mStatusEmptyView);
                        }
                    }
                }, null);
            } else if (statusEmptyView.isShowing()) {
                this.mStatusEmptyView.hide();
            }
        }
        this.tvAppeal.setVisibility(8);
        this.mLoadingView.hide();
    }

    public void setError(int i, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        cancelRefresh();
        Status status = this.mStatus;
        if (getResources().getString(R.string.moku_do_not_use_emulators).equals(str)) {
            status = Status.BLACKLIST;
        }
        this.mStatusEmptyView.show(status, new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!(RefreshableRecyclerView.this.onStatusEmptyClickListener != null ? RefreshableRecyclerView.this.onStatusEmptyClickListener.isInterruptLoadDate() : false)) {
                    RefreshableRecyclerView.this.loadData();
                }
                if (RefreshableRecyclerView.this.onStatusEmptyClickListener != null) {
                    RefreshableRecyclerView.this.onStatusEmptyClickListener.onStatusClick(RefreshableRecyclerView.this.mStatusEmptyView);
                }
            }
        }, null);
        this.mLoadingView.hide();
    }

    public void showAppeal() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("当前账号登录异常，点击前往查看详情");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 13, 17, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-16777216), 0, 13, 33);
        spannableStringBuilder.setSpan(new UnderlineSpan(), 13, 17, 33);
        this.tvAppeal.setText(spannableStringBuilder);
        this.tvAppeal.setVisibility(0);
    }

    public void hideAppeal() {
        this.tvAppeal.setVisibility(8);
    }

    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
    public void success(int i, List<T> list) throws Exception {
        String str = TAG;
        LogUtils.log(str, "getTaskList success");
        Log.d(str, this.tag);
        if (this.mBaseRecyclerAdapter != null) {
            if (list != null && list.size() > 0) {
                if ("TASKCOMPLETED_FRAGMENT_TAG".equals(this.tag) && (list.get(0) instanceof ClientSampleTaskDataRecord)) {
                    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Collections.sort(list, new Comparator<T>() { // from class: com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.5
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public int compare(T t, T t2) {
                            if (!(t instanceof ClientSampleTaskDataRecord) || !(t2 instanceof ClientSampleTaskDataRecord)) {
                                return 0;
                            }
                            try {
                                return simpleDateFormat.parse(((ClientSampleTaskDataRecord) t).getRecordTime()).getTime() > simpleDateFormat.parse(((ClientSampleTaskDataRecord) t2).getRecordTime()).getTime() ? -1 : 1;
                            } catch (ParseException e) {
                                e.printStackTrace();
                                return 0;
                            }
                        }
                    });
                }
                this.mBaseRecyclerAdapter.setData(list);
                setSuccess(i, false);
                return;
            }
            this.mBaseRecyclerAdapter.setData(null);
            setSuccess(i, true);
        }
    }

    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
    public void error(int i, String str) throws Exception {
        LogUtils.log(TAG, "getTaskList error");
        BaseRecyclerAdapter<T> baseRecyclerAdapter = this.mBaseRecyclerAdapter;
        if (baseRecyclerAdapter != null) {
            baseRecyclerAdapter.setData(null);
        }
        setError(i, str);
    }

    class MyHandle implements InvocationHandler {
        MyHandle() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            new Handler().postDelayed(new Runnable() { // from class: com.fendasz.moku.planet.ui.customview.RefreshableRecyclerView.MyHandle.1
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                    if (RefreshableRecyclerView.this.mRefreshListener != null) {
                        Long lValueOf = Long.valueOf(System.currentTimeMillis());
                        if (lValueOf.longValue() - RefreshableRecyclerView.this.mLastRefreshTime.longValue() > 60000) {
                            RefreshableRecyclerView.this.mLastRefreshTime = lValueOf;
                            RefreshableRecyclerView.this.mRefreshListener.refresh();
                            RefreshableRecyclerView.this.mStatusEmptyView.hide();
                            return;
                        }
                        RefreshableRecyclerView.this.cancelRefresh();
                    }
                }
            }, 2000L);
            return null;
        }
    }
}
