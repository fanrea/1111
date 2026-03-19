package com.tk.core.component.text;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.luck.picture.lib.config.CustomIntentKey;
import com.sigmob.sdk.base.mta.PointCategory;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import io.netty.util.internal.StringUtil;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class j implements com.tk.core.manager.a.a<h> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "spanType";
            case 1:
                return "textStyle";
            case 2:
                return "size";
            case 3:
                return "start";
            case 4:
                return "marginRight";
            case 5:
                return "clickHideUnderline";
            case 6:
                return CustomIntentKey.EXTRA_IMAGE_HEIGHT;
            case 7:
                return "imagePlaceholder";
            case 8:
                return "marginLeft";
            case 9:
                return CustomIntentKey.EXTRA_OFFSET_X;
            case 10:
                return PointCategory.END;
            case 11:
                return "index";
            case 12:
                return TypedValues.Custom.S_COLOR;
            case 13:
                return "imageUrl";
            case 14:
                return CustomIntentKey.EXTRA_OFFSET_Y;
            case 15:
                return CustomIntentKey.EXTRA_IMAGE_WIDTH;
            case 16:
                return "url";
            case 17:
                return "fontFamily";
            case 18:
                return "setSpanOnClickListener";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#spanType#0,2#textStyle#1,2#size#2,2#start#3,2#marginRight#4,2#clickHideUnderline#5,2#imageHeight#6,2#imagePlaceholder#7,2#marginLeft#8,2#offsetX#9,2#end#10,2#index#11,2#color#12,2#imageUrl#13,2#offsetY#14,2#imageWidth#15,2#url#16,2#fontFamily#17,4#setSpanOnClickListener#18";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ h b(NativeModuleInitParams nativeModuleInitParams) {
        return an(nativeModuleInitParams);
    }

    private static h an(NativeModuleInitParams nativeModuleInitParams) {
        return new h(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
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
                case -1548407259: goto Lc6;
                case -1548407258: goto Lbb;
                case -1450494677: goto Lb0;
                case -1224696685: goto La5;
                case -1179157758: goto L9b;
                case -1048634236: goto L91;
                case -859610604: goto L86;
                case -483807976: goto L7c;
                case 100571: goto L71;
                case 116079: goto L66;
                case 3530753: goto L5b;
                case 94842723: goto L4f;
                case 100346066: goto L43;
                case 109757538: goto L38;
                case 975087886: goto L2d;
                case 1846310498: goto L22;
                case 1970934485: goto L16;
                case 2057127332: goto Lb;
                default: goto L9;
            }
        L9:
            goto Ld1
        Lb:
            java.lang.String r0 = "spanType"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 0
            goto Ld2
        L16:
            java.lang.String r0 = "marginLeft"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 8
            goto Ld2
        L22:
            java.lang.String r0 = "imageHeight"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 6
            goto Ld2
        L2d:
            java.lang.String r0 = "marginRight"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 4
            goto Ld2
        L38:
            java.lang.String r0 = "start"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 3
            goto Ld2
        L43:
            java.lang.String r0 = "index"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 11
            goto Ld2
        L4f:
            java.lang.String r0 = "color"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 12
            goto Ld2
        L5b:
            java.lang.String r0 = "size"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 2
            goto Ld2
        L66:
            java.lang.String r0 = "url"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 16
            goto Ld2
        L71:
            java.lang.String r0 = "end"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 10
            goto Ld2
        L7c:
            java.lang.String r0 = "imagePlaceholder"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 7
            goto Ld2
        L86:
            java.lang.String r0 = "imageUrl"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 13
            goto Ld2
        L91:
            java.lang.String r0 = "textStyle"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 1
            goto Ld2
        L9b:
            java.lang.String r0 = "clickHideUnderline"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 5
            goto Ld2
        La5:
            java.lang.String r0 = "fontFamily"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 17
            goto Ld2
        Lb0:
            java.lang.String r0 = "imageWidth"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 15
            goto Ld2
        Lbb:
            java.lang.String r0 = "offsetY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 14
            goto Ld2
        Lc6:
            java.lang.String r0 = "offsetX"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 9
            goto Ld2
        Ld1:
            r4 = -1
        Ld2:
            switch(r4) {
                case 0: goto Ld6;
                case 1: goto Ld6;
                case 2: goto Ld6;
                case 3: goto Ld6;
                case 4: goto Ld6;
                case 5: goto Ld6;
                case 6: goto Ld6;
                case 7: goto Ld6;
                case 8: goto Ld6;
                case 9: goto Ld6;
                case 10: goto Ld6;
                case 11: goto Ld6;
                case 12: goto Ld6;
                case 13: goto Ld6;
                case 14: goto Ld6;
                case 15: goto Ld6;
                case 16: goto Ld6;
                case 17: goto Ld6;
                default: goto Ld5;
            }
        Ld5:
            return r2
        Ld6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.j.g(java.lang.String):boolean");
    }

    @Override // com.tk.core.manager.a.a
    public final int h(String str) {
        return ((str.hashCode() == -788501935 && str.equals("setSpanOnClickListener")) ? (char) 0 : (char) 65535) != 0 ? 0 : 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        h hVar = (h) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1548407259:
                    if (str.equals(CustomIntentKey.EXTRA_OFFSET_X)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1548407258:
                    if (str.equals(CustomIntentKey.EXTRA_OFFSET_Y)) {
                        c = 14;
                        break;
                    }
                    break;
                case -1450494677:
                    if (str.equals(CustomIntentKey.EXTRA_IMAGE_WIDTH)) {
                        c = 15;
                        break;
                    }
                    break;
                case -1224696685:
                    if (str.equals("fontFamily")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1179157758:
                    if (str.equals("clickHideUnderline")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1048634236:
                    if (str.equals("textStyle")) {
                        c = 1;
                        break;
                    }
                    break;
                case -859610604:
                    if (str.equals("imageUrl")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -483807976:
                    if (str.equals("imagePlaceholder")) {
                        c = 7;
                        break;
                    }
                    break;
                case 100571:
                    if (str.equals(PointCategory.END)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 116079:
                    if (str.equals("url")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3530753:
                    if (str.equals("size")) {
                        c = 2;
                        break;
                    }
                    break;
                case 94842723:
                    if (str.equals(TypedValues.Custom.S_COLOR)) {
                        c = '\f';
                        break;
                    }
                    break;
                case 100346066:
                    if (str.equals("index")) {
                        c = 11;
                        break;
                    }
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c = 3;
                        break;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1846310498:
                    if (str.equals(CustomIntentKey.EXTRA_IMAGE_HEIGHT)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 2057127332:
                    if (str.equals("spanType")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    hVar.afz = (String) obj2;
                    break;
                case 1:
                    hVar.afB = (String) obj2;
                    break;
                case 2:
                    hVar.size = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case 3:
                    hVar.start = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case 4:
                    hVar.afG = com.tk.core.manager.a.f.g((Number) obj2);
                    break;
                case 5:
                    hVar.afA = ((Boolean) obj2).booleanValue();
                    break;
                case 6:
                    hVar.afD = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case 7:
                    hVar.afH = (String) obj2;
                    break;
                case '\b':
                    hVar.afF = com.tk.core.manager.a.f.g((Number) obj2);
                    break;
                case '\t':
                    hVar.Vo = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case '\n':
                    hVar.end = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case 11:
                    hVar.index = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case '\f':
                    hVar.aj((String) obj2);
                    break;
                case '\r':
                    hVar.imageUrl = (String) obj2;
                    break;
                case 14:
                    hVar.afE = com.tk.core.manager.a.f.g((Number) obj2);
                    break;
                case 15:
                    hVar.afC = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case 16:
                    hVar.url = (String) obj2;
                    break;
                case 17:
                    hVar.KS = (String) obj2;
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("SpanItem", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("SpanItem apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.j.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str, Object[] objArr) {
        h hVar = (h) obj;
        if (((str.hashCode() == -788501935 && str.equals("setSpanOnClickListener")) ? (char) 0 : (char) 65535) == 0) {
            hVar.aS((V8Function) com.tk.core.o.a.b(objArr, 0));
            return null;
        }
        if (t.isDebug()) {
            Log.e("SpanItem", "can't find method ---> " + str);
        }
        return null;
    }
}
