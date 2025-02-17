import java.util.HashMap;
import java.util.Map;

public class MessageContainer {

	Map<String, String> content = new HashMap<>();

	public void init() {
		content.put("factum.name", "An open source project initiated by Enrique Esteban, Eduardo Moriana and Jorge Cano, supported by Factum Foundation and other programmers like you\n © Factum Foundation, Madrid, Spain 2018");
		
		content.put("sw.version", "Version 2.0");
		content.put("sw.name", "MANUCAPTURE");
		
		content.put("sw.newproject", "NEW PROJECT");
		content.put("sw.openproject", "LOAD PROJECT");
		content.put("sw.lastproject", "LOAD PREVIOUS");

		content.put("sw.nocamera", "The cameras was not detected, please connect, turn on and restart de application");
		content.put("sw.liveviewenable", "START LIVEVIEW MODE");
		content.put("sw.liveviewdisable", "STOPPING LIVEVIEW MODE");

		content.put("sw.calibration1", "CAPTURING CHART COLOR\n PLEASE OPEN THE MANUSCRIPT AT THE BEGINNING,\n AND PUT THE CHART COLOR ON THIS SIDE");
		content.put("sw.calibration2", "DRAG POINTS TO COVER ALL DE MANUSCRIPT, AND PRESS BUTTON NORMAL");
		content.put("sw.calibration3", "CAPTURING CHART COLOR\n PLEASE OPEN THE MANUSCRIPT AT THE END,\n AND PUT THE CHART COLOR ON THIS SIDE");

		content.put("sw.errorloadingproject", "Can't load project");

		content.put("sw.rotationRightChanged", "Page right camera rotation has changed ");
		content.put("sw.rotationLeftChanged", "Page left camera rotation has changed ");
		content.put("sw.serialRightChanged", "Page right camera serial has changed ");
		content.put("sw.serialLeftChanged", "Page left camera serial has changed ");
		
		content.put("sw.rawWidthChanged", "Raw image width has changed ");
		content.put("sw.rawHeightChanged", "Raw image height has changed ");
		content.put("sw.sourceChanged", "Source scanner has changed ");
		content.put("sw.cameraModelChanged", "Camera model has changed ");
		
		content.put("sw.notconnected", "Can't capture, cameras are not connected, check connection and camera state");
		content.put("sw.notready", "Can't Trigger, cameras are not ready");
		content.put("sw.noeventA", "Camera A Fails, no event after action");
		content.put("sw.noeventB", "Camera B Fails, no event after action");

		content.put("sw.fails", "Camera A And B Fails");
		content.put("sw.failsA", "Camera A Fails");
		content.put("sw.failsB", "Camera B Fails");

		content.put("sw.", "");
		
		content.put("sw.failsSerial", "Trigger board is not working. Please check if it's physically connected to the USB hub and restart the app.\n Click the mouse to continue without shutter.");
		content.put("sw.failsrepository", "Can't create proyect folder, verify repository folder ");
		
		content.put("sw.liveviewlefttitle", "Left Page live view");
		content.put("sw.liveviewrighttitle", "Right Page live view");
		
	}

	public String getText(String key) {
		return content.get(key);
	}

}
