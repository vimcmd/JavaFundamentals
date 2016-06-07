package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch08_exceptions.sub06_ownExceptions;


/* # 5 # Method generates own exception */

public class Coin {
    private double diameter;
    private double weight;

    public static void main(String[] args) {
        Coin coin = new Coin();

        try {
            coin.setDiameter(-2.0);
        } catch (CoinLogicException e) {
            System.err.println(e);
        }

        try {
            coin.doAction("two");
        } catch (CoinTechnicalException e) {
            System.err.println(e);
        }
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) throws CoinLogicException {
        if (diameter <= 0) {
            throw new CoinLogicException("diameter is negative");
        }
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void doAction(String value) throws CoinTechnicalException {
        /* # 9 # Generate and rethrow own exception */
        try {
            double d = Double.parseDouble(value);
            this.setDiameter(d);
        } catch (NumberFormatException e) {
            throw new CoinTechnicalException("incorrect symbol in string", e);
        } catch (CoinLogicException e) {
            //System.err.println(e);
            e.getCause();
        }
    }
}
