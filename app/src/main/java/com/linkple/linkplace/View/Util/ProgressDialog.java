package com.linkple.linkplace.View.Util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.PulseRing;
import com.linkple.linkplace.R;

public class ProgressDialog extends Dialog {
    public ProgressDialog(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_progress);

        ProgressBar progressBar = findViewById(R.id.progress);
        Sprite pulseRing = new PulseRing();
        progressBar.setIndeterminateDrawable(pulseRing);
    }
}
