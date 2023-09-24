package it.ryther.projectriot.API.Queues;

import java.util.List;

public class QueueUtils {
    public static Queue getQueue(List<Queue> queues, long queueId) {
        for (Queue q : queues) {
            if (q.getQueueId() == queueId) {
                return q;
            }
        }
        return null;
    }
}
