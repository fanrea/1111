package com.bytedance.sdk.component.adexpress.d.hc;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.d.b.d;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.component.utils.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b {
    public abstract File d();

    protected boolean d(Map<String, com.bytedance.sdk.component.adexpress.d.b.d> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.d.b.d dVar = map.get(it.next());
            if (dVar != null && !d(dVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    protected boolean d(List<d.C0260d> list) throws IOException {
        if (list == null || list.size() <= 0 || d() == null) {
            return false;
        }
        for (d.C0260d c0260d : list) {
            String strHc = com.bytedance.sdk.component.utils.u.hc(c0260d.d());
            if (TextUtils.isEmpty(strHc)) {
                return false;
            }
            File file = new File(d(), strHc);
            String strD = com.bytedance.sdk.component.utils.u.d(file);
            if (!file.exists() || !file.isFile() || c0260d.hc() == null || !c0260d.hc().equals(strD)) {
                return false;
            }
        }
        return true;
    }

    protected boolean d(d.hc hcVar) {
        if (hcVar == null || d() == null) {
            return false;
        }
        List<Pair<String, String>> listHc = hcVar.hc();
        if (listHc == null || listHc.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listHc.iterator();
        while (it.hasNext()) {
            File file = new File(d(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public List<d.C0260d> d(com.bytedance.sdk.component.adexpress.d.b.d dVar, com.bytedance.sdk.component.adexpress.d.b.d dVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD = dVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapD.size() == 0) {
            if (dVar2 != null && dVar2.d().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD2 = dVar2.d();
                Iterator<String> it = mapD2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.d.b.d dVar3 = mapD2.get(it.next());
                    if (dVar3 != null) {
                        arrayList.addAll(dVar3.getResources());
                    }
                }
            }
        } else if (dVar2 == null || dVar2.d().size() == 0) {
            if (mapD.size() != 0) {
                Iterator<String> it2 = mapD.keySet().iterator();
                while (it2.hasNext()) {
                    com.bytedance.sdk.component.adexpress.d.b.d dVar4 = mapD.get(it2.next());
                    if (dVar4 != null) {
                        arrayList2.addAll(dVar4.getResources());
                    }
                }
            }
        } else {
            Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD3 = dVar2.d();
            for (String str : mapD.keySet()) {
                com.bytedance.sdk.component.adexpress.d.b.d dVar5 = mapD.get(str);
                com.bytedance.sdk.component.adexpress.d.b.d dVar6 = mapD3.get(str);
                if (dVar6 == null && dVar5 != null) {
                    arrayList2.addAll(dVar5.getResources());
                } else if (dVar5 == null && dVar6 != null) {
                    arrayList.addAll(dVar6.getResources());
                } else if (dVar5 != null) {
                    for (d.C0260d c0260d : dVar5.getResources()) {
                        if (c0260d != null && !dVar6.getResources().contains(c0260d) && c0260d.hc() != null && c0260d.d() != null) {
                            arrayList2.add(c0260d);
                        }
                    }
                    for (d.C0260d c0260d2 : dVar6.getResources()) {
                        if (c0260d2 != null && !dVar5.getResources().contains(c0260d2)) {
                            arrayList.add(c0260d2);
                        }
                    }
                }
            }
        }
        if (d(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    private boolean d(List<d.C0260d> list, List<d.C0260d> list2) {
        for (d.C0260d c0260d : list) {
            String strD = c0260d.d();
            String strHc = com.bytedance.sdk.component.utils.u.hc(strD);
            File file = new File(d(), strHc);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.tt.hc.hc hcVarC = com.bytedance.sdk.component.adexpress.d.d.d.d().b().c();
            hcVarC.d(strD);
            hcVarC.d(d().getAbsolutePath(), strHc);
            com.bytedance.sdk.component.tt.hc hcVarD = hcVarC.d();
            list2.add(c0260d);
            if (hcVarD == null || !hcVarD.gb() || hcVarD.h() == null || !hcVarD.h().exists()) {
                b(list2);
                return false;
            }
        }
        return true;
    }

    public List<d.C0260d> hc(com.bytedance.sdk.component.adexpress.d.b.d dVar, com.bytedance.sdk.component.adexpress.d.b.d dVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (dVar2 == null || dVar2.getResources().isEmpty()) {
            arrayList2.addAll(dVar.getResources());
        } else if (dVar.getResources().isEmpty()) {
            arrayList.addAll(dVar2.getResources());
        } else {
            for (d.C0260d c0260d : dVar.getResources()) {
                if (!dVar2.getResources().contains(c0260d) && c0260d != null && c0260d.d() != null && c0260d.hc() != null) {
                    arrayList2.add(c0260d);
                }
            }
            for (d.C0260d c0260d2 : dVar2.getResources()) {
                if (!dVar.getResources().contains(c0260d2)) {
                    arrayList.add(c0260d2);
                }
            }
        }
        if (d(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void hc(List<d.C0260d> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<d.C0260d> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(d(), com.bytedance.sdk.component.utils.u.hc(it.next().d()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public boolean d(String str) {
        File file = new File(d().getAbsoluteFile(), com.bytedance.sdk.component.utils.u.hc(str) + ".zip");
        com.bytedance.sdk.component.tt.hc.hc hcVarC = com.bytedance.sdk.component.adexpress.d.d.d.d().b().c();
        hcVarC.d(str);
        hcVarC.d(file.getParent(), file.getName());
        com.bytedance.sdk.component.tt.hc hcVarD = hcVarC.d();
        if (hcVarD.gb() && hcVarD.h() != null && hcVarD.h().exists()) {
            File fileH = hcVarD.h();
            try {
                s.d(fileH.getAbsolutePath(), file.getParent());
                if (!fileH.exists()) {
                    return true;
                }
                fileH.delete();
                return true;
            } catch (Exception e) {
                mq.d(e);
            }
        }
        return false;
    }

    public void d(int i) {
        if (com.bytedance.sdk.component.adexpress.d.d.d.d().c() != null) {
            com.bytedance.sdk.component.adexpress.d.d.d.d().c().d(i);
        }
    }

    public void b(List<d.C0260d> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<d.C0260d> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(d(), com.bytedance.sdk.component.utils.u.hc(it.next().d()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void d(File file, com.bytedance.sdk.component.adexpress.d.b.d dVar, String str) throws IOException {
        FileOutputStream fileOutputStream;
        if (dVar == null) {
            return;
        }
        String strGb = dVar.gb();
        if (TextUtils.isEmpty(strGb)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(strGb.getBytes("utf-8"));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                mq.b("PlayComponentEngineCacheManager", "version save error3", th);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th3) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static boolean b(com.bytedance.sdk.component.adexpress.d.b.d dVar, com.bytedance.sdk.component.adexpress.d.b.d dVar2) {
        if (dVar != null) {
            try {
                if (!TextUtils.isEmpty(dVar.b())) {
                    if (dVar2 == null) {
                        return false;
                    }
                    if (d(dVar.b(), dVar2.b())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD = dVar.d();
                    Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD2 = dVar2.d();
                    if (mapD.isEmpty()) {
                        return !mapD2.isEmpty();
                    }
                    if (mapD2.isEmpty()) {
                        return false;
                    }
                    return d(mapD, mapD2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean d(Map<String, com.bytedance.sdk.component.adexpress.d.b.d> map, Map<String, com.bytedance.sdk.component.adexpress.d.b.d> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.d.b.d dVar = map.get(str);
            if (dVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.d.b.d dVar2 = map2.get(str);
            if (dVar2 == null) {
                return false;
            }
            if (d(dVar.b(), dVar2.b())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean d(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r7.length
            int r1 = r6.length
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = r1
        L12:
            if (r2 >= r0) goto L42
            r3 = r7[r2]
            int r3 = r3.length()
            r4 = r6[r2]
            int r4 = r4.length()
            int r3 = r3 - r4
            r4 = 1
            if (r3 != 0) goto L3f
            r3 = r7[r2]
            r5 = r6[r2]
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L2f
            return r4
        L2f:
            if (r3 >= 0) goto L32
            return r1
        L32:
            int r3 = r0 + (-1)
            if (r2 != r3) goto L3c
            int r7 = r7.length
            int r6 = r6.length
            if (r7 <= r6) goto L3b
            return r4
        L3b:
            return r1
        L3c:
            int r2 = r2 + 1
            goto L12
        L3f:
            if (r3 <= 0) goto L42
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.d.hc.b.d(java.lang.String, java.lang.String):boolean");
    }

    @Deprecated
    public static boolean d(com.bytedance.sdk.component.adexpress.d.b.d dVar, String str) {
        if (dVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(dVar.b())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return d(dVar.b(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void hc(File file, com.bytedance.sdk.component.adexpress.d.b.d dVar, String str) {
        if (dVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (dVar.getResources() != null) {
            Iterator<d.C0260d> it = dVar.getResources().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.u.hc(it.next().d())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
