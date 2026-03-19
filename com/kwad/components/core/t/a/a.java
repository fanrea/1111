package com.kwad.components.core.t.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.b.a;
import com.kwad.components.core.c.f;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.n;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends com.kwad.components.core.n.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> ZZ = new ConcurrentHashMap();
    private static final AtomicInteger aaa = new AtomicInteger(1);
    private StyleTemplate ZR;
    private String ZS;
    private boolean ZU;
    private n ZV;
    private k ZW;
    private com.kwad.components.core.t.b.b ZX;
    private int ZY;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "TKActivityProxy";
    }

    public static void register() {
        c.g(FeedDownloadActivity.class, a.class);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.ZU = getIntent().getBooleanExtra("show_navigationBar", true);
        this.ZS = getIntent().getStringExtra("title");
        this.ZV = (n) aK("native_intent");
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        this.ZY = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        k kVar = (k) aK("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.ZR = styleTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return false;
            }
        }
        if (kVar != null) {
            this.ZW = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData adResultDataD = f.ot().d(intExtra, true);
        this.mAdResultData = adResultDataD;
        return intExtra <= 0 || adResultDataD != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_container);
        if (!this.ZU && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0458a() { // from class: com.kwad.components.core.t.a.a.1
            @Override // com.kwad.components.core.b.a.InterfaceC0458a
            public final void y(View view) {
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0458a
            public final void x(View view) {
                a.this.finish();
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.ZS));
        this.mTitleBarHelper.aj(false);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.t.b.b bVar = this.ZX;
        if (bVar == null || !bVar.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.b
    /* renamed from: tg, reason: merged with bridge method [inline-methods] */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.a(this.mAdResultData);
        bVar.ZR = this.ZR;
        bVar.mRootContainer = this.mRootContainer;
        bVar.ZV = this.ZV;
        bVar.ZW = this.ZW;
        return bVar;
    }

    @Override // com.kwad.components.core.n.b
    public Presenter onCreatePresenter() {
        if (this.ZR != null) {
            return new com.kwad.components.core.t.b.a();
        }
        if (this.ZX == null) {
            this.ZX = new com.kwad.components.core.t.b.b();
        }
        return this.ZX;
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            bf(this.ZY);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private Object aK(String str) {
        return o(this.ZY, str);
    }

    public static int th() {
        return aaa.incrementAndGet();
    }

    private static Object o(int i, String str) {
        Map<String, Object> map = ZZ.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static void a(int i, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = ZZ;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i), map);
        }
        map.put(str, obj);
    }

    private static void bf(int i) {
        Map<String, Object> map = ZZ.get(Integer.valueOf(i));
        if (map != null) {
            map.clear();
        }
    }
}
