/*
 * Copyright (C) 2020 Beijing Yishu Technology Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.growingio.autotest.help;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Awaiter {
    private static final int DEFAULT_TIMEOUT = 10;

    private Awaiter() {
    }

    public static void untilTrue(Condition condition) {
        untilTrue(condition, DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void untilFalse(Condition condition) {
        untilFalse(condition, DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void untilTrue(Condition condition, long timeout, TimeUnit unit) {
        long remainingNanos = unit.toNanos(timeout);
        long end = System.nanoTime() + remainingNanos;

        while (!condition.await()) {
            if (condition.await()) {
                break;
            }
            if (System.nanoTime() > end) {
                throw new ConditionTimeoutException("expected <true> but was <false> within " + timeout + " " + unit.name());
            }
            Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
        }
    }

    public static void untilFalse(Condition condition, long timeout, TimeUnit unit) {
        long remainingNanos = unit.toNanos(timeout);
        long end = System.nanoTime() + remainingNanos;

        while (condition.await()) {
            if (!condition.await()) {
                break;
            }
            if (System.nanoTime() > end) {
                throw new ConditionTimeoutException("expected <false> but was <true> within " + timeout + " " + unit.name());
            }
            Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
        }
    }

    public static void untilTrue(AtomicBoolean atomic) {
        untilTrue(atomic, DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void untilTrue(AtomicBoolean atomic, long timeout, TimeUnit unit) {
        untilTrue(atomic::get, timeout, unit);
    }

    public static void untilFalse(AtomicBoolean atomic) {
        untilFalse(atomic, DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void untilFalse(AtomicBoolean atomic, long timeout, TimeUnit unit) {
        untilFalse(atomic::get, timeout, unit);
    }
}
