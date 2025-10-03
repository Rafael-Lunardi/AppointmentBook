public class AppointmentBook {
    private boolean[][] schedule;

    public AppointmentBook(boolean[][] schedule) {
        this.schedule = schedule;
    }

    private boolean isMinuteFree(int period, int minute) {
        return schedule[period - 1][minute];
    }

    public int findFreeBlock(int period, int duration) {
        int block = 0;
        for (int i = 0; i<60; i++) {
            if (isMinuteFree(period, i)) {
                block++;
                if(block == duration){
                    return (i - block + 1);
                }
            } else block = 0;
        }
        return -1;
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        for (int i = startPeriod; i < endPeriod; i++) {
            int freeBlock =  findFreeBlock(i, duration);
        }
        return false;
    }

    private void reserveBlock(int period, int startMinute, int duration) {
        for (int i = startMinute; i < duration; i++) schedule[period - 1][i] = false;
    }

    public void printPeriod(int period) {
        for (int i = 0; i < schedule[period - 1].length; i++) {
            System.out.println(i + " " + schedule[period - 1][i]);
        }
    }
}
