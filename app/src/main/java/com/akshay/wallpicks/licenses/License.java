package com.akshay.wallpicks.licenses;

import com.dm.wallpaper.board.items.InAppBilling;

public class License {

    /*
     * License Checker
     * private static final boolean ENABLE_LICENSE_CHECKER = true; --> enabled
     * Change to private static final boolean ENABLE_LICENSE_CHECKER = false; if you want to disable it
     *
     * NOTE: If you disable license checker you need to remove LICENSE_CHECK permission inside AndroidManifest.xml
     */
    private static final boolean ENABLE_LICENSE_CHECKER = false;

    /*
     * NOTE: If license checker is disabled (above), just ignore this
     *
     * Generate 20 random bytes
     * For easy way, go to https://www.random.org/strings/
     * Set generate 20 random strings
     * Each string should be 2 character long
     * Check numeric digit (0-9)
     * Choose each string should be unique
     * Get string
     */
    private static final byte[] SALT = new byte[]{
            //Put generated random bytes here, separate with comma
            //Ex: 14, 23, 58, 85, ...

    };

    /*
     * Your license key
     * If your app hasn't published at play store, publish it first as beta, get license key
     */
    private static final String LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkiVW5vsD197wuoCnNXU7hV+9Iszd1zxfoCcfqbLXmM51Wi7drZ00Fg5pwoOGMEfqbG9sG8/WHnblgW29J0ZwwoJnZ7pnZ+uLjvdt+3ainfNoWS31V6sL0JX18XJVukcLRokF4Aqzv7kldCDf2Up0cdqha7NwQYA11xhAVUeCm/C29C5Mo8LmSC4iwqO9Wxz6RfeBv+7l3lO0HPIoDpKrBIqDlZnS3Aw1EK/Nl9Sco70Csu0YClTrBnbq20a89ZJdjn0Wyoc9E/IsD6XnBG6KumWmiTIyk11ZUaoGjVF7/dpF3XilMBWDJRBfXhAzQDqBeOyAmoBHc3l/gH3ROyhuCQIDAQAB";

    /*
     * NOTE: Make sure your app name in project same as app name at play store listing
     * NOTE: Your InApp Purchase will works only after the apk published
     */

    /*
     * NOTE: If donation disabled, just ignored this
     *
     * InApp product id for donation
     * Product name displayed the same as product name displayed at play store
     * So make sure to name it properly
     * Format: new InAppBilling("donation product id")
     */
    private static final InAppBilling[] DONATION_PRODUCTS = new InAppBilling[] {
            new InAppBilling("com.akshay.wallpicks.purchases"),
            new InAppBilling("com.akshay.wallpicks.burger"),
            new InAppBilling("com.akshay.wallpicks.pizza"),
            new InAppBilling("com.akshay.wallpicks.meal")
    };

    public static boolean isLicenseCheckerEnabled() {
        return ENABLE_LICENSE_CHECKER;
    }

    public static String getLicenseKey() {
        return LICENSE_KEY;
    }

    public static byte[] getRandomString() {
        return SALT;
    }

    public static String[] getDonationProductsId() {
        String[] productId = new String[DONATION_PRODUCTS.length];
        for (int i = 0; i < DONATION_PRODUCTS.length; i++) {
            productId[i] = DONATION_PRODUCTS[i].getProductId();
        }
        return productId;
    }

}
