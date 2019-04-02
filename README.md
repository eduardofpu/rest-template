## Objetido dessa api endenter o rest-template


## Requisitos
```
java 1.8
use o doker para construir um banco
docker-compose up
docker-compose dow

```


## Insira usuarios pois a api possui security
```
USUARIO: ADMIN
username: toyo
password:devdojo


INSERT INTO public.usuario
(id, "admin", "name", "password", username)
VALUES(1, true, 'toyo','$2a$10$Umt8cyNWdtZHZ.U2gYSGA.E6cjw.kMN.Luj3A9VQTtWierkTEQcea','toyo');


INSERT INTO public.usuario(id, "admin", "name", "password", username)
VALUES(3, false, 'oda','$2a$10$Umt8cyNWdtZHZ.U2gYSGA.E6cjw.kMN.Luj3A9VQTtWierkTEQcea','oda');

```


```
classe:

JavaClientDao

```


# Métodos
```

findById
listAll
save
update
delete

```

# Testando os métodos
```
Classe:

JavaSpringClientTest

```

# Para tratamento de chamada de recursos com id que não existem
```
Classe:

Essa classe evita uma Exeception e trata o erro com hasError e o handleError

RestResponseExceptionHandler

```

