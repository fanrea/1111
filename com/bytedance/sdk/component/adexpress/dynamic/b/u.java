package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    public static final Map<String, Integer> d;
    private an an;
    private String b;
    private String c;
    private String h;
    private String hc;
    private an u;

    static {
        HashMap map = new HashMap();
        d = map;
        map.put("root", 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put("title", 0);
        map.put("subtitle", 0);
        map.put(n.l, 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put("text", 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        map.put("logounion", 5);
        map.put("logo-union", 9);
        map.put("dislike", 3);
        map.put("close", 3);
        map.put("close-fill", 3);
        map.put("webview-close", 22);
        map.put("feedback-dislike", 12);
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        map.put("carousel-vessel", 26);
        map.put("leisure-interact", 25);
        map.put("video-hd", 7);
        map.put("video", 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        map.put("star", 11);
        map.put("skip-countdowns", 19);
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        map.put("skip-with-countdowns-skip-countdown", 20);
        map.put("skip-with-time", 14);
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put("skip", 27);
        map.put("timedown", 13);
        map.put("icon", 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
        map.put("lottie", 28);
        map.put("image-flip-slide", 29);
    }

    public int d() {
        if (TextUtils.isEmpty(this.hc)) {
            return 0;
        }
        if (this.hc.equals("logo")) {
            String str = this.hc + this.b;
            this.hc = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.hc.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = d;
        if (map.get(this.hc) != null) {
            return map.get(this.hc).intValue();
        }
        return -1;
    }

    public String getType() {
        return this.hc;
    }

    public void d(String str) {
        this.hc = str;
    }

    public String hc() {
        return this.b;
    }

    public void hc(String str) {
        this.b = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.h = str;
    }

    public String c() {
        return this.h;
    }

    public an u() {
        return this.u;
    }

    public int an() {
        return this.u.gw();
    }

    public void d(an anVar) {
        this.u = anVar;
    }

    public void hc(an anVar) {
        this.an = anVar;
    }

    public an h() {
        return this.an;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.hc + "', data='" + this.b + "', value=" + this.u + ", themeValue=" + this.an + ", dataExtraInfo='" + this.h + "'}";
    }
}
