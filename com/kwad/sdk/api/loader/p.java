package com.kwad.sdk.api.loader;

import aegon.chrome.net.NetError;
import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p {
    public static String bn(Context context) {
        q qVarVW = r.VW();
        if (qVarVW != null) {
            return qVarVW.getAESKey(context);
        }
        return null;
    }

    public static int a(String str, InputStream inputStream, String str2) throws Throwable {
        try {
            boolean zA = a(str, o.decrypt(str2.getBytes("UTF-8"), b(inputStream)));
            boolean zB = b(inputStream, str, true);
            if (zA && zB) {
                return 1;
            }
            return zA ? -104 : -103;
        } catch (UnsupportedEncodingException unused) {
            return NetError.ERR_CONNECTION_REFUSED;
        }
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
            int iF = f(bArr);
            byte[] bArr2 = new byte[iF];
            int i = inputStream.read(bArr2, 0, iF);
            if (i > 0) {
                System.out.println("readEncryptedByteArray bytes content: " + i);
                return bArr2;
            }
            System.out.println("readEncryptedByteArray File is empty.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    System.out.println("writeEncryptedByteToFile successfully.");
                    closeQuietly(fileOutputStream2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean b(InputStream inputStream, String str, boolean z) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str, true);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            System.out.println("File copied successfully.");
                            closeQuietly(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private static int f(byte[] bArr) {
        int i = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        System.out.println("Converted int: " + Integer.toHexString(i));
        return i;
    }

    private static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
