package com.bytedance.pangle.res.d;

import java.io.DataInput;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class an implements DataInput {
    public final tt d;

    public an(tt ttVar) {
        this.d = ttVar;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return this.d.skipBytes(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.d.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.d.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.d.readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.d.readShort();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.d.readLong();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.d.readLine();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.d.readInt();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.d.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.d.readFully(bArr);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.d.readFloat();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.d.readDouble();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.d.readChar();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.d.readByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.d.readBoolean();
    }
}
