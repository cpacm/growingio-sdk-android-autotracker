/*
 *   Copyright (C) 2020 Beijing Yishu Technology Co., Ltd.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.growingio.android.sdk.autotrack.inject;


import android.app.AlertDialog;
import android.content.DialogInterface;

import com.growingio.android.sdk.track.utils.ClassExistHelper;


public class DialogInjector {

    private DialogInjector() {
    }

    public static void alertDialogShow(AlertDialog alertDialog) {
        DialogClickProvider.alertDialogShow(alertDialog);
    }

    public static void dialogOnClick(DialogInterface.OnClickListener listener, DialogInterface dialogInterface, int which) {
        if (dialogInterface instanceof AlertDialog) {
            DialogClickProvider.alertDialogOnClick((AlertDialog) dialogInterface, which);
        } else if (ClassExistHelper.instanceOfAndroidXAlertDialog(dialogInterface)) {
            DialogClickProvider.alertDialogXOnClick((androidx.appcompat.app.AlertDialog) dialogInterface, which);
        } else if (ClassExistHelper.instanceOfSupportAlertDialog(dialogInterface)) {
            DialogClickProvider.alertDialogSupportOnClick((android.support.v7.app.AlertDialog) dialogInterface, which);
        }
    }
}