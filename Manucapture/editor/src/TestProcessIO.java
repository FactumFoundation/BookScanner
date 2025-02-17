import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestProcessIO {

	public static boolean isAlive(Process p) {
		try {
			p.exitValue();
			return false;
		} catch (IllegalThreadStateException e) {
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		ProcessBuilder builder = new ProcessBuilder("bash", "-c","stdbuf -oL gphoto2 --capture-tethered --port usb:002,011 --force-overwrite --filename /home/veronica1/.manucapture/A.cr2");
		builder.redirectErrorStream(true); // so we can ignore the error stream
		Process process = builder.start();
		InputStream out = process.getInputStream();
		OutputStream in = process.getOutputStream();

		byte[] buffer = new byte[400];
		while (isAlive(process)) {
			int no = out.available();
			if (no > 0) {
				int n = out.read(buffer, 0, Math.min(no, buffer.length));
				System.out.println(new String(buffer, 0, n));
			}

			int ni = System.in.available();
			if (ni > 0) {
				int n = System.in.read(buffer, 0, Math.min(ni, buffer.length));
				in.write(buffer, 0, n);
				in.flush();
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}

		System.out.println(process.exitValue());
	}
}