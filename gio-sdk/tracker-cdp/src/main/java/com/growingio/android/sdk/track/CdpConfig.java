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

package com.growingio.android.sdk.track;

import com.growingio.android.sdk.Configurable;

public class CdpConfig implements Configurable {
    private String mDataSourceId;

    public String getDataSourceId() {
        return mDataSourceId;
    }

    /**
     * 设置dataSourceId
     *
     * @param dataSourceId 官网的中您的相应APP的DataSourceId
     * @return this
     */
    public CdpConfig setDataSourceId(String dataSourceId) {
        mDataSourceId = dataSourceId;
        return this;
    }
}