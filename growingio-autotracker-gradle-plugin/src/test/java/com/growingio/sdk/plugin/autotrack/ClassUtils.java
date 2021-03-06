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

package com.growingio.sdk.plugin.autotrack;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class ClassUtils {
    private ClassUtils() {
    }

    public static InputStream classToInputStream(Class<?> clazz) {
        String className = clazz.getName();
        String classAsPath = className.replace('.', '/') + ".class";
        return clazz.getClassLoader().getResourceAsStream(classAsPath);
    }

    public static byte[] classToByteArray(Class<?> clazz) throws IOException {
        return IOUtils.toByteArray(classToInputStream(clazz));
    }

    public static String getClassName(Class<?> clazz) {
        return clazz.getName().replace(".", "/");
    }
}
