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
package com.growingio.android.sdk.autotrack;

import android.text.TextUtils;

import com.growingio.android.sdk.AppGioModule;
import com.growingio.sdk.annotation.GIOAppModule;
import com.growingio.sdk.annotation.GIOTracker;

/**
 * <p>
 *
 * @author cpacm 5/12/21
 */
@GIOAppModule(name = "GrowingAutotracker", config = CdpAutotrackConfig.class, configName = "CdpAutotrack")
public final class GrowingAppModule extends AppGioModule {

    @GIOTracker(name = CdpAutotracker.class)
    public void config(CdpAutotrackConfiguration configuration) {
        if (TextUtils.isEmpty(configuration.getDataSourceId())) {
            throw new IllegalStateException("DataSourceId is NULL");
        }
    }
}
