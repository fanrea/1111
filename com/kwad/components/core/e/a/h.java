package com.kwad.components.core.e.a;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h implements d {
    private static WeakReference<Window> Qq;
    private final com.kwad.sdk.core.c.c<Activity> Cf = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.aaf();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.Qp.get())) {
                h.this.ge();
            }
        }
    };
    private g Qn;
    private b Qo;
    private WeakReference<Activity> Qp;
    private ViewGroup sJ;
    private boolean sK;

    public static void a(Window window) {
        Qq = new WeakReference<>(window);
    }

    public static void oZ() {
        WeakReference<Window> weakReference = Qq;
        if (weakReference != null) {
            weakReference.clear();
        }
        Qq = null;
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        Window window;
        try {
            this.Qo = bVar;
            com.kwad.sdk.core.c.b.aaf();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = Qq;
                if (weakReference != null) {
                    window = weakReference.get();
                } else {
                    window = currentActivity.getWindow();
                }
                View viewFindViewById = window.getDecorView().findViewById(R.id.content);
                if (!(viewFindViewById instanceof ViewGroup)) {
                    return false;
                }
                this.Qp = new WeakReference<>(currentActivity);
                this.Qn = new g(m.wrapContextIfNeed(currentActivity), adTemplate, this);
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.a(this.Cf);
                this.sJ = (ViewGroup) viewFindViewById;
                this.sJ.addView(this.Qn, new ViewGroup.LayoutParams(-1, -1));
                bVar.oQ();
                return true;
            }
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ge() {
        g gVar;
        if (this.sK) {
            return;
        }
        this.sK = true;
        this.Qo.gd();
        ViewGroup viewGroup = this.sJ;
        if (viewGroup != null && (gVar = this.Qn) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.Cf);
    }

    @Override // com.kwad.components.core.e.a.d
    public final void oR() {
        ge();
    }
}
