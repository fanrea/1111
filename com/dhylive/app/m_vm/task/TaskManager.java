package com.dhylive.app.m_vm.task;

import com.dhylive.app.data.task.TJData;
import com.dhylive.app.data.task.XSData;
import com.dhylive.app.m_vm.task.TaskService;
import com.dhylive.app.net.BaseManager;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.NetworkApi;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: TaskManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e0\u00070\u00062\u0006\u0010\u000f\u001a\u00020\fJ\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e0\u00070\u00062\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/dhylive/app/m_vm/task/TaskManager;", "Lcom/dhylive/app/net/BaseManager;", "()V", "taskService", "Lcom/dhylive/app/m_vm/task/TaskService;", "getTJTaskList", "Lkotlinx/coroutines/flow/Flow;", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/task/TJData;", "page", "", NetworkDefine.PARAM_TOKEN, "", "getTJToken", "", "url", "getXSTaskList", "Lcom/dhylive/app/data/task/XSData;", "getXSToken", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class TaskManager extends BaseManager {
    private final TaskService taskService = (TaskService) NetworkApi.INSTANCE.create(TaskService.class);

    /* compiled from: TaskManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskManager$getTJToken$1", f = "TaskManager.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskManager$getTJToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C09471 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Map<String, ? extends String>>>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09471(String str, Continuation<? super C09471> continuation) {
            super(1, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return TaskManager.this.new C09471(this.$url, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Map<String, String>>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TaskManager.this.taskService.getTJToken(this.$url, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<Map<String, String>>> getTJToken(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return request(new C09471(url, null));
    }

    /* compiled from: TaskManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/task/TJData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskManager$getTJTaskList$1", f = "TaskManager.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskManager$getTJTaskList$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends TJData>>, Object> {
        final /* synthetic */ int $page;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$page = i;
            this.$token = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return TaskManager.this.new AnonymousClass1(this.$page, this.$token, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<TJData>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TaskService.DefaultImpls.getTJTaskList$default(TaskManager.this.taskService, this.$page, 0, this.$token, null, (Continuation) this, 10, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<TJData>> getTJTaskList(int page, String token) {
        Intrinsics.checkNotNullParameter(token, NetworkDefine.PARAM_TOKEN);
        return request(new AnonymousClass1(page, token, null));
    }

    /* compiled from: TaskManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskManager$getXSToken$1", f = "TaskManager.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskManager$getXSToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C09491 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Map<String, ? extends String>>>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09491(String str, Continuation<? super C09491> continuation) {
            super(1, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return TaskManager.this.new C09491(this.$url, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Map<String, String>>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TaskManager.this.taskService.getXSToken(this.$url, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<Map<String, String>>> getXSToken(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return request(new C09491(url, null));
    }

    /* compiled from: TaskManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/task/XSData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskManager$getXSTaskList$1", f = "TaskManager.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskManager$getXSTaskList$1, reason: invalid class name and case insensitive filesystem */
    static final class C09481 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends XSData>>, Object> {
        final /* synthetic */ int $page;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09481(int i, String str, Continuation<? super C09481> continuation) {
            super(1, continuation);
            this.$page = i;
            this.$token = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return TaskManager.this.new C09481(this.$page, this.$token, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<XSData>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TaskService.DefaultImpls.getXSTaskList$default(TaskManager.this.taskService, this.$page, 0, this.$token, 0, 0, 0, null, (Continuation) this, 122, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<XSData>> getXSTaskList(int page, String token) {
        Intrinsics.checkNotNullParameter(token, NetworkDefine.PARAM_TOKEN);
        return request(new C09481(page, token, null));
    }
}
