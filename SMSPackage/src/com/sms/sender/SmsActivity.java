package com.sms.sender;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SmsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
		SMSObject sms = new SMSObject();
		sms.setMessageSMS("THANH TOAN ABC");
		sms.setPhoneNumber("01647942877");
			
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("SMS:" + sms.getPhoneNumber()));
		intent.putExtra("sms_body", sms.getMessageSMS());
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sms, menu);
		return true;
	}

}
