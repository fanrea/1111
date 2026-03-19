package com.sigmob.sdk.videocache.file;

import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class d {

    private static final class a implements Comparator<File> {
        private a() {
        }

        private int a(long first, long second) {
            if (first < second) {
                return -1;
            }
            return first == second ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File lhs, File rhs) {
            return a(lhs.lastModified(), rhs.lastModified());
        }
    }

    d() {
    }

    static void a(File directory) throws IOException {
        if (directory.exists()) {
            if (!directory.isDirectory()) {
                throw new IOException("File " + directory + " is not directory!");
            }
        } else if (!directory.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", directory.getAbsolutePath()));
        }
    }

    static List<File> b(File directory) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = directory.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new a());
        return listAsList;
    }

    static void c(File file) throws IOException {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                SigmobLog.e("Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    static void d(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            e(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte b = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(b);
        randomAccessFile.close();
    }

    private static void e(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }
}
