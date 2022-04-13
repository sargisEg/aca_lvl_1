package com.homework.week9.generic.queue;

import com.aca.homework.week9.generic.queue.Queue;
import com.aca.homework.week9.generic.queue.QueueEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class QueueTest {

    private Queue<String> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Queue<>();
    }

    @Test
    public void testWhenProduceIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.produce(null);
            }
        });
    }

    @Test
    public void testConsumeWhenContains1Item() {
        testSubject.produce("test");
        Assertions.assertEquals("test", testSubject.consume());
    }

    @Test
    public void testConsumeWhenQueueIsEmpty() {
        Assertions.assertThrows(QueueEmptyException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.consume();
            }
        });
    }

    @Test
    public void testConsume2TimesWhenQueueContains2Items() {
        testSubject.produce("test1");
        testSubject.produce("test2");
        Assertions.assertEquals("test2", testSubject.consume());
        Assertions.assertEquals("test1", testSubject.consume());
    }

}