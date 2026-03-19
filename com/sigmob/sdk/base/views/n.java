package com.sigmob.sdk.base.views;

import com.czhj.sdk.common.utils.Preconditions;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n implements Serializable {
    private static final List<String> a = Arrays.asList("image/jpeg", PictureMimeType.PNG_Q, "image/bmp", "image/gif");
    private static final List<String> b = Arrays.asList("application/x-javascript");
    private static final long serialVersionUID = 0;
    private final String c;
    private final b d;
    private final a e;
    private final int f;
    private final int g;

    /* renamed from: com.sigmob.sdk.base.views.n$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.IFRAME_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.STATIC_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.NATIVE_RESOURCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.URL_RESOURCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum a {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    public enum b {
        STATIC_RESOURCE,
        HTML_RESOURCE,
        IFRAME_RESOURCE,
        NATIVE_RESOURCE,
        URL_RESOURCE
    }

    public n(final String resource, final b type, final a creativeType, final int width, final int height) {
        Preconditions.NoThrow.checkNotNull(resource);
        Preconditions.NoThrow.checkNotNull(type);
        Preconditions.NoThrow.checkNotNull(creativeType);
        this.c = resource;
        this.d = type;
        this.e = creativeType;
        this.f = width;
        this.g = height;
    }

    public String a() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(final java.lang.String r6, final java.lang.String r7) {
        /*
            r5 = this;
            int[] r0 = com.sigmob.sdk.base.views.n.AnonymousClass1.a
            com.sigmob.sdk.base.views.n$b r1 = r5.d
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            java.lang.String r2 = "CreativeType.JAVASCRIPT"
            java.lang.String r3 = "CreativeType.IMAGE"
            r4 = 0
            if (r0 == r1) goto L3b
            r1 = 2
            if (r0 == r1) goto L3b
            r1 = 3
            if (r0 == r1) goto L1f
            r1 = 4
            if (r0 == r1) goto L3b
            r1 = 5
            if (r0 == r1) goto L3b
            goto L56
        L1f:
            com.sigmob.sdk.base.views.n$a r0 = com.sigmob.sdk.base.views.n.a.IMAGE
            com.sigmob.sdk.base.views.n$a r1 = r5.e
            if (r0 != r1) goto L30
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L2f
            return r7
        L2f:
            return r6
        L30:
            com.sigmob.sdk.base.views.n$a r6 = com.sigmob.sdk.base.views.n.a.JAVASCRIPT
            com.sigmob.sdk.base.views.n$a r0 = r5.e
            if (r6 != r0) goto L3a
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L3a:
            return r4
        L3b:
            com.sigmob.sdk.base.views.n$a r0 = com.sigmob.sdk.base.views.n.a.IMAGE
            com.sigmob.sdk.base.views.n$a r1 = r5.e
            if (r0 != r1) goto L4c
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L4b
            return r6
        L4b:
            return r4
        L4c:
            com.sigmob.sdk.base.views.n$a r6 = com.sigmob.sdk.base.views.n.a.JAVASCRIPT
            com.sigmob.sdk.base.views.n$a r0 = r5.e
            if (r6 != r0) goto L56
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L56:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.n.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public void a(o webView) {
        StringBuilder sbAppend;
        String str;
        String string;
        String str2;
        Preconditions.NoThrow.checkNotNull(webView);
        int i = AnonymousClass1.a[this.d.ordinal()];
        if (i == 1) {
            sbAppend = new StringBuilder().append("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"").append(this.f).append("\" height=\"").append(this.g).append("\" src=\"").append(this.c);
            str = "\"></iframe>";
        } else {
            if (i == 2) {
                string = this.c;
                webView.a(string);
            }
            if (i != 3) {
                if (i == 4) {
                    if (!this.c.toLowerCase().startsWith(UriUtils.FILE_PREFIX)) {
                        str2 = UriUtils.FILE_PREFIX + this.c;
                    }
                    webView.loadUrl(str2);
                    return;
                } else if (i != 5) {
                    return;
                }
                str2 = this.c;
                webView.loadUrl(str2);
                return;
            }
            if (this.e == a.IMAGE) {
                sbAppend = new StringBuilder().append("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"").append(this.c);
                str = "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            } else {
                if (this.e != a.JAVASCRIPT) {
                    return;
                }
                sbAppend = new StringBuilder().append("<script src=\"").append(this.c);
                str = "\"></script>";
            }
        }
        string = sbAppend.append(str).toString();
        webView.a(string);
    }

    public b b() {
        return this.d;
    }

    public a c() {
        return this.e;
    }
}
