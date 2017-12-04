package io.github.d2edev.ccc;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import io.github.d2edev.ccc.api.IVideoResolution;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.enums.H264profile;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.enums.StringState;
import io.github.d2edev.ccc.enums.VideoOptimization;
import io.github.d2edev.ccc.enums.WiFiSecurityMode;
import io.github.d2edev.ccc.enums.WifiInfrastructureMode;
import io.github.d2edev.ccc.enums.WifiKeyEncryption;
import io.github.d2edev.ccc.models.ImageProperties;
import io.github.d2edev.ccc.models.NetworkProperties;
import io.github.d2edev.ccc.models.OSDProperties;
import io.github.d2edev.ccc.models.VideoEncoderProperties;
import io.github.d2edev.ccc.models.VideoSourceProperties;
import io.github.d2edev.ccc.models.WirelessNetwork;
import io.github.d2edev.ccc.requests.network.PrepareWirelessValidation;
import io.github.d2edev.ccc.requests.video.GetImageProperties;
import io.github.d2edev.ccc.requests.video.SetImageProperties;
import io.github.d2edev.ccc.services.NetworkService;
import io.github.d2edev.ccc.services.VideoService;

public class AppTest {
	private static final String ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	IPCamera camera;
	Random random;

	@Before
	public void init() {
		try {
			camera = new IPCamera("192.168.0.211", 80, ENDPOINT, "admin", "admin");
			random = new Random();
		} catch (Exception e) {
			fail("Failed initing camera");
		}
	}

//	@Test
	public void testVideoPropertiesGetSet() {
		try {
			VideoService service = camera.getVideoService();
			VideoSourceProperties props = service.getVideoSourceProperties();
			System.out.println(props);		
			props.setProfile(H264profile.MAIN);
			List<IVideoResolution> ress=props.getResolutions();
			ress.set(0, VideoSourceProperties.w1280h720);
			ress.set(1, VideoSourceProperties.w640h352);
			props.setResolutions(ress);
			service.setVideoSourceProperties(props);
			VideoSourceProperties anotherProps = service.getVideoSourceProperties();
			assertEquals(props, anotherProps);
		} catch (MarshallException e) {
			fail("Cannot marshall request: " + e.getMessage());
		} catch (IOException e) {
			fail("Message process fail: " + e.getMessage());
		} catch (UnmarshallException e) {
			fail("Cannot unmarshall reply: " + e.getMessage());
		}
	}

	//@Test
	public void testVideoEncoderPropertiesGetSet() {
		try {
			VideoService service = camera.getVideoService();
			VideoEncoderProperties props = service.getVideoEncoderProperties(StreamID.Main);
			System.out.println(props);
			int bps = 256 + random.nextInt(256);
			props.setBps(bps);
			service.setVideoEncoderProperties(props, StreamID.Main);
			VideoEncoderProperties anotherProps = service.getVideoEncoderProperties(StreamID.Main);
			assertEquals(props, anotherProps);
			System.out.println(anotherProps);
		} catch (MarshallException e) {
			fail("Cannot marshall request: " + e.getMessage());
		} catch (IOException e) {
			fail("Message process fail: " + e.getMessage());
		} catch (UnmarshallException e) {
			fail("Cannot unmarshall reply: " + e.getMessage());
		}
	}

	//@Test
	public void testImagePropertiesGetSet() {
		try {
			VideoService service = camera.getVideoService();
			ImageProperties props = service.getImageProperties();
			System.out.println(props);
			props.setBrightness(random.nextInt(100));
			;
			props.setFlipMode(random.nextBoolean() ? StringState.DISABLED : StringState.ENABLED);
			props.setOptimization(random.nextBoolean() ? VideoOptimization.ILLUMINANCE : VideoOptimization.FRAMERATE);
			props.setMirrorMode(random.nextBoolean() ? StringState.DISABLED : StringState.ENABLED);
			service.setImageProperties(props);
			ImageProperties anotherProps = service.getImageProperties();
			assertEquals(props, anotherProps);
			System.out.println(anotherProps);
		} catch (MarshallException e) {
			fail("Cannot marshall request: " + e.getMessage());
		} catch (IOException e) {
			fail("Message process fail: " + e.getMessage());
		} catch (UnmarshallException e) {
			fail("Cannot unmarshall reply: " + e.getMessage());
		}
	}

