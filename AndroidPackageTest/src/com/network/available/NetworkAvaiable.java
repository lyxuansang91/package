/**
 * 
 */
package com.network.available;

/**
 * @author sang/**
 * 
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * @author sang
 *
 */
public class NetworkAvaiable {
	private Context mContext;
	private boolean haveConnectedWifi; 
	private boolean haveConnectedMobileInternet;
	public boolean haveNetworkConnection(){
		ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] netInfo = connectivityManager.getAllNetworkInfo();
		for(NetworkInfo ni : netInfo) {
			if(ni.getTypeName().equalsIgnoreCase("WIFI")) {
				if(ni.isConnected())
					haveConnectedWifi = true;
			} else {
				if(ni.isConnected())
					haveConnectedMobileInternet = true;
			}
		}
		return (haveConnectedMobileInternet || haveConnectedWifi);
	}
		
	public NetworkAvaiable(){
		
	}
	
	
}


