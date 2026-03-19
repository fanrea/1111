package com.kwai.player.vr;

import android.util.SparseArray;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiMesh {
    private static final int sPositionDataSize = 3;
    private static final int sTextureCoordinateDataSize = 2;
    private ShortBuffer mIndicesBuffer;
    private int mNumIndices;
    private SparseArray<FloatBuffer> mTexCoordinateBuffers = new SparseArray<>(2);
    private SparseArray<FloatBuffer> mVerticesBuffers = new SparseArray<>(2);

    public int getNumIndices() {
        return this.mNumIndices;
    }

    public void setNumIndices(int i) {
        this.mNumIndices = i;
    }

    public FloatBuffer getVerticesBuffer(int i) {
        return this.mVerticesBuffers.get(i);
    }

    public void setVerticesBuffer(int i, FloatBuffer floatBuffer) {
        this.mVerticesBuffers.put(i, floatBuffer);
    }

    public FloatBuffer getTexCoordinateBuffer(int i) {
        return this.mTexCoordinateBuffers.get(i);
    }

    public void setTexCoordinateBuffer(int i, FloatBuffer floatBuffer) {
        this.mTexCoordinateBuffers.put(i, floatBuffer);
    }

    public ShortBuffer getIndicesBuffer() {
        return this.mIndicesBuffer;
    }

    public void setIndicesBuffer(ShortBuffer shortBuffer) {
        this.mIndicesBuffer = shortBuffer;
    }
}
