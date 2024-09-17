package megogo.model.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private int id;
    private int external_id;
    private String title;
}