package dns.pages.app;

public class BuyButton implements Button {
    private final String add = ".button-ui_passive",
            del = ".remove-button__title";

    @Override
    public String getAddLocal() {
        return add;
    }

    @Override
    public String getDelLocal() {
        return del;
    }
}
