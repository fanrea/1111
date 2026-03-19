package com.kwai.player.vr;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiSphereMesh extends KwaiBaseMesh {
    private static final String TAG = "KwaiSphereMesh";
    private static KwaiMesh kwaiMesh = new KwaiMesh();

    @Override // com.kwai.player.vr.KwaiBaseMesh
    protected void genKwaiMesh() {
        generateSphere();
    }

    public static void generateSphere() {
        generateSphere(18.0f, 150);
    }

    @Override // com.kwai.player.vr.KwaiBaseMesh
    public KwaiMesh getKwaiMesh() {
        return kwaiMesh;
    }

    private static void generateSphere(float f, int i) {
        int i2 = i / 2;
        int i3 = i2 + 1;
        int i4 = i + 1;
        int i5 = i3 * i4;
        float f2 = i;
        float f3 = 6.2831855f / f2;
        int i6 = i5 * 3;
        float[] fArr = new float[i6];
        int i7 = i5 * 2;
        float[] fArr2 = new float[i7];
        int i8 = i2 * i * 6 * 6;
        short[] sArr = new short[i8];
        int i9 = 0;
        while (i9 < i3) {
            int i10 = 0;
            while (i10 < i4) {
                int i11 = (i9 * i4) + i10;
                int i12 = i11 * 3;
                int i13 = i3;
                float f4 = i9;
                int i14 = i8;
                int i15 = i4;
                double d = f3 * f4;
                int i16 = i2;
                float f5 = i10;
                float f6 = f3;
                double d2 = f3 * f5;
                fArr[i12 + 0] = (-f) * ((float) Math.sin(d)) * ((float) Math.sin(d2));
                fArr[i12 + 1] = ((float) Math.sin(r6 + 1.5707964f)) * f;
                fArr[i12 + 2] = ((float) Math.sin(d)) * f * ((float) Math.cos(d2));
                int i17 = i11 * 2;
                fArr2[i17 + 0] = f5 / f2;
                fArr2[i17 + 1] = f4 / i16;
                i10++;
                sArr = sArr;
                i9 = i9;
                i3 = i13;
                i8 = i14;
                i4 = i15;
                i7 = i7;
                f3 = f6;
                i6 = i6;
                i2 = i16;
            }
            i9++;
            i2 = i2;
        }
        int i18 = i2;
        int i19 = i4;
        int i20 = i7;
        int i21 = i8;
        int i22 = i6;
        short[] sArr2 = sArr;
        int i23 = 0;
        for (int i24 = 0; i24 < i18; i24++) {
            int i25 = 0;
            while (i25 < i) {
                int i26 = i23 + 1;
                int i27 = i24 * i19;
                short s = (short) (i27 + i25);
                sArr2[i23] = s;
                int i28 = i26 + 1;
                int i29 = (i24 + 1) * i19;
                sArr2[i26] = (short) (i29 + i25);
                int i30 = i28 + 1;
                i25++;
                short s2 = (short) (i29 + i25);
                sArr2[i28] = s2;
                int i31 = i30 + 1;
                sArr2[i30] = s;
                int i32 = i31 + 1;
                sArr2[i31] = s2;
                i23 = i32 + 1;
                sArr2[i32] = (short) (i27 + i25);
            }
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i22 * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(i20 * 4);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2);
        floatBufferAsFloatBuffer2.position(0);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(i21 * 2);
        byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer shortBufferAsShortBuffer = byteBufferAllocateDirect3.asShortBuffer();
        shortBufferAsShortBuffer.put(sArr2);
        shortBufferAsShortBuffer.position(0);
        kwaiMesh.setIndicesBuffer(shortBufferAsShortBuffer);
        kwaiMesh.setTexCoordinateBuffer(0, floatBufferAsFloatBuffer2);
        kwaiMesh.setTexCoordinateBuffer(1, floatBufferAsFloatBuffer2);
        kwaiMesh.setVerticesBuffer(0, floatBufferAsFloatBuffer);
        kwaiMesh.setVerticesBuffer(1, floatBufferAsFloatBuffer);
        kwaiMesh.setNumIndices(i21);
    }
}
