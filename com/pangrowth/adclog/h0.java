package com.pangrowth.adclog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h0 {
    public static final h0 m;
    public static final String[] n = {com.baidu.mobads.container.components.j.a.b, "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
    public final File a;
    public final i0 b;
    public final Map<String, a> c = new HashMap();
    public final File d;
    public volatile boolean e;
    public File f;
    public ZipFile[] g;
    public String h;
    public ApplicationInfo i;
    public Map<String, String> j;
    public String[] k;
    public String l;

    public static class a {
        public boolean a = false;

        public String toString() {
            return Boolean.toString(this.a);
        }
    }

    public class b {
        public RandomAccessFile a;
        public FileLock b;
        public FileChannel c;
        public File d;

        public b(File file) {
            this.d = file;
        }

        public void a() throws IOException {
            FileLock fileLock = this.b;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                }
            }
            i0 i0Var = h0.this.b;
            String str = "released lock " + this.d.getPath();
            i0Var.getClass();
            Log.d("librarian", str);
            h0.this.a(this.c);
            h0.this.a(this.a);
        }

        public void b() throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.d, "rw");
            this.a = randomAccessFile;
            try {
                this.c = randomAccessFile.getChannel();
                try {
                    i0 i0Var = h0.this.b;
                    String str = "blocking on lock " + this.d.getPath();
                    i0Var.getClass();
                    Log.d("librarian", str);
                    this.b = this.c.lock();
                    i0 i0Var2 = h0.this.b;
                    String str2 = "acquired on lock " + this.d.getPath();
                    i0Var2.getClass();
                    Log.d("librarian", str2);
                } catch (IOException e) {
                    h0.this.a(this.c);
                    throw e;
                }
            } catch (IOException e2) {
                h0.this.a(this.a);
                throw e2;
            }
        }
    }

    static {
        Context context = g0.a;
        g0.a = null;
        if (context == null) {
            throw new j0("you should call init first or use loadLibraryForModule.");
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        File dir = context.getDir("librarian", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, "default.version." + (new File(applicationInfo.sourceDir).lastModified() >> 8));
        File[] fileArrListFiles = dir.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (!file.getName().equals(file2.getName())) {
                    File[] fileArrListFiles2 = file2.listFiles();
                    if (fileArrListFiles2 != null) {
                        for (File file3 : fileArrListFiles2) {
                            file3.delete();
                        }
                    }
                    file2.delete();
                }
            }
        }
        file.mkdirs();
        m = file.exists() ? new h0(applicationInfo, file, new i0()) : null;
    }

    public h0(ApplicationInfo applicationInfo, File file, i0 i0Var) {
        this.a = file;
        this.b = i0Var;
        this.i = applicationInfo;
        this.d = new File(file, "process.lock");
    }

    public final void a() {
        String[] strArr;
        if (this.e) {
            return;
        }
        synchronized (this) {
            if (!this.e) {
                File file = new File(this.i.sourceDir);
                ArrayList arrayList = new ArrayList();
                arrayList.add(file);
                if (Build.VERSION.SDK_INT >= 21 && (strArr = this.i.splitSourceDirs) != null && strArr.length != 0) {
                    for (String str : strArr) {
                        arrayList.add(new File(str));
                    }
                }
                ZipFile[] zipFileArr = new ZipFile[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    int i2 = i + 1;
                    try {
                        zipFileArr[i] = new ZipFile(file2);
                    } catch (IOException e) {
                        new j0("fail to get zip file " + file2.getName(), e).printStackTrace();
                    }
                    i = i2;
                }
                this.g = zipFileArr;
                this.f = new File(this.i.nativeLibraryDir);
                HashMap map = new HashMap();
                this.j = map;
                map.put("arm64-v8a", "arm64");
                this.j.put("armeabi-v7a", "arm");
                this.j.put("armeabi", "arm");
                String str2 = null;
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                        str2 = (String) cls.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);
                    } catch (Exception e2) {
                        this.b.getClass();
                        Log.w("librarian", "fail to get vm instruction set", e2);
                    }
                }
                this.h = str2;
                i0 i0Var = this.b;
                String str3 = "vm instruction set: " + this.h;
                i0Var.getClass();
                Log.d("librarian", str3);
                this.k = Build.VERSION.SDK_INT < 21 ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : Build.SUPPORTED_ABIS;
                this.e = true;
            }
        }
    }

    public final boolean b(File file) throws IOException {
        a(file.getName());
        String str = "lib/" + this.l + "/" + file.getName();
        for (ZipFile zipFile : this.g) {
            ZipEntry entry = zipFile.getEntry(str);
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                try {
                    a(inputStream, file);
                    i0 i0Var = this.b;
                    String str2 = "get lib file " + file.getPath() + " from " + str + " of " + zipFile.getName();
                    i0Var.getClass();
                    Log.d("librarian", str2);
                    a(inputStream);
                    return true;
                } catch (Throwable th) {
                    a(inputStream);
                    throw th;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ee  */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.pangrowth.adclog.h0] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.io.File r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.h0.a(java.io.File):boolean");
    }

    public final void a(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            this.b.getClass();
            Log.w("librarian", "failed to close resource", e);
        }
    }

    public final void a(String str) {
        boolean zEquals;
        if (this.l != null) {
            return;
        }
        for (String str2 : this.k) {
            if (this.h == null) {
                zEquals = true;
            } else {
                String str3 = this.j.get(str2);
                String str4 = this.h;
                if (str3 == null) {
                    str3 = str2;
                }
                zEquals = str4.equals(str3);
            }
            if (zEquals) {
                String str5 = "lib/" + str2 + "/" + str;
                for (ZipFile zipFile : this.g) {
                    if (zipFile.getEntry(str5) != null) {
                        this.l = str2;
                        this.b.getClass();
                        Log.d("librarian", "ensure that abi is " + str2);
                        return;
                    }
                }
            }
        }
        StringBuilder sbAppend = new StringBuilder().append("can not ensure abi for ").append(str).append(", check ").append(this.h).append(", apks ");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ZipFile zipFile2 : this.g) {
            String name = zipFile2.getName();
            sb.append(name).append("#").append(zipFile2.size()).append(":").append(new File(name).length()).append(" ");
        }
        sb.append("]");
        throw new j0(sbAppend.append(sb.toString()).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0184 A[Catch: IOException -> 0x021f, all -> 0x0228, TryCatch #5 {IOException -> 0x021f, blocks: (B:56:0x0177, B:57:0x017e, B:59:0x0184, B:61:0x019b, B:64:0x01a5, B:66:0x01aa, B:78:0x021b, B:79:0x021e), top: B:97:0x016b, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.h0.a(java.lang.String, boolean):void");
    }

    public final File a(InputStream inputStream, File file) throws IOException {
        File fileCreateTempFile = File.createTempFile("tmp-", file.getName(), file.getParentFile());
        i0 i0Var = this.b;
        String str = "extracting " + fileCreateTempFile.getPath();
        i0Var.getClass();
        Log.d("librarian", str);
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            }
            if (!fileCreateTempFile.setReadOnly()) {
                throw new IOException("failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            }
            i0 i0Var2 = this.b;
            String str2 = "renaming to " + file.getPath();
            i0Var2.getClass();
            Log.d("librarian", str2);
            if (fileCreateTempFile.renameTo(file)) {
                return file;
            }
            throw new IOException("failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } finally {
            a(fileOutputStream);
            fileCreateTempFile.delete();
        }
    }
}
