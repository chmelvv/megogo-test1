package megogo.model.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pictures {
    private String original;
    private String _105x85;
    private String _180x180;
    private String _980x560;
    private String _88x65;
    private String _88x88;
    private String _105x105;
    private String _40x40;
    private String _150x150;
    private String _1600x520;
}