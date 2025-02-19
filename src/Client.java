
public class Client {
    public static void main(String[] args) {
        Downloader downloader = new FileDownloaderProxy();
        String sourceURL = "https://james.codegym.vn/mod/assign/view.php?id=9334";
        String targetFile = "output-files/proxy-pattern.html";

        downloader.download(sourceURL, targetFile);
    }
}
