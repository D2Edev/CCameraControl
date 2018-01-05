package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.IVideoResolution;

public class VideoResolution implements IVideoResolution{

	private int width;
	private int height;
	
	public VideoResolution(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public int getPixelCount() {
		return width*height;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(width).append("x").append(height);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoResolution other = (VideoResolution) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public static String stringify(int width, int height) {
		StringBuilder sb=new StringBuilder();
		sb.append(width).append("x").append(height);
		return sb.toString();
	}
	
	public static VideoResolution valueOf(String value) throws Exception{
		String []array=value.split("[x|X|*|_|-]");
		int width;
		int height;
		if(array.length<2) throw new IllegalArgumentException("Can't understand resolution value: "+value);
		try {
			width = Integer.valueOf(array[0]);			
		} catch (Exception e) {
			throw new IllegalArgumentException("Can't understand resolution part: "+array[0]);
		}
		try {
			height = Integer.valueOf(array[1]);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Can't understand resolution part: "+array[1]);
		}
		return new VideoResolution(width, height);

	}
	
	public static void main(String[] args) {
		try {
			System.out.println(VideoResolution.valueOf("aaa-480"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
}
