package com.bytedance.sdk.djx.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Image {
    private List<String> mBackupUrls;
    private int mHeight;
    private String mUri;
    private String mUrl;
    private int mWidth;

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getUri() {
        return this.mUri;
    }

    public void setUri(String str) {
        this.mUri = str;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void addBackupUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mBackupUrls == null) {
            this.mBackupUrls = new ArrayList();
        }
        this.mBackupUrls.add(str);
    }

    public List<String> getBackupUrls() {
        return this.mBackupUrls;
    }

    public void setBackupUrls(List<String> list) {
        this.mBackupUrls = list;
    }
}
