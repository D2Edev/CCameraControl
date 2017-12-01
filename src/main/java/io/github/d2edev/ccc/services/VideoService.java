package io.github.d2edev.ccc.services;

import java.io.IOException;

import io.github.d2edev.ccc.api.AbstractService;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.enums.OSDRegion;
import io.github.d2edev.ccc.enums.StreamID;
import io.github.d2edev.ccc.models.ImageProperties;
import io.github.d2edev.ccc.models.OSDProperties;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.models.VideoEncoderProperties;
import io.github.d2edev.ccc.models.VideoSourceProperties;
import io.github.d2edev.ccc.requests.video.GetImageProperties;
import io.github.d2edev.ccc.requests.video.GetOverlayProperties;
import io.github.d2edev.ccc.requests.video.GetVideoEncoderProperties;
import io.github.d2edev.ccc.requests.video.GetVideoSourceProperties;
import io.github.d2edev.ccc.requests.video.SetImageProperties;
import io.github.d2edev.ccc.requests.video.SetOverlayProperties;
import io.github.d2edev.ccc.requests.video.SetVideoEncoderProperties;
import io.github.d2edev.ccc.requests.video.SetVideoSourceProperties;

public class VideoService extends AbstractService {

	public VideoService(CameraHttpClient client) {
		super(client);
	}

	public ImageProperties getImageProperties() throws MarshallException, IOException, UnmarshallException {
		GetImageProperties request = new GetImageProperties();
		return client.processRequest(request, ImageProperties.class );
	}

	public OSDProperties getOverlayProperties(OSDRegion region)
			throws MarshallException, IOException, UnmarshallException {
		GetOverlayProperties request = new GetOverlayProperties();
		request.setRegion(region);
		return  client.processRequest(request, OSDProperties.class);
	}

	public VideoEncoderProperties getVideoEncoderProperties(StreamID streamID)
			throws MarshallException, IOException, UnmarshallException {
		GetVideoEncoderProperties request = new GetVideoEncoderProperties();
		request.setStreamID(streamID);
		return  client.processRequest(request, VideoEncoderProperties.class);
	}

	public VideoSourceProperties getVideoSourceProperties() throws MarshallException, IOException, UnmarshallException {
		GetVideoSourceProperties request = new GetVideoSourceProperties();
		return  client.processRequest(request, VideoSourceProperties.class);
	}

	public boolean setImageProperties(ImageProperties props)
			throws MarshallException, IOException, UnmarshallException {
		SetImageProperties request = new SetImageProperties();
		request.setProperties(props);
		SimpleResponse response =  client.processRequest(request, SimpleResponse.class);
		return response.isSuccessfull();
	}

	public boolean setOverlayProperties(OSDProperties props, OSDRegion region)
			throws MarshallException, IOException, UnmarshallException {
		SetOverlayProperties request = new SetOverlayProperties();
		request.setProperties(props);
		request.setRegion(region);
		SimpleResponse response =client.processRequest(request,  SimpleResponse.class);
		return response.isSuccessfull();
	}

	public boolean setVideoEncoderProperties(VideoEncoderProperties props, StreamID streamID)
			throws MarshallException, IOException, UnmarshallException {
		SetVideoEncoderProperties request = new SetVideoEncoderProperties();
		request.setProperties(props);
		request.setStreamID(streamID);
		SimpleResponse response = client.processRequest(request, SimpleResponse.class );
		return response.isSuccessfull();
	}

	public boolean setVideoSourceProperties(VideoSourceProperties props)
			throws MarshallException, IOException, UnmarshallException {
		SetVideoSourceProperties request = new SetVideoSourceProperties();
		request.setProperties(props);
		SimpleResponse response =  client.processRequest(request, SimpleResponse.class);
		return response.isSuccessfull();
	}

}
