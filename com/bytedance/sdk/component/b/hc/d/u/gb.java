package com.bytedance.sdk.component.b.hc.d.u;

import com.bytedance.sdk.component.b.d.jh;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.hc.d.u.c;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class gb implements Closeable {
    static final Logger d = Logger.getLogger(u.class.getName());
    private final com.bytedance.sdk.component.b.d.u b;
    private final d c;
    final c.d hc;
    private final boolean u;

    interface hc {
        void d(int i, int i2, List<b> list) throws IOException;

        void d(int i, long j);

        void d(int i, com.bytedance.sdk.component.b.hc.d.u.hc hcVar);

        void d(int i, com.bytedance.sdk.component.b.hc.d.u.hc hcVar, com.bytedance.sdk.component.b.d.an anVar);

        void d(boolean z, int i, int i2);

        void d(boolean z, int i, int i2, List<b> list);

        void d(boolean z, int i, com.bytedance.sdk.component.b.d.u uVar, int i2) throws IOException;

        void d(boolean z, k kVar);
    }

    gb(com.bytedance.sdk.component.b.d.u uVar, boolean z) {
        this.b = uVar;
        this.u = z;
        d dVar = new d(uVar);
        this.c = dVar;
        this.hc = new c.d(4096, dVar);
    }

    public void d(hc hcVar) throws IOException {
        if (this.u) {
            if (!d(true, hcVar)) {
                throw u.hc("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.component.b.d.an anVarB = this.b.b(u.d.h());
        Logger logger = d;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.component.b.hc.d.b.d("<< CONNECTION %s", anVarB.u()));
        }
        if (!u.d.equals(anVarB)) {
            throw u.hc("Expected a connection header but was %s", anVarB.d());
        }
    }

    public boolean d(boolean z, hc hcVar) throws IOException {
        try {
            this.b.d(9L);
            int iD = d(this.b);
            if (iD < 0 || iD > 16384) {
                throw u.hc("FRAME_SIZE_ERROR: %s", Integer.valueOf(iD));
            }
            byte bGb = (byte) (this.b.gb() & 255);
            if (z && bGb != 4) {
                throw u.hc("Expected a SETTINGS frame but was %s", Byte.valueOf(bGb));
            }
            byte bGb2 = (byte) (this.b.gb() & 255);
            int iTc = this.b.tc() & Integer.MAX_VALUE;
            Logger logger = d;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(u.d(true, iTc, iD, bGb, bGb2));
            }
            switch (bGb) {
                case 0:
                    hc(hcVar, iD, bGb2, iTc);
                    return true;
                case 1:
                    d(hcVar, iD, bGb2, iTc);
                    return true;
                case 2:
                    b(hcVar, iD, bGb2, iTc);
                    return true;
                case 3:
                    c(hcVar, iD, bGb2, iTc);
                    return true;
                case 4:
                    u(hcVar, iD, bGb2, iTc);
                    return true;
                case 5:
                    an(hcVar, iD, bGb2, iTc);
                    return true;
                case 6:
                    h(hcVar, iD, bGb2, iTc);
                    return true;
                case 7:
                    gb(hcVar, iD, bGb2, iTc);
                    return true;
                case 8:
                    tt(hcVar, iD, bGb2, iTc);
                    return true;
                default:
                    this.b.gb(iD);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void d(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw u.hc("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short sGb = (b & 8) != 0 ? (short) (this.b.gb() & 255) : (short) 0;
        if ((b & 32) != 0) {
            d(hcVar, i2);
            i -= 5;
        }
        hcVar.d(z, i2, -1, d(d(i, b, sGb), sGb, b, i2));
    }

    private List<b> d(int i, short s, byte b, int i2) throws IOException {
        d dVar = this.c;
        dVar.c = i;
        dVar.d = i;
        this.c.u = s;
        this.c.hc = b;
        this.c.b = i2;
        this.hc.d();
        return this.hc.hc();
    }

    private void hc(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw u.hc("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw u.hc("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sGb = (b & 8) != 0 ? (short) (this.b.gb() & 255) : (short) 0;
        hcVar.d(z, i2, this.b, d(i, b, sGb));
        this.b.gb(sGb);
    }

    private void b(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw u.hc("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw u.hc("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        d(hcVar, i2);
    }

    private void d(hc hcVar, int i) throws IOException {
        this.b.tc();
        this.b.gb();
    }

    private void c(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw u.hc("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw u.hc("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iTc = this.b.tc();
        com.bytedance.sdk.component.b.hc.d.u.hc hcVarD = com.bytedance.sdk.component.b.hc.d.u.hc.d(iTc);
        if (hcVarD == null) {
            throw u.hc("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iTc));
        }
        hcVar.d(i2, hcVarD);
    }

    private void u(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw u.hc("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw u.hc("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw u.hc("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        k kVar = new k();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sTt = this.b.tt();
            int iTc = this.b.tc();
            if (sTt == 2) {
                if (iTc != 0 && iTc != 1) {
                    throw u.hc("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (sTt == 3) {
                sTt = 4;
            } else if (sTt == 4) {
                sTt = 7;
                if (iTc < 0) {
                    throw u.hc("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
            } else if (sTt == 5 && (iTc < 16384 || iTc > 16777215)) {
                throw u.hc("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iTc));
            }
            kVar.d(sTt, iTc);
        }
        hcVar.d(false, kVar);
    }

    private void an(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw u.hc("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sGb = (b & 8) != 0 ? (short) (this.b.gb() & 255) : (short) 0;
        hcVar.d(i2, this.b.tc() & Integer.MAX_VALUE, d(d(i - 4, b, sGb), sGb, b, i2));
    }

    private void h(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw u.hc("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw u.hc("TYPE_PING streamId != 0", new Object[0]);
        }
        hcVar.d((b & 1) != 0, this.b.tc(), this.b.tc());
    }

    private void gb(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw u.hc("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw u.hc("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iTc = this.b.tc();
        int iTc2 = this.b.tc();
        int i3 = i - 8;
        com.bytedance.sdk.component.b.hc.d.u.hc hcVarD = com.bytedance.sdk.component.b.hc.d.u.hc.d(iTc2);
        if (hcVarD == null) {
            throw u.hc("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iTc2));
        }
        com.bytedance.sdk.component.b.d.an anVarB = com.bytedance.sdk.component.b.d.an.hc;
        if (i3 > 0) {
            anVarB = this.b.b(i3);
        }
        hcVar.d(iTc, hcVarD, anVarB);
    }

    private void tt(hc hcVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw u.hc("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jTc = this.b.tc() & 2147483647L;
        if (jTc == 0) {
            throw u.hc("windowSizeIncrement was 0", Long.valueOf(jTc));
        }
        hcVar.d(i2, jTc);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    static final class d implements rf {
        private final com.bytedance.sdk.component.b.d.u an;
        int b;
        int c;
        int d;
        byte hc;
        short u;

        @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
        }

        d(com.bytedance.sdk.component.b.d.u uVar) {
            this.an = uVar;
        }

        @Override // com.bytedance.sdk.component.b.d.rf
        public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            while (true) {
                int i = this.c;
                if (i == 0) {
                    this.an.gb(this.u);
                    this.u = (short) 0;
                    if ((this.hc & 4) != 0) {
                        return -1L;
                    }
                    hc();
                } else {
                    long jD = this.an.d(bVar, Math.min(j, i));
                    if (jD == -1) {
                        return -1L;
                    }
                    this.c = (int) (this.c - jD);
                    return jD;
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.d.rf
        public jh d() {
            return this.an.d();
        }

        private void hc() throws IOException {
            int i = this.b;
            int iD = gb.d(this.an);
            this.c = iD;
            this.d = iD;
            byte bGb = (byte) (this.an.gb() & 255);
            this.hc = (byte) (this.an.gb() & 255);
            if (gb.d.isLoggable(Level.FINE)) {
                gb.d.fine(u.d(true, this.b, this.d, bGb, this.hc));
            }
            int iTc = this.an.tc() & Integer.MAX_VALUE;
            this.b = iTc;
            if (bGb != 9) {
                throw u.hc("%s != TYPE_CONTINUATION", Byte.valueOf(bGb));
            }
            if (iTc != i) {
                throw u.hc("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int d(com.bytedance.sdk.component.b.d.u uVar) throws IOException {
        return (uVar.gb() & 255) | ((uVar.gb() & 255) << 16) | ((uVar.gb() & 255) << 8);
    }

    static int d(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw u.hc("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
