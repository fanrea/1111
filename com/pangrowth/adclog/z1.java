package com.pangrowth.adclog;

import android.os.Debug;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class z1 extends r1 implements o2 {
    public File b = null;
    public long c = 0;

    @Override // com.pangrowth.adclog.o2
    public List<String> a() {
        ArrayList arrayList = new ArrayList(1);
        File file = this.b;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "heap_oom";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) throws Throwable {
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (a(jSONObject, p1Var)) {
            return true;
        }
        if (System.currentTimeMillis() - this.c < 300000) {
            return false;
        }
        this.c = System.currentTimeMillis();
        boolean zOptBoolean = jSONObject.optBoolean("isTryToCatch", false);
        String str = f1.j;
        if (TextUtils.isEmpty(str)) {
            a("本地未设置dumpFileName", p1Var);
            return true;
        }
        if (zOptBoolean) {
            try {
                Debug.dumpHprofData(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = new File(str);
        String str2 = TextUtils.isEmpty(str) ? "本地未设置dumpFileName" : null;
        if (!file.exists()) {
            str2 = "dumpFile不存在";
        }
        if (!TextUtils.isEmpty(str2)) {
            a(str2, p1Var);
            return true;
        }
        this.b = file;
        p2 p2Var = new p2("log_heap_oom", 0L, false, p1Var.c, this, null);
        p2Var.k = true;
        n2.a(p2Var);
        return true;
    }
}
