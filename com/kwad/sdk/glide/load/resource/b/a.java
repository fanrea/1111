package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static volatile boolean bXU = true;

    public static Drawable a(Context context, Context context2, int i) {
        return b(context, context2, i);
    }

    public static Drawable a(Context context, int i, Resources.Theme theme) {
        return b(context, context, i);
    }

    private static Drawable b(Context context, Context context2, int i) {
        try {
            return context2.getResources().getDrawable(i);
        } catch (Resources.NotFoundException unused) {
            return context2.getResources().getDrawable(i);
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            bXU = false;
            return context2.getResources().getDrawable(i);
        }
    }
}
