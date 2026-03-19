package com.tk.core.o;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class l {

    interface b<T> {
        T b(BufferedReader bufferedReader);
    }

    public static String cW(String str) {
        try {
            return (String) a(str, new b<String>() { // from class: com.tk.core.o.l.1
                @Override // com.tk.core.o.l.b
                public final /* synthetic */ String b(BufferedReader bufferedReader) {
                    return a(bufferedReader);
                }

                private static String a(BufferedReader bufferedReader) throws IOException {
                    String line = bufferedReader.readLine();
                    while (bufferedReader.readLine() != null) {
                    }
                    return line;
                }
            });
        } catch (IOException | InterruptedException unused) {
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private static <T> T a(String str, b<T> bVar) {
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(str);
            a aVar = new a(processExec.getErrorStream());
            aVar.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            try {
                T tB = bVar.b(bufferedReader);
                bufferedReader.close();
                aVar.join();
                processExec.waitFor();
                return tB;
            } finally {
            }
        } finally {
            if (processExec != null) {
                processExec.destroy();
            }
        }
    }

    static class a extends Thread {
        private InputStream ajd;

        public a(InputStream inputStream) {
            super("NoopStreamConsumer");
            this.ajd = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws IOException {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.ajd));
                do {
                    try {
                    } finally {
                    }
                } while (bufferedReader.readLine() != null);
                bufferedReader.close();
            } catch (IOException unused) {
            }
        }
    }
}
