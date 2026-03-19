package com.tk.component.f;

import com.kuaishou.tk.export.NativeModuleInitParams;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str) {
        return null;
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        if (i == 0) {
            return "show";
        }
        if (i == 1) {
            return "hide";
        }
        if (i != 2) {
            return null;
        }
        return SchedulerSupport.CUSTOM;
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final boolean g(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "4#show#0,4#hide#1,4#custom#2";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return ac(nativeModuleInitParams);
    }

    private static a ac(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1349088399(0xffffffffaf968b71, float:-2.738392E-10)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = 3202370(0x30dd42, float:4.487476E-39)
            if (r0 == r1) goto L21
            r1 = 3529469(0x35dafd, float:4.94584E-39)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "show"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 0
            goto L36
        L21:
            java.lang.String r0 = "hide"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 1
            goto L36
        L2b:
            java.lang.String r0 = "custom"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 2
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3d
            if (r6 == r4) goto L3d
            if (r6 == r3) goto L3d
            return r2
        L3d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.f.b.h(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.tk.component.f.a r6 = (com.tk.component.f.a) r6
            int r0 = r7.hashCode()
            r1 = -1349088399(0xffffffffaf968b71, float:-2.738392E-10)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2d
            r1 = 3202370(0x30dd42, float:4.487476E-39)
            if (r0 == r1) goto L23
            r1 = 3529469(0x35dafd, float:4.94584E-39)
            if (r0 == r1) goto L19
            goto L37
        L19:
            java.lang.String r0 = "show"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L23:
            java.lang.String r0 = "hide"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L2d:
            java.lang.String r0 = "custom"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L37:
            r0 = -1
        L38:
            r1 = 0
            if (r0 == 0) goto L7e
            if (r0 == r4) goto L7a
            if (r0 == r3) goto L59
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "Toast"
            android.util.Log.e(r7, r6)
        L58:
            return r1
        L59:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r2)
            com.tkruntime.v8.V8Object r7 = (com.tkruntime.v8.V8Object) r7
            java.lang.Object r0 = com.tk.core.o.a.b(r8, r4)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r2 = (java.lang.String) r2
            r3 = 3
            java.lang.Object r8 = com.tk.core.o.a.c(r8, r3)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = com.tk.core.manager.a.f.h(r8)
            r6.a(r7, r0, r2, r8)
            return r1
        L7a:
            r6.hide()
            return r1
        L7e:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r4)
            java.lang.String r8 = (java.lang.String) r8
            r6.r(r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.f.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
