package com.kuaishou.weapon.p0;

import android.os.Process;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class di {
    private static String b(String str) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            ArrayList arrayList = new ArrayList();
            do {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.contains("TCP") && !line.contains(":443")) {
                    arrayList.add(line);
                }
            } while (arrayList.size() <= 5);
            bufferedReader.close();
            if (arrayList.size() > 0) {
                return arrayList.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        try {
            return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() throws Throwable {
        try {
            String strA = a(" pidof adbd ");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return strA.length() > 10 ? strA.substring(0, 10) : strA;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            try {
                String line = bufferedReader2.readLine();
                String str2 = line != null ? "" + line : "";
                try {
                    bufferedReader2.close();
                } catch (Exception unused) {
                }
                return str2;
            } catch (Exception unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Set c() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            HashSet hashSet = new HashSet();
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -nap ").getInputStream()));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.contains(LiveConfigKey.TCP) && line.contains("ESTABLISHED") && line.contains(":5555 ")) {
                        hashSet.add(line);
                    }
                } catch (Exception unused) {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            if (hashSet.size() > 0) {
                try {
                    bufferedReader.close();
                } catch (Exception unused3) {
                }
                return hashSet;
            }
        } catch (Exception unused4) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
        try {
            bufferedReader.close();
        } catch (Exception unused5) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d() throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = " netstat -apn | grep scrcpy "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
        L1a:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r1 == 0) goto L2d
            java.lang.String r2 = "scrcpy"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r1 == 0) goto L1a
            r3.close()     // Catch: java.lang.Exception -> L2b
        L2b:
            r0 = 1
            return r0
        L2d:
            r3.close()     // Catch: java.lang.Exception -> L30
        L30:
            return r0
        L31:
            r0 = move-exception
            r1 = r3
            goto L37
        L34:
            r1 = r3
            goto L3d
        L36:
            r0 = move-exception
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Exception -> L3c
        L3c:
            throw r0
        L3d:
            if (r1 == 0) goto L42
            r1.close()     // Catch: java.lang.Exception -> L42
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.di.d():int");
    }

    public static JSONObject e() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -an ").getInputStream()));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.contains("/") || line.contains("@")) {
                    if (line.contains("/")) {
                        line = line.substring(line.indexOf("/"));
                    } else if (line.contains("@")) {
                        line = line.substring(line.indexOf("@"));
                    }
                    if (line.contains("/ddy")) {
                        jSONObject.put("0", line);
                    } else if (line.contains("scrcpy")) {
                        jSONObject.put("1", line);
                    } else if (line.contains("supersu")) {
                        jSONObject.put("2", line);
                    } else if (line.contains("/adbd")) {
                        jSONObject.put("3", line);
                    }
                }
            }
            if (jSONObject.length() > 0) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return jSONObject;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
            }
            return null;
        } catch (Exception unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused6) {
                }
            }
            throw th;
        }
    }
}
