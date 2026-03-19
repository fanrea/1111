package com.pangrowth.adclog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class w1 extends r1 implements o2 {
    public File b = null;
    public volatile boolean c = false;

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
        return "db";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) throws Throwable {
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (a(jSONObject, p1Var)) {
            return true;
        }
        if (this.c) {
            q2 q2Var = new q2(0L, false, p1Var.c, null);
            q2Var.d = 0;
            q2Var.e = "数据库文件正在处理中";
            n2.a(q2Var);
            return true;
        }
        this.c = true;
        File fileA = null;
        try {
            String strOptString = jSONObject.optString("db_name", "");
            f1.c().getClass();
            fileA = k2.a(f1.f, strOptString);
        } catch (Throwable unused) {
        }
        this.c = false;
        if (fileA == null) {
            a("Sqlite文件拷贝失败", p1Var);
            return true;
        }
        this.b = fileA;
        p2 p2Var = new p2(jSONObject.optString("fileContentType", "default_db_file_type"), 0L, false, p1Var.c, this, null);
        p2Var.k = false;
        p2Var.m = true;
        n2.a(p2Var);
        return true;
    }
}
