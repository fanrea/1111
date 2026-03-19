package com.baidu.mobads.container.preload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.bf;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.d.d;
import com.baidu.mobads.container.util.o;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static volatile b a = null;
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static final String d = "https://mobads.baidu.com/ads/preload.php";
    private Context c;
    private List<XAdMaterialsInfo> e;
    private String f;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        if (b.get()) {
            return;
        }
        this.c = context.getApplicationContext();
        this.f = DeviceUtils.getInstance().l(this.c);
        b.set(true);
        com.baidu.mobads.container.d.b.a().a(new a(this), 2L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c(bf.a(o.e(d)));
        c();
    }

    private void c() {
        if (this.e == null || this.e.size() == 0) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            XAdMaterialsInfo xAdMaterialsInfo = this.e.get(i);
            String strA = xAdMaterialsInfo.a();
            if (a(xAdMaterialsInfo) && a(strA)) {
                by.a = String.valueOf(System.currentTimeMillis());
                by.b = String.valueOf(System.currentTimeMillis());
                by.a(this.c, bu.aL, "material_has_loaded", strA);
            }
            if (a(xAdMaterialsInfo) && !a(strA)) {
                d(strA);
            }
        }
    }

    private boolean a(String str) {
        return com.baidu.mobads.container.util.d.d.a(this.c).g(str);
    }

    private boolean a(XAdMaterialsInfo xAdMaterialsInfo) {
        if (xAdMaterialsInfo.b().equals(this.f) && b(xAdMaterialsInfo.c()) <= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    private long b(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (Exception e) {
            date = null;
        }
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.e = XAdMaterialsInfo.a(new JSONObject(str).optJSONArray("preload"));
            } catch (Exception e) {
            }
        }
    }

    private void d(String str) {
        try {
            com.baidu.mobads.container.util.d.d.a(this.c).a(str, (d.InterfaceC0136d<?>) new c(this));
        } catch (Exception e) {
        }
    }

    private static class a extends com.baidu.mobads.container.d.a {
        private b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // com.baidu.mobads.container.d.a
        protected Object a() {
            this.a.b();
            return null;
        }
    }
}
