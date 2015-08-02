package com.coolweather.app.service;

import com.coolweather.app.util.HttpCallbackListener;
import com.coolweather.app.util.HttpUtil;
import com.coolweather.app.util.Utility;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;

/**
 * @包名: com.coolweather.app.service
 * @类名: AutoUpdateService
 * @作者: fml
 * @时间: 2015-8-2 下午9:24:24
 * 
 * @描述: TODO
 * 
 * @SVN版本号: $Rev$
 * @更新时间: $Date$
 * @更新人: $Author$
 * @更新描述: TODO
 */
public class AutoUpdateService extends Service
{

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		new Thread(new Runnable(){

			@Override
			public void run()
			{
				updateWeather();
				
			}

			}).start();
		return super.onStartCommand(intent, flags, startId);
	}
	
	/**
	 * 更新天气信息。
	 */
	private void updateWeather()
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String weatherCode = prefs.getString("weather_code", "");
		String address = "http://www.weather.com.cn/data/cityinfo/"+weatherCode+".html";
		HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
			
			@Override
			public void onFinish(String response)
			{
				Utility.handleWeatherResponse(AutoUpdateService.this, response);
				
			}
			
			@Override
			public void onError(Exception e)
			{
				e.printStackTrace();
			}
		});
		
	}

}
