package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.Pair;
import com.ss.ttm.player.MediaPlayer;
import com.tencent.turingfd.sdk.ams.au.ITuringDID;
import com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider;
import com.tencent.turingfd.sdk.ams.au.ITuringPermissionRuntime;
import com.tencent.turingfd.sdk.ams.au.ITuringPrivacyPolicy;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c20 {
    private static volatile boolean d;
    private static volatile int e;
    private static volatile boolean h;
    private static volatile boolean i;
    private static volatile String a = e();
    private static volatile String b = d();
    private static volatile long c = 0;
    private static volatile int f = 1;
    private static volatile boolean g = false;

    static /* synthetic */ void a(Context context) {
        pro.getVresult(584, 1, context);
    }

    public static void a(jn jnVar, String str) {
        pro.getVresult(585, 1, jnVar, str);
    }

    private static void a(ITuringDID iTuringDID) {
        pro.getVresult(586, 1, iTuringDID);
    }

    private static void a(String str) {
        pro.getVresult(587, 1, str);
    }

    private static void a(String str, String str2) {
        pro.getVresult(588, 1, str, str2);
    }

    public static void a(JSONObject jSONObject, String str) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRANS_OPEN_START_TIME, 1, jSONObject, str);
    }

    public static void a(boolean z, JSONObject jSONObject, String str) {
        pro.getVresult(590, 1, Boolean.valueOf(z), jSONObject, str);
    }

    static /* synthetic */ boolean a() {
        return pro.getZresult(591, 1, new Object[0]);
    }

    static /* synthetic */ boolean a(boolean z) {
        return pro.getZresult(592, 1, Boolean.valueOf(z));
    }

    public static void b(Context context) {
        pro.getVresult(593, 1, context);
    }

    private static void b(String str) {
        pro.getVresult(594, 1, str);
    }

    static /* synthetic */ boolean b() {
        return pro.getZresult(595, 1, new Object[0]);
    }

    static /* synthetic */ void c() {
        pro.getVresult(596, 1, new Object[0]);
    }

    private static void c(Context context) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_R_LOW_LATENCY, 1, context);
    }

    private static String d() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIOPTS_MS_CORRECTION_EXTENSION, 1, new Object[0]);
    }

    private static String e() {
        return (String) pro.getobjresult(599, 1, new Object[0]);
    }

    public static Pair<String, String> f() {
        return (Pair) pro.getobjresult(600, 1, new Object[0]);
    }

    private static boolean g() {
        return pro.getZresult(601, 1, new Object[0]);
    }

    private static void h() {
        pro.getVresult(602, 1, new Object[0]);
    }

    private static void i() {
        pro.getVresult(603, 1, new Object[0]);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            c20.a(this.a);
            if (c20.a() || c20.b()) {
                c20.c();
            }
        }
    }

    /* compiled from: A */
    class d implements ITuringPrivacyPolicy {
        @Override // com.tencent.turingfd.sdk.ams.au.Centaurus
        public boolean a() {
            return true;
        }

        d() {
        }
    }

    /* compiled from: A */
    class c implements ITuringDeviceInfoProvider {
        final /* synthetic */ boolean a;
        final /* synthetic */ Context b;

        @Override // com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider
        public String c() {
            return null;
        }

        c(boolean z, Context context) {
            this.a = z;
            this.b = context;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider
        public String a() {
            if (this.a) {
                return ma.IMEI.c().a(this.b);
            }
            return null;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider
        public String b() {
            if (this.a) {
                return ma.ANDROIDID.c().a(this.b);
            }
            return null;
        }
    }

    /* compiled from: A */
    class b implements ITuringPermissionRuntime {
        @Override // com.tencent.turingfd.sdk.ams.au.CanisMajor
        public boolean a() {
            return r1.d().f().a("taes", 1) == 1 && !pa.b("caes");
        }

        b() {
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().getName();
            c20.a(true);
            c20.c();
            c20.a(false);
        }

        e() {
        }
    }
}
