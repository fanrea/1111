package android.support.v4.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static abstract class a {
        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.content.a.d.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a(typeface);
                }
            });
        }

        public final void a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.content.a.d.a.2
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceA = a(context, resources, typedValue, i, i2, aVar, null, true);
        if (typefaceA != null || aVar != null) {
            return typefaceA;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, android.support.v4.content.a.d.a r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto La3
            java.lang.CharSequence r1 = r1.string
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L28
            if (r9 == 0) goto L27
            r9.a(r14, r10)
        L27:
            return r13
        L28:
            android.graphics.Typeface r1 = android.support.v4.graphics.b.a(r0, r4, r5)
            if (r1 == 0) goto L34
            if (r9 == 0) goto L33
            r9.a(r1, r10)
        L33:
            return r1
        L34:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            if (r1 == 0) goto L67
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            android.support.v4.content.a.b$a r2 = android.support.v4.content.a.b.a(r1, r0)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            if (r2 != 0) goto L55
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            if (r9 == 0) goto L54
            r9.a(r14, r10)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
        L54:
            return r13
        L55:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = android.support.v4.graphics.b.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            return r0
        L67:
            r1 = r15
            android.graphics.Typeface r0 = android.support.v4.graphics.b.a(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            if (r9 == 0) goto L77
            if (r0 == 0) goto L74
            r9.a(r0, r10)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
            goto L77
        L74:
            r9.a(r14, r10)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8b
        L77:
            return r0
        L78:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to read xml resource "
            r1.<init>(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            goto L9d
        L8b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to parse xml resource "
            r1.<init>(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
        L9d:
            if (r9 == 0) goto La2
            r9.a(r14, r10)
        La2:
            return r13
        La3:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Resource \""
            r3.<init>(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.a.d.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.support.v4.content.a.d$a, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
