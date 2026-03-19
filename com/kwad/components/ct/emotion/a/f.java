package com.kwad.components.ct.emotion.a;

import com.kwad.components.ct.emotion.model.EmotionPackage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    private Map<String, EmotionPackage> aCj = Collections.synchronizedMap(new LinkedHashMap());

    public final void a(String str, EmotionPackage emotionPackage) {
        this.aCj.put(str, emotionPackage);
    }

    public final List<EmotionPackage> DJ() {
        return new ArrayList(this.aCj.values());
    }
}
