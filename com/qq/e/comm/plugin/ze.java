package com.qq.e.comm.plugin;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ze {
    private static int c = 4;
    private ArrayList<HandlerThread> a;
    private AtomicInteger b;

    /* compiled from: A */
    static class b {
        static final ze a = new ze();
    }

    public static ze b() {
        return b.a;
    }

    private ze() {
        this.a = new ArrayList<>();
        this.b = new AtomicInteger(0);
    }

    public int a() {
        return this.b.getAndIncrement();
    }

    public Looper a(int i) {
        int i2 = i % c;
        if (i2 >= this.a.size()) {
            HandlerThread handlerThread = new HandlerThread("FrameDecoderExecutor-" + i2);
            handlerThread.start();
            this.a.add(handlerThread);
            Looper looper = handlerThread.getLooper();
            return looper != null ? looper : Looper.getMainLooper();
        }
        if (this.a.get(i2) != null) {
            Looper looper2 = this.a.get(i2).getLooper();
            return looper2 != null ? looper2 : Looper.getMainLooper();
        }
        return Looper.getMainLooper();
    }
}
