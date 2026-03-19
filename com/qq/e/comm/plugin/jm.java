package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface jm extends t50 {
    View a();

    void a(int i);

    void a(Context context);

    void a(bm bmVar);

    void a(e eVar);

    @Deprecated
    void a(f fVar);

    @Deprecated
    void a(m mVar);

    void a(sh shVar);

    void a(boolean z);

    void addJavascriptInterface(Object obj, String str);

    bm b();

    void b(boolean z);

    u50 c();

    void c(boolean z);

    boolean canGoBack();

    boolean canGoBackOrForward(int i);

    void d();

    void d(boolean z);

    String e();

    void e(boolean z);

    void f(boolean z);

    Context getContext();

    void goBack();

    void loadUrl(String str);

    void onPause();

    void onResume();

    void setFocusable(boolean z);

    void setFocusableInTouchMode(boolean z);
}
