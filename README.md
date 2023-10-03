# Ktor HTTP and Authentication API
RESTAPI Notes `(CRUD)` and Authentication Using [ktor](https://ktor.io/) `(Kotlin)` and `mySQL Database`.

Runs embedded web server on [localhost:8080](http://127.0.0.1:8080) `(baseurl)`.

### Endpoint CRUD Operations For Notes

- `Get` All Notes.
  
```
{baseurl}/notes
```

- `Get` One Note By ID.
  
```
{baseurl}/notes/{id}
```

- `POST` One Note.
  
```
{baseurl}/notes
```
your json request
```JSON
{
    "note":"write your note"
}
```

- `PUT` Note By ID.
  
```
{baseurl}/notes/{id}
```
your json request
```JSON
{
    "note":"update your note"
}
```

- `DELETE` Note By ID.
  
```
{baseurl}/notes/{id}
```

### Authentication Endpoint

- `POST` Login User.
  
```
{baseurl}/login
```
your json request
```JSON
{
    "userName":"mosamir",
    "password":"1234567"
}
```

- `POST` Register User.
  
```
{baseurl}/register
```
your json request
```JSON
{
    "userName":"mosamir",
    "password":"1234567"
}
```




