import com.google.gson.annotations.SerializedName;

public class Cotacao {
    private String code;
    private String name;
    private String bid;
    private String low;

    @SerializedName("high")
    private String high;

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getBid() { return bid; }
    public String getHigh() { return high; }
    public String getLow() { return low; }
}
