package com.rba.sdkdemo.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import com.rba.sdkdemo.R;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public class Loading {

    private Dialog dialog = null;
    private Context context = null;

    public Loading(Context context){
        this.context = context;

    }

    public void show(){

        if(dialog != null && dialog.isShowing()){

            dialog.dismiss();
        }

        dialog = new Dialog(context, R.style.MyDialog);

        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_progress);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        dialog.show();

    }

    public boolean isShowing() {
        return dialog != null && dialog.isShowing();
    }

    public void dismiss(){
        if(isShowing()){
            dialog.dismiss();
        }
    }
}
