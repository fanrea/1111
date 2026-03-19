package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.widget.al;
import android.util.DisplayMetrics;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class as extends ContextWrapper {
    private static final Object vk = new Object();
    private static ArrayList<WeakReference<as>> vl;
    private final Resources.Theme fI;
    private final Resources fK;

    /* renamed from: android.support.v7.widget.as$1, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass1 extends al.n {
        boolean xx = false;

        AnonymousClass1() {
        }

        @Override // android.support.v7.widget.al.n
        public final void c(al alVar, int i) {
            super.c(alVar, i);
            if (i == 0 && this.xx) {
                this.xx = false;
                as.this.gq();
            }
        }

        @Override // android.support.v7.widget.al.n
        public final void a(al alVar, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.xx = true;
        }
    }

    public static Context j(Context context) {
        if (!k(context)) {
            return context;
        }
        synchronized (vk) {
            if (vl == null) {
                vl = new ArrayList<>();
            } else {
                for (int size = vl.size() - 1; size >= 0; size--) {
                    WeakReference<as> weakReference = vl.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        vl.remove(size);
                    }
                }
                for (int size2 = vl.size() - 1; size2 >= 0; size2--) {
                    WeakReference<as> weakReference2 = vl.get(size2);
                    as asVar = weakReference2 != null ? weakReference2.get() : null;
                    if (asVar != null && asVar.getBaseContext() == context) {
                        return asVar;
                    }
                }
            }
            as asVar2 = new as(context);
            vl.add(new WeakReference<>(asVar2));
            return asVar2;
        }
    }

    private static boolean k(Context context) {
        if ((context instanceof as) || (context.getResources() instanceof au) || (context.getResources() instanceof ba)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || ba.fD();
    }

    private as(Context context) {
        super(context);
        if (ba.fD()) {
            this.fK = new ba(this, context.getResources());
            this.fI = this.fK.newTheme();
            this.fI.setTo(context.getTheme());
        } else {
            this.fK = new au(this, context.getResources());
            this.fI = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.fI;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        Resources.Theme theme = this.fI;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.fK;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.fK.getAssets();
    }

    /* renamed from: android.support.v7.widget.as$2, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass2 extends ad {
        AnonymousClass2(Context context) {
            super(context);
        }

        protected final void a(View view, al.t.a aVar) {
            if (as.this.pD == null) {
                return;
            }
            as asVar = as.this;
            int[] iArrA = asVar.a(asVar.pD.getLayoutManager(), view);
            int i = iArrA[0];
            int i2 = iArrA[1];
            int iAu = au(Math.max(Math.abs(i), Math.abs(i2)));
            if (iAu > 0) {
                aVar.a(i, i2, iAu, this.rB);
            }
        }

        protected final float a(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }
}
