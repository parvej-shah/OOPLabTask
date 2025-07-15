public class Constants {

    // Degree options (latest degrees offered by IITDU)
    public static final String[] DEGREES = {
            "BSc in Computer Science and Engineering",
            "MSc in Computer Science and Engineering",
            "PhD in Computer Science and Engineering"
    };
    // Batch numbers
    public static final String[] BATCHNUMBERS = new String[20];
    static {
        for (int i = 0; i < 20; i++) {
            BATCHNUMBERS[i] = String.valueOf(i + 1);
        }
    }
    // roll numbers

    public static final String[] ROLLNUMBERS = new String[56];
    static {
        for (int i = 0; i < 56; i++) {
            ROLLNUMBERS[i] = String.valueOf(i + 1);
        }
    }
    // Preferred playing positions
    public static final String[] POSITIONS = {
            "Goalkeeper",
            "Defender",
            "Midfielder",
            "Forward"
    };

    // Gender options
    public static final String[] GENDERS = {
            "Male",
            "Female",
            "Other"
    };

    // Day options (1–31)
    public static final String[] DAYS = new String[31];
    static {
        for (int i = 0; i < 31; i++) {
            DAYS[i] = String.valueOf(i + 1);
        }
    }

    // Month options (January–December)
    public static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    // Year options (1990–2020)
    public static final String[] YEARS = new String[31];
    static {
        for (int i = 0; i < 31; i++) {
            YEARS[i] = String.valueOf(1990 + i);
        }
    }
}
