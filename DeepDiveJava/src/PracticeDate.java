public class PracticeDate {
     /* fields */
    private int yearMonthDay;
    private int timeSecond;
    public static void main(String[] args){
        PracticeDate pd = new PracticeDate();
    }/* end main */

    /* methods */
    /* setter */
    public void setYearMonthDay(int yearMonthDay){
        this.yearMonthDay = yearMonthDay;
    }

    public void setTimeSecond(int timeSecond){
        this.timeSecond = timeSecond;
    }/* end setters */

    /* getter */
    public int getYearMonthDay(int yearMonthDay){
        return this.yearMonthDay;
    }

    public int getTimeSecond(int timeSecond){
        return this.timeSecond;
    }
}
