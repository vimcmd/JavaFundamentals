package com.newcircle.bookshelf.javaFundamentals.chapter10_javaLangPackage;

import java.util.List;
import java.util.LinkedList;

/**
 * <ul>
 *  <li>
 *      The {@code java.lang} package includes a class for each Java primitive type:
 *      <p>
 *          {@code Boolean, Byte, Short, Character, Integer, Float, Long, Double, Void}
 *      </p>
 *      <p>
 *          for example: {@link #wrappersExample()}
 *      </p>
 *  </li>
 *  <li>
 *      Used for:
 *      <ul>
 *          <li>
 *              Storing primitives in Object based collections
 *          </li>
 *          <li>
 *              Parsing/Decoding primitives form {@code String}
 *              <p>
 *                  for example: {@link #parseFromStringExample()}
 *              </p>
 *          </li>
 *          <li>Converting/encoding primitives to Strings</li>
 *          <li>Range definitions (e.g. {@code Byte.MAX_VALUE})</li>
 *          <li>Toolbox of convenience methods: many of them {@code static}
 *              (e.g. {@code isLetter()}, {@code toLowerCase()}, {@code reverseBytes()}, {@code isInfinite()}, etc.)
 *          </li>
 *      </ul>
 *  </li>
 * </ul>
 * @see Boolean
 * @see Byte
 * @see Short
 * @see Character
 * @see Integer
 * @see Float
 * @see Long
 * @see Double
 * @see Void
 */
public class part01_PrimitiveWrappers {

    public static void main(String[] args) {
        wrappersInGenericCollectionsExample();
    }

    public static void wrappersExample() {
        System.out.println(Integer.class);
        System.out.println("bytes: " + Integer.BYTES);
        System.out.println("type: " + Integer.TYPE);
        System.out.println("range: " + Integer.MIN_VALUE + ".." + Integer.MAX_VALUE);
        System.out.println("and many other methods for comparing/converting/etc.");
    }

    public static void parseFromStringExample() {
        String stringInteger = "123456";
        int primitiveInteger = 123456;
        Integer wrapperInteger = Integer.parseInt(stringInteger);
        System.out.println(
                stringInteger +
                " (parsed from " +
                stringInteger.getClass() +
                ") equal to primitive " +
                primitiveInteger +
                ": " +
                wrapperInteger.equals(primitiveInteger)
        );
    }

    /**
     * Any object in Java can be assigned to type {@code java.lang.Object}. This means that generic collections can be
     * implemented that deal with {@code java.lang.Object}'s, and not care about actual data types. Unfortunately, this
     * does not work for primitives, because they are not Objects. But with their wrappers, primitives can easily move
     * to/from Objects.
     * <p>
     *     Since Java 1.5, Java supports auto-boxing/auto-unboxing - implicit wrapping/unwrapping
     *     of primitives as needed.
     * </p>
     */
    public static void wrappersInGenericCollectionsExample() {
        int i = 5;
        List<Object> list = new LinkedList<>();
        // implicit call of auto-boxing equals to
        // list.add(new Integer(i));
        list.add(i);
        Integer intObj = (Integer) list.get(0);
        // implicit call of auto-unboxing equals to
        // j = intObj.intValue();
        // also can be done as
        // int j = (Integer) list.get(0);
        int j = intObj;
        System.out.println(i == j); // prints true

    }


}
