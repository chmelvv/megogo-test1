package megogo.model.channel;


import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelResponse {
    private String result;
    private List<ChannelData> data;
}