	//@Test
	public void testOverlayPropertiesGetSet() {
		try {
			VideoService service = camera.getVideoService();
			OSDProperties props = service.getOverlayProperties(OSDRegion.CAPTION);
			System.out.println(props);
			props.setState(random.nextBoolean() ? IntegerState.ENABLED : IntegerState.DISABLED);
			props.setName(UUID.randomUUID().toString().substring(0, 11));
			service.setOverlayProperties(props, OSDRegion.CAPTION);
			OSDProperties anotherProps = service.getOverlayProperties(OSDRegion.CAPTION);
			assertEquals(props, anotherProps);
			System.out.println(anotherProps);
		} catch (MarshallException e) {
			fail("Cannot marshall request: " + e.getMessage());
		} catch (IOException e) {
			fail("Message process fail: " + e.getMessage());
		} catch (UnmarshallException e) {
			fail("Cannot unmarshall reply: " + e.getMessage());
		}
	}

	//@Test
	public void testWifiNetworkGetSet() {
		try {
			NetworkService service = camera.getNetworkService();
			WirelessNetwork props = service.getWirelessSettings();
			System.out.println(props);
			props.setWiFiSecurityMode(random.nextBoolean() ? WiFiSecurityMode.WPA_PSK : WiFiSecurityMode.WPA2_PSK);
			props.setInfrastructureMode(
					random.nextBoolean() ? WifiInfrastructureMode.PEER2PEER : WifiInfrastructureMode.ROUTE);
			props.setState(random.nextBoolean() ? IntegerState.ENABLED : IntegerState.DISABLED);
			props.setSSID(UUID.randomUUID().toString());
			service.setWirelessNetwork(props);
			WirelessNetwork anotherProps = service.getWirelessSettings();
			System.out.println(anotherProps);
			assertEquals(props, anotherProps);
		} catch (MarshallException e) {
			fail("Cannot marshall request: " + e.getMessage());
		} catch (IOException e) {
			fail("Message process fail: " + e.getMessage());
		} catch (UnmarshallException e) {
			fail("Cannot unmarshall reply: " + e.getMessage());
		}
	}

	//@Test
	public void testWifiCheck() {
		try {
			String YOUR_SSID = null;
			String YOUR_PSWD = null;
			NetworkService service = camera.getNetworkService();
			PrepareWirelessValidation setup = new PrepareWirelessValidation();
			WirelessNetwork net = new WirelessNetwork();
			net.setInfrastructureMode(WifiInfrastructureMode.ROUTE);
			net.setWiFiSecurityMode(WiFiSecurityMode.WPA2_PSK);
			net.setKeyEncryption(WifiKeyEncryption.AES);
			net.setState(IntegerState.ENABLED);
			net.setSSID(YOUR_SSID);
			net.setPassphrase(YOUR_PSWD);
			setup.setNetwork(net);
			assertTrue(service.isWirelessConfigurationValid(net));
			WirelessNetwork props = service.getWirelessSettings();
		} catch (MarshallException e) {
			fail("Cannot marshall request: " + e.getMessage());
		} catch (IOException e) {
			fail("Message process fail: " + e.getMessage());
		} catch (UnmarshallException e) {
			fail("Cannot unmarshall reply: " + e.getMessage());
		}
	}

	//@Test
	public void testNetworkGetSet() {
		try {
			NetworkService service = camera.getNetworkService();
			NetworkProperties props = service.getNetworkProperties();
			System.out.println(props);
			props.setFirstDnsIP("8.8.8.8");
			props.setSecondDnsIP("8.8.8.4");
			service.setNetworkProperties(props);
			NetworkProperties anotherProps = service.getNetworkProperties();
			System.out.println(anotherProps);
			assertEquals(props, anotherProps);
		} catch (MarshallException e) {
			fail("Cannot marshall request: " + e.getMessage());
		} catch (IOException e) {
			fail("Message process fail: " + e.getMessage());
		} catch (UnmarshallException e) {
			fail("Cannot unmarshall reply: " + e.getMessage());
		}
	}

}
