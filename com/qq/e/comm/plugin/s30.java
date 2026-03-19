package com.qq.e.comm.plugin;

import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class s30 {
    private static volatile JSONObject a;

    private static List<a> b(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new a(jSONObject.getInt("v"), jSONObject.getString("s")));
        }
        return arrayList;
    }

    /* compiled from: A */
    private static final class a {
        private final int a;
        private final String b;

        public a(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public int b() {
            return this.a;
        }

        public String a() {
            return this.b;
        }
    }

    private static JSONObject a(byte[] bArr, List<a> list) throws Exception {
        JSONObject jSONObject = new JSONObject(new String(bArr, 0, bArr.length, "UTF-8"));
        int i = jSONObject.getInt("v");
        String string = jSONObject.getString(com.kuaishou.weapon.p0.t.i);
        long j = jSONObject.getLong("t");
        String string2 = jSONObject.getString("m");
        for (a aVar : list) {
            if (aVar.a == i) {
                String strA = a(aVar, string, j);
                if (string2.equals(strA)) {
                    return jSONObject;
                }
                throw new Exception("file signature:" + string2 + " not match calculate signature:" + strA);
            }
        }
        throw new Exception("file version not exist:" + i);
    }

    private static String a(a aVar, String str, long j) throws Exception {
        return gp.a(String.format("%s%d%d%s", str, Integer.valueOf(aVar.b()), Long.valueOf(j), aVar.a())).toUpperCase();
    }

    private static byte[] a(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileLockLock = randomAccessFile.getChannel().lock();
            long length = randomAccessFile.length();
            if (length > 10240) {
                length = 10240;
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            int i2 = randomAccessFile.read(bArr, 0, i);
            if (i2 == i) {
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused) {
                    }
                }
                randomAccessFile.close();
                return bArr;
            }
            throw new Exception("read file length：" + i2 + "file length:" + i + " not match " + file.getAbsolutePath());
        } catch (Throwable th2) {
            th = th2;
            if (fileLockLock != null) {
                try {
                    fileLockLock.release();
                } catch (IOException unused2) {
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
                throw th;
            }
            throw th;
        }
    }

    private static void a(File file, String str, byte[] bArr) throws Exception {
        Throwable th;
        RandomAccessFile randomAccessFile;
        if (!file.exists()) {
            file.mkdirs();
        }
        FileLock fileLock = null;
        try {
            randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
            try {
                FileLock fileLockLock = randomAccessFile.getChannel().lock();
                try {
                    randomAccessFile.setLength(0L);
                    randomAccessFile.write(bArr);
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileLock = fileLockLock;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static synchronized JSONObject a(String str) {
        if (a != null) {
            return a;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "Tencent/ams/cache");
        File file2 = new File(Environment.getExternalStorageDirectory(), "Android/data/com.tencent.ams/cache");
        char c = 0;
        byte[] bytes = null;
        try {
            List<a> listB = b(str);
            try {
                bytes = a(new File(file, "meta.dat"));
                a = a(bytes, listB);
            } catch (Exception unused) {
            }
            if (a != null) {
                c = 2;
            } else {
                try {
                    bytes = a(new File(file2, "meta.dat"));
                    a = a(bytes, listB);
                } catch (Exception unused2) {
                }
                if (a != null) {
                    c = 1;
                } else {
                    a aVar = listB.get(listB.size() - 1);
                    a = a(aVar);
                    qm$h$$ExternalSyntheticBackport0.m(a);
                    qm$h$$ExternalSyntheticBackport0.m(aVar);
                    bytes = a.toString().getBytes("UTF-8");
                    c = 3;
                }
            }
        } catch (JSONException | Exception unused3) {
        }
        if (bytes != null && c != 0) {
            if ((c & 1) != 0) {
                try {
                    a(file, "meta.dat", bytes);
                } catch (Exception unused4) {
                    if (c == 3) {
                        a = new JSONObject();
                    }
                }
            }
            if ((c & 2) != 0) {
                a(file2, "meta.dat", bytes);
            }
        }
        return a;
    }

    private static JSONObject a(a aVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        String string = UUID.randomUUID().toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        jSONObject.put("v", aVar.a);
        jSONObject.put(com.kuaishou.weapon.p0.t.i, string);
        jSONObject.put("t", jCurrentTimeMillis);
        jSONObject.put("m", a(aVar, string, jCurrentTimeMillis));
        return jSONObject;
    }
}
