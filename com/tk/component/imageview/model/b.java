package com.tk.component.imageview.model;

import android.util.Log;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.manager.a.f;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "progressiveEnabled";
            case 1:
                return "borderWidth";
            case 2:
                return "blurRadius";
            case 3:
                return "resize";
            case 4:
                return "borderColor";
            case 5:
                return "iconName";
            case 6:
                return "fallbackImage";
            case 7:
                return "fadeEnabled";
            case 8:
                return "cdnUrl";
            case 9:
                return ContentProviderManager.PROVIDER_URI;
            case 10:
                return "thumbnailPixelSize";
            case 11:
                return "loadCallback";
            case 12:
                return "placeHolder";
            case 13:
                return "cdnResizeMode";
            case 14:
                return "borderRadius";
            case 15:
                return "tintColor";
            case 16:
                return "viewMode";
            case 17:
                return "setTintColor";
            case 18:
                return "setPlaceholder";
            case 19:
                return "setImageLoadCallback";
            case 20:
                return "setViewMode";
            case 21:
                return "setFallbackImage";
            case 22:
                return "setBlurRadius";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#progressiveEnabled#0,2#borderWidth#1,2#blurRadius#2,2#resize#3,2#borderColor#4,2#iconName#5,2#fallbackImage#6,2#fadeEnabled#7,2#cdnUrl#8,2#uri#9,2#thumbnailPixelSize#10,2#loadCallback#11,2#placeHolder#12,2#cdnResizeMode#13,2#borderRadius#14,2#tintColor#15,2#viewMode#16,4#setTintColor#17,4#setPlaceholder#18,4#setImageLoadCallback#19,4#setViewMode#20,4#setFallbackImage#21,4#setBlurRadius#22";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return X(nativeModuleInitParams);
    }

    private static a X(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return ((str.hashCode() == -934437708 && str.equals("resize")) ? (char) 0 : (char) 65535) == 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1633907685: goto Lba;
                case -1428201511: goto Lb0;
                case -1364966910: goto La5;
                case -934437708: goto L9b;
                case -858961627: goto L91;
                case -738113884: goto L87;
                case -317886061: goto L7c;
                case 116076: goto L71;
                case 542576537: goto L67;
                case 693344388: goto L5c;
                case 722830999: goto L51;
                case 741115130: goto L46;
                case 1111556939: goto L3a;
                case 1195642344: goto L2e;
                case 1327599912: goto L22;
                case 1349188574: goto L16;
                case 1875318070: goto Lb;
                default: goto L9;
            }
        L9:
            goto Lc5
        Lb:
            java.lang.String r0 = "progressiveEnabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 0
            goto Lc6
        L16:
            java.lang.String r0 = "borderRadius"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 14
            goto Lc6
        L22:
            java.lang.String r0 = "tintColor"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 15
            goto Lc6
        L2e:
            java.lang.String r0 = "viewMode"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 16
            goto Lc6
        L3a:
            java.lang.String r0 = "loadCallback"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 11
            goto Lc6
        L46:
            java.lang.String r0 = "borderWidth"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 1
            goto Lc6
        L51:
            java.lang.String r0 = "borderColor"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 4
            goto Lc6
        L5c:
            java.lang.String r0 = "cdnResizeMode"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 13
            goto Lc6
        L67:
            java.lang.String r0 = "fallbackImage"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 6
            goto Lc6
        L71:
            java.lang.String r0 = "uri"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 9
            goto Lc6
        L7c:
            java.lang.String r0 = "placeHolder"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 12
            goto Lc6
        L87:
            java.lang.String r0 = "iconName"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 5
            goto Lc6
        L91:
            java.lang.String r0 = "fadeEnabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 7
            goto Lc6
        L9b:
            java.lang.String r0 = "resize"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 3
            goto Lc6
        La5:
            java.lang.String r0 = "cdnUrl"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 8
            goto Lc6
        Lb0:
            java.lang.String r0 = "blurRadius"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 2
            goto Lc6
        Lba:
            java.lang.String r0 = "thumbnailPixelSize"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 10
            goto Lc6
        Lc5:
            r4 = -1
        Lc6:
            switch(r4) {
                case 0: goto Lca;
                case 1: goto Lca;
                case 2: goto Lca;
                case 3: goto Lca;
                case 4: goto Lca;
                case 5: goto Lca;
                case 6: goto Lca;
                case 7: goto Lca;
                case 8: goto Lca;
                case 9: goto Lca;
                case 10: goto Lca;
                case 11: goto Lca;
                case 12: goto Lca;
                case 13: goto Lca;
                case 14: goto Lca;
                case 15: goto Lca;
                case 16: goto Lca;
                default: goto Lc9;
            }
        Lc9:
            return r2
        Lca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.model.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1813758031: goto L40;
                case -1582341116: goto L36;
                case -1427979546: goto L2c;
                case -1110004630: goto L22;
                case -951818789: goto L18;
                case 1888301655: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "setFallbackImage"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 4
            goto L4b
        L18:
            java.lang.String r0 = "setBlurRadius"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 5
            goto L4b
        L22:
            java.lang.String r0 = "setViewMode"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 3
            goto L4b
        L2c:
            java.lang.String r0 = "setTintColor"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 0
            goto L4b
        L36:
            java.lang.String r0 = "setImageLoadCallback"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 2
            goto L4b
        L40:
            java.lang.String r0 = "setPlaceholder"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 1
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L58
            if (r8 == r6) goto L58
            if (r8 == r5) goto L58
            if (r8 == r4) goto L58
            if (r8 == r3) goto L58
            if (r8 == r2) goto L58
            return r1
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.model.b.h(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1633907685:
                    if (str.equals("thumbnailPixelSize")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1428201511:
                    if (str.equals("blurRadius")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1364966910:
                    if (str.equals("cdnUrl")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c = 3;
                        break;
                    }
                    break;
                case -858961627:
                    if (str.equals("fadeEnabled")) {
                        c = 7;
                        break;
                    }
                    break;
                case -738113884:
                    if (str.equals("iconName")) {
                        c = 5;
                        break;
                    }
                    break;
                case -317886061:
                    if (str.equals("placeHolder")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 116076:
                    if (str.equals(ContentProviderManager.PROVIDER_URI)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 542576537:
                    if (str.equals("fallbackImage")) {
                        c = 6;
                        break;
                    }
                    break;
                case 693344388:
                    if (str.equals("cdnResizeMode")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 4;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1111556939:
                    if (str.equals("loadCallback")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1195642344:
                    if (str.equals("viewMode")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1327599912:
                    if (str.equals("tintColor")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1875318070:
                    if (str.equals("progressiveEnabled")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar.aa(((Boolean) obj2).booleanValue());
                    break;
                case 1:
                    aVar.Rm = f.f((Number) obj2);
                    break;
                case 2:
                    aVar.cM(f.h((Number) obj2));
                    break;
                case 3:
                    aVar.aA((String) obj2);
                    break;
                case 4:
                    aVar.Rn = (String) obj2;
                    break;
                case 5:
                    aVar.aI((String) obj2);
                    break;
                case 6:
                    aVar.aH((String) obj2);
                    break;
                case 7:
                    aVar.setFadeEnabled(((Boolean) obj2).booleanValue());
                    break;
                case '\b':
                    aVar.aR((String) obj2);
                    break;
                case '\t':
                    aVar.at((String) obj2);
                    break;
                case '\n':
                    aVar.b((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 11:
                    aVar.y((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\f':
                    aVar.as((String) obj2);
                    break;
                case '\r':
                    aVar.cO(f.h((Number) obj2));
                    break;
                case 14:
                    aVar.Rl = f.h((Number) obj2);
                    break;
                case 15:
                    aVar.setTintColor((String) obj2);
                    break;
                case 16:
                    aVar.Rw = f.h((Number) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKImageLoadParam", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKImageLoadParam apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.model.b.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    private static void c(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            if (str.hashCode() == -934437708 && str.equals("resize")) {
                c = 0;
            }
            if (c == 0) {
                aVar.aA((String) obj2);
            } else if (t.isDebug()) {
                Log.e("TKImageLoadParam", "call applyAttr() with unsupported attr: " + str);
            }
        } catch (Exception e) {
            throw new RuntimeException("TKImageLoadParam setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r9, java.lang.String r10, java.lang.Object[] r11) {
        /*
            r8 = this;
            com.tk.component.imageview.model.a r9 = (com.tk.component.imageview.model.a) r9
            int r0 = r10.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r0) {
                case -1813758031: goto L42;
                case -1582341116: goto L38;
                case -1427979546: goto L2e;
                case -1110004630: goto L24;
                case -951818789: goto L1a;
                case 1888301655: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L4c
        L10:
            java.lang.String r0 = "setFallbackImage"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 4
            goto L4d
        L1a:
            java.lang.String r0 = "setBlurRadius"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 5
            goto L4d
        L24:
            java.lang.String r0 = "setViewMode"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 3
            goto L4d
        L2e:
            java.lang.String r0 = "setTintColor"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 0
            goto L4d
        L38:
            java.lang.String r0 = "setImageLoadCallback"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 2
            goto L4d
        L42:
            java.lang.String r0 = "setPlaceholder"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 1
            goto L4d
        L4c:
            r0 = -1
        L4d:
            r7 = 0
            if (r0 == 0) goto Lac
            if (r0 == r5) goto La2
            if (r0 == r4) goto L9a
            if (r0 == r3) goto L8c
            if (r0 == r2) goto L82
            if (r0 == r1) goto L74
            boolean r9 = com.tk.core.o.t.isDebug()
            if (r9 == 0) goto L73
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "can't find method ---> "
            r9.<init>(r11)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "TKImageLoadParam"
            android.util.Log.e(r10, r9)
        L73:
            return r7
        L74:
            java.lang.Object r10 = com.tk.core.o.a.c(r11, r6)
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = com.tk.core.manager.a.f.h(r10)
            r9.cM(r10)
            return r7
        L82:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r10 = (java.lang.String) r10
            r9.aH(r10)
            return r7
        L8c:
            java.lang.Object r10 = com.tk.core.o.a.c(r11, r6)
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = com.tk.core.manager.a.f.h(r10)
            r9.cN(r10)
            return r7
        L9a:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            r9.y(r10)
            return r7
        La2:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r10 = (java.lang.String) r10
            r9.as(r10)
            return r7
        Lac:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r10 = (java.lang.String) r10
            r9.setTintColor(r10)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.model.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
