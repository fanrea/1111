package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.a;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ExpressAdData {
    private String adPlaceId;
    private String desc;
    private String iconUrl;
    private String imageUrl;
    private List<String> multiPicUrls;
    private String pk;
    private String title;
    private String videoUrl;

    public ExpressAdData(a aVar, String str) {
        this.title = "";
        this.desc = "";
        this.iconUrl = "";
        this.pk = "";
        this.imageUrl = "";
        this.videoUrl = "";
        this.multiPicUrls = null;
        this.adPlaceId = str;
        this.title = aVar.a();
        this.desc = aVar.b();
        this.iconUrl = aVar.c();
        this.pk = aVar.m();
        this.imageUrl = aVar.d();
        this.videoUrl = aVar.n();
        this.multiPicUrls = aVar.H();
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getAppPackage() {
        return this.pk;
    }

    public List<String> getMultiPicUrls() {
        return this.multiPicUrls;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getAdPlaceId() {
        return this.adPlaceId;
    }
}
