package com.kwad.tachikoma.f;

import com.kuaishou.tk.export.NativeModuleInitParams;
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
        switch (i) {
            case 0:
                return "show";
            case 1:
                return "setTemplateInfo";
            case 2:
                return "registerBridge";
            case 3:
                return "setOnDismissListener";
            case 4:
                return "setIsHideNavigationBar";
            case 5:
                return "setViewKey";
            case 6:
                return "dismiss";
            default:
                return null;
        }
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
        return "4#show#0,4#setTemplateInfo#1,4#registerBridge#2,4#setOnDismissListener#3,4#setIsHideNavigationBar#4,4#setViewKey#5,4#dismiss#6";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return n(nativeModuleInitParams);
    }

    private static a n(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1065446083: goto L46;
                case -969869300: goto L3c;
                case -867092808: goto L32;
                case -652294287: goto L28;
                case 3529469: goto L1e;
                case 1560962506: goto L14;
                case 1671672458: goto La;
                default: goto L9;
            }
        L9:
            goto L50
        La:
            java.lang.String r0 = "dismiss"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L50
            r4 = 6
            goto L51
        L14:
            java.lang.String r0 = "setTemplateInfo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L50
            r4 = 1
            goto L51
        L1e:
            java.lang.String r0 = "show"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L50
            r4 = 0
            goto L51
        L28:
            java.lang.String r0 = "setIsHideNavigationBar"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L50
            r4 = 4
            goto L51
        L32:
            java.lang.String r0 = "setViewKey"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L50
            r4 = 5
            goto L51
        L3c:
            java.lang.String r0 = "registerBridge"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L50
            r4 = 2
            goto L51
        L46:
            java.lang.String r0 = "setOnDismissListener"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L50
            r4 = 3
            goto L51
        L50:
            r4 = -1
        L51:
            switch(r4) {
                case 0: goto L55;
                case 1: goto L55;
                case 2: goto L55;
                case 3: goto L55;
                case 4: goto L55;
                case 5: goto L55;
                case 6: goto L55;
                default: goto L54;
            }
        L54:
            return r2
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.f.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r4, java.lang.String r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            com.kwad.tachikoma.f.a r4 = (com.kwad.tachikoma.f.a) r4
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case -1065446083: goto L47;
                case -969869300: goto L3d;
                case -867092808: goto L33;
                case -652294287: goto L29;
                case 3529469: goto L1f;
                case 1560962506: goto L15;
                case 1671672458: goto Lb;
                default: goto La;
            }
        La:
            goto L51
        Lb:
            java.lang.String r0 = "dismiss"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L51
            r0 = 6
            goto L52
        L15:
            java.lang.String r0 = "setTemplateInfo"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L51
            r0 = 1
            goto L52
        L1f:
            java.lang.String r0 = "show"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L51
            r0 = 0
            goto L52
        L29:
            java.lang.String r0 = "setIsHideNavigationBar"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L51
            r0 = 4
            goto L52
        L33:
            java.lang.String r0 = "setViewKey"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L51
            r0 = 5
            goto L52
        L3d:
            java.lang.String r0 = "registerBridge"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L51
            r0 = 2
            goto L52
        L47:
            java.lang.String r0 = "setOnDismissListener"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L51
            r0 = 3
            goto L52
        L51:
            r0 = -1
        L52:
            r2 = 0
            switch(r0) {
                case 0: goto Laa;
                case 1: goto La0;
                case 2: goto L96;
                case 3: goto L8c;
                case 4: goto L7e;
                case 5: goto L74;
                case 6: goto L70;
                default: goto L56;
            }
        L56:
            boolean r4 = com.tk.core.o.t.isDebug()
            if (r4 == 0) goto Lb3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "can't find method ---> "
            r4.<init>(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "TKDialog"
            android.util.Log.e(r5, r4)
            goto Lb3
        L70:
            r4.dismiss()
            return r2
        L74:
            java.lang.Object r5 = com.tk.core.o.a.b(r6, r1)
            java.lang.String r5 = (java.lang.String) r5
            r4.setViewKey(r5)
            return r2
        L7e:
            java.lang.Object r5 = com.tk.core.o.a.d(r6, r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r4.I(r5)
            return r2
        L8c:
            java.lang.Object r5 = com.tk.core.o.a.b(r6, r1)
            com.tkruntime.v8.V8Function r5 = (com.tkruntime.v8.V8Function) r5
            r4.h(r5)
            return r2
        L96:
            java.lang.Object r5 = com.tk.core.o.a.b(r6, r1)
            com.tkruntime.v8.V8Object r5 = (com.tkruntime.v8.V8Object) r5
            r4.i(r5)
            return r2
        La0:
            java.lang.Object r5 = com.tk.core.o.a.b(r6, r1)
            java.lang.String r5 = (java.lang.String) r5
            r4.q(r5)
            return r2
        Laa:
            java.lang.Object r5 = com.tk.core.o.a.b(r6, r1)
            com.tkruntime.v8.V8Function r5 = (com.tkruntime.v8.V8Function) r5
            r4.i(r5)
        Lb3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.f.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
