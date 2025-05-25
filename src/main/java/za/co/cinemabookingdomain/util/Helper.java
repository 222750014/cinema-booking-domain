package za.co.cinemabookingdomain.util;

import za.co.cinemabookingdomain.Domain.Customer;
import za.co.cinemabookingdomain.Domain.Promotion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    // South African phone number: optionally starts with +27, followed by 9 digits (making 10 total)
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^(\\+27)?\\d{9}$");

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }

    public static Customer createCustomer(String name, String email, String phone, Integer loyaltyPoints) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (!isValidPhoneNumber(phone)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        return new Customer.Builder()
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setLoyaltyPoints(loyaltyPoints != null ? loyaltyPoints : 0)
                .build();
    }

    public static String generateDiscountCode() {
        return "DISCOUNT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public static boolean isExpired(Promotion promotion) {
        return promotion != null &&
                promotion.getEndDate().isBefore(ZonedDateTime.now(ZoneId.of("Africa/Johannesburg")).toLocalDateTime());
    }

    public static boolean isActivePromotion(Promotion promotion) {
        return promotion != null && !isExpired(promotion);
    }

    public static String formatDate(LocalDate date) {
        return date != null ? date.format(DATE_FORMATTER) : "N/A";
    }

    public static String generateUniqueId(String prefix) {
        return (prefix != null ? prefix + "-" : "") + UUID.randomUUID().toString().substring(0, 12);
    }

    public static boolean isNotNullOrEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static void validateNotNull(Object obj, String fieldName) {
        if (obj == null) {
            throw new IllegalArgumentException(fieldName + " must not be null");
        }
    }

    public static boolean isLoyalCustomer(Customer customer) {
        return customer != null && customer.getLoyaltyPoints() >= 100;
    }

    public static boolean isInvalidcustomerName(String customerName) {
        return customerName == null || customerName.trim().length() < 2;
    }

    public static boolean isInvalidbookingTime(String bookingTime) {
        return bookingTime == null || bookingTime.trim().isEmpty(); // Optional: validate format
    }

    public static boolean isInvalidbookingDate(String bookingDate) {
        try {
            if (bookingDate == null) return true;
            LocalDate.parse(bookingDate); // ISO format yyyy-MM-dd
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isInvalidgenre(String genre) {
        return genre == null || genre.trim().isEmpty();
    }

    public static boolean isInvalduration(String duration) {
        try {
            return duration == null || Integer.parseInt(duration) <= 0;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isInvalidlanguage(String language) {
        return language == null || language.trim().length() < 2;
    }

    public static boolean isInvalidseatType(String seatType) {
        return seatType == null || seatType.trim().isEmpty();
    }

    public static boolean isInvalidseatRow(String seatRow) {
        return seatRow == null || !seatRow.matches("[A-Z]");
    }
}