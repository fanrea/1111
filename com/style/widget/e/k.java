package com.style.widget.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k extends com.component.a.b.e {
    final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(f fVar, String str) {
        super(str);
        this.a = fVar;
    }

    @Override // com.component.a.b.n
    public boolean a(String str) {
        return "video_timer".equals(str) && this.a.H >= 0;
    }

    @Override // com.component.a.b.n
    public Object b(String str) {
        if ("video_timer".equals(str)) {
            return Long.valueOf(this.a.H);
        }
        return null;
    }
}
