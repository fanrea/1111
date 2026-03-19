package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.views.n;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f implements Serializable {
    private static final long serialVersionUID = 0;
    private final int a;
    private final int b;
    private final n c;
    private final int d;
    private String e;
    private a f;
    private String g;
    private String h;
    private int i;
    private boolean j = false;
    private com.sigmob.sdk.videoAd.a k;

    public interface a {
        void a();

        void b();
    }

    f(int width, int height, int actionType, String clickThroughUrl, String deepLinkUrl, n creativeResource) {
        this.a = width;
        this.b = height;
        this.d = actionType;
        this.h = deepLinkUrl;
        this.g = clickThroughUrl;
        this.c = creativeResource;
    }

    private void a(BaseAdUnit adUnit, String realClickUrl, String coordinate, com.sigmob.sdk.base.a clickUIType) {
    }

    public n a() {
        return this.c;
    }

    public void a(int duration) {
        this.i = duration;
    }

    public void a(com.sigmob.sdk.videoAd.a videoConfig) {
        this.k = videoConfig;
    }

    public void a(a companionAdClickListener) {
        this.f = companionAdClickListener;
    }

    public void a(String mDeepLinkUrl) {
        this.h = mDeepLinkUrl;
    }

    public String b() {
        return this.h;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}
