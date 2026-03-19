package com.pangrowth.adclog;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class y1 extends r1 implements o2 {
    public static final String[] d = {"/system/lib", "/system/lib64", "/vender/lib", "/vender/lib64", " /apex/com.android.runtime/lib", " /apex/com.android.runtime/lib64"};
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
        return "new_file";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) throws Throwable {
        File file;
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (a(jSONObject, p1Var)) {
            return true;
        }
        if (System.currentTimeMillis() - this.c < 300000) {
            return false;
        }
        this.c = System.currentTimeMillis();
        String strOptString = jSONObject.optString("rootNode");
        String strOptString2 = jSONObject.optString("relativeFilename");
        if (!"systemlib_so".equals(strOptString)) {
            String strA = s2.a(strOptString, strOptString2);
            if (TextUtils.isEmpty(strA)) {
                str2 = "文件名为空";
                str = str2;
                file = null;
            } else {
                file = new File(strA);
                str = !file.exists() ? "文件/目录不存在" : (file.isDirectory() || (file.canRead() && file.canWrite())) ? null : "该文件没有读/写权限";
            }
        } else if (strOptString2.endsWith(".so")) {
            String strA2 = s2.a("data_package_file", "/" + p1Var.c);
            new File(strA2).mkdir();
            for (String str3 : d) {
                String str4 = str3 + strOptString2;
                File file2 = new File(str4);
                if (file2.exists() && file2.canRead() && !file2.canWrite()) {
                    String[] strArrSplit = str3.split("/");
                    String str5 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
                    String[] strArrSplit2 = strOptString2.split("/");
                    s2.a(str4, strA2, "/" + str5 + Config.replace + (strArrSplit2.length > 0 ? strArrSplit2[strArrSplit2.length - 1] : strOptString2));
                }
            }
            s2.a(strA2 + ".zip", strA2);
            s2.a(strA2);
            file = new File(strA2 + ".zip");
        } else {
            str2 = "非so文件无权回捞";
            str = str2;
            file = null;
        }
        if (!TextUtils.isEmpty(str)) {
            a(str, p1Var);
            return true;
        }
        this.b = file;
        p2 p2Var = new p2(jSONObject.optString("fileContentType", "unknown"), 0L, false, p1Var.c, this, null);
        p2Var.k = true;
        n2.a(p2Var);
        if ("systemlib_so".equals(strOptString)) {
            this.b.delete();
        }
        return true;
    }
}
