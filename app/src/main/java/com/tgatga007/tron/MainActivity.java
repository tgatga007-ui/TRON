package com.tgatga007.tron;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Informational placeholder only. This screen intentionally has no wallet,
 * key-management, blockchain-network, signing, or transfer functionality.
 */
public final class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView message = new TextView(this);
        message.setGravity(Gravity.CENTER);
        message.setPadding(32, 32, 32, 32);
        message.setTextSize(18);
        message.setText(
                "TRON Wallet — preview\n\n"
                + "Planned networks: TRON · Ethereum · Bitcoin · Solana\n\n"
                + "This is a documentation scaffold, not a working wallet.\n"
                + "Do not enter a recovery phrase or send funds.");
        setContentView(message);
    }
}
