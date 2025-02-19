
public class FileDownloaderProxy implements Downloader {
    private FileDownloader fileDownloader;
    private String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:90.0) Gecko/20100101 Firefox/90.0";

    public FileDownloaderProxy() {
        fileDownloader = new FileDownloader(userAgent);
    }

    @Override
    public void download(String fileURL, String saveFile) {
        fileDownloader.download(fileURL, saveFile);
    }
}
