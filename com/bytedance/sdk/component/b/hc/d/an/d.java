package com.bytedance.sdk.component.b.hc.d.an;

import com.bytedance.sdk.component.b.d.mq;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.d.yo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface d {
    public static final d d = new d() { // from class: com.bytedance.sdk.component.b.hc.d.an.d.1
        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public rf d(File file) throws FileNotFoundException {
            return mq.d(file);
        }

        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public yo hc(File file) throws FileNotFoundException {
            try {
                return mq.hc(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return mq.hc(file);
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public yo b(File file) throws FileNotFoundException {
            try {
                return mq.b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return mq.b(file);
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public boolean c(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public long u(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public void d(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.an.d
        public void an(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    an(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }
    };

    void an(File file) throws IOException;

    yo b(File file) throws FileNotFoundException;

    boolean c(File file);

    rf d(File file) throws FileNotFoundException;

    void d(File file, File file2) throws IOException;

    void delete(File file) throws IOException;

    yo hc(File file) throws FileNotFoundException;

    long u(File file);
}
