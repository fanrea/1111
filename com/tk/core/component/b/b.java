package com.tk.core.component.b;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.b;
import com.tk.core.component.e;
import com.tk.core.component.text.e;
import com.tk.core.component.text.f;
import com.tk.core.o.ac;
import com.tk.core.o.r;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends e<Button> {
    public String KE;
    private HashMap<String, HashMap> acB;
    private String acC;
    private String acD;
    private String acE;
    private e.a acF;
    private String acG;
    private int acH;
    private int acI;
    public HashMap acJ;
    public HashMap acK;
    public Map<String, String> acL;

    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return J(context);
    }

    static /* synthetic */ e.a a(b bVar, e.a aVar) {
        bVar.acF = null;
        return null;
    }

    public b(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        ae();
    }

    public b(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
        ae();
    }

    private void ae() {
        this.acB = new HashMap<>();
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return com.tk.core.component.e.qv() || Build.VERSION.SDK_INT > 25;
    }

    @Override // com.tk.core.component.e
    public final boolean qr() {
        return !com.tk.core.component.e.qv();
    }

    private static Button J(Context context) {
        Button button = new Button(context);
        button.setMinimumWidth(0);
        button.setMinimumHeight(0);
        button.setMinWidth(0);
        button.setMinHeight(0);
        button.setAllCaps(false);
        button.setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator(null);
        }
        return button;
    }

    @Override // com.tk.core.component.e
    public final void a(HashMap map) {
        f(map);
        super.a(map);
        k(map);
    }

    private void k(HashMap map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap map2 = this.acB.get("normal");
        if (map2 == null || map2.size() <= 0) {
            this.acB.put("normal", map);
        } else {
            map2.putAll(map);
        }
    }

    public final void setText(String str) {
        if (str == null || !str.equals(this.KE)) {
            this.KE = str;
            getView().setText(this.KE);
        }
    }

    public final void dD(int i) {
        Button view = getView();
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        view.setMaxLines(i);
    }

    public final void dE(int i) {
        dD(i);
    }

    public final void bS(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.acD)) {
            return;
        }
        this.acD = str;
        bV(this.acC);
    }

    public final void bT(String str) {
        String str2 = this.acE;
        if (str2 == null || !str2.equals(str)) {
            this.acE = str;
            bV(this.acC);
        }
    }

    public final void bU(String str) {
        if ("clip".equalsIgnoreCase(str)) {
            getView().setEllipsize(null);
            return;
        }
        if ("ellipsis".equalsIgnoreCase(str)) {
            getView().setEllipsize(TextUtils.TruncateAt.END);
        } else if ("head".equalsIgnoreCase(str)) {
            getView().setEllipsize(TextUtils.TruncateAt.START);
        } else if ("middle".equalsIgnoreCase(str)) {
            getView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
        }
    }

    public final void l(HashMap map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        if (this.acJ == null) {
            this.acJ = new HashMap();
        }
        this.acJ.putAll(map);
        this.acB.put("pressed", this.acJ);
        a(new int[]{R.attr.state_pressed, R.attr.state_enabled}, map);
    }

    public final void m(HashMap map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        if (this.acK == null) {
            this.acK = new HashMap();
        }
        this.acK.putAll(map);
        this.acB.put("disabled", this.acK);
        a(new int[]{-16842910}, this.acK);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void al(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = 3317767(0x32a007, float:4.649182E-39)
            if (r0 == r1) goto L20
            r1 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 2
            goto L35
        L20:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 1
            goto L35
        L2a:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 0
            goto L35
        L34:
            r5 = -1
        L35:
            if (r5 == 0) goto L54
            if (r5 == r3) goto L48
            if (r5 == r2) goto L3c
            goto L47
        L3c:
            android.view.View r5 = r4.getView()
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 21
            r5.setGravity(r0)
        L47:
            return
        L48:
            android.view.View r5 = r4.getView()
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 19
            r5.setGravity(r0)
            return
        L54:
            android.view.View r5 = r4.getView()
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 17
            r5.setGravity(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.b.b.al(java.lang.String):void");
    }

    public final void ak(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.acC)) {
            return;
        }
        this.acH++;
        this.acC = str;
        bV(str);
    }

    public final void dF(int i) {
        getView().setTextSize(1, i);
    }

    public final void aj(String str) {
        Integer numValueOf = Integer.valueOf(r.a(str, pP()));
        if (numValueOf == null) {
            return;
        }
        getView().setTextColor(numValueOf.intValue());
    }

    private void a(int[] iArr, HashMap map) {
        qa().b(iArr, a.h(map));
        ColorStateList colorStateListI = a.i(this.acB);
        if (colorStateListI != null) {
            getView().setTextColor(colorStateListI);
        }
    }

    public final void i(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.acI++;
        this.acL = map;
        String str = map.get("src");
        final String str2 = map.get("fileName");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = this.acC;
        if (str3 == null || !str3.equals(str2)) {
            this.acC = str2;
            this.acG = str2;
            if (f.rh().a(str2, 0, pq(), getVersionCode()) != null) {
                bW(str2);
                return;
            }
            e.a aVar = this.acF;
            if (aVar != null) {
                com.tk.core.component.text.e.a(this.acG, aVar);
            }
            this.acF = new e.a() { // from class: com.tk.core.component.b.b.1
                @Override // com.tk.core.component.text.e.a
                public final void a(Typeface typeface, boolean z, int i) {
                    b.a(b.this, (e.a) null);
                    if (b.this.acI != i) {
                        return;
                    }
                    b.this.bW(str2);
                }
            };
            com.tk.core.component.text.e.a(pq(), getContext(), str, str2, getVersionCode(), this.acI, this.acF);
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(final TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            qU();
        } else {
            ac.c(new Runnable() { // from class: com.tk.core.component.b.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    TKBaseNativeModule.DestroyReason destroyReason2 = destroyReason;
                    bVar.qU();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qU() {
        e.a aVar = this.acF;
        if (aVar != null) {
            com.tk.core.component.text.e.a(this.acG, aVar);
        }
    }

    private void bV(String str) {
        com.tk.core.component.b.a(getView(), str, this.acD, this.acE, pn(), pR().getYogaNode(), pq(), getVersionCode(), this.acH, new b.a() { // from class: com.tk.core.component.b.b.3
            @Override // com.tk.core.component.b.a
            public final void a(Typeface typeface, int i, int i2) {
                if (b.this.pN() || b.this.acH != i2) {
                    return;
                }
                b.this.getView().setTypeface(typeface, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(String str) {
        com.tk.core.component.b.a(getView(), str, this.acD, this.acE, pn(), pR().getYogaNode(), pq(), getVersionCode(), this.acI, new b.a() { // from class: com.tk.core.component.b.b.4
            @Override // com.tk.core.component.b.a
            public final void a(Typeface typeface, int i, int i2) {
                if (b.this.pN() || b.this.acI != i2) {
                    return;
                }
                b.this.getView().setTypeface(typeface, i);
            }
        });
    }
}
