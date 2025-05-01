# 🚀 Concurrent Payment

**선착순 이벤트 결제 시스템**  
빠르게 결제하는 사용자만 상품을 구매할 수 있는 이벤트 결제 API입니다.  
**Kafka, Redis, MySQL, Spring Boot** 기반으로 설계되었습니다.

---

## 📌 주요 기능

- 결제 생성 API (`PENDING` 상태 저장)
- Redis로 중복 결제 요청 방지
- Kafka로 결제 승인 메시지 전송
- Kafka Consumer에서 선착순 100명만 승인 (`CONFIRMED`)
- 유저 결제 내역 조회 API (상태 필터링 가능)

---

## ⚙️ 사용 기술 스택

| 기술 | 설명 |
|------|------|
| Spring Boot | API 서버, Kafka Producer & Consumer |
| MySQL | 결제 정보 저장 (JPA) |
| Redis | 중복 요청 방지 (TTL Lock) |
| Kafka | 비동기 결제 승인 처리 |
| Docker Compose | 전체 환경 컨테이너 구성 예정 |

---

## 🏗️ 폴더 구조

```bash
src
├── config              # Kafka, Redis 설정
├── controller          # API 요청 처리
├── dto                 # 요청/응답 객체
├── entity              # JPA Entity
├── kafka               # Producer / Consumer
├── repository          # JPA 인터페이스
├── service             # 비즈니스 로직
└── utils               # 유틸 클래스
