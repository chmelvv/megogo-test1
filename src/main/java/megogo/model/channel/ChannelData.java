package megogo.model.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelData {
    private int id;
    private int external_id;
    private String title;
    private Pictures pictures;
    private int video_id;
    private List<Program> programs;
}
