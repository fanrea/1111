package com.ss.android.downloadlib.addownload.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.d.d.hc.k;
import com.ss.android.d.d.u.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.hc.an;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.mk;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.downloadlib.tc;
import com.ss.android.socialbase.downloader.downloader.h;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static final String d = "d";
    private static d hc;
    private hc an;
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hc.d> b;
    private boolean c = false;
    private String u;

    /* renamed from: com.ss.android.downloadlib.addownload.d.d$d, reason: collision with other inner class name */
    public interface InterfaceC0751d {
        void d();
    }

    private d() {
        hc hcVar = new hc();
        this.an = hcVar;
        this.b = hcVar.d("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static d d() {
        if (hc == null) {
            hc = new d();
        }
        return hc;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x0068, B:25:0x006e, B:27:0x0076, B:29:0x0082, B:31:0x008a, B:33:0x0099, B:36:0x00bf, B:34:0x009d), top: B:40:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x0068, B:25:0x006e, B:27:0x0076, B:29:0x0082, B:31:0x008a, B:33:0x0099, B:36:0x00bf, B:34:0x009d), top: B:40:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00be A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.app.Activity r22, com.ss.android.socialbase.downloader.h.b r23, boolean r24, com.ss.android.downloadlib.addownload.d.d.InterfaceC0751d r25) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r24
            r3 = r25
            r4 = 0
            if (r23 != 0) goto L17
            java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hc.d> r5 = r1.b     // Catch: java.lang.Exception -> L14
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Exception -> L14
            if (r5 == 0) goto L17
            return r4
        L14:
            r0 = move-exception
            goto Ld1
        L17:
            if (r0 == 0) goto Ld4
            boolean r5 = r22.isFinishing()     // Catch: java.lang.Exception -> L14
            if (r5 == 0) goto L21
            goto Ld4
        L21:
            r5 = 1
            if (r23 == 0) goto L4d
            java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hc.d> r6 = r1.b     // Catch: java.lang.Exception -> L14
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Exception -> L14
            if (r6 == 0) goto L4d
            com.ss.android.downloadlib.addownload.hc.d r6 = new com.ss.android.downloadlib.addownload.hc.d     // Catch: java.lang.Exception -> L14
            int r7 = r23.h()     // Catch: java.lang.Exception -> L14
            long r8 = (long) r7     // Catch: java.lang.Exception -> L14
            r10 = 0
            r12 = 0
            java.lang.String r14 = r23.us()     // Catch: java.lang.Exception -> L14
            java.lang.String r15 = r23.tt()     // Catch: java.lang.Exception -> L14
            r16 = 0
            java.lang.String r17 = r23.k()     // Catch: java.lang.Exception -> L14
            r7 = r6
            r7.<init>(r8, r10, r12, r14, r15, r16, r17)     // Catch: java.lang.Exception -> L14
            r1.d(r0, r6, r2, r3)     // Catch: java.lang.Exception -> L14
            return r5
        L4d:
            r6 = 0
            if (r23 == 0) goto L5e
            java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> L14
            java.lang.String r7 = r23.k()     // Catch: java.lang.Exception -> L14
            r6.<init>(r7)     // Catch: java.lang.Exception -> L14
            long r6 = r6.lastModified()     // Catch: java.lang.Exception -> L14
        L5e:
            java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hc.d> r8 = r1.b     // Catch: java.lang.Exception -> L14
            int r9 = r8.size()     // Catch: java.lang.Exception -> L14
            java.util.ListIterator r8 = r8.listIterator(r9)     // Catch: java.lang.Exception -> L14
        L68:
            boolean r9 = r8.hasPrevious()     // Catch: java.lang.Exception -> L14
            if (r9 == 0) goto Lbe
            java.lang.Object r9 = r8.previous()     // Catch: java.lang.Exception -> L14
            com.ss.android.downloadlib.addownload.hc.d r9 = (com.ss.android.downloadlib.addownload.hc.d) r9     // Catch: java.lang.Exception -> L14
            if (r9 == 0) goto L68
            android.content.Context r10 = com.ss.android.downloadlib.addownload.mq.getContext()     // Catch: java.lang.Exception -> L14
            java.lang.String r11 = r9.c     // Catch: java.lang.Exception -> L14
            boolean r10 = com.ss.android.downloadlib.h.uo.u(r10, r11)     // Catch: java.lang.Exception -> L14
            if (r10 != 0) goto L68
            java.lang.String r10 = r9.h     // Catch: java.lang.Exception -> L14
            boolean r10 = com.ss.android.downloadlib.h.uo.d(r10)     // Catch: java.lang.Exception -> L14
            if (r10 == 0) goto L68
            java.io.File r8 = new java.io.File     // Catch: java.lang.Exception -> L14
            java.lang.String r10 = r9.h     // Catch: java.lang.Exception -> L14
            r8.<init>(r10)     // Catch: java.lang.Exception -> L14
            long r10 = r8.lastModified()     // Catch: java.lang.Exception -> L14
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 < 0) goto L9d
            r1.d(r0, r9, r2, r3)     // Catch: java.lang.Exception -> L14
            goto Lbf
        L9d:
            com.ss.android.downloadlib.addownload.hc.d r6 = new com.ss.android.downloadlib.addownload.hc.d     // Catch: java.lang.Exception -> L14
            int r7 = r23.h()     // Catch: java.lang.Exception -> L14
            long r11 = (long) r7     // Catch: java.lang.Exception -> L14
            r13 = 0
            r15 = 0
            java.lang.String r17 = r23.us()     // Catch: java.lang.Exception -> L14
            java.lang.String r18 = r23.tt()     // Catch: java.lang.Exception -> L14
            r19 = 0
            java.lang.String r20 = r23.k()     // Catch: java.lang.Exception -> L14
            r10 = r6
            r10.<init>(r11, r13, r15, r17, r18, r19, r20)     // Catch: java.lang.Exception -> L14
            r1.d(r0, r6, r2, r3)     // Catch: java.lang.Exception -> L14
            goto Lbf
        Lbe:
            r5 = r4
        Lbf:
            java.lang.String r0 = com.ss.android.downloadlib.addownload.d.d.d     // Catch: java.lang.Exception -> L14
            java.lang.String r2 = "tryShowInstallDialog isShow:"
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L14
            java.lang.String r2 = r2.concat(r3)     // Catch: java.lang.Exception -> L14
            r3 = 0
            com.ss.android.downloadlib.h.mk.d(r0, r2, r3)     // Catch: java.lang.Exception -> L14
            return r5
        Ld1:
            com.bytedance.sdk.component.utils.mq.d(r0)
        Ld4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.d.d.d(android.app.Activity, com.ss.android.socialbase.downloader.h.b, boolean, com.ss.android.downloadlib.addownload.d.d$d):boolean");
    }

    public boolean d(Activity activity, boolean z, InterfaceC0751d interfaceC0751d) {
        if (mq.tt().optInt("disable_install_app_dialog") == 1 || this.c) {
            return false;
        }
        return d(activity, d(activity), z, interfaceC0751d);
    }

    public void d(Context context, com.ss.android.downloadlib.addownload.hc.d dVar, boolean z, InterfaceC0751d interfaceC0751d) throws JSONException {
        this.b.clear();
        d(context, dVar, interfaceC0751d, z);
        this.c = true;
        tc.d(context).b();
        this.an.hc("sp_ad_install_back_dialog", "key_uninstalled_list");
        mk.d(d, "tryShowInstallDialog isShow:true", null);
    }

    public com.ss.android.socialbase.downloader.h.b d(Context context) {
        long jHc;
        List<com.ss.android.socialbase.downloader.h.b> listHc;
        com.ss.android.socialbase.downloader.h.b bVar = null;
        try {
            jHc = tc.d(context).hc();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        if (mq.tt().optInt("enable_miniapp_dialog", 0) != 0 && (listHc = h.hc(context).hc("application/vnd.android.package-archive")) != null && !listHc.isEmpty()) {
            long j = 0;
            for (com.ss.android.socialbase.downloader.h.b bVar2 : listHc) {
                if (bVar2 != null && !uo.u(context, bVar2.us()) && uo.d(bVar2.k())) {
                    long jLastModified = new File(bVar2.k()).lastModified();
                    if (jLastModified >= jHc && bVar2.s() != null) {
                        try {
                            if (new JSONObject(bVar2.s()).has("isMiniApp") && (j == 0 || jLastModified > j)) {
                                bVar = bVar2;
                                j = jLastModified;
                            }
                        } catch (Exception e2) {
                            com.bytedance.sdk.component.utils.mq.d(e2);
                        }
                    }
                }
            }
            return bVar;
        }
        return null;
    }

    public void d(long j, long j2, long j3, String str, String str2, String str3, String str4) throws JSONException {
        for (int i = 0; i < this.b.size(); i++) {
            com.ss.android.downloadlib.addownload.hc.d dVar = this.b.get(i);
            if (dVar != null && dVar.hc == j2) {
                this.b.set(i, new com.ss.android.downloadlib.addownload.hc.d(j, j2, j3, str, str2, str3, str4));
                this.an.d("sp_ad_install_back_dialog", "key_uninstalled_list", this.b);
                return;
            }
        }
        this.b.add(new com.ss.android.downloadlib.addownload.hc.d(j, j2, j3, str, str2, str3, str4));
        this.an.d("sp_ad_install_back_dialog", "key_uninstalled_list", this.b);
    }

    private void d(final Context context, final com.ss.android.downloadlib.addownload.hc.d dVar, final InterfaceC0751d interfaceC0751d, boolean z) throws JSONException {
        final com.ss.android.hc.d.hc.hc hcVarC = an.d().c(dVar.hc);
        if (hcVarC == null) {
            com.ss.android.downloadlib.u.b.d().d("showBackInstallDialog nativeModel null");
            return;
        }
        k kVarB = mq.b();
        b.d dVarD = new b.d(context).d(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(dVar.u) ? "刚刚下载的应用" : dVar.u;
        kVarB.hc(dVarD.hc(String.format("%1$s下载完成，是否立即安装？", objArr)).b("立即安装").c(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).d(false).d(uo.d(context, dVar.h)).d(new b.hc() { // from class: com.ss.android.downloadlib.addownload.d.d.1
            @Override // com.ss.android.d.d.u.b.hc
            public void d(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.c.d.d().hc("backdialog_install", hcVarC);
                com.ss.android.socialbase.appdownloader.c.d(context, (int) dVar.d);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.d.d.u.b.hc
            public void hc(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.c.d.d().hc("backdialog_exit", hcVarC);
                InterfaceC0751d interfaceC0751d2 = interfaceC0751d;
                if (interfaceC0751d2 != null) {
                    interfaceC0751d2.d();
                }
                d.this.hc("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.d.d.u.b.hc
            public void b(DialogInterface dialogInterface) {
                d.this.hc("");
            }
        }).d(1).d());
        com.ss.android.downloadlib.c.d.d().hc("backdialog_show", hcVarC);
        this.u = dVar.c;
    }

    public boolean d(String str) {
        return TextUtils.equals(this.u, str);
    }

    public void hc(String str) {
        if (TextUtils.isEmpty(str)) {
            this.u = "";
        } else if (TextUtils.equals(this.u, str)) {
            this.u = "";
        }
    }

    public void d(com.ss.android.hc.d.hc.hc hcVar) {
        if (mq.tt().optInt("enable_open_app_dialog", 0) == 1 && !hcVar.rw() && hcVar.w() && Build.VERSION.SDK_INT < 34) {
            hcVar.mk(true);
            TTDelegateActivity.d(hcVar);
        }
    }
}
