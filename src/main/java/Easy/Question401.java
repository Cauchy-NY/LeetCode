package Easy;

import java.util.ArrayList;
import java.util.List;

public class Question401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ret = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ret.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ret;
    }
}
