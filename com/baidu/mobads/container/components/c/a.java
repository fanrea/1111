package com.baidu.mobads.container.components.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.container.components.a.o;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.util.bd;
import com.baidu.mobads.container.util.bj;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.kuaishou.tk.api.export.sdk.TKErrorCode;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements com.baidu.mobads.container.util.a.a {
    private static final String b = "InstallReceiver";
    private j c;
    private long j;
    private AtomicInteger d = new AtomicInteger(-1);
    private ArrayList<SoftReference<InterfaceC0121a>> e = new ArrayList<>();
    protected final bq a = bq.a();
    private com.baidu.mobads.container.components.command.a f = new com.baidu.mobads.container.components.command.a();
    private int g = 0;
    private boolean h = false;
    private boolean i = false;

    /* renamed from: com.baidu.mobads.container.components.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0121a {
        boolean a(Context context, Intent intent);
    }

    static /* synthetic */ int a(a aVar, int i) {
        int i2 = aVar.g + i;
        aVar.g = i2;
        return i2;
    }

    public a(j jVar) {
        this.j = 0L;
        this.c = jVar;
        this.j = System.currentTimeMillis() + this.c.aB;
    }

    public void a(int i) {
        this.d.set(i);
    }

    public int a() {
        return this.d.get();
    }

    public boolean b() {
        return System.currentTimeMillis() > this.j;
    }

    @Override // com.baidu.mobads.container.util.a.a
    public void a(Context context, String str, String str2, Intent intent) {
        int i;
        boolean zA;
        InterfaceC0121a interfaceC0121a;
        int i2;
        if (intent != null && context != null && TextUtils.equals(str2, this.c.Z)) {
            a(1);
            int i3 = 0;
            if ("android.intent.action.PACKAGE_ADDED".equals(str)) {
                try {
                    this.c.aC = context.getPackageManager().getPackageInfo(str2, 0).firstInstallTime;
                } catch (Throwable th) {
                    com.baidu.mobads.container.l.g.f(th.getMessage());
                }
                com.baidu.mobads.container.components.d.b.a().b(context.getApplicationContext(), this.c);
                c(400, false);
                String str3 = this.c.au;
                String str4 = this.c.ai;
                String str5 = this.c.aj;
                String str6 = this.c.ah;
                boolean zA2 = a(context, str3);
                if (a(context, this.c.av)) {
                    this.h = true;
                    this.i = !TextUtils.isEmpty(this.c.aw);
                    try {
                        by.a aVarA = by.a.a(context).a(551).a("pk", str2).a(j.C, this.c.aw).a("dl_type", this.c.ay).a(j.F, this.c.az).a("isAuto", this.c.ax).a("i_de_t", this.c.aA).a("i_dt_t", this.c.aB).a("installtime", this.c.aC).a("msg", this.i ? "coop_link_install_completed" : "appstore_link_install_completed").a(j.A, str3).a("canopen_apopage", zA2);
                        if (!TextUtils.isEmpty(str4)) {
                            aVarA.c(str4);
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            aVarA.b(str6);
                        }
                        aVarA.a(str5);
                        aVarA.f();
                    } catch (Exception e) {
                    }
                }
                Bundle extras = intent.getExtras();
                if (extras != null && extras.getBoolean("fromTask", false)) {
                    i = 2;
                } else {
                    i = 1;
                }
                com.baidu.mobads.container.o.d.a().a(context, str2, i, true, this.h, this.c.b("cur_qk", this.c.ae), this.c.b("cur_apid", this.c.ah), this.c.b("cur_adid", this.c.ag));
                this.f.a(context, this.c, this.h);
                if (this.e != null && !this.e.isEmpty()) {
                    Iterator<SoftReference<InterfaceC0121a>> it = this.e.iterator();
                    zA = false;
                    while (it.hasNext()) {
                        SoftReference<InterfaceC0121a> next = it.next();
                        if (next != null && (interfaceC0121a = next.get()) != null) {
                            zA |= interfaceC0121a.a(context, intent);
                        }
                    }
                    this.e.clear();
                } else {
                    zA = false;
                }
                if (!zA) {
                    try {
                        this.g = 0;
                        com.baidu.mobads.container.d.b.a().a(new b(this, context, str2), 0L, 1L, TimeUnit.SECONDS);
                    } catch (Throwable th2) {
                        this.a.b(b, "Delay open exception: " + th2.getMessage());
                    }
                }
                if (!com.baidu.mobads.container.h.a.a().B()) {
                    com.baidu.mobads.container.util.b.a().a(context, str2, com.baidu.mobads.container.util.b.b);
                }
                g.a().a(context, this.c.Z);
            } else {
                if (bd.a.equals(str) || bd.b.equals(str)) {
                    try {
                        Bundle extras2 = intent.getExtras();
                        if (extras2 == null) {
                            return;
                        }
                        try {
                            if (bd.a.equals(str)) {
                                int i4 = extras2.getInt("styleCheckResult");
                                if (i4 == 0) {
                                    a(111, true);
                                    i2 = 2;
                                    a(context, 550, "open_appstore_check_result_succ", this.c.av, false);
                                } else {
                                    i2 = 2;
                                }
                                if (i4 == 1) {
                                    a(112, true);
                                    a(context, 550, "open_appstore_check_result_succ", this.c.av, false);
                                }
                            } else {
                                i2 = 2;
                                if (bd.b.equals(str)) {
                                    switch (extras2.getInt("statusCode")) {
                                        case 1001:
                                            a(context, 550, "open_appstore_err_nonet", this.c.av, false);
                                            i3 = 141;
                                            break;
                                        case 1002:
                                            a(context, 550, "open_appstore_page_show", this.c.av, false);
                                            i3 = 113;
                                            break;
                                        case 1003:
                                            a(context, 550, "open_appstore_err_noresult", this.c.av, false);
                                            i3 = 142;
                                            break;
                                        case 1004:
                                            a(context, 550, "open_appstore_err_intererror", this.c.av, false);
                                            this.f.a(context, this.c, 304);
                                            i3 = 143;
                                            break;
                                        case 1005:
                                            a(context, 550, "open_appstore_err_resultfail", this.c.av, false);
                                            i3 = 144;
                                            break;
                                        case 3001:
                                            a(context, 550, "open_appstore_startdownload", this.c.av, false);
                                            this.f.a(context, this.c, 302);
                                            i3 = 114;
                                            break;
                                        case 3002:
                                            a(context, 550, "open_appstore_downloadfinish", this.c.av, false);
                                            this.f.a(context, this.c, 305);
                                            i3 = 307;
                                            break;
                                        case 3005:
                                            a(context, 550, "open_appstore_downloadpause", this.c.av, false);
                                            this.f.a(context, this.c, 303);
                                            i3 = 308;
                                            break;
                                        case 3006:
                                            a(context, 550, "open_appstore_downloadrecover", this.c.av, false);
                                            i3 = 309;
                                            break;
                                        case TKErrorCode.BUNDLE_FILE_OVER_SIZE /* 3007 */:
                                            a(context, 550, "open_appstore_startinstall", this.c.av, false);
                                            this.f.a(context, this.c, 306);
                                            i3 = 406;
                                            break;
                                        case 3008:
                                            a(context, 550, "open_appstore_installfinish", this.c.av, true);
                                            i3 = 407;
                                            break;
                                        case 5001:
                                            a(context, 550, "open_appstore_pageopenapp", this.c.av, true);
                                            this.f.a(context, this.c, 309);
                                            i3 = 408;
                                            break;
                                    }
                                    if (i3 != 0) {
                                        String strValueOf = String.valueOf(i3);
                                        if (!TextUtils.isEmpty(strValueOf)) {
                                            if (strValueOf.startsWith("1")) {
                                                a(i3, true);
                                            } else if (strValueOf.startsWith("3")) {
                                                b(i3, true);
                                            } else if (strValueOf.startsWith("4")) {
                                                c(i3, true);
                                            } else {
                                                c(i3, true);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                        }
                    } catch (Throwable th4) {
                        i2 = 2;
                    }
                }
                a(i2);
            }
            i2 = 2;
            a(i2);
        }
    }

    public static boolean a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (!new com.component.c.d(context).a(intent, 65536).isEmpty()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        boolean zA;
        String str;
        int i;
        String str2;
        if (context != null) {
            try {
                if (this.h) {
                    String str3 = this.i ? "coop_link_delayopen" : "appstore_link_delayopen";
                    str2 = this.c.au;
                    zA = a(context, str2);
                    str = str3;
                    i = 552;
                } else {
                    String str4 = "apo_page_delayopen";
                    if (this.c.as && !TextUtils.isEmpty(this.c.at)) {
                        String str5 = this.c.at;
                        zA = a(context, str5);
                        str = "apo_page_delayopen";
                        i = 381;
                        str2 = str5;
                    } else {
                        String str6 = this.c.au;
                        zA = a(context, str6);
                        if (!zA) {
                            str4 = "pk_delayopen";
                        }
                        str = str4;
                        i = 711;
                        str2 = str6;
                    }
                }
                a(context, i, str, str2, zA);
                if (zA) {
                    bj.a(context, str2);
                    c(402, true);
                    return;
                }
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(this.c.Z);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    c(401, true);
                }
            } catch (Exception e) {
                this.a.a(b, e);
            }
        }
    }

    private void a(int i, boolean z) {
        com.baidu.mobads.container.components.h.a.a.a().a(this.c.i(), this.c.h(), this.c.Z, i, z);
    }

    private void b(int i, boolean z) {
        com.baidu.mobads.container.components.h.a.a.a().b(this.c.i(), this.c.h(), i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z) {
        com.baidu.mobads.container.components.h.a.a.a().c(this.c.i(), this.c.h(), i, z);
    }

    private void a(Context context, int i, String str, String str2, boolean z) {
        by.a aVarA = by.a.a(context).a(i).a(this.c.l()).a("msg", str).a("adid", this.c.h()).a("qk", this.c.i()).a("pk", this.c.d()).a(j.f, this.c.j()).a("from", "receiver").a("dl_type", this.c.ay).a(j.F, this.c.az).a("clicktime", String.valueOf(this.c.c())).a("i_de_t", String.valueOf(this.c.aA)).a("i_dt_t", String.valueOf(this.c.aB)).a("appsize", String.valueOf(this.c.e()));
        if (!TextUtils.isEmpty(this.c.k())) {
            aVarA.c(this.c.k());
        }
        if (!TextUtils.isEmpty(this.c.ah)) {
            aVarA.b(this.c.ah);
        }
        if (this.h) {
            aVarA.a("canopenapopage", z).a(j.A, str2).a(j.C, this.c.aw).a("isAuto", this.c.ax);
        } else {
            aVarA.a(FeedReqParams.REQ_TYPE_OPEN, z).a("schema", str2);
        }
        if (this.c.am != null) {
            aVarA.a(this.c.am);
        }
        aVarA.f();
    }

    public void a(j jVar) {
        if (a() != 1) {
            this.c = jVar;
            this.j = System.currentTimeMillis() + this.c.aB;
        }
    }

    public j c() {
        return this.c;
    }

    public void a(InterfaceC0121a interfaceC0121a) {
        this.e.add(new SoftReference<>(interfaceC0121a));
    }

    public boolean d() {
        try {
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject(this.c.aD);
                if (TextUtils.equals(jSONObject.optString("once_acti_moment_close", "0"), "0") && TextUtils.equals(jSONObject.optString("once_acti_win", "0"), "1")) {
                    return o.a().b();
                }
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
