package com.tk.core.component;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import com.tk.core.component.text.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private static Boolean ZQ;

    public interface a {
        void a(Typeface typeface, int i, int i2);
    }

    public static void a(Context context, String str, int i, String str2, String str3, int i2, int i3, final e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Typeface typefaceBi = bi(str);
            if (typefaceBi != null) {
                aVar.a(typefaceBi, true, i3);
            } else {
                com.tk.core.component.text.f.rh().a(str, i, context.getAssets(), str2, str3, i2, i3, new e.a() { // from class: com.tk.core.component.b.1
                    @Override // com.tk.core.component.text.e.a
                    public final void a(Typeface typeface, boolean z, int i4) {
                        e.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(typeface, z, i4);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.tk.core.i.a.a("FONT", "loadFontFamily error. fontFamily = " + str, th);
        }
    }

    public static Typeface a(Context context, String str, int i, String str2, String str3, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Typeface typefaceBi = bi(str);
            return typefaceBi == null ? com.tk.core.component.text.f.rh().b(str, i, context.getAssets(), str2, str3, i2) : typefaceBi;
        } catch (Throwable th) {
            com.tk.core.i.a.a("FONT", "loadFontFamilySync error. fontFamily = " + str, th);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface bi(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1431958525: goto L29;
                case -1039745817: goto L1f;
                case 3522707: goto L15;
                case 109326717: goto Lb;
                default: goto La;
            }
        La:
            goto L33
        Lb:
            java.lang.String r0 = "serif"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L33
            r4 = 2
            goto L34
        L15:
            java.lang.String r0 = "sans"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L33
            r4 = 1
            goto L34
        L1f:
            java.lang.String r0 = "normal"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L33
            r4 = 0
            goto L34
        L29:
            java.lang.String r0 = "monospace"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L33
            r4 = 3
            goto L34
        L33:
            r4 = -1
        L34:
            if (r4 == 0) goto L47
            if (r4 == r3) goto L44
            if (r4 == r2) goto L41
            if (r4 == r1) goto L3e
            r4 = 0
            goto L49
        L3e:
            android.graphics.Typeface r4 = android.graphics.Typeface.MONOSPACE
            goto L49
        L41:
            android.graphics.Typeface r4 = android.graphics.Typeface.SERIF
            goto L49
        L44:
            android.graphics.Typeface r4 = android.graphics.Typeface.SANS_SERIF
            goto L49
        L47:
            android.graphics.Typeface r4 = android.graphics.Typeface.DEFAULT
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.b.bi(java.lang.String):android.graphics.Typeface");
    }

    private static int bj(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }

    private static int s(String str, String str2) {
        return ((!TextUtils.isEmpty(str) ? bj(str) : -1) >= 500 || "bold".equals(str)) ? "italic".equals(str2) ? 3 : 1 : "italic".equals(str2) ? 2 : 0;
    }

    public static void a(final TextView textView, String str, final String str2, String str3, String str4, com.kwad.yoga.c cVar, String str5, int i, int i2, final a aVar) {
        final int iS;
        if (cVar != null) {
            cVar.dirty();
        }
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            iS = s(str2, str3);
        } else {
            iS = textView.getTypeface() != null ? textView.getTypeface().getStyle() : 0;
        }
        if (TextUtils.isEmpty(str)) {
            aVar.a(null, iS, i2);
            if (iS != 0 || TextUtils.isEmpty(str2)) {
                return;
            }
            if ("medium".equals(str2)) {
                textView.getPaint().setFakeBoldText(true);
                return;
            } else {
                if (textView.getPaint().isFakeBoldText()) {
                    textView.getPaint().setFakeBoldText(false);
                    return;
                }
                return;
            }
        }
        if (pJ()) {
            textView.setTypeface(a(textView.getContext(), str, iS, str4, str5, i), iS);
            if (iS != 0 || TextUtils.isEmpty(str2)) {
                return;
            }
            if ("medium".equals(str2)) {
                textView.getPaint().setFakeBoldText(true);
                return;
            } else {
                if (textView.getPaint().isFakeBoldText()) {
                    textView.getPaint().setFakeBoldText(false);
                    return;
                }
                return;
            }
        }
        a(textView.getContext(), str, iS, str4, str5, i, i2, new e.a() { // from class: com.tk.core.component.b.2
            @Override // com.tk.core.component.text.e.a
            public final void a(Typeface typeface, boolean z, int i3) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(typeface, iS, i3);
                }
                if (iS != 0 || TextUtils.isEmpty(str2)) {
                    return;
                }
                if ("medium".equals(str2)) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (textView.getPaint().isFakeBoldText()) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
        });
    }

    public static boolean pJ() {
        if (ZQ == null) {
            if (com.tk.core.a.oP().getTKSwitch() != null) {
                ZQ = Boolean.valueOf(com.tk.core.a.oP().getTKSwitch().oY());
            } else {
                ZQ = Boolean.FALSE;
            }
        }
        return ZQ.booleanValue();
    }
}
