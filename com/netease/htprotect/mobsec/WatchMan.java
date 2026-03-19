package com.netease.htprotect.mobsec;

import android.os.Handler;
import android.os.Looper;
import com.netease.htprotect.HTProtect;
import com.netease.htprotect.callback.GetTokenCallback;
import com.netease.htprotect.factory.O8oO888;
import com.netease.htprotect.p001OO8.O8;
import com.netease.htprotect.result.AntiCheatResult;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WatchMan {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final Handler f52O8oO888 = new Handler(Looper.getMainLooper());

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final String f53O8 = "302";

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final String f54Ooo = "301";

    private class DynamicTask implements Callable {

        /* renamed from: 〇O8, reason: contains not printable characters */
        private final O8oO888 f63O8;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private final String f64Ooo;

        public DynamicTask(O8oO888 o8oO888, String str) {
            this.f64Ooo = str;
            this.f63O8 = o8oO888;
        }

        @Override // java.util.concurrent.Callable
        public AntiCheatResult call() throws Exception {
            try {
                return WatchMan.m533O8oO888(this.f63O8, this.f64Ooo);
            } catch (Exception unused) {
                return new AntiCheatResult(HTProtect.ioctl(8, WatchMan.f54Ooo), 200, "success", this.f64Ooo);
            }
        }
    }

    private static final class Pool1Holder {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        static final O8 f65O8oO888 = new O8();

        private Pool1Holder() {
        }
    }

    private static final class Pool2Holder {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        static final O8 f66O8oO888 = new O8();

        private Pool2Holder() {
        }
    }

    private static class Singleton {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        static final WatchMan f67O8oO888 = new WatchMan(0);

        private Singleton() {
        }
    }

    private WatchMan() {
    }

    /* synthetic */ WatchMan(byte b) {
        this();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    static /* synthetic */ AntiCheatResult m533O8oO888(O8oO888 o8oO888, String str) {
        byte[] bArrM527O8oO888 = o8oO888.m527O8oO888(str);
        int code = AntiCheatResult.getCode(com.netease.htprotect.p001OO8.O8oO888.m487O8oO888(bArrM527O8oO888));
        return code == 200 ? new AntiCheatResult(new String(bArrM527O8oO888, 4, bArrM527O8oO888.length - 4), 200, "success", str) : new AntiCheatResult("", code, AntiCheatResult.getCodeStr(code), "");
    }

    public static WatchMan getInstance() {
        return Singleton.f67O8oO888;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static AntiCheatResult m534Ooo(O8oO888 o8oO888, String str) {
        byte[] bArrM527O8oO888 = o8oO888.m527O8oO888(str);
        int code = AntiCheatResult.getCode(com.netease.htprotect.p001OO8.O8oO888.m487O8oO888(bArrM527O8oO888));
        return code == 200 ? new AntiCheatResult(new String(bArrM527O8oO888, 4, bArrM527O8oO888.length - 4), 200, "success", str) : new AntiCheatResult("", code, AntiCheatResult.getCodeStr(code), "");
    }

    public AntiCheatResult getToken(O8oO888 o8oO888, int i, String str) {
        if (str == null) {
            return new AntiCheatResult("", 203, AntiCheatResult.ERROR_BUSINESSID_INVALID_STR, "");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return new AntiCheatResult("", 202, AntiCheatResult.ERROR_ON_MAIN_STR, "");
        }
        if (i < 100 || i > 10000) {
            i = 3000;
        }
        FutureTask futureTask = new FutureTask(new DynamicTask(o8oO888, str));
        new Thread(futureTask).start();
        try {
            return (AntiCheatResult) futureTask.get(i, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            return new AntiCheatResult(HTProtect.ioctl(8, "302|".concat(String.valueOf(i))), 200, "success", str);
        } catch (Exception unused2) {
            return new AntiCheatResult(HTProtect.ioctl(8, f54Ooo), 200, "success", str);
        }
    }

    public void getTokenAsync(O8oO888 o8oO888, int i, final String str, final GetTokenCallback getTokenCallback) {
        if (getTokenCallback == null) {
            throw new IllegalArgumentException();
        }
        if (str == null) {
            getTokenCallback.onResult(new AntiCheatResult("", 203, AntiCheatResult.ERROR_BUSINESSID_INVALID_STR, ""));
            return;
        }
        if (i < 100 || i > 10000) {
            i = 3000;
        }
        final int i2 = i;
        final FutureTask futureTask = new FutureTask(new DynamicTask(o8oO888, str));
        Pool1Holder.f65O8oO888.m488O8oO888(futureTask);
        Pool2Holder.f66O8oO888.m488O8oO888(new Runnable() { // from class: com.netease.htprotect.mobsec.WatchMan.1
            @Override // java.lang.Runnable
            public void run() {
                final AntiCheatResult antiCheatResult;
                try {
                    antiCheatResult = (AntiCheatResult) futureTask.get(i2, TimeUnit.MILLISECONDS);
                } catch (TimeoutException unused) {
                    antiCheatResult = new AntiCheatResult(HTProtect.ioctl(8, "302|" + i2), 200, "success", str);
                } catch (Exception unused2) {
                    antiCheatResult = new AntiCheatResult(HTProtect.ioctl(8, WatchMan.f54Ooo), 200, "success", str);
                }
                WatchMan.f52O8oO888.post(new Runnable() { // from class: com.netease.htprotect.mobsec.WatchMan.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        getTokenCallback.onResult(antiCheatResult);
                    }
                });
            }
        });
    }
}
