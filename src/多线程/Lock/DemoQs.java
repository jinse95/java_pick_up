package 多线程.Lock;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * created on 2019/2/11
 *
 * @author J
 **/
public class DemoQs extends AbstractQueuedLongSynchronizer {


    @Override
    protected boolean tryAcquire(long arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected long tryAcquireShared(long arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(long arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
