package com.kwad.library.solder.lib.ext;

import android.os.Build;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final String aIf;
    private final int biA;
    private final String biO;
    private final String biP;
    private final String biQ;
    private final String biR;
    private final String biS;
    private final String biT;
    private final boolean biU;
    private final boolean biV;
    private final boolean biW;
    private String biX;
    private byte[] biY;
    private boolean biZ;
    private int bja;
    private ExecutorService mExecutorService;

    /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4, executorService, i2);
    }

    private c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2) {
        this.biA = i;
        this.aIf = str2;
        this.biO = str3;
        this.biP = str4;
        this.biQ = str5;
        this.biR = str6;
        this.biS = str7;
        this.biT = str;
        this.biU = z;
        this.biV = z2;
        this.biX = str8;
        this.biY = bArr;
        this.biZ = z3;
        this.biW = z4;
        this.mExecutorService = executorService;
        this.bja = i2;
    }

    public final int getRetryCount() {
        return this.biA;
    }

    public final int PJ() {
        return this.bja;
    }

    public final String PK() {
        return this.aIf;
    }

    public final String PL() {
        return this.biO;
    }

    public final String PM() {
        return this.biP;
    }

    public final String PN() {
        return this.biQ;
    }

    public final String PO() {
        return this.biR;
    }

    public final String PP() {
        return this.biS;
    }

    public final boolean PQ() {
        return this.biV;
    }

    public final boolean PR() {
        return this.biW;
    }

    public final ExecutorService PS() {
        return this.mExecutorService;
    }

    public static class a {
        private static final String bjb;
        private String biT;
        private boolean biW;
        private String biX;
        private byte[] biY;
        private boolean biZ;
        private int bjc;
        private ExecutorService mExecutorService;
        private int biA = 3;
        private String aIf = "sodler";
        private String biO = "code-cache";
        private String biP = "lib";
        private String biQ = "temp";
        private String biS = bjb;
        private String biR = ".tmp";
        private boolean biV = false;
        private boolean biU = false;

        static {
            bjb = PT() ? "base-1_apk" : "base-1.apk";
        }

        private static boolean PT() {
            return Build.VERSION.SDK_INT == 30 || Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32;
        }

        public final a db(String str) {
            this.aIf = str;
            return this;
        }

        public final a dS(int i) {
            if (i > 0) {
                this.biA = i;
            }
            return this;
        }

        public final a cm(boolean z) {
            this.biZ = false;
            return this;
        }

        public final a cn(boolean z) {
            this.biW = z;
            return this;
        }

        public final a a(ExecutorService executorService) {
            this.mExecutorService = executorService;
            return this;
        }

        public final a dT(int i) {
            this.bjc = i;
            return this;
        }

        public final c PU() {
            return new c(this.biU, this.biV, this.biT, this.aIf, this.biO, this.biP, this.biQ, this.biR, this.biS, this.biA, this.biX, this.biY, this.biZ, this.biW, this.mExecutorService, this.bjc, (byte) 0);
        }
    }
}
