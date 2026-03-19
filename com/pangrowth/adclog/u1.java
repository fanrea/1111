package com.pangrowth.adclog;

import com.pangrowth.adclog.m2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u1 extends r1 {
    public i1 b;
    public List<String> c = new ArrayList();
    public volatile long d = 0;

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "alog";
    }

    @Override // com.pangrowth.adclog.r1
    public synchronized boolean b(p1 p1Var) {
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (this.b == null) {
            i.a(p1Var.c, "未设置ALog回捞处理组件", 3, (Map<String, String>) null);
            return false;
        }
        if (System.currentTimeMillis() - this.d < 180000) {
            q2 q2Var = new q2(0L, false, p1Var.c, null);
            q2Var.d = 0;
            q2Var.e = "3分钟内不重复执行alog回捞";
            n2.a(q2Var);
            return false;
        }
        this.d = System.currentTimeMillis();
        List<String> listA = this.b.a(jSONObject.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000), jSONObject.optLong("fetch_end_time", System.currentTimeMillis() / 1000), jSONObject);
        q1 q1VarA = this.b.a();
        if (listA == null || listA.size() == 0) {
            i1 i1Var = this.b;
            if ((i1Var instanceof h1) && (listA = ((h1) i1Var).b()) != null && listA.size() != 0) {
                q1VarA = new q1(true, "兜底策略数据", q1VarA.c);
            }
        }
        if (listA != null && listA.size() != 0 && q1VarA.a) {
            this.c.clear();
            this.c.addAll(listA);
            m2 m2Var = m2.b.a;
            if (!m2Var.b.exists()) {
                m2Var.b.mkdirs();
            }
            File file = new File(m2Var.b, p1Var.c + "temp");
            if (file.exists()) {
                file.delete();
            }
            file.mkdirs();
            File file2 = new File(file, p1Var.c + "-cloudMsg.zip");
            if (file2.exists()) {
                file2.delete();
            }
            String[] strArr = (String[]) listA.toArray(new String[listA.size()]);
            s2.a(file2.getAbsolutePath(), strArr);
            i.a(p1Var.c, "Alog回捞:" + Arrays.toString(strArr) + " ErrMsg=" + q1VarA.b, 0, q1VarA.c);
            m2Var.a(p1Var, file, "log_agile");
        } else if (!q1VarA.a) {
            a(q1VarA.b, q1VarA.c, p1Var);
        }
        return true;
    }
}
