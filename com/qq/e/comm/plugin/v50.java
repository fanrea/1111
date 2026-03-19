package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class v50 {
    private final bm a;
    private int b = -1;

    public v50(bm bmVar) {
        this.a = bmVar;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v50.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i = this.b;
        bm bmVar = this.a;
        if (bmVar == null) {
            this.b = -1;
            return;
        }
        if (i == 0) {
            bmVar.a(new sg("onPageShown", null));
        } else {
            bmVar.a(new sg("onPageHidden", null));
        }
        this.b = -1;
    }

    public void a(int i) {
        if (this.b != -1) {
            this.b = i;
        } else {
            this.b = i;
            xo.a(new a(), 10L);
        }
    }
}
