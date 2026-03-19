package com.bytedance.sdk.djx.core.business.budrama.history;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.base.BaseViewModel;
import com.bytedance.sdk.djx.core.business.base.FragMVVMProxy;
import com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter;
import com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDmtLoadingLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.log.SdkTLog;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.net.HomePageImageTag;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHistoryParam;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaHistoryFragment extends FragMVVMProxy<DJXDramaHistoryViewModel, DJXWidgetDramaHistoryParam> {
    private DramaHistoryAdapter mAdapter;
    private boolean mHasMore;
    private DJXDmtLoadingLayout mLoadingLayout;
    private FrameLayout mNetworkErrorHintLayout;
    private RecyclerView mRecyclerView;
    private final RVExposeReporter mExposeReporter = new RVExposeReporter();
    private final SdkTLog mTLog = new SdkTLog();

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_frag_basic_recycler_view);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initView(View view) {
        super.initView(view);
        this.mRecyclerView = (RecyclerView) findById(R.id.djx_favorite_video_recycler_view);
        DramaHistoryAdapter dramaHistoryAdapter = new DramaHistoryAdapter((DJXDramaHistoryViewModel) this.mViewModel, (DJXWidgetDramaHistoryParam) this.mParam, this.mRecyclerView) { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryFragment.1
            @Override // com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter
            public void bindFooterViewHolder(BaseHomePageAdapter.FooterItemHolder footerItemHolder) {
                if (!DJXDramaHistoryFragment.this.mHasMore) {
                    footerItemHolder.mTextView.setText(R.string.djx_no_more_video_hint1);
                    footerItemHolder.mArrowImage.setVisibility(8);
                } else {
                    footerItemHolder.mTextView.setText(R.string.djx_author_loadmore_yes);
                    footerItemHolder.mArrowImage.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter
            public void bindEmptyItemContent(BaseHomePageAdapter.EmptyItemHolder emptyItemHolder) {
                super.bindEmptyItemContent(emptyItemHolder);
                emptyItemHolder.mGotoWatchVideo.setVisibility(8);
            }
        };
        this.mAdapter = dramaHistoryAdapter;
        dramaHistoryAdapter.setEmptyItemButtonClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryFragment.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    HomePageImageTag.resumeHomePageImageLoad(DJXDramaHistoryFragment.this.getGlobalContext());
                } else {
                    HomePageImageTag.pauseHomePageImageLoad(DJXDramaHistoryFragment.this.getGlobalContext());
                }
            }
        });
        this.mLoadingLayout = (DJXDmtLoadingLayout) findById(R.id.djx_loading_layout);
        this.mNetworkErrorHintLayout = (FrameLayout) findById(R.id.djx_network_error_hint);
        this.mExposeReporter.init(this.mRecyclerView, new RVExposeReporter.IClientShowListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryFragment.4
            @Override // com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter.IClientShowListener
            public void onItemInVisible(Object obj, int i) {
            }

            @Override // com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter.IClientShowListener
            public void onItemVisible(Object obj, int i) {
            }

            @Override // com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter.IClientShowListener
            public void onSendClientShow(Object obj, int i, long j, long j2) {
                if (obj instanceof Drama) {
                    DramaHistoryReporter.clientShow((DJXWidgetDramaHistoryParam) DJXDramaHistoryFragment.this.mParam, (Drama) obj, j, j2, DJXDramaHistoryFragment.this.mCommonParams);
                }
            }
        });
        setNetworkHintSpan();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
        super.processLogic();
        ((DJXDramaHistoryViewModel) this.mViewModel).mDramaHistoryData.observe(getViewLifecycleOwner(), new Observer<BaseViewModel.DataWrapper<List<Drama>>>() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryFragment.5
            @Override // androidx.lifecycle.Observer
            public void onChanged(BaseViewModel.DataWrapper<List<Drama>> dataWrapper) {
                if (dataWrapper == null) {
                    return;
                }
                if (dataWrapper.getResult() != BaseViewModel.NetworkResult.FAILED || DJXDramaHistoryFragment.this.mAdapter == null || !DJXDramaHistoryFragment.this.mAdapter.isEmptyDataList()) {
                    if (DJXDramaHistoryFragment.this.mRecyclerView.getVisibility() != 0) {
                        DJXDramaHistoryFragment.this.mRecyclerView.setVisibility(0);
                    }
                    if (DJXDramaHistoryFragment.this.mNetworkErrorHintLayout.getVisibility() != 8) {
                        DJXDramaHistoryFragment.this.mNetworkErrorHintLayout.setVisibility(8);
                    }
                    List<Drama> data = dataWrapper.getData();
                    Object extra = dataWrapper.getExtra();
                    if (extra instanceof Boolean) {
                        DJXDramaHistoryFragment.this.mHasMore = ((Boolean) extra).booleanValue();
                    }
                    DJXDramaHistoryFragment.this.mAdapter.appendData((List) data);
                    return;
                }
                DJXDramaHistoryFragment.this.mRecyclerView.setVisibility(8);
                DJXDramaHistoryFragment.this.mNetworkErrorHintLayout.setVisibility(0);
            }
        });
        ((DJXDramaHistoryViewModel) this.mViewModel).loadAllDramaHistory(true);
    }

    private void setNetworkHintSpan() {
        SpannableString spannableString = new SpannableString(getGlobalContext().getResources().getString(R.string.djx_network_error_hint));
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryFragment.6
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ((DJXDramaHistoryViewModel) DJXDramaHistoryFragment.this.mViewModel).loadAllDramaHistory(true);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(DJXDramaHistoryFragment.this.getGlobalContext().getResources().getColor(R.color.djx_white_color));
            }
        }, 5, spannableString.length(), 17);
        TextView textView = (TextView) this.mNetworkErrorHintLayout.getChildAt(0);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy
    public void showLoadingProgress() {
        this.mLoadingLayout.setVisibility(0);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy
    public void dismissLoadingProgress() {
        this.mLoadingLayout.setVisibility(4);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentShow() {
        super.onFragmentShow();
        this.mExposeReporter.reset();
        this.mTLog.sendPageEvent(ILogConst.Params.SCENE_HISTORY_PAGE, ILogConst.EVENT_T_SHOW, null, null);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentHide() {
        super.onFragmentHide();
        this.mExposeReporter.flushItemDuration();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMVVMProxy, com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onResume() {
        super.onResume();
        this.mAdapter.refreshData();
    }
}
