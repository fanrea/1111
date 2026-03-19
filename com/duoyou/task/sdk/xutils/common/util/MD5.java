package com.duoyou.task.sdk.xutils.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class MD5 {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5() {
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = hexDigits;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String md5(File file) throws Throwable {
        FileChannel fileChannel;
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        FileChannel channel = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (NoSuchAlgorithmException e) {
            e = e;
            fileChannel = null;
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            channel = fileInputStream.getChannel();
            messageDigest.update(channel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
            byte[] bArrDigest = messageDigest.digest();
            IOUtil.closeQuietly(fileInputStream);
            IOUtil.closeQuietly(channel);
            return toHexString(bArrDigest);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            fileChannel = channel;
            channel = fileInputStream;
            try {
                throw new RuntimeException(e);
            } catch (Throwable th2) {
                th = th2;
                IOUtil.closeQuietly(channel);
                IOUtil.closeQuietly(fileChannel);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = channel;
            channel = fileInputStream;
            IOUtil.closeQuietly(channel);
            IOUtil.closeQuietly(fileChannel);
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
}
