package com.component.a.f;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {

    /* renamed from: com.component.a.f.a$a, reason: collision with other inner class name */
    public enum EnumC0315a {
        LP("lp"),
        DL("dl"),
        APO("apo");

        private final String d;

        EnumC0315a(String str) {
            this.d = str;
        }

        public String b() {
            return this.d;
        }

        public static boolean b(String str) {
            for (EnumC0315a enumC0315a : values()) {
                if (TextUtils.equals(str, enumC0315a.d)) {
                    return true;
                }
            }
            return false;
        }
    }

    public enum c {
        IMAGE("image"),
        VIDEO("video");

        private final String c;

        c(String str) {
            this.c = str;
        }

        public String b() {
            return this.c;
        }

        public static boolean b(String str) {
            for (c cVar : values()) {
                if (TextUtils.equals(str, cVar.c)) {
                    return true;
                }
            }
            return false;
        }
    }

    public enum b {
        SHARE("share");

        private final String b;

        b(String str) {
            this.b = str;
        }

        public String b() {
            return this.b;
        }

        public static boolean b(String str) {
            for (b bVar : values()) {
                if (TextUtils.equals(str, bVar.b)) {
                    return true;
                }
            }
            return false;
        }
    }
}
