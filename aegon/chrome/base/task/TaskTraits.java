package aegon.chrome.base.task;

import com.kuaishou.socket.nano.SocketMessages;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class TaskTraits {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TaskTraits BEST_EFFORT;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK;
    public static final TaskTraits CHOREOGRAPHER_FRAME;
    public static final int EXTENSION_STORAGE_SIZE = 8;
    public static final byte INVALID_EXTENSION_ID = 0;
    public static final int MAX_EXTENSION_ID = 4;
    public static final TaskTraits THREAD_POOL;
    public static final TaskTraits THREAD_POOL_BEST_EFFORT;
    public static final TaskTraits THREAD_POOL_USER_BLOCKING;
    public static final TaskTraits THREAD_POOL_USER_VISIBLE;
    public static final TaskTraits USER_BLOCKING;
    public static final TaskTraits USER_BLOCKING_MAY_BLOCK;
    public static final TaskTraits USER_VISIBLE;
    public static final TaskTraits USER_VISIBLE_MAY_BLOCK;
    byte[] mExtensionData;
    byte mExtensionId;
    boolean mIsChoreographerFrame;
    boolean mMayBlock;
    int mPriority;
    boolean mPrioritySetExplicitly;
    boolean mUseThreadPool;

    static {
        TaskTraits taskTraitsTaskPriority = new TaskTraits().taskPriority(0);
        BEST_EFFORT = taskTraitsTaskPriority;
        BEST_EFFORT_MAY_BLOCK = taskTraitsTaskPriority.mayBlock();
        TaskTraits taskTraitsTaskPriority2 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = taskTraitsTaskPriority2;
        USER_VISIBLE_MAY_BLOCK = taskTraitsTaskPriority2.mayBlock();
        TaskTraits taskTraitsTaskPriority3 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = taskTraitsTaskPriority3;
        USER_BLOCKING_MAY_BLOCK = taskTraitsTaskPriority3.mayBlock();
        TaskTraits taskTraits = new TaskTraits();
        CHOREOGRAPHER_FRAME = taskTraits;
        taskTraits.mIsChoreographerFrame = true;
        TaskTraits taskTraitsThreadPool = new TaskTraits().threadPool();
        THREAD_POOL = taskTraitsThreadPool;
        THREAD_POOL_USER_BLOCKING = taskTraitsThreadPool.taskPriority(2);
        THREAD_POOL_USER_VISIBLE = taskTraitsThreadPool.taskPriority(1);
        THREAD_POOL_BEST_EFFORT = taskTraitsThreadPool.taskPriority(0);
    }

    private TaskTraits() {
        this.mPriority = 1;
    }

    private TaskTraits(TaskTraits taskTraits) {
        this.mPrioritySetExplicitly = taskTraits.mPrioritySetExplicitly;
        this.mPriority = taskTraits.mPriority;
        this.mMayBlock = taskTraits.mMayBlock;
        this.mUseThreadPool = taskTraits.mUseThreadPool;
        this.mExtensionId = taskTraits.mExtensionId;
        this.mExtensionData = taskTraits.mExtensionData;
    }

    public TaskTraits taskPriority(int i) {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mPrioritySetExplicitly = true;
        taskTraits.mPriority = i;
        return taskTraits;
    }

    public TaskTraits mayBlock() {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mMayBlock = true;
        return taskTraits;
    }

    public TaskTraits threadPool() {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mUseThreadPool = true;
        return taskTraits;
    }

    public boolean hasExtension() {
        return this.mExtensionId != 0;
    }

    public <Extension> Extension getExtension(TaskTraitsExtensionDescriptor<Extension> taskTraitsExtensionDescriptor) {
        if (this.mExtensionId == taskTraitsExtensionDescriptor.getId()) {
            return taskTraitsExtensionDescriptor.fromSerializedData(this.mExtensionData);
        }
        return null;
    }

    public <Extension> TaskTraits withExtension(TaskTraitsExtensionDescriptor<Extension> taskTraitsExtensionDescriptor, Extension extension) {
        int id = taskTraitsExtensionDescriptor.getId();
        byte[] serializedData = taskTraitsExtensionDescriptor.toSerializedData(extension);
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mExtensionId = (byte) id;
        taskTraits.mExtensionData = serializedData;
        return taskTraits;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TaskTraits) {
            TaskTraits taskTraits = (TaskTraits) obj;
            if (this.mPrioritySetExplicitly == taskTraits.mPrioritySetExplicitly && this.mPriority == taskTraits.mPriority && this.mExtensionId == taskTraits.mExtensionId && Arrays.equals(this.mExtensionData, taskTraits.mExtensionData)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((!this.mPrioritySetExplicitly ? 1 : 0) + SocketMessages.PayloadType.SC_LIVE_BULLET_PLAY_BOTTOM_ENTRANCE) * 37) + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37) + Arrays.hashCode(this.mExtensionData)) * 37) + (!this.mIsChoreographerFrame ? 1 : 0);
    }
}
