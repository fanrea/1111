package com.qq.e.comm.plugin;

import java.io.File;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class q30 implements Runnable {
    private final String[] a;
    private int b;
    private int c;

    public q30() {
        String[] list = g2.c().list();
        this.a = list;
        if (list != null) {
            Arrays.sort(list);
            this.b = list.length - 1;
        } else {
            this.b = -1;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.b;
        if (i < 0 || this.c >= 3) {
            return;
        }
        String str = this.a[i];
        File file = new File(g2.c(), str);
        if (file.exists()) {
            m7 m7Var = new m7(str, file);
            if (m7Var.a() && !new p30().a(m7Var)) {
                int i2 = this.c + 1;
                this.c = i2;
                if (i2 >= 3) {
                    return;
                }
            }
        }
        int i3 = this.b - 1;
        this.b = i3;
        if (i3 >= 0) {
            h2.a().postDelayed(this, 2000L);
        }
    }
}
