package megogo;

import megogo.helpers.TVProgramHelper;
import megogo.model.channel.ChannelData;
import megogo.model.channel.ChannelResponse;
import megogo.model.channel.Program;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/** Існує ендпоінт, що має повертати розклад телепередач на наступні 24 години.
 https://epg.megogo.net/channel?video_ids=
 Для наступних video_id 1639111, 1585681, 1639231 перевірити, що:
 а) програми телепередач (поле programs) відсортовані за полем start_timestamp;
 б) на поточний час існує програма в розкладі (поточний timestamp в рамках
 start_timestamp та end_timestamp);
 в) в розкладі немає телепередач з минулого та далі ніж на 24 години вперед.
 */
public class TVProgramTest {

    @ParameterizedTest
    @ValueSource(ints = { 1639111, 1585681, 1639231 })
    public void testTVProgram(int videoId) {
        ChannelResponse channelResponse = TVProgramHelper.getTVProgram(videoId)
                .extract()
                .jsonPath()
                .getObject("", ChannelResponse.class);
        assertThat(channelResponse.getResult()).isEqualTo("ok");

        List<ChannelData> channels = channelResponse.getData();
        for (ChannelData channel : channels) {
            List<Program> programs = channel.getPrograms();
            assertThat(programs)
                    .withFailMessage("The programs list should not be empty")
                    .isNotEmpty();

            assertThat(programs).isSortedAccordingTo(Comparator.comparingLong(Program::getStart_timestamp));

            long currentTimestamp = System.currentTimeMillis() / 1000;
            assertThat(programs)
                    .withFailMessage("Some program should exists for current time")
                    .anyMatch(p -> p.getStart_timestamp() <= currentTimestamp && p.getEnd_timestamp() >= currentTimestamp);

            assertThat(programs)
                    .withFailMessage("There should be no programs from the past or more than 24 hours ahead")
                    .noneMatch(p -> p.getEnd_timestamp() < currentTimestamp || p.getStart_timestamp() > currentTimestamp + 24 * 60 * 60);
        }
    }
}