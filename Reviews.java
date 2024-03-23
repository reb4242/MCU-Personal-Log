/**
 * This class creates a blueprint to store reviews.
 *
 * @author (Rebecca)
 * @version (May.30/23)
 */
public class Reviews{
    String Title;
    Float Rating;
    String Comments;
    
    //constructors
    public Reviews(){
        this.Title = "UNKNOWN";
        this.Rating = 0f;
        this.Comments = "Comments are empty, share your opinions!";
    }
    public Reviews(String T, Float R, String C){
        this.Title = T;
        this.Rating = R;
        this.Comments = C;
    }
    public String toString(){
        //declare variable
        String myReviews = "";
        
        //format
        myReviews += "Title: " + this.Title;
        myReviews += "\nRating: " + this.Rating + "/5";
        myReviews += "\nComments: " + this.Comments;
        
        return myReviews;
    }
    public boolean equals(Reviews that){
        return (this.Title == that.Title);
    }
}
