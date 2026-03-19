package com.kwad.sdk.crash.message;

import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BackTraceElement extends a implements Serializable {
    private static final long serialVersionUID = 631048314192081635L;
    public String mFileName;
    public int mIndex;
    public String mLine;
    public long mLineNumber;
    public String mMethodName;
    public boolean mNeedClustering;

    public BackTraceElement() {
        this.mLine = "";
        this.mMethodName = "";
        this.mFileName = "";
        this.mLineNumber = 0L;
        this.mNeedClustering = true;
    }

    public BackTraceElement(String str, int i) {
        this.mMethodName = "";
        this.mFileName = "";
        this.mLineNumber = 0L;
        this.mNeedClustering = true;
        this.mLine = str;
        this.mIndex = i;
    }

    public String getLine() {
        return this.mLine;
    }

    public void setLine(String str) {
        this.mLine = str;
    }

    public String getMethodName() {
        return this.mMethodName;
    }

    public void setMethodName(String str) {
        this.mMethodName = str;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public long getLineNumber() {
        return this.mLineNumber;
    }

    public void setLineNumber(long j) {
        this.mLineNumber = j;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public boolean isNeedClustering() {
        return this.mNeedClustering;
    }

    public void setNeedClustering(boolean z) {
        this.mNeedClustering = z;
    }
}
