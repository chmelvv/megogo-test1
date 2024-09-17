package megogo;

import io.restassured.response.ValidatableResponse;
import megogo.helpers.CurrentTimeHelper;
import megogo.model.time.TimeResponse;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/** Існує ендпоінт, що має повертати поточний час.
 https://epg.megogo.net/time
 Зробити тест, що сервер дійсно повертає поточний час
 */
public class CurrentTimeTest {
    public static final int ALLOWED_TIME_DIFFERENCE_IN_SECONDS = 5;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy h:mm:ss a XXX");

    @Test
    public void testCurrentTime() {
        ValidatableResponse response = CurrentTimeHelper.getCurrentTime();

        String result = response.extract().jsonPath().getString("result");
        assertThat(result).isEqualTo("ok");

        TimeResponse timeResponse = response
                .extract()
                .jsonPath()
                .getObject("", TimeResponse.class);

        assertThat(timeResponse.getResult()).isEqualTo("ok");

        ZonedDateTime actualTime = ZonedDateTime.parse(timeResponse.getData().getTimeLocal(), dateTimeFormatter);
        ZonedDateTime currentTime = ZonedDateTime.now(actualTime.getZone());
        long timeDifference = Math.abs(actualTime.toEpochSecond() - currentTime.toEpochSecond());
        assertThat(timeDifference).isLessThanOrEqualTo(ALLOWED_TIME_DIFFERENCE_IN_SECONDS);
    }
}