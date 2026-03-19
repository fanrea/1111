package com.bytedance.sdk.djx.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ThumbM {
    public float duration;
    public String fext;
    public int height;
    public float interval;
    public int total;
    public List<String> urls;
    public int width;
    public int xLen;
    public int yLen;

    public ThumbM setTotal(int i) {
        this.total = i;
        return this;
    }

    public String getUrl(int i) {
        List<String> list = this.urls;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.urls.get(i);
    }

    public ThumbM setUrls(List<String> list) {
        this.urls = list;
        return this;
    }

    public ThumbM addUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.urls == null) {
                this.urls = new ArrayList();
            }
            this.urls.add(str);
        }
        return this;
    }

    public ThumbM setWidth(int i) {
        this.width = i;
        return this;
    }

    public ThumbM setHeight(int i) {
        this.height = i;
        return this;
    }

    public ThumbM setxLen(int i) {
        this.xLen = i;
        return this;
    }

    public ThumbM setyLen(int i) {
        this.yLen = i;
        return this;
    }

    public ThumbM setDuration(float f) {
        this.duration = f;
        return this;
    }

    public ThumbM setInterval(float f) {
        this.interval = f;
        return this;
    }

    public ThumbM setFext(String str) {
        this.fext = str;
        return this;
    }

    public String toString() {
        return "ThumbM{total=" + this.total + ", width=" + this.width + ", height=" + this.height + ", xLen=" + this.xLen + ", yLen=" + this.yLen + ", duration=" + this.duration + ", interval=" + this.interval + ", fext='" + this.fext + "', urls=" + this.urls + '}';
    }
}
