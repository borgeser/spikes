package com.novoda.tpbot.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.novoda.notils.caster.Views;
import com.novoda.tpbot.R;
import com.novoda.tpbot.ServerDeclarationListener;

public class ServerDeclarationView extends LinearLayout {

    private ServerDeclarationListener serverDeclarationListener = ServerDeclarationListener.NO_OP;

    public ServerDeclarationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.merge_server_declaration, this);

        final EditText serverAddressDeclaration = Views.findById(this, R.id.bot_server_declaration);
        View connectToServer = Views.findById(this, R.id.bot_server_connect);

        connectToServer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String serverAddress = serverAddressDeclaration.getText().toString();
                serverDeclarationListener.onConnect(serverAddress);
            }
        });

        LastServerPreferences lastServerPreferences = LastServerPreferences.newInstance(getContext());
        if (lastServerPreferences.containsLastConnectedServer()) {
            serverAddressDeclaration.setText(lastServerPreferences.getLastConnectedServer());
        }
    }

    public void setServerDeclarationListener(ServerDeclarationListener serverDeclarationListener) {
        this.serverDeclarationListener = serverDeclarationListener;
    }

}