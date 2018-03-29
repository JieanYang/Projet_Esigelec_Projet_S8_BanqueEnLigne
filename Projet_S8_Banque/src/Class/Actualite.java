package Class;
import java.util.*;

/**
 * 
 */
public class Actualite {

    public int getId_actualite() {
		return id_actualite;
	}

	public void setId_actualite(int id_actualite) {
		this.id_actualite = id_actualite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
     * Default constructor
     */
    public Actualite() {
    }

    /**
     * 
     */
    private int id_actualite;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String text;

}