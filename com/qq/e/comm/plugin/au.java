package com.qq.e.comm.plugin;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class au {
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    private String a() {
        return (String) pro.getobjresult(312, 0, this);
    }

    static /* synthetic */ boolean a(au auVar) throws vu {
        return pro.getZresult(313, 1, auVar);
    }

    private boolean b() throws vu {
        return pro.getZresult(314, 0, this);
    }

    void a(Socket socket) throws IOException {
        pro.getVresult(315, 0, this, socket);
    }

    boolean a(int i, int i2) {
        return pro.getZresult(316, 0, this, Integer.valueOf(i), Integer.valueOf(i2));
    }

    boolean a(String str) {
        return pro.getZresult(317, 0, this, str);
    }

    au(String str, int i) {
        this.b = str;
        this.c = i;
    }

    /* compiled from: A */
    private class b implements Callable<Boolean> {
        private b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(au.a(au.this));
        }
    }
}
