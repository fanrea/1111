package com.bytedance.d.hc.d;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.sdk.m.t.a;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.sdk.component.utils.mq;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    static volatile boolean d = true;
    private volatile boolean an = false;
    private c b;
    private final Context c;
    private final SharedPreferences h;
    private d hc;
    private volatile long u;

    public b(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.c = context;
        SharedPreferences sharedPreferencesHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "anr_monitor_table", 0);
        this.h = sharedPreferencesHc;
        this.u = sharedPreferencesHc.getLong("trace_anr_happen_time", 0L);
    }

    public void d() {
        if (this.an) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            d dVar = new d(this, "/data/anr/", 8);
            this.hc = dVar;
            dVar.startWatching();
        } else {
            this.b = new c(this);
        }
        this.an = true;
    }

    boolean d(int i, String str, int i2) {
        JSONObject jSONObjectD;
        JSONObject jSONObjectD2;
        try {
            jSONObjectD = u.d(d);
        } catch (Throwable th) {
            mq.d(th);
            jSONObjectD = null;
        }
        String strD = u.d(this.c, i2);
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        try {
            com.bytedance.d.hc.an anVarC = gb.hc().c();
            if (anVarC != null) {
                if (anVarC.d()) {
                    if (i == 200 && (jSONObjectD2 = d(str, Process.myPid(), this.c.getPackageName())) != null && jSONObjectD2.length() > 0) {
                        jSONObjectD = jSONObjectD2;
                    }
                    if (jSONObjectD != null && jSONObjectD.length() > 0) {
                        try {
                            jSONObjectD.put("pid", Process.myPid());
                            jSONObjectD.put("package", this.c.getPackageName());
                            jSONObjectD.put("is_remote_process", 0);
                            com.bytedance.d.hc.b.d dVar = new com.bytedance.d.hc.b.d(new JSONObject());
                            dVar.d("data", jSONObjectD.toString());
                            dVar.d("is_anr", (Object) 1);
                            dVar.d(a.k, Long.valueOf(System.currentTimeMillis()));
                            dVar.d(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, "anr");
                            dVar.d("anr_time", Long.valueOf(System.currentTimeMillis()));
                            dVar.d("crash_time", Long.valueOf(System.currentTimeMillis()));
                            dVar.d("anr_info", strD);
                            com.bytedance.d.hc.b.d dVarD = com.bytedance.d.hc.u.d.u.d().d(com.bytedance.d.hc.b.ANR, dVar);
                            com.bytedance.d.hc.gb.c.d(this.c, com.bytedance.d.hc.b.ANR.d(), (String) null);
                            com.bytedance.d.hc.h.d.d().hc(dVarD.d());
                            d(strD);
                        } catch (Throwable th2) {
                            tc.hc(th2);
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void d(String str) {
        Iterator<Object> it = gb.hc().b().iterator();
        while (it.hasNext()) {
            it.next();
            com.bytedance.d.hc.b bVar = com.bytedance.d.hc.b.ANR;
        }
    }

    public JSONObject d(String str, int i, String str2) throws Throwable {
        BufferedReader bufferedReader;
        int i2;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            e = e;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            com.bytedance.d.hc.gb.an.d(bufferedReader2);
            throw th;
        }
        try {
            try {
                Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                boolean z = false;
                Object[] objArrD = d(bufferedReader, patternCompile);
                if (objArrD == null) {
                    com.bytedance.d.hc.gb.an.d(bufferedReader);
                    return null;
                }
                long j = Long.parseLong(objArrD[1].toString().split("\\s")[2]);
                long time = simpleDateFormat.parse(objArrD[1].toString().split("\\s")[4] + " " + objArrD[1].toString().split("\\s")[5]).getTime();
                Object[] objArrD2 = d(bufferedReader, patternCompile3);
                if (objArrD2 == null) {
                    com.bytedance.d.hc.gb.an.d(bufferedReader);
                    return null;
                }
                String str3 = objArrD2[1].toString().split("\\s")[2];
                if (j == i && str3.equalsIgnoreCase(str2)) {
                    if (this.u != 0 && Math.abs(this.u - time) < 20000) {
                        com.bytedance.d.hc.gb.an.d(bufferedReader);
                        return null;
                    }
                    this.u = time;
                    SharedPreferences sharedPreferences = this.h;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putLong("trace_anr_happen_time", this.u).apply();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("anrTime", time);
                    while (true) {
                        Object[] objArrD3 = d(bufferedReader, patternCompile2, patternCompile4);
                        if (objArrD3 != null && objArrD3[0] == patternCompile4) {
                            Matcher matcher = Pattern.compile("\".+\"").matcher(objArrD3[1].toString());
                            String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                            Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrD3[1].toString());
                            if (matcher2.find()) {
                                String strGroup = matcher2.group();
                                i2 = Integer.parseInt(strGroup.substring(strGroup.indexOf("=") + 1));
                            } else {
                                i2 = -1;
                            }
                            String strD = d(bufferedReader);
                            if (i2 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strD) && strSubstring.equalsIgnoreCase(LiveConfigKey.MAIN)) {
                                jSONObject.put("mainStackFromTrace", strD);
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        com.bytedance.d.hc.gb.an.d(bufferedReader);
                        return null;
                    }
                    jSONObject.put("thread_number", 1);
                    com.bytedance.d.hc.gb.an.d(bufferedReader);
                    return jSONObject;
                }
                com.bytedance.d.hc.gb.an.d(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                com.bytedance.d.hc.gb.an.d(bufferedReader2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            mq.d(e);
            com.bytedance.d.hc.gb.an.d(bufferedReader);
            return null;
        }
    }

    private Object[] d(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    for (Pattern pattern : patternArr) {
                        if (pattern.matcher(line).matches()) {
                            return new Object[]{pattern, line};
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    private String d(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
