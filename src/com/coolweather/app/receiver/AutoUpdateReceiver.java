package com.coolweather.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @包名: com.coolweather.app.receiver
 * @类名: AutoUpdateReceiver
 * @作者: fml
 * @时间: 2015-8-2 下午9:32:54
 * 
 * @描述: TODO
 * 
 * @SVN版本号: $Rev$
 * @更新时间: $Date$
 * @更新人: $Author$
 * @更新描述: TODO
 */
public class AutoUpdateReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent)
	{
		Intent i = new Intent(context,AutoUpdateReceiver.class);
		context.startService(i);

	}

}
