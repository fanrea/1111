package com.qq.e.comm.plugin;

import android.content.Context;
import android.net.NetworkCapabilities;
import android.telephony.CellSignalStrength;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class zy {
    private TelephonyManager a;
    private PhoneStateListener b;
    private volatile int c;
    private boolean d;
    private volatile int e;
    private final AtomicBoolean f = new AtomicBoolean(false);

    zy() {
    }

    void c() {
        if (this.d) {
            return;
        }
        try {
            Context contextA = r1.d().a();
            if (this.a == null) {
                this.a = (TelephonyManager) contextA.getSystemService("phone");
            }
            if (this.a == null) {
                return;
            }
            if (this.b == null) {
                this.b = new a(qg.c);
            }
            this.a.listen(this.b, 256);
            this.d = true;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* compiled from: A */
    class a extends PhoneStateListener {
        a(Executor executor) {
            super(executor);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            List<CellSignalStrength> cellSignalStrengths;
            int size;
            if (signalStrength == null || (cellSignalStrengths = signalStrength.getCellSignalStrengths()) == null || (size = cellSignalStrengths.size()) == 0) {
                return;
            }
            StringBuilder sb = null;
            for (int i = 0; i < size; i++) {
                CellSignalStrength cellSignalStrength = cellSignalStrengths.get(i);
                if (cellSignalStrength != null) {
                    zy.this.c = cellSignalStrength.getDbm();
                    int i2 = as.p;
                    int unused = zy.this.c;
                    if (size > 1 && zy.this.f.compareAndSet(false, true)) {
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append(cellSignalStrength.getClass().getName());
                        sb.append(":");
                        sb.append(zy.this.c);
                        sb.append(",");
                    }
                }
            }
            if (sb != null) {
                b10.a(9720004, null, Integer.valueOf(size), new ja().a("msg", sb.toString()));
            }
        }
    }

    void d() {
        if (this.d) {
            try {
                this.a.listen(this.b, 0);
                this.d = false;
                this.c = 0;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    int b() {
        return this.e;
    }

    int a() {
        return this.c;
    }

    void a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            this.e = networkCapabilities.getSignalStrength();
            int i = as.p;
        }
    }
}
