package ss4_object_class.bai_tap;

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


    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch();
        Thread.sleep(3000);
        sw.stop();
        System.out.println("Thời gian chạy: " + sw.getElapsedTime() + " ms");
    }
}
