package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.djx.base.dynamic.DynamicManager;
import com.bytedance.sdk.djx.core.api.req.FeedApi;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.ad.open.OpenBannerAd;
import com.bytedance.sdk.djx.core.business.base.FragProxy;
import com.bytedance.sdk.djx.core.business.budrama.DefaultDramaParamsWrapperKt;
import com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment;
import com.bytedance.sdk.djx.core.business.view.DJXDrawTitleBar;
import com.bytedance.sdk.djx.core.business.view.DJXDrawTitleRefresh;
import com.bytedance.sdk.djx.core.business.view.refresh.IRefresh;
import com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab;
import com.bytedance.sdk.djx.core.business.view.tab.NewsTabFragDelegate;
import com.bytedance.sdk.djx.core.business.view.tab.NewsTabFragPagerAdapter;
import com.bytedance.sdk.djx.core.business.view.tab.NewsViewPager;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.model.ev.BEDrawBox4Recommend;
import com.bytedance.sdk.djx.model.ev.BERecommendSwitch;
import com.bytedance.sdk.djx.model.ev.BESeekStart;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.MessageTimer;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawBoxFragment extends FragProxy {
    private static final float RATIO = 0.15f;
    public static final String TAB_DRAW_FEED = "draw_feed";
    public static final String TAB_THEATER = "theater";
    private static final String TAG = "DJXDrawBoxFragment";
    private OpenBannerAd mBannerAd;
    private FrameLayout mBannerAdContainer;
    private AdKey mBannerAdKey;
    private FrameLayout mBottomBannerContainer;
    private View mContentLayout;
    private int mCurrentPosition;
    private FrameLayout mCustomBannerContainer;
    private NewsTabFragPagerAdapter mPagerAdapter;
    private DJXDrawTitleBar mTitleBar;
    private FrameLayout mTopBannerContainer;
    private NewsViewPager mViewPager;
    private DJXWidgetDrawParams mWidgetParams;
    private String mEnterType = ILogConst.DRAW_ENTER_TYPE_OTHER;
    private boolean mIsDragged = false;
    private final DrawRefreshHelper mRefreshHelper = new DrawRefreshHelper();
    private final List<FragProxy> mFragments = new ArrayList();
    private final SettingData mSettingData = SettingData.getInstance();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final MessageTimer mMessageTimer = MessageTimer.get();
    private boolean mForTheFirstTimeLoadBanner = true;
    private boolean mFragmentInvisible = false;
    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (DJXDrawBoxFragment.this.mCurrentPosition >= 0 && DJXDrawBoxFragment.this.mCurrentPosition < DJXDrawBoxFragment.this.mFragments.size()) {
                FragProxy fragProxy = (FragProxy) DJXDrawBoxFragment.this.mFragments.get(DJXDrawBoxFragment.this.mCurrentPosition);
                if (fragProxy instanceof DJXDrawFragment) {
                    ((DJXDrawFragment) fragProxy).slide2Invisible();
                }
            }
            DJXDrawBoxFragment.this.mCurrentPosition = i;
            if (DJXDrawBoxFragment.this.mIsDragged) {
                DJXDrawBoxFragment.this.mIsDragged = false;
                DJXDrawBoxFragment.this.mEnterType = ILogConst.DRAW_ENTER_TYPE_SLIDE;
            }
            NewsPagerSlidingTab.Tab tab = DJXDrawBoxFragment.this.mPagerAdapter.getTab(i);
            if (DJXDrawBoxFragment.this.mWidgetParams == null || DJXDrawBoxFragment.this.mWidgetParams.mListener == null) {
                return;
            }
            try {
                DJXDrawBoxFragment.this.mWidgetParams.mListener.onChannelTabChange(DJXDrawBoxFragment.this.getChannelType(tab.getId()));
            } catch (Throwable th) {
                LG.e(DJXDrawBoxFragment.TAG, "error occurred: IDJXDrawListener.onChannelTabChange()", th);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            DJXDrawBoxFragment.this.mIsDragged = i != 0;
        }
    };
    private final IDrawBoxListener mBoxListener = new IDrawBoxListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.4
        @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.IDrawBoxListener
        public String getEnterType() {
            return TextUtils.isEmpty(DJXDrawBoxFragment.this.mEnterType) ? super.getEnterType() : DJXDrawBoxFragment.this.mEnterType;
        }

        @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.IDrawBoxListener
        public IRefresh getRefresh() {
            return DJXDrawBoxFragment.this.mRefreshHelper;
        }

        @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.IDrawBoxListener
        public DJXDrawTitleBar getTitleBar() {
            return DJXDrawBoxFragment.this.mTitleBar;
        }

        @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.IDrawBoxListener
        public void onFinishRefresh() {
            if (DJXDrawBoxFragment.this.getMyActivity() == null || DJXDrawBoxFragment.this.getMyActivity().isFinishing() || DJXDrawBoxFragment.this.mTitleBar == null) {
                return;
            }
            DJXDrawBoxFragment.this.mTitleBar.showLoading(false);
        }
    };
    private final IBusListener mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.5
        public void onBusEvent(BusEvent busEvent) {
            NewsPagerSlidingTab.Tab tab;
            if (busEvent instanceof BEDrawBox4Recommend) {
                if (DJXDrawBoxFragment.this.getMyActivity() == null || DJXDrawBoxFragment.this.getMyActivity().isFinishing() || DJXDrawBoxFragment.this.mViewPager == null) {
                    return;
                }
                DJXDrawBoxFragment.this.mViewPager.setCurrentItem(0, true);
                return;
            }
            if (busEvent instanceof BERecommendSwitch) {
                if (DJXDrawBoxFragment.this.mPagerAdapter == null || (tab = DJXDrawBoxFragment.this.mPagerAdapter.getTab(DJXDrawBoxFragment.TAB_DRAW_FEED)) == null) {
                    return;
                }
                tab.setText(DJXDrawBoxFragment.this.getTabName4Recommend());
                return;
            }
            if (busEvent instanceof BESeekStart) {
                BESeekStart bESeekStart = (BESeekStart) busEvent;
                if (DJXDrawBoxFragment.this.mViewPager != null) {
                    DJXDrawBoxFragment.this.mViewPager.setCanScroller(!bESeekStart.isStart());
                    return;
                }
                return;
            }
            if (busEvent instanceof BEAdCome) {
                BEAdCome bEAdCome = (BEAdCome) busEvent;
                if (DJXDrawBoxFragment.this.mBannerAdKey == null || !TextUtils.equals(bEAdCome.getCodeId(), DJXDrawBoxFragment.this.mBannerAdKey.getCodeId())) {
                    return;
                }
                Log.i(DJXDrawBoxFragment.TAG, "BEAdCome, codeId = " + DJXDrawBoxFragment.this.mBannerAdKey);
            }
        }
    };
    private final NewsTabFragPagerAdapter.FragFactory mFactory = new NewsTabFragPagerAdapter.FragFactory() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.6
        @Override // com.bytedance.sdk.djx.core.business.view.tab.NewsTabFragPagerAdapter.FragFactory
        public FragProxy newItemFragment(boolean z, int i) {
            return (FragProxy) DJXDrawBoxFragment.this.mFragments.get(i);
        }
    };

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    public void editAdKey() {
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
    }

    public void setWidgetParams(DJXWidgetDrawParams dJXWidgetDrawParams) {
        this.mWidgetParams = dJXWidgetDrawParams;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_frag_draw_box);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initData(Bundle bundle) {
        DJXBus.getInstance().addListener(this.mBusListener);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initView(View view) {
        this.mContentLayout = findById(R.id.djx_content_layout);
        this.mTitleBar = (DJXDrawTitleBar) findById(R.id.djx_draw_box_title_bar);
        DJXDrawTitleRefresh dJXDrawTitleRefresh = (DJXDrawTitleRefresh) findById(R.id.djx_draw_box_title_refresh);
        this.mViewPager = (NewsViewPager) findById(R.id.djx_draw_box_pager);
        this.mCustomBannerContainer = (FrameLayout) findById(R.id.djx_draw_box_banner);
        this.mTopBannerContainer = (FrameLayout) findById(R.id.djx_top_banner);
        this.mBottomBannerContainer = (FrameLayout) findById(R.id.djx_bottom_banner);
        this.mRefreshHelper.init(this.mTitleBar, dJXDrawTitleRefresh);
        initTitleBar();
        initFrags();
        initPagers();
        initTabs();
        loadCustomAd();
    }

    private void loadCustomAd() {
        View drawBoxAdBannerView;
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        if (dJXWidgetDrawParams == null || dJXWidgetDrawParams.mDetailConfig == null || this.mWidgetParams.mDetailConfig.getAdCustomProvider() == null || !SettingData.getInstance().isBannerCustomBoxOpen() || (drawBoxAdBannerView = this.mWidgetParams.mDetailConfig.getAdCustomProvider().getDrawBoxAdBannerView()) == null) {
            return;
        }
        this.mCustomBannerContainer.addView(drawBoxAdBannerView);
        this.mCustomBannerContainer.setVisibility(0);
    }

    private void initTitleBar() {
        this.mTitleBar.initTitle(this.mWidgetParams);
        this.mTitleBar.setCloseListener(true, new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawBoxFragment.this.mWidgetParams != null && DJXDrawBoxFragment.this.mWidgetParams.mCloseListener != null) {
                    try {
                        DJXDrawBoxFragment.this.mWidgetParams.mCloseListener.onClick(view);
                    } catch (Throwable th) {
                        LG.e(DJXDrawBoxFragment.TAG, "error occurred: IDJXDrawListener.mCloseListener.onClick()", th);
                    }
                } else if (DJXDrawBoxFragment.this.getMyActivity() != null) {
                    DJXDrawBoxFragment.this.getMyActivity().finish();
                }
                if (DJXDrawBoxFragment.this.mWidgetParams == null || DJXDrawBoxFragment.this.mWidgetParams.mListener == null) {
                    return;
                }
                try {
                    DJXDrawBoxFragment.this.mWidgetParams.mListener.onDJXClose();
                } catch (Throwable th2) {
                    LG.e(DJXDrawBoxFragment.TAG, "error occurred: IDJXDrawListener.onDJXClose()", th2);
                }
            }
        });
    }

    private void initFrags() {
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        if (dJXWidgetDrawParams == null) {
            LG.e(TAG, "DJXWidgetDrawParams is null");
            return;
        }
        DJXWidgetDramaHomeParams dJXWidgetDramaHomeParamsShowPageTitle = DJXWidgetDramaHomeParams.obtain(dJXWidgetDrawParams.mDetailConfig == null ? DefaultDramaParamsWrapperKt.getDefaultDramaDetailConfig() : this.mWidgetParams.mDetailConfig).setTopOffset(42).showPageTitle(false);
        DJXDrawFragment dJXDrawFragment = new DJXDrawFragment();
        DJXWidgetDrawParams dJXWidgetDrawParams2 = this.mWidgetParams;
        if (dJXWidgetDrawParams2 != null) {
            dJXDrawFragment.setWidgetParams(dJXWidgetDrawParams2);
        }
        dJXDrawFragment.setDrawBoxListener(this.mBoxListener);
        this.mFragments.add(dJXDrawFragment);
        DJXDramaHomeFragment dJXDramaHomeFragment = new DJXDramaHomeFragment(dJXWidgetDramaHomeParamsShowPageTitle);
        if (isShowTheaterTab()) {
            this.mFragments.add(dJXDramaHomeFragment);
        }
    }

    private void initTabs() {
        NewsPagerSlidingTab tabsSlidingView = this.mTitleBar.getTabsSlidingView();
        tabsSlidingView.setVisibility(isHideTabName() ? 4 : 0);
        tabsSlidingView.setTabTextColorNormal(getResources().getColor(R.color.djx_white_80));
        tabsSlidingView.setTabTextColorSelected(getResources().getColor(R.color.djx_white_color));
        tabsSlidingView.setRoundCorner(true);
        tabsSlidingView.setEnableIndicatorAnim(true);
        tabsSlidingView.setEnableScroll(false);
        tabsSlidingView.setThreShold(3);
        tabsSlidingView.setBottomDividerColor(getResources().getColor(R.color.djx_transparent_color));
        tabsSlidingView.setTabContainerGravity(17);
        tabsSlidingView.setIndicatorColor(Color.parseColor("#FFFFFF"));
        tabsSlidingView.setIndicatorWidth(UIUtil.dp2px(20.0f));
        tabsSlidingView.setViewPager(this.mViewPager);
        tabsSlidingView.setOnPageChangeListener(this.mOnPageChangeListener);
        tabsSlidingView.setTabClickListener(new NewsPagerSlidingTab.TabClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.2
            @Override // com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.TabClickListener
            public void onTabClick(int i) {
                DJXDrawBoxFragment.this.mEnterType = "click";
            }
        });
    }

    private void initPagers() {
        FragmentManager fragmentManager;
        if (isV4Support()) {
            this.mPagerAdapter = new NewsTabFragPagerAdapter(getMyActivity(), this.mFragment.getChildFragmentManager(), this.mFactory);
        } else {
            if (Build.VERSION.SDK_INT >= 17) {
                fragmentManager = this.mFragmentApp.getChildFragmentManager();
            } else {
                fragmentManager = this.mFragmentApp.getFragmentManager();
            }
            this.mPagerAdapter = new NewsTabFragPagerAdapter(getMyActivity(), fragmentManager, this.mFactory);
        }
        this.mPagerAdapter.setParent(this);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        List<NewsTabFragDelegate> tabFragmentDelegates = getTabFragmentDelegates();
        if (tabFragmentDelegates.isEmpty()) {
            return;
        }
        this.mViewPager.setOffscreenPageLimit(tabFragmentDelegates.size());
        this.mPagerAdapter.setFragments(tabFragmentDelegates);
        this.mPagerAdapter.notifyDataSetChanged();
    }

    private List<NewsTabFragDelegate> getTabFragmentDelegates() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NewsTabFragDelegate(new NewsPagerSlidingTab.Tab(TAB_DRAW_FEED, getTabName4Recommend())));
        if (isShowTheaterTab()) {
            arrayList.add(new NewsTabFragDelegate(new NewsPagerSlidingTab.Tab(TAB_THEATER, "剧场")));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTabName4Recommend() {
        if (TokenHelper.getInstance().getRecommendSwitch()) {
            return "推荐";
        }
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        return (dJXWidgetDrawParams == null || TextUtils.isEmpty(dJXWidgetDrawParams.mCustomCategory)) ? "首页" : this.mWidgetParams.mCustomCategory;
    }

    private boolean isHideTabName() {
        return this.mWidgetParams.mIsHideChannelName && this.mWidgetParams.mDrawChannelType != 3;
    }

    private boolean isShowTheaterTab() {
        return (this.mWidgetParams.mDrawChannelType & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getChannelType(String str) {
        str.hashCode();
        if (str.equals(TAB_THEATER)) {
            return 2;
        }
        return !str.equals(TAB_DRAW_FEED) ? -1 : 1;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDetach() {
        super.onDetach();
        DJXBus.getInstance().removeListener(this.mBusListener);
        this.mMessageTimer.removeAllTimer();
        this.mForTheFirstTimeLoadBanner = true;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentShow() {
        super.onFragmentShow();
        this.mEnterType = ILogConst.DRAW_ENTER_TYPE_OTHER;
        this.mFragmentInvisible = false;
        for (int i = 0; i < this.mFragments.size(); i++) {
            this.mFragments.get(i).editAdKey();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentHide() {
        super.onFragmentHide();
        this.mFragmentInvisible = true;
        for (int i = 0; i < this.mFragments.size(); i++) {
            this.mFragments.get(i).editAdKey();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FragProxy currentFragProxy = getCurrentFragProxy();
        if (currentFragProxy != null) {
            currentFragProxy.setUserVisibleHint(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        FragProxy currentFragProxy = getCurrentFragProxy();
        if (currentFragProxy != null) {
            currentFragProxy.onHiddenChanged(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void refresh() {
        super.refresh();
        FragProxy currentFragProxy = getCurrentFragProxy();
        if (currentFragProxy != null) {
            currentFragProxy.refresh();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void scrollToTop() {
        super.scrollToTop();
        FragProxy currentFragProxy = getCurrentFragProxy();
        if (currentFragProxy != null) {
            currentFragProxy.scrollToTop();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public boolean canBackPress() {
        FragProxy currentFragProxy = getCurrentFragProxy();
        if (currentFragProxy != null) {
            return currentFragProxy.canBackPress();
        }
        return super.canBackPress();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void backRefresh() {
        super.backRefresh();
        FragProxy currentFragProxy = getCurrentFragProxy();
        if (currentFragProxy != null) {
            currentFragProxy.backRefresh();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void destroy() {
        super.destroy();
        FragProxy currentFragProxy = getCurrentFragProxy();
        if (currentFragProxy != null) {
            currentFragProxy.destroy();
        }
    }

    public FragProxy getCurrentFrag(String str) {
        int tabPositionById;
        NewsTabFragPagerAdapter newsTabFragPagerAdapter = this.mPagerAdapter;
        if (newsTabFragPagerAdapter == null || (tabPositionById = newsTabFragPagerAdapter.getTabPositionById(str)) < 0 || tabPositionById >= this.mFragments.size()) {
            return null;
        }
        FragProxy fragProxy = this.mFragments.get(tabPositionById);
        if (fragProxy == null || tabPositionById == this.mCurrentPosition) {
            return fragProxy;
        }
        this.mViewPager.setCurrentItem(tabPositionById, false);
        return fragProxy;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public boolean setCurrentPage(int i) {
        FragProxy currentFrag = getCurrentFrag(TAB_DRAW_FEED);
        if (currentFrag != null) {
            return currentFrag.setCurrentPage(i);
        }
        return super.setCurrentPage(i);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void seekTo(long j) {
        FragProxy currentFrag = getCurrentFrag(TAB_DRAW_FEED);
        if (currentFrag != null) {
            currentFrag.seekTo(j);
        }
    }

    private FragProxy getCurrentFragProxy() {
        int currentItem;
        NewsViewPager newsViewPager = this.mViewPager;
        if (newsViewPager == null || (currentItem = newsViewPager.getCurrentItem()) < 0 || currentItem >= this.mFragments.size()) {
            return null;
        }
        return this.mFragments.get(currentItem);
    }

    private void initBannerAd() {
        int videoBannerAwake = this.mSettingData.getVideoBannerAwake();
        if (videoBannerAwake < 0) {
            LG.i(TAG, "initBannerAd, bannerAwake = " + videoBannerAwake);
            return;
        }
        String videoBannerAdCodeId = DynamicManager.getInstance().getVideoBannerAdCodeId();
        int i = (int) (r2.widthPixels / Resources.getSystem().getDisplayMetrics().density);
        int i2 = (int) (i * RATIO);
        LG.i(TAG, "initBannerAdData bannerCodeId = " + videoBannerAdCodeId + " ,width = " + i + " ,height = " + i2);
        this.mBannerAdKey = AdKey.obtain().codeId(videoBannerAdCodeId).commonParams(null).width(i).height(i2).paramsCode(this.mWidgetParams.hashCode()).featureValues(FeedApi.getFeatureValues("hotsoon_video_detail_draw", this.mWidgetParams.mDrawContentType)).category("hotsoon_video_detail_draw");
        editAdKey();
        AdManager adManagerInst = AdManager.inst();
        AdKey adKey = this.mBannerAdKey;
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        adManagerInst.buildAdLoader(8, adKey, dJXWidgetDrawParams != null ? dJXWidgetDrawParams.mAdListener : null);
        AdManager.inst().hasAd(this.mBannerAdKey, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBannerAd() {
        if (this.mBannerAdKey != null && this.mBannerAd == null) {
            IDJXAd ad = AdManager.inst().getAd(this.mBannerAdKey);
            LG.i(TAG, "loadBanner ad , BannerAdKey code = " + this.mBannerAdKey.getCodeId() + " , Ad = " + ad);
            if (ad instanceof OpenBannerAd) {
                this.mBannerAd = (OpenBannerAd) ad;
                int videoBannerAwake = this.mSettingData.getVideoBannerAwake();
                if (this.mForTheFirstTimeLoadBanner) {
                    this.mForTheFirstTimeLoadBanner = false;
                    if (videoBannerAwake >= 0) {
                        LG.i(TAG, "banner delay, bannerAwake = " + videoBannerAwake);
                        this.mMessageTimer.addTimer(videoBannerAwake * 1000, false, new MessageTimer.TimerCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.7
                            public void onTick() {
                                LG.i(DJXDrawBoxFragment.TAG, "banner awake reached, show banner");
                                DJXDrawBoxFragment.this.showBanner();
                            }
                        });
                        return;
                    } else {
                        LG.i(TAG, "Do not show banner, bannerAwake = " + videoBannerAwake);
                        return;
                    }
                }
                LG.i(TAG, "Do show banner, mForTheFirstTimeLoadBanner = false");
                showBanner();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBanner() {
        if (this.mBannerAd == null) {
            return;
        }
        int videoBannerLoopDuration = this.mSettingData.getVideoBannerLoopDuration();
        if (this.mFragmentInvisible) {
            LG.i(TAG, "fragment invisible, add loop timer, bannerLoopDuration = " + videoBannerLoopDuration);
            this.mMessageTimer.addTimer(videoBannerLoopDuration * 1000, false, new MessageTimer.TimerCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.8
                public void onTick() {
                    LG.i(DJXDrawBoxFragment.TAG, "case: fragment invisible, loop timer on tick, show banner");
                    DJXDrawBoxFragment.this.showBanner();
                }
            });
            return;
        }
        LG.i(TAG, "show banner, fragment visible ");
        Activity myActivity = getMyActivity();
        if (myActivity != null) {
            this.mBannerAd.setDislikeCallback(myActivity, new AnonymousClass9(videoBannerLoopDuration));
        }
        View adView = this.mBannerAd.getAdView();
        if (adView == null) {
            LG.i(TAG, "show banner , banner ad getAdView == null");
            return;
        }
        int videoBannerLocation = this.mSettingData.getVideoBannerLocation();
        int videoBannerCarousel = this.mSettingData.getVideoBannerCarousel();
        this.mBannerAd.setSlideIntervalTime(videoBannerCarousel * 1000);
        this.mBannerAdContainer = videoBannerLocation == 1 ? this.mBottomBannerContainer : this.mTopBannerContainer;
        LG.i(TAG, "show banner , banner ad carousel = " + videoBannerCarousel + ", location = " + videoBannerLocation + ", loop = " + videoBannerLoopDuration);
        this.mBannerAdContainer.removeAllViews();
        this.mBannerAdContainer.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.mBannerAdContainer.addView(adView, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mBannerAdContainer.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = UIUtil.getScreenWidth(this.mBannerAdContainer.getContext());
            layoutParams2.height = (int) (layoutParams2.width * RATIO);
        }
        this.mBannerAdContainer.setLayoutParams(layoutParams2);
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment$9, reason: invalid class name */
    class AnonymousClass9 extends OpenBannerAd.DislikeCallbackAdapter {
        final /* synthetic */ int val$bannerLoopDuration;

        AnonymousClass9(int i) {
            this.val$bannerLoopDuration = i;
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenBannerAd.DislikeCallbackAdapter, com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
        public void onSelected(int i, String str) {
            LG.i(DJXDrawBoxFragment.TAG, "banner ad onSelected pos = " + i + " , value = " + str);
            DJXDrawBoxFragment.this.mBannerAd.dismissByReflect();
            DJXDrawBoxFragment.this.mBannerAd = null;
            if (DJXDrawBoxFragment.this.mBannerAdContainer != null) {
                DJXDrawBoxFragment.this.mBannerAdContainer.removeAllViews();
                DJXDrawBoxFragment.this.mBannerAdContainer.setVisibility(8);
            }
            DJXDrawBoxFragment.this.mMessageTimer.addTimer(this.val$bannerLoopDuration * 1000, false, new MessageTimer.TimerCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.9.1
                public void onTick() {
                    LG.i(DJXDrawBoxFragment.TAG, "close banner ad, timer onTick");
                    DJXDrawBoxFragment.this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment.9.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.i(DJXDrawBoxFragment.TAG, "close timer on tick, load banner ad.");
                            DJXDrawBoxFragment.this.loadBannerAd();
                        }
                    });
                }
            });
        }
    }

    static abstract class IDrawBoxListener {
        public String getEnterType() {
            return ILogConst.DRAW_ENTER_TYPE_OTHER;
        }

        public IRefresh getRefresh() {
            return null;
        }

        public DJXDrawTitleBar getTitleBar() {
            return null;
        }

        public void onFinishRefresh() {
        }

        IDrawBoxListener() {
        }
    }
}
