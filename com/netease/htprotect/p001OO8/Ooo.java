package com.netease.htprotect.p001OO8;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.netease.htprotect.OO〇8.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static volatile boolean f38O8oO888 = false;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static volatile int f39Ooo;

    /* renamed from: com.netease.htprotect.OO〇8.〇Ooo$O8〇oO8〇88, reason: invalid class name */
    private static class O8oO888 implements DisplayManager.DisplayListener {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private final DisplayManager f40O8oO888;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private final Set f41Ooo = new HashSet();

        public O8oO888(DisplayManager displayManager) {
            this.f40O8oO888 = displayManager;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private void m492O8oO888() {
            int unused = Ooo.f39Ooo = 0;
            HashSet hashSet = new HashSet(this.f41Ooo);
            if (hashSet.size() <= 0) {
                return;
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (num.intValue() != 0) {
                    try {
                        if (this.f40O8oO888.getDisplay(num.intValue()) == null) {
                            int unused2 = Ooo.f39Ooo = num.intValue();
                        }
                    } catch (Exception unused3) {
                    }
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i) {
            synchronized (this) {
                try {
                    this.f41Ooo.add(Integer.valueOf(i));
                    m492O8oO888();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i) {
            synchronized (this) {
                try {
                    this.f41Ooo.add(Integer.valueOf(i));
                    m492O8oO888();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i) {
            synchronized (this) {
                try {
                    this.f41Ooo.remove(Integer.valueOf(i));
                    m492O8oO888();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static synchronized int m489O8oO888() {
        return f39Ooo;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static synchronized void m491O8oO888(Context context) {
        if (context == null) {
            return;
        }
        if (f38O8oO888) {
            return;
        }
        try {
            DisplayManager displayManager = (DisplayManager) context.getApplicationContext().getSystemService("display");
            if (displayManager == null) {
                return;
            }
            HandlerThread handlerThread = new HandlerThread("ht-display");
            handlerThread.start();
            displayManager.registerDisplayListener(new O8oO888(displayManager), new Handler(handlerThread.getLooper()));
            f38O8oO888 = true;
        } catch (Exception unused) {
        }
    }
}
