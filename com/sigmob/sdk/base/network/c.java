package com.sigmob.sdk.base.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    public static byte[] a(byte[] bytes) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(bytes);
        byte[] bArr = new byte[1024];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (!inflater.finished()) {
                try {
                    byteArrayOutputStream.write(bArr, 0, inflater.inflate(bArr));
                } finally {
                }
            }
            inflater.end();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bytes) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(bytes);
        deflater.finish();
        byte[] bArr = new byte[1024];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
                } finally {
                }
            }
            deflater.end();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
