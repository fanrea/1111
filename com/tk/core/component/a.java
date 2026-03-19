package com.tk.core.component;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.kuaishou.tk.api.export.sdk.Callback;
import com.tk.core.o.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private Bitmap BF;
    private final com.tk.core.component.view.d ZL;
    private String ZM;
    private boolean ZN;
    private String mBackgroundPosition;
    private String mBackgroundSize;
    private final com.tk.core.bridge.b mTKJSContext;

    public a(com.tk.core.bridge.b bVar, com.tk.core.component.view.d dVar) {
        this.mTKJSContext = bVar;
        this.ZL = dVar;
    }

    public final void bf(String str) {
        if (this.ZN || TextUtils.isEmpty(str) || str.equals(this.mBackgroundSize)) {
            return;
        }
        this.mBackgroundSize = str;
        Bitmap bitmap = this.BF;
        if (bitmap != null) {
            updateBackgroundImage(bitmap, this.mBackgroundSize, this.mBackgroundPosition);
        }
    }

    public final void bg(String str) {
        if (this.ZN || TextUtils.isEmpty(str) || str.equals(this.mBackgroundPosition)) {
            return;
        }
        this.mBackgroundPosition = str;
        Bitmap bitmap = this.BF;
        if (bitmap != null) {
            updateBackgroundImage(bitmap, this.mBackgroundSize, this.mBackgroundPosition);
        }
    }

    public final void bh(final String str) {
        if (this.ZN || TextUtils.isEmpty(str) || str.equals(this.ZM)) {
            return;
        }
        this.ZM = str;
        h.c(this.mTKJSContext.getContext(), str, this.mTKJSContext.pq(), this.mTKJSContext.pn(), 0, 0, new Callback<h.a>() { // from class: com.tk.core.component.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kuaishou.tk.api.export.sdk.Callback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void callback(h.a aVar) {
                if (a.this.ZN || aVar == null || aVar.HI == null) {
                    return;
                }
                if (b.pJ() || a.this.ZM.equals(aVar.QJ)) {
                    a.this.BF = aVar.HI;
                    a.this.updateBackgroundImage(aVar.HI, a.this.mBackgroundSize, a.this.mBackgroundPosition);
                }
            }

            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final void error(Throwable th) {
                com.tk.core.i.a.a("BackgroundImageHelper", "setBackgroundImage request exception, backgroundImage: " + str, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBackgroundImage(Bitmap bitmap, String str, String str2) {
        if (bitmap == null || bitmap.isRecycled() || this.ZN) {
            return;
        }
        this.ZL.updateBackgroundImage(bitmap, str, str2);
    }

    public final void pI() {
        this.ZN = true;
        this.BF = null;
    }
}
