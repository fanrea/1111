package com.ss.mediakit.medialoader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLCopyOperation {
    public String mCustomDir;
    String mDestPath;
    String mFileKey;
    boolean mForceCopyUnfinished;
    public final AVMDLCopyOperationListener mListener;
    boolean mWaitIfCaching;

    public AVMDLCopyOperation(String str, String str2, AVMDLCopyOperationListener aVMDLCopyOperationListener) {
        this.mFileKey = str;
        this.mDestPath = str2;
        this.mListener = aVMDLCopyOperationListener;
        this.mCustomDir = null;
        this.mWaitIfCaching = false;
    }

    public AVMDLCopyOperation(String str, String str2, boolean z, AVMDLCopyOperationListener aVMDLCopyOperationListener) {
        this.mFileKey = str;
        this.mDestPath = str2;
        this.mListener = aVMDLCopyOperationListener;
        this.mCustomDir = null;
        this.mWaitIfCaching = z;
    }

    public AVMDLCopyOperation(String str, String str2, boolean z, boolean z2, AVMDLCopyOperationListener aVMDLCopyOperationListener) {
        this.mFileKey = str;
        this.mDestPath = str2;
        this.mListener = aVMDLCopyOperationListener;
        this.mCustomDir = null;
        this.mWaitIfCaching = z2;
        this.mForceCopyUnfinished = z;
        if (z) {
            this.mWaitIfCaching = false;
        }
    }
}
