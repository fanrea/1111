package com.component.a.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private String a = "";

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L41
            if (r3 != 0) goto L3f
            java.lang.String r3 = "opt_style"
            boolean r3 = r7.contains(r3)     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L3f
            java.lang.String r3 = "_(\\d+)_?(\\d+)?$"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch: java.lang.Throwable -> L41
            java.util.regex.Matcher r7 = r3.matcher(r7)     // Catch: java.lang.Throwable -> L41
            boolean r3 = r7.find()     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L3f
            java.lang.String r3 = r7.group(r1)     // Catch: java.lang.Throwable -> L41
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = r7.group(r0)     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L3a
            java.lang.String r7 = r7.group(r0)     // Catch: java.lang.Throwable -> L3d
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L3d
            r2 = r7
        L3a:
            r7 = r2
            r2 = r3
            goto L40
        L3d:
            r7 = move-exception
            goto L43
        L3f:
            r7 = 0
        L40:
            goto L50
        L41:
            r7 = move-exception
            r3 = 0
        L43:
            com.baidu.mobads.container.util.bq r4 = com.baidu.mobads.container.util.bq.a()
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r2] = r7
            r4.d(r5)
            r2 = r3
            r7 = 0
        L50:
            r3 = 3
            switch(r2) {
                case 28: goto Lc0;
                case 29: goto Lb2;
                case 30: goto Lab;
                case 31: goto L54;
                case 32: goto L54;
                case 33: goto L87;
                case 34: goto L80;
                case 35: goto L79;
                case 36: goto L72;
                case 37: goto L6b;
                case 38: goto L54;
                case 39: goto L54;
                case 40: goto L54;
                case 41: goto L56;
                default: goto L54;
            }
        L54:
            goto Ldc
        L56:
            if (r7 != 0) goto L5d
            java.lang.String r7 = r6.q()
            return r7
        L5d:
            if (r7 != r1) goto L64
            java.lang.String r7 = r6.r()
            return r7
        L64:
            if (r7 != r0) goto Ldc
            java.lang.String r7 = r6.s()
            return r7
        L6b:
            if (r7 != 0) goto Ldc
            java.lang.String r7 = r6.p()
            return r7
        L72:
            if (r7 != 0) goto Ldc
            java.lang.String r7 = r6.o()
            return r7
        L79:
            if (r7 != 0) goto Ldc
            java.lang.String r7 = r6.n()
            return r7
        L80:
            if (r7 != 0) goto Ldc
            java.lang.String r7 = r6.m()
            return r7
        L87:
            if (r7 != 0) goto L8e
            java.lang.String r7 = r6.h()
            return r7
        L8e:
            if (r7 != r1) goto L95
            java.lang.String r7 = r6.i()
            return r7
        L95:
            if (r7 != r0) goto L9c
            java.lang.String r7 = r6.j()
            return r7
        L9c:
            if (r7 != r3) goto La3
            java.lang.String r7 = r6.k()
            return r7
        La3:
            r0 = 4
            if (r7 != r0) goto Ldc
            java.lang.String r7 = r6.l()
            return r7
        Lab:
            if (r7 != 0) goto Ldc
            java.lang.String r7 = r6.g()
            return r7
        Lb2:
            if (r7 != 0) goto Lb9
            java.lang.String r7 = r6.e()
            return r7
        Lb9:
            if (r7 != r1) goto Ldc
            java.lang.String r7 = r6.f()
            return r7
        Lc0:
            if (r7 != 0) goto Lc7
            java.lang.String r7 = r6.a()
            return r7
        Lc7:
            if (r7 != r1) goto Lce
            java.lang.String r7 = r6.b()
            return r7
        Lce:
            if (r7 != r0) goto Ld5
            java.lang.String r7 = r6.c()
            return r7
        Ld5:
            if (r7 != r3) goto Ldc
            java.lang.String r7 = r6.d()
            return r7
        Ldc:
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.e.c.a(java.lang.String):java.lang.String");
    }

    private String a() {
        return "[{\"id\":\"opt_style_28\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"28_tit2line#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String b() {
        return "[{\"id\":\"opt_style_28_1\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"28_1_tit2line#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String c() {
        return "[{\"id\":\"opt_style_28_2\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"28_2_tit2line#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}},{\"id\":\"28_2_brand_name#3\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}},{\"id\":\"28_2_opt_desc#3\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String d() {
        return "[{\"id\":\"opt_style_28_3\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"28_3_brand_name#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String e() {
        return "[{\"id\":\"opt_style_29\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"29_tit2line#1\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String f() {
        return "[{\"id\":\"opt_style_29_1\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"29_1_tit2line#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String g() {
        return "[{\"id\":\"opt_style_30\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"30_tit2line#1\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}},{\"id\":\"30_brand_name#1\",\"text\":{\"color\":\"#A4A4A4\",\"alpha\":\"1\"}}]";
    }

    private String h() {
        return "[{\"id\":\"opt_style_33\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"33_tit2line#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String i() {
        return "[{\"id\":\"opt_style_33_1\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"33_1_brand_name#3\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}},{\"id\":\"33_1_desc#3\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String j() {
        return "[{\"id\":\"opt_style_33_2\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"33_2_appname#4\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}},{\"id\":\"33_2_content_desc#4\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String k() {
        return "[{\"id\":\"opt_style_33_3\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}}]";
    }

    private String l() {
        return "[{\"id\":\"opt_style_33_4\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}}]";
    }

    private String m() {
        return "[{\"id\":\"opt_style_34\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"34_tit2line#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String n() {
        return "[{\"id\":\"opt_style_35\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"35_tit2line#1\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String o() {
        return "[{\"id\":\"opt_style_36\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"36_tit2line#1\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}},{\"id\":\"36_brand_name#1\",\"text\":{\"color\":\"#A4A4A4\",\"alpha\":\"1\"}}]";
    }

    private String p() {
        return "[{\"id\":\"opt_style_37\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"37_tit2line#1\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}}]";
    }

    private String q() {
        return "[{\"id\":\"opt_style_41\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}}]";
    }

    private String r() {
        return "[{\"id\":\"opt_style_41_1\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}}]";
    }

    private String s() {
        return "[{\"id\":\"opt_style_41_2\",\"background\":{\"foreground_color\":\"#000000\",\"foreground_alpha\":0.5}},{\"id\":\"41_2_front_card#1\",\"background\":{\"color\":\"#FFFFFF\",\"alpha\":\"0.06\"}},{\"id\":\"41_2_front_brand#2\",\"text\":{\"color\":\"#D2D2D2\",\"alpha\":\"1\"}},{\"id\":\"41_2_front_desc#2\",\"text\":{\"color\":\"#A4A4A4\",\"alpha\":\"1\"}}]";
    }
}
