package entities;

import java.io.Serializable;

/**
 *  Class Name: Ramen.java
 *  Intro: An entity class to store a ramen and its options.
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class Ramen implements Serializable {
    private static final long serialVersionUID = 1L;
    private String soup = "Tonkosu";
    private String noodles="Soft";
    private int onion_level = 0;
    private Boolean nori = false;
    private Boolean chashu = false;
    private Boolean boiled_egg = false;
    private int spiciness = 0;//0:no,1,2,3,4,5(max)
    public int ramenNumber = 1;

    private int extra_nori = 0;
    private int extra_boiled_egg = 0;
    private int Bamboo_shoots = 0;
    private int extra_chashu= 0;

    private static float NoriPrice = 1f;
    private static float BoiledEggPrice = 1f;
    private static float BambooShootPrice = 1f;
    private static float ChashuPrice = 2f;
    private static float fixPrice = 9.9f;

    /**
     * Method Name: Ramen()
     * Intro: It will initialize prices with the modification of ramen restaurant staff.
     */
     public Ramen() {
         fixPrice = Menu.getFixed_price();
         NoriPrice = Menu.getP_E_Nori();
         BoiledEggPrice = Menu.getP_E_boiledEgg();
         BambooShootPrice = Menu.getP_Bamboo_Shoots();
         ChashuPrice = Menu.getP_E_Chashu();
     }

    /**
     * Method Name: getSoup()
     * Intro: return soup type
     * @return String type
     */
    public String getSoup() {
        return soup;
    }

    /**
     * Method Name: getNoodles()
     * Intro: return noodle type
     * @return String type
     */
    public String getNoodles() {
        return noodles;
    }

    /**
     * Method Name: getOnion_level()
     * Intro: return the level of onion
     * @return int type
     */
    public int getOnion_level() {
        return onion_level;
    }

    /**
     * Method Name: getNori()
     * Intro: return a boolean value, select nori or not
     * @return boolean type
     */
    public Boolean getNori() {
        return nori;
    }

    /**
     * Method Name: getChashu()
     * Intro: return a boolean value, select chashu or not
     * @return boolean type
     */
    public Boolean getChashu() {
        return chashu;
    }

    /**
     * Method Name: getBoiled_egg()
     * Intro: return a boolean value, select boiled_egg or not
     * @return boolean type
     */
    public Boolean getBoiled_egg() {
        return boiled_egg;
    }

    /**
     * Method Name: getSpiciness()
     * Intro:  return an int value of the level of spiciness
     * @return int value
     */
    public int getSpiciness() {
        return spiciness;
    }

    /**
     * Method Name: getNum()
     * Intro: return how many ramen in this type has been selected?
     * @return int type
     */
    public int getNum() { return this.ramenNumber; }

    /**
     * Method Name: getExtra_nori()
     * Intro: return the number of extra nori
     * @return int type
     */
    public int getExtra_nori() {
        return extra_nori;
    }

    /**
     * Method Name: getExtra_boiled_egg()
     * Intro: return the number of extra boiled egg
     * @return int type
     */
    public int getExtra_boiled_egg() {
        return extra_boiled_egg;
    }

    /**
     * Method Name: getExtra_chashu()
     * Intro: return the number of extra chashu
     * @return int type
     */
    public int getExtra_chashu() {
        return extra_chashu;
    }

    /**
     * Method Name: getBamboo_shoots()
     * Intro: return the number of bamboo shoots
     * @return int type
     */
    public int getBamboo_shoots() {
        return Bamboo_shoots;
    }

    /**
     * Method Name: setSoup()
     * Intro: set the choice of soup
     * @param soup String type
     */
    public void setSoup(String soup) {
        this.soup = soup;
    }

    /**
     * Method Name: setNoodles()
     * Intro: set the choice of noodles
     * @param noodles String type
     */
    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    /**
     * Method Name: setOnion_level()
     * Intro: set the level of onion
     * @param onion_level int type
     */
    public void setOnion_level(int onion_level) {
        this.onion_level = onion_level;
    }

    /**
     * Method Name: setNori()
     * Intro: has Nori or not
     * @param nori boolean type
     */
    public void setNori(Boolean nori) {
        this.nori = nori;
    }

    /**
     * Method Name: setChashu()
     * Intro: has Chashu or not
     * @param chashu boolean type
     */
    public void setChashu(Boolean chashu) {
        this.chashu = chashu;
    }

    /**
     * Method Name: setBoiled_egg()
     * Intro: has boiled egg or not
     * @param boiled_egg boolean type
     */
    public void setBoiled_egg(Boolean boiled_egg) {
        this.boiled_egg = boiled_egg;
    }

    /**
     * Method Name: setSpiciness()
     * Intro: set the level of spiciness
     * @param spiciness int type
     */
    public void setSpiciness(int spiciness) {
        this.spiciness = spiciness;
    }

    /**
     * Method Name: setNum()
     * Intro: set the number of ramen customer needed
     * @param ramenNumber int type
     */
    public void setNum(int ramenNumber) {
        this.ramenNumber = ramenNumber;
    }

    /**
     * Method Name: setExtra_nori()
     * Intro: set the num of extra nori
     * @param extra_nori int type
     */
    public void setExtra_nori(int extra_nori) {
        this.extra_nori = extra_nori;
    }

    /**
     * Method Name: setExtra_boiled_egg()
     * Intro: set the num of extra boiled egg
     * @param extra_boiled_egg int type
     */
    public void setExtra_boiled_egg(int extra_boiled_egg) {
        this.extra_boiled_egg = extra_boiled_egg;
    }

    /**
     * Method Name: setBamboo_shoots()
     * Intro: set num of bamboo shoots
     * @param bamboo_shoots int type
     */
    public void setBamboo_shoots(int bamboo_shoots) {
        Bamboo_shoots = bamboo_shoots;
    }

    /**
     * Method Name: setExtra_chashu()
     * Intro: set the num of extra chashu
     * @param extra_chashu int type
     */
    public void setExtra_chashu(int extra_chashu) {
        this.extra_chashu = extra_chashu;
    }

    /**
     * Method Name: getNoriAmount()
     * Intro: return the amount of nori
     * @return float type
     */
    public float getNoriAmount() {
        return NoriPrice * this.extra_nori;
    }

    /**
     * Method Name: getBoiledEggAmount()
     * Intro: return the amount of egg
     * @return float type
     */
    public float getBoiledEggAmount() {
        return BoiledEggPrice * this.extra_boiled_egg;
    }

    /**
     * Method Name: getChashuAmount()
     * Intro: return the amount of chashu
     * @return float type
     */
    public float getChashuAmount() {
        return ChashuPrice * this.extra_chashu;
    }

    /**
     * Method Name: getBambooShootAmount()
     * Intro: return the amount of bamboo shoots
     * @return float type
     */
    public float getBambooShootAmount() {
        return BambooShootPrice * this.Bamboo_shoots;
    }

    /**
     * Method Name: calcRamenAmount()
     * Intro: calculate the ramen amount
     * @return float type, ramen amount
     */
    public float calcRamenAmount() {
        float RamenAmount = fixPrice;
        RamenAmount += this.getNoriAmount();
        RamenAmount += this.getBoiledEggAmount();
        RamenAmount += this.getBambooShootAmount();
        RamenAmount += this.getChashuAmount();
        return RamenAmount;
    }
}
