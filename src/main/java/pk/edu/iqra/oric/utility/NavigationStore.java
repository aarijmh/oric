package pk.edu.iqra.oric.utility;

public class NavigationStore {
    private Integer type;
    private String landingPage;

    public NavigationStore() {
    }

    public NavigationStore(Integer type, String landingPage) {
        this.type = type;
        this.landingPage = landingPage;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLandingPage() {
        return landingPage;
    }

    public void setLandingPage(String landingPage) {
        this.landingPage = landingPage;
    }
}
