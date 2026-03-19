package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ac {
    public boolean a() {
        return Process.myUid() / KSTubeParamInner.FREE_ALL != 0;
    }

    public boolean a(Context context) {
        try {
            return new File(context.getFilesDir().getParentFile().getAbsolutePath() + File.separator + "..").canRead();
        } catch (Throwable unused) {
            return false;
        }
    }

    public String b(Context context) {
        try {
            return context.getFilesDir().getParentFile().getAbsolutePath();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String c(Context context) {
        try {
            Object objInvoke = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = objInvoke.getClass().getDeclaredField("mPackages");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map != null && map.size() > 0) {
                for (Object obj : map.keySet()) {
                    if (obj.toString().length() > 1 && !obj.toString().equals(context.getPackageName())) {
                        File file = new File("/data/data" + File.separator + obj.toString());
                        if (file.exists() && file.canWrite()) {
                            return obj.toString();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray d(Context context) throws IOException {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            try {
                HashSet hashSet = new HashSet();
                String packageName = context.getPackageName();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.contains("@Hw") && !line.contains(".apk@classes.dex") && !line.contains("WebViewGoogle") && !line.contains("FeatureFramework") && !line.contains("framework@oppo") && !line.contains("framework@mediatek")) {
                            if (hashSet.size() > 15) {
                                break;
                            }
                            if (!line.contains(packageName) && line.contains("/data/") && line.contains(".so")) {
                                hashSet.add(line.substring(line.indexOf("/data/"), line.indexOf(".so") + 3));
                            } else if (!line.contains(packageName) && line.contains("/data/") && line.contains(".dex")) {
                                hashSet.add(line.substring(line.indexOf("/data/"), line.indexOf(".dex") + 4));
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (hashSet.size() > 0) {
                    JSONArray jSONArray = new JSONArray((Collection) hashSet);
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    return jSONArray;
                }
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return null;
            }
        } catch (Throwable unused3) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return null;
    }

    public int e(Context context) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return a(context) ? 1 : 0;
            }
            String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
            String str = "fk_w_" + System.currentTimeMillis();
            fileOutputStream = new FileOutputStream(absolutePath + File.separator + str);
            try {
                FileDescriptor fd = fileOutputStream.getFD();
                Field declaredField = fd.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                declaredField.get(fd);
                String absolutePath2 = Files.readSymbolicLink(Paths.get(String.format("/proc/self/fd/%d", Integer.valueOf(((Integer) declaredField.get(fd)).intValue())), new String[0])).toFile().getAbsolutePath();
                if (absolutePath2.substring(absolutePath2.lastIndexOf(File.separator)).equals(File.separator + str)) {
                    boolean zCanRead = new File(absolutePath2.replace(str, "")).getParentFile().canRead();
                    File file = new File(absolutePath2);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (zCanRead) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                        return 1;
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    return 0;
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
                return 1;
            } catch (Throwable unused4) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                return 0;
            }
        } catch (Throwable unused6) {
            fileOutputStream = null;
        }
    }

    private String a(int i, int i2) {
        if (i2 < 26) {
            return "u:r:untrusted_app";
        }
        if (i >= i2) {
            return "u:r:untrusted_app:s0";
        }
        if (i < 26) {
            return "u:r:untrusted_app_25:s0";
        }
        if (i2 == 27) {
            if (i >= 26) {
                return "u:r:untrusted_app:s0";
            }
        } else if (i2 == 28 || i2 == 29) {
            if (i >= 26) {
                return "u:r:untrusted_app_27:s0";
            }
        } else if (i2 == 30) {
            if (i >= 29) {
                return "u:r:untrusted_app_29:s0";
            }
            return "u:r:untrusted_app_27:s0";
        }
        return "u:r:untrusted_app";
    }

    public boolean f(Context context) throws ClassNotFoundException {
        try {
            int i = context.getApplicationInfo().targetSdkVersion;
            Class<?> cls = Class.forName("android.os.SELinux");
            String str = (String) cls.getDeclaredMethod("getContext", new Class[0]).invoke(cls, new Object[0]);
            String strA = a(i, Build.VERSION.SDK_INT);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return !str.startsWith(strA);
        } catch (Exception unused) {
            return false;
        }
    }
}
