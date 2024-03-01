# Simple CRUD API
Ini merupakan sebuah API sederhana yang bertujuan untuk test.

## Cara menjalankan 
1. Buat sebuah database base/schema pada MySQL bernama waizly, yang saya gunakan adalah MySQL 8.0
2. Lalu jalankan aplikasi menggunkan `mvn spring-boot:run`. Setelah aplikasi dijalankan aplikasi akan membuat table  beserta data user.
3. Pada API ini terdapat sebuat API dokumentasi menggunkana swagger yang dapat di temukan pada path `<BASE_URL>:<PORT>/docs/indet.html`. Dalam contoh kasus pada lokal saya, saya dapat mengakses halam tersebut pada [http://localhost:8080/docs/index.html](http://localhost:8080/docs/index.html). 
4. Untuk authentikasi yang digunakan saya menggunakan basic auth dengan username `admin` dan password `admin`.

## Link terkait
1. API Documentation - [http://localhost:8080/docs/index.html](http://localhost:8080/docs/index.html)