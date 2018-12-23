/**
 * this class manage the opinions in each opinion bar
 */
public class Opinion {
    private float positiveCount;//no of positive reactions or opinions
    private float negativeCount;//no of negative reactions or opinions
    private float total;//the total opinions

    //constructor
    Opinion() { }

    //to get the percentage of positive reactions to the note
    Float getPositivePercent() {
        return (positiveCount/total)*100;
    }

    //to get the percentage of the negative reactions to the note
    float getNegativePercent() {
        return (negativeCount/total)*100;
    }

    /**
     * to add a single positive reaction
     * and update total
     * @return the updated positive reaction variable
     */
    float addPositive() {
        positiveCount = positiveCount + 1;
        total = positiveCount + negativeCount;

        return positiveCount;
    }

    /**
     * to add a single negative reaction
     * and update total
     * @return the updated negative reaction variable
     */
    float addNegativeOpinion() {
        negativeCount = negativeCount + 1;
        total = negativeCount + positiveCount;

        return negativeCount;
    }
}
