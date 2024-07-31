- Project được convert từ BE node
- Mặc định JPA sẽ convert tên camelcase -> underscore
  + vd  createdAt-> created_at
  +   jpa:
          hibernate:
              naming:physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
  + Thêm cái trên là fix đc đấy