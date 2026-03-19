package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import com.kwad.sdk.utils.a.a;
import com.kwai.video.player.KsMediaMeta;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int coA;
    private static final int coB;
    private static final int[] cox = {0, 1, 4, 4, 8, 8};
    private static final byte[] coy = new byte[0];
    private static final int coz;
    private final String adR;
    private final Map<String, b> coC;
    private FileChannel coE;
    private FileChannel coF;
    private RandomAccessFile coG;
    private RandomAccessFile coH;
    private MappedByteBuffer coI;
    private MappedByteBuffer coJ;
    private com.kwad.sdk.utils.a.b coK;
    private int coL;
    private long coM;
    private int coP;
    private int coQ;
    private int coR;
    private boolean coS;
    private String coT;
    private int coU;
    private int coW;
    private final String name;
    private final d coD = com.kwad.sdk.utils.a.d.cpg;
    private final Map<String, a.b> coN = new HashMap();
    private boolean coO = false;
    private final ArrayList<e> coV = new ArrayList<>();
    private boolean coX = true;
    private final Executor bTZ = new f();

    public interface b<T> {
        byte[] L(T t);

        String aqM();

        T g(byte[] bArr, int i, int i2);
    }

    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    private static long i(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    static {
        int iAqO = h.aqO();
        PAGE_SIZE = iAqO;
        coz = iAqO - 192;
        int iMax = Math.max(iAqO << 1, 16384);
        coA = iMax;
        coB = iMax << 1;
    }

    c(String str, String str2, b[] bVarArr, int i) {
        this.adR = str;
        this.name = str2;
        this.coW = i;
        HashMap map = new HashMap();
        g gVar = g.cpl;
        map.put(gVar.aqM(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String strAqM = bVar.aqM();
                if (map.containsKey(strAqM)) {
                    jc("duplicate encoder tag:" + strAqM);
                } else {
                    map.put(strAqM, bVar);
                }
            }
        }
        this.coC = map;
        synchronized (this.coN) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Dt();
                }
            });
            while (!this.coO) {
                try {
                    this.coN.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Dt() {
        synchronized (this.coN) {
            this.coO = true;
            this.coN.notify();
        }
        long jNanoTime = System.nanoTime();
        if (!aqw() && this.coW == 0) {
            aqu();
        }
        if (this.coK == null) {
            this.coK = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        if (this.coD != null) {
            info("loading finish, data len:" + this.coL + ", get keys:" + this.coN.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void aqu() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.aqu():void");
    }

    private void h(File file, File file2) {
        try {
            if (an(file)) {
                return;
            }
        } catch (IOException e2) {
            h(e2);
        }
        aqE();
        try {
            if (an(file2)) {
                return;
            }
        } catch (Exception e3) {
            h(e3);
        }
        aqE();
    }

    private boolean aqv() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.coL);
        MappedByteBuffer mappedByteBuffer = this.coJ;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.coJ.get(bVar.cow, 0, this.coL);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.coK;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.cow;
        byte[] bArr2 = bVar.cow;
        for (int i = 0; i < this.coL; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean aqw() {
        File file = new File(this.adR, this.name + ".kvc");
        File file2 = new File(this.adR, this.name + ".tmp");
        boolean z = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (an(file)) {
                    if (this.coW == 0) {
                        if (a(this.coK)) {
                            info("recover from c file");
                            try {
                                aqB();
                                return true;
                            } catch (Exception e2) {
                                e = e2;
                                B(e);
                                return z;
                            }
                        }
                        this.coW = 1;
                    }
                } else {
                    aqE();
                    aqB();
                }
            } else if (this.coW != 0) {
                File file3 = new File(this.adR, this.name + ".kva");
                File file4 = new File(this.adR, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    h(file3, file4);
                }
            }
            return false;
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    private boolean an(File file) throws IOException {
        com.kwad.sdk.utils.a.b bVar;
        long length = file.length();
        if (length != 0 && length <= KsMediaMeta.AV_CH_STEREO_LEFT) {
            int i = (int) length;
            int iAh = ah(PAGE_SIZE, i);
            com.kwad.sdk.utils.a.b bVar2 = this.coK;
            if (bVar2 != null && bVar2.cow.length == iAh) {
                bVar = this.coK;
                bVar.position = 0;
            } else {
                com.kwad.sdk.utils.a.b bVar3 = new com.kwad.sdk.utils.a.b(new byte[iAh]);
                this.coK = bVar3;
                bVar = bVar3;
            }
            h.a(file, bVar.cow, i);
            int i2 = bVar.getInt();
            long j = bVar.getLong();
            this.coL = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == bVar.ag(12, i2) && aqx() == 0) {
                this.coM = j;
                return true;
            }
        }
        return false;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) throws Exception {
        int length = bVar.cow.length;
        File file = new File(this.adR, this.name + ".kva");
        File file2 = new File(this.adR, this.name + ".kvb");
        try {
            if (!h.ao(file) || !h.ao(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.coE = randomAccessFile.getChannel();
            this.coF = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.coE.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.coI = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            MappedByteBuffer map2 = this.coF.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.coJ = map2;
            map2.order(ByteOrder.LITTLE_ENDIAN);
            this.coI.put(bVar.cow, 0, this.coL);
            this.coJ.put(bVar.cow, 0, this.coL);
            return true;
        } catch (Exception e2) {
            B(e2);
            return false;
        }
    }

    private static void k(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) throws IOException {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.coJ ? this.coF : this.coE).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.coJ) {
                    this.coJ = map;
                } else {
                    this.coI = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                B(e2);
                aqC();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x017a, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int aqx() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.aqx():int");
    }

    public final synchronized boolean contains(String str) {
        return this.coN.containsKey(str);
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        a.c cVar = (a.c) this.coN.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i) {
        a.f fVar = (a.f) this.coN.get(str);
        if (fVar == null) {
            return i;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j) {
        a.g gVar = (a.g) this.coN.get(str);
        if (gVar == null) {
            return j;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.coN.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.cou) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] bArrAp = h.ap(new File(this.adR + this.name, (String) iVar.value));
            String str = new String(bArrAp);
            return (bArrAp == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.l(bArrAp, com.kwad.sdk.utils.a.b.iY(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e2) {
            B(e2);
        }
        return "";
    }

    private byte[] a(a.C0633a c0633a) {
        try {
            byte[] bArrAp = h.ap(new File(this.adR + this.name, (String) c0633a.value));
            return bArrAp != null ? bArrAp : coy;
        } catch (Exception e2) {
            B(e2);
            return coy;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] bArrAp = h.ap(new File(this.adR + this.name, (String) hVar.value));
            if (bArrAp != null) {
                int i = bArrAp[0] & 255;
                String str = new String(bArrAp, 1, i, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.coC.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.g(bArrAp, i2, bArrAp.length - i2);
                }
                h(new Exception("No encoder for tag:" + str));
                return null;
            }
            h(new Exception("Read object data failed"));
            return null;
        } catch (Exception e2) {
            B(e2);
            return null;
        }
    }

    public final synchronized void putBoolean(String str, boolean z) {
        jb(str);
        a.c cVar = (a.c) this.coN.get(str);
        if (cVar == null) {
            a(str, (byte) 1);
            com.kwad.sdk.utils.a.b bVar = this.coK;
            if (bVar != null) {
                int i = bVar.position;
                this.coK.e((byte) (z ? 1 : 0));
                aqF();
                Map<String, a.b> map = this.coN;
                if (map != null) {
                    map.put(str, new a.c(i, z));
                }
            }
            aqy();
            return;
        }
        if (cVar.value != z) {
            cVar.value = z;
            a((byte) (z ? 1 : 0), cVar.offset);
            aqy();
        }
    }

    public final synchronized void putInt(String str, int i) {
        jb(str);
        a.f fVar = (a.f) this.coN.get(str);
        if (fVar == null) {
            a(str, (byte) 2);
            com.kwad.sdk.utils.a.b bVar = this.coK;
            if (bVar != null) {
                int i2 = bVar.position;
                this.coK.hC(i);
                aqF();
                Map<String, a.b> map = this.coN;
                if (map != null) {
                    map.put(str, new a.f(i2, i));
                }
            }
            aqy();
            return;
        }
        if (fVar.value != i) {
            long j = (fVar.value ^ i) & C00oOOo.f362O8oO888;
            fVar.value = i;
            a(i, j, fVar.offset);
            aqy();
        }
    }

    private synchronized void putFloat(String str, float f) {
        jb(str);
        a.e eVar = (a.e) this.coN.get(str);
        if (eVar != null) {
            if (eVar.value != f) {
                int iFloatToRawIntBits = Float.floatToRawIntBits(f);
                long jFloatToRawIntBits = (Float.floatToRawIntBits(eVar.value) ^ iFloatToRawIntBits) & C00oOOo.f362O8oO888;
                eVar.value = f;
                a(iFloatToRawIntBits, jFloatToRawIntBits, eVar.offset);
                aqy();
            }
            return;
        }
        a(str, (byte) 3);
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null) {
            int i = bVar.position;
            this.coK.hC(Float.floatToRawIntBits(f));
            aqF();
            Map<String, a.b> map = this.coN;
            if (map != null) {
                map.put(str, new a.e(i, f));
            }
        }
        aqy();
    }

    public final synchronized void putLong(String str, long j) {
        jb(str);
        a.g gVar = (a.g) this.coN.get(str);
        if (gVar != null) {
            if (gVar.value != j) {
                long j2 = j ^ gVar.value;
                gVar.value = j;
                c(j, j2, gVar.offset);
                aqy();
            }
            return;
        }
        a(str, (byte) 4);
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null) {
            int i = bVar.position;
            this.coK.bO(j);
            aqF();
            Map<String, a.b> map = this.coN;
            if (map != null) {
                map.put(str, new a.g(i, j));
            }
        }
        aqy();
    }

    private synchronized void putDouble(String str, double d2) {
        jb(str);
        a.d dVar = (a.d) this.coN.get(str);
        if (dVar != null) {
            if (dVar.value != d2) {
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
                long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ jDoubleToRawLongBits;
                dVar.value = d2;
                c(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.offset);
                aqy();
            }
            return;
        }
        a(str, (byte) 5);
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null) {
            int i = bVar.position;
            this.coK.bO(Double.doubleToRawLongBits(d2));
            aqF();
            Map<String, a.b> map = this.coN;
            if (map != null) {
                map.put(str, new a.d(i, d2));
            }
        }
        aqy();
    }

    public final synchronized void putString(String str, String str2) {
        byte[] bArrJa;
        byte[] bArr;
        byte[] bArr2;
        jb(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.coN.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            bArrJa = coy;
        } else {
            if (iVar == null && str2.length() < 2048) {
                int iIY = com.kwad.sdk.utils.a.b.iY(str2);
                bArr = new byte[iIY];
                if (iIY == str2.length()) {
                    a(str2, 0, iIY, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrJa = com.kwad.sdk.utils.a.b.ja(str2);
                }
            } else if (iVar != null && !iVar.cou) {
                int iIY2 = com.kwad.sdk.utils.a.b.iY(str2);
                bArr = new byte[iIY2];
                if (iIY2 == str2.length()) {
                    a(str2, 0, iIY2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrJa = com.kwad.sdk.utils.a.b.ja(str2);
                }
            } else {
                bArrJa = com.kwad.sdk.utils.a.b.ja(str2);
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArr2 = bArrJa;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    private synchronized void b(String str, byte[] bArr) {
        jb(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0633a) this.coN.get(str), (byte) 7);
        }
    }

    private synchronized <T> void a(String str, T t, b<T> bVar) {
        jb(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (com.kwad.library.a.a.qr.booleanValue()) {
                throw illegalArgumentException;
            }
            B(illegalArgumentException);
            return;
        }
        String strAqM = bVar.aqM();
        if (!strAqM.isEmpty() && strAqM.length() <= 50) {
            if (!this.coC.containsKey(strAqM)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (com.kwad.library.a.a.qr.booleanValue()) {
                    throw illegalArgumentException2;
                }
                B(illegalArgumentException2);
                return;
            }
            if (t == null) {
                remove(str);
                return;
            }
            byte[] bArrL = null;
            try {
                bArrL = bVar.L(t);
            } catch (Exception e2) {
                B(e2);
            }
            if (bArrL == null) {
                remove(str);
                return;
            }
            int iIY = com.kwad.sdk.utils.a.b.iY(strAqM);
            com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(iIY + 1 + bArrL.length);
            bVar2.e((byte) iIY);
            bVar2.iX(strAqM);
            bVar2.t(bArrL);
            a(str, t, bVar2.cow, (a.h) this.coN.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + strAqM);
        if (com.kwad.library.a.a.qr.booleanValue()) {
            throw illegalArgumentException3;
        }
        B(illegalArgumentException3);
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.cpl);
        }
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.coN.get(str);
        if (bVar != null) {
            this.coN.remove(str);
            byte bAqs = bVar.aqs();
            String str2 = null;
            if (bAqs <= 5) {
                a(bAqs, bVar.offset - (com.kwad.sdk.utils.a.b.iY(str) + 2), bVar.offset + cox[bAqs]);
            } else {
                a.j jVar = (a.j) bVar;
                a(bAqs, jVar.start, jVar.offset + jVar.cot);
                if (jVar.cou) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (bAqs | (-128));
            if (this.coW == 0) {
                MappedByteBuffer mappedByteBuffer = this.coI;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.coM);
                    this.coI.put(this.coR, b2);
                }
                MappedByteBuffer mappedByteBuffer2 = this.coJ;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.coM);
                    this.coJ.put(this.coR, b2);
                }
            } else {
                com.kwad.sdk.utils.a.b bVar2 = this.coK;
                if (bVar2 != null) {
                    bVar2.j(4, this.coM);
                }
            }
            this.coR = 0;
            if (str2 != null) {
                h.h(new File(this.adR + this.name, str2));
            }
            aqI();
            aqy();
        }
    }

    public final synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.coN.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.coN.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            Object obj = null;
            switch (value.aqs()) {
                case 1:
                    objValueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    if (iVar.cou) {
                        objValueOf = a(iVar);
                        break;
                    } else {
                        objValueOf = iVar.value;
                        break;
                    }
                case 7:
                    a.C0633a c0633a = (a.C0633a) value;
                    if (c0633a.cou) {
                        objValueOf = a(c0633a);
                        break;
                    } else {
                        objValueOf = c0633a.value;
                        break;
                    }
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.cou) {
                        objValueOf = a(hVar);
                        break;
                    } else {
                        objValueOf = ((a.h) value).value;
                        break;
                    }
                default:
                    continue;
                    map.put(key, obj);
            }
            obj = objValueOf;
            map.put(key, obj);
        }
        return map;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(key, (byte[]) value);
                } else {
                    h(new Exception("missing encoders"));
                }
            }
        }
    }

    private void aqy() {
        if (this.coW == 0 || !this.coX) {
            return;
        }
        aqz();
    }

    private boolean aqz() {
        int i = this.coW;
        if (i == 1) {
            Executor executor = this.bTZ;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.aqA();
                    }
                });
            }
        } else if (i == 2) {
            return aqA();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean aqA() {
        try {
            File file = new File(this.adR, this.name + ".tmp");
            if (h.ao(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.coL);
                randomAccessFile.write(this.coK.cow, 0, this.coL);
                randomAccessFile.close();
                File file2 = new File(this.adR, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    h(new Exception("rename failed"));
                }
            }
        } catch (Exception e2) {
            B(e2);
        }
        return false;
    }

    private void aqB() {
        try {
            h.h(new File(this.adR, this.name + ".kvc"));
            h.h(new File(this.adR, this.name + ".tmp"));
        } catch (Exception e2) {
            B(e2);
        }
    }

    private void aqC() throws IOException {
        this.coW = 1;
        h.closeQuietly(this.coE);
        h.closeQuietly(this.coF);
        this.coE = null;
        this.coF = null;
        this.coI = null;
        this.coJ = null;
    }

    private void aqD() throws IOException {
        if (this.coW == 0) {
            try {
                a(this.coI);
                a(this.coJ);
            } catch (Throwable unused) {
                aqC();
            }
        }
        aqE();
        h.h(new File(this.adR + this.name));
    }

    public final void release() throws IOException {
        h.closeQuietly(this.coG);
        h.closeQuietly(this.coH);
        h.closeQuietly(this.coE);
        h.closeQuietly(this.coF);
        this.coE = null;
        this.coF = null;
        this.coI = null;
        this.coJ = null;
        String str = this.adR + this.name;
        C0634c c0634c = a.cpa;
        C0634c.remove(str);
    }

    private void a(MappedByteBuffer mappedByteBuffer) throws IOException {
        if (mappedByteBuffer == null) {
            return;
        }
        int iCapacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (iCapacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.coI ? this.coE : this.coF;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.coI) {
                this.coI = map;
            } else {
                this.coJ = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void aqE() {
        this.coL = 12;
        this.coM = 0L;
        aqK();
        this.coN.clear();
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar == null || bVar.cow.length != PAGE_SIZE) {
            this.coK = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        } else {
            this.coK.ae(0, 0);
            this.coK.j(4, 0L);
        }
    }

    private static void jb(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private static void hJ(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void a(String str, byte b2) throws IOException {
        a(str, b2, cox[b2]);
    }

    private void a(String str, byte b2, int i) throws IOException {
        int iIY = com.kwad.sdk.utils.a.b.iY(str);
        hJ(iIY);
        this.coQ = iIY + 2 + i;
        aqH();
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null) {
            bVar.e(b2);
        }
        z(str, iIY);
    }

    private void aqF() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.coK;
        if (bVar2 != null) {
            this.coM ^= bVar2.ag(this.coP, this.coQ);
        }
        if (this.coW == 0) {
            MappedByteBuffer mappedByteBuffer = this.coI;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.coI);
                this.coI.putInt(0, this.coL - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.coJ;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.coS && (bVar = this.coK) != null) {
                bVar.ae(0, this.coL - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.coK;
            if (bVar3 != null) {
                bVar3.j(4, this.coM);
            }
        }
        this.coS = false;
        this.coR = 0;
        this.coQ = 0;
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.coS && mappedByteBuffer != this.coI) {
            mappedByteBuffer.putInt(0, this.coL - 12);
        }
        mappedByteBuffer.putLong(4, this.coM);
        int i = this.coR;
        if (i != 0) {
            mappedByteBuffer.put(i, this.coK.cow[this.coR]);
        }
        if (this.coQ != 0) {
            mappedByteBuffer.position(this.coP);
            mappedByteBuffer.put(this.coK.cow, this.coP, this.coQ);
        }
    }

    private int aqG() {
        int i = this.coL;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void hK(int i) throws IOException {
        if (this.coK == null) {
            this.coK = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.coK.cow.length;
        int i2 = this.coL + i;
        if (i2 >= length) {
            int i3 = this.coU;
            if (i3 > i && i3 > aqG()) {
                hL(i);
                return;
            }
            int iAh = ah(length, i2);
            byte[] bArr = new byte[iAh];
            System.arraycopy(this.coK.cow, 0, bArr, 0, this.coL);
            this.coK.cow = bArr;
            if (this.coW == 0) {
                try {
                    long j = iAh;
                    MappedByteBuffer map = this.coE.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.coI = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.coF.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.coJ = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (Throwable th) {
                    B(new Exception("map failed", th));
                    this.coK.ae(0, this.coL - 12);
                    this.coK.j(4, this.coM);
                    aqC();
                }
            }
        }
    }

    private void a(byte b2, int i) {
        long jI = this.coM ^ i(1L, i);
        this.coM = jI;
        if (this.coW == 0) {
            MappedByteBuffer mappedByteBuffer = this.coI;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jI);
                this.coI.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.coJ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.coM);
                this.coJ.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.coK;
            if (bVar != null) {
                bVar.j(4, jI);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.coK;
        if (bVar2 != null) {
            bVar2.cow[i] = b2;
        }
    }

    private void a(int i, long j, int i2) {
        long jI = i(j, i2) ^ this.coM;
        this.coM = jI;
        if (this.coW == 0) {
            MappedByteBuffer mappedByteBuffer = this.coI;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jI);
                this.coI.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.coJ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.coM);
                this.coJ.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.coK;
            if (bVar != null) {
                bVar.j(4, jI);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.coK;
        if (bVar2 != null) {
            bVar2.ae(i2, i);
        }
    }

    private void c(long j, long j2, int i) {
        long jI = i(j2, i) ^ this.coM;
        this.coM = jI;
        if (this.coW == 0) {
            MappedByteBuffer mappedByteBuffer = this.coI;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jI);
                this.coI.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.coJ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.coM);
                this.coJ.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.coK;
            if (bVar != null) {
                bVar.j(4, jI);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.coK;
        if (bVar2 != null) {
            bVar2.j(i, j);
        }
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null) {
            this.coM ^= bVar.ag(i, length);
            this.coK.position = i;
            this.coK.t(bArr);
            this.coM ^= this.coK.ag(i, length);
        }
        if (this.coW == 0) {
            MappedByteBuffer mappedByteBuffer = this.coI;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.coI.putLong(4, this.coM);
                this.coI.position(i);
                this.coI.put(bArr);
                this.coI.putInt(0, this.coL - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.coJ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.coM);
                this.coJ.position(i);
                this.coJ.put(bArr);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.b bVar2 = this.coK;
        if (bVar2 != null) {
            bVar2.j(4, this.coM);
        }
    }

    private void aqH() throws IOException {
        hK(this.coQ);
        int i = this.coL;
        this.coP = i;
        this.coL = this.coQ + i;
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null) {
            bVar.position = i;
        }
        this.coS = true;
    }

    private void z(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i);
        if (i == str.length()) {
            a(str, 0, i, this.coK.cow, this.coK.position);
            this.coK.position += i;
            return;
        }
        this.coK.iX(str);
    }

    private static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 <= str.length() && i2 >= 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (cCharAt < 128) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) (((byte) cCharAt) ^ 1);
                } else {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) cCharAt;
                }
                i5 = i6;
                i3 = i4;
            }
        }
    }

    private void A(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i == str.length()) {
            a(str, 0, i, this.coK.cow, this.coK.position);
        } else {
            this.coK.iX(str);
        }
    }

    private void a(String str, String str2, a.i iVar) throws IOException {
        int iIY = com.kwad.sdk.utils.a.b.iY(str2);
        if (iVar == null) {
            int iIY2 = com.kwad.sdk.utils.a.b.iY(str);
            hJ(iIY2);
            int i = iIY2 + 4;
            this.coQ = i + iIY;
            aqH();
            com.kwad.sdk.utils.a.b bVar = this.coK;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            z(str, iIY2);
            A(str2, iIY);
            Map<String, a.b> map = this.coN;
            int i2 = this.coP;
            map.put(str, new a.i(i2, i2 + i, str2, iIY, false));
            aqF();
        } else {
            int i3 = iVar.offset - iVar.start;
            boolean z = true;
            if (iVar.cot == iIY) {
                this.coM ^= this.coK.ag(iVar.offset, iVar.cot);
                if (iIY == str2.length()) {
                    a(str2, 0, iIY, this.coK.cow, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.coK;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        this.coK.iX(str2);
                    }
                }
                this.coP = iVar.offset;
                this.coQ = iIY;
                z = false;
            } else {
                this.coQ = i3 + iIY;
                aqH();
                com.kwad.sdk.utils.a.b bVar3 = this.coK;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i4 = i3 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.coK;
                if (bVar4 != null) {
                    System.arraycopy(bVar4.cow, iVar.start + 1, this.coK.cow, this.coK.position, i4);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.coK;
                if (bVar5 != null) {
                    bVar5.position += i4;
                }
                A(str2, iIY);
                a((byte) 6, iVar.start, iVar.offset + iVar.cot);
                str = iVar.cou ? (String) iVar.value : null;
                iVar.cou = false;
                iVar.start = this.coP;
                iVar.offset = this.coP + i3;
                iVar.cot = iIY;
            }
            iVar.value = str2;
            aqF();
            if (z) {
                aqI();
            }
            if (str != null) {
                h.h(new File(this.adR + this.name, str));
            }
        }
        aqy();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) throws IOException {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (jVar.cou || jVar.cot != bArr.length) {
            a(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        }
        aqy();
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        a.b hVar;
        int iA = a(str, bArr, b2);
        if (iA != 0) {
            String str2 = this.coT;
            boolean z = str2 != null;
            if (z) {
                this.coT = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                hVar = new a.i(this.coP, iA, (String) obj2, length, z);
            } else if (b2 == 7) {
                hVar = new a.C0633a(this.coP, iA, obj2, length, z);
            } else {
                hVar = new a.h(this.coP, iA, obj2, length, z);
            }
            this.coN.put(str, hVar);
            aqF();
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar) throws IOException {
        int iA = a(str, bArr, jVar.aqs());
        if (iA != 0) {
            String str2 = jVar.cou ? (String) jVar.value : null;
            a(jVar.aqs(), jVar.start, jVar.offset + jVar.cot);
            boolean z = this.coT != null;
            jVar.start = this.coP;
            jVar.offset = iA;
            jVar.cou = z;
            if (z) {
                jVar.value = this.coT;
                jVar.cot = 32;
                this.coT = null;
            } else {
                jVar.value = obj;
                jVar.cot = bArr.length;
            }
            aqF();
            aqI();
            if (str2 != null) {
                h.h(new File(this.adR + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.coT = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strAqN = h.aqN();
        if (h.a(new File(this.adR + this.name, strAqN), bArr)) {
            this.coT = strAqN;
            byte[] bArr2 = new byte[32];
            strAqN.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b2 | 64));
        }
        jc("save large value failed");
        return 0;
    }

    private int b(String str, byte[] bArr, byte b2) throws IOException {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        int i = this.coK.position;
        this.coK.t(bArr);
        return i;
    }

    private void a(byte b2, int i, int i2) {
        ai(i, i2);
        byte b3 = (byte) (b2 | (-128));
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null && bVar.cow != null) {
            this.coM ^= ((this.coK.cow[i] ^ b3) & 255) << ((i & 7) << 3);
            this.coK.cow[i] = b3;
        }
        this.coR = i;
    }

    private void aqI() throws IOException {
        if (this.coU < (aqG() << 1)) {
            if (this.coV.size() < (this.coL < 16384 ? 80 : 160)) {
                return;
            }
        }
        hL(0);
    }

    private void aqJ() {
        ArrayList<e> arrayList = this.coV;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.coV.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.coV.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.coV.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void hL(int i) throws IOException {
        int i2;
        ArrayList<e> arrayList = this.coV;
        if (arrayList == null || this.coK == null) {
            return;
        }
        Collections.sort(arrayList);
        aqJ();
        e eVar = this.coV.get(0);
        int i3 = eVar.start;
        int i4 = this.coL;
        int i5 = i4 - this.coU;
        int i6 = i5 - 12;
        int i7 = i5 - i3;
        int i8 = i4 - i3;
        boolean z = i6 < i8 + i7;
        if (!z) {
            this.coM ^= this.coK.ag(i3, i8);
        }
        int size = this.coV.size();
        int i9 = size - 1;
        int i10 = this.coL - this.coV.get(i9).end;
        int[] iArr = new int[(i10 > 0 ? size : i9) << 1];
        int i11 = eVar.start;
        int i12 = eVar.end;
        int i13 = 1;
        while (i13 < size) {
            e eVar2 = this.coV.get(i13);
            int i14 = eVar2.start - i12;
            int i15 = size;
            System.arraycopy(this.coK.cow, i12, this.coK.cow, i11, i14);
            int i16 = (i13 - 1) << 1;
            iArr[i16] = i12;
            iArr[i16 + 1] = i12 - i11;
            i11 += i14;
            i12 = eVar2.end;
            i13++;
            size = i15;
        }
        if (i10 > 0) {
            System.arraycopy(this.coK.cow, i12, this.coK.cow, i11, i10);
            int i17 = i9 << 1;
            iArr[i17] = i12;
            iArr[i17 + 1] = i12 - i11;
        }
        aqK();
        if (z) {
            this.coM = this.coK.ag(12, i6);
        } else {
            this.coM ^= this.coK.ag(i3, i7);
        }
        this.coL = i5;
        if (this.coW == 0) {
            MappedByteBuffer mappedByteBuffer = this.coI;
            if (mappedByteBuffer != null) {
                i2 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.coI.putLong(4, this.coM);
                this.coI.position(i3);
                this.coI.put(this.coK.cow, i3, i7);
                this.coI.putInt(0, i6);
            } else {
                i2 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.coJ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i2, i6);
                this.coJ.putLong(4, this.coM);
                this.coJ.position(i3);
                this.coJ.put(this.coK.cow, i3, i7);
            }
        } else {
            this.coK.ae(0, i6);
            this.coK.j(4, this.coM);
        }
        a(i3, iArr);
        int i18 = i5 + i;
        if (this.coK.cow.length - i18 > coB) {
            hM(i18);
        }
        info("gc finish");
    }

    private void a(int i, int[] iArr) {
        Map<String, a.b> map = this.coN;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            if (bVar.offset > i) {
                int i2 = iArr[(h.binarySearch(iArr, bVar.offset) << 1) + 1];
                bVar.offset -= i2;
                if (bVar.aqs() >= 6) {
                    ((a.j) bVar).start -= i2;
                }
            }
        }
    }

    private void hM(int i) throws IOException {
        int i2 = PAGE_SIZE;
        int iAh = ah(i2, i + i2);
        com.kwad.sdk.utils.a.b bVar = this.coK;
        if (bVar != null) {
            if (iAh >= bVar.cow.length) {
                return;
            }
            byte[] bArr = new byte[iAh];
            System.arraycopy(this.coK.cow, 0, bArr, 0, this.coL);
            this.coK.cow = bArr;
        }
        if (this.coW == 0) {
            try {
                long j = iAh;
                this.coE.truncate(j);
                MappedByteBuffer map = this.coE.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.coI = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.coF.truncate(j);
                MappedByteBuffer map2 = this.coF.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.coJ = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                B(new Exception("map failed", th));
                aqC();
            }
        }
        info("truncate finish");
    }

    private int ah(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.library.a.a.qr.booleanValue()) {
                throw illegalStateException;
            }
            B(illegalStateException);
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = coA;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private void ai(int i, int i2) {
        this.coU += i2 - i;
        ArrayList<e> arrayList = this.coV;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    private void aqK() {
        this.coU = 0;
        ArrayList<e> arrayList = this.coV;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    static class e implements Comparable<e> {
        int end;
        int start;

        e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    private void jc(String str) {
        d dVar = this.coD;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void B(Throwable th) {
        d dVar = this.coD;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void h(Exception exc) {
        d dVar = this.coD;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void info(String str) {
        d dVar = this.coD;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.c$c, reason: collision with other inner class name */
    static class C0634c {
        private static Map<String, c> cpc;
        private static List<String> cpd;
        private static int cpe;
        public static Map<String, Integer> cpf;

        private static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        public C0634c(int i) {
            int size = getSize(i);
            cpc = new ConcurrentHashMap(size);
            cpf = new HashMap(size);
            cpd = new CopyOnWriteArrayList();
            cpe = i;
        }

        private static void hN(int i) {
            com.kwad.sdk.utils.a.d.cpg.i("Ks_UnionKv", "reSize:" + i);
            cpe = i;
        }

        public static c jd(String str) {
            if (cpc == null) {
                cpc = new ConcurrentHashMap(getSize(cpe));
            }
            if (cpd == null) {
                cpd = new CopyOnWriteArrayList();
            }
            c cVar = cpc.get(str);
            if (cVar == null) {
                return null;
            }
            cpd.remove(str);
            cpd.add(str);
            return cVar;
        }

        public static void b(String str, c cVar) throws IOException {
            if (cpc == null) {
                cpc = new ConcurrentHashMap(getSize(cpe));
            }
            if (cpd == null) {
                cpd = new CopyOnWriteArrayList();
            }
            if (cpc.containsKey(str)) {
                cpd.remove(str);
                cpd.add(str);
            } else {
                cpd.add(str);
            }
            cpc.put(str, cVar);
            if (cpc.size() > cpe) {
                Integer num = cpf.get(cpd.get(0));
                if (num != null && num.intValue() != 2) {
                    hN(cpe + 1);
                    return;
                }
                c cVar2 = cpc.get(cpd.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                cpc.remove(cpd.get(0));
                cpd.remove(0);
            }
        }

        public static void remove(String str) {
            List<String> list = cpd;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = cpc;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public static class a {
        static int coZ = 11;
        static final C0634c cpa = new C0634c(coZ);
        private final String adR;
        private int coW = 0;
        private b[] cpb;
        private final String name;

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            this.adR = str.endsWith("/") ? str : str + '/';
            this.name = str2;
        }

        public final c aqL() {
            String str = this.adR + this.name;
            c cVarJd = C0634c.jd(str);
            if (cVarJd == null) {
                synchronized (a.class) {
                    cVarJd = C0634c.jd(str);
                    if (cVarJd == null) {
                        cVarJd = new c(this.adR, this.name, this.cpb, this.coW);
                        C0634c.b(str, cVarJd);
                    }
                }
            }
            Integer num = C0634c.cpf.get(str);
            if (num != null) {
                C0634c.cpf.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0634c.cpf.put(str, 1);
            }
            return cVarJd;
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.adR + " name:" + this.name;
    }
}
