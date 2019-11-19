package com.example.bmi.model;


public class Body {
    private int height;
    private int weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float calculateBmi(){
        //bmi = kg /m^2

        float height = this.height / 100f;
        // บรรทัก 42 เติม f หลัง100 เพื่อให้ 100เป็น float
        // ถ้าใส่ 100.00 จะเป็น type double
        float bmi = this.weight / (height * height);
        return bmi;

    }
    public String getResultText(){
        float bmi =calculateBmi();
        String resultText = null;
        if (bmi < 18.5)
            resultText = "Underweight";
        else if(bmi > 18.5 && bmi <= 22.9)
            resultText = "Normal";
        else if(bmi >= 23 && bmi <= 24.9)
            resultText = "Overweight";
        else if(bmi >= 25 && bmi <= 29.9)
            resultText = "Obese1";
        else
            resultText = "Obese2";
        return resultText;
    }
}
