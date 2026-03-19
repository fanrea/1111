package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.a$a, reason: collision with other inner class name */
    public interface InterfaceC0551a {
        a Mo();

        x.a Mp();

        int Mq();

        void Mr();

        boolean Ms();

        void Mt();

        void Mu();

        boolean Mv();

        boolean da(int i);

        void free();

        boolean isOver();
    }

    public interface b {
        int Mw();
    }

    public interface c {
        void Mx();

        void onBegin();
    }

    a B(String str, String str2);

    b LX();

    boolean LY();

    boolean LZ();

    int Ma();

    int Mb();

    boolean Mc();

    i Md();

    long Me();

    long Mf();

    byte Mg();

    boolean Mh();

    Throwable Mi();

    int Mj();

    int Mk();

    boolean Ml();

    boolean Mm();

    boolean Mn();

    a a(i iVar);

    a cZ(int i);

    boolean cancel();

    a cf(boolean z);

    a cg(boolean z);

    a ch(boolean z);

    a cm(String str);

    a cn(String str);

    a f(String str, boolean z);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    a j(Object obj);

    boolean pause();

    int start();
}
