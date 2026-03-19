package com.component.data;

import android.view.View;
import com.baidu.mobads.container.a.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class PatchDataResponse {
    public static final String GIF = "gif";
    public static final String NORMAL = "normal";
    public static final String VIDEO = "video";
    Class<?> a;
    Object b;

    public PatchDataResponse(Object obj) {
        this.a = null;
        this.b = null;
        this.a = obj.getClass();
        this.b = obj;
    }

    public void recordImpression(View view) {
        g.a(this.b, "recordImpression", (Class<?>[]) new Class[]{View.class}, new Object[]{view});
    }

    public void handleClick(View view) {
        try {
            g.a(this.b, "handleClick", (Class<?>[]) new Class[]{View.class}, new Object[]{view});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleClick(View view, int i) {
        try {
            g.a(this.b, "handleClick", (Class<?>[]) new Class[]{View.class, Integer.TYPE}, new Object[]{view, Integer.valueOf(i)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return a("getTitle");
    }

    public String getDesc() {
        return a("getDesc");
    }

    public String getIconUrl() {
        return a("getIconUrl");
    }

    public String getImageUrl() {
        return a("getImageUrl");
    }

    public String getAdLogoUrl() {
        return a("getAdLogoUrl");
    }

    public String getBaiduLogoUrl() {
        return a("getBaiduLogoUrl");
    }

    public String getVideoUrl() {
        return a("getVideoUrl");
    }

    private String a(String str) {
        try {
            return (String) g.a(this.b, str, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public Object invoke(String str, Object... objArr) {
        return g.a(this.b, str, objArr);
    }

    public String getMaterialType() {
        try {
            if (this.b == null) {
                return null;
            }
            return (String) g.a(this.b, "getMaterialType", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
