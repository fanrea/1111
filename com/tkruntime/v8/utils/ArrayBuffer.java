package com.tkruntime.v8.utils;

import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8ArrayBuffer;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class ArrayBuffer {
    private V8ArrayBuffer arrayBuffer;

    ArrayBuffer(V8ArrayBuffer v8ArrayBuffer) {
        this.arrayBuffer = v8ArrayBuffer;
    }

    public ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        this.arrayBuffer = new V8ArrayBuffer(v8, byteBuffer);
    }

    public boolean isAvailable() {
        return !this.arrayBuffer.isReleased();
    }

    public V8ArrayBuffer getV8ArrayBuffer() {
        return this.arrayBuffer;
    }
}
