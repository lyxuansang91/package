/**
 * 
 */
package com.network.available;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.sip.SipSession.State;
import android.os.AsyncTask;
import android.util.Log;

/**
 * @author sang
 * 
 */
public class CheckingNetwork extends AsyncTask<Void, Void, Boolean> {

	private Context mContext;
	private boolean haveConnectedWifi = false;
	private boolean haveConnectedMobileInternet = false;

	public CheckingNetwork(Context mContext) {
		this.mContext = mContext;
	}

	public Boolean haveNetworkConnection() {
		ConnectivityManager connectivityManager = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] netInfo = connectivityManager.getAllNetworkInfo();

		for (NetworkInfo ni : netInfo) {
			if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
				if (ni.isConnected())
					haveConnectedWifi = true;
			}
			if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
				if (ni.isConnected())
					haveConnectedMobileInternet = true;
			}
		}
		return (haveConnectedMobileInternet || haveConnectedWifi);
	}

	public boolean haveInternet(Context ctx) {

		NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx
				.getSystemService(Context.CONNECTIVITY_SERVICE))
				.getActiveNetworkInfo();

		if (info == null || !info.isConnected()) {
			return false;
		}
		if (info.isRoaming()) {
			// here is the roaming option you can change it if you want to
			// disable internet while roaming, just return false
			return false;
		}
		return true;
	}

	public void netWorkState() {
		ConnectivityManager conMan = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		// mobile
		android.net.NetworkInfo.State mobile = conMan.getNetworkInfo(0)
				.getState();

		// wifi
		android.net.NetworkInfo.State wifi = conMan.getNetworkInfo(1)
				.getState();

		if (mobile == NetworkInfo.State.CONNECTED
				|| mobile == NetworkInfo.State.CONNECTING) {
			Log.v("State ", "Mobile connected");
			// mobile
		} else if (wifi == NetworkInfo.State.CONNECTED
				|| wifi == NetworkInfo.State.CONNECTING) {
			// wifi
			Log.v("State", "Wifi Connected");
		}
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

	}

	protected Boolean doInBackground(Void... params) {

		// TODO Auto-generated method stub
		Log.v("DKM THANG KHANH", "call do in background");
		Log.v("Result ", String.valueOf(haveInternet(mContext)));
		netWorkState();

		return haveNetworkConnection();

	}

}
