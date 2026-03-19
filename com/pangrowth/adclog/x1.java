package com.pangrowth.adclog;

import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class x1 extends r1 {
    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "data_clear";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) {
        File file;
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (a(jSONObject, p1Var)) {
            return true;
        }
        String strA = s2.a(jSONObject.optString("rootNode"), jSONObject.optString("relativeDirName"));
        String str = null;
        if (TextUtils.isEmpty(strA)) {
            file = null;
            str = "目录名为空";
        } else {
            file = new File(strA);
            if (!file.exists()) {
                str = "文件/目录不存在";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            a(str, p1Var);
            return true;
        }
        boolean zA = false;
        int iOptInt = jSONObject.optInt("deleteStrategy", 0);
        if (iOptInt == 0) {
            zA = file.isDirectory() ? s2.a(file.getAbsolutePath()) : file.delete();
        } else {
            if (iOptInt != 1) {
                a("数据清理策略不合法", p1Var);
                return true;
            }
            long jOptLong = jSONObject.optLong("expiration_time", -1L);
            if (jOptLong < 0) {
                a("数据清理过期时间为空", p1Var);
            } else if (file.isDirectory()) {
                boolean z = true;
                for (File file2 : file.listFiles()) {
                    if (file2.lastModified() < jOptLong * 1000) {
                        z = z && file.delete();
                    }
                }
                zA = z;
            } else if (file.lastModified() >= jOptLong * 1000 || file.delete()) {
            }
            zA = true;
        }
        if (zA) {
            c(p1Var);
        } else {
            a("数据删除失败(部分文件执行delete操作失败)", p1Var);
        }
        return true;
    }
}
