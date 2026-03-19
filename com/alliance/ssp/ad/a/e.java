package com.alliance.ssp.ad.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.r.c;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: MyDownLoadListener.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements DownloadListener {
    public Context a;
    public SAAllianceAdData b;

    /* compiled from: MyDownLoadListener.java */
    public class a implements c.a {
        public a() {
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void a(Exception exc) {
            exc.getMessage();
            int i = l.a;
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void b() throws JSONException, PackageManager.NameNotFoundException, IOException {
            com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
            SAAllianceAdData sAAllianceAdData = e.this.b;
            fVar.a(5, 0, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "", 0);
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void c() throws JSONException, PackageManager.NameNotFoundException, IOException {
            com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
            SAAllianceAdData sAAllianceAdData = e.this.b;
            fVar.a(5, 0, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "", 0);
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void a() throws JSONException, PackageManager.NameNotFoundException, IOException {
            com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
            SAAllianceAdData sAAllianceAdData = e.this.b;
            fVar.a(5, 1, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "", 0);
        }

        @Override // com.alliance.ssp.ad.r.c.a
        public void a(String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
            com.alliance.ssp.ad.d0.f fVar = new com.alliance.ssp.ad.d0.f();
            SAAllianceAdData sAAllianceAdData = e.this.b;
            fVar.a(5, 2, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "", 0);
        }
    }

    public e(Context context, SAAllianceAdData sAAllianceAdData) {
        this.a = context;
        this.b = sAAllianceAdData;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        a aVar = new a();
        Context context = this.a;
        int i = com.alliance.ssp.ad.r.c.a;
        if (str == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        new com.alliance.ssp.ad.r.b(str, context, aVar, null).start();
    }
}
