package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m extends com.component.a.b.e {
    final /* synthetic */ l a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(l lVar, String str) {
        super(str);
        this.a = lVar;
    }

    @Override // com.component.a.b.n
    public boolean a(String str) {
        return "video_timer".equals(str) && this.a.bl >= 0;
    }

    @Override // com.component.a.b.n
    public Object b(String str) {
        if ("video_timer".equals(str)) {
            return Long.valueOf(this.a.bl);
        }
        return null;
    }
}
