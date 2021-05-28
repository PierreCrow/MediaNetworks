package com.futuremobile.wox.presentation.utiles.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.futuremobile.wox.R;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class DialogUI {

    private Context context;

    public DialogUI(Context context) {
        this.context = context;
    }


    public void showDialogConfirmation(String title, String question, boolean isCancelable, final ConfirmationDialogCallback callback) {
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(isCancelable);
        this._showDialogConfirmation(dialog, title, question, callback);
    }

    public void showDialogYesNoQuestion(String title, String question, boolean isCancelable, final YesNoQuestionDialogCallback callback) {
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(isCancelable);
        this._showDialogYesNoQuestion(dialog,title, question,isCancelable, callback);
    }

    public void showDialogError(String title, boolean isCancelable, final ErrorDialogCallback callback) {
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(isCancelable);
        this._showDialogError(dialog,title, callback);
    }



    private void _showDialogConfirmation(final Dialog dialog, String title, String question, final ConfirmationDialogCallback callback) {

        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert_confirm);
        TextView tvTitle = (TextView) dialog.findViewById(R.id.title_alert_question_ConfirmNetWork);
        TextView tvQuestion = (TextView)dialog.findViewById(R.id.txt_question_ConfirmNetwork);

        tvTitle.setText(title);
        tvQuestion.setText(question);

        ImageView imageView = dialog.findViewById(R.id.imageViewIcon);
       // imageView.setImageResource(_getDrawableIconToModal(type));

        Button btnConfirm = dialog.findViewById(R.id.btn_accept_alerts);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (callback != null) {
                    callback.onConfirmDialog();
                }
            }
        });

        dialog.show();
    }


    public void _showDialogYesNoQuestion(final Dialog dialog,String title, String disclaimer, boolean isCancelable, final YesNoQuestionDialogCallback callback) {
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation_2;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert_questions);
        TextView tvTitle = dialog.findViewById(R.id.title_alert_question);
        TextView tvDisclaimer = dialog.findViewById(R.id.txt_question);
        tvTitle.setText(title);
        tvDisclaimer.setText(disclaimer);

      //  ImageView imageView = dialog.findViewById(R.id.imageViewIcon);
      //  imageView.setImageResource(_getDrawableIconToModal(type));

        Button btnCancel = dialog.findViewById(R.id.btn_cancel_alert);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                callback.onNoAccept();
            }
        });

        Button btnConfirm = dialog.findViewById(R.id.btn_accept_alert);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                callback.onAccept();
            }
        });

        dialog.show();
    }


    private void _showDialogError(final Dialog dialog, String title, final ErrorDialogCallback callback) {
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert_confirm);
        TextView tvTitle = dialog.findViewById(R.id.title_alert_question);
        tvTitle.setText(title);

        ImageView imageView = dialog.findViewById(R.id.imageViewIcon);
        // imageView.setImageResource(_getDrawableIconToModal(type));

        Button btnConfirm = dialog.findViewById(R.id.btn_accept_alerts);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (callback != null) {
                    callback.onAccept();
                }
            }
        });

        dialog.show();
    }


    private int _getDrawableIconToModal(int type) {
        int iconModal = R.drawable.ic_verified;
        switch (type) {
            case Constantes.TYPE_DIALOG.TYPE_ERROR:

                break;
            case Constantes.TYPE_DIALOG.TYPE_LOG_OUT:
                iconModal = R.drawable.ic_logout;
                break;
            case Constantes.TYPE_DIALOG.TYPE_WARNING:
                iconModal = R.drawable.ic_warning;
                break;
            case Constantes.TYPE_DIALOG.TYPE_OVERALL:
               // iconModal = R.drawable.ic_logo_aura;
                break;
            case Constantes.TYPE_DIALOG.TYPE_SYNC:
                iconModal = R.drawable.ic_sync_modal;
                break;
            case Constantes.TYPE_DIALOG.TYPE_SUCCESS:
                iconModal = R.drawable.ic_verified;
                break;
        }
        return iconModal;
    }


}
