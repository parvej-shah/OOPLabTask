public class Validator {

    // Returns true if all required fields are filled, false otherwise
    public static boolean isValid(Participant p) {

        if (isEmpty(p.getName())) return false;
        if (isEmpty(p.getPhone())) return false;
        if (isEmpty(p.getEmail())) return false;
        if (isEmpty(p.getAddress())) return false;
        if (isEmpty(p.getGender())) return false;
        if (isEmpty(p.getDateOfBirth())) return false;
        if (isEmpty(p.getDegree())) return false;
        if (isEmpty(p.getPicturePath())) return false;
        if (isEmpty(p.getPreferredPosition())) return false;
        return !isEmpty(p.getExperience());
    }

    // Helper method to check for null or empty string
    private static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
