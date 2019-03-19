package Schedule;

import Schedule.Calendar.DayOfTheWeek;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Scanner;

//import Tasks.*;

public class Schedule {

    private Scanner scanner = new Scanner(System.in);

    private DayOfTheWeek.DayOfTheWeekBuilder mon = new DayOfTheWeek.DayOfTheWeekBuilder();
    private DayOfTheWeek.DayOfTheWeekBuilder tue = new DayOfTheWeek.DayOfTheWeekBuilder();
    private DayOfTheWeek.DayOfTheWeekBuilder wed = new DayOfTheWeek.DayOfTheWeekBuilder();
    private DayOfTheWeek.DayOfTheWeekBuilder thu = new DayOfTheWeek.DayOfTheWeekBuilder();
    private DayOfTheWeek.DayOfTheWeekBuilder fri = new DayOfTheWeek.DayOfTheWeekBuilder();
    private DayOfTheWeek.DayOfTheWeekBuilder sat = new DayOfTheWeek.DayOfTheWeekBuilder();
    private DayOfTheWeek.DayOfTheWeekBuilder sun = new DayOfTheWeek.DayOfTheWeekBuilder();

    public static void main(String[] args) {
        time();
        new Schedule().schedule();
    }

    private static void time() {
        Formatter f = new Formatter();
        Calendar cal = Calendar.getInstance();
        f.format("%ta %td %tb %tY %tT %tZ", cal, cal, cal, cal, cal, cal);
        System.out.print("\n[Today is " + f + "]\n");
    }

    private void schedule() {
        System.out.print("\nChoice Act:" + "\n\n1 - Record " + "\n2 - Viewing " + "\n\n0 - Exit" + "\n>>> ");
        checkInt();
        int choiceAct = scanner.nextInt();
        switch (choiceAct) {
            case 1:
                choiceDay(choiceAct);
                break;
            case 2:
                choiceDay(choiceAct);
                break;
            case 0:
                break;
            default:
                System.out.print("\nPlease, input '1', '2' or '0'. \n\n");
                schedule();
                break;
        }
    }

    private void choiceDay(int TODO) {

        final int RETURN = 0;
        final int MON_DAY = 1;
        final int TUE_DAY = 2;
        final int WED_DAY = 3;
        final int THU_DAY = 4;
        final int FRI_DAY = 5;
        final int SAT_DAY = 6;
        final int SUN_DAY = 7;

        System.out.printf("Choice Day:\n\n%d - Monday;\n%d - Tuesday;\n%d - Wednesday;\n%d - Thursday;\n%d - Friday\n%d - Saturday;\n%d - Sunday;\n\n%d - Return;\n>>> ",
                MON_DAY, TUE_DAY, WED_DAY, THU_DAY, FRI_DAY, SAT_DAY, SUN_DAY, RETURN);

        checkInt();
        int choiceDay = scanner.nextInt();
        scanner.nextLine();                 // Пропускает строку (Case 1:  Case 2:)
        switch (choiceDay) {
            case MON_DAY:
                System.out.println("Monday:");
                if (TODO == 1) {
                    inputSchedule(mon);
                } else {
                    showSchedule(mon);
                }
                schedule();
                break;
            case TUE_DAY:
                System.out.println("Tuesday:");
                if (TODO == 1) {
                    inputSchedule(tue);
                } else {
                    showSchedule(tue);
                }
                schedule();
                break;
            case WED_DAY:
                System.out.println("Wednesday:");
                if (TODO == 1) {
                    inputSchedule(wed);
                } else {
                    showSchedule(wed);
                }
                schedule();
                break;
            case THU_DAY:
                System.out.println("Thursday:");
                if (TODO == 1) {
                    inputSchedule(thu);
                } else {
                    showSchedule(thu);
                }
                schedule();
                break;
            case FRI_DAY:
                System.out.println("Friday:");
                if (TODO == 1) {
                    inputSchedule(fri);
                } else {
                    showSchedule(fri);
                }
                schedule();
                break;
            case SAT_DAY:
                System.out.println("Saturday:");
                if (TODO == 1) {
                    inputSchedule(sat);
                } else {
                    showSchedule(sat);
                }
                schedule();
                break;
            case SUN_DAY:
                System.out.println("Sunday:");
                if (TODO == 1) {
                    inputSchedule(sun);
                } else {
                    showSchedule(sun);
                }
                schedule();
                break;
            case RETURN:
                schedule();
                break;
            default:
                System.out.print("\nPlease input number from '0' before '7'.");
                choiceDay(TODO);
                break;
        }
    }

