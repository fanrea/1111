package com.kwad.tachikoma.o;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private com.kwad.tachikoma.l.e Cf;
    private g Cg;
    private String Cj;
    private g Et;
    private String Eu;
    private Intent mIntent;
    private String mUrl;
    private String mViewKey;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(com.kuaishou.tk.export.NativeModuleInitParams r2) {
        /*
            r1 = this;
            r1.<init>(r2)
            java.lang.Object[] r0 = r2.args
            if (r0 == 0) goto L1c
            java.lang.Object[] r0 = r2.args
            int r0 = r0.length
            if (r0 <= 0) goto L1c
            java.lang.Object[] r2 = r2.args
            r0 = 0
            r2 = r2[r0]
            boolean r0 = r2 instanceof java.lang.Boolean
            if (r0 == 0) goto L1c
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L1d
        L1c:
            r2 = 1
        L1d:
            if (r2 == 0) goto L26
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            r1.mIntent = r2
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.o.a.<init>(com.kuaishou.tk.export.NativeModuleInitParams):void");
    }

    public final void D(String str) {
        this.Cj = str;
    }

    public final String getTemplateString() {
        return this.Cj;
    }

    public final void setViewKey(String str) {
        this.mViewKey = str;
    }

    public final String getViewKey() {
        return this.mViewKey;
    }

    public final void setClassName(String str) {
        this.Eu = str;
    }

    public final String getClassName() {
        return this.Eu;
    }

    public final void setUrl(String str) {
        this.mUrl = str;
        this.mIntent.setData(Uri.parse(str));
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final void E(String str) {
        this.mIntent.setAction(str);
    }

    public final void k(String str, String str2) {
        this.mIntent.setComponent(new ComponentName(str, str2));
    }

    public final void addCategory(String str) {
        this.mIntent.addCategory(str);
    }

    public final void a(String str, Object obj) {
        if (obj instanceof Serializable) {
            this.mIntent.putExtra(str, (Serializable) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            this.mIntent.putExtra(str, (Parcelable) obj);
            return;
        }
        com.kwad.tachikoma.e.log().e("TKNativeIntent", "Object cannot be put to intent:" + obj);
    }

    public final boolean hasExtra(String str) {
        return this.mIntent.hasExtra(str);
    }

    public final String getStringExtra(String str) {
        return this.mIntent.getStringExtra(str);
    }

    public final int getIntExtra(String str, int i) {
        return this.mIntent.getIntExtra(str, i);
    }

    public final double getDoubleExtra(String str, double d) {
        return this.mIntent.getDoubleExtra(str, d);
    }

    public final float getFloatExtra(String str, float f) {
        return this.mIntent.getFloatExtra(str, f);
    }

    public final long getLongExtra(String str, long j) {
        return this.mIntent.getLongExtra(str, j);
    }

    public final boolean getBooleanExtra(String str, boolean z) {
        return this.mIntent.getBooleanExtra(str, z);
    }

    public final V8Array F(String str) {
        int[] intArrayExtra = this.mIntent.getIntArrayExtra(str);
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        for (int i : intArrayExtra) {
            v8Array.push(i);
        }
        return v8Array;
    }

    public final V8Array G(String str) {
        boolean[] booleanArrayExtra = this.mIntent.getBooleanArrayExtra(str);
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        for (boolean z : booleanArrayExtra) {
            v8Array.push(z);
        }
        return v8Array;
    }

    public final V8Array H(String str) {
        long[] longArrayExtra = this.mIntent.getLongArrayExtra(str);
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        for (long j : longArrayExtra) {
            v8Array.push(j);
        }
        return v8Array;
    }

    public final V8Array I(String str) {
        float[] floatArrayExtra = this.mIntent.getFloatArrayExtra(str);
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        for (float f : floatArrayExtra) {
            v8Array.push(f);
        }
        return v8Array;
    }

    public final V8Array J(String str) {
        double[] doubleArrayExtra = this.mIntent.getDoubleArrayExtra(str);
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        for (double d : doubleArrayExtra) {
            v8Array.push(d);
        }
        return v8Array;
    }

    public final V8Array K(String str) {
        String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        for (String str2 : stringArrayExtra) {
            v8Array.push(str2);
        }
        return v8Array;
    }

    public final V8Array L(String str) {
        ArrayList<String> stringArrayListExtra = this.mIntent.getStringArrayListExtra(str);
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        Iterator<String> it = stringArrayListExtra.iterator();
        while (it.hasNext()) {
            v8Array.push(it.next());
        }
        return v8Array;
    }

    public final void M(String str) {
        this.mIntent.setPackage(str);
    }

    public final void setFlags(int i) {
        this.mIntent.setFlags(i);
    }

    public final void addFlags(int i) {
        this.mIntent.addFlags(i);
    }

    public final void removeFlags(int i) {
        this.mIntent.removeFlags(i);
    }

    public final void i(V8Object v8Object) {
        com.kwad.tachikoma.l.e eVar = (com.kwad.tachikoma.l.e) getNativeModule(v8Object);
        eVar.pL();
        this.Cf = eVar;
    }

    public final void v(V8Function v8Function) {
        g gVar = this.Cg;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Cg = new g(v8Function, pO());
    }

    public final void w(V8Function v8Function) {
        g gVar = this.Et;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Et = new g(v8Function, pO());
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final void callbackPageStatus(boolean z, String str) {
        g gVar = this.Cg;
        if (gVar != null) {
            gVar.call(null, Boolean.valueOf(z), str);
        }
    }

    public final void callbackDismiss() {
        g gVar = this.Et;
        if (gVar != null) {
            gVar.call(null, new Object[0]);
        }
    }

    public final void callTKBridge(String str) {
        com.kwad.tachikoma.l.e eVar = this.Cf;
        if (eVar != null) {
            eVar.callAdBridge(str);
        }
    }

    public final void a(com.kwad.tachikoma.l.c cVar) {
        com.kwad.tachikoma.l.e eVar = this.Cf;
        if (eVar != null) {
            eVar.a(cVar);
        }
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        g gVar = this.Cg;
        if (gVar != null) {
            gVar.destroy();
        }
    }

    public final void b(Intent intent) {
        this.mIntent = intent;
    }
}
