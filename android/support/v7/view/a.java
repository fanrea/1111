package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.a.a;
import android.view.ViewConfiguration;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    private Context mContext;

    public static a c(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    public final int aD() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    public final boolean aE() {
        return Build.VERSION.SDK_INT >= 19 || !ViewConfiguration.get(this.mContext).hasPermanentMenuKey();
    }

    public final int aF() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    private boolean aG() {
        return this.mContext.getResources().getBoolean(a.b.abc_action_bar_embed_tabs);
    }

    public final int aH() {
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.C0010a.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0);
        Resources resources = this.mContext.getResources();
        if (!aG()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public final int aI() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width);
    }
}
