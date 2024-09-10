# SocialMaker

SocialMaker, kullanıcıların gönderi oluşturabileceği, diğer kullanıcılarla etkileşime geçebileceği ve kendi profillerini yönetebileceği bir sosyal medya uygulamasıdır.

## Proje Özeti

SocialMaker, kullanıcıların sosyal medya ortamında etkileşimde bulunmalarını sağlar. Kullanıcılar profil oluşturabilir, gönderiler paylaşabilir, diğer kullanıcılarla etkileşim kurabilir ve daha fazlasını yapabilir. Bu proje, modern web teknolojilerini kullanarak esnek ve ölçeklenebilir bir yapı sunar.

## Özellikler

- **Kullanıcı Kaydı ve Girişi**: Kullanıcılar sisteme kayıt olabilir ve giriş yapabilir.
- **Profil Yönetimi**: Kullanıcılar profil bilgilerini güncelleyebilir, profil fotoğraflarını yükleyebilir.
- **Gönderi Paylaşımı**: Kullanıcılar gönderi oluşturabilir, görüntüleyebilir ve silebilir.
- **Gönderilere Yorum Yapma**: Kullanıcılar gönderilere yorum yapabilir.
- **Gönderileri Beğenme**: Kullanıcılar gönderileri beğenebilir.
- **Bildirimler**: Kullanıcılar kendilerine yapılan etkileşimler hakkında bildirim alabilir.
- **Takip Sistemi**: Kullanıcılar birbirlerini takip edebilir ve takipçilerini görebilir.

## Kurulum

### Gereksinimler

- Java 17+
- Maven
- MySQL veya H2 veritabanı
- Docker (opsiyonel, veritabanını çalıştırmak için)

### Adım 1: Depoyu Klonlayın

```bash
git clone https://github.com/kullanici/socialmaker.git
cd socialmaker
```

### Adım 2: Veritabanı Kurulumu

- **MySQL Kullanıyorsanız:** `application.properties` dosyasında MySQL yapılandırmanızı yapın.

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/socialmaker_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```


- **H2 Veritabanı Kullanıyorsanız:** H2 veritabanı ayarlarını kullanarak projenizi başlatabilirsiniz.

```bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
```


### Adım 3: Maven Bağımlılıklarını Yükleyin

```bash
mvn clean install
```


### Adım 4: Projeyi Başlatın

```bash
mvn spring-boot:run
```

Proje başarıyla başlatıldığında, API `http://localhost:8080` adresinde çalışacaktır.


## Kullanım

### API Endpoints

- **Kullanıcı Kaydı ve Girişi`**

  - `POST /api/auth/register`: Kullanıcı kaydı
  - `POST /api/auth/login`: Kullanıcı girişi

- **Profil Yönetimi**

  - `GET /api/users/{userId}`: Kullanıcı profil bilgilerini getirir
  - `PUT /api/users/{userId}/update-profile`: Kullanıcı profil bilgilerini günceller
  - `POST /api/users/{userId}/upload-profile-picture`: Profil fotoğrafı yükleme

- **Gönderiler**

 - `POST /api/posts`: Yeni gönderi oluşturur
 - `GET /api/posts/user/{userId}`: Belirtilen kullanıcıya ait gönderileri getirir
 - `DELETE /api/posts/{postId}`: Gönderiyi siler

- **Yorumlar**

 - `POST /api/posts/{postId}/comments`: Gönderiye yorum yapar
 - `GET /api/posts/{postId}/comments`: Gönderinin yorumlarını getirir

- **Beğeniler**

 - `POST /api/posts/{postId}/like`: Gönderiyi beğenir
 - `POST /api/posts/{postId}/unlike`: Gönderiyi beğenmekten vazgeçer

- **Takip**

 - `POST /api/users/{userId}/follow/{followedUserId}`: Kullanıcıyı takip eder
 - `DELETE /api/users/{userId}/unfollow/{followedUserId}`: Takipten çıkar

## Örnek API Kullanımı

```bash
curl -X POST http://localhost:8080/api/auth/register \
-H 'Content-Type: application/json' \
-d '{"username": "johndoe", "email": "johndoe@example.com", "password": "123456"}'
```

## Katkıda Bulunma
Katkıda bulunmak için lütfen bir fork yapın ve ardından bir pull request gönderin. Değişikliklerinizi detaylıca açıklamayı unutmayın.

## Lisans
Bu proje MIT Lisansı altında lisanslanmıştır. Daha fazla bilgi için `LICENSE` dosyasına bakın.

## İletişim
Herhangi bir sorunuz veya geri bildiriminiz için [mail](yasingunesctf@gmail.com) adresinden bana ulaşabilirsiniz.

