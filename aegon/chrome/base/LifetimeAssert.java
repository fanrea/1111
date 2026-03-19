package aegon.chrome.base;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class LifetimeAssert {
    static TestHook sTestHook;
    final WrappedReference mWrapper;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    interface TestHook {
        void onCleaned(WrappedReference wrappedReference, String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class LifetimeAssertException extends RuntimeException {
        LifetimeAssertException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class CreationException extends RuntimeException {
        CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class WrappedReference extends PhantomReference<Object> {
        final CreationException mCreationException;
        boolean mSafeToGc;
        final Class<?> mTargetClass;
        private static ReferenceQueue<Object> sReferenceQueue = new ReferenceQueue<>();
        private static Set<WrappedReference> sActiveWrappers = Collections.synchronizedSet(new HashSet());

        public WrappedReference(Object obj, CreationException creationException, boolean z) {
            super(obj, sReferenceQueue);
            this.mCreationException = creationException;
            this.mSafeToGc = z;
            this.mTargetClass = obj.getClass();
            sActiveWrappers.add(this);
        }

        static {
            new Thread("GcStateAssertQueue") { // from class: aegon.chrome.base.LifetimeAssert.WrappedReference.1
                {
                    setDaemon(true);
                    start();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            WrappedReference wrappedReference = (WrappedReference) WrappedReference.sReferenceQueue.remove();
                            WrappedReference.sActiveWrappers.remove(wrappedReference);
                            if (!wrappedReference.mSafeToGc) {
                                String str = String.format("Object of type %s was GC'ed without cleanup. Refer to \"Caused by\" for where object was created.", wrappedReference.mTargetClass.getName());
                                if (LifetimeAssert.sTestHook != null) {
                                    LifetimeAssert.sTestHook.onCleaned(wrappedReference, str);
                                } else {
                                    throw new LifetimeAssertException(str, wrappedReference.mCreationException);
                                }
                            } else if (LifetimeAssert.sTestHook != null) {
                                LifetimeAssert.sTestHook.onCleaned(wrappedReference, null);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
        }
    }

    private LifetimeAssert(WrappedReference wrappedReference) {
        this.mWrapper = wrappedReference;
    }

    public static LifetimeAssert create(Object obj) {
        if (BuildConfig.DCHECK_IS_ON) {
            return new LifetimeAssert(new WrappedReference(obj, new CreationException(), false));
        }
        return null;
    }

    public static LifetimeAssert create(Object obj, boolean z) {
        if (BuildConfig.DCHECK_IS_ON) {
            return new LifetimeAssert(new WrappedReference(obj, new CreationException(), z));
        }
        return null;
    }

    public static void setSafeToGc(LifetimeAssert lifetimeAssert, boolean z) {
        if (BuildConfig.DCHECK_IS_ON) {
            lifetimeAssert.mWrapper.mSafeToGc = z;
        }
    }

    public static void assertAllInstancesDestroyedForTesting() {
        if (BuildConfig.DCHECK_IS_ON) {
            synchronized (WrappedReference.sActiveWrappers) {
                for (WrappedReference wrappedReference : WrappedReference.sActiveWrappers) {
                    if (!wrappedReference.mSafeToGc) {
                        throw new LifetimeAssertException(String.format("Object of type %s was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", wrappedReference.mTargetClass.getName()), wrappedReference.mCreationException);
                    }
                }
            }
        }
    }
}
