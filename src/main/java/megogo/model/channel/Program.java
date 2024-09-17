package megogo.model.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Program {
    private int external_id;
    private String title;
    private Category category;
    private Pictures pictures;
    private long start_timestamp;
    private long end_timestamp;
    private int id;
    private String start;
    private String end;
    private String virtual_object_id;
    private String schedule_type;
}