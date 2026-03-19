package com.tkruntime.v8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8TypedArray extends V8Array {
    public V8TypedArray(V8 v8, long j) {
        super(v8, j);
    }

    @Override // com.tkruntime.v8.V8Array
    public Object get(int i) {
        this.v8.checkThread();
        checkReleased();
        int type = getType();
        if (type == 1) {
            return super.get(i);
        }
        if (type == 2) {
            return super.get(i);
        }
        if (type == 9) {
            return Byte.valueOf(((Number) super.get(i)).byteValue());
        }
        switch (type) {
            case 11:
                return Short.valueOf((short) (((Number) super.get(i)).shortValue() & 255));
            case 12:
                return Short.valueOf((short) (((Number) super.get(i)).byteValue() & 255));
            case 13:
                return Short.valueOf(((Number) super.get(i)).shortValue());
            case 14:
                return Integer.valueOf(((Integer) super.get(i)).intValue() & 65535);
            case 15:
                return Long.valueOf((-1) & ((Number) super.get(i)).longValue());
            case 16:
                return Float.valueOf(((Number) super.get(i)).floatValue());
            default:
                return null;
        }
    }

    public V8ArrayBuffer getBuffer() {
        return (V8ArrayBuffer) get("buffer");
    }

    public static int getStructureSize(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 8;
        }
        if (i != 9) {
            switch (i) {
                case 11:
                case 12:
                    break;
                case 13:
                case 14:
                    return 2;
                case 15:
                case 16:
                    return 4;
                default:
                    throw new IllegalArgumentException("Cannot create a typed array of type = " + i);
            }
        }
        return 1;
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        checkOffset(v8ArrayData);
        checkSize(v8ArrayData);
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        if (v8ArrayData.size < 0) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        }
        if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset > v8ArrayData.buffer.limit()) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        }
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        if (v8ArrayData.offset % getStructureSize(v8ArrayData.type) == 0) {
            return;
        }
        throw new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
    }

    static class V8ArrayData {
        private V8ArrayBuffer buffer;
        private int offset;
        private int size;
        private int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
            this.buffer = v8ArrayBuffer;
            this.offset = i;
            this.size = i2;
            this.type = i3;
        }
    }
}
