package com.pangrowth.adclog;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m2 {
    public Map<String, Boolean> a = new HashMap();
    public volatile File b;

    public class a implements FileFilter {
        public a(m2 m2Var) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isFile();
        }
    }

    public static class b {
        public static final m2 a = new m2();
    }

    public static m2 a() {
        return b.a;
    }

    public void b() {
        this.b = new File(v.a.getFilesDir(), "cloud_uploading");
    }

    public synchronized void a(p1 p1Var, File file, String str) {
        i.a(p1Var.c, "命令产物已生成，等待上传", 0, (Map<String, String>) null);
        if (!this.b.exists()) {
            this.b.mkdirs();
        }
        String str2 = p1Var.c;
        File file2 = new File(this.b, str2);
        if (file2.exists()) {
            file2.delete();
        }
        file.renameTo(file2);
        long jA = c0.a(file2);
        boolean z = p1Var.d.optBoolean("wifiOnly") && jA > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        this.a.put(str2, Boolean.valueOf(z));
        if (z) {
            f1.c().getClass();
            if (!t2.a(f1.f)) {
                i.a(p1Var.c, "产物超过阈值，等待WiFi环境执行. fileTotalSize=" + jA, 0, (Map<String, String>) null);
                return;
            }
        }
        File[] fileArrListFiles = file2.listFiles(new a(this));
        int length = fileArrListFiles.length;
        int i = 0;
        boolean z2 = true;
        while (i < length) {
            File file3 = fileArrListFiles[i];
            String str3 = "正在上传:" + file3.getName();
            if (v.a()) {
                Log.d("cloudmessage", a0.a(new String[]{"postFile: commandId=" + str2, "postFile=" + file3.getAbsolutePath(), ", uploadMessage=" + str3, ", fileType=" + str}));
            }
            int i2 = i;
            int i3 = length;
            boolean zA = r2.a("https://mon.snssdk.com/monitor/collect/c/cloudcontrol/file", file3, 1, str, str2, str3, System.currentTimeMillis(), null);
            i.a(p1Var.c, "文件上传" + (zA ? "成功" : "失败") + ":" + file3.getName(), 0, (Map<String, String>) null);
            if (!zA) {
                z2 = false;
            }
            i = i2 + 1;
            length = i3;
        }
        if (z2) {
            i.a(str2, "上传成功", 2, (Map<String, String>) null);
        }
    }
}
