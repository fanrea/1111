package com.alliance.ssp.ad.t;

import android.content.Context;
import android.content.SharedPreferences;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceAdEncryptData;
import com.alliance.ssp.ad.o0.l;
import com.google.gson.Gson;
import com.google.gson.JsonStreamParser;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CachePoolManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h {
    public static final String c = com.alliance.ssp.ad.a.b.a("gameley/adcachepool/").append(com.alliance.ssp.ad.o0.i.a).append("/").toString();
    public Map<String, List<String>> a = new HashMap();
    public Map<String, SAAllianceAdData> b = new HashMap();

    /* compiled from: CachePoolManager.java */
    public class a extends TypeToken<SAAllianceAdData> {
        public a(h hVar) {
        }
    }

    /* compiled from: CachePoolManager.java */
    public class b implements Comparator<SAAllianceAdData> {
        public b(h hVar) {
        }

        @Override // java.util.Comparator
        public int compare(SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) {
            return Double.compare(sAAllianceAdData2.getPriceD(), sAAllianceAdData.getPriceD());
        }
    }

    /* compiled from: CachePoolManager.java */
    public static class c {
        public static final h a = new h();
    }

    public final void a(Context context, String str, List<String> list) {
        String str2 = str + " cache ad info =\n | waitLoadTime: " + a(context, str);
        for (String str3 : list) {
            if (this.b.get(str3) != null) {
                str2 = str2 + "\n | id: " + str3 + ", price:" + this.b.get(str3).getPrice() + ", deadTime:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.b.get(str3).getDeadlineTime()));
            }
        }
        int i = l.a;
    }

    public synchronized SAAllianceAdData b(Context context, String str) {
        int i = l.a;
        try {
            List<String> list = this.a.get(str);
            if (list != null && !list.isEmpty()) {
                List<String> listB = b(context, str, list);
                int i2 = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) listB;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    SAAllianceAdData sAAllianceAdDataRemove = this.b.remove((String) arrayList.remove(i2));
                    if (sAAllianceAdDataRemove != null) {
                        if (a(sAAllianceAdDataRemove)) {
                            int i3 = l.a;
                            return sAAllianceAdDataRemove;
                        }
                        a(context, str, sAAllianceAdDataRemove.getRequestid());
                    }
                    i2++;
                }
            }
            File file = new File(context.getFilesDir(), c + str);
            if (file.exists()) {
                ArrayList arrayList2 = new ArrayList();
                if (file.isDirectory()) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        for (File file2 : fileArrListFiles) {
                            SAAllianceAdData sAAllianceAdDataA = a(new File(file, file2.getName()));
                            if (sAAllianceAdDataA != null) {
                                if (a(sAAllianceAdDataA)) {
                                    arrayList2.add(file2.getName());
                                    this.b.put(file2.getName(), sAAllianceAdDataA);
                                } else {
                                    a(context, str, file2.getName());
                                }
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            List<String> listB2 = b(context, str, arrayList2);
                            ArrayList arrayList3 = (ArrayList) listB2;
                            String str2 = (String) arrayList3.remove(0);
                            if (!arrayList3.isEmpty()) {
                                this.a.put(str, listB2);
                            }
                            int i4 = l.a;
                            return this.b.remove(str2);
                        }
                    }
                    int i5 = l.a;
                    return null;
                }
            } else if (!file.mkdirs()) {
                int i6 = l.a;
                return null;
            }
            return null;
        } catch (Exception e) {
            e.getMessage();
            int i7 = l.a;
            return null;
        }
    }

    public synchronized void a(Context context, SAAllianceAdData sAAllianceAdData, String str) {
        List<String> arrayList;
        File file;
        File[] fileArrListFiles;
        int i = l.a;
        try {
            if (this.a.get(str) != null) {
                arrayList = this.a.get(str);
            } else {
                arrayList = new ArrayList<>();
                this.a.put(str, arrayList);
            }
            file = new File(context.getFilesDir(), c + str);
        } catch (Exception e) {
            e.getMessage();
            int i2 = l.a;
        }
        if (file.exists() || file.mkdirs()) {
            if (arrayList.isEmpty() && ((fileArrListFiles = file.listFiles()) != null || fileArrListFiles.length != 0)) {
                for (File file2 : fileArrListFiles) {
                    SAAllianceAdData sAAllianceAdDataA = a(new File(file, file2.getName()));
                    if (sAAllianceAdDataA != null) {
                        if (a(sAAllianceAdDataA)) {
                            arrayList.add(file2.getName());
                            this.b.put(file2.getName(), sAAllianceAdDataA);
                        } else {
                            a(context, str, sAAllianceAdDataA.getRequestid());
                        }
                    }
                }
            }
            File file3 = new File(file, sAAllianceAdData.getRequestid() + ".json");
            if (!file3.createNewFile()) {
                int i3 = l.a;
                return;
            }
            a(file3, sAAllianceAdData);
            arrayList.add(file3.getName());
            this.b.put(file3.getName(), sAAllianceAdData);
            a(context, arrayList, str);
            a(context, str, arrayList);
            arrayList.size();
            int i4 = l.a;
        }
    }

    public void a(Context context, String str, String str2) {
        File[] fileArrListFiles;
        int i = l.a;
        File file = new File(context.getFilesDir(), c + str);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().contains(str2)) {
                if (file2.delete()) {
                    return;
                }
                int i2 = l.a;
                return;
            }
        }
    }

    public final List<String> b(Context context, String str, List<String> list) {
        int i = l.a;
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            String str2 = list.get(size);
            SAAllianceAdData sAAllianceAdData = this.b.get(str2);
            if (sAAllianceAdData != null) {
                if (!a(sAAllianceAdData)) {
                    list.remove(size);
                    this.b.remove(str2);
                    a(context, str, str2);
                } else {
                    arrayList.add(sAAllianceAdData);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new b(this));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SAAllianceAdData sAAllianceAdData2 = (SAAllianceAdData) it.next();
                arrayList2.add(sAAllianceAdData2.getRequestid() + ".json");
                sAAllianceAdData2.getRequestid();
                int i2 = l.a;
            }
        }
        return arrayList2;
    }

    public void a(String str, String str2) {
        int i = l.a;
        List<String> list = this.a.get(str);
        if (list != null) {
            list.remove(str2 + ".json");
        }
    }

    public final void a(File file, SAAllianceAdData sAAllianceAdData) throws IOException {
        int i = l.a;
        Gson gson = new Gson();
        String[] strArrB = com.alliance.ssp.ad.o.e.b(gson.toJson(sAAllianceAdData));
        String json = gson.toJson(new SAAllianceAdEncryptData(strArrB[0], strArrB[1]));
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                int iCeil = (int) Math.ceil(json.length() / 1000);
                for (int i2 = 0; i2 < iCeil; i2++) {
                    int i3 = i2 * 1000;
                    bufferedWriter.write(json.substring(i3, Math.min(i3 + 1000, json.length())));
                }
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            e.getMessage();
            int i4 = l.a;
        }
    }

    public final SAAllianceAdData a(File file) {
        int i = l.a;
        ArrayList arrayList = new ArrayList();
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(file);
            try {
                JsonStreamParser jsonStreamParser = new JsonStreamParser(fileReader);
                while (jsonStreamParser.hasNext()) {
                    arrayList.add((SAAllianceAdEncryptData) gson.fromJson(jsonStreamParser.next(), SAAllianceAdEncryptData.class));
                }
                if (arrayList.isEmpty()) {
                    fileReader.close();
                    return null;
                }
                JSONObject jSONObject = new JSONObject(gson.toJson(arrayList.get(0)));
                SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) new Gson().fromJson(com.alliance.ssp.ad.o.e.a(jSONObject.getString("cipher"), jSONObject.getString("encryptParams")), new a(this).getType());
                fileReader.close();
                return sAAllianceAdData;
            } finally {
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = l.a;
            return null;
        }
    }

    public final void a(Context context, List<String> list, String str) {
        list.size();
        int i = l.a;
        if (list.size() > 5) {
            String str2 = list.get(0);
            for (String str3 : list) {
                if (this.b.get(str3) != null && this.b.get(str3).getDeadlineTime() < this.b.get(str2).getDeadlineTime()) {
                    str2 = str3;
                }
            }
            list.remove(str2);
            this.b.remove(str2);
            a(context, str, str2);
            a(context, list, str);
        }
    }

    public long a(Context context, String str) {
        if (context != null && str != null && !str.isEmpty()) {
            try {
                return context.getSharedPreferences("gameleycachepool", 0).getLong("waitLoadTime" + str, 500L);
            } catch (Exception e) {
                e.getMessage();
                int i = l.a;
            }
        }
        return 500L;
    }

    public void a(Context context, String str, long j) {
        if (context == null || str == null || str.isEmpty()) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("gameleycachepool", 0).edit();
            editorEdit.putLong("waitLoadTime" + str, j);
            editorEdit.apply();
        } catch (Exception e) {
            e.getMessage();
            int i = l.a;
        }
    }

    public long a(long j) {
        return System.currentTimeMillis() + (j <= 0 ? 43200000L : j * 1000);
    }

    public double a(String str) {
        if (str == null || str.isEmpty()) {
            return -1.0d;
        }
        return Double.parseDouble(str);
    }

    public final boolean a(SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData.getDeadlineTime() <= 0) {
            int i = l.a;
            return false;
        }
        if (sAAllianceAdData.getPriceD() <= 0.0d) {
            String price = sAAllianceAdData.getPrice();
            if (price != null && !price.isEmpty()) {
                sAAllianceAdData.setPriceD(Double.parseDouble(price));
            } else {
                int i2 = l.a;
                return false;
            }
        }
        sAAllianceAdData.getDeadlineTime();
        System.currentTimeMillis();
        int i3 = l.a;
        return sAAllianceAdData.getDeadlineTime() > System.currentTimeMillis();
    }

    public static h a() {
        return c.a;
    }
}
