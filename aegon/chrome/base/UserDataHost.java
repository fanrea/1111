package aegon.chrome.base;

import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class UserDataHost {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mThreadId = Process.myTid();
    private HashMap<Class<? extends UserData>, UserData> mUserDataMap = new HashMap<>();

    private void checkThreadAndState() {
    }

    public final <T extends UserData> T setUserData(Class<T> cls, T t) {
        checkThreadAndState();
        this.mUserDataMap.put(cls, t);
        return (T) getUserData(cls);
    }

    public final <T extends UserData> T getUserData(Class<T> cls) {
        checkThreadAndState();
        return cls.cast(this.mUserDataMap.get(cls));
    }

    public final <T extends UserData> T removeUserData(Class<T> cls) {
        checkThreadAndState();
        return cls.cast(this.mUserDataMap.remove(cls));
    }

    public final void destroy() {
        checkThreadAndState();
        HashMap<Class<? extends UserData>, UserData> map = this.mUserDataMap;
        this.mUserDataMap = null;
        Iterator<UserData> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }
}
