package com.dhylive.app.m_vm.task;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.dhylive.app.data.task.TJData;
import com.dhylive.app.data.task.XSData;
import com.dhylive.app.net.BaseResp;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0011R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR)\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR)\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006!"}, d2 = {"Lcom/dhylive/app/m_vm/task/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "taskManager", "Lcom/dhylive/app/m_vm/task/TaskManager;", "getTaskManager", "()Lcom/dhylive/app/m_vm/task/TaskManager;", "taskManager$delegate", "Lkotlin/Lazy;", "tjTaskListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/task/TJData;", "getTjTaskListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "tjTokenLiveData", "", "", "getTjTokenLiveData", "xsTaskListLiveData", "Lcom/dhylive/app/data/task/XSData;", "getXsTaskListLiveData", "xsTokenLiveData", "getXsTokenLiveData", "getTJTaskList", "", "page", "", NetworkDefine.PARAM_TOKEN, "getTJToken", "url", "getXSTaskList", "getXSToken", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class TaskViewModel extends ViewModel {

    /* renamed from: taskManager$delegate, reason: from kotlin metadata */
    private final Lazy taskManager = LazyKt.lazy(new Function0<TaskManager>() { // from class: com.dhylive.app.m_vm.task.TaskViewModel$taskManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TaskManager m374invoke() {
            return new TaskManager();
        }
    });
    private final MutableLiveData<BaseResp<Map<String, String>>> tjTokenLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<TJData>> tjTaskListLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<Map<String, String>>> xsTokenLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<XSData>> xsTaskListLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskManager getTaskManager() {
        return (TaskManager) this.taskManager.getValue();
    }

    public final MutableLiveData<BaseResp<Map<String, String>>> getTjTokenLiveData() {
        return this.tjTokenLiveData;
    }

    public final MutableLiveData<BaseResp<TJData>> getTjTaskListLiveData() {
        return this.tjTaskListLiveData;
    }

    public final MutableLiveData<BaseResp<Map<String, String>>> getXsTokenLiveData() {
        return this.xsTokenLiveData;
    }

    public final MutableLiveData<BaseResp<XSData>> getXsTaskListLiveData() {
        return this.xsTaskListLiveData;
    }

    /* compiled from: TaskViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getTJToken$1", f = "TaskViewModel.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getTJToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C09501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09501(String str, Continuation<? super C09501> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TaskViewModel.this.new C09501(this.$url, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(TaskViewModel.this.getTaskManager().getTJToken(this.$url), new C03521(TaskViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: TaskViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/dhylive/app/net/BaseResp;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getTJToken$1$1", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getTJToken$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03521 extends SuspendLambda implements Function2<BaseResp<? extends Map<String, ? extends String>>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TaskViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03521(TaskViewModel taskViewModel, Continuation<? super C03521> continuation) {
                super(2, continuation);
                this.this$0 = taskViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03521 = new C03521(this.this$0, continuation);
                c03521.L$0 = obj;
                return c03521;
            }

            public final Object invoke(BaseResp<? extends Map<String, String>> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getTjTokenLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getTJToken(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09501(url, null), 3, null);
    }

    /* compiled from: TaskViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getTJTaskList$1", f = "TaskViewModel.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getTJTaskList$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $page;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$page = i;
            this.$token = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TaskViewModel.this.new AnonymousClass1(this.$page, this.$token, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(TaskViewModel.this.getTaskManager().getTJTaskList(this.$page, this.$token), new C03511(TaskViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: TaskViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/task/TJData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getTJTaskList$1$1", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getTJTaskList$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03511 extends SuspendLambda implements Function2<BaseResp<? extends TJData>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TaskViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03511(TaskViewModel taskViewModel, Continuation<? super C03511> continuation) {
                super(2, continuation);
                this.this$0 = taskViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03511 = new C03511(this.this$0, continuation);
                c03511.L$0 = obj;
                return c03511;
            }

            public final Object invoke(BaseResp<TJData> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getTjTaskListLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getTJTaskList(int page, String token) {
        Intrinsics.checkNotNullParameter(token, NetworkDefine.PARAM_TOKEN);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(page, token, null), 3, null);
    }

    /* compiled from: TaskViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getXSToken$1", f = "TaskViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getXSToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C09521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09521(String str, Continuation<? super C09521> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TaskViewModel.this.new C09521(this.$url, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(TaskViewModel.this.getTaskManager().getXSToken(this.$url), new C03541(TaskViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: TaskViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/dhylive/app/net/BaseResp;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getXSToken$1$1", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getXSToken$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03541 extends SuspendLambda implements Function2<BaseResp<? extends Map<String, ? extends String>>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TaskViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03541(TaskViewModel taskViewModel, Continuation<? super C03541> continuation) {
                super(2, continuation);
                this.this$0 = taskViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03541 = new C03541(this.this$0, continuation);
                c03541.L$0 = obj;
                return c03541;
            }

            public final Object invoke(BaseResp<? extends Map<String, String>> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getXsTokenLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getXSToken(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09521(url, null), 3, null);
    }

    /* compiled from: TaskViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getXSTaskList$1", f = "TaskViewModel.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getXSTaskList$1, reason: invalid class name and case insensitive filesystem */
    static final class C09511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $page;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09511(int i, String str, Continuation<? super C09511> continuation) {
            super(2, continuation);
            this.$page = i;
            this.$token = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TaskViewModel.this.new C09511(this.$page, this.$token, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(TaskViewModel.this.getTaskManager().getXSTaskList(this.$page, this.$token), new C03531(TaskViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: TaskViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/task/XSData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.task.TaskViewModel$getXSTaskList$1$1", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.task.TaskViewModel$getXSTaskList$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03531 extends SuspendLambda implements Function2<BaseResp<? extends XSData>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TaskViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03531(TaskViewModel taskViewModel, Continuation<? super C03531> continuation) {
                super(2, continuation);
                this.this$0 = taskViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03531 = new C03531(this.this$0, continuation);
                c03531.L$0 = obj;
                return c03531;
            }

            public final Object invoke(BaseResp<XSData> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getXsTaskListLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getXSTaskList(int page, String token) {
        Intrinsics.checkNotNullParameter(token, NetworkDefine.PARAM_TOKEN);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09511(page, token, null), 3, null);
    }
}
