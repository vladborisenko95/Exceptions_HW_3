public class UserData {

    private String lastName;
    private String firstName;
    private String patronymic;
    private String dateOfBirth;
    private String phoneNumber;
    private char gender;

    public UserData(String[] data) throws InvalidDataFormatException {
        if (data.length != 12) {
            throw new InvalidDataFormatException("Invalid number of data fields");
        }

        // Extract data fields
        for (int i = 0; i < 12; i += 2) {
            String key = data[i].toLowerCase();
            String value = data[i + 1];

            switch (key) {
                case "1":
                    lastName = value;
                    break;
                case "2":
                    firstName = value;
                    break;
                case "3":
                    patronymic = value;
                    break;
                case "4":
                    dateOfBirth = value;
                    break;
                case "5":
                    phoneNumber = value;
                    break;
                case "6":
                    gender = value.toLowerCase().charAt(0);
                    break;
                default:
                    throw new InvalidDataFormatException("Unknown data field: " + data[i]);
            }
        }

        validateDataFields();
    }

    private void validateDataFields() throws InvalidDataFormatException {
        if (lastName == null || firstName == null || patronymic == null ||
            dateOfBirth == null || phoneNumber == null) {
            throw new InvalidDataFormatException("Missing data fields");
        }

        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new InvalidDataFormatException("Invalid date of birth format");
        }

        if (!phoneNumber.matches("(8|\\+7)\\d{10}")) {
            throw new InvalidDataFormatException("Invalid phone number format");
        }

        if (gender != 'f' && gender != 'm') {
            throw new InvalidDataFormatException("Invalid gender");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return lastName + " " + firstName + " " + patronymic + " " + dateOfBirth +
               " " + phoneNumber + " " + gender;
    }
}