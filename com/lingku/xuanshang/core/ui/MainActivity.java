package com.lingku.xuanshang.core.ui;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.g;
import com.lingku.xuanshang.core.data.model.XSListener;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;
import com.lingku.xuanshang.xutils.x;
import com.sigmob.sdk.base.n;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import lkxssdk.e.k;
import lkxssdk.e0.d;
import lkxssdk.e0.f;
import lkxssdk.j.b;
import lkxssdk.j.c;
import lkxssdk.j0.d;
import lkxssdk.k0.b;
import lkxssdk.l.t;
import lkxssdk.l.u;
import lkxssdk.l0.e;
import lkxssdk.w.a;
import lkxssdk.w.h;
import lkxssdk.w.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MainActivity extends BaseActivity {
    public RelativeLayout d;
    public WebViewWrapper e;
    public b f;

    public class a extends b {
        public a(MainActivity mainActivity, c cVar) {
            super(cVar);
        }

        @Override // lkxssdk.j.b, lkxssdk.j.c
        public void a(boolean z, String str) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(z, str);
            }
            k kVarA = k.a();
            if (d.b(kVarA.d)) {
                kVarA.b();
                kVarA.c();
            }
        }
    }

    @Override // lkxssdk.d.b
    public void a() {
        finish();
        overridePendingTransition(0, lkxssdk.a.a.a(0, false));
        this.e.a();
    }

    @Override // lkxssdk.d.b
    public void b() {
        e eVarA = e.a();
        this.d = (RelativeLayout) findViewById(eVarA.b.getResources().getIdentifier("webParent", "id", eVarA.c));
        new Handler(getMainLooper());
        this.f = new a(this, this);
        XSListener xSListener = lkxssdk.a.a.f;
        if (xSListener != null) {
            xSListener.onShow();
        }
    }

    @Override // lkxssdk.d.b
    public void c() {
        StringBuilder sbAppend;
        String str;
        if (u.a == null) {
            synchronized (u.class) {
                if (u.a == null) {
                    u.a = new u();
                }
            }
        }
        u uVar = u.a;
        uVar.getClass();
        if (TextUtils.isEmpty(lkxssdk.a.a.e)) {
            sbAppend = new StringBuilder().append("https://appunion.xuanshangwa.com.cn/");
            str = "task";
        } else {
            sbAppend = new StringBuilder().append("https://appunion.xuanshangwa.com.cn/");
            str = lkxssdk.a.a.e;
        }
        Uri.Builder builderBuildUpon = Uri.parse(sbAppend.append(str).toString()).buildUpon();
        TreeMap treeMap = new TreeMap(new t(uVar));
        builderBuildUpon.appendQueryParameter(n.p, lkxssdk.a.a.d().getPackageName());
        treeMap.put(n.p, lkxssdk.a.a.d().getPackageName());
        builderBuildUpon.appendQueryParameter("mt_id", lkxssdk.a.a.a);
        treeMap.put("mt_id", lkxssdk.a.a.a);
        builderBuildUpon.appendQueryParameter("app_unique", lkxssdk.l0.a.e());
        treeMap.put("app_unique", lkxssdk.l0.a.e());
        if (!TextUtils.isEmpty(lkxssdk.a.a.c)) {
            builderBuildUpon.appendQueryParameter("mt_user_id", lkxssdk.a.a.c);
            treeMap.put("mt_user_id", lkxssdk.a.a.c);
        }
        if (!TextUtils.isEmpty("2.8")) {
            builderBuildUpon.appendQueryParameter("sdk_ver", "2.8");
            treeMap.put("sdk_ver", "2.8");
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            String strB = lkxssdk.l0.a.b();
            if (!TextUtils.isEmpty(strB)) {
                builderBuildUpon.appendQueryParameter(com.baidu.mobads.upgrade.remote.gray.c.l, strB);
                treeMap.put(com.baidu.mobads.upgrade.remote.gray.c.l, strB);
            }
            String strA = lkxssdk.l0.a.a(0);
            if (!TextUtils.isEmpty(strA)) {
                builderBuildUpon.appendQueryParameter("imei1", strA);
                treeMap.put("imei1", strA);
            }
            String strA2 = lkxssdk.l0.a.a(1);
            if (!TextUtils.isEmpty(strA2)) {
                builderBuildUpon.appendQueryParameter(g.A, strA2);
                treeMap.put(g.A, strA2);
            }
            String strC = lkxssdk.l0.a.c();
            if (!TextUtils.isEmpty(strC)) {
                builderBuildUpon.appendQueryParameter("imsi", strC);
                treeMap.put("imsi", strC);
            }
            String strD = lkxssdk.l0.a.d();
            if (!TextUtils.isEmpty(strD)) {
                builderBuildUpon.appendQueryParameter("serial_number", strD);
                treeMap.put("serial_number", strD);
            }
        } else if (TextUtils.isEmpty(lkxssdk.a.a.d)) {
            builderBuildUpon.appendQueryParameter("oaid", "");
            treeMap.put("oaid", "");
        } else {
            treeMap.put("oaid", lkxssdk.a.a.d);
            builderBuildUpon.appendQueryParameter("oaid", lkxssdk.a.a.d);
        }
        String strA3 = lkxssdk.l0.a.a();
        if (!TextUtils.isEmpty(strA3)) {
            builderBuildUpon.appendQueryParameter("android_id", strA3);
            treeMap.put("android_id", strA3);
        }
        int[] iArrA = lkxssdk.l0.a.a(lkxssdk.a.a.d());
        builderBuildUpon.appendQueryParameter("screen_resolution", iArrA[0] + "x" + iArrA[1]);
        treeMap.put("screen_resolution", iArrA[0] + "x" + iArrA[1]);
        String strA4 = lkxssdk.l0.a.a(lkxssdk.a.a.d(), iArrA[0], iArrA[1]);
        if (!TextUtils.isEmpty(strA4)) {
            builderBuildUpon.appendQueryParameter("screen_size", strA4);
            treeMap.put("screen_size", strA4);
        }
        String str2 = Build.MODEL;
        if (!TextUtils.isEmpty(str2)) {
            builderBuildUpon.appendQueryParameter("mobile_model", str2);
            treeMap.put("mobile_model", str2);
        }
        String str3 = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str3)) {
            builderBuildUpon.appendQueryParameter("sys_ver", str3);
            treeMap.put("sys_ver", str3);
        }
        builderBuildUpon.appendQueryParameter("sys_ver_int", i + "");
        treeMap.put("sys_ver_int", i + "");
        String str4 = (System.currentTimeMillis() / 1000) + "";
        builderBuildUpon.appendQueryParameter(com.alipay.sdk.m.t.a.k, str4);
        treeMap.put(com.alipay.sdk.m.t.a.k, str4);
        StringBuilder sb = new StringBuilder();
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            sb.append(((String) ((Map.Entry) it.next()).getValue()) + "#");
        }
        sb.append(lkxssdk.a.a.b);
        Log.e("tag", sb.toString());
        builderBuildUpon.appendQueryParameter("sign", lkxssdk.a0.c.a(Base64.encodeToString(sb.toString().getBytes(), 2).trim()));
        String string = builderBuildUpon.build().toString();
        lkxssdk.h0.c.b("time4:" + System.currentTimeMillis());
        if (this.e == null) {
            WebViewWrapper webViewWrapper = new WebViewWrapper(this);
            this.e = webViewWrapper;
            this.d.addView(webViewWrapper, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
        WebViewWrapper webViewWrapper2 = this.e;
        b bVar = this.f;
        webViewWrapper2.a = this;
        this.b = webViewWrapper2;
        webViewWrapper2.j = bVar;
        webViewWrapper2.d.loadUrl(string);
        lkxssdk.h0.c.b("time5:" + System.currentTimeMillis());
    }

    @Override // lkxssdk.d.b
    public void d() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        boolean z;
        if (lkxssdk.a0.b.a <= 0 || System.currentTimeMillis() - lkxssdk.a0.b.a >= com.alipay.sdk.m.u.b.a) {
            lkxssdk.a0.b.a = System.currentTimeMillis();
            z = false;
        } else {
            z = true;
        }
        if (z) {
            a();
        } else {
            lkxssdk.m0.b.a().a("再按一次就退出", 1);
        }
    }

    @Override // lkxssdk.d.b
    public void e() {
        XSListener xSListener = lkxssdk.a.a.f;
        if (xSListener != null) {
            xSListener.onClose();
        }
    }

    @Override // lkxssdk.d.b
    public int f() {
        Log.e("time1", System.currentTimeMillis() + "");
        e eVarA = e.a();
        return eVarA.b.getResources().getIdentifier("lkxs_aty_main", "layout", eVarA.c);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        int[] iArrA = lkxssdk.l0.a.a(this);
        lkxssdk.b.a.a = iArrA[0];
        lkxssdk.b.a.b = iArrA[1];
        WebViewWrapper webViewWrapper = this.e;
        if (webViewWrapper == null || !webViewWrapper.g) {
            return;
        }
        ((WebViewWrapper) this.b).b();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("oaid", lkxssdk.a.a.d);
        bundle.putString("mt_id", lkxssdk.a.a.a);
        bundle.putString("mt_key", lkxssdk.a.a.b);
        bundle.putString("mt_userid", lkxssdk.a.a.c);
        String str = lkxssdk.a.a.e;
        if (!TextUtils.isEmpty(str) && str.startsWith("task_union")) {
            bundle.putString("pageRouter", lkxssdk.a.a.e);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // lkxssdk.d.b
    public void a(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        lkxssdk.h0.c.b("time2:" + System.currentTimeMillis());
        if (bundle != null) {
            String string = bundle.getString("oaid");
            String string2 = bundle.getString("mt_id");
            String string3 = bundle.getString("mt_key");
            String string4 = bundle.getString("mt_userid");
            lkxssdk.a.a.a = string2;
            lkxssdk.a.a.b = string3;
            lkxssdk.a.a.c = string4;
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            lkxssdk.a.a.d = string;
            String string5 = bundle.getString("pageRouter");
            if (!TextUtils.isEmpty(string5)) {
                lkxssdk.a.a.e = string5;
            }
        }
        Context applicationContext = getApplicationContext();
        Context applicationContext2 = applicationContext.getApplicationContext();
        lkxssdk.a.a.a(applicationContext2 == null ? lkxssdk.a.a.e() : (Application) applicationContext2.getApplicationContext());
        lkxssdk.i0.b.a();
        b.a aVar = new b.a(applicationContext.getApplicationContext());
        aVar.d = "https://api.xuanshangwa.com.cn/app/init";
        aVar.c = 0;
        lkxssdk.k0.b bVar = new lkxssdk.k0.b(aVar);
        if (lkxssdk.k0.a.a == null) {
            synchronized (lkxssdk.k0.a.class) {
                if (lkxssdk.k0.a.a == null) {
                    lkxssdk.k0.a.a = new lkxssdk.k0.a();
                }
            }
        }
        lkxssdk.k0.a aVar2 = lkxssdk.k0.a.a;
        synchronized (aVar2) {
            if (aVar2.b == null) {
                lkxssdk.h0.c.a("RequestManager", "ImageLoader FileLoader init()");
                aVar2.b = bVar;
                new Handler();
                new HashMap();
            }
        }
        d.a aVar3 = new d.a(applicationContext.getApplicationContext());
        aVar3.f = true;
        lkxssdk.e0.d dVar = new lkxssdk.e0.d(aVar3);
        lkxssdk.e0.c cVarA = lkxssdk.e0.c.a();
        synchronized (cVarA) {
            if (cVarA.b == null) {
                lkxssdk.h0.c.a("FileLoader", "ImageLoader FileLoader init()");
                cVarA.c = new f(dVar);
                cVarA.b = dVar;
                cVarA.d = new Handler();
            }
        }
        a.C0849a c0849a = new a.C0849a(applicationContext.getApplicationContext());
        c0849a.d = 2;
        c0849a.c = 1;
        c0849a.g = 10000;
        c0849a.i = true;
        c0849a.h = false;
        lkxssdk.w.a aVar4 = new lkxssdk.w.a(c0849a);
        j jVarA = j.a();
        if (jVarA.b == null) {
            jVarA.b = aVar4;
            jVarA.c = new h(aVar4);
        }
        x.Ext.init(getApplication());
        x.Ext.setDebug(false);
        x.Ext.setDefaultHostnameVerifier(new lkxssdk.c.a(this));
        lkxssdk.h0.c.b("time3:" + System.currentTimeMillis());
    }
}
