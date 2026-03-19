package com.qq.e.comm.plugin;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vv {
    private static final String a = "vv";
    private static final int b = r1.d().f().a("skccerpce", 50);
    private static final AtomicInteger c = new AtomicInteger();
    private static final ConcurrentLinkedQueue<uv> d = new ConcurrentLinkedQueue<>();
    private static final AtomicInteger e = new AtomicInteger();
    private static final Lock f = new ReentrantLock(true);
    private static final AtomicBoolean g = new AtomicBoolean(false);
    private static final AtomicBoolean h = new AtomicBoolean(false);
    private static final AtomicBoolean i = new AtomicBoolean(false);
    private static final long j = (r1.d().f().a("ptprp", 10) * 60) * 1000;
    private static long k = 0;

    private static String a(Map<String, String> map) {
        return (String) pro.getobjresult(TypedValues.PositionType.TYPE_PERCENT_Y, 1, map);
    }

    private static Map<String, String> a(String str) {
        return (Map) pro.getobjresult(TypedValues.PositionType.TYPE_CURVE_FIT, 1, str);
    }

    static /* synthetic */ void a() {
        pro.getVresult(509, 1, new Object[0]);
    }

    private static void a(int i2, aw awVar, int i3, int i4) {
        pro.getVresult(510, 1, Integer.valueOf(i2), awVar, Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static void a(h4 h4Var, aw awVar, int i2) {
        pro.getVresult(511, 1, h4Var, awVar, Integer.valueOf(i2));
    }

    private static boolean a(h4 h4Var) {
        return pro.getZresult(512, 1, h4Var);
    }

    static /* synthetic */ void b() {
        pro.getVresult(513, 1, new Object[0]);
    }

    public static void b(h4 h4Var, aw awVar, int i2) {
        pro.getVresult(514, 1, h4Var, awVar, Integer.valueOf(i2));
    }

    private static boolean b(h4 h4Var) {
        return pro.getZresult(515, 1, h4Var);
    }

    static /* synthetic */ String c() {
        return (String) pro.getobjresult(516, 1, new Object[0]);
    }

    static /* synthetic */ void d() {
        pro.getVresult(517, 1, new Object[0]);
    }

    private static void e() {
        pro.getVresult(518, 1, new Object[0]);
    }

    private static void f() {
        pro.getVresult(519, 1, new Object[0]);
    }

    private static void g() {
        pro.getVresult(520, 1, new Object[0]);
    }

    public static void h() {
        pro.getVresult(521, 1, new Object[0]);
    }

    public static void i() {
        pro.getVresult(522, 1, new Object[0]);
    }

    public static void j() {
        pro.getVresult(523, 1, new Object[0]);
    }

    private static void k() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_STREAM_DURATION, 1, new Object[0]);
    }

    /* compiled from: A */
    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            vv.a();
        }

        a() {
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            vv.b();
            vv.i();
        }

        b() {
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (!as.i()) {
                vv.c();
                return;
            }
            zr zrVarP = r1.d().c().p();
            vv.c();
            zrVarP.c();
            if (zrVarP == zr.WIFI || zrVarP == zr.NET_4G) {
                vv.d();
            }
        }

        c() {
        }
    }
}
