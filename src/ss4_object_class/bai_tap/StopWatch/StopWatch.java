package ss4_object_class.bai_tap.StopWatch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }


    public void start() {
        this.startTime = System.currentTimeMillis();
    }


    public void stop() {
        this.endTime = System.currentTimeMillis();
    }


    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

}
