package Problem2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class CallCenter <T> {
    private final static int POOl_Size = 3;
    private final Semaphore sem = new Semaphore(POOl_Size, true);
    private final Queue<T> resources = new LinkedList<T>();

    public CallCenter(Queue<T> source) {
        resources.addAll(source);
    }

    public T getResourc(long maxWaitMillis) throws Exception {
        try {
            if (sem.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                T res = resources.poll();
                return res;
            }
        } catch (InterruptedException e) {
            throw new Exception(e);
        }
        throw new Exception(": timeout");
    }

    public void returnResource(T res) {
        resources.add(res);
        sem.release();
    }
}
