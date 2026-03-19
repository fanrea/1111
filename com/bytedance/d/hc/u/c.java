package com.bytedance.d.hc.u;

import android.os.Build;
import com.bytedance.sdk.component.utils.mq;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static List<String> d(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i), d(i2)};
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            new d(processExec.getInputStream(), copyOnWriteArrayList).start();
            new d(processExec.getErrorStream(), copyOnWriteArrayList).start();
            new hc(processExec, com.alipay.sdk.m.u.b.a).start();
            if (Build.VERSION.SDK_INT >= 26) {
                processExec.waitFor(com.alipay.sdk.m.u.b.a, TimeUnit.MILLISECONDS);
            } else {
                processExec.waitFor();
            }
        } catch (Throwable th) {
            try {
                mq.d(th);
            } finally {
                if (0 != 0) {
                    processExec.destroy();
                }
            }
        }
        if (processExec != null) {
        }
        return copyOnWriteArrayList;
    }

    private static class d extends com.bytedance.sdk.component.tc.c.b {
        private InputStream d;
        private List<String> hc;

        d(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.d = inputStream;
            this.hc = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.d));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("---------")) {
                            length -= line.getBytes("UTF-8").length;
                            if (length < 0) {
                                break;
                            } else {
                                this.hc.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    return;
                } finally {
                    com.bytedance.d.hc.gb.an.d(bufferedReader);
                }
            }
        }
    }

    private static class hc extends com.bytedance.sdk.component.tc.c.b {
        private Process d;
        private long hc;

        public hc(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.d = process;
            this.hc = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.hc);
            } catch (InterruptedException e) {
                mq.d(e);
            }
            Process process = this.d;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String d(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
