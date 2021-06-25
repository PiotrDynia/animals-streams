public class AnimalCharacteristics {
    private double body_wt;
    private double brain_wt;
    private double non_dreaming;
    private double dreaming;
    private double total_sleep;
    private double life_span;
    private double gestation;
    private int predation;
    private int exposure;
    private int danger;

    public AnimalCharacteristics() {
    }

    @Override
    public String toString() {
        String s1 = "AnimalCharacteristics{" +
                "body_wt=" + body_wt +
                ", brain_wt=" + brain_wt +
                ", non_dreaming=" + non_dreaming +
                ", dreaming=" + dreaming +
                ", total_sleep=" + total_sleep +
                ", life_span=" + life_span +
                ", gestation=" + gestation +
                ", predation=" + predation +
                ", exposure=" + exposure +
                ", danger=" + danger +
                '}';
            String replaceString = s1.replaceAll("=0.0,", "=unknown,");
            return replaceString;
    }

    public void setBody_wt(double body_wt) {
        this.body_wt = body_wt;
    }

    public void setNon_dreaming(double non_dreaming) {
        this.non_dreaming = non_dreaming;
    }

    public void setDreaming(double dreaming) {
        this.dreaming = dreaming;
    }

    public void setTotal_sleep(double total_sleep) {
        this.total_sleep = total_sleep;
    }

    public void setLife_span(double life_span) {
        this.life_span = life_span;
    }

    public void setGestation(double gestation) {
        this.gestation = gestation;
    }

    public void setPredation(int predation) {
        this.predation = predation;
    }

    public void setExposure(int exposure) {
        this.exposure = exposure;
    }

    public void setDanger(int danger) {
        this.danger = danger;
    }

    public void setBrain_wt(double brain_wt) {
        this.brain_wt = brain_wt;
    }

    public double getBody_wt() {
        return body_wt;
    }

    public double getDreaming() {
        return dreaming;
    }

    public double getTotal_sleep() {
        return total_sleep;
    }

    public double getLife_span() {
        return life_span;
    }

    public double getDreamtoTotal(){
        double percentage = (dreaming/total_sleep)*100;
        return percentage;
    }

    public synchronized void feed(){
        this.body_wt += body_wt*(((Math.random()*1.5)+0.5)/100);
    }

    public synchronized void burn(){
        this.body_wt -= (1.4*body_wt)/100;
    }
    public String round(double value){
        String strDouble = String.format("%.2f", value);
        return strDouble;
    }
}
