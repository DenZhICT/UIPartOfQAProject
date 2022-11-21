package dns.pages.app;

public class WishButton implements Button {
    private final String add = ".wishlist-btn",
            del = ".button-ui_done";

    @Override
    public String getAddLocal() {
        return add;
    }

    @Override
    public String getDelLocal() {
        return del;
    }
}
