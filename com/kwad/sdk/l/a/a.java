package com.kwad.sdk.l.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a implements c {
    protected List<c> cju;
    protected boolean enabled;

    protected boolean cK(Context context) {
        return false;
    }

    public a(boolean z) {
        this.enabled = z;
    }

    public a() {
        this.enabled = true;
    }

    @Override // com.kwad.sdk.l.a.c
    public final boolean cJ(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children != null && children.size() > 0) {
            Iterator<c> it = children.iterator();
            while (it.hasNext()) {
                if (it.next().cJ(context)) {
                    return true;
                }
            }
            return false;
        }
        try {
            return cK(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    private List<c> getChildren() {
        return this.cju;
    }
}
