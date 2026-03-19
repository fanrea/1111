package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.components.core.e.c.a;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends g {
    private static b Qv;
    private boolean QA;
    private final C0468b Qw;
    private com.kwad.components.core.e.c.a Qz;

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.g
    public final boolean pg() {
        return true;
    }

    public static boolean a(Context context, C0468b c0468b) {
        Activity activityFb;
        b bVar = Qv;
        if ((bVar == null || !bVar.isShowing()) && context != null && (activityFb = m.fb(context)) != null && !activityFb.isFinishing()) {
            com.kwad.sdk.a.a.c.VC().dismiss();
            try {
                b bVar2 = new b(activityFb, c0468b);
                Qv = bVar2;
                bVar2.show();
                com.kwad.sdk.core.adlog.c.b(c0468b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
        return false;
    }

    public static boolean pe() {
        b bVar = Qv;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public static void pf() {
        b bVar = Qv;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        Qv.dismiss();
    }

    private b(Activity activity, C0468b c0468b) {
        super(activity);
        this.QA = false;
        this.Qw = c0468b;
        if (com.kwad.sdk.c.a.a.i(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0468b.QC);
        setOnDismissListener(c0468b.QD);
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dB() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.Qw);
        this.Qz = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        this.Qz.setChangeListener(new a.InterfaceC0467a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.e.c.a.InterfaceC0467a
            public final void pd() {
                b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = Qv;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Qv = null;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        Qv = null;
    }

    public final void al(boolean z) {
        this.QA = z;
        dismiss();
    }

    public final boolean ph() {
        return this.QA;
    }

    @Override // android.app.Dialog
    public final void show() {
        Resources resources;
        int identifier;
        try {
            super.show();
            int dimensionPixelSize = 0;
            try {
                if (getContext() != null && (resources = getContext().getResources()) != null && (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                    dimensionPixelSize = getContext().getResources().getDimensionPixelSize(identifier);
                }
                if (dimensionPixelSize > 0) {
                    getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 5382 : SocketMessages.PayloadType.SC_LIVE_POPULARITY_TICKET_ENCOURAGE_BATTLE_INFO);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.adlog.c.cs(this.Qw.adTemplate);
    }

    /* renamed from: com.kwad.components.core.e.c.b$b, reason: collision with other inner class name */
    public static class C0468b {
        protected DialogInterface.OnShowListener QC;
        protected DialogInterface.OnDismissListener QD;
        protected final AdTemplate adTemplate;
        protected String url;

        /* synthetic */ C0468b(a aVar, byte b) {
            this(aVar);
        }

        private C0468b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.QC = aVar.QC;
            this.QD = aVar.QD;
        }
    }

    public static class a {
        private DialogInterface.OnShowListener QC;
        private DialogInterface.OnDismissListener QD;
        private AdTemplate adTemplate;
        private String url;

        public final a aB(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a ap(String str) {
            this.url = str;
            return this;
        }

        public final a a(DialogInterface.OnShowListener onShowListener) {
            this.QC = onShowListener;
            return this;
        }

        public final a c(DialogInterface.OnDismissListener onDismissListener) {
            this.QD = onDismissListener;
            return this;
        }

        public final C0468b pi() {
            if (com.kwad.components.core.a.qr.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0468b(this, (byte) 0);
        }
    }
}
