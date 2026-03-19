package com.netease.mobsec.xt;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ClickHelper {
    public static final int STATUS_ERROR_HOOK_FAIL = 1006;
    public static final int STATUS_ERROR_LOAD_SO = 1004;
    public static final int STATUS_ERROR_NULL_CONTEXT = 1002;
    public static final int STATUS_ERROR_RELEASE_SO = 1003;
    public static final int STATUS_ERROR_SO_NOT_FOUND = 1005;
    public static final int STATUS_HOOK_SUCCESS = 0;
    public static final int STATUS_INIT_SUCCESS = 0;
    public static final int STATUS_NO_INIT = 1001;
    public static volatile String c;
    public volatile boolean a = false;
    public volatile boolean b = false;

    public static class a {
        public static final ClickHelper a = new ClickHelper();
    }

    public static String aea215(char[] cArr, String str) {
        int length = str.length();
        for (int i = 0; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 > 255) {
                cArr[i] = (char) ((c2 ^ (255 & str.charAt(i % length))) & 65535);
            } else {
                int i2 = ((((((((c2 << 7) | (c2 >> 1)) & 255) + i) & 255) ^ i) & 255) + 15) & 255;
                int i3 = (((((i2 << 7) & 255) ^ ((i2 >> 1) & 255)) & 255) - 241) & 255;
                cArr[i] = (char) ((((((i3 << 5) & 255) | ((i3 >> 3) & 255)) & 255) ^ str.charAt(i % length)) & 255 & 255);
            }
        }
        return new String(cArr);
    }

    public static ClickHelper get() {
        return a.a;
    }

    public final int a() {
        if (!this.a) {
            return 1001;
        }
        if (TextUtils.isEmpty(c) || !c.endsWith(aea215(new char[]{'O', '2', '#'}, "ͣ˷ʄ˝̿˥"))) {
            return 1005;
        }
        if (this.b) {
            return 0;
        }
        try {
            System.load(c);
            this.b = com.netease.mobsec.xt.a.esp();
            return this.b ? 0 : 1006;
        } catch (Exception unused) {
            return 1004;
        }
    }

    public String getClickInfos() {
        if (this.a && this.b) {
            return com.netease.mobsec.xt.a.efb();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int init(android.content.Context r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.mobsec.xt.ClickHelper.init(android.content.Context):int");
    }

    public void setClickState(boolean z) {
        setClickState(z, 400);
    }

    public void setClickState(boolean z, int i) {
        if (this.a && this.b) {
            com.netease.mobsec.xt.a.ess(z, i);
        }
    }

    public int startHook() {
        return a();
    }

    public int startHook(int i) {
        int iA = a();
        if (iA != 0) {
            return iA;
        }
        com.netease.mobsec.xt.a.ess(true, i);
        return iA;
    }
}
