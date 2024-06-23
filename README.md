# Mini Banking Application

Bu proje, basit bir bankacılık uygulaması örneğidir. Spring Boot ile geliştirilmiş bir backend ve JWT tabanlı kimlik doğrulama sistemi içerir.

## İçindekiler

- [Kurulum](#kurulum)
- [Çalıştırma](#çalıştırma)
- [API Endpointleri](#api-endpointleri)
- [Postman Collection](#postman-collection)
- [Yazarlar](#yazarlar)

## Kurulum

Projeyi çalıştırmak için aşağıdaki adımları takip edebilirsiniz.

### Gereksinimler

- Java 11 veya üstü
- Maven 3.6.0 veya üstü

### Adımlar

1. **Projeyi Klonlayın:**

    ```bash
    git clone https://github.com/vipspeciall/banking-app.git
    cd banking-app
    ```

2. **Bağımlılıkları Yükleyin:**

   Maven kullanarak tüm bağımlılıkları yükleyin:

    ```bash
    mvn clean install
    ```

3. **Veritabanı Ayarları:**

   `application.properties` dosyasında H2 veritabanı yapılandırması varsayılan olarak ayarlanmıştır:

    ```properties
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.h2.console.enabled=true

    # JWT Secret Key
    jwt.secret=your_secret_key
    ```

## Çalıştırma

Uygulamayı çalıştırmak için aşağıdaki komutu kullanabilirsiniz:

```bash
mvn spring-boot:run
