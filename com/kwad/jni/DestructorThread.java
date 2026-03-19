package com.kwad.jni;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class DestructorThread {
    private static final Thread sThread;
    private static final b sDestructorStack = new b(0);
    private static final ReferenceQueue sReferenceQueue = new ReferenceQueue();
    private static final a sDestructorList = new a();

    public static abstract class Destructor extends PhantomReference<Object> {
        private Destructor next;
        private Destructor previous;

        protected abstract void destruct();

        public Destructor(Object obj) {
            super(obj, DestructorThread.sReferenceQueue);
            DestructorThread.sDestructorStack.d(this);
        }

        private Destructor() {
            super(null, DestructorThread.sReferenceQueue);
        }
    }

    static {
        Thread thread = new Thread("HybridData DestructorThread") { // from class: com.kwad.jni.DestructorThread.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                while (true) {
                    try {
                        Destructor destructor = (Destructor) DestructorThread.sReferenceQueue.remove();
                        destructor.destruct();
                        if (destructor.previous == null) {
                            DestructorThread.sDestructorStack.hK();
                        }
                        a.b(destructor);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        };
        sThread = thread;
        thread.start();
    }

    static class c extends Destructor {
        private c() {
            super();
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.jni.DestructorThread.Destructor
        protected final void destruct() {
            throw new IllegalStateException("Cannot destroy Terminus Destructor.");
        }
    }

    static class b {
        private final AtomicReference<Destructor> AK;

        private b() {
            this.AK = new AtomicReference<>();
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void d(Destructor destructor) {
            Destructor destructor2;
            do {
                destructor2 = this.AK.get();
                destructor.next = destructor2;
            } while (!this.AK.compareAndSet(destructor2, destructor));
        }

        public final void hK() {
            Destructor andSet = this.AK.getAndSet(null);
            while (andSet != null) {
                Destructor destructor = andSet.next;
                DestructorThread.sDestructorList.a(andSet);
                andSet = destructor;
            }
        }
    }

    static class a {
        private final Destructor AJ;

        public a() {
            byte b = 0;
            this.AJ = new c(b);
            this.AJ.next = new c(b);
            this.AJ.next.previous = this.AJ;
        }

        public final void a(Destructor destructor) {
            destructor.next = this.AJ.next;
            this.AJ.next = destructor;
            destructor.next.previous = destructor;
            destructor.previous = this.AJ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Destructor destructor) {
            destructor.next.previous = destructor.previous;
            destructor.previous.next = destructor.next;
        }
    }
}
