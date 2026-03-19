package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.entity.Header;
import com.pandora.common.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class t {
    private static t a;
    private File b;
    private File c;
    private File d;
    private Context e;
    private a f = null;

    private static class a {
        private long a;
        private long b;
        private File c;
        private JSONObject d;

        private a(File file) throws NumberFormatException {
            long j;
            this.d = null;
            this.c = file;
            String name = file.getName();
            int iIndexOf = name.indexOf("-");
            if (iIndexOf > 0) {
                this.a = Long.parseLong(name.substring(0, iIndexOf));
                j = Long.parseLong(name.substring(iIndexOf + 1, name.lastIndexOf(".")));
            } else {
                j = 0;
                this.a = 0L;
            }
            this.b = j;
        }

        private String a() {
            return this.a + "-" + this.b + ".ctx";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.b = j;
            this.c.renameTo(new File(this.c.getParent(), a()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject b() {
            if (this.d == null) {
                try {
                    this.d = new JSONObject(com.apm.insight.o.j.c(this.c.getAbsolutePath()));
                } catch (Throwable unused) {
                }
                if (this.d == null) {
                    this.d = new JSONObject();
                }
            }
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(long j) {
            long j2 = this.a;
            if (j2 > j && j2 - j > 604800000) {
                return true;
            }
            long j3 = this.b;
            if (j3 >= j || j - j3 <= 604800000) {
                return this.c.lastModified() < j && j - this.c.lastModified() > 604800000;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.c.delete();
        }
    }

    private t(Context context) {
        File fileC = com.apm.insight.o.p.c(context);
        if (!fileC.exists() || (!fileC.isDirectory() && fileC.delete())) {
            fileC.mkdirs();
            com.apm.insight.runtime.a.b.a();
        }
        this.b = fileC;
        this.c = new File(fileC, Constants.APPLog.DEVICE_ID);
        this.d = new File(fileC, "device_uuid");
        this.e = context;
    }

    public static int a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (Header.c(jSONObject)) {
            return 2;
        }
        if (Header.c(jSONObject2)) {
            return 0;
        }
        return (String.valueOf(jSONObject2.opt("update_version_code")).equals(String.valueOf(jSONObject.opt("update_version_code"))) && Header.d(jSONObject)) ? 1 : 2;
    }

    public static t a() {
        if (a == null) {
            a = new t(com.apm.insight.g.f());
        }
        return a;
    }

    private void a(long j, long j2, JSONObject jSONObject, JSONArray jSONArray) {
        File file = new File(this.b, "" + j + "-" + j2 + ".ctx");
        File file2 = new File(this.b, "" + j + "-" + j2 + ".allData");
        try {
            com.apm.insight.o.j.a(file, jSONObject, false);
            com.apm.insight.o.j.a(file2, jSONArray, false);
            this.f = new a(file);
        } catch (Exception e) {
            com.apm.insight.b.a().a("NPTH_CATCH", e);
        }
    }

    private a c() {
        if (this.f == null) {
            d(".ctx");
        }
        return this.f;
    }

    private void c(long j) {
        try {
            ArrayList<a> arrayListD = d("");
            if (arrayListD.size() <= 6) {
                return;
            }
            Iterator<a> it = arrayListD.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.b(j)) {
                    next.c();
                }
            }
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
    }

    private File d(long j) {
        Iterator<a> it = d(".ctx").iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j >= next.a && j <= next.b) {
                return next.c;
            }
        }
        return null;
    }

    private ArrayList<a> d(final String str) {
        File[] fileArrListFiles = this.b.listFiles(new FilenameFilter() { // from class: com.apm.insight.runtime.t.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return str2.endsWith(str);
            }
        });
        ArrayList<a> arrayList = new ArrayList<>();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        com.apm.insight.o.q.a((Object) ("foundRuntimeContextFiles " + fileArrListFiles.length));
        a aVar = null;
        for (File file : fileArrListFiles) {
            try {
                a aVar2 = new a(file);
                arrayList.add(aVar2);
                if (this.f == null && ".ctx".equals(str) && (aVar == null || aVar2.b >= aVar.b)) {
                    aVar = aVar2;
                }
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.f == null && aVar != null) {
            this.f = aVar;
        }
        return arrayList;
    }

    private File e(long j) {
        Iterator<a> it = d(".allData").iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j >= next.a && j <= next.b) {
                return next.c;
            }
        }
        return null;
    }

    private File f(long j) {
        Iterator<a> it = d(".ctx").iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (aVar == null || Math.abs(aVar.b - j) > Math.abs(next.b - j)) {
                aVar = next;
            }
        }
        if (aVar == null) {
            return null;
        }
        return aVar.c;
    }

    private File g(long j) {
        Iterator<a> it = d(".allData").iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (aVar == null || Math.abs(aVar.b - j) > Math.abs(next.b - j)) {
                aVar = next;
            }
        }
        if (aVar == null) {
            return null;
        }
        return aVar.c;
    }

    public String a(String str) {
        try {
            return com.apm.insight.o.j.c(this.d.getAbsolutePath());
        } catch (Throwable unused) {
            return str;
        }
    }

    public JSONObject a(long j) {
        boolean z;
        String strC;
        File fileD = d(j);
        if (fileD == null) {
            fileD = f(j);
            z = true;
        } else {
            z = false;
        }
        JSONObject jSONObject = null;
        if (fileD != null) {
            try {
                strC = com.apm.insight.o.j.c(fileD.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
                strC = null;
            }
            try {
                jSONObject = new JSONObject(strC);
            } catch (Throwable th2) {
                th = th2;
                com.apm.insight.b.a().a("NPTH_CATCH", new IOException("content :" + strC, th));
                if (jSONObject != null) {
                    try {
                        jSONObject.put("unauthentic_version", 1);
                    } catch (JSONException e) {
                        com.apm.insight.b.a().a("NPTH_CATCH", e);
                    }
                }
                return jSONObject;
            }
        }
        if (jSONObject != null && z) {
            jSONObject.put("unauthentic_version", 1);
        }
        return jSONObject;
    }

    public void a(Map<String, Object> map, JSONArray jSONArray) {
        JSONObject jSONObjectA = Header.a(this.e).a(map);
        if (Header.c(jSONObjectA)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        a aVarC = c();
        if (aVarC == null) {
            a(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectA, jSONArray);
            return;
        }
        int iA = a(aVarC.b(), jSONObjectA);
        if (iA == 1) {
            a(aVarC.a, jCurrentTimeMillis, jSONObjectA, jSONArray);
            com.apm.insight.o.j.a(aVarC.c);
        } else if (iA == 2) {
            a(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectA, jSONArray);
        } else if (iA == 3) {
            aVarC.a(jCurrentTimeMillis);
        }
        c(jCurrentTimeMillis);
    }

    protected String b() {
        try {
            return com.apm.insight.o.j.c(this.c.getAbsolutePath());
        } catch (Throwable unused) {
            return "0";
        }
    }

    public JSONArray b(long j) {
        String strC;
        File fileE = e(j);
        if (fileE == null) {
            fileE = g(j);
        }
        if (fileE == null) {
            return null;
        }
        try {
            strC = com.apm.insight.o.j.c(fileE.getAbsolutePath());
        } catch (Throwable th) {
            th = th;
            strC = null;
        }
        try {
            return new JSONArray(strC);
        } catch (Throwable th2) {
            th = th2;
            com.apm.insight.b.a().a("NPTH_CATCH", new IOException("content :" + strC, th));
            return null;
        }
    }

    protected void b(String str) {
        try {
            com.apm.insight.o.j.a(this.c, str, false);
        } catch (Throwable unused) {
        }
    }

    public void c(String str) {
        try {
            com.apm.insight.o.j.a(this.d, str, false);
        } catch (Throwable unused) {
        }
    }
}
