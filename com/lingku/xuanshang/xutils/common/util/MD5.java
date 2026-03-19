package com.lingku.xuanshang.xutils.common.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class MD5 {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(File file) throws Throwable {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (NoSuchAlgorithmException e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                IOUtil.closeQuietly((Closeable) null);
                IOUtil.closeQuietly((Closeable) null);
                throw th;
            }
            try {
                FileChannel channel = fileInputStream.getChannel();
                messageDigest.update(channel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                byte[] bArrDigest = messageDigest.digest();
                IOUtil.closeQuietly(fileInputStream);
                IOUtil.closeQuietly(channel);
                return toHexString(bArrDigest);
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                throw new RuntimeException(e);
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtil.closeQuietly((Closeable) null);
            IOUtil.closeQuietly((Closeable) null);
            throw th;
        }
    }

    public static String md5(String str) {
        try {
            return toHexString(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = a;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }
}
