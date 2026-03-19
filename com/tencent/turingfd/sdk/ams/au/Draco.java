package com.tencent.turingfd.sdk.ams.au;

import com.alibaba.fastjson.asm.TypeCollector;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Draco {
    public ByteBuffer a;
    public String b = "GBK";

    public Draco() {
    }

    public final void a() {
        ByteBuffer byteBuffer = this.a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        a(b2);
    }

    public boolean b(int i) {
        int i2;
        int i3;
        while (true) {
            try {
                ByteBuffer byteBufferDuplicate = this.a.duplicate();
                byte b = byteBufferDuplicate.get();
                byte b2 = (byte) (b & 15);
                i2 = (b & 240) >> 4;
                if (i2 == 15) {
                    i2 = byteBufferDuplicate.get() & 255;
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (i <= i2 || b2 == 11) {
                    break;
                }
                a(i3);
                a(b2);
            } catch (Crux | BufferUnderflowException unused) {
                return false;
            }
        }
        return i == i2;
    }

    public final void a(int i) {
        ByteBuffer byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    public final void a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i2 = this.a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                a(i2);
                return;
            case 7:
                a(this.a.getInt());
                return;
            case 8:
                int iA = a(0, 0, true);
                while (i < iA * 2) {
                    a();
                    i++;
                }
                return;
            case 9:
                int iA2 = a(0, 0, true);
                while (i < iA2) {
                    a();
                    i++;
                }
                return;
            case 10:
                b();
                return;
            case 11:
            case 12:
                return;
            case 13:
                ByteBuffer byteBuffer = this.a;
                byte b2 = byteBuffer.get();
                byte b3 = (byte) (b2 & 15);
                if (((b2 & 240) >> 4) == 15) {
                    byteBuffer.get();
                }
                if (b3 == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new Crux("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) b3));
            default:
                throw new Crux("invalid type.");
        }
    }

    public void b() {
        while (this.a.remaining() != 0) {
            ByteBuffer byteBuffer = this.a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            a(b2);
            if (b2 == 11) {
                return;
            }
        }
    }

    public String b(int i, boolean z) {
        if (b(i)) {
            ByteBuffer byteBuffer = this.a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 6) {
                int i2 = this.a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.a.get(bArr);
                try {
                    return new String(bArr, this.b);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            }
            if (b2 == 7) {
                int i3 = this.a.getInt();
                if (i3 <= 104857600 && i3 >= 0) {
                    byte[] bArr2 = new byte[i3];
                    this.a.get(bArr2);
                    try {
                        return new String(bArr2, this.b);
                    } catch (UnsupportedEncodingException unused2) {
                        return new String(bArr2);
                    }
                }
                throw new Crux(Dorado.a("String too long: ", i3));
            }
            if (b2 != 11) {
                throw new Crux("type mismatch.");
            }
        } else if (z) {
            throw new Crux("require field not exist.");
        }
        return null;
    }

    public boolean a(boolean z, int i, boolean z2) {
        return a(z ? (byte) 1 : (byte) 0, i, z2) != 0;
    }

    public byte a(byte b, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return b;
        }
        ByteBuffer byteBuffer = this.a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b3 == 0) {
            return this.a.get();
        }
        if (b3 == 11) {
            return b;
        }
        if (b3 == 12) {
            return (byte) 0;
        }
        throw new Crux("type mismatch.");
    }

    public short a(short s, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return s;
        }
        ByteBuffer byteBuffer = this.a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 == 0) {
            return this.a.get();
        }
        if (b2 == 1) {
            return this.a.getShort();
        }
        if (b2 == 11) {
            return s;
        }
        if (b2 == 12) {
            return (short) 0;
        }
        throw new Crux("type mismatch.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] b(T t, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 != 9) {
            if (b2 == 11) {
                return null;
            }
            throw new Crux("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA >= 0) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), iA));
            for (int i2 = 0; i2 < iA; i2++) {
                tArr[i2] = a((Draco) t, 0, true);
            }
            return tArr;
        }
        throw new Crux(Dorado.a("size invalid: ", iA));
    }

    public int a(int i, int i2, boolean z) {
        if (!b(i2)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return i;
        }
        ByteBuffer byteBuffer = this.a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 == 0) {
            return this.a.get();
        }
        if (b2 == 1) {
            return this.a.getShort();
        }
        if (b2 == 2) {
            return this.a.getInt();
        }
        if (b2 == 11) {
            return i;
        }
        if (b2 == 12) {
            return 0;
        }
        throw new Crux("type mismatch.");
    }

    public long a(long j, int i, boolean z) {
        int i2;
        if (!b(i)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return j;
        }
        ByteBuffer byteBuffer = this.a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 == 11) {
            return j;
        }
        if (b2 == 12) {
            return 0L;
        }
        if (b2 == 0) {
            i2 = this.a.get();
        } else if (b2 == 1) {
            i2 = this.a.getShort();
        } else {
            if (b2 != 2) {
                if (b2 != 3) {
                    throw new Crux("type mismatch.");
                }
                return this.a.getLong();
            }
            i2 = this.a.getInt();
        }
        return i2;
    }

    public float a(float f, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return f;
        }
        ByteBuffer byteBuffer = this.a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 == 4) {
            return this.a.getFloat();
        }
        if (b2 == 11) {
            return f;
        }
        if (b2 == 12) {
            return 0.0f;
        }
        throw new Crux("type mismatch.");
    }

    public double a(double d, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return d;
        }
        ByteBuffer byteBuffer = this.a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 == 4) {
            return this.a.getFloat();
        }
        if (b2 == 5) {
            return this.a.getDouble();
        }
        if (b2 == 11) {
            return d;
        }
        if (b2 == 12) {
            return 0.0d;
        }
        throw new Crux("type mismatch.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        TypeCollector.AnonymousClass1 anonymousClass1 = (HashMap<K, V>) new HashMap();
        if (map != null && !map.isEmpty()) {
            Map.Entry<K, V> next = map.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (!b(i)) {
                if (z) {
                    throw new Crux("require field not exist.");
                }
                return anonymousClass1;
            }
            ByteBuffer byteBuffer = this.a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 != 8) {
                if (b2 == 11) {
                    return anonymousClass1;
                }
                throw new Crux("type mismatch.");
            }
            int iA = a(0, 0, true);
            if (iA < 0) {
                throw new Crux(Dorado.a("size invalid: ", iA));
            }
            for (int i2 = 0; i2 < iA; i2++) {
                anonymousClass1.put(a((Draco) key, 0, true), a((Draco) value, 1, true));
            }
            return anonymousClass1;
        }
        return new HashMap<>();
    }

    public byte[] a(int i, boolean z) {
        if (b(i)) {
            ByteBuffer byteBuffer = this.a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 9) {
                int iA = a(0, 0, true);
                if (iA >= 0) {
                    byte[] bArr = new byte[iA];
                    for (int i2 = 0; i2 < iA; i2++) {
                        bArr[i2] = a(bArr[0], 0, true);
                    }
                    return bArr;
                }
                throw new Crux(Dorado.a("size invalid: ", iA));
            }
            if (b2 != 11) {
                if (b2 == 13) {
                    ByteBuffer byteBuffer2 = this.a;
                    byte b3 = byteBuffer2.get();
                    byte b4 = (byte) (b3 & 15);
                    if (((b3 & 240) >> 4) == 15) {
                        byteBuffer2.get();
                    }
                    if (b4 == 0) {
                        int iA2 = a(0, 0, true);
                        if (iA2 >= 0) {
                            byte[] bArr2 = new byte[iA2];
                            this.a.get(bArr2);
                            return bArr2;
                        }
                        throw new Crux("invalid size, tag: " + i + ", type: " + ((int) b2) + ", " + ((int) b4) + ", size: " + iA2);
                    }
                    throw new Crux("type mismatch, tag: " + i + ", type: " + ((int) b2) + ", " + ((int) b4));
                }
                throw new Crux("type mismatch.");
            }
        } else if (z) {
            throw new Crux("require field not exist.");
        }
        return null;
    }

    public Equuleus a(Equuleus equuleus, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new Crux("require field not exist.");
            }
            return null;
        }
        try {
            Equuleus equuleus2 = (Equuleus) equuleus.getClass().newInstance();
            ByteBuffer byteBuffer = this.a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 10) {
                equuleus2.a(this);
                b();
                return equuleus2;
            }
            throw new Crux("type mismatch.");
        } catch (Exception e) {
            throw new Crux(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i, z));
        }
        if (t instanceof String) {
            return b(i, z);
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        double[] dArr = null;
        zArr = null;
        boolean[] zArr = null;
        sArr = null;
        short[] sArr = null;
        iArr = null;
        int[] iArr = null;
        jArr = null;
        long[] jArr = null;
        fArr = null;
        float[] fArr = null;
        dArr = null;
        if (t instanceof List) {
            List list = (List) t;
            if (list != null && !list.isEmpty()) {
                Object[] objArrB = b(list.get(0), i, z);
                if (objArrB == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : objArrB) {
                    arrayList.add(obj);
                }
                return arrayList;
            }
            return new ArrayList();
        }
        if (t instanceof Equuleus) {
            return a((Equuleus) t, i, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer = this.a;
                        byte b = byteBuffer.get();
                        byte b2 = (byte) (b & 15);
                        if (((b & 240) >> 4) == 15) {
                            byteBuffer.get();
                        }
                        if (b2 == 9) {
                            int iA = a(0, 0, true);
                            if (iA >= 0) {
                                zArr = new boolean[iA];
                                for (int i2 = 0; i2 < iA; i2++) {
                                    zArr[i2] = a(zArr[0], 0, true);
                                }
                            } else {
                                throw new Crux(Dorado.a("size invalid: ", iA));
                            }
                        } else if (b2 != 11) {
                            throw new Crux("type mismatch.");
                        }
                    } else if (z) {
                        throw new Crux("require field not exist.");
                    }
                    return zArr;
                }
                if (t instanceof short[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer2 = this.a;
                        byte b3 = byteBuffer2.get();
                        byte b4 = (byte) (b3 & 15);
                        if (((b3 & 240) >> 4) == 15) {
                            byteBuffer2.get();
                        }
                        if (b4 == 9) {
                            int iA2 = a(0, 0, true);
                            if (iA2 >= 0) {
                                sArr = new short[iA2];
                                for (int i3 = 0; i3 < iA2; i3++) {
                                    sArr[i3] = a(sArr[0], 0, true);
                                }
                            } else {
                                throw new Crux(Dorado.a("size invalid: ", iA2));
                            }
                        } else if (b4 != 11) {
                            throw new Crux("type mismatch.");
                        }
                    } else if (z) {
                        throw new Crux("require field not exist.");
                    }
                    return sArr;
                }
                if (t instanceof int[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer3 = this.a;
                        byte b5 = byteBuffer3.get();
                        byte b6 = (byte) (b5 & 15);
                        if (((b5 & 240) >> 4) == 15) {
                            byteBuffer3.get();
                        }
                        if (b6 == 9) {
                            int iA3 = a(0, 0, true);
                            if (iA3 >= 0) {
                                iArr = new int[iA3];
                                for (int i4 = 0; i4 < iA3; i4++) {
                                    iArr[i4] = a(iArr[0], 0, true);
                                }
                            } else {
                                throw new Crux(Dorado.a("size invalid: ", iA3));
                            }
                        } else if (b6 != 11) {
                            throw new Crux("type mismatch.");
                        }
                    } else if (z) {
                        throw new Crux("require field not exist.");
                    }
                    return iArr;
                }
                if (t instanceof long[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer4 = this.a;
                        byte b7 = byteBuffer4.get();
                        byte b8 = (byte) (b7 & 15);
                        if (((b7 & 240) >> 4) == 15) {
                            byteBuffer4.get();
                        }
                        if (b8 == 9) {
                            int iA4 = a(0, 0, true);
                            if (iA4 >= 0) {
                                jArr = new long[iA4];
                                for (int i5 = 0; i5 < iA4; i5++) {
                                    jArr[i5] = a(jArr[0], 0, true);
                                }
                            } else {
                                throw new Crux(Dorado.a("size invalid: ", iA4));
                            }
                        } else if (b8 != 11) {
                            throw new Crux("type mismatch.");
                        }
                    } else if (z) {
                        throw new Crux("require field not exist.");
                    }
                    return jArr;
                }
                if (t instanceof float[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer5 = this.a;
                        byte b9 = byteBuffer5.get();
                        byte b10 = (byte) (b9 & 15);
                        if (((b9 & 240) >> 4) == 15) {
                            byteBuffer5.get();
                        }
                        if (b10 == 9) {
                            int iA5 = a(0, 0, true);
                            if (iA5 >= 0) {
                                fArr = new float[iA5];
                                for (int i6 = 0; i6 < iA5; i6++) {
                                    fArr[i6] = a(fArr[0], 0, true);
                                }
                            } else {
                                throw new Crux(Dorado.a("size invalid: ", iA5));
                            }
                        } else if (b10 != 11) {
                            throw new Crux("type mismatch.");
                        }
                    } else if (z) {
                        throw new Crux("require field not exist.");
                    }
                    return fArr;
                }
                if (t instanceof double[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer6 = this.a;
                        byte b11 = byteBuffer6.get();
                        byte b12 = (byte) (b11 & 15);
                        if (((b11 & 240) >> 4) == 15) {
                            byteBuffer6.get();
                        }
                        if (b12 == 9) {
                            int iA6 = a(0, 0, true);
                            if (iA6 >= 0) {
                                dArr = new double[iA6];
                                for (int i7 = 0; i7 < iA6; i7++) {
                                    dArr[i7] = a(dArr[0], 0, true);
                                }
                            } else {
                                throw new Crux(Dorado.a("size invalid: ", iA6));
                            }
                        } else if (b12 != 11) {
                            throw new Crux("type mismatch.");
                        }
                    } else if (z) {
                        throw new Crux("require field not exist.");
                    }
                    return dArr;
                }
                Object[] objArr = (Object[]) t;
                if (objArr.length != 0) {
                    return b(objArr[0], i, z);
                }
                throw new Crux("unable to get type of key and value.");
            }
            return a(i, z);
        }
        throw new Crux("read object error: unsupport type.");
    }

    public Draco(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    public Draco(byte[] bArr, int i) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.a = byteBufferWrap;
        byteBufferWrap.position(i);
    }
}
