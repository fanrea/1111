package com.ss.texturerender.effect;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EmptyEffect extends AbsEffect {
    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        return null;
    }

    public EmptyEffect(int i) {
        super(i, 6);
        this.mOrder = 101;
    }
}
