package io.github.d2edev.ccc;

import java.io.FileOutputStream;
import java.io.IOException;

import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;

public class FileTest {

	private static final String IP = "192.168.0.212";

	public static void main(String[] args) {
		IPCamera cam=new IPCamera(IP, IPCamera.DEFAULT_HTTP_PORT, "admin", "admin");
		try {
			byte []data=cam.getSystemService().getBackupData();
			System.out.println(data.length);
			try (FileOutputStream fileOuputStream = new FileOutputStream("backup.bin")) {
	            fileOuputStream.write(data);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		} catch (MarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnmarshallException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
