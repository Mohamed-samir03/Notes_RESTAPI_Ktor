# Ktor HTTP API and Authentication
RESTAPI Notes `(CRUD)` and Authentication Using [ktor](https://ktor.io/) `(Kotlin)` and `mySQL Database`.


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

```JSON
/* your json request */
{
    "note":"write your note"
}
```

- `PUT` Note By ID.
  
```
{baseurl}/notes/{id}
```

```JSON
/* your json request */
{
    "note":"update your note"
}
```

- `DELETE` Note By ID.
  
```
{baseurl}/notes/{id}
```


