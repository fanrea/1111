package yaq;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.plugin.managers.AdManager;
import com.sigmob.sdk.archives.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pro {
    static final int DexNum = 1;
    static final int ERROR_EXCEPTION = -2;
    static final int ERROR_FALSE = 0;
    static final int ERROR_FILE_EXIST = 2;
    static final int ERROR_FILE_MISMATCH = -4;
    static final int ERROR_FILE_NOT_FOUND = -1;
    static final int ERROR_FILE_NOT_FOUND_INZIP = -3;
    static final int ERROR_FLAG = 3;
    static final int ERROR_SUCCESS = 1;
    static String Pluginname = null;
    static String Pluginpath = null;
    static Context ctx = null;
    static final String data2name = "yaq2.sec";
    static final String data3name = "yaq3_0.sec";
    static final String dataname = "yaq.sec";
    static final String libName = "libyaqpro.so";
    static final String libbasicName = "libyaqbasic.so";
    static final String turingauName = "libturingau.so";
    static final String versioncookie = "13295965";
    static final String versionname = "yaqsdkcookie";
    static boolean isdebugmode = false;
    static int arch_code = 0;
    static String LibPath = null;
    static String LibBasicPath = null;
    static String turingauLibPath = null;
    static String DataPath = null;
    static String Data2Path = null;
    static String Data3Path = null;
    static long vmpctx = 0;
    static String CPUABI = null;

    public static native byte getBresult(int i, int i2, Object... objArr);

    public static native char getCresult(int i, int i2, Object... objArr);

    public static native double getDresult(int i, int i2, Object... objArr);

    public static native float getFresult(int i, int i2, Object... objArr);

    public static native int getIresult(int i, int i2, Object... objArr);

    public static native long getJresult(int i, int i2, Object... objArr);

    public static native short getSresult(int i, int i2, Object... objArr);

    public static native void getVresult(int i, int i2, Object... objArr);

    public static native boolean getZresult(int i, int i2, Object... objArr);

    public static native Object getobjresult(int i, int i2, Object... objArr);

    public static native void init(int i);

    static {
        Pluginpath = null;
        Pluginname = null;
        ctx = null;
        try {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        if (Build.VERSION.SDK_INT > 36) {
            throw new UnsupportedOperationException("unsupport OS version");
        }
        Context contextinmainthread = getContextinmainthread();
        ctx = contextinmainthread;
        if (contextinmainthread == null) {
            Context appContext = AdManager.getInstance().getAppContext();
            ctx = appContext;
            if (appContext == null) {
                throw new RuntimeException("cannot get context!");
            }
        }
        ClassLoader loader = pro.class.getClassLoader();
        Pluginpath = getAppPath(loader);
        String str = Pluginpath;
        if (str != null) {
            int prepare_result = preparefiles(str);
            if (prepare_result == -2) {
                throw new RuntimeException("prepare secure files error");
            }
            String str2 = Pluginpath;
            int lastslash = Pluginpath.lastIndexOf(47);
            if (lastslash >= 0) {
                String pluginname_tmp = Pluginpath.substring(lastslash + 1);
                Pluginname = pluginname_tmp.substring(0, pluginname_tmp.lastIndexOf(46));
            } else {
                String pluginname_tmp2 = Pluginpath;
                Pluginname = pluginname_tmp2.substring(0, pluginname_tmp2.lastIndexOf(46));
            }
        }
        try {
            if (!loadLib(LibPath) || !loadLib(LibBasicPath)) {
                throw new RuntimeException("load lib error");
            }
            if ((!isdebugmode || arch_code == 1 || arch_code == 2) && !loadLib(turingauLibPath)) {
                throw new RuntimeException("load lib error");
            }
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
            throw new RuntimeException("load lib error");
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            throw new RuntimeException("load lib error");
        } catch (IllegalArgumentException e7) {
            e7.printStackTrace();
            throw new RuntimeException("load lib error");
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            throw new RuntimeException("load lib error");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x001a -> B:29:0x0034). Please report as a decompilation issue!!! */
    public static int readelfarch(String filename) throws IOException {
        int c = 0;
        RandomAccessFile rf = null;
        try {
            try {
                try {
                    try {
                        rf = new RandomAccessFile(filename, t.k);
                        rf.seek(18L);
                        c = rf.read();
                        rf.close();
                    } catch (Throwable th) {
                        if (rf != null) {
                            try {
                                rf.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    if (rf != null) {
                        rf.close();
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                if (rf != null) {
                    rf.close();
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return c;
    }

    public static HashSet<String> getsecfilelist(String plugindir) {
        HashSet<String> secfilelist = new HashSet<>();
        String[] allfilelist = new File(plugindir).list();
        for (String filename : allfilelist) {
            if (filename.matches("^libyaqpro.[0-9a-fA-F]+.so$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^libyaqbasic.[0-9a-fA-F]+.so$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^dexMethod.[0-9a-fA-F]+.dat$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^yaq.[0-9a-fA-F]+.sec$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^yaq2.[0-9a-fA-F]+.sec$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^yaq3_[0-9].[0-9a-fA-F]+.sec$")) {
                secfilelist.add(filename);
            } else if (filename.matches("^libturingau.[0-9a-fA-F]+.so$")) {
                secfilelist.add(filename);
            }
        }
        return secfilelist;
    }

    public static HashSet<String> getcookiefilelist(String plugindir) {
        HashSet<String> cookiefilelist = new HashSet<>();
        String[] allfilelist = new File(plugindir).list();
        for (String filename : allfilelist) {
            if (filename.matches("^\\d+.yaqcookie$")) {
                cookiefilelist.add(filename);
            }
        }
        return cookiefilelist;
    }

    public static String getelffilearch(String elffile, boolean isemumode) throws IOException {
        String file_arch;
        String file_arch2;
        int archcode = readelfarch(elffile);
        if (archcode == 3) {
            if (isdebugmode && !isemumode) {
                file_arch = "x86";
            } else {
                file_arch = "armeabi";
            }
            arch_code = 3;
            return file_arch;
        }
        if (archcode == 40) {
            arch_code = 1;
            return "armeabi";
        }
        if (archcode != 62) {
            if (archcode == 183) {
                arch_code = 2;
                return "arm64-v8a";
            }
            arch_code = 999;
            return "unknown";
        }
        if (isdebugmode && !isemumode) {
            file_arch2 = "x86_64";
        } else {
            file_arch2 = "arm64-v8a";
        }
        arch_code = 4;
        return file_arch2;
    }

    static boolean loadLib(String libPath) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method tmpLoadlib;
        boolean result = false;
        Runtime tmpruntime = Runtime.getRuntime();
        Class clazz = Class.forName("java.lang.Runtime");
        Class[] argsClass = {String.class, ClassLoader.class};
        if (Build.VERSION.SDK_INT > 27) {
            tmpLoadlib = clazz.getDeclaredMethod("nativeLoad", argsClass);
            tmpLoadlib.setAccessible(true);
        } else if (Build.VERSION.SDK_INT > 24) {
            tmpLoadlib = clazz.getDeclaredMethod("doLoad", argsClass);
            tmpLoadlib.setAccessible(true);
        } else {
            tmpLoadlib = clazz.getDeclaredMethod("load", argsClass);
            tmpLoadlib.setAccessible(true);
        }
        ClassLoader loader = pro.class.getClassLoader();
        try {
            if (Build.VERSION.SDK_INT > 24) {
                String errormasg = (String) tmpLoadlib.invoke(tmpruntime, libPath, loader);
                if (errormasg == null) {
                    result = true;
                }
            } else {
                tmpLoadlib.invoke(tmpruntime, libPath, loader);
                result = true;
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int writepidcookie(String plugindir, int pid, String cookie) throws IOException {
        File Cookiefile = new File(plugindir + "/" + pid + ".yaqcookie");
        BufferedOutputStream checkfbr = null;
        try {
            try {
                checkfbr = new BufferedOutputStream(new FileOutputStream(Cookiefile));
                checkfbr.write(cookie.getBytes());
                try {
                    checkfbr.close();
                    return 1;
                } catch (IOException e) {
                    e.printStackTrace();
                    return -2;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return -2;
                    }
                }
                return -1;
            } catch (IOException e4) {
                e4.printStackTrace();
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return -2;
                    }
                }
                return -2;
            }
        } catch (Throwable e6) {
            if (checkfbr != null) {
                try {
                    checkfbr.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    return -2;
                }
            }
            throw e6;
        }
    }

    public static int createcookiefile(File Cookiefile, String cookie) throws IOException {
        BufferedOutputStream checkfbr = null;
        try {
            try {
                try {
                    checkfbr = new BufferedOutputStream(new FileOutputStream(Cookiefile));
                    checkfbr.write(cookie.getBytes());
                    try {
                        checkfbr.close();
                        return 1;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return -2;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    if (checkfbr != null) {
                        try {
                            checkfbr.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return -2;
                        }
                    }
                    return -2;
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return -2;
                    }
                }
                return -1;
            }
        } catch (Throwable e6) {
            if (checkfbr != null) {
                try {
                    checkfbr.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    return -2;
                }
            }
            throw e6;
        }
    }

    public static void cleanfiles(String cleandir) throws IOException {
        String versioncookie_hash;
        String versioncookie_hash2;
        String str;
        String str2;
        String str3;
        String ls_result;
        String str4 = cleandir;
        HashSet<String> removecookiefilelist = new HashSet<>();
        HashSet<String> cookiefilelist = getcookiefilelist(cleandir);
        HashSet<String> secfilelist = getsecfilelist(cleandir);
        String versioncookie_hash3 = getCRC32HEX(versioncookie, Pluginpath);
        secfilelist.remove("libyaqpro." + versioncookie_hash3 + ".so");
        secfilelist.remove("libyaqbasic." + versioncookie_hash3 + ".so");
        secfilelist.remove("yaq." + versioncookie_hash3 + ".sec");
        secfilelist.remove("yaq2." + versioncookie_hash3 + ".sec");
        StringBuilder sb = new StringBuilder();
        String str5 = "yaq3_0.";
        sb.append("yaq3_0.");
        sb.append(versioncookie_hash3);
        sb.append(".sec");
        secfilelist.remove(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        String versioncookie_hash4 = "libturingau.";
        sb2.append("libturingau.");
        sb2.append(versioncookie_hash3);
        sb2.append(".so");
        secfilelist.remove(sb2.toString());
        Iterator<String> it = cookiefilelist.iterator();
        while (it.hasNext()) {
            HashSet<String> cookiefilelist2 = cookiefilelist;
            String cookiefile = it.next();
            Iterator<String> it2 = it;
            File pidcookie = new File(str4 + "/" + cookiefile);
            if (pidcookie.length() == 8) {
                String yaqcookie = readcookiefile(pidcookie);
                String yaq_pid = cookiefile.substring(0, cookiefile.lastIndexOf("."));
                StringBuilder sb3 = new StringBuilder();
                String versioncookie_hash5 = versioncookie_hash3;
                sb3.append("/proc/");
                sb3.append(yaq_pid);
                File proc_pid = new File(sb3.toString());
                try {
                } catch (SecurityException e) {
                    str2 = str5;
                    str3 = versioncookie_hash4;
                }
                if (proc_pid.exists()) {
                    str2 = str5;
                    str3 = versioncookie_hash4;
                } else {
                    try {
                        try {
                            Runtime runtime = Runtime.getRuntime();
                            str3 = versioncookie_hash4;
                            try {
                                StringBuilder sb4 = new StringBuilder();
                                str2 = str5;
                                try {
                                    sb4.append("ls /proc/");
                                    sb4.append(yaq_pid);
                                    ls_result = new BufferedReader(new InputStreamReader(runtime.exec(sb4.toString()).getErrorStream())).readLine();
                                } catch (SecurityException e2) {
                                } catch (Exception e3) {
                                }
                            } catch (SecurityException e4) {
                                str2 = str5;
                            } catch (Exception e5) {
                                str2 = str5;
                            }
                        } catch (SecurityException e6) {
                            str2 = str5;
                            str3 = versioncookie_hash4;
                        } catch (Exception e7) {
                            str2 = str5;
                            str3 = versioncookie_hash4;
                        }
                    } catch (Exception e8) {
                        str2 = str5;
                        str3 = versioncookie_hash4;
                    }
                    if (ls_result != null && ls_result.toLowerCase().indexOf("no such file") >= 0) {
                        removecookiefilelist.add(cookiefile);
                        str4 = cleandir;
                        cookiefilelist = cookiefilelist2;
                        it = it2;
                        versioncookie_hash3 = versioncookie_hash5;
                        versioncookie_hash4 = str3;
                        str5 = str2;
                    }
                }
                String yaqcookie_hash = getCRC32HEX(yaqcookie, Pluginpath);
                secfilelist.remove("libyaqpro." + yaqcookie + ".so");
                secfilelist.remove("libyaqbasic." + yaqcookie + ".so");
                secfilelist.remove("dexMethod." + yaqcookie + ".dat");
                secfilelist.remove("libyaqpro." + yaqcookie_hash + ".so");
                secfilelist.remove("libyaqbasic." + yaqcookie_hash + ".so");
                secfilelist.remove("yaq." + yaqcookie_hash + ".sec");
                secfilelist.remove("yaq2." + yaqcookie_hash + ".sec");
                StringBuilder sb5 = new StringBuilder();
                versioncookie_hash2 = str2;
                sb5.append(versioncookie_hash2);
                sb5.append(yaqcookie_hash);
                sb5.append(".sec");
                secfilelist.remove(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                str = str3;
                sb6.append(str);
                versioncookie_hash = versioncookie_hash5;
                sb6.append(versioncookie_hash);
                sb6.append(".so");
                secfilelist.remove(sb6.toString());
            } else {
                String str6 = versioncookie_hash4;
                versioncookie_hash = versioncookie_hash3;
                versioncookie_hash2 = str5;
                str = str6;
            }
            str4 = cleandir;
            cookiefilelist = cookiefilelist2;
            it = it2;
            String str7 = str;
            str5 = versioncookie_hash2;
            versioncookie_hash3 = versioncookie_hash;
            versioncookie_hash4 = str7;
        }
        Iterator<String> it3 = removecookiefilelist.iterator();
        while (it3.hasNext()) {
            String cookiefilename = it3.next();
            new File(cleandir + "/" + cookiefilename).delete();
        }
        Iterator<String> it4 = secfilelist.iterator();
        while (it4.hasNext()) {
            String secfilelistname = it4.next();
            File secfile = new File(cleandir + "/" + secfilelistname);
            secfile.delete();
        }
    }

    private static String readcookiefile(File pidcookie) throws IOException {
        byte[] checkfilebuf = new byte[8];
        BufferedInputStream checkfbr = null;
        String tmpfilestr = null;
        try {
            try {
                try {
                    checkfbr = new BufferedInputStream(new FileInputStream(pidcookie));
                    checkfbr.read(checkfilebuf);
                    tmpfilestr = new String(checkfilebuf);
                    checkfbr.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    if (checkfbr != null) {
                        checkfbr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (checkfbr != null) {
                        checkfbr.close();
                    }
                }
                return tmpfilestr;
            } catch (Throwable e2) {
                if (checkfbr != null) {
                    checkfbr.close();
                }
                throw e2;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static int Comparecookie(ZipFile pluginzf, String filepathinzip, File fileinfiledir) throws IOException {
        BufferedInputStream checkzbr = null;
        BufferedInputStream checkfbr = null;
        try {
            try {
                ZipEntry cookie_entry = pluginzf.getEntry(filepathinzip);
                if (cookie_entry == null) {
                    if (0 != 0) {
                        try {
                            try {
                                checkzbr.close();
                                if (0 != 0) {
                                    try {
                                        checkfbr.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return -2;
                                    }
                                }
                            } catch (Throwable e2) {
                                if (0 != 0) {
                                    try {
                                        checkfbr.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        return -2;
                                    }
                                }
                                throw e2;
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    return -2;
                                }
                            }
                            return -2;
                        }
                    }
                    return -3;
                }
                byte[] checkzipbuf = new byte[8];
                checkzbr = new BufferedInputStream(pluginzf.getInputStream(cookie_entry));
                int readziplen = checkzbr.read(checkzipbuf);
                String tmpzipstr = new String(checkzipbuf).substring(0, readziplen);
                if (!tmpzipstr.equals(versioncookie)) {
                    try {
                        try {
                            checkzbr.close();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    return -2;
                                }
                            }
                            return -4;
                        } catch (Throwable e7) {
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                    return -2;
                                }
                            }
                            throw e7;
                        }
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        if (0 != 0) {
                            try {
                                checkfbr.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                return -2;
                            }
                        }
                        return -2;
                    }
                }
                if (fileinfiledir == null) {
                    try {
                        try {
                            checkzbr.close();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                    return -2;
                                }
                            }
                            return 1;
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            if (0 != 0) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                    return -2;
                                }
                            }
                            return -2;
                        }
                    } catch (Throwable e14) {
                        if (0 != 0) {
                            try {
                                checkfbr.close();
                            } catch (IOException e15) {
                                e15.printStackTrace();
                                return -2;
                            }
                        }
                        throw e14;
                    }
                }
                byte[] checkfilebuf = new byte[8];
                checkfbr = new BufferedInputStream(new FileInputStream(fileinfiledir));
                int readfilelen = checkfbr.read(checkfilebuf);
                String tmpfilestr = new String(checkfilebuf).substring(0, readfilelen);
                int result = tmpfilestr.equals(tmpzipstr) ? 1 : 0;
                try {
                    try {
                        checkzbr.close();
                        try {
                            checkfbr.close();
                            return result;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            return -2;
                        }
                    } catch (Throwable e17) {
                        try {
                            checkfbr.close();
                            throw e17;
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            return -2;
                        }
                    }
                } catch (IOException e19) {
                    e19.printStackTrace();
                    try {
                        checkfbr.close();
                        return -2;
                    } catch (IOException e20) {
                        e20.printStackTrace();
                        return -2;
                    }
                }
            } catch (Throwable e21) {
                try {
                    if (checkzbr != null) {
                        try {
                            checkzbr.close();
                            if (checkfbr != null) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                    return -2;
                                }
                            }
                        } catch (IOException e23) {
                            e23.printStackTrace();
                            if (checkfbr != null) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e24) {
                                    e24.printStackTrace();
                                    return -2;
                                }
                            }
                            return -2;
                        }
                    }
                    throw e21;
                } catch (Throwable e25) {
                    if (checkfbr != null) {
                        try {
                            checkfbr.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            return -2;
                        }
                    }
                    throw e25;
                }
            }
        } catch (Exception e27) {
            e27.printStackTrace();
            try {
                if (checkzbr != null) {
                    try {
                        checkzbr.close();
                        if (checkfbr != null) {
                            try {
                                checkfbr.close();
                            } catch (IOException e28) {
                                e28.printStackTrace();
                                return -2;
                            }
                        }
                    } catch (IOException e29) {
                        e29.printStackTrace();
                        if (checkfbr != null) {
                            try {
                                checkfbr.close();
                            } catch (IOException e30) {
                                e30.printStackTrace();
                                return -2;
                            }
                        }
                        return -2;
                    }
                }
                return -2;
            } catch (Throwable e31) {
                if (checkfbr != null) {
                    try {
                        checkfbr.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                        return -2;
                    }
                }
                throw e31;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:1071:0x0c7c A[Catch: all -> 0x250e, Exception -> 0x251a, TRY_ENTER, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:1329:0x0f0b A[Catch: all -> 0x250e, Exception -> 0x251a, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:1586:0x119b  */
    /* JADX WARN: Removed duplicated region for block: B:1842:0x140a A[Catch: all -> 0x250e, Exception -> 0x251a, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:2094:0x1668 A[Catch: all -> 0x250e, Exception -> 0x251a, TRY_ENTER, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:2348:0x18d0 A[Catch: all -> 0x250e, Exception -> 0x251a, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:2600:0x1b2e A[Catch: all -> 0x250e, Exception -> 0x251a, TRY_ENTER, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:2854:0x1d96 A[Catch: all -> 0x250e, Exception -> 0x251a, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04d1 A[Catch: all -> 0x250e, Exception -> 0x251a, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:3111:0x2021  */
    /* JADX WARN: Removed duplicated region for block: B:3369:0x22b1 A[Catch: all -> 0x250e, Exception -> 0x251a, TRY_ENTER, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:3371:0x22b6 A[Catch: all -> 0x250e, Exception -> 0x251a, TRY_LEAVE, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /* JADX WARN: Removed duplicated region for block: B:3381:0x22e3  */
    /* JADX WARN: Removed duplicated region for block: B:3464:0x239a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:3965:0x2870 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:4268:0x2aca  */
    /* JADX WARN: Removed duplicated region for block: B:4503:0x261c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5171:0x2876 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5247:0x22eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0762  */
    /* JADX WARN: Removed duplicated region for block: B:815:0x09f7 A[Catch: all -> 0x250e, Exception -> 0x251a, TryCatch #871 {Exception -> 0x251a, all -> 0x250e, blocks: (B:296:0x0452, B:298:0x04d1, B:302:0x04e3, B:813:0x09f1, B:815:0x09f7, B:819:0x0a01, B:1327:0x0f05, B:1329:0x0f0b, B:1333:0x0f1b, B:1840:0x1404, B:1842:0x140a, B:1846:0x1415, B:2346:0x18ca, B:2348:0x18d0, B:2352:0x18db, B:2852:0x1d90, B:2854:0x1d96, B:2858:0x1da3, B:3369:0x22b1, B:3371:0x22b6, B:3375:0x22c3, B:3112:0x2026, B:3116:0x2034, B:2600:0x1b2e, B:2604:0x1b3d, B:2094:0x1668, B:2098:0x1677, B:1587:0x11a2, B:1591:0x11b1, B:1071:0x0c7c, B:1075:0x0c8a, B:556:0x0766, B:560:0x0774), top: B:5763:0x0452 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int preparefiles(java.lang.String r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 10955
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: yaq.pro.preparefiles(java.lang.String):int");
    }

    static String getAppPath(ClassLoader loader) throws IllegalAccessException, NoSuchFieldException, IOException, ClassNotFoundException, IllegalArgumentException {
        String[] outPathList;
        if (Build.VERSION.SDK_INT >= 9 && Build.VERSION.SDK_INT <= 13) {
            Field loaderfield = Class.forName("dalvik.system.DexClassLoader").getDeclaredField("mFiles");
            loaderfield.setAccessible(true);
            Object[] objelements = (Object[]) loaderfield.get(loader);
            outPathList = new String[objelements.length];
            for (int i = 0; i < objelements.length; i++) {
                File fileelement = (File) objelements[i];
                if (fileelement != null) {
                    outPathList[i] = fileelement.getAbsolutePath();
                }
            }
        } else {
            Field loaderfield2 = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
            loaderfield2.setAccessible(true);
            Object objdexpathlist = loaderfield2.get(loader);
            Field pathlistfield = objdexpathlist.getClass().getDeclaredField("dexElements");
            pathlistfield.setAccessible(true);
            Object[] objelements2 = (Object[]) pathlistfield.get(objdexpathlist);
            outPathList = new String[objelements2.length];
            for (int i2 = 0; i2 < objelements2.length; i2++) {
                try {
                    Field zipfield = objelements2[i2].getClass().getDeclaredField(d.e);
                    zipfield.setAccessible(true);
                    File zip = (File) zipfield.get(objelements2[i2]);
                    if (zip != null) {
                        outPathList[i2] = zip.getAbsolutePath();
                    }
                } catch (NoSuchFieldException e) {
                    try {
                        Field zipfilefield = objelements2[i2].getClass().getDeclaredField("zipFile");
                        zipfilefield.setAccessible(true);
                        ZipFile zipFile = (ZipFile) zipfilefield.get(objelements2[i2]);
                        outPathList[i2] = new File(zipFile.getName()).getAbsolutePath();
                    } catch (NoSuchFieldException e2) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            String elementstoString = objelements2[i2].toString();
                            int iszipfile = elementstoString.indexOf("zip file");
                            if (iszipfile == 0) {
                                int lastindexofquotes = elementstoString.lastIndexOf("\"");
                                int lastlastindexofquotes = elementstoString.lastIndexOf("\"", lastindexofquotes - 1);
                                outPathList[i2] = elementstoString.substring(lastlastindexofquotes + 1, lastindexofquotes);
                            }
                        } else {
                            Field pathfield = objelements2[i2].getClass().getDeclaredField("path");
                            pathfield.setAccessible(true);
                            File path = (File) pathfield.get(objelements2[i2]);
                            if (path != null) {
                                outPathList[i2] = path.getAbsolutePath();
                            }
                        }
                    }
                }
            }
        }
        try {
            if (outPathList[0] == null) {
                return null;
            }
            String result = new File(outPathList[0]).getCanonicalPath();
            return result;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    static Context getContextinmainthread() {
        int tid = Process.myTid();
        int pid = Process.myPid();
        if (tid == pid) {
            return getContext();
        }
        return getContextRaw();
    }

    static Handler getMainHandler() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class activityThreadClass = Class.forName("android.app.ActivityThread");
        Field handlerfield = activityThreadClass.getDeclaredField("sMainThreadHandler");
        handlerfield.setAccessible(true);
        Handler handler = (Handler) handlerfield.get(activityThreadClass);
        return handler;
    }

    static Context getContextinner(Class activityThreadClass, Object objactivityThread) throws NoSuchMethodException, SecurityException {
        try {
            Method getappmethod = activityThreadClass.getMethod("getApplication", new Class[0]);
            Context tmpctx = (Context) getappmethod.invoke(objactivityThread, new Object[0]);
            return tmpctx;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    static Context getContextnormal(Class activityThreadClass) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method getthreadmethod = activityThreadClass.getMethod("currentActivityThread", new Class[0]);
            Object threadtmp = getthreadmethod.invoke(null, new Object[0]);
            Context tmpctx = getContextinner(activityThreadClass, threadtmp);
            return tmpctx;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX WARN: Failed to apply debug info
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0110: MOVE (r1 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY] A[D('ObjActivitythread' java.lang.Object)]), block:B:54:0x0110 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0114: MOVE (r1 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY] A[D('ObjActivitythread' java.lang.Object)]), block:B:56:0x0114 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0118: MOVE (r1 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY] A[D('ObjActivitythread' java.lang.Object)]), block:B:58:0x0118 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x011c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY] A[D('ObjActivitythread' java.lang.Object)]), block:B:60:0x011c */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    static android.content.Context getContextRaw() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: yaq.pro.getContextRaw():android.content.Context");
    }

    static Context getContext() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Context tmpctx = getContextnormal(activityThreadClass);
            return tmpctx;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int SafeUnzipFile(ZipFile zf, String filepathinzip, File fileinfiledir) {
        return SafeUnzipFile(zf, filepathinzip, fileinfiledir, 0L);
    }

    public static int SafeUnzipFile(ZipFile zf, String filepathinzip, File fileinfiledir, long crc) throws IOException {
        BufferedOutputStream Output_fos = null;
        try {
            try {
                ZipEntry ze = zf.getEntry(filepathinzip);
                if (ze == null) {
                    if (0 != 0) {
                        try {
                            Output_fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            return -2;
                        }
                    }
                    return -3;
                }
                if (crc != 0 && ze.getCrc() == crc) {
                    if (0 != 0) {
                        try {
                            Output_fos.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return -2;
                        }
                    }
                    return 1;
                }
                byte[] buf = UnzipFile(zf, ze);
                int compareResult = Comparecookie(zf, "assets/yaqsdkcookie", null);
                if (compareResult != 1) {
                    if (0 != 0) {
                        try {
                            Output_fos.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return -2;
                        }
                    }
                    return compareResult;
                }
                if (1 != 0) {
                    Output_fos = new BufferedOutputStream(new FileOutputStream(fileinfiledir));
                    Output_fos.write(buf, 0, buf.length);
                }
                if (Output_fos != null) {
                    try {
                        Output_fos.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return -2;
                    }
                }
                return 1;
            } catch (Exception e5) {
                e5.printStackTrace();
                if (Output_fos != null) {
                    try {
                        Output_fos.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return -2;
                    }
                }
                return -2;
            }
        } catch (Throwable e7) {
            if (Output_fos != null) {
                try {
                    Output_fos.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return -2;
                }
            }
            throw e7;
        }
    }

    public static byte[] UnzipFile(ZipFile zf, ZipEntry ze) throws IOException {
        byte[] buf = new byte[(int) ze.getSize()];
        BufferedInputStream bufbr = new BufferedInputStream(zf.getInputStream(ze));
        int totallen = 0;
        do {
            try {
                int readlen = bufbr.read(buf, totallen, ((int) ze.getSize()) - totallen);
                if (readlen < 0) {
                    break;
                }
                totallen += readlen;
            } catch (Throwable th) {
                try {
                    bufbr.close();
                    throw th;
                } catch (IOException e) {
                    throw e;
                }
            }
        } while (totallen != ze.getSize());
        if (totallen != ((int) ze.getSize())) {
            throw new IOException("incorrect zip file size");
        }
        try {
            bufbr.close();
            return buf;
        } catch (IOException e2) {
            throw e2;
        }
    }

    public static String getCPUABI() throws IOException {
        if (CPUABI == null) {
            try {
                String os_cpuabi = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
                if (os_cpuabi.contains("x86")) {
                    CPUABI = "x86";
                } else if (os_cpuabi.contains("arm64-v8a")) {
                    CPUABI = "arm64-v8a";
                } else if (os_cpuabi.contains("armeabi-v7a")) {
                    CPUABI = "armeabi-v7a";
                } else {
                    CPUABI = "armeabi";
                }
            } catch (Exception e) {
                CPUABI = "armeabi";
            }
        }
        return CPUABI;
    }

    public static String getCRC32HEX(String cookie, String path) {
        CRC32 crc32 = new CRC32();
        crc32.update((cookie + path).getBytes());
        int crc32_result = (int) crc32.getValue();
        String hex_int = Integer.toHexString(crc32_result);
        return ("00000000" + hex_int).substring(hex_int.length(), hex_int.length() + 8);
    }

    private static long getFileCRC32(File file) throws IOException {
        long result = -1;
        byte[] filebuf = new byte[(int) file.length()];
        BufferedInputStream filebr = null;
        CRC32 crc32 = new CRC32();
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                filebr = new BufferedInputStream(new FileInputStream(file));
                int totallen = 0;
                while (true) {
                    int readlen = filebr.read(filebuf);
                    if (readlen < 0) {
                        break;
                    }
                    crc32.update(filebuf);
                    totallen += readlen;
                }
                result = crc32.getValue();
                filebr.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                if (filebr != null) {
                    filebr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (filebr != null) {
                    filebr.close();
                }
            }
            return result;
        } catch (Throwable th) {
            if (filebr != null) {
                try {
                    filebr.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void setaccessible(Constructor a) {
        a.setAccessible(true);
    }

    public static void setaccessible(Method a) {
        a.setAccessible(true);
    }

    public static void setaccessible(Field a) {
        a.setAccessible(true);
    }

    public static Object setaccessibleobj(Class a) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Constructor c = a.getDeclaredConstructor(new Class[0]);
        c.setAccessible(true);
        Object result = c.newInstance(new Object[0]);
        return result;
    }
}
