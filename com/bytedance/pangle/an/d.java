package com.bytedance.pangle.an;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static boolean d(String[] strArr) throws IOException {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = processExec.getErrorStream();
            InputStream inputStream = processExec.getInputStream();
            d(errorStream);
            d(inputStream);
            if (processExec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e) {
            com.bytedance.sdk.openadsdk.api.an.d(e);
            return false;
        } catch (InterruptedException e2) {
            com.bytedance.sdk.openadsdk.api.an.d(e2);
            return false;
        }
    }

    private static void d(final InputStream inputStream) {
        com.bytedance.pangle.u.u.hc(new Runnable() { // from class: com.bytedance.pangle.an.d.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            return;
                        } else {
                            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(String.valueOf(line)));
                        }
                    } catch (IOException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                        return;
                    } finally {
                        com.bytedance.pangle.util.h.d(bufferedReader);
                    }
                }
            }
        });
    }
}
