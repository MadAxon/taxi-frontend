package taxi.flashka.me.repository.model;

public class DealOfferModel {

    private String date;

    private int id;

    public DealOfferModel(String date, int id) {
        this.date = date;
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
