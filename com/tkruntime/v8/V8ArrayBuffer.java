package com.tkruntime.v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8ArrayBuffer extends V8Value {
    ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v8, int i) {
        super(v8);
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i));
        this.byteBuffer = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.objectHandle, i);
        this.byteBuffer.order(ByteOrder.nativeOrder());
    }

    public V8ArrayBuffer(V8 v8, long j, ByteBuffer byteBuffer) {
        this.v8 = v8;
        this.objectHandle = j;
        this.released = false;
        this.byteBuffer = byteBuffer;
        addObjectReference(this.objectHandle);
    }

    public V8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8);
        byteBuffer = byteBuffer == null ? ByteBuffer.allocateDirect(0) : byteBuffer;
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        }
        initialize(v8.getV8RuntimePtr(), byteBuffer);
        this.byteBuffer = byteBuffer;
        byteBuffer.order(ByteOrder.nativeOrder());
    }

    @Override // com.tkruntime.v8.V8Value
    protected void initialize(long j, Object obj) {
        this.releaseCheck = false;
        this.v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        } else {
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), ((Integer) obj).intValue());
        }
        this.released = false;
        addObjectReference(this.objectHandle);
    }

    public int limit() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.limit();
    }

    public final int capacity() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.capacity();
    }

    public final int position() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.position();
    }

    public final V8ArrayBuffer position(int i) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.position(i);
        return this;
    }

    public final V8ArrayBuffer limit(int i) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.limit(i);
        return this;
    }

    public final V8ArrayBuffer mark() {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.mark();
        return this;
    }

    public final V8ArrayBuffer reset() {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.reset();
        return this;
    }

    public final V8ArrayBuffer clear() {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.clear();
        return this;
    }

    public final V8ArrayBuffer flip() {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.flip();
        return this;
    }

    public final V8ArrayBuffer rewind() {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.rewind();
        return this;
    }

    public final int remaining() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.remaining();
    }

    public final boolean hasRemaining() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasRemaining();
    }

    public boolean isReadOnly() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.isReadOnly();
    }

    public byte get() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.get();
    }

    public V8ArrayBuffer put(byte b) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.put(b);
        return this;
    }

    public byte get(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.get(i);
    }

    public V8ArrayBuffer put(int i, byte b) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.put(i, b);
        return this;
    }

    public V8ArrayBuffer get(byte[] bArr, int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr, i, i2);
        return this;
    }

    public V8ArrayBuffer get(byte[] bArr) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr);
        return this;
    }

    public V8ArrayBuffer put(ByteBuffer byteBuffer) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.put(byteBuffer);
        return this;
    }

    public V8ArrayBuffer put(byte[] bArr, int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr, i, i2);
        return this;
    }

    public final V8ArrayBuffer put(byte[] bArr) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr);
        return this;
    }

    public final boolean hasArray() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasArray();
    }

    public final byte[] array() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.array();
    }

    public final int arrayOffset() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.arrayOffset();
    }

    public V8ArrayBuffer compact() {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.compact();
        return this;
    }

    public boolean isDirect() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.isDirect();
    }

    public final ByteOrder order() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.order();
    }

    public final V8ArrayBuffer order(ByteOrder byteOrder) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.order(byteOrder);
        return this;
    }

    public char getChar() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar();
    }

    public V8ArrayBuffer putChar(char c) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(c);
        return this;
    }

    public char getChar(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar(i);
    }

    public V8ArrayBuffer putChar(int i, char c) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(i, c);
        return this;
    }

    public short getShort() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort();
    }

    public V8ArrayBuffer putShort(short s) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(s);
        return this;
    }

    public short getShort(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort(i);
    }

    public V8ArrayBuffer putShort(int i, short s) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(i, s);
        return this;
    }

    public int getInt() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt();
    }

    public V8ArrayBuffer putInt(int i) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putInt(i);
        return this;
    }

    public int getInt(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt(i);
    }

    public V8ArrayBuffer putInt(int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.asIntBuffer().put(i, i2);
        return this;
    }

    public long getLong() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong();
    }

    public V8ArrayBuffer putLong(long j) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(j);
        return this;
    }

    public long getLong(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong(i);
    }

    public V8ArrayBuffer putLong(int i, long j) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(i, j);
        return this;
    }

    public float getFloat() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat();
    }

    public V8ArrayBuffer putFloat(float f) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(f);
        return this;
    }

    public float getFloat(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat(i);
    }

    public V8ArrayBuffer putFloat(int i, float f) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(i, f);
        return this;
    }

    public double getDouble() {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble();
    }

    public V8ArrayBuffer putDouble(double d) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(d);
        return this;
    }

    public double getDouble(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble(i);
    }

    public V8ArrayBuffer putDouble(int i, double d) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(i, d);
        return this;
    }
}
