package by.etc.somnum;

//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.

import java.util.Scanner;

class Calendar {

    int year;
    int month;
    private Day[] daysArray;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Calendar() {

        this.year = 0;
        this.month = 0;
    }

    public Calendar(int year, int month) {

        this.year = year;
        this.month = month;
    }

    private class Day {

        int numberDay;
        boolean weekend;
        boolean holiday;

        public Day() {

            this.numberDay = 0;
            this.weekend = false;
            this.holiday = false;
        }

        public Day(int year, int month, int numberDay, boolean holiday, boolean weekend) {

            this.numberDay = numberDay;
            this.weekend = weekend;
            this.holiday = holiday;
        }

        public int getNumberDay() {
            return numberDay;
        }

        public void setNumberDay(int numberDay) {
            this.numberDay = numberDay;
        }

        public boolean isWeekend() {
            return weekend;
        }

        public void setWeekend(boolean weekend) {
            this.weekend = weekend;
        }

        public boolean isHoliday() {
            return holiday;
        }

        public void setHoliday(boolean holiday) {
            this.holiday = holiday;
        }

    }

    public void setCalendar() {

        System.out.println("Это календарь в котором ты можешь пометить праздничные и выходные дни!");
        System.out.print("На сколько дней вы хотите заполнить свой календарь?: ");
        Scanner reader = new Scanner(System.in);
        int userInput = reader.nextInt();

        daysArray = new Day[userInput];

        System.out.print("Какой год вы хотите заполнить?: ");
        int userYear = reader.nextInt();
        this.year = userYear;

        System.out.print("Какой месяц вы хотите заполнить? Месяц вводите цифрой: ");
        int userMonth = reader.nextInt();
        this.month = userMonth;

        for (int i = 0; i < userInput; i++) {

            System.out.println("День " + (i + 1) + ": ");
            System.out.print("Число дня: ");
            int userDay = reader.nextInt();

            System.out.print("Выберите: 1) праздник 2) выходной день : ");
            int userChoice = reader.nextInt();
            boolean userHoliday = false;
            boolean userWeekend = false;
            if (userChoice == 1) {
                userHoliday = true;
            } else if (userChoice == 2) {
                userWeekend = true;
            }
            daysArray[i] = new Day(userYear, userMonth, userDay, userHoliday, userWeekend);
        }
    }

    public void printCalendar() {

        if (this.daysArray.length != 0) {

            System.out.println("============================");
            System.out.println("Год: " + this.year);
            System.out.println("Месяц: " + this.month);
            System.out.println("____________________________");

            for (int i = 0; i < this.daysArray.length; i++) {

                System.out.format("День %d ", i + 1);
                System.out.format("\n\tЧисло: %2d ", this.daysArray[i].numberDay);

                if (this.daysArray[i].holiday == true) {
                    System.out.println("- праздник");
                }
                if (this.daysArray[i].weekend == true) {
                    System.out.println("- выходной");
                }
            }
            System.out.println("============================");
        } else {
            System.out.println();
            System.out.println("Массив не создан");
        }
    }
}

public class OOP_exe_3 {

    public static void main(String[] args) {

        Calendar calendarOne = new Calendar();
        calendarOne.setCalendar();
        calendarOne.printCalendar();
    }
}
