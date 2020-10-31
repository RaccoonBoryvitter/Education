package com.university.LabWork8;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Lessons.FrustumService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 30.10.2020|00:58
 * @Version FrustumService: 1.0
 */

public class FrustumService implements IGeometry, IPacking, IFrustum {

    private ConicalFrustum currentFrustum;

    public FrustumService() { }

    public FrustumService(ConicalFrustum currentFrustum) {
        this.currentFrustum = currentFrustum;
    }

    public ConicalFrustum getCurrentFrustum() {
        return currentFrustum;
    }

    public void setCurrentFrustum(ConicalFrustum currentFrustum) {
        this.currentFrustum = currentFrustum;
    }

    public void clearCurrentFrustum() {
        this.currentFrustum = null;
    }

    @Override
    public double getSlantHeight() {
        double expr = Math.pow(this.currentFrustum.getHeight(), 2) +
                Math.pow(this.currentFrustum.getLowerRadius() - this.currentFrustum.getUpperRadius(), 2);

        return Math.sqrt(expr);
    }

    @Override
    public float getPreCutHeight() {
        double _a = this.currentFrustum.getHeight() * this.currentFrustum.getLowerRadius();
        double _b = this.currentFrustum.getLowerRadius() - this.currentFrustum.getUpperRadius();
        return (float) (_a / _b);
    }

    @Override
    public double getSideArea() {
        return Math.PI * this.getSlantHeight() *
                (this.currentFrustum.getLowerRadius() + this.currentFrustum.getUpperRadius());
    }

    @Override
    public double getArea() {
        double _lowerBaseArea = Math.PI * this.currentFrustum.getLowerRadius() * this.currentFrustum.getLowerRadius();
        double _upperBaseArea = Math.PI * this.currentFrustum.getUpperRadius() * this.currentFrustum.getUpperRadius();
        return getSideArea() + _lowerBaseArea + _upperBaseArea;
    }

    @Override
    public double getVolume() {
        double sum = Math.pow(this.currentFrustum.getLowerRadius(), 2) +
                this.currentFrustum.getLowerRadius() * this.currentFrustum.getUpperRadius() +
                Math.pow(this.currentFrustum.getUpperRadius(), 2);

        return (Math.PI / 3.0) * this.currentFrustum.getHeight() * sum;
    }

    @Override
    public String toJSON() {
        Gson jsonMaker   = new Gson();
        String result    = jsonMaker.toJson(this.currentFrustum);
        return result;
    }

    @Override
    public String toXML() {
        Class conicalfrustum                  = this.currentFrustum.getClass();
        Field[] classFields                   = conicalfrustum.getDeclaredFields();
        ArrayList<Field> fields               = new ArrayList<>(Arrays.asList(classFields));
        ArrayList<StringBuilder> fieldNames   = new ArrayList<>();
        fields.stream().forEach(f -> fieldNames.add(new StringBuilder(f.toString())));

        for (int i = 0; i < classFields.length; i++) {
            classFields[i].setAccessible(true);
        }

        for (int i = 0; i < fieldNames.size(); i++) {
            int index = fieldNames.get(i).indexOf(".");
            while(index != -1) {
                fieldNames.get(i).delete(0, index + 1);
                index = fieldNames.get(i).indexOf(".");
            }
        }

        StringBuilder className   = new StringBuilder(conicalfrustum.toString());
        int index = className.indexOf(".");
        while (index != -1) {
            className.delete(0, index + 1);
            index = className.indexOf(".");
        }

        StringBuilder xmlFields   = new StringBuilder();
        try {
            for (int i = 0; i < fieldNames.size(); i++) {
                Field field = classFields[i];
                Float value = (Float)field.get(this.currentFrustum);
                xmlFields.append("\t<" + fieldNames.get(i) + ">" + value
                        + "</" + fieldNames.get(i) + ">\n");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        StringBuilder xmlClass    = new StringBuilder("<" + className + ">\n"
                + xmlFields + "</" + className + ">");

        String fullXML = new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xmlClass);

        return fullXML;
    }
}