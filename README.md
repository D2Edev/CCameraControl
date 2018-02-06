# CCameraControl

Full name is Chinese Camera Control or CGI Camera Control - use the one you like more
Java wrapper aimed to control chinese IP Cameras which use CGI-BIN and command set like the one described here:
http://www.themadhermit.net/wp-content/uploads/2013/03/FI9821W-CGI-Commands.pdf

Cameras from Foscam, Wanscam, ... etc.

NOTE: project still in development; any part of it could be changed without warning. Watch 'dev' branch for latest changes.


## Getting Started

Start camera instance  as simple as:

``` java
	IPCamera camera = new IPCamera("192.168.0.201", 80, "admin", "admin");

```
then get respective camera service and perform needed action.

Example one - getting image properties, changing them and setting back:

``` java
	VideoService service=camera.getVideoService();
	ImageProperties props=service.getImageProperties();
	System.out.println(props);
	props.setBrightness(70);;
	props.setFlipMode(StringState.DISABLED);
	props.setOptimization(VideoOptimization.FRAMERATE);
	props.setMirrorMode(StringState.ENABLED);
	service.setImageProperties(props);
	System.out.println(props);
```

Example two - getting list of available wireless networks:

``` java
	NetworkService service=camera.getNetworkService();
	System.out.println(service.scanWirelessNetworks());
```

Example three - getting and changing camera time:

``` java
	SystemService service=camera.getSystemService();
	ServerTime time = service.getServerTime();
	time.setDaylightModeStatus(StringState.ENABLED);
	ZoneId zid=ZoneId.of(CameraTimeZone.EUROPE_MOSCOW.stringValue());
	ZonedDateTime zdt=ZonedDateTime.now(zid);
	time.setDateTime(zdt);
	ServerTime changed= service.getServerTime();
	System.out.println("check:" + changed);
```

Example four - backing camera settings up:

``` java
	byte []data=cam.getSystemService().getBackupData();
	System.out.println(data.length);
	try (FileOutputStream fileOuputStream = new FileOutputStream("backup.bin")) {
	  fileOuputStream.write(data);
	} catch (IOException e) {
	  e.printStackTrace();
	}
```
## TODOS

* Not all requests and responses implemented - needs to be done

All subject-related notes and comments are welcome!

