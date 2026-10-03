package setup;

import java.util.HashMap;

public class Environment {


	/*
	****************************************************************************
	****************************************************************************
	VARIABLES
	****************************************************************************
	****************************************************************************
	*/
	
	private String environmentName;
	
	private String urlBase;
	
	private String urlLogOut;
	
	private String authUser;
	
	private String authPassword;
	
	private String mobileAppIOS;

	private String mobileAppAndroid;
	
	private String mobileAppPackage;
	
	private String mobileAppActivity;
	
	private String desktopApp;
	
	private String desktopAppDummy;
	
	private String description;
	
	private String tiporeport;

	/*
	****************************************************************************
	****************************************************************************
	GETTERS & SETTERS
	****************************************************************************
	****************************************************************************
	*/

	public String getEnvironmentName() {
		return environmentName;
	}


	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}


	public String getUrlBase() {
		return urlBase;
	}


	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}


	public String getUrlLogOut() {
		return urlLogOut;
	}


	public void setUrlLogOut(String urlLogOut) {
		this.urlLogOut = urlLogOut;
	}


	public String getAuthUser() {
		return authUser;
	}


	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}


	public String getAuthPassword() {
		return authPassword;
	}


	public void setAuthPassword(String authPassword) {
		this.authPassword = authPassword;
	}


	public String getMobileAppIOS() {
		return mobileAppIOS;
	}


	public void setMobileAppAndroid(String mobileApp) {
		this.mobileAppAndroid = mobileApp;
	}


	public String getMobileAppAndroid() {
		return mobileAppAndroid;
	}


	public void setMobileAppIOS(String mobileApp) {
		this.mobileAppIOS = mobileApp;
	}


	public String getMobileAppPackage() {
		return mobileAppPackage;
	}


	public void setMobileAppPackage(String mobileAppPackage) {
		this.mobileAppPackage = mobileAppPackage;
	}


	public String getMobileAppActivity() {
		return mobileAppActivity;
	}


	public void setMobileAppActivity(String mobileAppActivity) {
		this.mobileAppActivity = mobileAppActivity;
	}


	public String getDesktopApp() {
		return desktopApp;
	}


	public void setDesktopApp(String desktopApp) {
		this.desktopApp = desktopApp;
	}


	public String getDesktopAppDummy() {
		return desktopAppDummy;
	}


	public void setDesktopAppDummy(String desktopAppDummy) {
		this.desktopAppDummy = desktopAppDummy;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTiporeport() {
		return tiporeport;
	}


	public void setTiporeport(String tiporeport) {
		this.tiporeport = tiporeport;
	}
	
	/*
	****************************************************************************
	****************************************************************************
	CONSTRUCTOR
	****************************************************************************
	****************************************************************************
	*/
	
	public Environment(HashMap<String, String> data) {
		// TODO Auto-generated constructor stub
		this.environmentName = data.get("ENVIRONMENT_NAME");
		this.urlBase = data.get("URL_BASE");
		this.urlLogOut = data.get("URL_LOG_OUT");
		this.authUser = data.get("AUTH_USER");
		this.authPassword = data.get("AUTH_PASSWORD");
		this.mobileAppIOS = data.get("MOBILE_APP_IOS");
		this.mobileAppAndroid = data.get("MOBILE_APP_ANDROID");
		this.mobileAppPackage = data.get("MOBILE_APP_PACKAGE");
		this.mobileAppActivity = data.get("MOBILE_APP_ACTIVITY");
		this.desktopApp = data.get("DESKTOP_APP");
		this.desktopAppDummy = data.get("DESKTOP_APP_DUMY");
		this.description = data.get("DESCRIPTION");
		this.tiporeport = data.get("TIPO_REPORTE");
	}


	@Override
	public String toString() {
		return "Environment [environmentName=" + environmentName + ", urlBase=" + urlBase + ", urlLogOut=" + urlLogOut
				+ ", authUser=" + authUser + ", authPassword=" + authPassword + ", mobileAppIOS=" + mobileAppIOS
				+ ", mobileAppAndroid=" + mobileAppAndroid + ", mobileAppPackage=" + mobileAppPackage
				+ ", mobileAppActivity=" + mobileAppActivity + ", desktopApp=" + desktopApp + ", desktopAppDummy="
				+ desktopAppDummy + ", description=" + description + ", tiporeport="+ tiporeport +"]";
	}


}
