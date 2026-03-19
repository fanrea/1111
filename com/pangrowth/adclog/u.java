package com.pangrowth.adclog;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u implements FilenameFilter {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ Pattern b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public u(ArrayList arrayList, Pattern pattern, long j, long j2) {
        this.a = arrayList;
        this.b = pattern;
        this.c = j;
        this.d = j2;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) throws NumberFormatException {
        String strGroup;
        this.a.add(str);
        Matcher matcher = this.b.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1 || (strGroup = matcher.group(1)) == null) {
            return false;
        }
        long j = Long.parseLong(strGroup);
        if (j > 0 && j <= this.c) {
            long jLastModified = new File(file, str).lastModified();
            if (jLastModified > 0 && jLastModified >= this.d) {
                return true;
            }
        }
        return false;
    }
}
