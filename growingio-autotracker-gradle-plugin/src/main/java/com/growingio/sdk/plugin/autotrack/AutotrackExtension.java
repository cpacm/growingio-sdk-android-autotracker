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

public class AutotrackExtension {
    private boolean mIsLogEnabled = true;
    private boolean mIsDevelopment = false;
    private String[] mExcludePackages;

    public boolean isLogEnabled() {
        return mIsLogEnabled;
    }

    public void setLogEnabled(boolean logEnabled) {
        mIsLogEnabled = logEnabled;
    }

    public boolean isDevelopment() {
        return mIsDevelopment;
    }

    public void setDevelopment(boolean development) {
        mIsDevelopment = development;
    }

    public String[] getExcludePackages() {
        return mExcludePackages;
    }

    public void setExcludePackages(String[] excludePackages) {
        mExcludePackages = excludePackages;
    }
}