package entities;

/**
 *  Class Name: Menu.java
 *  Intro: An entity class to store Menu Modification Info, which is sold out, and price modification.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Menu {
    private static boolean Soup_Tonkotsu;
    private static boolean Soup_Shoyu;
    private static boolean Soup_Shio;
    private static boolean Noodles_Soft;
    private static boolean Noodles_Medium;
    private static boolean Noodles_Firm;
    private static boolean Nori;
    private static boolean Boiled_egg;
    private static boolean Bamboo_shoots;
    private static boolean Chashu;
    private static float P_E_Nori;
    private static float P_E_Chashu;
    private static float P_E_boiledEgg;
    private static float P_Bamboo_Shoots;
    private static float Fixed_price;

    /**
     * Method Name: isSoup_tonkotsu()
     * Intro: return the status of Tonkotsu, remained or sold out
     * @return a boolean value
     */
    public static boolean isSoup_Tonkotsu() {
        return Soup_Tonkotsu;
    }

    /**
     * Method Name: setSoup_Tonkotsu()
     * Intro: set the status of Tonkotsu, remained or sold out
     * @param soup_Tonkotsu new status
     */
    public static void setSoup_Tonkotsu(boolean soup_Tonkotsu) {
        Soup_Tonkotsu = soup_Tonkotsu;
    }

    /**
     * Method Name: isSoup_Shoyu()
     * Intro: return the status of Shoyu, remained or sold out
     * @return a boolean value
     */
    public static boolean isSoup_Shoyu() {
        return Soup_Shoyu;
    }

    /**
     * Method Name: setSoup_Shoyu()
     * Intro: set the status of Shoyu, remained or sold out
     * @param soup_Shoyu new status
     */
    public static void setSoup_Shoyu(boolean soup_Shoyu) {
        Soup_Shoyu = soup_Shoyu;
    }

    /**
     * Method Name: isSoup_Shio()
     * Intro: return the status of Shio, remained or sold out
     * @return a boolean value
     */
    public static boolean isSoup_Shio() {
        return Soup_Shio;
    }

    /**
     * Method Name: setSoup_Shio()
     * Intro: set the status of Shio, remained or sold out
     * @param soup_Shio new status
     */
    public static void setSoup_Shio(boolean soup_Shio) {
        Soup_Shio = soup_Shio;
    }

    /**
     * Method Name: isNoodles_Soft()
     * Intro: return the status of Noodles_Soft, remained or sold out
     * @return a boolean value
     */
    public static boolean isNoodles_Soft() {
        return Noodles_Soft;
    }

    /**
     * Method Name: setNoodles_Soft()
     * Intro: set the status of Noodles_Soft, remained or sold out
     * @param noodles_Soft new status
     */
    public static void setNoodles_Soft(boolean noodles_Soft) {
        Noodles_Soft = noodles_Soft;
    }

    /**
     * Method Name: isNoodles_Medium()
     * Intro: return the status of Noodles_Medium, remained or sold out
     * @return a boolean value
     */
    public static boolean isNoodles_Medium() {
        return Noodles_Medium;
    }

    /**
     * Method Name: setNoodles_Medium()
     * Intro: set the status of Noodles_Medium, remained or sold out
     * @param noodles_Medium new status
     */
    public static void setNoodles_Medium(boolean noodles_Medium) {
        Noodles_Medium = noodles_Medium;
    }

    /**
     * Method Name: isNoodles_Firm()
     * Intro: return the status of Noodles_Firm, remained or sold out
     * @return a boolean value
     */
    public static boolean isNoodles_Firm() {
        return Noodles_Firm;
    }

    /**
     * Method Name: setNoodles_Firm()
     * Intro: set the status of Noodles_Firm, remained or sold out
     * @param noodles_Firm new status
     */
    public static void setNoodles_Firm(boolean noodles_Firm) {
        Noodles_Firm = noodles_Firm;
    }

    /**
     * Method Name: isNori()
     * Intro: return the status of Nori, remained or sold out
     * @return a boolean value
     */
    public static boolean isNori() {
        return Nori;
    }

    /**
     * Method Name: setNori()
     * Intro: set the status of Nori, remained or sold out
     * @param nori new status
     */
    public static void setNori(boolean nori) {
        Nori = nori;
    }

    /**
     * Method Name: isBoiled_egg()
     * Intro: return the status of Boiled_egg, remained or sold out
     * @return a boolean value
     */
    public static boolean isBoiled_egg() {
        return Boiled_egg;
    }

    /**
     * Method Name: setBoiled_egg()
     * Intro: set the status of Boiled_egg, remained or sold out
     * @param boiled_egg new status
     */
    public static void setBoiled_egg(boolean boiled_egg) {
        Boiled_egg = boiled_egg;
    }

    /**
     * Method Name: isBamboo_shoots()
     * Intro: return the status of Bamboo_shoots, remained or sold out
     * @return a boolean value
     */
    public static boolean isBamboo_shoots() {
        return Bamboo_shoots;
    }

    /**
     * Method Name: setBamboo_shoots()
     * Intro: set the status of Bamboo_shoots, remained or sold out
     * @param bamboo_shoots new status
     */
    public static void setBamboo_shoots(boolean bamboo_shoots) {
        Bamboo_shoots = bamboo_shoots;
    }

    /**
     * Method Name: isChashu()
     * Intro: return the status of Chashu, remained or sold out
     * @return a boolean value
     */
    public static boolean isChashu() {
        return Chashu;
    }

    /**
     * Method Name: setChashu()
     * Intro: set the status of Chashu, remained or sold out
     * @param chashu new status
     */
    public static void setChashu(boolean chashu) {
        Chashu = chashu;
    }

    /**
     * Method Name: getP_E_Nori()
     * Intro: return the price of P_E_Nori
     * @return a float value
     */
    public static float getP_E_Nori() {
        return P_E_Nori;
    }

    /**
     * Method Name: setP_E_Nori()
     * Intro: set the price of P_E_Nori
     * @param p_E_Nori new price
     */
    public static void setP_E_Nori(float p_E_Nori) {
        P_E_Nori = p_E_Nori;
    }

    /**
     * Method Name: getP_E_Chashu()
     * Intro: return the price of P_E_Chashu
     * @return a float value
     */
    public static float getP_E_Chashu() {
        return P_E_Chashu;
    }

    /**
     * Method Name: setP_E_Chashu()
     * Intro: set the price of P_E_Chashu
     * @param p_E_Chashu new price
     */
    public static void setP_E_Chashu(float p_E_Chashu) {
        P_E_Chashu = p_E_Chashu;
    }

    /**
     * Method Name: getP_E_boiledEgg()
     * Intro: return the price of P_E_boiledEgg
     * @return a float value
     */
    public static float getP_E_boiledEgg() {
        return P_E_boiledEgg;
    }

    /**
     * Method Name: setP_E_boiledEgg()
     * Intro: set the price of P_E_boiledEgg
     * @param p_E_boiledEgg new price
     */
    public static void setP_E_boiledEgg(float p_E_boiledEgg) {
        P_E_boiledEgg = p_E_boiledEgg;
    }

    /**
     * Method Name: getP_Bamboo_Shoots()
     * Intro: return the price of P_Bamboo_Shoots
     * @return a float value
     */
    public static float getP_Bamboo_Shoots() {
        return P_Bamboo_Shoots;
    }

    /**
     * Method Name: setP_Bamboo_Shoots()
     * Intro: set the price of P_Bamboo_Shoots
     * @param p_Bamboo_Shoots new price
     */
    public static void setP_Bamboo_Shoots(float p_Bamboo_Shoots) {
        P_Bamboo_Shoots = p_Bamboo_Shoots;
    }

    /**
     * Method Name: getFixed_price()
     * Intro: return the price of Fixed_price
     * @return a float value
     */
    public static float getFixed_price() {
        return Fixed_price;
    }

    /**
     * Method Name: setFixed_price()
     * Intro: set the price of Fixed_price
     * @param fixed_price new price
     */
    public static void setFixed_price(float fixed_price) {
        Fixed_price = fixed_price;
    }
}