    private void inputSchedule(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        ArrayList<String> TASK_ARRAY = taskArray(0);
        System.out.print("\tWake up time?: ");
        checkInt();
        int WAKE_UP = scanner.nextInt();
        System.out.print("\tGo to sleep time?: ");
        checkInt();
        int GO_TO_SLEEP = scanner.nextInt();
        dayOfTheWeek.tasks(TASK_ARRAY).wakeUpTime(WAKE_UP).goToSleepTime(GO_TO_SLEEP).build();
    }

    private ArrayList<String> taskArray = new ArrayList<>();

    private ArrayList<String> taskArray(int NUMBER_CASES) {
        int yesOrNo;
        do {
            System.out.printf("\t\tCase %d: ", NUMBER_CASES + 1);
            String task = scanner.nextLine();
            taskArray.add(task);
            System.out.print("\nIs it all?\n\t1 - Yes;\n\t2 - No;\n>>> ");
            checkInt();
            yesOrNo = scanner.nextInt();
            scanner.nextLine();
            switch (yesOrNo) {
                case 1:
                    break;
                case 2:
                    NUMBER_CASES++;
                    continue;
                default:
                    System.out.print("Input '1' or '2': ");
                    checkInt();
                    scanner.nextInt();
                    scanner.nextLine();
                    taskArray(NUMBER_CASES + 1);
            }
        } while (yesOrNo == 2);
        return taskArray;
    }

    private void showSchedule(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        getTasks(dayOfTheWeek);
    }

    private void getTasks(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        if (checkTasksDay(dayOfTheWeek)) {
            for (int i = 0; i < dayOfTheWeek.getTasks().size(); i++) {
                System.out.printf("\t\tCase %d: ", i + 1);
                System.out.println(dayOfTheWeek.getTasks().get(i));
            }
            replaceOrRemoveCase(dayOfTheWeek);
        } else questionCheckTask(dayOfTheWeek);
    }

    private boolean checkTasksDay(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        return  (dayOfTheWeek.getTasks() != null);
    }

    private void questionCheckTask(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        System.out.print("\nNo Schedule\n\nFill the Schedule for the day now?\n\t1 - Yes;\n\t2 - No;\n>>> ");
        checkInt();
        int yesOrNo = scanner.nextInt();
        scanner.nextLine();
        switch (yesOrNo) {
            case 1:
                inputSchedule(dayOfTheWeek);
                break;
            case 2:
                break;
            default:
                questionCheckTask(dayOfTheWeek);
        }
    }

    private void replaceOrRemoveCase(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        System.out.print("\n1 - Replace case;\n2 - Remove case;\n3 - Remove all;\n4 - Add new case;\n0 - Return\n>>> ");
        checkInt();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                replaceCase(dayOfTheWeek);
                break;
            case 2:
                removeCase(dayOfTheWeek);
                break;
            case 3:
                dayOfTheWeek.getTasks().clear();
                break;
            case 4:
                scanner.nextLine();
                taskArray(dayOfTheWeek.getTasks().size());
                break;
            case 0:
                break;
            default:
                System.out.print("\nPlease, input number from '0' to '3'");
                replaceOrRemoveCase(dayOfTheWeek);
                break;
        }
    }

    private void replaceCase(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        System.out.print("Choice case: ");
        checkInt();
        int choiceCase = scanner.nextInt();
        scanner.nextLine();
        if (choiceCase + 1 <= dayOfTheWeek.getTasks().size()) {
            System.out.printf("\nCase %d: ", choiceCase);
            String replaceCase = scanner.nextLine();
            dayOfTheWeek.getTasks().set(choiceCase - 1, replaceCase);
        } else if(choiceCase <= 0 || choiceCase > dayOfTheWeek.getTasks().size()) {
            System.out.printf("Please, input number from 1 to %d\n",dayOfTheWeek.getTasks().size());
            removeCase(dayOfTheWeek);
        }
    }

    private void removeCase(DayOfTheWeek.DayOfTheWeekBuilder dayOfTheWeek) {
        System.out.print("Choice case: ");
        checkInt();
        int choiceCase = scanner.nextInt();
        if (choiceCase + 1 <= dayOfTheWeek.getTasks().size()) {
            dayOfTheWeek.getTasks().remove(choiceCase - 1);
        } else if(choiceCase <= 0 || choiceCase > dayOfTheWeek.getTasks().size()) {
            System.out.printf("Please, input number from 1 to %d\n",dayOfTheWeek.getTasks().size());
            removeCase(dayOfTheWeek);
        }
    }

    private void checkInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Input number: ");
        }
    }
}
