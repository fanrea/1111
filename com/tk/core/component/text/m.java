package com.tk.core.component.text;

import android.content.Context;
import android.view.View;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class m extends com.tk.core.component.e<g> {
    public String KE;

    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return N(context);
    }

    public m(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        if (z) {
            nj();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.text.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.nj();
                }
            });
        }
        super.a(destroyReason, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        if (pQ()) {
            getView().rm();
        }
    }

    private static g N(Context context) {
        return new g(context);
    }

    public final void setText(String str) {
        if (str == null || !str.equals(this.KE)) {
            this.KE = str;
            pR().getYogaNode().dirty();
            getView().setText(this.KE);
        }
    }

    public final void aj(String str) {
        getView().setTextColor(com.tk.core.o.r.a(str, pP()));
    }

    public final void dF(int i) {
        getView().setTextSize(1, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void bS(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = 3029637(0x2e3a85, float:4.245426E-39)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "bold"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L1b:
            java.lang.String r0 = "normal"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L25:
            r5 = -1
        L26:
            if (r5 == 0) goto L3f
            if (r5 == r3) goto L2b
            goto L3e
        L2b:
            android.view.View r5 = r4.getView()
            com.tk.core.component.text.g r5 = (com.tk.core.component.text.g) r5
            android.view.View r0 = r4.getView()
            com.tk.core.component.text.g r0 = (com.tk.core.component.text.g) r0
            android.graphics.Typeface r0 = r0.getTypeface()
            r5.setTypeface(r0, r2)
        L3e:
            return
        L3f:
            android.view.View r5 = r4.getView()
            com.tk.core.component.text.g r5 = (com.tk.core.component.text.g) r5
            android.view.View r0 = r4.getView()
            com.tk.core.component.text.g r0 = (com.tk.core.component.text.g) r0
            android.graphics.Typeface r0 = r0.getTypeface()
            r5.setTypeface(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.m.bS(java.lang.String):void");
    }
}
