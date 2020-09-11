package framework.entity;

public class BrowserValues {

    private boolean isRemote = false;
    private String host = "";
    private String browser = "";
    private int port = -1;
    private String url = "";
    private long timeout = 0;

    public BrowserValues(boolean isRemote, String host, String browser, int port, String url, long timeout) {
        this.isRemote = isRemote;
        this.host = host;
        this.browser = browser;
        this.port = port;
        this.url = url;
        this.timeout = timeout;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
