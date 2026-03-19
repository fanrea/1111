package com.bytedance.sdk.djx.core.business.reporter;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.DJXRVExposeUtil;
import com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter;
import com.bytedance.sdk.djx.core.business.view.rv2.adapter.BaseAdapter;
import com.bytedance.sdk.djx.model.Feed;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RVExposeReporter {
    private static final int CLIENT_SHOW_DURATION_TIME = 1000;
    private IClientShowListener mListener;
    private RecyclerView mRecyclerView;
    private final DJXRVExposeUtil mExposeUtil = new DJXRVExposeUtil();
    private final Map<Integer, Long> mDurationMap = new HashMap();
    private final Map<Integer, Long> mMaxDurationMap = new HashMap();
    private final Map<Integer, Object> mDataMap = new HashMap();
    private int mShowTime = 1000;
    private final DJXRVExposeUtil.OnItemExposeListener mExposeListener = new DJXRVExposeUtil.OnItemExposeListener() { // from class: com.bytedance.sdk.djx.core.business.reporter.RVExposeReporter.1
        @Override // com.bytedance.sdk.djx.core.business.view.rv.DJXRVExposeUtil.OnItemExposeListener
        public void onItemViewVisible(boolean z, int i) {
            if (z) {
                RVExposeReporter.this.resetDuration(i);
            } else {
                RVExposeReporter.this.sendItemClientShow(i);
            }
        }
    };

    public static abstract class IClientShowListener {
        public void onItemInVisible(Object obj, int i) {
        }

        public void onItemVisible(Object obj, int i) {
        }

        public void onSendClientShow(Feed feed, int i, long j, long j2) {
        }

        public void onSendClientShow(Object obj, int i, long j, long j2) {
        }
    }

    public void init(RecyclerView recyclerView, IClientShowListener iClientShowListener) {
        this.mRecyclerView = recyclerView;
        this.mListener = iClientShowListener;
        initRecyclerView(recyclerView);
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView == null || this.mExposeUtil.getScrollListener() == null) {
            return;
        }
        this.mExposeUtil.getScrollListener().onScrolled(recyclerView, i, i2);
    }

    public void setShowTime(int i) {
        this.mShowTime = i;
    }

    public void reset() {
        resetItemsDuration();
    }

    public void flushItemDuration() {
        sendItemsClientShow();
        this.mDataMap.clear();
        this.mDurationMap.clear();
        this.mMaxDurationMap.clear();
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        this.mExposeUtil.setRecyclerItemExposeListener(recyclerView, this.mExposeListener);
    }

    private void resetItemsDuration() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        int[] position = getPosition();
        for (int i = position[0]; i <= position[1]; i++) {
            resetDuration(i);
        }
    }

    private void sendItemsClientShow() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        int[] position = getPosition();
        for (int i = position[0]; i <= position[1]; i++) {
            sendItemClientShow(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendItemClientShow(int i) {
        Long lValueOf = this.mDurationMap.get(Integer.valueOf(i));
        if (lValueOf == null || lValueOf.longValue() == 0) {
            lValueOf = Long.valueOf(System.currentTimeMillis());
            this.mDurationMap.put(Integer.valueOf(i), lValueOf);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - lValueOf.longValue();
        Long lValueOf2 = this.mMaxDurationMap.get(Integer.valueOf(i));
        if (lValueOf2 == null) {
            lValueOf2 = Long.valueOf(jCurrentTimeMillis);
            this.mMaxDurationMap.put(Integer.valueOf(i), lValueOf2);
        }
        Object data = getData(i);
        IClientShowListener iClientShowListener = this.mListener;
        if (iClientShowListener != null) {
            iClientShowListener.onItemInVisible(data, i);
        }
        if (jCurrentTimeMillis > this.mShowTime) {
            Long lValueOf3 = Long.valueOf(Math.max(jCurrentTimeMillis, lValueOf2.longValue()));
            this.mMaxDurationMap.put(Integer.valueOf(i), lValueOf3);
            IClientShowListener iClientShowListener2 = this.mListener;
            if (iClientShowListener2 != null) {
                if (data instanceof Feed) {
                    Feed feed = (Feed) data;
                    if (!feed.isType4Ad()) {
                        this.mListener.onSendClientShow(feed, i, jCurrentTimeMillis, lValueOf3.longValue());
                    }
                } else {
                    iClientShowListener2.onSendClientShow(data, i, jCurrentTimeMillis, lValueOf3.longValue());
                }
            }
        }
        this.mDurationMap.put(Integer.valueOf(i), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDuration(int i) {
        Long l = this.mDurationMap.get(Integer.valueOf(i));
        if (l == null || l.longValue() == 0) {
            this.mDurationMap.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        }
        resetData(i);
    }

    private void resetData(int i) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || this.mDataMap.get(Integer.valueOf(i)) != null) {
            return;
        }
        Object adapterItem = getAdapterItem(i);
        this.mDataMap.put(Integer.valueOf(i), adapterItem);
        IClientShowListener iClientShowListener = this.mListener;
        if (iClientShowListener != null) {
            iClientShowListener.onItemVisible(adapterItem, i);
        }
    }

    private Object getAdapterItem(int i) {
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter instanceof BaseAdapter) {
            return ((BaseAdapter) adapter).getItemData(i);
        }
        if (adapter instanceof MultiItemTypeAdapter) {
            return ((MultiItemTypeAdapter) adapter).getItemData(i);
        }
        if (adapter instanceof BaseHomePageAdapter) {
            return ((BaseHomePageAdapter) adapter).getItem(i);
        }
        return null;
    }

    private Object getData(int i) {
        return this.mDataMap.get(Integer.valueOf(i));
    }

    private int[] getPosition() {
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArrFindRangeStaggeredGrid = DJXRVExposeUtil.findRangeStaggeredGrid((StaggeredGridLayoutManager) layoutManager);
            iFindFirstVisibleItemPosition = iArrFindRangeStaggeredGrid[0];
            iFindLastVisibleItemPosition = iArrFindRangeStaggeredGrid[1];
        } else {
            iFindFirstVisibleItemPosition = -1;
            iFindLastVisibleItemPosition = -2;
        }
        return new int[]{iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition};
    }
}
