package base.web.utls;

import model.member.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Maths {

    private static final Logger LOG = LoggerFactory.getLogger(Maths.class);

    public static void agg(Member member) {
//        int[] tab = {member.getMmr1v1(), member.getMmr2v2(), member.getMmr3v3(), member.getMmrTour()};
        int[] tab = {member.getMmr1v1(), member.getMmr2v2(), member.getMmr3v3()};
        int min = Arrays.stream(tab).min().getAsInt();
        int max = Arrays.stream(tab).max().getAsInt();
        int sum = Arrays.stream(tab).sum();

        double average = 0;
        if (Arrays.stream(tab).average().isPresent())
            average = Arrays.stream(tab).average().getAsDouble();

        member.setMax(max);
        member.setMin(min);
        member.setSum(sum);
        member.setAverage(average);

        LOG.info(member.toString());
    }

}
