package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class z {
    private static final String a = "CKUtils";
    private static long b = 0;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static long e = 0;

    public static class a {
        public long a;
        public float b;
        public float c;
        public long d;
        public float e;
        public float f;
        public long g;
        public int h;
        public int i;
        public int j;
        public int k;
        public b l;
    }

    public enum b {
        TOUCH(1),
        SHAKE(2),
        SLIDE(3),
        AUTO(4);

        int e;

        b(int i) {
            this.e = i;
        }

        public int b() {
            return this.e;
        }
    }

    public static void a() {
        if (b == 0) {
            b = System.currentTimeMillis();
        }
    }

    public static String a(MotionEvent motionEvent, com.baidu.mobads.container.adrequest.t tVar, View view, b bVar) {
        if (motionEvent == null || view == null || tVar == null) {
            return "";
        }
        try {
            if (motionEvent.getAction() == 0) {
                e = System.currentTimeMillis();
                c = motionEvent.getRawX();
                d = motionEvent.getRawY();
                return "";
            }
            if (motionEvent.getAction() != 1) {
                return "";
            }
            if (bVar == b.SHAKE || bVar == b.AUTO) {
                c = 0.0f;
                d = 0.0f;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            a aVar = new a();
            aVar.a = e;
            aVar.b = c;
            aVar.c = d;
            aVar.d = System.currentTimeMillis();
            aVar.e = motionEvent.getRawX();
            aVar.f = motionEvent.getRawY();
            aVar.h = view.getWidth();
            aVar.i = view.getHeight();
            aVar.j = i;
            aVar.k = i2;
            aVar.l = bVar;
            aVar.g = b;
            return a(aVar, tVar);
        } catch (Throwable th) {
            bq.a().a(a, th.getMessage());
            return "";
        }
    }

    private static long a(int i, int i2, long j, String str, int i3) {
        long jCharAt = 0;
        for (long j2 = 0; j2 < ((i * ((j % 100) + 30)) % 99) + 9; j2++) {
            jCharAt += str.charAt((int) ((i2 * j2) % i3));
        }
        return jCharAt;
    }

    public static String a(a aVar, com.baidu.mobads.container.adrequest.t tVar) {
        String str;
        String str2;
        int i;
        String str3;
        if (tVar == null) {
            return "";
        }
        try {
            e = aVar.a;
            c = aVar.b;
            d = aVar.c;
            b = aVar.g;
            if (aVar.l == b.SHAKE || aVar.l == b.AUTO) {
                c = 0.0f;
                d = 0.0f;
            }
            String clickThroughUrl = tVar.q().getClickThroughUrl();
            if (!clickThroughUrl.contains("//m.baidu.com/") || !clickThroughUrl.contains("&ck=__CPC_ANTI_CK__")) {
                Iterator<String> it = tVar.q().getThirdClickTrackingUrls().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        clickThroughUrl = "";
                        break;
                    }
                    String next = it.next();
                    if (next.contains("//m.baidu.com/") && next.contains("&ck=__CPC_ANTI_CK__")) {
                        clickThroughUrl = next;
                        break;
                    }
                }
                if (TextUtils.isEmpty(clickThroughUrl)) {
                    return "";
                }
            }
            String[] strArrSplit = clickThroughUrl.split("url=");
            if (strArrSplit.length >= 2 && !TextUtils.isEmpty(strArrSplit[1])) {
                String str4 = strArrSplit[1];
                String[] strArrSplit2 = str4.split(com.alipay.sdk.m.s.a.n);
                if (strArrSplit2.length >= 2 && !TextUtils.isEmpty(strArrSplit2[0])) {
                    str4 = strArrSplit2[0];
                }
                String[] strArrSplit3 = str4.split("\\.");
                if (strArrSplit3.length >= 2 && !TextUtils.isEmpty(strArrSplit3[0])) {
                    str2 = strArrSplit3[0];
                } else {
                    str2 = str4;
                }
            } else {
                str2 = "";
            }
            if (aVar.l == b.SHAKE || aVar.l == b.AUTO) {
                c = 0.0f;
                d = 0.0f;
                aVar.e = 0.0f;
                aVar.f = 0.0f;
            }
            String strValueOf = String.valueOf(System.currentTimeMillis() - e);
            if (strValueOf.length() > 4) {
                strValueOf = strValueOf.substring(strValueOf.length() - 4);
            }
            String str5 = (aVar.l == b.SHAKE || aVar.l == b.AUTO) ? "0" : strValueOf;
            try {
                int i2 = Integer.parseInt(str5);
                i = i2 > 0 ? i2 : 0;
            } catch (NumberFormatException e2) {
                i = 0;
            }
            String strValueOf2 = String.valueOf(a(i, (int) c, tVar.q().getDTime(), str2, str2.length()));
            String strValueOf3 = String.valueOf((int) c);
            String strValueOf4 = String.valueOf((int) d);
            String strValueOf5 = String.valueOf(aVar.h);
            String strValueOf6 = String.valueOf(aVar.i);
            if (aVar.d <= 0) {
                aVar.d = System.currentTimeMillis();
            }
            String strValueOf7 = String.valueOf(aVar.d - b);
            if (aVar.d - b <= 0 || b <= 0) {
                strValueOf7 = "0";
            }
            String strValueOf8 = String.valueOf((int) aVar.e);
            String strValueOf9 = String.valueOf((int) aVar.f);
            Context contextT = tVar.t();
            if (contextT.getResources().getConfiguration().orientation != 2) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            String strValueOf10 = String.valueOf(aVar.j);
            String strValueOf11 = String.valueOf(aVar.k);
            str = "";
            try {
                String strValueOf12 = String.valueOf(bv.b(contextT));
                String strValueOf13 = String.valueOf(bv.c(contextT));
                String strValueOf14 = String.valueOf((int) bv.e(contextT));
                String strValueOf15 = String.valueOf(aVar.l.e);
                StringBuilder sb = new StringBuilder();
                sb.append(strValueOf2).append(".").append(str5).append(".").append(strValueOf3).append(".").append(strValueOf4).append(".").append(strValueOf5).append(".").append(strValueOf6).append(".").append("0").append(".").append("0").append(".").append(strValueOf7).append(".").append(strValueOf8).append(".").append(strValueOf9).append(".").append(str3).append(".").append(strValueOf10).append(".").append(strValueOf11).append(".").append(strValueOf12).append(".").append(strValueOf13).append(".").append(strValueOf14).append(".").append(strValueOf15).append(".").append("0");
                return sb.toString();
            } catch (Throwable th) {
                th = th;
                bq.a().a(a, th.getMessage());
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
    }
}
