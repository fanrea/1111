package com.tk.component.imageview;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class g {
    private static volatile g Ri;
    private com.tk.component.imageview.a.c Rf;
    private com.tk.component.imageview.a.a Rg;
    private com.tk.component.imageview.a.b Rh;

    public static g ng() {
        if (Ri == null) {
            synchronized (g.class) {
                if (Ri == null) {
                    Ri = new g();
                }
            }
        }
        return Ri;
    }

    @Deprecated
    public final com.tk.component.imageview.a.c nf() {
        return this.Rf;
    }

    @Deprecated
    public final void a(com.tk.component.imageview.a.c cVar) {
        this.Rf = cVar;
    }

    @Deprecated
    public final com.tk.component.imageview.a.a mT() {
        return this.Rg;
    }

    @Deprecated
    public final void setAnimatedImageHandler(com.tk.component.imageview.a.a aVar) {
        this.Rg = aVar;
    }

    public final com.tk.component.imageview.a.b nh() {
        if (this.Rh == null) {
            this.Rh = ni();
            if (this.Rh == null) {
                throw new ExceptionInInitializerError("please implements IImageLoadPlugin interface first");
            }
        }
        return this.Rh;
    }

    private static com.tk.component.imageview.a.b ni() {
        try {
            Class.forName("com.yxcorp.gifshow.image.KwaiImageView");
        } catch (Throwable unused) {
        }
        return null;
    }
}
