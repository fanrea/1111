package com.component.a.g;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.activity.PermissionDialogActivity;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.util.h;
import com.baidu.mobads.container.util.o;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class b {
    public static final String i = "ad_click";
    public static final String j = "creative_click";
    public static final String k = "union_click";
    public static final String l = "permission";
    public static final String m = "privacy";
    public static final String n = "function";
    public static final String o = "close";
    public static final String p = "dislike";
    public static final String q = "dl_pause";
    public static final String r = "play";
    public static final String s = "pause";
    public static final String t = "no";
    private boolean a = false;
    protected final j u;
    protected final Context v;
    protected k w;

    public b(Context context, j jVar) {
        this.u = jVar;
        this.v = context.getApplicationContext();
    }

    public b(k kVar, j jVar) {
        this.w = kVar;
        this.u = jVar;
        this.v = kVar.getAdContainerContext().t();
    }

    void a(boolean z) {
        this.a = z;
    }

    void a(com.component.a.f.d dVar) {
        if (dVar == null) {
            return;
        }
        String strH = dVar.h();
        View viewE = dVar.e();
        if (TextUtils.equals("ad_click", strH)) {
            a(viewE, this.a, strH, dVar);
            return;
        }
        if (TextUtils.equals(j, strH)) {
            a(viewE, this.a, strH, dVar);
            return;
        }
        if (TextUtils.equals(k, strH)) {
            d(viewE);
            return;
        }
        if (TextUtils.equals("permission", strH)) {
            c(viewE);
            return;
        }
        if (TextUtils.equals("privacy", strH)) {
            a(viewE);
            return;
        }
        if (TextUtils.equals("function", strH)) {
            b(viewE);
            return;
        }
        if (!TextUtils.isEmpty(strH) && strH.startsWith("{") && strH.endsWith(i.d)) {
            a(viewE, strH.substring(1, strH.length() - 1));
            return;
        }
        if (TextUtils.equals("dislike", strH)) {
            a(viewE, dVar);
        } else if (TextUtils.equals(q, strH)) {
            e(viewE);
        } else {
            a(viewE, dVar, strH);
        }
    }

    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        try {
            if (this.w != null && this.u != null) {
                if (z) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("use_dialog_frame", true);
                    new com.baidu.mobads.container.components.k.c(this.w).a(this.w, this.u, (Boolean) true, map);
                } else {
                    new com.baidu.mobads.container.components.k.c(this.w).a(this.w, this.u, (Boolean) true, (HashMap<String, Object>) null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void a(View view) {
        try {
            if (this.u != null) {
                String strOptString = this.u.getOriginJsonObject().optString("privacy_link");
                if (!TextUtils.isEmpty(strOptString)) {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.putExtra("privacy_link", strOptString);
                    h.a(this.v, intent);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void b(View view) {
        try {
            if (this.u != null) {
                String strOptString = this.u.getOriginJsonObject().optString(com.baidu.mobads.container.components.command.j.M);
                if (!TextUtils.isEmpty(strOptString)) {
                    a(view, strOptString);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void c(View view) {
        try {
            if (this.u == null) {
                return;
            }
            String strOptString = this.u.getOriginJsonObject().optString(com.baidu.mobads.container.components.command.j.L);
            if (!TextUtils.isEmpty(strOptString)) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra(PermissionDialogActivity.PERMISSION_URL, strOptString);
                h.f(this.v, intent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void d(View view) {
        a(view, com.baidu.mobads.container.adrequest.h.g);
    }

    protected void a(View view, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strE = o.e(str);
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("privacy_link", strE);
                h.a(this.v, intent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void a(View view, com.component.a.f.d dVar) {
        try {
            if (this.w != null && this.u != null) {
                this.w.handleDislikeClick(this.u, view, dVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void e(View view) {
        new com.baidu.mobads.container.b.a().a(this.w, this.u);
    }

    protected void a(View view, com.component.a.f.d dVar, String str) {
    }
}
