package nyc.c4q.RusiLi.Draw;

public class Animation {

    public static void stop(double time) {
        boolean stop = false;
        if (stop)
            throw new RuntimeException("frame is already finished");
        try {
            Thread.sleep((int) (time * 1000)); // time is in milliseconds. Multiplying by 1000 gives us seconds.
        } catch (InterruptedException e) {
            // Ignore.
        }
        stop = true;
    }

}
