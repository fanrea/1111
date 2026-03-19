package com.kwad.components.core.webview.tachikoma.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e extends j {
    public String Cz;
    public com.kwad.components.core.webview.tachikoma.f.c ZP;
    protected StyleTemplate ZR;
    private d ajA;
    private KSFrameLayout ajB;
    protected List<DialogInterface.OnDismissListener> ajC = new CopyOnWriteArrayList();
    public boolean ajD = false;
    protected com.kwad.components.core.webview.tachikoma.d.b ajp;
    protected l ajr;
    protected k ajs;
    public boolean ajt;
    public a aju;
    private com.kwad.components.core.webview.tachikoma.f.e ajx;
    public AdResultData mAdResultData;
    private Presenter mPresenter;

    public interface a {
        boolean hg();
    }

    public static e b(b bVar) {
        e eVar = new e();
        eVar.mAdResultData = bVar.iy();
        eVar.Cz = bVar.getTemplateId();
        eVar.ajt = bVar.ajt;
        eVar.ajD = bVar.ajD;
        eVar.ZR = bVar.ajF;
        eVar.ajr = bVar.ajr;
        eVar.ajs = bVar.ajG;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        eVar.setArguments(bundle);
        return eVar;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.f.e eVar) {
        this.ajx = eVar;
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.ajC.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.ajC.remove(onDismissListener);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Cz = getArguments().getString("templateId");
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.ajB == null) {
            this.ajB = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.ajB;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("TkDialogFragment", "destroy view failed:" + th);
        }
        KSFrameLayout kSFrameLayout = this.ajB;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ajB.getParent()).removeView(this.ajB);
            this.ajB = null;
        }
        com.kwad.components.core.webview.tachikoma.f.e eVar = this.ajx;
        if (eVar != null) {
            eVar.hm();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        D(view);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.ZP;
        if (cVar != null) {
            cVar.he();
        }
        com.kwad.components.core.webview.tachikoma.f.e eVar = this.ajx;
        if (eVar != null) {
            eVar.he();
        }
    }

    private void D(View view) {
        if (this.ajp == null) {
            this.ajp = ky();
        }
        kA();
        if (this.mPresenter == null) {
            Presenter presenterBI = bI();
            this.mPresenter = presenterBI;
            presenterBI.ak(view);
        }
        this.mPresenter.K(this.ajp);
    }

    protected com.kwad.components.core.webview.tachikoma.d.b ky() {
        return new com.kwad.components.core.webview.tachikoma.d.b();
    }

    private Presenter bI() {
        this.mPresenter = new Presenter();
        if (this.ajp.ajs != null) {
            this.mPresenter.d(wi());
        } else {
            this.mPresenter.d(kz());
        }
        return this.mPresenter;
    }

    protected c kz() {
        return new c();
    }

    private d wi() {
        if (this.ajA == null) {
            this.ajA = new d();
        }
        return this.ajA;
    }

    protected void kA() {
        this.ajp.a(this.mAdResultData);
        this.ajp.mActivity = getActivity();
        this.ajp.ahi = this;
        this.ajp.ajq = this.ajB;
        this.ajp.Cz = this.Cz;
        this.ajp.ZR = this.ZR;
        this.ajp.ajt = this.ajt;
        this.ajp.ajr = this.ajr;
        this.ajp.ajs = this.ajs;
        this.ajp.aju = this.aju;
        this.ajp.ZP = this.ZP;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.ZP;
        if (cVar != null) {
            cVar.hm();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.ajC) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        l lVar = this.ajr;
        if (lVar != null) {
            lVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.tachikoma.d.b bVar = this.ajp;
        if (bVar != null) {
            bVar.release();
            this.ajp = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        Resources resources;
        int identifier;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        int dimensionPixelSize = 0;
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (i(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        try {
            if (this.ajr.isHideNavigationBar()) {
                if (getContext() != null && (resources = getContext().getResources()) != null && (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                    dimensionPixelSize = getContext().getResources().getDimensionPixelSize(identifier);
                }
                if (dimensionPixelSize > 0) {
                    getDialog().getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 5382 : SocketMessages.PayloadType.SC_LIVE_POPULARITY_TICKET_ENCOURAGE_BATTLE_INFO);
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.d.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (e.this.ajD) {
                    return true;
                }
                if (e.this.ajA != null) {
                    return e.this.ajA.onBackPressed();
                }
                return false;
            }
        });
    }

    private static boolean i(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static class b {
        private boolean ajD;
        private StyleTemplate ajF;
        private k ajG;
        private l ajr;
        private boolean ajt;
        private AdResultData mAdResultData;
        private String templateId;

        public final AdResultData iy() {
            return this.mAdResultData;
        }

        public final void a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final void bo(String str) {
            this.templateId = str;
        }

        public final void a(StyleTemplate styleTemplate) {
            this.ajF = styleTemplate;
        }

        public final void a(k kVar) {
            this.ajG = kVar;
        }

        public final boolean lr() {
            return this.ajt;
        }

        public final void bf(boolean z) {
            this.ajt = false;
        }

        public final void bg(boolean z) {
            this.ajD = true;
        }

        public final boolean wj() {
            return this.ajD;
        }

        public final void c(l lVar) {
            this.ajr = lVar;
        }
    }
}
