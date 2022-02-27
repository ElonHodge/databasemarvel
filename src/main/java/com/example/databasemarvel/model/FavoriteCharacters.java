package com.example.databasemarvel.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "fav_char")
public class FavoriteCharacters {

    @Id
    @Column
    @NotNull
    private Integer charId;


   @JoinColumn(referencedColumnName = "user_id")
    private String userId;

    @Column
   private  String charName;

    @Column
    private String charImage;




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
}
