package com.jimmy.cc;

import com.avos.avoscloud.AVOSCloud;

import android.app.Application;

public class MyApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		AVOSCloud.initialize(this, Configuration.AVOS_APP_ID, Configuration.AVOS_APP_KEY);
	}

}
