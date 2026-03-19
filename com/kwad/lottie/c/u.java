package com.kwad.lottie.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class u {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.kwad.lottie.model.content.Mask r(android.util.JsonReader r9, com.kwad.lottie.d r10) throws java.io.IOException {
        /*
            r9.beginObject()
            r0 = 0
            r1 = r0
            r2 = r1
        L6:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto Lb3
            java.lang.String r3 = r9.nextName()
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = -1
            switch(r4) {
                case 111: goto L36;
                case 3588: goto L2b;
                case 3357091: goto L20;
                default: goto L1e;
            }
        L1e:
            r4 = r8
            goto L40
        L20:
            java.lang.String r4 = "mode"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L29
            goto L1e
        L29:
            r4 = r5
            goto L40
        L2b:
            java.lang.String r4 = "pt"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L34
            goto L1e
        L34:
            r4 = r6
            goto L40
        L36:
            java.lang.String r4 = "o"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L3f
            goto L1e
        L3f:
            r4 = r7
        L40:
            switch(r4) {
                case 0: goto Lad;
                case 1: goto La7;
                case 2: goto L47;
                default: goto L43;
            }
        L43:
            r9.skipValue()
            goto L6
        L47:
            java.lang.String r0 = r9.nextString()
            r0.hashCode()
            int r4 = r0.hashCode()
            switch(r4) {
                case 97: goto L6b;
                case 105: goto L60;
                case 115: goto L57;
                default: goto L55;
            }
        L55:
            r5 = r8
            goto L75
        L57:
            java.lang.String r4 = "s"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L75
            goto L55
        L60:
            java.lang.String r4 = "i"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L69
            goto L55
        L69:
            r5 = r6
            goto L75
        L6b:
            java.lang.String r4 = "a"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L74
            goto L55
        L74:
            r5 = r7
        L75:
            switch(r5) {
                case 0: goto La3;
                case 1: goto L9a;
                case 2: goto L96;
                default: goto L78;
            }
        L78:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown mask mode "
            r0.<init>(r4)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = ". Defaulting to Add."
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "LOTTIE"
            android.util.Log.w(r3, r0)
            com.kwad.lottie.model.content.Mask$MaskMode r0 = com.kwad.lottie.model.content.Mask.MaskMode.MaskModeAdd
            goto L6
        L96:
            com.kwad.lottie.model.content.Mask$MaskMode r0 = com.kwad.lottie.model.content.Mask.MaskMode.MaskModeSubtract
            goto L6
        L9a:
            java.lang.String r0 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r10.dh(r0)
            com.kwad.lottie.model.content.Mask$MaskMode r0 = com.kwad.lottie.model.content.Mask.MaskMode.MaskModeIntersect
            goto L6
        La3:
            com.kwad.lottie.model.content.Mask$MaskMode r0 = com.kwad.lottie.model.content.Mask.MaskMode.MaskModeAdd
            goto L6
        La7:
            com.kwad.lottie.model.a.h r1 = com.kwad.lottie.c.d.j(r9, r10)
            goto L6
        Lad:
            com.kwad.lottie.model.a.d r2 = com.kwad.lottie.c.d.g(r9, r10)
            goto L6
        Lb3:
            r9.endObject()
            com.kwad.lottie.model.content.Mask r9 = new com.kwad.lottie.model.content.Mask
            r9.<init>(r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.lottie.c.u.r(android.util.JsonReader, com.kwad.lottie.d):com.kwad.lottie.model.content.Mask");
    }
}
