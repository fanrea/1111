package com.bytedance.pangle.util.hc.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private final byte[] d = new byte[2];
    private final byte[] hc = new byte[4];

    public int d(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.hc);
        return hc(this.hc);
    }

    public int hc(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.d);
        return d(this.d);
    }

    public void d(RandomAccessFile randomAccessFile, int i) throws IOException {
        d(this.d, i);
        randomAccessFile.write(this.d);
    }

    public void d(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        d(this.d, i);
        byteArrayOutputStream.write(this.d);
    }

    public void d(OutputStream outputStream, int i) throws IOException {
        hc(this.hc, i);
        outputStream.write(this.hc);
    }

    private int d(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    private int hc(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    private void d(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    private void hc(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
