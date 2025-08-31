# Joker AI Agent Pet

ИИ-агент для генерации шуток на заданную тему для аудитории. Используется **Koog** для логики агента и **Spring Boot** для REST API.

---

## 🔧 Требования

- Java 17+
- Gradle
- Docker & Docker Compose

---

## 🚀 Запуск

1. Сборка проекта:
    
    ```bash
    ./gradlew build -x test
    ````

2. Запуск через Docker Compose:

    ```bash
    docker compose up --build -d
    ```
    
API будет доступно по адресу: `http://127.0.0.1:80`

---

## 🔑 Настройки окружения

Для работы ИИ агента создайте файл `.env` в корне проекта со следующей переменной:

```dotenv
# Ключ OpenAI для Koog агента
OPENAI_API_KEY=sk-proj-xxx-xxx
```

## 📡 Взаимодействие с API

### Генерация шутки

**Endpoint:**

```
GET /joke/generate
```

**Параметры:**

| Параметр | Описание        |
|----------|-----------------|
| audience | Аудитория шутки |
| theme    | Тема шутки      |

**Пример запроса:**

```bash
curl "http://127.0.0.1:80/joke/generate?audience=общество гениальных людей, понимающих глубину шутки&theme=любая тема"
```

**Пример ответа:**

```json
{
  "joke": "Here goes a clever joke for the audience..."
}
```

## ⚙️ Структура проекта

```
src/main/kotlin/com/yooshyasha/jokeraiagentpet/
 ├─ JokerAiAgentPetApplication.kt      # main
 ├─ agent/
 │   ├─ common/                        # провайдеры агента
 │   │   └─ IAgentProvider.kt
 │   └─ joker/                          # агент, генерирующий шутки
 │       └─ JokerProvider.kt
 ├─ controller/                         # REST контроллер
 │   └─ JokerController.kt
 ├─ dto/                                # модели данных
 │   ├─ RequestGenerateJoke.kt
 │   └─ ResponseGenerateJoke.kt
 └─ service/
     └─ JokerService.kt
```

---

## 📝 Примечания

* Koog требует интернет для работы.
* Агент умеет самопроверку и улучшение шуток по стратегии узлов.