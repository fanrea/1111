package okhttp3.internal.d;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface a {
    public static final a Dn = new a() { // from class: okhttp3.internal.d.a.1
        @Override // okhttp3.internal.d.a
        public final Source c(File file) {
            return Okio.source(file);
        }

        @Override // okhttp3.internal.d.a
        public final Sink d(File file) {
            try {
                return Okio.sink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.sink(file);
            }
        }

        @Override // okhttp3.internal.d.a
        public final Sink e(File file) {
            try {
                return Okio.appendingSink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.appendingSink(file);
            }
        }

        @Override // okhttp3.internal.d.a
        public final void f(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.d.a
        public final boolean g(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.d.a
        public final long h(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.d.a
        public final void a(File file, File file2) throws IOException {
            f(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.d.a
        public final void i(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    i(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    void a(File file, File file2);

    Source c(File file);

    Sink d(File file);

    Sink e(File file);

    void f(File file);

    boolean g(File file);

    long h(File file);

    void i(File file);
}
