package com.bytedance.sdk.djx.core.business.budrama.home;

import aegon.chrome.net.NetError;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.absdk.EMABManager;
import com.bytedance.sdk.djx.base.dynamic.DynamicManager;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.api.req.FeedApi;
import com.bytedance.sdk.djx.core.business.ActiveLog;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.base.BaseViewModel;
import com.bytedance.sdk.djx.core.business.base.FragMVVMProxy;
import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.core.business.budrama.GridRenderHelper;
import com.bytedance.sdk.djx.core.business.budrama.ItemExposeReporter;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHelper;
import com.bytedance.sdk.djx.core.business.budrama.draw.HomeRefreshHelper;
import com.bytedance.sdk.djx.core.business.reporter.DramaReporter;
import com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter;
import com.bytedance.sdk.djx.core.business.view.DJXDrawTitleRefresh;
import com.bytedance.sdk.djx.core.business.view.DJXRoundImageView;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDmtLoadingLayout;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDoubleColorBallAnimationView;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXEmptyRefreshView;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout2;
import com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder;
import com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.log.SdkTLog;
import com.bytedance.sdk.djx.core.log.T2WLog;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.ImageUtil;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.core.util.VisibilityChecker;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaHomeListener;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.SourceMode;
import com.bytedance.sdk.djx.model.ev.BEHomeFirstFrame;
import com.bytedance.sdk.djx.model.ev.BEHomeLoadFrame;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.ListUtils;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaHomeFragment extends FragMVVMProxy<DJXDramaHomeViewModel, DJXWidgetDramaHomeParams> {
    private static final float CARD_COVER_RATIO = 0.5625f;
    private static final int COLUMN_SPACING = 10;
    private static final int GRID_SPAN_COUNT = 2;
    private static final int GRID_VIEW = 3;
    private static final float HISTORY_CARD_RATIO = 0.25f;
    private static final int HISTORY_SPAN_COUNT = 2;
    private static final int HISTORY_VIEW = 2;
    private static final int HOT_SPAN_COUNT = 3;
    private static final int HOT_VIEW = 1;
    private static final String KEY_AB_ENABLE_HOME_AD = "enable_playlet_home_feed_ad";
    private static final Long RETRY_MS = 1000L;
    private ActiveLog mActiveLog;
    private AdKey mAdKey;
    private ImageView mBackBtn;
    private final IBusListener mBusListener;
    private LinearLayout mChangeBtn;
    private DramaGridAdapter mDramaGridAdapter;
    private RecyclerView mDramaGridRecycleView;
    private FrameLayout mGridViewNetworkErrorHint;
    private ConstraintLayout mHistoryDramaCard1;
    private ConstraintLayout mHistoryDramaCard2;
    private ViewGroup mHistoryDramaLayout;
    private LinearLayout mHotDramaCard1;
    private LinearLayout mHotDramaCard2;
    private LinearLayout mHotDramaCard3;
    private ViewGroup mHotDramaLayout;
    private FrameLayout mHotViewNetworkErrorHint;
    private boolean mInsertAdEnable;
    private DJXDmtLoadingLayout mLoadingLayout;
    private DJXDoubleColorBallAnimationView mLoadingView;
    private DJXRefreshLayout2 mRefreshLayout;
    private DJXScrollerLayout mScrollerLayout;
    private ConstraintLayout mTitleLayout;
    private DJXDrawTitleRefresh mTitleRefresh;
    private final String TAG = "DJXDramaHomeFragment";
    private final List<LinearLayout> mHotCards = new ArrayList();
    private final List<ConstraintLayout> mHistoryCards = new ArrayList();
    private final RVExposeReporter mExposeReporter = new RVExposeReporter();
    private Boolean mHasMore = false;
    private final SdkTLog mTLog = new SdkTLog();
    private final String mCategory = FeedApi.CATEGORY_GRID;
    private long mStartTime = -1;
    private final List<Drama> mHotCardsData = new CopyOnWriteArrayList();
    private final List<Drama> mHistoryCardsData = new CopyOnWriteArrayList();
    private final ItemExposeReporter mHotExposeReporter = new ItemExposeReporter();
    private final ItemExposeReporter mHistoryExposeReporter = new ItemExposeReporter();
    private final DJXEmptyRefreshView refreshView = new DJXEmptyRefreshView(getContext());
    private final HomeRefreshHelper mRefreshHelper = new HomeRefreshHelper();
    private Long requestTime = 0L;
    private final T2WLog mT2WLog = new T2WLog(T2WLog.SCENE_HOME);

    public DJXDramaHomeFragment(DJXWidgetDramaHomeParams dJXWidgetDramaHomeParams) {
        this.mInsertAdEnable = ((Integer) EMABManager.getInstance().getConfig(KEY_AB_ENABLE_HOME_AD, 0)).intValue() == 1;
        this.mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.1
            public void onBusEvent(BusEvent busEvent) {
                if (busEvent instanceof BEHomeFirstFrame) {
                    BEHomeFirstFrame bEHomeFirstFrame = (BEHomeFirstFrame) busEvent;
                    if (bEHomeFirstFrame.mSource == SourceMode.PLAYLET) {
                        DJXDramaHomeFragment.this.mT2WLog.sendFirstFrame(bEHomeFirstFrame.mPosition);
                        return;
                    }
                    return;
                }
                if (busEvent instanceof BEHomeLoadFrame) {
                    BEHomeLoadFrame bEHomeLoadFrame = (BEHomeLoadFrame) busEvent;
                    if (bEHomeLoadFrame.mSource == SourceMode.PLAYLET) {
                        DJXDramaHomeFragment.this.mT2WLog.sendLoad(bEHomeLoadFrame.mPosition);
                    }
                }
            }
        };
        this.mParam = dJXWidgetDramaHomeParams;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_frag_drama_home);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mT2WLog.sendInit();
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        int i = ((DJXWidgetDramaHomeParams) this.mParam).mTopOffset;
        if (i >= 0) {
            View viewFindById = findById(R.id.djx_top_scope);
            ViewGroup.LayoutParams layoutParams = viewFindById.getLayoutParams();
            layoutParams.height = UIUtil.dp2px(i);
            viewFindById.setLayoutParams(layoutParams);
        }
        return viewOnCreateView;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initData(Bundle bundle) {
        super.initData(bundle);
        initAdData();
    }

    private void initAdData() {
        if (this.mInsertAdEnable) {
            String storyHomeAdCodeId = DynamicManager.getInstance().getStoryHomeAdCodeId();
            int iHashCode = this.mParam == 0 ? 0 : ((DJXWidgetDramaHomeParams) this.mParam).hashCode();
            int iPx2dp = UIUtil.px2dp((UIUtil.getScreenWidth(InnerManager.getContext()) + NetError.ERR_PROXY_CONNECTION_FAILED) / 2.0f);
            this.mAdKey = AdKey.obtain().codeId(storyHomeAdCodeId).commonParams(null).paramsCode(iHashCode).category(FeedApi.CATEGORY_GRID).adType("draw").adSource(ILogConst.AD_SOURCE_HOME_FEED).width(iPx2dp).height(iPx2dp * 2);
            ((DJXDramaHomeViewModel) this.mViewModel).setAdKey(this.mAdKey);
            AdManager.inst().buildAdLoader(2, this.mAdKey, this.mParam != 0 ? ((DJXWidgetDramaHomeParams) this.mParam).mDJXHomeAdListener : null);
            AdManager.inst().hasAd(this.mAdKey, 0);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initView(View view) {
        super.initView(view);
        this.mTitleLayout = (ConstraintLayout) findById(R.id.djx_drama_home_title_layout);
        this.mHotDramaLayout = (ViewGroup) findById(R.id.djx_hot_drama_layout);
        this.mHistoryDramaLayout = (ViewGroup) findById(R.id.djx_history_drama_layout);
        this.mLoadingLayout = (DJXDmtLoadingLayout) findById(R.id.djx_loading_layout);
        this.mScrollerLayout = (DJXScrollerLayout) findById(R.id.djx_scroll_layout);
        this.mRefreshLayout = (DJXRefreshLayout2) findById(R.id.djx_draw_refresh);
        this.mLoadingView = (DJXDoubleColorBallAnimationView) findById(R.id.djx_drama_home_loading);
        this.mTitleRefresh = (DJXDrawTitleRefresh) findById(R.id.djx_draw_box_title_refresh);
        this.mHotViewNetworkErrorHint = (FrameLayout) this.mHotDramaLayout.findViewById(R.id.djx_network_error_hint_drama_hot);
        this.mHotDramaCard1 = (LinearLayout) this.mHotDramaLayout.findViewById(R.id.djx_hot_drama_card1);
        this.mHotDramaCard2 = (LinearLayout) this.mHotDramaLayout.findViewById(R.id.djx_hot_drama_card2);
        this.mHotDramaCard3 = (LinearLayout) this.mHotDramaLayout.findViewById(R.id.djx_hot_drama_card3);
        this.mHotCards.add(this.mHotDramaCard1);
        this.mHotCards.add(this.mHotDramaCard2);
        this.mHotCards.add(this.mHotDramaCard3);
        this.mHotDramaLayout.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.2
            @Override // java.lang.Runnable
            public void run() {
                DJXDramaHomeFragment.this.handleDramaCardLayoutParams(1);
            }
        });
        this.mHistoryDramaLayout.setVisibility(DevInfo.getPrivacyController().isTeenagerMode() ? 8 : 0);
        this.mHistoryDramaCard1 = (ConstraintLayout) this.mHistoryDramaLayout.findViewById(R.id.djx_history_drama_card1);
        this.mHistoryDramaCard2 = (ConstraintLayout) this.mHistoryDramaLayout.findViewById(R.id.djx_history_drama_card2);
        this.mHistoryCards.add(this.mHistoryDramaCard1);
        this.mHistoryCards.add(this.mHistoryDramaCard2);
        this.mHistoryDramaLayout.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.3
            @Override // java.lang.Runnable
            public void run() {
                DJXDramaHomeFragment.this.handleDramaCardLayoutParams(2);
            }
        });
        this.mGridViewNetworkErrorHint = (FrameLayout) findById(R.id.djx_network_error_hint_drama_grid);
        this.mDramaGridRecycleView = (RecyclerView) findById(R.id.djx_grid_drama_recycler_view);
        this.mDramaGridAdapter = new DramaGridAdapter(getContext(), this.mDramaGridRecycleView, this.mAdKey);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(1);
        this.mDramaGridAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.4
            @Override // com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter.OnItemClickListener
            public boolean onItemLongClick(View view2, Object obj, BaseViewHolder baseViewHolder, int i) {
                return false;
            }

            @Override // com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter.OnItemClickListener
            public void onItemClick(View view2, Object obj, BaseViewHolder baseViewHolder, int i) {
                if (obj instanceof Drama) {
                    Drama drama = (Drama) obj;
                    DJXDramaHomeFragment.this.invokeOnItemClick(drama, 3);
                    DJXDramaHomeFragment.this.enterDramaDetail(drama, DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HOME, ILogConst.MODULE_FEED_SKITS);
                }
            }
        });
        this.mDramaGridRecycleView.setLayoutManager(gridLayoutManager);
        this.mDramaGridRecycleView.setAdapter(this.mDramaGridAdapter);
        this.mDramaGridRecycleView.addItemDecoration(new DramaGridItemDecoration(2, 18, 10));
        this.mExposeReporter.init(this.mDramaGridRecycleView, new RVExposeReporter.IClientShowListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.5
            @Override // com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter.IClientShowListener
            public void onItemInVisible(Object obj, int i) {
            }

            @Override // com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter.IClientShowListener
            public void onItemVisible(Object obj, int i) {
            }

            @Override // com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter.IClientShowListener
            public void onSendClientShow(Object obj, int i, long j, long j2) {
                super.onSendClientShow(obj, i, j, j2);
                if (obj instanceof Drama) {
                    DramaReporter.reportClientShow(FeedApi.CATEGORY_GRID, ILogConst.MODULE_FEED_SKITS, j, j2, (Drama) obj);
                }
            }
        });
        this.mHotExposeReporter.init(this.mHotDramaLayout, new ItemExposeReporter.IClientShowListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.6
            @Override // com.bytedance.sdk.djx.core.business.budrama.ItemExposeReporter.IClientShowListener
            public Object getKey(Object obj) {
                return obj instanceof Drama ? Long.valueOf(((Drama) obj).id) : obj;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.ItemExposeReporter.IClientShowListener
            public List<?> getDatas() {
                BaseViewModel.DataWrapper<List<Drama>> value = ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).getHotList().getValue();
                if (value != null && value.getData() != null) {
                    return value.getData();
                }
                return new ArrayList();
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.ItemExposeReporter.IClientShowListener
            public void onSendClientShow(Object obj, long j, long j2) {
                if (obj instanceof Drama) {
                    DramaReporter.reportClientShow(FeedApi.CATEGORY_GRID, ILogConst.MODULE_HOT_SKITS, j, j2, (Drama) obj);
                }
            }
        });
        this.mHistoryExposeReporter.init(this.mHistoryDramaLayout, new ItemExposeReporter.IClientShowListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.7
            @Override // com.bytedance.sdk.djx.core.business.budrama.ItemExposeReporter.IClientShowListener
            public Object getKey(Object obj) {
                return obj instanceof Drama ? Long.valueOf(((Drama) obj).id) : obj;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.ItemExposeReporter.IClientShowListener
            public List<?> getDatas() {
                BaseViewModel.DataWrapper<List<Drama>> value = ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).getHistoryList().getValue();
                if (value != null && value.getData() != null) {
                    return value.getData();
                }
                return new ArrayList();
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.ItemExposeReporter.IClientShowListener
            public void onSendClientShow(Object obj, long j, long j2) {
                if (obj instanceof Drama) {
                    DramaReporter.reportClientShow(FeedApi.CATEGORY_GRID, ILogConst.MODULE_HISTORY_SKITS, j, j2, (Drama) obj);
                }
            }
        });
        this.mScrollerLayout.setOnVerticalScrollChangeListener(new DJXScrollerLayout.OnScrollChangeListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.8
            @Override // com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.OnScrollChangeListener
            public void onScrollChange(View view2, int i, int i2, int i3) {
                int i4 = i - i2;
                if (DJXDramaHomeFragment.this.mScrollerLayout.isScrollBottom() && i4 > 0) {
                    ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).loadGridList(false);
                }
                DJXDramaHomeFragment.this.mExposeReporter.onScrolled(DJXDramaHomeFragment.this.mDramaGridRecycleView, 0, i4);
                if (DJXDramaHomeFragment.this.mActiveLog != null) {
                    DJXDramaHomeFragment.this.mActiveLog.active();
                }
                DJXDramaHomeFragment.this.mHotExposeReporter.startChecking();
                DJXDramaHomeFragment.this.mHistoryExposeReporter.startChecking();
                if (i3 == 0) {
                    DJXDramaHomeFragment.this.sendRecHotShow();
                    DJXDramaHomeFragment.this.sendRecHistoryShow();
                    DJXDramaHomeFragment.this.sendRecFeedShow();
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) this.mHotDramaLayout.findViewById(R.id.djx_change_btn);
        this.mChangeBtn = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).acquire3HotDrama();
            }
        });
        ImageView imageView = (ImageView) findById(R.id.djx_drama_home_back_btn);
        this.mBackBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DJXDramaHomeFragment.this.finishActivity();
            }
        });
        if (DevInfo.getPrivacyController().isTeenagerMode()) {
            ((TextView) this.mHotViewNetworkErrorHint.getChildAt(0)).setText(getGlobalContext().getResources().getString(R.string.djx_teenager_no_data));
            ((TextView) this.mGridViewNetworkErrorHint.getChildAt(0)).setText(getGlobalContext().getResources().getString(R.string.djx_teenager_no_data));
        } else {
            setNetworkErrorHint(1, this.mHotViewNetworkErrorHint);
            setNetworkErrorHint(3, this.mGridViewNetworkErrorHint);
        }
        if (this.mActiveLog == null) {
            ActiveLog activeLog = new ActiveLog(this.mContentView, FeedApi.CATEGORY_GRID, ActiveLog.SKIT_FEED, null);
            this.mActiveLog = activeLog;
            activeLog.putParam(ILogConst.Keys.KEY_MODE, "playlet");
            this.mActiveLog.putParam(ILogConst.Keys.INTERFACE_TYPE, "sdk");
        }
        this.mRefreshLayout.setIsCanSecondFloor(false);
        this.mRefreshLayout.setRefreshEnable(true);
        this.mRefreshLayout.setRefreshHeight(0);
        this.mRefreshLayout.setRefreshFixedContent(true);
        this.mRefreshLayout.setLoadEnable(false);
        this.mRefreshLayout.setForceStopIntercept(true);
        this.mTitleRefresh.setContent(false);
        this.mRefreshHelper.init(this.mTitleLayout, this.mTitleRefresh);
        this.refreshView.setRefreshListener(this.mRefreshHelper);
        this.mRefreshLayout.setRefreshView(this.refreshView);
        this.mRefreshLayout.setOnRefreshListener(new DJXRefreshLayout.OnRefreshListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.11
            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (!NetworkUtils.isActive(InnerManager.getContext())) {
                    ToastUtil.show(InnerManager.getContext(), DJXDramaHomeFragment.this.getResources().getString(R.string.djx_str_refresh_error_retry));
                    DJXDramaHomeFragment.this.mRefreshLayout.setRefreshing(false);
                    DJXDramaHomeFragment.this.mLoadingView.stopAnimate();
                    return;
                }
                if (SystemClock.elapsedRealtime() - DJXDramaHomeFragment.this.requestTime.longValue() >= Math.max(SettingData.getInstance().getHostListRetryTime(), 0) * DJXDramaHomeFragment.RETRY_MS.longValue() || !((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).hasCache()) {
                    ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).loadHotList(DJXDramaHomeFragment.this.formNewTopDramaIds());
                } else {
                    ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).acquire3HotDrama();
                }
                DJXDramaHomeFragment.this.mDramaGridAdapter.clear();
                ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).loadGridList(true);
                DJXDramaHomeFragment.this.mRefreshLayout.setRefreshing(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRecFeedShow() {
        RecyclerView recyclerView = this.mDramaGridRecycleView;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || !(this.mDramaGridRecycleView.getLayoutManager() instanceof GridLayoutManager)) {
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.mDramaGridRecycleView.getLayoutManager();
        int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
            View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            Object itemData = this.mDramaGridAdapter.getItemData(iFindFirstVisibleItemPosition);
            if (viewFindViewByPosition != null && viewFindViewByPosition.isShown() && (itemData instanceof Drama)) {
                float visibleArea = VisibilityChecker.getVisibleArea(viewFindViewByPosition);
                if (visibleArea > 0.0f) {
                    DramaReporter.reportRecShow(FeedApi.CATEGORY_GRID, ILogConst.MODULE_FEED_SKITS, (Drama) itemData, visibleArea);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRecHotShow() {
        if (this.mHotCardsData.isEmpty() || this.mHotCards.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.mHotCards.size(); i++) {
            LinearLayout linearLayout = this.mHotCards.get(i);
            Drama drama = (Drama) ListUtils.get(this.mHotCardsData, i);
            if (linearLayout != null && linearLayout.isShown() && drama != null) {
                float visibleArea = VisibilityChecker.getVisibleArea(linearLayout);
                if (visibleArea > 0.0f) {
                    DramaReporter.reportRecShow(FeedApi.CATEGORY_GRID, ILogConst.MODULE_HOT_SKITS, drama, visibleArea);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRecHistoryShow() {
        if (this.mHistoryCards.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.mHistoryCards.size(); i++) {
            ConstraintLayout constraintLayout = this.mHistoryCards.get(i);
            Drama drama = (Drama) ListUtils.get(this.mHistoryCardsData, i);
            if (constraintLayout != null && constraintLayout.isShown() && drama != null) {
                float visibleArea = VisibilityChecker.getVisibleArea(constraintLayout);
                if (visibleArea > 0.0f) {
                    DramaReporter.reportRecShow(FeedApi.CATEGORY_GRID, ILogConst.MODULE_HISTORY_SKITS, drama, visibleArea);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDramaCardLayoutParams(int i) {
        if (i == 1) {
            for (LinearLayout linearLayout : this.mHotCards) {
                int width = this.mHotDramaLayout.getWidth() - (UIUtil.dp2px(9.0f) * 2);
                linearLayout.setLayoutParams(GridRenderHelper.handleVerticalLayoutParams(linearLayout.getLayoutParams(), width, 10, 3, 0.0f));
                DJXRoundImageView dJXRoundImageView = (DJXRoundImageView) linearLayout.findViewById(R.id.djx_drama_cover);
                dJXRoundImageView.setLayoutParams(GridRenderHelper.handleVerticalLayoutParams(dJXRoundImageView.getLayoutParams(), GridRenderHelper.getRealSpace(width, 10, 3), 0, 0, CARD_COVER_RATIO));
                dJXRoundImageView.setCornerRadius(4);
            }
            return;
        }
        if (i != 2) {
            return;
        }
        for (ConstraintLayout constraintLayout : this.mHistoryCards) {
            constraintLayout.setLayoutParams(GridRenderHelper.handleVerticalLayoutParams(constraintLayout.getLayoutParams(), this.mHistoryDramaLayout.getWidth(), 10, 2, 0.0f));
            DJXRoundImageView dJXRoundImageView2 = (DJXRoundImageView) constraintLayout.findViewById(R.id.djx_drama_cover);
            dJXRoundImageView2.setLayoutParams(GridRenderHelper.handleVerticalLayoutParams(dJXRoundImageView2.getLayoutParams(), (int) (GridRenderHelper.getRealSpace(this.mHistoryDramaLayout.getWidth(), 10, 2) * HISTORY_CARD_RATIO), 0, 0, CARD_COVER_RATIO));
            LinearLayout linearLayout2 = (LinearLayout) constraintLayout.findViewById(R.id.djx_drama_desc);
            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
            layoutParams.width = (int) (GridRenderHelper.getRealSpace(this.mHistoryDramaLayout.getWidth(), 10, 2) * 0.75f);
            linearLayout2.setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDetach() {
        super.onDetach();
        DJXBus.getInstance().removeListener(this.mBusListener);
        Picasso.with(getGlobalContext()).cancelTag(ImageTag.TAG_DRAMA_HOME);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
        this.mT2WLog.sendViewFinish();
        super.processLogic();
        DJXBus.getInstance().addListener(this.mBusListener);
        this.mTitleLayout.setVisibility(((DJXWidgetDramaHomeParams) this.mParam).mShowPageTitle ? 0 : 8);
        if (!((DJXWidgetDramaHomeParams) this.mParam).mShowPageTitle) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshLayout.getLayoutParams()).topMargin = 0;
        }
        if (((DJXWidgetDramaHomeParams) this.mParam).mShowPageTitle) {
            this.mBackBtn.setVisibility(((DJXWidgetDramaHomeParams) this.mParam).mShowBackBtn ? 0 : 8);
        }
        this.mChangeBtn.setVisibility(((DJXWidgetDramaHomeParams) this.mParam).mShowChangeBtn ? 0 : 8);
        ((DJXDramaHomeViewModel) this.mViewModel).getHotList().observe(getViewLifecycleOwner(), new AnonymousClass12());
        ((DJXDramaHomeViewModel) this.mViewModel).getHistoryList().observe(getViewLifecycleOwner(), new AnonymousClass13());
        ((DJXDramaHomeViewModel) this.mViewModel).getGridList().observe(getViewLifecycleOwner(), new Observer<BaseViewModel.DataWrapper<List<Drama>>>() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.14
            @Override // androidx.lifecycle.Observer
            public void onChanged(BaseViewModel.DataWrapper<List<Drama>> dataWrapper) {
                if (dataWrapper == null) {
                    return;
                }
                if (DevInfo.getPrivacyController().isTeenagerMode() && dataWrapper.getResult() == BaseViewModel.NetworkResult.SUCCESS && (dataWrapper.getData() == null || dataWrapper.getData().isEmpty())) {
                    DJXDramaHomeFragment.this.mT2WLog.sendReqEnd(true, dataWrapper.errCode, dataWrapper.errMsg, null);
                    DJXDramaHomeFragment.this.mGridViewNetworkErrorHint.setVisibility(0);
                    DJXDramaHomeFragment.this.mGridViewNetworkErrorHint.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DJXDramaHomeFragment.this.mScrollerLayout.smoothScrollToChildWithOffset(DJXDramaHomeFragment.this.mGridViewNetworkErrorHint, DJXDramaHomeFragment.this.mGridViewNetworkErrorHint.getHeight());
                        }
                    });
                    return;
                }
                if (dataWrapper.getResult() == BaseViewModel.NetworkResult.FAILED) {
                    DJXDramaHomeFragment.this.mT2WLog.sendReqEnd(false, dataWrapper.errCode, dataWrapper.errMsg, null);
                    DJXDramaHomeFragment.this.mGridViewNetworkErrorHint.setVisibility(0);
                    DJXDramaHomeFragment.this.mGridViewNetworkErrorHint.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.14.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DJXDramaHomeFragment.this.mScrollerLayout.smoothScrollToChildWithOffset(DJXDramaHomeFragment.this.mGridViewNetworkErrorHint, DJXDramaHomeFragment.this.mGridViewNetworkErrorHint.getHeight());
                        }
                    });
                    return;
                }
                DJXDramaHomeFragment.this.mT2WLog.sendReqEnd(true, dataWrapper.errCode, dataWrapper.errMsg, null);
                DJXDramaHomeFragment.this.resetViewVisibility(3);
                List<Object> data = dataWrapper.getData();
                Object extra = dataWrapper.getExtra();
                if (extra instanceof Boolean) {
                    DJXDramaHomeFragment.this.mHasMore = Boolean.valueOf(((Boolean) extra).booleanValue());
                }
                DramaGridAdapter dramaGridAdapter = DJXDramaHomeFragment.this.mDramaGridAdapter;
                if (DJXDramaHomeFragment.this.mInsertAdEnable) {
                    data = ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).inflateAd(data);
                }
                dramaGridAdapter.addAll(data);
                DJXDramaHomeFragment.this.mScrollerLayout.checkLayoutChange();
            }
        });
        ((DJXDramaHomeViewModel) this.mViewModel).loadHotList(formNewTopDramaIds());
        ((DJXDramaHomeViewModel) this.mViewModel).loadAllHistory();
        ((DJXDramaHomeViewModel) this.mViewModel).loadGridList(true);
        this.requestTime = Long.valueOf(SystemClock.elapsedRealtime());
        this.mT2WLog.sendReqBegin();
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment$12, reason: invalid class name */
    class AnonymousClass12 implements Observer<BaseViewModel.DataWrapper<List<Drama>>> {
        AnonymousClass12() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(BaseViewModel.DataWrapper<List<Drama>> dataWrapper) throws Resources.NotFoundException {
            if (dataWrapper == null) {
                DJXDramaHomeFragment.this.mHotExposeReporter.flush();
                return;
            }
            if (DevInfo.getPrivacyController().isTeenagerMode() && dataWrapper.getResult() == BaseViewModel.NetworkResult.SUCCESS && (dataWrapper.getData() == null || dataWrapper.getData().isEmpty())) {
                DJXDramaHomeFragment.this.mHotViewNetworkErrorHint.setVisibility(0);
                DJXDramaHomeFragment.this.mHotDramaCard1.setVisibility(4);
                DJXDramaHomeFragment.this.mHotDramaCard2.setVisibility(4);
                DJXDramaHomeFragment.this.mHotDramaCard3.setVisibility(4);
                DJXDramaHomeFragment.this.mHotExposeReporter.flush();
                return;
            }
            if (dataWrapper.getResult() == BaseViewModel.NetworkResult.FAILED) {
                DJXDramaHomeFragment.this.mHotViewNetworkErrorHint.setVisibility(0);
                DJXDramaHomeFragment.this.mHotDramaCard1.setVisibility(4);
                DJXDramaHomeFragment.this.mHotDramaCard2.setVisibility(4);
                DJXDramaHomeFragment.this.mHotDramaCard3.setVisibility(4);
                DJXDramaHomeFragment.this.mHotExposeReporter.flush();
                return;
            }
            DJXDramaHomeFragment.this.resetViewVisibility(1);
            List<Drama> data = dataWrapper.getData();
            if (data != null) {
                DJXDramaHomeFragment.this.mHotCardsData.clear();
                for (int i = 0; i < Math.min(DJXDramaHomeFragment.this.mHotCards.size(), data.size()); i++) {
                    DJXDramaHomeFragment.this.mHotCardsData.add(i, data.get(i));
                    DJXDramaHomeFragment dJXDramaHomeFragment = DJXDramaHomeFragment.this;
                    dJXDramaHomeFragment.processDramaCard((View) dJXDramaHomeFragment.mHotCards.get(i), data.get(i), 1);
                }
            }
            DJXDramaHomeFragment.this.mHotDramaCard1.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment$12$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m358x985cd267();
                }
            }, 50L);
            DJXDramaHomeFragment.this.mScrollerLayout.checkLayoutChange();
            DJXDramaHomeFragment.this.mHotExposeReporter.startChecking();
        }

        /* renamed from: lambda$onChanged$0$com-bytedance-sdk-djx-core-business-budrama-home-DJXDramaHomeFragment$12, reason: not valid java name */
        /* synthetic */ void m358x985cd267() {
            DJXDramaHomeFragment.this.sendRecHotShow();
        }
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment$13, reason: invalid class name */
    class AnonymousClass13 implements Observer<BaseViewModel.DataWrapper<List<Drama>>> {
        AnonymousClass13() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(BaseViewModel.DataWrapper<List<Drama>> dataWrapper) throws Resources.NotFoundException {
            if (dataWrapper == null) {
                DJXDramaHomeFragment.this.mHistoryExposeReporter.flush();
                return;
            }
            DJXDramaHomeFragment.this.resetViewVisibility(2);
            List<Drama> data = dataWrapper.getData();
            DJXDramaHomeFragment.this.mHistoryCardsData.clear();
            for (int i = 0; i < Math.min(DJXDramaHomeFragment.this.mHistoryCards.size(), data.size()); i++) {
                DJXDramaHomeFragment.this.mHistoryCardsData.add(i, data.get(i));
                View view = (View) DJXDramaHomeFragment.this.mHistoryCards.get(i);
                if (i == 0) {
                    view.findViewById(R.id.djx_recent_hint).setVisibility(0);
                }
                view.setVisibility(0);
                DJXDramaHomeFragment.this.processDramaCard(view, data.get(i), 2);
            }
            DJXDramaHomeFragment.this.mHistoryDramaCard1.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment$13$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m359x985cd268();
                }
            }, 50L);
            DJXDramaHomeFragment.this.mScrollerLayout.checkLayoutChange();
            DJXDramaHomeFragment.this.mHistoryExposeReporter.startChecking();
        }

        /* renamed from: lambda$onChanged$0$com-bytedance-sdk-djx-core-business-budrama-home-DJXDramaHomeFragment$13, reason: not valid java name */
        /* synthetic */ void m359x985cd268() {
            DJXDramaHomeFragment.this.sendRecHistoryShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> formNewTopDramaIds() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(((DJXWidgetDramaHomeParams) this.mParam).mTopDramaId));
        return (((DJXWidgetDramaHomeParams) this.mParam).mTopDramaIds == null || ((DJXWidgetDramaHomeParams) this.mParam).mTopDramaIds.size() <= 0) ? arrayList : ((DJXWidgetDramaHomeParams) this.mParam).mTopDramaIds;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentShow() {
        super.onFragmentShow();
        this.mT2WLog.setIsFragmentShow(true);
        this.mT2WLog.sendTotalLog();
        this.mExposeReporter.reset();
        this.mHotExposeReporter.setUserVisible(true);
        this.mHotExposeReporter.startChecking();
        this.mHistoryExposeReporter.setUserVisible(true);
        this.mHistoryExposeReporter.startChecking();
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.startCheckingShow();
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        DramaReporter.reportEnterCategory(FeedApi.CATEGORY_GRID);
        ImageTag.resume(InnerManager.getContext(), ImageTag.TAG_DRAMA_HOME);
        this.mTLog.sendPageEvent("home_page", ILogConst.EVENT_T_SHOW, null, null);
        this.mDramaGridRecycleView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m357x6ea9cd4f();
            }
        }, 50L);
    }

    /* renamed from: lambda$onFragmentShow$0$com-bytedance-sdk-djx-core-business-budrama-home-DJXDramaHomeFragment, reason: not valid java name */
    /* synthetic */ void m357x6ea9cd4f() {
        sendRecHotShow();
        sendRecHistoryShow();
        sendRecFeedShow();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentHide() {
        super.onFragmentHide();
        this.mT2WLog.setIsFragmentShow(false);
        this.mExposeReporter.flushItemDuration();
        this.mHotExposeReporter.setUserVisible(false);
        this.mHotExposeReporter.flush();
        this.mHistoryExposeReporter.setUserVisible(false);
        this.mHistoryExposeReporter.flush();
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.stopCheckingShow();
        }
        if (this.mStartTime > 0) {
            DramaReporter.reportStayCategory(FeedApi.CATEGORY_GRID, SystemClock.elapsedRealtime() - this.mStartTime);
            this.mStartTime = -1L;
        }
        ImageTag.pause(InnerManager.getContext(), ImageTag.TAG_DRAMA_HOME);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onResume() {
        super.onResume();
        if (this.mViewModel != 0) {
            ((DJXDramaHomeViewModel) this.mViewModel).refreshHistory();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy
    public void showLoadingProgress() {
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.startAnimate();
        this.mLoadingLayout.setVisibility(0);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy
    public void dismissLoadingProgress() {
        this.mLoadingLayout.setVisibility(4);
        this.mLoadingView.stopAnimate();
        this.mLoadingView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetViewVisibility(int i) {
        if (i == 1) {
            this.mHotDramaCard1.setVisibility(0);
            this.mHotDramaCard2.setVisibility(0);
            this.mHotDramaCard3.setVisibility(0);
            this.mHotViewNetworkErrorHint.setVisibility(8);
        } else if (i == 2) {
            this.mHistoryDramaCard1.setVisibility(8);
            this.mHistoryDramaCard2.setVisibility(8);
        } else if (i == 3) {
            this.mDramaGridRecycleView.setVisibility(0);
            this.mGridViewNetworkErrorHint.setVisibility(8);
        }
        this.mScrollerLayout.checkLayoutChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDramaCard(View view, final Drama drama, final int i) throws Resources.NotFoundException {
        DJXWidgetDramaDetailParams.DJXDramaEnterFrom dJXDramaEnterFrom;
        String str;
        final DJXWidgetDramaDetailParams.DJXDramaEnterFrom dJXDramaEnterFrom2;
        final String str2;
        final DJXRoundImageView dJXRoundImageView = (DJXRoundImageView) view.findViewById(R.id.djx_drama_cover);
        TextView textView = (TextView) view.findViewById(R.id.djx_drama_title);
        TextView textView2 = (TextView) view.findViewById(R.id.djx_drama_info);
        textView.setText(drama.title);
        String str3 = "";
        if (i == 1) {
            String string = getResources().getString(R.string.djx_drama_info);
            Object[] objArr = new Object[2];
            objArr[0] = drama.status == 0 ? "已完结" : "未完结";
            objArr[1] = Integer.valueOf(drama.total);
            str3 = String.format(string, objArr);
            dJXDramaEnterFrom = DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HOME;
            str = ILogConst.MODULE_HOT_SKITS;
        } else if (i == 2) {
            str3 = String.format(getResources().getString(R.string.djx_drama_history_info), Integer.valueOf(drama.index), Integer.valueOf(drama.total));
            dJXDramaEnterFrom = DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HOME_RECENTLY_WATCHED;
            str = ILogConst.MODULE_HISTORY_SKITS;
        } else {
            str2 = "";
            dJXDramaEnterFrom2 = null;
            textView2.setText(str3);
            dJXRoundImageView.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.15
                @Override // java.lang.Runnable
                public void run() {
                    String cover = ImageUtil.getCover(drama.coverImages2, drama.coverImage);
                    DJXDramaHomeFragment dJXDramaHomeFragment = DJXDramaHomeFragment.this;
                    dJXDramaHomeFragment.setImageUrl(dJXDramaHomeFragment.getContext(), dJXRoundImageView, cover);
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    DJXDramaHomeFragment.this.invokeOnItemClick(drama, i);
                    DJXDramaHomeFragment.this.enterDramaDetail(drama, dJXDramaEnterFrom2, str2);
                }
            });
        }
        dJXDramaEnterFrom2 = dJXDramaEnterFrom;
        str2 = str;
        textView2.setText(str3);
        dJXRoundImageView.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.15
            @Override // java.lang.Runnable
            public void run() {
                String cover = ImageUtil.getCover(drama.coverImages2, drama.coverImage);
                DJXDramaHomeFragment dJXDramaHomeFragment = DJXDramaHomeFragment.this;
                dJXDramaHomeFragment.setImageUrl(dJXDramaHomeFragment.getContext(), dJXRoundImageView, cover);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DJXDramaHomeFragment.this.invokeOnItemClick(drama, i);
                DJXDramaHomeFragment.this.enterDramaDetail(drama, dJXDramaEnterFrom2, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterDramaDetail(Drama drama, DJXWidgetDramaDetailParams.DJXDramaEnterFrom dJXDramaEnterFrom, String str) {
        Drama historyDrama = DramaManager.getInstance().getHistoryDrama(drama.id);
        Drama drama2 = historyDrama == null ? drama : historyDrama;
        DramaReporter.reportClickContent(FeedApi.CATEGORY_GRID, str, drama);
        DramaReporter.reportRecClick(FeedApi.CATEGORY_GRID, drama);
        DramaDetailHelper.getInstance().start(drama2, 0, dJXDramaEnterFrom, null, ((DJXWidgetDramaHomeParams) this.mParam).mDetailConfig, ((DJXWidgetDramaHomeParams) this.mParam).mEnterDelegate);
    }

    private void setNetworkErrorHint(final int i, ViewGroup viewGroup) {
        SpannableString spannableString = new SpannableString(getGlobalContext().getResources().getString(R.string.djx_network_error_hint));
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment.17
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                int i2 = i;
                if (i2 == 1) {
                    DJXDramaHomeFragment.this.requestTime = Long.valueOf(SystemClock.elapsedRealtime());
                    ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).loadHotList(DJXDramaHomeFragment.this.formNewTopDramaIds());
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    DJXDramaHomeFragment.this.mT2WLog.setReqRetryNum(DJXDramaHomeFragment.this.mT2WLog.getReqRetryNum() + 1);
                    DJXDramaHomeFragment.this.mT2WLog.sendReqBegin();
                    ((DJXDramaHomeViewModel) DJXDramaHomeFragment.this.mViewModel).loadGridList(false);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(DJXDramaHomeFragment.this.getGlobalContext().getResources().getColor(R.color.djx_white_color));
            }
        }, 5, spannableString.length(), 17);
        TextView textView = (TextView) viewGroup.getChildAt(0);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageUrl(Context context, ImageView imageView, String str) {
        Picasso.with(context).load(str).config(Bitmap.Config.RGB_565).fit().centerCrop().tag(ImageTag.TAG_DRAMA_HOME).into(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeOnItemClick(Drama drama, int i) {
        String str;
        if (((DJXWidgetDramaHomeParams) this.mParam).mListener != null) {
            if (i == 1) {
                str = IDJXDramaHomeListener.MODULE_HOT;
            } else if (i == 2) {
                str = IDJXDramaHomeListener.MODULE_HISTORY;
            } else {
                str = i != 3 ? "" : IDJXDramaHomeListener.MODULE_FEED;
            }
            if (str.isEmpty()) {
                return;
            }
            HashMap map = new HashMap();
            map.put("module", str);
            ((DJXWidgetDramaHomeParams) this.mParam).mListener.onItemClick(drama, map);
        }
    }
}
