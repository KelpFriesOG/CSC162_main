package notes;

import java.util.Date;

public class GeometricObject {
    private String color = "white";
    private boolean filled = false;
    private Date dateCreated = new Date();

    // #region Constructors

    public GeometricObject() {

    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // #endregion

    // #region Getters and Setters

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // #endregion

    // #region Methods

    public String toString() {
        String reprString = "A geometric object, colored "
                + color + " that is " + (filled ? "filled in." : "not filled in.");
        return reprString;
    }

    // #endregion
}
