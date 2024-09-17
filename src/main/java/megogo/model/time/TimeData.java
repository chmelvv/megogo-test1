package megogo.model.time;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeData {
    @JsonProperty("utc_offset")
    private int utcOffset;

    @JsonProperty("timestamp_gmt")
    private long timeStampGmt;

    @JsonProperty("timestamp_local")
    private long timeStampLocal;

    @JsonProperty("timezone")
    private String timeZone;

    @JsonProperty("timestamp")
    private long timeStamp;

    @JsonProperty("time_local")
    private String timeLocal;
}