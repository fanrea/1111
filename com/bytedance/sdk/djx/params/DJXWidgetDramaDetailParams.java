package com.bytedance.sdk.djx.params;

import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXWidgetDramaDetailParams {
    public final DJXDramaDetailConfig detailConfig;
    public final long id;
    public final int index;
    public Map<String, Object> mRecMap;
    public int mCurrentDuration = 0;
    public String mFromGid = "";
    public DJXDramaEnterFrom mFrom = DJXDramaEnterFrom.DEFAULT;

    public enum DJXDramaEnterFrom {
        DEFAULT,
        SKIT_MIXED,
        DRAMA_HOME_RECENTLY_WATCHED,
        DRAMA_HOME,
        DRAMA_HISTORY,
        DRAMA_CARD
    }

    public static DJXWidgetDramaDetailParams obtain(long j, int i, DJXDramaDetailConfig dJXDramaDetailConfig) {
        return new DJXWidgetDramaDetailParams(j, i, dJXDramaDetailConfig);
    }

    private DJXWidgetDramaDetailParams(long j, int i, DJXDramaDetailConfig dJXDramaDetailConfig) {
        this.id = j;
        this.index = i;
        this.detailConfig = dJXDramaDetailConfig;
    }

    public DJXWidgetDramaDetailParams currentDuration(int i) {
        this.mCurrentDuration = i;
        return this;
    }

    public DJXWidgetDramaDetailParams fromGid(String str) {
        this.mFromGid = str;
        return this;
    }

    public DJXWidgetDramaDetailParams from(DJXDramaEnterFrom dJXDramaEnterFrom) {
        this.mFrom = dJXDramaEnterFrom;
        return this;
    }

    public DJXWidgetDramaDetailParams recMap(Map<String, Object> map) {
        this.mRecMap = map;
        return this;
    }

    public String toString() {
        return "DJXWidgetDramaDetailParams{id=" + this.id + ", index=" + this.index + ", mDetailConfig=" + this.detailConfig + ", mCurrentDuration=" + this.mCurrentDuration + '}';
    }
}
