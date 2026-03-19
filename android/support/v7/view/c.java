package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.a.a;
import android.view.LayoutInflater;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class c extends ContextWrapper {
    private LayoutInflater ek;
    private int fH;
    private Resources.Theme fI;
    private Configuration fJ;
    private Resources fK;

    public c() {
        super(null);
    }

    public c(Context context, int i) {
        super(context);
        this.fH = i;
    }

    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return aJ();
    }

    private Resources aJ() {
        if (this.fK == null) {
            if (this.fJ == null) {
                this.fK = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.fK = createConfigurationContext(this.fJ).getResources();
            }
        }
        return this.fK;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.fH != i) {
            this.fH = i;
            aK();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.fI;
        if (theme != null) {
            return theme;
        }
        if (this.fH == 0) {
            this.fH = a.i.Theme_AppCompat_Light;
        }
        aK();
        return this.fI;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.ek == null) {
                this.ek = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.ek;
        }
        return getBaseContext().getSystemService(str);
    }

    private static void a(Resources.Theme theme, int i) {
        theme.applyStyle(i, true);
    }

    private void aK() {
        if (this.fI == null) {
            this.fI = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.fI.setTo(theme);
            }
        }
        a(this.fI, this.fH);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }
}
