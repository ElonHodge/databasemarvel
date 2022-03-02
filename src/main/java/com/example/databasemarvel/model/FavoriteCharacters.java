package com.example.databasemarvel.model;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;


@Entity
@Table(name = "fav_char")
public class FavoriteCharacters {

    @Id
    @Column
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer favId;


    @Column
    @NotNull
    private Integer charId;


   @JoinColumn(referencedColumnName = "user_id")
    private String userId;

    @Column
   private  String charName;

    @Column
    private String charImage;

    @Column
    private String imageExtenstion;

    public String getImageExtenstion() {
        return imageExtenstion;
    }

    public void setImageExtenstion(String imageExtenstion) {
        this.imageExtenstion = imageExtenstion;
    }

    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharImage() {
        return charImage;
    }

    public void setCharImage(String charImage) {
        this.charImage = charImage;
    }

    public Integer getFavId() {
        return favId;
    }

    public void setFavId(Integer favId) {
        this.favId = favId;
    }
}
