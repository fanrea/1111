package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ac {
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static volatile boolean NZ = false;

    static /* synthetic */ boolean access$002(boolean z) {
        NZ = false;
        return false;
    }

    public static void dm(Context context) {
        ae(context, ae.du(context));
    }

    public static void dn(Context context) {
        ae(context, ae.dx(context));
    }

    /* renamed from: do, reason: not valid java name */
    public static void m462do(Context context) {
        ae(context, ae.ds(context));
    }

    public static void dp(Context context) {
        ae(context, ae.dt(context));
    }

    public static void ae(Context context, String str) {
        c(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    public static void c(Context context, String str, long j) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, j);
    }

    public static void d(Context context, String str, long j) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    private static void c(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    private static void a(Context context, String str, int i, long j) {
        if (com.kwad.framework.a.a.bcH.booleanValue() && !NZ) {
            NZ = true;
            View viewInflate = com.kwad.sdk.p.m.inflate(context, i, null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
            mHandler.postDelayed(new bh() { // from class: com.kwad.sdk.utils.ac.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    ac.access$002(false);
                }
            }, j);
        }
    }

    public static void d(Context context, String str, int i) {
        if (com.kwad.framework.a.a.bcH.booleanValue()) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
        }
    }
}
