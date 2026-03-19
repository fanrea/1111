package com.baidu.mobads.container.v.b;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.adrequest.l;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.h;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.bh;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.u;
import com.baidu.mobads.container.v.d;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends d {
    public static final int k = 0;
    public static final String l = "00";
    public static final String m = "https://mobads.baidu.com/ad.html?url=%s&sn=%s&v=%s";
    private static final int n = 10000;
    protected String e;
    protected int f;
    public bh g;
    public AtomicBoolean h;
    public boolean i;
    public long j;

    public a(t tVar) {
        super(tVar);
        this.e = "";
        this.h = new AtomicBoolean(false);
        this.i = true;
        if (!a(tVar)) {
            this.mAdLogger.c(d.a, "context 非 Activity");
        }
    }

    private boolean a(t tVar) {
        return tVar.u() != null;
    }

    @Override // com.baidu.mobads.container.v.d, com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        if (this.mAdState != 2) {
            l lVarR = this.mAdContainerCxt.r();
            if (lVarR != null) {
                this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.v, lVarR.p()));
                return;
            } else {
                this.mAdLogger.b(d.a, "null response while do start");
                return;
            }
        }
        this.mAdLogger.a("XH5SplashAdContainer: ad state is stopped, so can not show ad");
    }

    @Override // com.baidu.mobads.container.v.d, com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = "XFeedsMouldAdContainer";
    }

    public void a(View view, JSONObject jSONObject) {
        j adInstanceInfoByJson = getAdInstanceInfoByJson(jSONObject);
        if (adInstanceInfoByJson != null) {
            setAdContainerView(adInstanceInfoByJson.getUniqueId(), view);
            a(view, adInstanceInfoByJson, new HashMap());
        }
        if (view != null) {
            view.setOnTouchListener(new b(this));
        }
    }

    public void a(View view, j jVar, Map<String, Object> map) {
        this.j = System.currentTimeMillis();
        if (this.h.get()) {
            return;
        }
        this.h.set(true);
        map.put("apid", this.mAdContainerCxt.l());
        this.g = new bh(10000);
        this.g.a(new c(this, view));
        this.g.a();
    }

    @Override // com.baidu.mobads.container.au, com.baidu.mobads.container.k
    public void destroy() {
        if (this.mWebView != null) {
            this.mWebView.destroy();
        }
        if (this.g != null) {
            this.g.b();
        }
        this.h.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, int i) {
        String strA;
        try {
            by.a aVarB = by.a.a(this.mAppContext).a(i).c(this.mAdContainerCxt.k()).a(this.mAdContainerCxt.z()).a(jVar).b(this.mAdContainerCxt.l());
            if (i == 362) {
                aVarB.a(com.baidu.mobads.container.components.command.j.C, bk.a(jVar)).a(jVar, this.mAdContainerCxt.k());
            } else if (i == 364) {
                aVarB.b(jVar);
            }
            if (this.g != null) {
                aVarB.a("trysum", "" + this.g.e());
            }
            if (this.e.length() > 150) {
                this.e = this.e.substring(0, 150);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.j;
            long jCurrentTimeMillis2 = System.currentTimeMillis() - this.mAdContainerCxt.r().a();
            String clickThroughUrl = jVar.getClickThroughUrl();
            if (jVar.getAntiTag() == 0 && (strA = a(this.mAppContext, clickThroughUrl)) != null) {
                clickThroughUrl = strA;
            }
            if (clickThroughUrl != null && clickThroughUrl.length() > 0) {
                aVarB.a("forecurl", b(clickThroughUrl));
            }
            aVarB.a("showsended", "" + this.e.endsWith("00")).a("showstate", "" + this.f).a("showrecord", this.e).a("timeprd", "" + jCurrentTimeMillis).a("expire", "" + jCurrentTimeMillis2).a("isusenewshowlog", "true").a("uniqueid", jVar.getUniqueId()).f();
        } catch (Exception e) {
            this.mAdLogger.a(e);
        }
    }

    public String a(Context context, String str) {
        try {
            String strC = IDManager.getInstance().c(context);
            if (str != null && !str.equals("")) {
                return String.format(m, URLEncoder.encode(str, "UTF-8"), u.a(strC), Double.valueOf(h.a));
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(str.substring(0, 70), "UTF-8");
        } catch (Exception e) {
            this.mAdLogger.c(e);
            return "";
        }
    }

    @Override // com.baidu.mobads.container.v.d
    public void d() {
        a(this.mAdContainerCxt.q(), 364);
    }

    @Override // com.baidu.mobads.container.v.d
    public boolean a() {
        return false;
    }
}
