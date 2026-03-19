package com.baidu.mobads.container;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static c a;
    private static String e = ":";
    private String b;
    private boolean c = false;
    private HashMap<String, String> d = new HashMap<>();

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                a = new c();
            }
        }
        return a;
    }

    public void a(Context context) {
        if (context == null || this.c) {
            return;
        }
        try {
            com.baidu.mobads.container.d.b.a().a((com.baidu.mobads.container.d.a) new d(this, context), 2);
        } catch (Throwable th) {
        }
    }

    public String a(String str) {
        return this.d.get(str);
    }

    public void a(String str, String str2) {
        this.d.put(str, str2);
        try {
            com.baidu.mobads.container.d.b.a().a(new e(this), 3L, TimeUnit.SECONDS);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, HashMap<String, String> map) {
        BufferedWriter bufferedWriter;
        Writer writer = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Throwable th) {
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bufferedWriter.write(String.format("%s%s%s\n", entry.getKey(), e, entry.getValue()));
            }
            a(bufferedWriter);
        } catch (Throwable th2) {
            writer = bufferedWriter;
            a(writer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, HashMap<String, String> map) {
        Reader reader = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    String line = bufferedReader.readLine();
                    int iIndexOf = line.indexOf(e);
                    if (iIndexOf > 0) {
                        map.put(line.substring(0, iIndexOf), line.substring(iIndexOf + 1));
                    }
                    a(bufferedReader);
                    return true;
                } catch (Throwable th) {
                    reader = bufferedReader;
                    a(reader);
                    return false;
                }
            }
            a((Reader) null);
            return true;
        } catch (Throwable th2) {
        }
    }

    private void a(Writer writer) {
        try {
            writer.close();
        } catch (Throwable th) {
        }
    }

    private void a(Reader reader) {
        try {
            reader.close();
        } catch (Throwable th) {
        }
    }
}
