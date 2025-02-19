
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader implements Downloader {
    private String userAgent;

    public FileDownloader() {
    }

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(String fileURL, String saveFile) {
        try {
            URL url = new URL(fileURL);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", userAgent);

            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(saveFile);

            byte[] buffer = new byte[1024];
            int bytesRead = -1;

            System.out.println("Downloading file...");

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
            System.out.println("File downloaded to " + saveFile);

        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
