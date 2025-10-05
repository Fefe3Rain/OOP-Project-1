package system;

public class Student {
    private String id;
    private String name;
    private String course;

    private double sciencePrelim, scienceMidterm, scienceFinal;
    private double mathPrelim, mathMidterm, mathFinal;
    private double languagePrelim, languageMidterm, languageFinal;
    private double historyPrelim, historyMidterm, historyFinal;
    private double artsPrelim, artsMidterm, artsFinal;
    private double pePrelim, peMidterm, peFinal;
    private double musicPrelim, musicMidterm, musicFinal;
    private double valuesPrelim, valuesMidterm, valuesFinal;

    private double scienceAve, mathAve, languageAve, historyAve, artsAve, peAve, musicAve, valuesAve;
    private double gwa;

    public Student(String id, String name, String course, double sciencePrelim, double scienceMidterm, double scienceFinal,
                   double mathPrelim, double mathMidterm, double mathFinal, double languagePrelim, double languageMidterm, 
                   double languageFinal, double historyPrelim, double historyMidterm, double historyFinal, double artsPrelim, 
                   double artsMidterm, double artsFinal, double pePrelim, double peMidterm, double peFinal, double musicPrelim, 
                   double musicMidterm, double musicFinal, double valuesPrelim, double valuesMidterm, double valuesFinal) {
        this.id = id;
        this.name = name;
        this.course = course;

        this.sciencePrelim = sciencePrelim;
        this.scienceMidterm = scienceMidterm;
        this.scienceFinal = scienceFinal;

        this.mathPrelim = mathPrelim;
        this.mathMidterm = mathMidterm;
        this.mathFinal = mathFinal;

        this.languagePrelim = languagePrelim;
        this.languageMidterm = languageMidterm;
        this.languageFinal = languageFinal;

        this.historyPrelim = historyPrelim;
        this.historyMidterm = historyMidterm;
        this.historyFinal = historyFinal;

        this.artsPrelim = artsPrelim;
        this.artsMidterm = artsMidterm;
        this.artsFinal = artsFinal;

        this.pePrelim = pePrelim;
        this.peMidterm = peMidterm;
        this.peFinal = peFinal;

        this.musicPrelim = musicPrelim;
        this.musicMidterm = musicMidterm;
        this.musicFinal = musicFinal;

        this.valuesPrelim = valuesPrelim;
        this.valuesMidterm = valuesMidterm;
        this.valuesFinal = valuesFinal;

        calculateSubjectAverages();
        calculateGWA();
    }

    private void calculateSubjectAverages() {
        scienceAve = calculate(sciencePrelim, scienceMidterm, scienceFinal);
        mathAve = calculate(mathPrelim, mathMidterm, mathFinal);
        languageAve = calculate(languagePrelim, languageMidterm, languageFinal);
        historyAve = calculate(historyPrelim, historyMidterm, historyFinal);
        artsAve = calculate(artsPrelim, artsMidterm, artsFinal);
        peAve = calculate(pePrelim, peMidterm, peFinal);
        musicAve = calculate(musicPrelim, musicMidterm, musicFinal);
        valuesAve = calculate(valuesPrelim, valuesMidterm, valuesFinal);
    }

    private void calculateGWA() {
        gwa = calculate(scienceAve, mathAve, languageAve, historyAve, artsAve, peAve, musicAve, valuesAve);
    }

    private double calculate(double prelim, double midterm, double finals) {
        return (prelim + midterm + finals) / 3.0;
    }

    private double calculate(double science, double math, double language, double history, double arts, double pe, double music, double values) {
        return (science + math + language + history + arts + pe + music + values) / 8.0;
    }
    // Tagakuha ko
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getGwa() { return gwa; }

    public String getRemarks() {
        if (gwa >= 90) return "Excellent";
        else if (gwa >= 85) return "Very Good";
        else if (gwa >= 80) return "Good";
        else if (gwa >= 75) return "Passed";
        else return "Failed";
    }
}