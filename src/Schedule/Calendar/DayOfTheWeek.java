package Schedule.Calendar;

import java.util.ArrayList;

public class DayOfTheWeek {

    private final ArrayList<String> tasks;

    private final int wakeUpTime;

    private final int goToSleepTime;

    DayOfTheWeek(final DayOfTheWeekBuilder dayOfTheWeekBuilder) {
        this.tasks = dayOfTheWeekBuilder.getTasks();
        this.wakeUpTime = dayOfTheWeekBuilder.getWakeUpTime();
        this.goToSleepTime = dayOfTheWeekBuilder.getGoToSleepTime();
    }

    public static class DayOfTheWeekBuilder {

        private ArrayList<String> tasks;

        private int wakeUpTime;

        private int goToSleepTime;

        public DayOfTheWeekBuilder tasks(final ArrayList<String> tasks) {
            this.tasks = tasks;
            return this;
        }

        public DayOfTheWeekBuilder wakeUpTime(final int wakeUpTime){
            this.wakeUpTime = wakeUpTime;
            return this;
        }

        public DayOfTheWeekBuilder goToSleepTime(final int goToSleepTime){
            this.goToSleepTime = goToSleepTime;
            return this;
        }

        public ArrayList<String> getTasks() {
            return tasks;
        }

        public int getWakeUpTime() {
            return wakeUpTime;
        }

        public int getGoToSleepTime() {
            return goToSleepTime;
        }

        public DayOfTheWeek build() {
            return new DayOfTheWeek(this);
        }
    }
}
