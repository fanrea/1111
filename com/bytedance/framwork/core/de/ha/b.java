package com.bytedance.framwork.core.de.ha;

import java.io.BufferedReader;
import java.io.FileReader;

/* compiled from: DeviceUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public static String a() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        do {
            try {
                line = bufferedReader.readLine();
                if (line != null) {
                }
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused4) {
            }
            return null;
        } while (!line.contains("Hardware"));
        String str = line.split(":")[1];
        try {
            bufferedReader.close();
        } catch (Exception unused5) {
        }
        return str;
    }
}
