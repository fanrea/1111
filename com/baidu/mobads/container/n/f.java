package com.baidu.mobads.container.n;

import android.content.Context;
import com.baidu.mobads.container.adrequest.ProdAdRequestInfo;
import com.baidu.mobads.container.nativecpu.j;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends j {
    public static final String G = "CPUNovelAdProd";
    public static final String H = "enter_refresh_bookstore";
    public static final String I = "enter_reader";
    public static final String J = "notify_impression";

    /* renamed from: K, reason: collision with root package name */
    public static final String f734K = "request_int_ad_view";
    public static final String L = "request_banner_ad_view";
    public static final String M = "request_shelf_ad_view";
    public static final String N = "request_bookstore_bottom_view";
    public static final String O = "reader_background_status_change";
    public static final String P = "pre_chapter_adstart_countdown";
    public static final String Q = "novel_activity";
    public static final String R = "interstitial_container";
    public static final String S = "banner_container";
    public static final String T = "backgroundColor";
    public static final String U = "isnight";
    public static final int V = 1;
    public static final int W = 277;
    public static final int X = 275;
    public static final int Y = 276;
    public static final int Z = 274;
    public static final int aA = 289;
    public static final int aB = 290;
    public static final int aC = 291;
    public static final int aD = 292;
    public static final int aE = 293;
    public static final int aF = 294;
    public static final int aG = 295;
    public static final int aH = 296;
    public static final int aI = 297;
    public static final int aJ = 304;
    public static final int aK = 305;
    public static final int aL = 306;
    public static final int aM = 307;
    public static final int aN = 308;
    public static final int aO = 323;
    public static final int aP = 324;
    public static final int aQ = 325;
    public static final int aR = 326;
    public static final int aS = 327;
    public static final int aT = 328;
    public static final int aU = 329;
    public static final int aV = 336;
    public static final int aW = 337;
    public static final int aa = 265;
    public static final int ab = 272;
    public static final int ac = 273;
    public static final int ad = 264;
    public static final int ae = 259;
    public static final int af = 258;
    public static final int ag = 257;
    public static final int ah = 256;
    public static final int ai = 153;
    public static final int aj = 152;
    public static final int ak = 151;
    public static final int al = 150;
    public static final int am = 149;
    public static final int an = 148;
    public static final int ao = 147;
    public static final int ap = 146;
    public static final int aq = 145;
    public static final int ar = 144;
    public static final int as = 134;
    public static final int at = 320;
    public static final int au = 321;
    public static final int av = 322;
    public static final int aw = 137;
    public static final int ax = 136;
    public static final int ay = 135;
    public static final int az = 288;

    public interface a {
        void a();

        void a(HashMap<String, Object> map);
    }

    public f(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        super(context, prodAdRequestInfo);
        IDManager.getInstance().a(context);
        H();
    }

    @Override // com.baidu.mobads.container.nativecpu.j, com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        super.run(iOAdEvent);
    }

    @Override // com.baidu.mobads.container.nativecpu.j, com.baidu.mobads.container.adrequest.o
    public void a() {
        JSONObject allAdParam = this.d.getAllAdParam();
        if (allAdParam != null) {
            c(allAdParam.optString("appid"));
            if (this.E != null) {
                this.E.b(allAdParam.optString("scid"));
            }
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.j, com.baidu.mobads.container.adrequest.o
    public void a(JSONObject jSONObject, Map<String, Object> map) {
        super.a(jSONObject, map);
    }

    public void a(a aVar) {
        if (this.E != null) {
            this.E.a(aVar);
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.j
    public void a(HashMap<String, Object> map) {
        map.put(com.baidu.mobads.container.components.k.c.b, com.baidu.mobads.container.components.k.c.d);
        this.B = map;
    }
}
