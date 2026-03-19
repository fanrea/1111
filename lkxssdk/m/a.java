package lkxssdk.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class a {
    public static String a(long j) {
        if (j >= 0) {
            return j < 1024 ? String.format("%.3fB", Double.valueOf(j)) : j < 1048576 ? String.format("%.3fKB", Double.valueOf(j / 1024.0d)) : j < 1073741824 ? String.format("%.3fMB", Double.valueOf(j / 1048576.0d)) : String.format("%.3fGB", Double.valueOf(j / 1.073741824E9d));
        }
        throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
    }
}
