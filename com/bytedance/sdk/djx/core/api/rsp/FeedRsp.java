package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FeedRsp extends BaseDjxRsp<List<Feed>> {
    private int mFavouriteCursor;
    private boolean mHasMore = true;
    private String mOriginal;
    private JSONArray mPreloadData;
    private int mWorksCount;

    public String getOriginal() {
        return this.mOriginal;
    }

    public void setOriginal(String str) {
        this.mOriginal = str;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    @Override // com.bytedance.sdk.djx.net.api.BaseRsp
    public List<Feed> getData() {
        List<Feed> list = (List) super.getData();
        return list == null ? new ArrayList() : list;
    }

    public JSONArray getPreloadData() {
        return this.mPreloadData;
    }

    public void setPreloadData(JSONArray jSONArray) {
        this.mPreloadData = jSONArray;
    }

    public int getWorksCount() {
        return this.mWorksCount;
    }

    public void setWorksCount(int i) {
        this.mWorksCount = i;
    }

    public int getFavouriteCursor() {
        return this.mFavouriteCursor;
    }

    public void setFavouriteCursor(int i) {
        this.mFavouriteCursor = i;
    }
}
