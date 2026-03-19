package com.bytedance.sdk.djx.core.business.budrama;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.sdk.djx.core.util.VisibilityChecker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ItemExposeReporter {
    private static final int CLIENT_SHOW_DURATION_TIME = 1000;
    private View mItemView;
    private IClientShowListener mListener;
    private boolean mUserVisible;
    private final Map<Object, Long> mDurationMap = new HashMap();
    private final Map<Object, Long> mMaxDurationMap = new HashMap();
    private final Map<Object, Object> mDataMap = new HashMap();
    private int mShowTime = 1000;

    public interface IClientShowListener {
        List<? extends Object> getDatas();

        Object getKey(Object obj);

        void onSendClientShow(Object obj, long j, long j2);
    }

    public void init(View view, IClientShowListener iClientShowListener) {
        this.mItemView = view;
        this.mListener = iClientShowListener;
    }

    public void setShowTime(int i) {
        this.mShowTime = i;
    }

    public void setUserVisible(boolean z) {
        this.mUserVisible = z;
    }

    public void startChecking() {
        if (isVisible()) {
            List<? extends Object> datas = this.mListener.getDatas();
            if (datas != null) {
                datas = new ArrayList<>();
            }
            HashMap map = new HashMap();
            for (Object obj : datas) {
                Object key = this.mListener.getKey(obj);
                if (!this.mDataMap.containsKey(key)) {
                    this.mDataMap.put(key, obj);
                    this.mDurationMap.put(key, Long.valueOf(SystemClock.elapsedRealtime()));
                }
                map.put(key, obj);
            }
            Iterator<Object> it = this.mDataMap.keySet().iterator();
            while (it.hasNext()) {
                Object key2 = this.mListener.getKey(it.next());
                if (!map.containsKey(key2)) {
                    sendItemClientShow(key2);
                }
            }
            return;
        }
        flush();
    }

    public void flush() {
        sendItemsClientShow();
        this.mDataMap.clear();
        this.mDurationMap.clear();
        this.mMaxDurationMap.clear();
    }

    public boolean isVisible() {
        return this.mUserVisible && VisibilityChecker.isVisible(this.mItemView);
    }

    private void sendItemsClientShow() {
        Iterator<Map.Entry<Object, Object>> it = this.mDataMap.entrySet().iterator();
        while (it.hasNext()) {
            sendItemClientShow(it.next().getKey());
        }
    }

    private void sendItemClientShow(Object obj) {
        if (!this.mDataMap.containsKey(obj)) {
            this.mDurationMap.put(obj, 0L);
            return;
        }
        Long lValueOf = this.mDurationMap.get(obj);
        if (lValueOf == null || lValueOf.longValue() == 0) {
            lValueOf = Long.valueOf(SystemClock.elapsedRealtime());
            this.mDurationMap.put(obj, lValueOf);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - lValueOf.longValue();
        Long lValueOf2 = this.mMaxDurationMap.get(obj);
        if (lValueOf2 == null) {
            lValueOf2 = Long.valueOf(jElapsedRealtime);
            this.mMaxDurationMap.put(obj, lValueOf2);
        }
        Object obj2 = this.mDataMap.get(obj);
        if (jElapsedRealtime > this.mShowTime) {
            Long lValueOf3 = Long.valueOf(Math.max(jElapsedRealtime, lValueOf2.longValue()));
            this.mMaxDurationMap.put(obj2, lValueOf3);
            this.mListener.onSendClientShow(obj2, jElapsedRealtime, lValueOf3.longValue());
        }
        this.mDurationMap.put(obj, 0L);
    }
}
