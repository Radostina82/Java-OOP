package Encapsulation.PizzaCalories4;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }
    private void setFlourType(String flourType){
        if (flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
    private void setBakingTechnique(String bakingTechnique){
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")){
            this.bakingTechnique = bakingTechnique;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
    private void setWeight(double weight){
        if (weight>=1 && weight<=200){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    public double calculateCalories(){
        double modFlour = getModFlour(this.flourType);
        double modTech = getModTechnique(this.bakingTechnique);
        //(2 * 100) * 1.5 * 1.1 = 330.00 total calories.
        return (2 * this.weight) * modFlour * modTech;
    }

    private double getModTechnique(String bakingTechnique) {

        if (this.bakingTechnique.equals("Crispy")){
            return  0.9;
        }else if (this.bakingTechnique.equals("Chewy")){
            return 1.1;
        }else if (bakingTechnique.equals("Homemade")){
            return 1.0;
        }
        return 0;
    }

    private double getModFlour(String flourType) {

        if (this.flourType.equals("White")){
            return  1.5;
        }else if (this.flourType.equals("Wholegrain")){
            return 1.0;
        }
        return 0;
    }
}
