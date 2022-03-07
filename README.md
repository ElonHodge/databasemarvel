# Database API 

API was created with java. Use in conjunction will the marvel api to show understanding of 
front end as well as back end development. 

 (https://marveldatabasejava.herokuapp.com)
## Models
```
User = {
	private String userId;

	private String userName;

	private String userEmail;
}

FavoriteCharacters = {

	private Integer charId;

	private String userId;

	private String charName;

	private String charImage;

	private String imageExtenstion;

}
```
## Routes
### User

| Verb   | Path                          | Description           |
|--------|-------------------------------|-----------------------|
| GET    | /api/v1/allusers              | shows all users       |
| GET    | /api/v1/userbyid/{id}         | show user by id       |
| GET    | /api/v1/userbyname/{username} | show user by username |
| GET    | /api/v1/userbyemail/{email}   | show user ny email    |
| POST   | /api/v1/adduser               | add user              |
| Delete | /api/v1/deleteuser            | delete user           |
| Put    | /api/v1/updateuser/{id}       | update user           |

### Favorites Characters

| Verb   | Path                     | Description              |
|--------|--------------------------|--------------------------|
| GET    | api/v1/allfavs           | shows all favorites      |
| GET    | api/v1/favsbyuserid/{id} | show user by user id     |
| GET    | api/v1/favsbyid/{id}     | show user by favorite id |
| POST   | api/v1/addtofavs         | add to favorite          |
| DELETE | api/v1/deletefav/{id}    | delete from favorite     |

